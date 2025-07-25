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
            rta.otpinput(p.getProperty("OTP"));
            rta.VerifyOtp();
            rta.clickCancelpopup();
            rta.clickonworkspace();
            rta.clickMyWorkspace();
            rta.setSelectRowsPerPage();
            rta.headerCheckbox();
            rta.exportClick();
            rta.clickCancelpopupagain();
            logger.info("Login to Radar Application");

        } catch (SkipException se) {
            logger.warn("Test Skipped: " + se.getMessage());
            throw se; // Let TestNG handle skip
        } catch (Exception e) {
            logger.error("Test Failed", e);
            Assert.fail("Test failed due to: " + e.getMessage());
        }
    }
}
