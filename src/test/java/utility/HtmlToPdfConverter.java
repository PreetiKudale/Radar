package utility;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmlToPdfConverter {

    public static void convertToPdf(String htmlFilePath, String outputPdfPath) {
        try {
            // Step 1: Read the HTML file
            String html = new String(java.nio.file.Files.readAllBytes(
                    new File(htmlFilePath).toPath()), StandardCharsets.UTF_8);

            // Step 2: Use Jsoup to clean/auto-close malformed tags (<link>, <meta>, <img>, etc.)
            Document doc = Jsoup.parse(html);
            doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml); // output as XHTML
            String xhtml = doc.outerHtml();

            // Step 3: Convert to PDF
            try (OutputStream os = Files.newOutputStream(Paths.get(outputPdfPath))) {
                PdfRendererBuilder builder = new PdfRendererBuilder();
                builder.useFastMode();
                builder.withHtmlContent(xhtml, new File(htmlFilePath).getParentFile().toURI().toString());
                builder.toStream(os);
                builder.run();
            }

            System.out.println("✅ PDF report created successfully: " + outputPdfPath);

        } catch (Exception e) {
            System.err.println("❌ PDF conversion failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
