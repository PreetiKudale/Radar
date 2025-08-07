package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.opsHead;

public class TC_009_opsHead extends BaseClass{
    @Test
    public void opsHeadAccount() {
        try {
            opsHead ops = new opsHead(driver);
            ops.setUserName(p.getProperty("opsHeadUserName"));
            ops.setPassword(p.getProperty("Password"));
            ops.setClickOnsignUp();
            ops.otpGenerate();
            ops.enterOtp(p.getProperty("OTP"));
            ops.VerifyOtp();
            ops.clickCancelpopup();
            ops.clickonworkspace();
            ops.clickMyWorkspace();
            ops.setSelectRowsPerPage();
            ops.headerCheckbox();
            ops.exportClick();
            ops.clickCancelpopupagain();
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
