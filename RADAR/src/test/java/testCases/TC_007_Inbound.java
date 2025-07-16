package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.inbound;

public class TC_007_Inbound extends BaseClass{
    @Test
    public void inboundAccount() {
        try {
            inbound inbound = new inbound(driver);
            inbound.setUserName(p.getProperty("InboundUserName"));
            inbound.setPassword(p.getProperty("Password"));
            inbound.setClickOnsignUp();
            inbound.otpGenerate();
            inbound.otpinput(p.getProperty("OTP"));
            inbound.VerifyOtp();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }
}
