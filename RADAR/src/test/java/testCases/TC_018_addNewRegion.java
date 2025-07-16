package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.addRegion;

public class TC_018_addNewRegion extends BaseClass {
    @Test
    public void addRegion() {
        try {
            addRegion addRegion = new addRegion(driver);
            addRegion.setUserName(p.getProperty("SuperAdminuserName"));
            addRegion.setPassword(p.getProperty("Password"));
            addRegion.setClickOnsignUp();
            addRegion.otpGenerate();
            addRegion.otpinput(p.getProperty("OTP"));
            addRegion.VerifyOtp();
            addRegion.cancelClick();
            addRegion.userManagenmentClick();
            addRegion.clickOnRegion();

            String regionName = p.getProperty("RegionName");

            // ✅ Check if region already exists
            if (!addRegion.isRegionPresentAcrossPages(regionName)) {
                addRegion.clickAddRegion();
                addRegion.inputRegionName(regionName);
                addRegion.clickSaveRegion();
                logger.info("✅ New region added: " + regionName);
            } else {
                logger.info("ℹ️ Region already exists: " + regionName);
            }

        } catch (Exception e) {
            logger.error("❌ Error in addRegion test: " + e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }
}