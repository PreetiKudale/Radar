package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.opsUser;

public class TC_016_OpsUser extends BaseClass{
    @Test
    public void commsUserAccount() {
        try {
            opsUser opsUser = new opsUser(driver);
            opsUser.setUserName(p.getProperty("OpsUserName"));
            opsUser.setPassword(p.getProperty("Password"));
            opsUser.setClickOnsignUp();
            opsUser.otpGenerate();
            opsUser.enterOtp(p.getProperty("OTP"));
            opsUser.VerifyOtp();
            opsUser.clickCancelpopup();
            opsUser.clickonworkspace();
            opsUser.clickMyWorkspace();
            opsUser.setSelectRowsPerPage();
            opsUser.headerCheckbox();
            opsUser.exportClick();
            opsUser.clickCancelpopupagain();
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
