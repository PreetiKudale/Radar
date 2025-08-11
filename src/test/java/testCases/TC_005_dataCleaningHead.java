package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.dataCleaningHead;

public class TC_005_dataCleaningHead extends BaseClass{
    @Test
    public void dcHeadAccount() {
        logger.info("Started Data Cleaning Account Test Class");
        try {
            dataCleaningHead dc = new dataCleaningHead(driver);
            dc.setUserName(p.getProperty("DCHeadUserName"));
            logger.info("Added Data Cleaning Head User Name");
            dc.setPassword(p.getProperty("Password"));
            logger.info("Added Data Cleaning Head Password");
            dc.setClickOnsignUp();
            logger.info("Click on Signup Data Cleaning Head");
            dc.otpGenerate();
            logger.info("Click on Generate otp Data Cleaning Head");
            dc.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP Data Cleaning Head");
            dc.VerifyOtp();
            logger.info("Click on Verify Otp Data Cleaning Head");
            dc.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available Data Cleaning Head");
            dc.clickonworkspace();
            logger.info("Click on Workspace Sidebar Data Cleaning Head");
            dc.clickMyWorkspace();
            logger.info("Click on Workspace Data Cleaning Head");
            dc.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available Data Cleaning Head");
            dc.headerCheckbox();
            logger.info("Click on Select all Checkbox Data Cleaning Head");
            dc.exportClick();
            logger.info("Click on Export Data Cleaning Head");
            logger.info("Data Cleaning Head Download Initiated");
            dc.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back Data Cleaning Head");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }

}
