package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.lang3.RandomStringUtils;
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
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.*;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;
    public Properties p;
    public ExtentReports extent;
    public ExtentTest test;
    public WebDriverWait wait;

    @BeforeSuite
    public void clearLogFile() {
        try {
            File logDir = new File("logs");
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
        test = extent.createTest(method.getName());
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
        extent = ExtentReportManager.getInstance();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new FileNotFoundException("config.properties not found in classpath");
            }
            p = new Properties();
            p.load(input);
            logger.info("Config properties loaded successfully.");
        } catch (Exception e) {
            logger.error("Failed to load config.properties", e);
            throw new RuntimeException("Unable to load config.properties");
        }

        // Initialize browser
        switch (br.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("Invalid Browser");
                return;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Load URL
        String url = p.getProperty("liveAppURL");
        if (url == null || url.isEmpty()) {
            throw new RuntimeException("URL not found in config.properties");
        }
        System.out.println("Loaded URL: " + url);
        driver.get(url);
    }

   /* @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/

    @AfterSuite
    public void tearDownReport() {
        ExtentReportManager.getInstance().flush();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }

        try {
            HtmlToPdfConverter.convertToPdf(
                    "test-output/ExtentReport.html",
                    "test-output/ExtentReport.pdf"
            );
        } catch (Exception e) {
            System.err.println("PDF conversion failed: " + e.getMessage());
        }
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    /*
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(7);
    }

    public String randomAlphaNumeric() {
        String alpha = RandomStringUtils.randomAlphabetic(7);
        String numeric = RandomStringUtils.randomNumeric(10);
        return alpha + "@" + numeric;
    }
    */
}
