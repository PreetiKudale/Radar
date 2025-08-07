package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.dataCleaningHead;

public class TC_005_dataCleaningHead extends BaseClass{
    @Test
    public void dcHeadAccount() {
        try {
            dataCleaningHead dc = new dataCleaningHead(driver);
            dc.setUserName(p.getProperty("DCHeadUserName"));
            dc.setPassword(p.getProperty("Password"));
            dc.setClickOnsignUp();
            dc.otpGenerate();
            dc.enterOtp(p.getProperty("OTP"));
            dc.VerifyOtp();
            dc.clickCancelpopup();
            dc.clickonworkspace();
            dc.clickMyWorkspace();
            dc.setSelectRowsPerPage();
            dc.headerCheckbox();
            dc.exportClick();
            dc.clickCancelpopupagain();
            logger.info("Login to Radar Application");

        } catch (SkipException e) {
            throw e;  // Don't catch this — let TestNG treat it as skipped
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }

}
