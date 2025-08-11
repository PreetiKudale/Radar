package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.dataValidationHead;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TC_002_dataValidationHead extends BaseClass {
    @Test
    public void dvHeadAccount() {
        logger.info("Started Data Validation Account Test Class");
        try {
            dataValidationHead dvHead = new dataValidationHead(driver);
            dvHead.setUserName(p.getProperty("DvHeadUserName"));
            logger.info("Added Data Validation Head User Name");
            dvHead.setPassword(p.getProperty("Password"));
            logger.info("Added Data Validation Head Password");
            dvHead.setClickOnsignUp();
            logger.info("Click on Signup Data Validation Head");
            dvHead.otpGenerate();
            logger.info("Click on Generate otp Data Validation Head");
            dvHead.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP Data Validation Head");
            dvHead.VerifyOtp();
            logger.info("Click on Verify Otp Data Validation Head");
            dvHead.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available Data Validation Head");
            dvHead.clickonworkspace();
            logger.info("Click on Workspace Sidebar Data Validation Head");
            dvHead.clickMyWorkspace();
            logger.info("Click on Workspace Data Validation Head");
            dvHead.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available Data Validation Head");
            dvHead.headerCheckbox();
            logger.info("Click on Select all Checkbox Data Validation Head");
            dvHead.exportClick();
            logger.info("Click on Export Data Validation Head");
            logger.info("Data Validation Download Initiated");
            dvHead.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back Data Validation Head");

        } catch (SkipException e) {
            throw e; // Let TestNG mark it as skipped
        } catch (Exception e) {
            logger.error("Test Failed", e);
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
