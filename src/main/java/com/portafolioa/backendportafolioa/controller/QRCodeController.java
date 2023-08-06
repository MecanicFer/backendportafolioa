package com.portafolioa.backendportafolioa.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Controller
public class QRCodeController {

    @GetMapping(value = "/generateQRCode")
    public ResponseEntity<byte[]> generateQRCode(@RequestParam String link, HttpServletResponse response)
            throws WriterException, IOException {

        // Genera el código QR
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(link, BarcodeFormat.QR_CODE, 350, 350);

        // Convierte el código QR en una imagen
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, MediaType.IMAGE_PNG.getSubtype(), pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();

        // Configura los encabezados de la respuesta HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(pngData.length);

        // Devuelve la imagen como un objeto ResponseEntity
        return new ResponseEntity<byte[]>(pngData, headers, HttpStatus.OK);
    }
}

