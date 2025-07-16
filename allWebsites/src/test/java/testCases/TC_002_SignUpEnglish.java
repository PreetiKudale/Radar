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
        sp.setInputName("Preeti");
        sp.setLastName("Automation");
        sp.setEmail("preeti.test1@botmaticsolution.in");
        sp.setMobileNumber(randomNumber());
        sp.setCompanyName("Automation Test Company");
        sp.setClickSignUp();
        String confirmationMsg = sp.getConetntmsgSuccesfull();
        Assert.assertEquals(confirmationMsg, "Email sent successfully");
        sp.setClickOnOk();
    }
}
