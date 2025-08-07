package testCases;

import org.testng.Assert;
import org.testng.SkipException;
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
            rta.enterOtp(p.getProperty("OTP"));
            rta.VerifyOtp();
            rta.clickCancelpopup();
            rta.clickonworkspace();
            rta.clickMyWorkspace();
            rta.setSelectRowsPerPage();
            rta.headerCheckbox();
            rta.exportClick();
            rta.clickCancelpopupagain();
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
