package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.dataValidationHead;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TC_002_dataValidationHead extends BaseClass {
    @Test
    public void dvHeadAccount() {
        try {
            dataValidationHead dv = new dataValidationHead(driver);
            dv.setUserName(p.getProperty("DvHeadUserName"));
            dv.setPassword(p.getProperty("Password"));
            dv.setClickOnsignUp();
            dv.otpGenerate();
            dv.otpinput(p.getProperty("OTP"));
            dv.VerifyOtp();
            dv.clickCancelpopup();
            dv.clickonworkspace();
            dv.clickMyWorkspace();
            dv.setSelectRowsPerPage();
            dv.headerCheckbox();
            dv.exportClick();
            dv.clickCanceagain();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
