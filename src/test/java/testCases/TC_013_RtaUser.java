package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.RtaUser;

public class TC_013_RtaUser extends BaseClass {
    @Test
    public void ratUserAccount() {
        logger.info("Started RTA User Account Test Class");
        try {
            RtaUser rtaUser = new RtaUser(driver);
            rtaUser.setUserName(p.getProperty("RtaUserName"));
            logger.info("Added RTA User Name");
            rtaUser.setPassword(p.getProperty("Password"));
            logger.info("Added RTA Password");
            rtaUser.setClickOnsignUp();
            logger.info("Click on Signup RTA User");
            rtaUser.otpGenerate();
            logger.info("Click on Generate otp RTA User");
            rtaUser.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP RTA User");
            rtaUser.VerifyOtp();
            logger.info("Click on Verify Otp RTA User");
            rtaUser.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available RTA User");
            rtaUser.clickonworkspace();
            logger.info("Click on Workspace Sidebar RTA User");
            rtaUser.clickMyWorkspace();
            logger.info("Click on Workspace RTA User");
            rtaUser.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available RTA User");
            rtaUser.headerCheckbox();
            logger.info("Click on Select all Checkbox RTA User");
            rtaUser.exportClick();
            logger.info("Click on Export RTA User");
            logger.info("RTA User Download Initiated");
            rtaUser.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back RTA User");
        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }

}
