package com.Cdv.ControleVendas.services;

import com.Cdv.ControleVendas.model.Product;
import com.Cdv.ControleVendas.repositories.ProductRepository;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;


@Service
public class PdfGeneratorServices {

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTitle.setSize(20);

        Paragraph paragraph = new Paragraph("Itens no estoque", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontText = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontText.setSize(12);

        document.add(paragraph);
        List<Product> productList = findAll();

        for (Product product : productList) {
            Paragraph textParagraph = new Paragraph(product.toString(), fontText);
            textParagraph.setAlignment(Paragraph.ALIGN_LEFT);

            document.add(textParagraph);
        }
        document.close();
    }
    @Autowired
    ProductRepository repository;
    public List<Product> findAll(){
        return repository.findAll();
    }
}
