package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.collectionHead;

public class TC_010_collectionHead extends BaseClass{
    @Test
    public void opsHeadAccount() {
        try {
            collectionHead collection = new collectionHead(driver);
            collection.setUserName(p.getProperty("CollectionHeadUserName"));
            collection.setPassword(p.getProperty("Password"));
            collection.setClickOnsignUp();
            collection.otpGenerate();
            collection.otpinput(p.getProperty("OTP"));
            collection.VerifyOtp();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }
}
