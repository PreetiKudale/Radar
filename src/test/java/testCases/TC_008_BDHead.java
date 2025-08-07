package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.BDHead;

public class TC_008_BDHead extends BaseClass{
    @Test
    public void BDHeadAccount() {
        try {
            BDHead bd = new BDHead(driver);
            bd.setUserName(p.getProperty("BDHeadUserName"));
            bd.setPassword(p.getProperty("Password"));
            bd.setClickOnsignUp();
            bd.otpGenerate();
            bd.enterOtp(p.getProperty("OTP"));
            bd.VerifyOtp();
            bd.clickCancelpopup();
            bd.clickonworkspace();
            bd.clickMyWorkspace();
            bd.setSelectRowsPerPage();
            bd.headerCheckbox();
            bd.exportClick();
            bd.clickCancelpopupagain();
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
