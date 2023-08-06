package com.portafolioa.backendportafolioa.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.DocumentException;
import com.portafolioa.backendportafolioa.service.FileConversionService;

@Controller
public class FileConversionController {
	
	@Autowired
	   private FileConversionService fileConversionService;  

	   @PostMapping("/convert")
	   public ResponseEntity<byte[]> convertFile(@RequestParam("file") MultipartFile file) throws IOException, DocumentException {
		   
	      // Se llama al servicio de conversión de archivo para convertir el archivo a PDF
	      byte[] pdfBytes = fileConversionService.convertFile(file.getBytes());

	      // Se configura la respuesta HTTP para descargar el archivo PDF
	      HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.APPLICATION_PDF);
	      headers.setContentDispositionFormData("attachment", "convertedFile.pdf");

	      return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	   }

}
