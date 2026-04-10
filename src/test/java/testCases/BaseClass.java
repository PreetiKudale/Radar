package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.ExtentReportManager;
import utility.HtmlToPdfConverter;
import utility.ScreenshotUtil;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;
    public ExtentReports extent;
    public ExtentTest test;

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
    @BeforeMethod
    public void startTest(Method method) {
        test = extent.createTest(method.getName());  // 💡 Log test name dynamically
    }

    @AfterMethod
    public void logResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
            // 👇 Capture screenshot
            String screenshotPath = ScreenshotUtil.capture(driver, result.getName());
            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath);  // For Extent report
            }

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else {
            test.skip("Test Skipped");
        }
    }

    @BeforeClass
    @Parameters({"os", "Browser"})
    public void setUp(@Optional("Windows") String os, @Optional("chrome") String br) throws IOException {
        extent = ExtentReportManager.getInstance();

        // Load config file
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());
        System.out.println("Running on OS: " + os + " | Browser: " + br);

        // Normalize browser input
        String browser = br.toLowerCase();
        boolean isHeadless = browser.contains("headless");

        switch (browser) {
            // 🧩 Chrome / Chrome-Headless
            case "chrome":
            case "chrome-headless": {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                // Disable save password prompts
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);

                // Stability arguments
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chrome-profile-" + UUID.randomUUID());

                // Headless mode
               /* if (isHeadless) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                }*/

                driver = new ChromeDriver(options);
                break;
            }

            // 🧩 Edge / Edge-Headless
            case "edge":
            case "edge-headless": {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();

              /*  if (isHeadless) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--window-size=1920,1080");
                }*/

                edgeOptions.addArguments("--disable-gpu");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--remote-allow-origins=*");

                driver = new EdgeDriver(edgeOptions);
                break;
            }

            // 🧩 Firefox / Firefox-Headless
            case "firefox":
            case "firefox-headless": {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOptions = new FirefoxOptions();

                if (isHeadless) {
                    ffOptions.addArguments("--headless");
                    ffOptions.addArguments("--width=1920");
                    ffOptions.addArguments("--height=1080");
                }

                driver = new FirefoxDriver(ffOptions);
                break;
            }

            default:
                throw new IllegalArgumentException("❌ Invalid browser name provided: " + br);
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(p.getProperty("TestAppURL"));

        logger.info("✅ Browser launched successfully: " + br + " | URL: " + p.getProperty("TestAppURL"));
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
