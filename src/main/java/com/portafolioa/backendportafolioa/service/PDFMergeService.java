package com.portafolioa.backendportafolioa.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;

@Service
public class PDFMergeService {
    
    public byte[] mergePDFs(List<MultipartFile> files) throws IOException, DocumentException {
        ByteArrayOutputStream mergedPDFOutputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfCopy copy = new PdfCopy(document, mergedPDFOutputStream);
        document.open();
        for (MultipartFile file : files) {
            InputStream inputStream = file.getInputStream();
            PdfReader reader = new PdfReader(inputStream);
            copy.addDocument(reader);
            inputStream.close();
        }
        document.close();
        return mergedPDFOutputStream.toByteArray();
    }
    
}

