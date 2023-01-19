package com.Shop.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

// 파일의 업로드/삭제를 담당하는 서비스 클래스
@Service
// 로그를 남기기 위한 어노테이션
@Log
public class FileService {

	public String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws Exception {
//		중복되지 않는 랜덤한 파일이름을 생성하기 위해 UUID 를 사용한다.
		UUID uuid = UUID.randomUUID();
//		확장자명을 분리.
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));  
		String savedFileName = uuid.toString() + extension;
		String fileUploadFullUrl = uploadPath + "/" + savedFileName;
		
//		파일 byte 를 내보내느 stream. 생성자의 매개변수로 파일이 저장될 위치와 파일이름을 같이 넘긴다.
		FileOutputStream fos = new FileOutputStream(fileUploadFullUrl); 
//		출력 스트림에 받아온 파일의 데이터를 출력해준다.
//		위에서 지정한 파일경로와 이름을 가진 공간에 데이터를 채워넣는 느낌.
		fos.write(fileData);
		fos.close();
		
		return savedFileName;
	}
	
	public void deleteFile(String filePath) throws Exception {
//		넘겨받은 경로를 이용해서 파일 객체를 생성한다.
		File deleteFile = new File(filePath);
		if(deleteFile.exists()) {
			deleteFile.delete();
			log.info("File has Deleted");
		} else {
			log.info("File does not Exist");
		}
	}
}
