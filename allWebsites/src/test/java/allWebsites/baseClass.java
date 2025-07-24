package allWebsites;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.ExtentReportManager;
import utility.HtmlToPdfConverter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.lang.reflect.Method;

public class baseClass {
    public WebDriver driver;
    public WebDriverWait wait;
    public ExtentReports extent;
    public ExtentTest test;
    public Logger logger;

    @BeforeSuite
    public void clearLogFile() {
        try {
            java.io.File logDir = new java.io.File("logs");
            if (!logDir.exists()) {
                logDir.mkdirs();
            }
            FileWriter fw = new FileWriter("logs/allWebsites.log", false);
            fw.write("");
            fw.close();
            System.out.println("Log4j log file cleared.");
        } catch (IOException e) {
            System.err.println("Failed to clear log file: " + e.getMessage());
        }
    }
    @BeforeMethod
    public void startTest(Method method) {
        test = extent.createTest(method.getName());  // 💡 Log test name dynamically
    }

    @AfterMethod
    public void logResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else {
            test.skip("Test Skipped");
        }
    }
    @BeforeClass
    @Parameters({"os", "Browser"})
    public void setUp(String os, String br) {
        logger = LogManager.getLogger(this.getClass());

        // Initialize ExtentReports
        extent = ExtentReportManager.getInstance();

        switch (br.toLowerCase()) {
            case "chrome": driver = new ChromeDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default:
                System.out.println("Invalid Browser");
                return;
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
}

