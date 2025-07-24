package testCases;

import org.testng.Assert;
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
            dc.otpinput(p.getProperty("OTP"));
            dc.VerifyOtp();
            dc.clickCancelpopup();
            dc.clickonworkspace();
            dc.clickMyWorkspace();
            dc.setSelectRowsPerPage();
            dc.headerCheckbox();
            dc.exportClick();
            dc.clickCancelpopupagain();
            logger.info("Login to Radar Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }

}
