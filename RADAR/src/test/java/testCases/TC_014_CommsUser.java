package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.commsUser;

public class TC_014_CommsUser extends BaseClass{
    @Test
    public void commsUserAccount() {
        try {
            commsUser commsUser = new commsUser(driver);
            commsUser.setUserName(p.getProperty("CommsUserName"));
            commsUser.setPassword(p.getProperty("Password"));
            commsUser.setClickOnsignUp();
            commsUser.otpGenerate();
            commsUser.otpinput(p.getProperty("OTP"));
            commsUser.VerifyOtp();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }
}
