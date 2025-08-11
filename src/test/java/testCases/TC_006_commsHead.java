package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.commsHead;

public class TC_006_commsHead extends BaseClass {
    @Test
    public void commsHeadAccount() {
        logger.info("Started Communication Account Test Class");
        try {
            commsHead commsHead = new commsHead(driver);
            commsHead.setUserName(p.getProperty("CommsHeadUserName"));
            logger.info("Added Communication Head User Name");
            commsHead.setPassword(p.getProperty("Password"));
            logger.info("Added Communication Head Password");
            commsHead.setClickOnsignUp();
            logger.info("Click on Signup Communication Head");
            commsHead.otpGenerate();
            logger.info("Click on Generate otp Communication Head");
            commsHead.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP Communication Head");
            commsHead.VerifyOtp();
            logger.info("Click on Verify Otp Communication Head");
            commsHead.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available Communication Head");
            commsHead.clickonworkspace();
            logger.info("Click on Workspace Sidebar Communication Head");
            commsHead.clickMyWorkspace();
            logger.info("Click on Workspace Communication Head");
            commsHead.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available Communication Head");
            commsHead.headerCheckbox();
            logger.info("Click on Select all Checkbox Communication Head");
            commsHead.exportClick();
            logger.info("Click on Export Communication Head");
            logger.info("Communication Head Download Initiated");
            commsHead.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back Communication Head");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
