import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.*;

// iText support info: https://itextpdf.com/en/products/itext-7/itext-7-core

public class Export {
    //TODO make this so it doesn't overwrite existing file (renames)
    public static final String DEST = System.getProperty("user.home") + "/Desktop/tangzhong.pdf/";

    public static void getPDF(String flourAmount, String waterAmount) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
        Document document = new Document(pdf);
        String line = "Amounts for the roux:\n" + flourAmount + " flour \n" + waterAmount + " water";
        document.add(new Paragraph(line));
        document.close();


        //System.out.println("Awesome PDF just got created.");
    }
}
