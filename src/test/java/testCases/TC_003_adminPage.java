package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.adminPage;

public class TC_003_adminPage extends BaseClass{
    @Test
    public void adminAccount() {
        logger.info("Started Admin Account Test Class");
        try {
            adminPage ad = new adminPage(driver);
            ad.setUserName(p.getProperty("AdminUserName"));
            logger.info("Added Admin User Name");
            ad.setPassword(p.getProperty("Password"));
            logger.info("Added Admin Password");
            ad.setClickOnsignUp();
            logger.info("Click on Signup Admin");
            ad.otpGenerate();
            logger.info("Click on Generate otp Admin");
            ad.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP Admin");
            ad.VerifyOtp();
            logger.info("Click on Verify Otp Admin");
            ad.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available Admin");
            ad.clickonworkspace();
            logger.info("Click on Workspace Sidebar Admin");
            ad.clickMyWorkspace();
            logger.info("Click on Workspace Admin");
            ad.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available Admin");
            ad.headerCheckbox();
            logger.info("Click on Select all Checkbox Admin");
            ad.exportClick();
            logger.info("Click on Export Admin");
            logger.info("Admin Download Initiated");
            ad.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back Admin");
        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
