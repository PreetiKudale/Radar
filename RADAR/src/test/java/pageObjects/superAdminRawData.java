package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class superAdminRawData extends BasePage {
    public superAdminRawData(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    WebElement ClickOnsignUp;
    @FindBy(xpath = "//button[normalize-space()='Generate OTP']")
    WebElement generateOtp;
    @FindBy(xpath = "//input[@name='otp']")
    WebElement otp;
    @FindBy(xpath = "//button[normalize-space()='Verify OTP']")
    WebElement verifyOTP;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/i[1]")
    WebElement pwdPopUpcancelClick;
    @FindBy(xpath = "//span[normalize-space()='My Files']")
    WebElement clickAllFiles;
    @FindBy(xpath = "//span[normalize-space()='Raw Data']")
    WebElement clickOnRawData;
    @FindBy(xpath = "//a[contains(@class,'dropdown-toggle') and contains(.,'Export')]")
    WebElement exportButton;
    @FindBy(xpath = "//a[normalize-space()='Download Template']")
    WebElement exportTemplateOption;

    public void setUserName(String username) {
        userName.sendKeys(username);
    }

    public void setPassword(String Password) {
        password.sendKeys(Password);
    }

    public void setClickOnsignUp() {
        ClickOnsignUp.click();
    }

    public void otpGenerate() {
        generateOtp.click();
    }

    public void otpinput(String otpNo) {
        otp.sendKeys(otpNo);
    }

    public void VerifyOtp() {
        verifyOTP.click();
    }

    public void passwordPopUpcancelClick() {
        pwdPopUpcancelClick.click();
    }

    public void clickAllFiles() {
        clickAllFiles.click();
    }

    public void clickOnRawData() {
        clickOnRawData.click();
    }

    public void exportClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement exportBtn = wait.until(ExpectedConditions.elementToBeClickable(exportButton));
        exportBtn.click();
        WebElement exportTemplateExcel = wait.until(ExpectedConditions.elementToBeClickable(exportTemplateOption));
        exportTemplateExcel.click();

        }

    }
