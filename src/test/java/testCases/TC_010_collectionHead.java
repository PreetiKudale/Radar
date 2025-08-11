package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.collectionHead;

public class TC_010_collectionHead extends BaseClass{
    @Test
    public void CollectionHeadAccount() {
        logger.info("Started Collection Head Account Test Class");
        try {
            collectionHead collection = new collectionHead(driver);
            collection.setUserName(p.getProperty("CollectionHeadUserName"));
            logger.info("Added collection Head User Name");
            collection.setPassword(p.getProperty("Password"));
            logger.info("Added collection Head Password");
            collection.setClickOnsignUp();
            logger.info("Click on Signup collection Head");
            collection.otpGenerate();
            logger.info("Click on Generate otp collection Head");
            collection.enterOtp(p.getProperty("OTP"));
            logger.info("Entered OTP collection Head");
            collection.VerifyOtp();
            logger.info("Click on Verify Otp collection Head");
            collection.clickCancelpopup();
            logger.info("Click on CancelPopup after Login if popup available collection Head");
            collection.clickonworkspace();
            logger.info("Click on Workspace Sidebar collection Head");
            collection.clickMyWorkspace();
            logger.info("Click on Workspace collection Head");
            collection.setSelectRowsPerPage();
            logger.info("Click on Rows Per Page if available collection Head");
            collection.headerCheckbox();
            logger.info("Click on Select all Checkbox collection Head");
            collection.exportClick();
            logger.info("Click on Export collection Head");
            logger.info("Collection Head Download Initiated");
            collection.clickCancelpopupagain();
            logger.info("Click on Cancel popup after file exported and click on back collection Head");

        } catch (SkipException e) {
            throw e; // Let TestNG mark it as skipped
        } catch (Exception e) {
            logger.error("Test Failed", e);
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }
}
