package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.RtaUser;

public class TC_013_RtaUser extends BaseClass {
    @Test
    public void ratUserAccount() {
        try {
            RtaUser rtaUser = new RtaUser(driver);
            rtaUser.setUserName(p.getProperty("RtaUserName"));
            rtaUser.setPassword(p.getProperty("Password"));
            rtaUser.setClickOnsignUp();
            rtaUser.otpGenerate();
            rtaUser.enterOtp(p.getProperty("OTP"));
            rtaUser.VerifyOtp();
            rtaUser.clickCancelpopup();
            rtaUser.clickonworkspace();
            rtaUser.clickMyWorkspace();
            rtaUser.setSelectRowsPerPage();
            rtaUser.headerCheckbox();
            rtaUser.exportClick();
            rtaUser.clickCancelpopupagain();
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
