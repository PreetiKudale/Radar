package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.opsHead;

public class TC_009_opsHead extends BaseClass{
    @Test
    public void opsHeadAccount() {
        logger.info("Started Operations Head Account Test Class");
        try {
            opsHead ops = new opsHead(driver);
            ops.setUserName(p.getProperty("opsHeadUserName"));
            logger.info("Added Operations Head User Name");
            ops.setPassword(p.getProperty("Password"));
            logger.info("Added Operations Head Password");
            ops.setClickOnsignUp();
            logger.info("Click on Signup Operations Head");
            ops.otpGenerate();
            logger.info("Click on Generate otp Operations Head");
            ops.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP Operations Head");
            ops.VerifyOtp();
            logger.info("Click on Verify Otp Operations Head");
            ops.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available Operations Head");
            ops.clickonworkspace();
            logger.info("Click on Workspace Sidebar Operations Head");
            ops.clickMyWorkspace();
            logger.info("Click on Workspace Operations Head");
            ops.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available Operations Head");
            ops.headerCheckbox();
            logger.info("Click on Select all Checkbox Operations Head");
            ops.exportClick();
            logger.info("Click on Export Operations Head");
            logger.info(" Ops Head Download Initiated");
            ops.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back Operations Head");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
