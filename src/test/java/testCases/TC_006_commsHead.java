package testCases;

import org.testng.Assert;
import org.testng.SkipException;
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
            commsHead.enterOtp(p.getProperty("OTP"));
            commsHead.VerifyOtp();
            commsHead.clickCancelpopup();
            commsHead.clickonworkspace();
            commsHead.clickMyWorkspace();
            commsHead.setSelectRowsPerPage();
            commsHead.headerCheckbox();
            commsHead.exportClick();
            commsHead.clickCancelpopupagain();
            logger.info("Login to Radar Application");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
