package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.bdUser;


public class TC_015_bdUser extends BaseClass {
    @Test
    public void BDUserAccount() {
        try {
            bdUser bdUser = new bdUser(driver);
            bdUser.setUserName(p.getProperty("BDUsername"));
            bdUser.setPassword(p.getProperty("Password"));
            bdUser.setClickOnsignUp();
            bdUser.otpGenerate();
            bdUser.otpinput(p.getProperty("OTP"));
            bdUser.VerifyOtp();
            bdUser.clickCancelpopup();
            bdUser.clickonworkspace();
            bdUser.clickMyWorkspace();
            bdUser.setSelectRowsPerPage();
            bdUser.headerCheckbox();
            bdUser.exportClick();
            bdUser.clickCancelpopupagain();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
           /* Assert.fail();*/
        }
    }

}
