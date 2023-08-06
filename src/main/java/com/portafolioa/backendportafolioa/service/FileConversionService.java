package com.portafolioa.backendportafolioa.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.portafolioa.backendportafolioa.constant.ViewConstant;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class FileConversionService {
	
	@GetMapping("/")
	public String convertForm(Model model) {
	    model.addAttribute("pdfFile", null);
	    return ViewConstant.DOCTOPDFCONVERTER;
	}
	
	   public byte[] convertFile(byte[] fileBytes) throws IOException, DocumentException {
	      // Se crea un objeto InputStream a partir del arreglo de bytes recibido
	      InputStream input = new ByteArrayInputStream(fileBytes);

	      // Se crea un objeto de tipo XWPFDocument a partir del archivo .doc o .docx
	      XWPFDocument document = new XWPFDocument(input);

	      // Se crea un objeto ByteArrayOutputStream para escribir el archivo PDF resultante
	      ByteArrayOutputStream out = new ByteArrayOutputStream();

	      // Se crea un objeto Document de iTextPDF
	      Document pdfDocument = new Document();

	      // Se crea un objeto PdfWriter para escribir el archivo PDF resultante
	      PdfWriter writer = PdfWriter.getInstance(pdfDocument, out);

	      // Se abre el documento PDF y se configura el autor del documento
	      pdfDocument.open();
	      pdfDocument.addAuthor("FileConversionService");

	      // Se recorre cada párrafo del documento original y se escribe en el nuevo documento PDF
	      List<XWPFParagraph> paragraphs = document.getParagraphs();
	      for (XWPFParagraph paragraph : paragraphs) {
	    	  
	         // Se crea un objeto Paragraph de iTextPDF y se configura su estilo
	         Paragraph pdfParagraph = new Paragraph();
	         pdfParagraph.setFont(new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL));

	         // Se recorre cada elemento del párrafo original y se escribe en el nuevo documento PDF
	         List<XWPFRun> runs = paragraph.getRuns();
	         for (XWPFRun run : runs) {
	            String text = run.getText(0);
	            if (text != null) {
	            	
	               // Se crea un objeto Chunk de iTextPDF y se escribe en el nuevo documento PDF
	               Chunk chunk = new Chunk(text);
	               pdfParagraph.add(chunk);
	            }
	         }

	         // Se agrega el párrafo al documento PDF
	         pdfDocument.add(pdfParagraph);
	      }

	   // Se cierra el documento original
	      document.close();

	      // Se cierra el documento PDF y se devuelve como un arreglo de bytes
	      pdfDocument.close();
	      writer.close();
	      out.close();
	      return out.toByteArray();
	   }
}

