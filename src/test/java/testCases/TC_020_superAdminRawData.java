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
            logger.info("Started SuperAdmin Account Test Class for Raw Data");
            superAdminRawData lp = new superAdminRawData(driver);
            lp.setUserName(p.getProperty("SuperAdminuserName"));
            logger.info("Login to Super Admin");
            lp.setPassword(p.getProperty("Password"));
            logger.info("Enter SuperAdmin Password");
            lp.setClickOnsignUp();
            logger.info("Click on Signup SuperAdmin");
            lp.otpGenerate();
            logger.info("Click on Generate otp SuperAdmin");
            lp.enterOtp(p.getProperty("OTP"));
            logger.info("Enter OTP SuperAdmin");
            lp.VerifyOtp();
            logger.info("Click on Verify OTP SuperAdmin");
            lp.clickCancelpopup();
            logger.info("Click on Cancel Popup if Available");
            lp.clickAllFiles();
            logger.info("Click on All files SuperAdmin");
            lp.clickOnRawData();
            logger.info("Cick on Raw data Super Admin");
            lp.exportClick();
            logger.info("Click on Export Super Admin File");
            logger.info("Download initiated");
            lp.clickCancelpopupagain();
            logger.info("Click on Cancel popup after File download navigating back on dashboard");


        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}