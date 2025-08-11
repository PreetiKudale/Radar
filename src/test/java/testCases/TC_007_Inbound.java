package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.inbound;

public class TC_007_Inbound extends BaseClass{
    @Test
    public void inboundAccount() {
        logger.info("Started Inbound Account Test Class");
        try {
            inbound inbound = new inbound(driver);
            inbound.setUserName(p.getProperty("InboundUserName"));
            logger.info("Added Inbound Head User Name");
            inbound.setPassword(p.getProperty("Password"));
            logger.info("Added Inbound Head Password");
            inbound.setClickOnsignUp();
            logger.info("Click on Signup Inbound Head");
            inbound.otpGenerate();
            logger.info("Click on Generate otp Inbound Head");
            inbound.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP Inbound Head");
            inbound.VerifyOtp();
            logger.info("Click on Verify Otp Inbound Head");
            inbound.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available Inbound Head");
            inbound.clickonworkspace();
            logger.info("Click on Workspace Sidebar Inbound Head");
            inbound.clickMyWorkspace();
            logger.info("Click on Workspace Inbound Head");
            inbound.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available Inbound Head");
            inbound.headerCheckbox();
            logger.info("Click on Select all Checkbox Inbound Head");
            inbound.exportClick();
            logger.info("Click on Export Inbound Head");
            logger.info("Inbound Head Download Initiated");
            inbound.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back Inbound Head");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
    }

