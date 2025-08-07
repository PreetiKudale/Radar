package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.collectionHead;

public class TC_010_collectionHead extends BaseClass{
    @Test
    public void opsHeadAccount() {
        try {
            collectionHead collection = new collectionHead(driver);
            collection.setUserName(p.getProperty("CollectionHeadUserName"));
            collection.setPassword(p.getProperty("Password"));
            collection.setClickOnsignUp();
            collection.otpGenerate();
            collection.enterOtp(p.getProperty("OTP"));
            collection.VerifyOtp();
            collection.clickCancelpopup();
            collection.clickonworkspace();
            collection.clickMyWorkspace();
            collection.setSelectRowsPerPage();
            collection.headerCheckbox();
            collection.exportClick();
            collection.clickCancelpopupagain();
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
