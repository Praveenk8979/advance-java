package com.meda.service;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.meda.entity.FormHandle;
import com.meda.repository.FormHandleReposotiry;

import net.sourceforge.tess4j.Tesseract;

import org.apache.pdfbox.Loader;

@Component
public class BlankPageServiceImpl implements BlankPageService {
	
	@Value("${ocr.path}")
	private String rootPath;
	
	@Autowired
	private FormHandleReposotiry formHandleReposotiry;
	
	private static final int DPI = 300;
	
//	public String uploadAndProcessPdf(MultipartFile file) throws NoSuchAlgorithmException {
//		if(file.isEmpty()) {
//			return "Please provide a valid file";
//		}
//		
//		String uploadDir="";
//		
//		try {
//			String originalFileName=file.getOriginalFilename();
//			String uniqueFileName=UUID.randomUUID().toString()+"_" +originalFileName;
//			File destinationFile=new File(uploadDir+File.separator+uniqueFileName);
//			
//			if(isFileDuplicate(file)) {
//				return "Deplicate file detected";
//			}
//			
//			file.transferTo(destinationFile);
//			
//			FormHandle formHandle=new FormHandle();
//			formHandle.setFileId(uniqueFileName);
//			formHandle.setLocation(destinationFile.getAbsolutePath());
//			formHandleReposotiry.save(formHandle);
//			
//			//process the PDF
//			return uploadAndProcessPdf((MultipartFile) destinationFile.getAbsoluteFile());
//		}catch (IOException e) {
//			e.printStackTrace();
//			return "File upload failed: "+e.getMessage();
//		}
//	}
//
//		private boolean isFileDuplicate(MultipartFile file) throws IOException , NoSuchAlgorithmException {
//			String fileChecksum= getFileChecksum(file.getInputStream());
//			
//			List<FormHandle> existingFiles = formHandleReposotiry.findAll();
//	        for (FormHandle handle : existingFiles) {
//	            File existingFile = new File(handle.getLocation());
//	            if (existingFile.exists() && getFileChecksum(new FileInputStream(existingFile)).equals(fileChecksum)) {
//	                return true; // Duplicate found
//	            }
//			}
//			return false;
//		}
//
//	private String getFileChecksum(InputStream inputStream)throws IOException , NoSuchAlgorithmException {
//		MessageDigest digest = MessageDigest.getInstance("MD5");
//	    try (BufferedInputStream bis = new BufferedInputStream(inputStream)) {
//	        byte[] buffer = new byte[1024];
//	        int bytesRead;
//	        while ((bytesRead = bis.read(buffer)) != -1) {
//	            digest.update(buffer, 0, bytesRead);
//	        }
//	    }
//	    byte[] hashBytes = digest.digest();
//	    StringBuilder sb = new StringBuilder();
//	    for (byte b : hashBytes) {
//	        sb.append(String.format("%02x", b));
//	    }
//	    return sb.toString();
//	}
	

	@Override
	public Map<String, String> startBlankPage(String pdfSource) {
		return doFinder(pdfSource);
	}

	private Map<String, String> doFinder(String pdfSource) {
		Map<String, String> data=new HashMap<>();
		
		data.put("blankPageList", "0");
		data.put("totalBlankPage", "0");
		data.put("blankPageStamp", "0");
		
		data.put("totalPage", "0");
		
		data.put("totalA0Pages", "0");
		data.put("totalA2Pages", "0");
		data.put("totalA4Pages", "0");

		List<Integer> pageNoList = new ArrayList<>();
		List<String> stampList = new ArrayList<>();

		int totalPages = 0;
		int totalA0Page = 0;
		int totalA2Page = 0;
		int totalA4Page = 0;
		try (PDDocument document = Loader.loadPDF(new File(pdfSource))) {
			totalPages = document.getNumberOfPages();
			PDFRenderer pdfRenderer = new PDFRenderer(document);

			for (int pageNumber = 0; pageNumber < totalPages; pageNumber++) {

				PDPage page = document.getPage(pageNumber);

				float width = page.getMediaBox().getWidth();
				float height = page.getMediaBox().getHeight();
				String pageSize = calculatePageSize(width, height);

				if (pageSize.equalsIgnoreCase("A0"))
					totalA0Page++;
				else if (pageSize.equalsIgnoreCase("A2"))
					totalA2Page++;
				else if (pageSize.equalsIgnoreCase("A4"))
					totalA4Page++;

				BufferedImage pageImage = getPageWithDPI(pdfRenderer, pageNumber, DPI);

				boolean isBlank = isBlankPage(pageImage);
				if (isBlank) {
					pageNoList.add(pageNumber + 1); // find stamp
					String stampTxt = findStampTxt(pageImage);
					stampList.add(stampTxt);
				}
			}

			// set data
			data.put("blankPageList", pageNoList.toString());
			data.put("totalBlankPage", pageNoList.size() + "");
			data.put("blankPageStamp", stampList.toString());
			data.put("totalPage", totalPages + "");

			data.put("totalA0Pages", totalA0Page+"");
			data.put("totalA2Pages", totalA2Page+"");
			data.put("totalA4Pages", totalA4Page+"");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;

	}

	private BufferedImage getPageWithDPI(PDFRenderer pdfRenderer, int pageNo, int dpi) {
		if (dpi <= 0)
			return null;
		try {
			return pdfRenderer.renderImageWithDPI(pageNo, DPI, ImageType.RGB);
		} catch (OutOfMemoryError | IOException e) {
			return getPageWithDPI(pdfRenderer, pageNo, dpi - 50);
		}
	}

	
	
	private boolean isBlankPage(BufferedImage image) {

		if (image == null)
			return false;

		Tesseract tesseract = new Tesseract();
		tesseract.setTessVariable("user_defined_dpi", DPI + "");
		tesseract.setDatapath(rootPath + "/tessdata-main");
		
		
		try {
			String doOCR = tesseract.doOCR(image).trim();
			
			if (doOCR.replaceAll("[`~!@#$%^&*()_+[\\\\]\\\\\\\\;\\',./{}|:\\\"<>?]", "").isEmpty()
					|| doOCR.replaceAll("[`~!@#$%^&*()_+[\\\\]\\\\\\\\;\\',./{}|:\\\"<>?]", "").isEmpty()
					|| doOCR.length() < 15) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}

		return false;
	}

	private String findStampTxt(BufferedImage image) {
		int footerHeight = 450;

		// find in footer
		BufferedImage subimage = image.getSubimage(0, image.getHeight() - footerHeight, image.getWidth(),
				footerHeight - 50);

		String txtFromImage = getTxtFromImage(subimage);
		if (txtFromImage.equalsIgnoreCase("NA")) {
			// find in header
			subimage = image.getSubimage(0, 0, image.getWidth(), footerHeight);
			return getTxtFromImage(subimage);
		}
		return txtFromImage;
	}

	private String getTxtFromImage(BufferedImage image) {

		// get only left and right corner
		int imageWidth = 350;
		BufferedImage firstImage = image.getSubimage(0, 0, imageWidth, image.getHeight());

		Tesseract tesseract = new Tesseract();
		tesseract.setTessVariable("user_defined_dpi", DPI + "");
		tesseract.setDatapath(rootPath + "/tessdata-main");
		try {
			String doOCR = tesseract.doOCR(firstImage).trim();
			doOCR = doOCR.replaceAll("\\D", "");
			if (doOCR == null || doOCR.equals("")) {
				// check second image
				BufferedImage secondImage = image.getSubimage(image.getWidth() - imageWidth, 0, imageWidth,
						image.getHeight());

				doOCR = tesseract.doOCR(secondImage).trim();
				doOCR = doOCR.replaceAll("\\D", "");
			}
			return String.valueOf(Integer.parseInt(doOCR));

		} catch (Exception e) {
			e.printStackTrace();
			return "NA";
		}
	}

	private String calculatePageSize(float width, float height) {
		if (width > 841 && height > 1189) {
			return "A0";
		} else if (width > 594 && height > 841) {
			return "A1";
		} else if (width > 420 && height > 594) {
			return "A2";
		} else if (width > 297 && height > 420) {
			return "A3";
		} else if (width > 210 && height > 297) {
			return "A4";
		} else {
			return "Unknown or custom size";
		}
	}


}
