package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class collectionHead extends BasePage{
    public collectionHead(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[normalize-space()='Sign In']")WebElement ClickOnsignUp;
    @FindBy(xpath = "//button[normalize-space()='Generate OTP']")WebElement generateOtp;
    @FindBy(xpath = "//input[@name='otp']")WebElement otp;
    @FindBy(xpath = "//button[normalize-space()='Verify OTP']")WebElement verifyOTP;
    public void setUserName(String username){
        userName.sendKeys(username);
    }
    public void setPassword(String Password) {
        password.sendKeys(Password);
    }
    public void setClickOnsignUp() { ClickOnsignUp.click(); }
    public void otpGenerate(){ generateOtp.click(); }
    public void otpinput(String otpNo){ otp.sendKeys(otpNo);}
    public void VerifyOtp() {verifyOTP.click();
    }
}
