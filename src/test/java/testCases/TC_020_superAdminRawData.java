package testCases;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.superAdminRawData;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class TC_020_superAdminRawData extends BaseClass{
    @Test
    public void superAdminExportImportRawData() {
        try {
            // Login and navigate to export
            superAdminRawData lp = new superAdminRawData(driver);
            lp.setUserName(p.getProperty("SuperAdminuserName"));
            lp.setPassword(p.getProperty("Password"));
            lp.setClickOnsignUp();
            lp.otpGenerate();
            lp.otpinput(p.getProperty("OTP"));
            lp.VerifyOtp();
            lp.clickCancelpopup();
            lp.clickAllFiles();
            lp.clickOnRawData();
            lp.exportClick();
            lp.clickCanceagain();
            logger.info("Download initiated");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}