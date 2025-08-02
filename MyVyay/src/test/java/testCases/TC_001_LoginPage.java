package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import java.time.Duration;

public class TC_001_LoginPage extends BaseClass {

    @Test
    public void verify_Account() {
        try {
            LoginPage lp = new LoginPage(driver);
            lp.setUserName(p.getProperty("userName"));
            lp.setPassword(p.getProperty("livePassword"));
            lp.setClickOnsignUp();
            logger.info("Login attempted on vyay.live");

        } catch (Exception e) {
            logger.error("Login test failed with exception: ", e);
            Assert.fail("Login test failed: " + e.getMessage());
        }
    }
}
