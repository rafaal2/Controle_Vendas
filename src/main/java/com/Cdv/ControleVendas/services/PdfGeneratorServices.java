package com.Cdv.ControleVendas.services;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PdfGeneratorServices {
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTitle.setSize(20);

        Paragraph paragraph = new Paragraph("manu", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontText = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontText.setSize(12);

        Paragraph textParagraph = new Paragraph("meu amor", fontText);
        textParagraph.setAlignment(Paragraph.ALIGN_LEFT);

        document.add( paragraph);
        document.add(textParagraph);
        document.close();

    }
}
