package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utility.ExtentReportManager;
import utility.HtmlToPdfConverter;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;

  @BeforeSuite
public void clearLogFile() {
    try {
        java.io.File logDir = new java.io.File("logs");
        if (!logDir.exists()) {
            logDir.mkdirs();
        }
        FileWriter fw = new FileWriter("logs/RadarAutomation.log", false);
        fw.write("");
        fw.close();
        System.out.println("Log4j log file cleared.");
    } catch (IOException e) {
        System.err.println("Failed to clear log file: " + e.getMessage());
    }
}
    @BeforeClass
    @Parameters({"os","Browser"})
    public void setUp(String os, String br) throws IOException {
        //Loading Config.properties file
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p=new Properties();
        p.load(file);
        logger = LogManager.getLogger(this.getClass());
        switch (br.toLowerCase()) {
            case "chrome" : driver = new ChromeDriver();break;
            case "edge" : driver = new EdgeDriver();break;
            case "firefox" : driver =new FirefoxDriver();break;
            default:System.out.println("Invalid Browser");return;
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(p.getProperty("uatAppURL"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void tearDownReport() {
        ExtentReportManager.getInstance().flush();

        // Wait for HTML file to be completely written
        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        // Convert to PDF
        HtmlToPdfConverter.convertToPdf(
                "test-output/ExtentReport.html",
                "test-output/ExtentReport.pdf"
        );
    }
  /*  public String randomNumber(){
        String geneatedNymeric = RandomStringUtils.randomNumeric(10);
        return geneatedNymeric;
    }*/
    /*
    public String randomeString() {
        String genratedString = RandomStringUtils.randomAlphabetic(7);
        return genratedString;
    }

    public String randomAlphaNumeric(){
        String genratedString = RandomStringUtils.randomAlphabetic(7);
        String geneatedNymeric = RandomStringUtils.randomNumeric(10);
        return (genratedString +"@"+ geneatedNymeric);
        //For Password not in use

        For Use Add on top on class object and use variable
                String password = randomAlphaNumeric();
    }*/

}
