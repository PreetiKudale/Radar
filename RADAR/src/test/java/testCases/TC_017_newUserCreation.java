package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.newUserCreation;

public class TC_017_newUserCreation extends BaseClass {
    @Test
    public void newuserCreation() {
        try {
            newUserCreation newUserCreation = new newUserCreation(driver);
            newUserCreation.setUserName(p.getProperty("SuperAdminuserName"));
            newUserCreation.setPassword(p.getProperty("Password"));
            newUserCreation.setClickOnsignUp();
            newUserCreation.otpGenerate();
            newUserCreation.otpinput(p.getProperty("OTP"));
            newUserCreation.VerifyOtp();
            newUserCreation.cancelClick();
            newUserCreation.userManagenmentClick();
            newUserCreation.AllUserClick();
            newUserCreation.selectRowsperPage("300"); // new method to select max rows

            String targetUsername = p.getProperty("UserName");

            if (!newUserCreation.isUsernamePresent(targetUsername)) {
                newUserCreation.addUserClick();
                newUserCreation.firstName(p.getProperty("Firstname"));
                newUserCreation.lastName(p.getProperty("LastName"));
                newUserCreation.age(p.getProperty("Age"));
                newUserCreation.email(p.getProperty("Email"));
                newUserCreation.UserName(targetUsername);
                newUserCreation.inputpassword(p.getProperty("Password"));
                newUserCreation.selectDesignation(p.getProperty("designation"));
                newUserCreation.mobileInput(p.getProperty("MobileNo"));
                newUserCreation.selectRole(p.getProperty("role"));
                newUserCreation.selectRegion(p.getProperty("region"));
                newUserCreation.selectTeam(p.getProperty("Team"));
                newUserCreation.saveClick();
                logger.info("✅ New user created: " + targetUsername);
            } else {
                logger.info("ℹ️ Username already exists: " + targetUsername);
            }

        } catch (Exception e) {
            logger.error("❌ Test Failed", e);
            Assert.fail(e.getMessage());
        }
    }

}
