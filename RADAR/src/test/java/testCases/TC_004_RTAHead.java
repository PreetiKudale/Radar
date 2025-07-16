package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RTAHead;

public class TC_004_RTAHead extends BaseClass{
    @Test
    public void rtaHeadAccount() {
        try {
            RTAHead rta = new RTAHead(driver);
            rta.setUserName(p.getProperty("RTAHeadUserName"));
            rta.setPassword(p.getProperty("Password"));
            rta.setClickOnsignUp();
            rta.otpGenerate();
            rta.otpinput(p.getProperty("OTP"));
            rta.VerifyOtp();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }
}
