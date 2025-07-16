package testCases;

import org.testng.Assert;
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
            lp.passwordPopUpcancelClick();
            lp.clickAllFiles();
            lp.clickOnRawData();
            lp.setSelectRowsPerPage();
            lp.headerCheckbox();
            lp.exportClick();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
        logger.error("Test Failed", e); // Log the actual exception
        Assert.fail("Test case failed due to exception: " + e.getMessage());
    }
    }

}
