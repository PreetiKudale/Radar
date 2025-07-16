package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.bdUser;
import pageObjects.latestFileEdit;

public class TC_021_openLatestFile extends BaseClass{
    @Test
    public void latestFileOpen() {
        try {
            latestFileEdit fd = new latestFileEdit(driver);
            fd.fileEdit();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }

}
