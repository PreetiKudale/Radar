package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DCUser;

public class TC_012_DCUser extends BaseClass{
    @Test
    public void dcUserAccount() {
        try {
            DCUser dcUser = new DCUser(driver);
            dcUser.setUserName(p.getProperty("DcUserName"));
            dcUser.setPassword(p.getProperty("Password"));
            dcUser.setClickOnsignUp();
            dcUser.otpGenerate();
            dcUser.otpinput(p.getProperty("OTP"));
            dcUser.VerifyOtp();
            dcUser.clickCancelpopup();
            dcUser.clickonworkspace();
            dcUser.clickMyWorkspace();
            dcUser.setSelectRowsPerPage();
            dcUser.headerCheckbox();
            dcUser.exportClick();
            dcUser.clickCancelpopupagain();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }
}
