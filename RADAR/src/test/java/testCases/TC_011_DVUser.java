package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.dvUser;

public class TC_011_DVUser extends BaseClass {
    @Test
    public void dvUserAccount() {
        try {
            dvUser dvUser = new dvUser(driver);
            dvUser.setUserName(p.getProperty("DVUserName"));
            dvUser.setPassword(p.getProperty("Password"));
            dvUser.setClickOnsignUp();
            dvUser.otpGenerate();
            dvUser.otpinput(p.getProperty("OTP"));
            dvUser.VerifyOtp();
            dvUser.clickCancelpopup();
            dvUser.clickonworkspace();
            dvUser.clickMyWorkspace();
            dvUser.setSelectRowsPerPage();
            dvUser.headerCheckbox();
            dvUser.exportClick();
            dvUser.clickCanceagain();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
