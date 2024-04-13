package com.example.springedu.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@Hidden
public class UploadController4 {
	@RequestMapping(value="/canvasupload",
			 produces="text/plain; charset=utf-8")	
	public String saveFile(MultipartFile mfile) {	    
	     String fileName =  mfile.getOriginalFilename();	  
	     byte[] content = null;
	     String result="OK";
		 String path = "/uploadtest";
		 File isDir = new File(path);
		 if (!isDir.isDirectory()) {
			isDir.mkdirs();
		 }
	     try {
	    	 content =  mfile.getBytes();
	    	 File f = new File("/uploadtest/"+fileName);
	   		 FileOutputStream fos = new FileOutputStream(f);
	   		 fos.write(content);
	   		 fos.close();	   		 
	     } catch (IOException e) {
	    	 e.printStackTrace();
	    	 result="FAIL";
	     }	    
	    return result;
	}
	@RequestMapping(value="/canvasdownload",
			 produces="text/plain; charset=utf-8")	
	public String downloadFile() {	    
		String path = "/uploadtest/";
		char[] buffer =  null;		
		try {
			FileReader reader = new FileReader(path+"test.png");
			buffer = new 
					char[(int)(new File(path+"test.png").length())];
			reader.read(buffer);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	    return new String(buffer);
	}
}
