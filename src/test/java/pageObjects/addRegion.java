package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class addRegion extends BasePage {
    public addRegion(WebDriver driver) {
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
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/i[1]")WebElement cancelClick;
    @FindBy(xpath = "//span[normalize-space()='User Mangement']")WebElement userManagenmentClick;
    @FindBy(xpath = "//span[normalize-space()='Region']")WebElement clickOnRegion;
    @FindBy(xpath = "//div[@class='btn btn-primary d-flex align-items-center']")WebElement clickAddRegion;
    @FindBy(xpath = "//input[@placeholder='Enter Region Name']")WebElement inputRegionName;
    @FindBy(xpath = "//button[normalize-space()='Save']")WebElement clickSaveRegion;
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

    public void cancelClick() {
        cancelClick.click();
    }

    public void userManagenmentClick() {
        userManagenmentClick.click();
    }

    public void clickOnRegion() {
        clickOnRegion.click();
    }

    public void clickAddRegion() {
        clickAddRegion.click();
    }

    public void inputRegionName(String regionName) {
        inputRegionName.sendKeys(regionName);
    }

    public void clickSaveRegion() {
        clickSaveRegion.click();
    }

    public boolean isRegionPresentAcrossPages(String targetRegionName) {
        while (true) {
            List<WebElement> regionCells = driver.findElements(
                    By.xpath("//table[@class='table datatable dataTable no-footer']//tbody//tr//td[2]"));

            for (WebElement cell : regionCells) {
                if (cell.getText().trim().equalsIgnoreCase(targetRegionName)) {
                    return true; // Region found
                }
            }

            // Check if the next button is disabled (pagination end)
            List<WebElement> nextDisabled = driver.findElements(
                    By.xpath("//li[contains(@class, 'paginate_button') and contains(@class, 'disabled') and .//i[@class='ti ti-chevron-right']]"));

            if (!nextDisabled.isEmpty()) {
                break; // Exit loop if pagination ends
            }

            // Otherwise, click on Next page
            WebElement nextBtn = driver.findElement(By.xpath("//li[contains(@class, 'paginate_button') and .//i[@class='ti ti-chevron-right']]"));
            nextBtn.click();
            try {
                Thread.sleep(800); // Suggest replacing with WebDriverWait
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return false; // Region not found after checking all pages
    }

}
