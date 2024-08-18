package com.meda.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("keys")
@Setter
@Getter
public class Keys {
	
//	@Value("#{'${UploadCsvHeader}'.split(',')}")
//	private String[] uploadCsvHeader;

	@Value("${uploadDist}")
	private String uploadDist;

	public String createPath(String path) {
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		return path;
	}

}
