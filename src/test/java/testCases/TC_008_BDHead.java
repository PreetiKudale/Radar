package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.BDHead;

public class TC_008_BDHead extends BaseClass{
    @Test
    public void BDHeadAccount() {
        logger.info("Started BD Head Account Test Class");
        try {
            BDHead bd = new BDHead(driver);
            bd.setUserName(p.getProperty("BDHeadUserName"));
            logger.info("Added BD Head User Name");
            bd.setPassword(p.getProperty("Password"));
            logger.info("Added BD Head Password");
            bd.setClickOnsignUp();
            logger.info("Click on Signup BD Head");
            bd.otpGenerate();
            logger.info("Click on Generate otp BD Head");
            bd.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP BD Head");
            bd.VerifyOtp();
            logger.info("Click on Verify Otp BD Head");
            bd.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available BD Head");
            bd.clickonworkspace();
            logger.info("Click on Workspace Sidebar BD Head");
            bd.clickMyWorkspace();
            logger.info("Click on Workspace BD Head");
            bd.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available BD Head");
            bd.headerCheckbox();
            logger.info("Click on Select all Checkbox BD Head");
            bd.exportClick();
            logger.info("Click on Export BD Head");
            logger.info("BD Head Download Initiated");
            bd.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back BD Head");
        } catch (SkipException e) {
            throw e; // Let TestNG mark it as skipped
        } catch (Exception e) {
            logger.error("Test Failed", e);
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
