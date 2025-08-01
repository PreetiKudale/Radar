package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Always generate full path for consistent behavior across local & Jenkins
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(spark);

            // Optional: Set system info (can be viewed in the report)
            extent.setSystemInfo("Framework", "Selenium");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Author", "Preeti");
        }
        return extent;
    }
}
