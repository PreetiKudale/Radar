package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.addTeam;

public class TC_019_newTeam extends BaseClass{
    @Test
    public void newTeamCreation() {
        try {
            addTeam addTeam = new addTeam(driver);
            addTeam.setUserName(p.getProperty("SuperAdminuserName"));
            addTeam.setPassword(p.getProperty("Password"));
            addTeam.setClickOnsignUp();
            addTeam.otpGenerate();
            addTeam.otpinput(p.getProperty("OTP"));
            addTeam.VerifyOtp();
            addTeam.cancelClick();
            addTeam.userManagenmentClick();
            addTeam.clickOnTeamSidebar();

            String teamName = p.getProperty("NewTeam");

            if (!addTeam.isTeamPresentAcrossPages(teamName)) {
                addTeam.clickOnAddTeam();
                addTeam.inputTeamName(teamName);
                addTeam.clickOnSave();
                logger.info("✅ New team added: " + teamName);
            } else {
                logger.info("ℹ️ Team already exists: " + teamName);
            }

        } catch (Exception e) {
            logger.error("❌ Error in newuserCreation test: " + e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }
}
