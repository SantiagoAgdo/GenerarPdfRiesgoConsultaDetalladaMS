package com.mibanco.generarpdfriesgo.ms.services.impl;

import com.mibanco.generarpdfriesgo.ms.constants.Constants;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@ApplicationScoped
public class PdfGeneratorService {

    public void generatePdf(String outputPath) throws IOException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        float margin = 45;
        float yStart = page.getMediaBox().getHeight() - margin;
        float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
        float yPosition = yStart;
        float tableHeight = 12;
        float marginY = 15;

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

            addSubtitulo(contentStream, 15, margin, yPosition, "Información Básica");
            yPosition -= marginY;

            drawTableHeaderPrincipal(contentStream, margin, yPosition, tableWidth, tableHeight);
            yPosition -= tableHeight;

            String[] valores = {"02-02-2022", "BERMUDEZ RAMIREZ JUAN CARLOS", "C.C.", "11444618", "VIGENTE"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;

            drawTableHeaderSecundario(contentStream, margin, yPosition, tableWidth, tableHeight);
            yPosition -= tableHeight;

            valores = new String[]{"FACATATIVA", "04-06-1998", " 36 - 45", "Masculino", "No", " "};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;

            addSubtitulo(contentStream, 15, margin, yPosition - 11, "Artículo 14 Ley 1266 de 2008");
            yPosition -= marginY;

            addText(contentStream, margin, yPosition - marginY, "\"Se presenta reporte negativo cuando la(s) persona(s) natural(es) efectivamente se encuentra(n) en mora en sus cuotas u obligaciones.");
            yPosition -= marginY;

            addText(contentStream, margin, yPosition - marginY, "Se presenta reporte positivo cuando la(s) persona(s) natural(es) está(n) al día en sus obligaciones\"");
            yPosition -= marginY;
            yPosition -= 39;

            addSubtitulo(contentStream, 15, margin, yPosition , "Resumen");
            yPosition -= marginY;

            addSubtitulo(contentStream, 9, margin, yPosition, "Perfil General");
            yPosition -= marginY;

            drawTableHeaderResumen(contentStream, margin, yPosition, tableWidth, tableHeight);
            yPosition -= tableHeight;

            valores = new String[]{"Creditos vigentes", "0","0","2","3","5","5","0"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Creditos cerrados", "0","0","4","4","8","8","0"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Creditos restructurados", "0","0","0","0","0","0","0"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Creditos refinanciados", "0","0","1","1","0","0","0"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Consulta en los ult 6 meses", "0","0","0","1","1","0","0"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Desacuerdos Vig a la fecha", "0","0","0","0","0","0","0"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Antiguedad desde ", "2001-03-31"," ","2017-09-05","2017-09-07"," "," "," "};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;

            drawTableHeaderSaldosYMora(contentStream, margin, yPosition, tableWidth, tableHeight);
            yPosition -= tableHeight;

            valores = new String[]{"Saldo deuda total en mora ", "0.0","0.0","0.0","0.0","0.0","0.0","0.0"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Saldo deuda total (en miles)", "6,205","6,607","7,032","7,156","7,919","8,253","8,456"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Moras max Sector Real", "N","N","N","N","N","-","-"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Moras max Sector Telcos", "","N","N","N","N","-","-"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Total Moras Maximas", "N","N","N","N","N","N","N"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,true, valores);
            yPosition -= tableHeight;
            yPosition -= 18;

            addSubtitulo(contentStream, 9, margin, yPosition , "Endeudamiento Actual");
            yPosition -= marginY;

            drawTableHeaderEndeudamiento(contentStream, margin, yPosition, tableWidth, tableHeight);
            yPosition -= tableHeight;
            drawTableHeaderEndeudamientoSub(contentStream, margin, yPosition, tableWidth, tableHeight);
            yPosition -= tableHeight;
            valores = new String[]{"Cartera Computadores", "Principal","Al dia","A","0.0","0.0","0.0","65","1.0%", "0.0%"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Cartera Telefonia Cel", "Principal","Al dia","A","0.0","0.0","0.0","65","1.0%", "0.0%"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Total Telecomunicaciones", "",""," ","0","166","0","65","2.6%", "0.0%"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,true, valores);
            yPosition -= tableHeight;

            drawTableHeaderEndeudamientoSubReal(contentStream, margin, yPosition, tableWidth, tableHeight);
            yPosition -= tableHeight;
            valores = new String[]{"Cartera Microcrédito", "Principal","Al dia","A","8,065","5,512","0.0","65","86.3%", "68.2%"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Cartera Microcrédito", "Principal","Al dia","A","1,314","693","0.0","65","10.1%", "52.7%"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,false, valores);
            yPosition -= tableHeight;
            valores = new String[]{"Total Real", "","","","9,399","6,205","0","65","97.0%", "66.0%"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,true, valores);
            yPosition -= tableHeight;
            valores = new String[]{"TOTAL", "","","","9,399","6,371","0", "65","100%", "67.8%"};
            drawTableRow(contentStream, margin, yPosition, tableWidth, tableHeight,true, valores);
            yPosition -= tableHeight;


        }

        document.save(Constants.PATH_PDF + File.separator + "HistorialCrediticio1000234651.pdf");
        document.close();
    }

    private static void drawTableHeaderPrincipal(PDPageContentStream contentStream, float margin, float yPosition, float tableWidth, float tableHeight) throws IOException {

        contentStream.setFont(getFontBoldItalic(), 5);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);

        contentStream.showText("Fecha Consulta");
        contentStream.newLineAtOffset(tableWidth / 5, 0);
        contentStream.showText("Nombre");
        contentStream.newLineAtOffset(tableWidth / 5, 0);
        contentStream.showText("Tipo Documento");
        contentStream.newLineAtOffset(tableWidth / 5, 0);
        contentStream.showText("Número Documento");
        contentStream.newLineAtOffset(tableWidth / 5, 0);
        contentStream.showText("Estado Documento");
        contentStream.newLineAtOffset(tableWidth / 5, 0);

        contentStream.endText();
    }

    private static void drawTableHeaderSecundario(PDPageContentStream contentStream, float margin, float yPosition, float tableWidth, float tableHeight) throws IOException {
        contentStream.setFont(getFontBoldItalic(), 5);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);

        contentStream.showText("Lugar Expedición");
        contentStream.newLineAtOffset(tableWidth / 6, 0);
        contentStream.showText("Fecha Expedición");
        contentStream.newLineAtOffset(tableWidth / 6, 0);
        contentStream.showText("Rango Edad");
        contentStream.newLineAtOffset(tableWidth / 6, 0);
        contentStream.showText("Genero");
        contentStream.newLineAtOffset(tableWidth / 6, 0);
        contentStream.showText("Tiene RUT");
        contentStream.newLineAtOffset(tableWidth / 6, 0);
        contentStream.showText("Antiguedad Ubicacion");
        contentStream.endText();
    }

    private static void drawTableHeaderResumen(PDPageContentStream contentStream, float margin, float yPosition, float tableWidth, float tableHeight) throws IOException {

        contentStream.setFont(getFontBoldItalic(), 5);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);

        contentStream.showText("Sectores");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Sector Fianciero");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Sector Coperativo");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Sector Real");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Sector Telcos");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Total Sectores");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Total Como Principal");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Total como Codeudores y otros");
        contentStream.newLineAtOffset(tableWidth / 8, 0);

        contentStream.endText();
    }
    private static void drawTableHeaderSaldosYMora(PDPageContentStream contentStream, float margin, float yPosition, float tableWidth, float tableHeight) throws IOException {

        contentStream.setFont(getFontBoldItalic(), 5);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition-4);

        contentStream.showText("Saldos y Moras");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Ene 21");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Feb 21");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Mar 21");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Apr 21");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("May 21");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Jun 21");
        contentStream.newLineAtOffset(tableWidth / 8, 0);
        contentStream.showText("Jul 21");
        contentStream.newLineAtOffset(tableWidth / 8, 0);

        contentStream.endText();
    }
    private static void drawTableHeaderEndeudamiento(PDPageContentStream contentStream, float margin, float yPosition, float tableWidth, float tableHeight) throws IOException {

        contentStream.setFont(getFontBoldItalic(), 5);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition-4);

        contentStream.showText("Carteras");
        contentStream.newLineAtOffset(tableWidth / 10, 0);
        contentStream.showText("Calidad");
        contentStream.newLineAtOffset(tableWidth / 10, 0);
        contentStream.showText("Estado Actual");
        contentStream.newLineAtOffset(tableWidth / 10, 0);
        contentStream.showText("Calif");
        contentStream.newLineAtOffset(tableWidth / 10, 0);
        contentStream.showText("Cupo Inicial");
        contentStream.newLineAtOffset(tableWidth / 10, 0);
        contentStream.showText("Saldo Actual");
        contentStream.newLineAtOffset(tableWidth / 10, 0);
        contentStream.showText("Saldo en Mora");
        contentStream.newLineAtOffset(tableWidth / 10, 0);
        contentStream.showText("Valor cuota");
        contentStream.newLineAtOffset(tableWidth / 10, 0);
        contentStream.showText("% Part");
        contentStream.newLineAtOffset(tableWidth / 10, 0);
        contentStream.showText("% Deuda");
        contentStream.newLineAtOffset(tableWidth / 10, 0);

        contentStream.endText();
    }
    private static void drawTableHeaderEndeudamientoSub(PDPageContentStream contentStream, float margin, float yPosition, float tableWidth, float tableHeight) throws IOException {

        contentStream.setFont(getFontBoldItalic(), 5);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition-4);

        contentStream.showText("");
        contentStream.newLineAtOffset(tableWidth / 2.3f, 0);
        contentStream.showText("Sector Comunicaciones");
        contentStream.newLineAtOffset(tableWidth / 2.3f, 0);
        contentStream.showText("");
        contentStream.newLineAtOffset(tableWidth / 2.3f, 0);

        contentStream.endText();
    }
    private static void drawTableHeaderEndeudamientoSubReal(PDPageContentStream contentStream, float margin, float yPosition, float tableWidth, float tableHeight) throws IOException {

        contentStream.setFont(getFontBoldItalic(), 5);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition-4);

        contentStream.showText("");
        contentStream.newLineAtOffset(tableWidth / 2.3f, 0);
        contentStream.showText("Sector Real");
        contentStream.newLineAtOffset(tableWidth / 2.3f, 0);
        contentStream.showText("");
        contentStream.newLineAtOffset(tableWidth / 2.3f, 0);

        contentStream.endText();
    }

    private static void drawTableRow(PDPageContentStream contentStream, float margin, float yPosition, float tableWidth, float tableHeight, boolean bold,  String[] valores) throws IOException {

        contentStream.setFont(bold ? getFontBoldItalic() : getFont(), 5);
        contentStream.setLineWidth(1f);
        contentStream.moveTo(margin, yPosition);
        contentStream.stroke();

        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);
        for (String val : valores) {
            contentStream.showText(val);
            contentStream.newLineAtOffset(tableWidth / valores.length, 0);
        }
        contentStream.endText();
    }

    private static void drawHorizontalLine(PDPageContentStream contentStream, float margin, float yPosition, float tableWidth) throws IOException {
        contentStream.setLineWidth(0.5f);
        contentStream.moveTo(margin - 13, yPosition + 7);
        contentStream.lineTo((margin + tableWidth), yPosition + 7);
        contentStream.stroke();
    }

    private static PDType0Font getFont() throws IOException {
        try (InputStream fontStream = PdfGeneratorService.class.getResourceAsStream("/ARIAL.TTF")) {
            return PDType0Font.load(new PDDocument(), fontStream);
        }
    }

    private static void addText(PDPageContentStream contentStream, float margin, float yPosition, String text) throws IOException {
        contentStream.setFont(getFont(), 7);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition - 8);
        contentStream.showText(text);
        contentStream.endText();
    }

    private static void addSubtitulo(PDPageContentStream contentStream, int tamanoFuente, float margin, float yPosition, String text) throws IOException {
        contentStream.setFont(getFont(), tamanoFuente);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText(text);
        contentStream.endText();
    }

    private static void addEmptySpace(PDPageContentStream contentStream, float xStart, float yStart, float width, float height) throws IOException {
        contentStream.setLineWidth(1);
        contentStream.addRect(xStart, yStart, width, height);
        contentStream.stroke();
    }
    public static String convertPDFToBase64(String pdfFilePath) throws IOException {
        Path path = Paths.get(pdfFilePath);
        byte[] pdfBytes = Files.readAllBytes(path);
        return Base64.getEncoder().encodeToString(pdfBytes);
    }
    private static PDType0Font getFontBoldItalic() throws IOException {
        try (InputStream fontStream = PdfGeneratorService.class.getResourceAsStream("/ArialCEBoldItalic.ttf")) {
            return PDType0Font.load(new PDDocument(), fontStream);
        }
    }
}
