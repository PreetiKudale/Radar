package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.bdUser;


public class TC_015_bdUser extends BaseClass {
    @Test
    public void BDUserAccount() {
        logger.info("Started BD User Account Test Class");
        try {
            bdUser bdUser = new bdUser(driver);
            bdUser.setUserName(p.getProperty("BDUsername"));
            logger.info("Added BD User Name");
            bdUser.setPassword(p.getProperty("Password"));
            logger.info("Added BD Password");
            bdUser.setClickOnsignUp();
            logger.info("Click on Signup BD User");
            bdUser.otpGenerate();
            logger.info("Click on Generate otp BD User");
            bdUser.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP BD User");
            bdUser.VerifyOtp();
            logger.info("Click on Verify Otp BD User");
            bdUser.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available BD User");
            bdUser.clickonworkspace();
            logger.info("Click on Workspace Sidebar BD User");
            bdUser.clickMyWorkspace();
            logger.info("Click on Workspace BD User");
            bdUser.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available BD User");
            bdUser.headerCheckbox();
            logger.info("Click on Select all Checkbox BD User");
            bdUser.exportClick();
            logger.info("Click on Export BD User");
            logger.info("Bd user Download Initiated");
            bdUser.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back BD User");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }

}
