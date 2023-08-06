package com.portafolioa.backendportafolioa.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.itextpdf.text.DocumentException;
import com.portafolioa.backendportafolioa.service.PDFMergeService;

@Controller
public class PDFMergeController {

    @Autowired
    private PDFMergeService pdfMergeService;

    @RequestMapping("/")
    public String home(Model model) {
        return "PDF merger";
    }

    @PostMapping("/merge")
    public ResponseEntity<byte[]> mergePDFs(@RequestParam("pdfs") List<MultipartFile> files) throws IOException, DocumentException {
        byte[] mergedPDF = pdfMergeService.mergePDFs(files);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "merged.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(mergedPDF, headers, HttpStatus.OK);
        return response;
    }
}

