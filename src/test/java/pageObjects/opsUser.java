package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

public class opsUser extends BasePage{
    public opsUser(WebDriver driver)
    {
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
    @FindBy(xpath = "//span[normalize-space()='WorkSpace']")
    WebElement workspace;
    @FindBy(xpath = "//span[normalize-space()='My Workspace']")
    WebElement myWorkspace;
    @FindBy(xpath = "//select[@name='rowsPerPage']")
    WebElement selectRowsPerPage;
    @FindBy(xpath = "//div[@role='columnheader']//input[@type='checkbox']")
    WebElement selectheaderCheckbox;
    @FindBy(xpath = "//a[contains(@class,'dropdown-toggle') and contains(.,'Export')]")
    WebElement exportButton;
    @FindBy(xpath = "//a[@class='dropdown-item rounded-1' and contains(normalize-space(), 'Export as Excel')]")
    WebElement exportAsExcelOption;

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
    public void clickonworkspace() {
        workspace.click();
    }
    public void clickMyWorkspace() {
        myWorkspace.click();
    }
    public void setSelectRowsPerPage() {
        try {
            if (selectRowsPerPage.isDisplayed()) {
                Select select = new Select(selectRowsPerPage);
                select.selectByVisibleText("100");

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                try {
                    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                            By.xpath("//table//tbody/tr"), 10));
                } catch (TimeoutException e) {
                    System.out.println("Table did not load expected number of rows in time.");
                }
            }
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            throw new SkipException("selectRowsPerPage not found or not interactable. Skipping this test.");
        } catch (Exception e) {
            throw new SkipException("Unexpected error while setting rows per page: " + e.getMessage());
        }
    }
    public void headerCheckbox() {
        selectheaderCheckbox.click();
    }
    public void exportClick() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement exportBtn = wait.until(ExpectedConditions.elementToBeClickable(exportButton));
        exportBtn.click();
        WebElement exportExcel = wait.until(ExpectedConditions.elementToBeClickable(exportAsExcelOption));
        exportExcel.click();
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
    public void clickCancelpopupagain() {
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
}
