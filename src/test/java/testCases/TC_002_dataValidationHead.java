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
        try {
            dataValidationHead dvHead = new dataValidationHead(driver);
            dvHead.setUserName(p.getProperty("DvHeadUserName"));
            dvHead.setPassword(p.getProperty("Password"));
            dvHead.setClickOnsignUp();
            dvHead.otpGenerate();
            dvHead.enterOtp(p.getProperty("OTP"));
            dvHead.VerifyOtp();
            dvHead.clickCancelpopup();
            dvHead.clickonworkspace();
            dvHead.clickMyWorkspace();
            dvHead.setSelectRowsPerPage();
            dvHead.headerCheckbox();
            dvHead.exportClick();
            dvHead.clickCancelpopupagain();
            logger.info("Login to Radar Application");
            logger.info("Login to Radar Application");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
