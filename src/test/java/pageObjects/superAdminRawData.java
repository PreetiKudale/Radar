package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.NoSuchElementException;

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
    public void clickCancelpopup() {
        try {
            if (pwdPopUpcancelClick.isDisplayed()) {
                pwdPopUpcancelClick.click();
                Thread.sleep(2000); // Optional pause
            }
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            System.out.println("Cancel popup not found or not clickable. Proceeding with the test.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted while waiting after cancel popup.");
        } catch (Exception e) {
            System.out.println("Unexpected error in clickCancelpopup(): " + e.getMessage());
        }
    }

    public void clickAllFiles() {
        clickAllFiles.click();
    }
    public void clickOnRawData() {
        clickOnRawData.click();
    }
    public void exportClick() throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement exportBtn = wait.until(ExpectedConditions.elementToBeClickable(exportButton));
        exportBtn.click();
        WebElement exportTemplateExcel = wait.until(ExpectedConditions.elementToBeClickable(exportTemplateOption));
        exportTemplateExcel.click();
        driver.get("chrome://downloads/");
        Robot robot = new Robot();
        // Press TAB 3 times
        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        // Press ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(200);

        // Press DOWN arrow
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        // Press ENTER again
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.navigate().back();
    }
    public void clickCanceagain() {
        pwdPopUpcancelClick.click();
    }
        }


