package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.DCUser;

public class TC_012_DCUser extends BaseClass{
    @Test
    public void dcUserAccount() {
        logger.info("Started Data Cleaning User Account Test Class");
        try {
            DCUser dcUser = new DCUser(driver);
            dcUser.setUserName(p.getProperty("DcUserName"));
            logger.info("Added Data Cleaning User Name");
            dcUser.setPassword(p.getProperty("Password"));
            logger.info("Added Data Cleaning Password");
            dcUser.setClickOnsignUp();
            logger.info("Click on Signup Data Cleaning User");
            dcUser.otpGenerate();
            logger.info("Click on Generate otp Data Cleaning User");
            dcUser.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP Data Cleaning User");
            dcUser.VerifyOtp();
            logger.info("Click on Verify Otp Data Cleaning User");
            dcUser.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available Data Cleaning User");
            dcUser.clickonworkspace();
            logger.info("Click on Workspace Sidebar Data Cleaning User");
            dcUser.clickMyWorkspace();
            logger.info("Click on Workspace Data Cleaning User");
            dcUser.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available Data Cleaning User");
            dcUser.headerCheckbox();
            logger.info("Click on Select all Checkbox Data Cleaning User");
            dcUser.exportClick();
            logger.info("Click on Export Data Cleaning User");
            logger.info(" Data Cleaning User Download Initiated");
            dcUser.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back Data Cleaning User");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
