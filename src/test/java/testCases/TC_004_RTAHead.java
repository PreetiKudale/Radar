package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.RTAHead;

public class TC_004_RTAHead extends BaseClass{
    @Test
    public void rtaHeadAccount() {
        logger.info("Started RTAHead Account Test Class");
        try {
            RTAHead rta = new RTAHead(driver);
            rta.setUserName(p.getProperty("RTAHeadUserName"));
            logger.info("Added RTA Head User Name");
            rta.setPassword(p.getProperty("Password"));
            logger.info("Added RTA Head Password");
            rta.setClickOnsignUp();
            logger.info("Click on Signup RTA Head");
            rta.otpGenerate();
            logger.info("Click on Generate otp RTA Head");
            rta.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP RTA Head");
            rta.VerifyOtp();
            logger.info("Click on Verify Otp RTA Head");
            rta.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available RTA Head");
            rta.clickonworkspace();
            logger.info("Click on Workspace Sidebar RTA Head");
            rta.clickMyWorkspace();
            logger.info("Click on Workspace RTA Head");
            rta.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available RTA Head");
            rta.headerCheckbox();
            logger.info("Click on Select all Checkbox RTA Head");
            rta.exportClick();
            logger.info("Click on Export RTA Head");
            logger.info("RTA Download Initiated");
            rta.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back RTA Head");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
