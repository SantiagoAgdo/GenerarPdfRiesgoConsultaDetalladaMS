package com.mibanco.generarpdfriesgo.ms.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

@ApplicationScoped
public class PdfGeneratorService {

    public void generatePdf(String outputPath, String textToAdd) throws IOException {
        PDDocument document = new PDDocument();
        PDPage blankPage = new PDPage(PDRectangle.A4);
        document.addPage(blankPage);
        PDPageContentStream contentStream = new PDPageContentStream(document, blankPage);
        contentStream.setFont(getFont(), 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 750);
        contentStream.showText(textToAdd);
        contentStream.endText();
        contentStream.close();

        document.save(outputPath);
        document.close();
    }

    private static PDType0Font getFont() throws IOException {
        PDType0Font font = PDType0Font.load(new PDDocument(), new File("/Users/santiagoagudelo/Downloads/Roboto/Roboto-Light.ttf"));
        return font;
    }
}
