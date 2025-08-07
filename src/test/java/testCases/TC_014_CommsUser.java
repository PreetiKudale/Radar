package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.commsUser;

public class TC_014_CommsUser extends BaseClass{
    @Test
    public void commsUserAccount() {
        try {
            commsUser commsUser = new commsUser(driver);
            commsUser.setUserName(p.getProperty("CommsUserName"));
            commsUser.setPassword(p.getProperty("Password"));
            commsUser.setClickOnsignUp();
            commsUser.otpGenerate();
            commsUser.enterOtp(p.getProperty("OTP"));
            commsUser.VerifyOtp();
            commsUser.clickCancelpopup();
            commsUser.clickonworkspace();
            commsUser.clickMyWorkspace();
            commsUser.setSelectRowsPerPage();
            commsUser.headerCheckbox();
            commsUser.exportClick();
            commsUser.clickCancelpopupagain();
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
