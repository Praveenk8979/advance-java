package com.meda.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.meda.entity.FileUpload;
import com.meda.repository.FileUploadRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploadService {

    @Autowired
    private FileUploadRepository caseRecordRepository;

//    public void save(MultipartFile file) {
//        try (BufferedReader fileReader = new BufferedReader(
//                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
//             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
//
//            List<FileUpload> caseRecords = new ArrayList<>();
//
//            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//            for (CSVRecord csvRecord : csvRecords) {
//            	FileUpload caseRecord = new FileUpload();
//                caseRecord.setSno(csvRecord.get("Sno"));
//                caseRecord.setFileId(csvRecord.get("FileId"));
//                caseRecord.setVolumeNo(csvRecord.get("VolumeNo"));
//                caseRecord.setBookNo(csvRecord.get("BookNo"));
//                caseRecord.setPageFrom(csvRecord.get("PageFrom"));
//                caseRecord.setPageTo(csvRecord.get("PageTo"));
//                caseRecord.setDateOfRegistration(csvRecord.get("DateOfRegistration"));
//                caseRecord.setDocumentType(csvRecord.get("DocumentType"));
//                caseRecord.setRegistrationDistrict(csvRecord.get("RegistrationDistrict"));
//                caseRecord.setDepartment(csvRecord.get("Department"));
//                caseRecords.add(caseRecord);
//            }
//
//            caseRecordRepository.saveAll(caseRecords);
//
//        } catch (Exception e) {
//            throw new RuntimeException("Error while processing CSV file: " + e.getMessage());
//        }
//    }
}
