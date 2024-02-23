package com.Cdv.ControleVendas.controllers;

import com.Cdv.ControleVendas.services.PdfGeneratorServices;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@Controller
public class PdfController {
    private final PdfGeneratorServices pdfGeneratorServices;

    @CrossOrigin
     @GetMapping("/Product/pdf")
     public void generatePdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
         DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
         String currentDateTime = dateFormatter.format(new Date());

         String headerKey = "Content-Disposition";
         String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
         response.setHeader(headerKey, headerValue);

         this.pdfGeneratorServices.export(response);
     }
}
