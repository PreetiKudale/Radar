package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.commsHead;

public class TC_006_commsHead extends BaseClass {
    @Test
    public void commsHeadAccount() {
        try {
            commsHead comms = new commsHead(driver);
            comms.setUserName(p.getProperty("CommsHeadUserName"));
            comms.setPassword(p.getProperty("Password"));
            comms.setClickOnsignUp();
            comms.otpGenerate();
            comms.otpinput(p.getProperty("OTP"));
            comms.VerifyOtp();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }
}
