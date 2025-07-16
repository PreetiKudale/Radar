package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BDHead;

public class TC_008_BDHead extends BaseClass{
    @Test
    public void BDHeadAccount() {
        try {
            BDHead bd = new BDHead(driver);
            bd.setUserName(p.getProperty("BDHeadUserName"));
            bd.setPassword(p.getProperty("Password"));
            bd.setClickOnsignUp();
            bd.otpGenerate();
            bd.otpinput(p.getProperty("OTP"));
            bd.VerifyOtp();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }
}
