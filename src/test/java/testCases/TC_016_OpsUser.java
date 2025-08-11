package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.opsUser;

public class TC_016_OpsUser extends BaseClass{
    @Test
    public void commsUserAccount() {
        logger.info("Started Operations User Account Test Class");
        try {
            opsUser opsUser = new opsUser(driver);
            opsUser.setUserName(p.getProperty("OpsUserName"));
            logger.info("Added Operations User Name");
            opsUser.setPassword(p.getProperty("Password"));
            logger.info("Added Operations Password");
            opsUser.setClickOnsignUp();
            logger.info("Click on Signup Operations User");
            opsUser.otpGenerate();
            logger.info("Click on Generate otp Operations User");
            opsUser.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP Operations User");
            opsUser.VerifyOtp();
            logger.info("Click on Verify Otp Operations User");
            opsUser.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available Operations User");
            opsUser.clickonworkspace();
            logger.info("Click on Workspace Sidebar Operations User");
            opsUser.clickMyWorkspace();
            logger.info("Click on Workspace Operations User");
            opsUser.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available Operations User");
            opsUser.headerCheckbox();
            logger.info("Click on Select all Checkbox Operations User");
            opsUser.exportClick();
            logger.info("Click on Export Operations User");
            logger.info("Ops User Download Initiated");
            opsUser.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back Operations User");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
