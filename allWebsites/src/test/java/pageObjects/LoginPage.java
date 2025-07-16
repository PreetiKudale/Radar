package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='UserName']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='myInput']")
    WebElement password;
    @FindBy(xpath = "//input[@id='Signin']")WebElement ClickOnsignUp;

    public void setUserName(String username){
        userName.sendKeys(username);
    }
    public void setPassword(String Password) {
        password.sendKeys(Password);
    }
    public void setClickOnsignUp() {
        ClickOnsignUp.click();
    }
}
