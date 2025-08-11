package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.dvUser;

public class TC_011_DVUser extends BaseClass {
    @Test
    public void dvUserAccount() {
        logger.info("Started Data validation User Account Test Class");
        try {
            dvUser dvUser = new dvUser(driver);
            dvUser.setUserName(p.getProperty("DVUserName"));
            logger.info("Added Data Validation User Name");
            dvUser.setPassword(p.getProperty("Password"));
            logger.info("Added Data Validation Password");
            dvUser.setClickOnsignUp();
            logger.info("Click on Signup Data Validation User");
            dvUser.otpGenerate();
            logger.info("Click on Generate otp Data Validation User");
            dvUser.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP Data Validation User");
            dvUser.VerifyOtp();
            logger.info("Click on Verify Otp Data Validation User");
            dvUser.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available Data Validation User");
            dvUser.clickonworkspace();
            logger.info("Click on Workspace Sidebar Data Validation User");
            dvUser.clickMyWorkspace();
            logger.info("Click on Workspace Data Validation User");
            dvUser.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available Data Validation User");
            dvUser.headerCheckbox();
            logger.info("Click on Select all Checkbox Data Validation User");
            dvUser.exportClick();
            logger.info("Click on Export Data Validation User");
            logger.info("Data Validation User Download Initiated");
            dvUser.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back Data Validation User");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
