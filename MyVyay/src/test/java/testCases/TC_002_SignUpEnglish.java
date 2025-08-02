package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SignUpEnglish;

public class TC_002_SignUpEnglish extends BaseClass{
    @Test
    public void signUpAccount() {
        logger.info("Sign Up with English Language");
    SignUpEnglish sp = new SignUpEnglish(driver);
       sp.setLanguagedrpEnglish();
       ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%'");
        sp.setSignUpLink();
        sp.setInputName(p.getProperty("InputName"));
        sp.setLastName(p.getProperty("LastName"));
        sp.setEmail(p.getProperty("Email"));
        sp.setMobileNumber(randomNumber());
        sp.setCompanyName(p.getProperty("CompanyName"));
        sp.setClickSignUp();
        String confirmationMsg = sp.getConetntmsgSuccesfull();
        Assert.assertEquals(confirmationMsg, "Email sent successfully");
        sp.setClickOnOk();
    }
}
