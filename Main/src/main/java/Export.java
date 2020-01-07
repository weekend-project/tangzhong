import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.*;

//FIXME fix this message in the output
// SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
// SLF4J: Defaulting to no-operation (NOP) logger implementation
// SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.

// iText support info: https://itextpdf.com/en/products/itext-7/itext-7-core

public class Export {
    public static final String DEST = "C:\\tangzhong\\out\\PDFs\\hello.pdf"; //TODO make this so it doesn't overwrite existing file (renames), and change file path to something more appropriate

    public static void getPDF() throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
        Document document = new Document(pdf);
        String line = "Amounts for the slurry:\n" + Grams.getFlourSlurry(Grams.flourWeight) + "g flour \n" + Grams.getLiquidSlurry(Grams.flourWeight) + "g liquid";
        document.add(new Paragraph(line));
        document.close();

        //System.out.println("Awesome PDF just got created.");
    }
}
