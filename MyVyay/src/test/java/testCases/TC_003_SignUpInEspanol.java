package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SignUpInEspanol;

public class TC_003_SignUpInEspanol extends BaseClass {
    @Test
    public void signUpInSpanisg() {
        logger.info("Sign Up with Spanish Language");
        SignUpInEspanol sie = new SignUpInEspanol(driver);
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%'");
        sie.selectLanguageEspanol();
        sie.register();
        sie.setInputName("Preeti");
        sie.setLastName("Automation");
        sie.setEmail("preeti.test1@botmaticsolution.in");
        sie.setMobileNumber(randomNumber());
        sie.setCompanyName("Automation Test Company");
        sie.setClickSignUp();
        String confirmationMsg = sie.getConetntmsgSuccesfull();
        Assert.assertEquals(confirmationMsg, "Correo electronico enviado con exito");
        sie.setClickOnOk();
    }
    }