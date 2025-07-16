package allWebsites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.ExtentReportManager;
import com.aventstack.extentreports.*;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import org.testng.annotations.Parameters;

public class baseClass {
    public WebDriver driver;
    public WebDriverWait wait;
    public ExtentReports extent;
    public ExtentTest test;
    public Logger logger;
    @BeforeSuite
    public void clearLogFile() {
        try (FileWriter fw = new FileWriter("logs/automation.log", false)) {
            fw.write(""); // Clear log file
            System.out.println("Log4j log file cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    @Parameters({"os","Browser"})
    public void setUp(String os, String br) {
        logger = LogManager.getLogger(this.getClass());
        switch (br.toLowerCase()) {
            case "chrome" : driver = new ChromeDriver();break;
            case "edge" : driver = new EdgeDriver();break;
            case "firefox" : driver =new FirefoxDriver();break;
            default:System.out.println("Invalid Browser");return;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}
