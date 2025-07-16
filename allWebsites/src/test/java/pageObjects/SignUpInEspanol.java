package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpInEspanol extends BasePage {
    public SignUpInEspanol(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath = "//select[@id='chooseLang']")WebElement languagedrpEspanol;
    @FindBy(xpath = "//a[normalize-space()='Regístrate ahora']")WebElement clickOnRegister;
    @FindBy(xpath = "//input[@id='First_Name']")WebElement inputName;
    @FindBy(xpath = "//input[@id='Last_Name']")WebElement lastName;
    @FindBy(xpath = "//input[@id='Email_id']")WebElement email;
    @FindBy(xpath = "//input[@id='Mobile_no']")WebElement mobileNumber;
    @FindBy(xpath = "//input[@id='Company_Name']")WebElement companyName;
    @FindBy(xpath = "//input[@id='Signin']")WebElement ClickSignUp;
    @FindBy(xpath = "//div[@id='swal2-content']")WebElement conetntmsgSuccesfull;
    @FindBy(xpath = "//button[normalize-space()='OK']")WebElement clickOnOk;


    public void selectLanguageEspanol() {
        languagedrpEspanol.click();
        Select select = new Select(languagedrpEspanol);
        select.selectByVisibleText("Español");  // Case-sensitive match
    }
    public void register(){
        clickOnRegister.click();
    }
    public void setInputName(String firstname) {
        inputName.sendKeys(firstname);
    }

    public void setLastName(String lastNameSignUp) {
        lastName.sendKeys(lastNameSignUp);
    }

    public void setEmail(String eamilSignUp) {
        email.sendKeys(eamilSignUp);
    }

    public void setMobileNumber(String mobNumber) {
        mobileNumber.sendKeys(mobNumber);
    }

    public void setCompanyName(String companyNameSignUp) {
        companyName.sendKeys(companyNameSignUp);
    }
    public void setClickSignUp() {
        ClickSignUp.click();
    }

    public String getConetntmsgSuccesfull() {
        try{
            return(conetntmsgSuccesfull.getText());
        } catch (Exception e) {
            return (e.getMessage());
        }
    }

    public void setClickOnOk() {
        clickOnOk.click();
    }
}
