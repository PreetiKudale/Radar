package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_001_LoginPage extends BaseClass {

    @Test
    public void verify_Account() {
        try {
            LoginPage lp = new LoginPage(driver);
            lp.setUserName(p.getProperty("userName"));
            lp.setPassword(p.getProperty("livePassword"));
            lp.setClickOnsignUp();
            logger.info("Login to vyay.live Application");

        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }

}
