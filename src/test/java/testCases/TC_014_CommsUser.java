package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.commsUser;

public class TC_014_CommsUser extends BaseClass{
    @Test
    public void commsUserAccount() {
        logger.info("Started Communication User Account Test Class");
        try {
            commsUser commsUser = new commsUser(driver);
            commsUser.setUserName(p.getProperty("CommsUserName"));
            logger.info("Added Communication User Name");
            commsUser.setPassword(p.getProperty("Password"));
            logger.info("Added Communication Password");
            commsUser.setClickOnsignUp();
            logger.info("Click on Signup Communication User");
            commsUser.otpGenerate();
            logger.info("Click on Generate otp Communication User");
            commsUser.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP Communication User");
            commsUser.VerifyOtp();
            logger.info("Click on Verify Otp Communication User");
            commsUser.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available Communication User");
            commsUser.clickonworkspace();
            logger.info("Click on Workspace Sidebar Communication User");
            commsUser.clickMyWorkspace();
            logger.info("Click on Workspace Communication User");
            commsUser.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available Communication User");
            commsUser.headerCheckbox();
            logger.info("Click on Select all Checkbox Communication User");
            commsUser.exportClick();
            logger.info("Click on Export Communication User");
            logger.info("Comms User Download Initiated");
            commsUser.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back Communication User");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
