package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.commsHead;

public class TC_006_commsHead extends BaseClass {
    @Test
    public void commsHeadAccount() {
        try {
            commsHead commsHead = new commsHead(driver);
            commsHead.setUserName(p.getProperty("CommsHeadUserName"));
            commsHead.setPassword(p.getProperty("Password"));
            commsHead.setClickOnsignUp();
            commsHead.otpGenerate();
            commsHead.otpinput(p.getProperty("OTP"));
            commsHead.VerifyOtp();
            commsHead.clickCancelpopup();
            commsHead.clickonworkspace();
            commsHead.clickMyWorkspace();
            commsHead.setSelectRowsPerPage();
            commsHead.headerCheckbox();
            commsHead.exportClick();
            commsHead.clickCancelpopupagain();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }
}
