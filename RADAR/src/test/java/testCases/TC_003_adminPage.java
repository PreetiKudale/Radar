package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.adminPage;

public class TC_003_adminPage extends BaseClass{
    @Test
    public void adminAccount() {
        try {
            adminPage ad = new adminPage(driver);
            ad.setUserName(p.getProperty("AdminUserName"));
            ad.setPassword(p.getProperty("Password"));
            ad.setClickOnsignUp();
            ad.otpGenerate();
            ad.enterOtp(p.getProperty("OTP"));
            ad.VerifyOtp();
            ad.clickCancelpopup();
            ad.clickonworkspace();
            ad.clickMyWorkspace();
            ad.setSelectRowsPerPage();
            ad.headerCheckbox();
            ad.exportClick();
            ad.clickCancelpopupagain();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }
}
