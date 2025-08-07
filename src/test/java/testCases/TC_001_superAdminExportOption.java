package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.superAdminExport;

public class TC_001_superAdminExportOption extends BaseClass {

    @Test
    public void verify_Account() {
        try {
            superAdminExport lp = new superAdminExport(driver);
            lp.setUserName(p.getProperty("SuperAdminuserName"));
            lp.setPassword(p.getProperty("Password"));
            lp.setClickOnsignUp();
            lp.otpGenerate();
            lp.otpinput(p.getProperty("OTP"));
            lp.VerifyOtp();
            lp.clickCancelpopup();
            lp.clickAllFiles();
            lp.clickOnRawData();
            lp.setSelectRowsPerPage();
            lp.headerCheckbox();
            lp.exportClick();
            lp.clickCancelpopupagain();
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
