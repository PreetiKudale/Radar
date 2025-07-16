package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

public class addTeam extends BasePage {
    public addTeam(WebDriver driver) {
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
    WebElement cancelClick;
    @FindBy(xpath = "//span[normalize-space()='User Mangement']")
    WebElement userManagenmentClick;
    @FindBy(xpath = "//span[normalize-space()='Team']")
    WebElement clickonTeam;
    @FindBy(xpath = "//div[@class='btn btn-primary d-flex align-items-center']")
    WebElement clickonAddTeam;
    @FindBy(xpath = "//input[@placeholder='Enter team name']")
    WebElement addTeamName;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement clickSave;

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

    public void clickOnTeamSidebar() {
        clickonTeam.click();
    }

    public void clickOnAddTeam() {
        clickonAddTeam.click();
    }

    public void inputTeamName(String teamName) {
        addTeamName.sendKeys(teamName);
    }

    public void clickOnSave() {
        clickSave.click();
    }
    public boolean isTeamPresentAcrossPages(String targetTeamName) {
        boolean found = false;

        while (true) {
            List<WebElement> teamCells = driver.findElements(
                    By.xpath("//table[@class='table datatable dataTable no-footer']//tbody//tr//td[2]"));

            for (WebElement cell : teamCells) {
                if (cell.getText().trim().equalsIgnoreCase(targetTeamName)) {
                    return true; // Team already exists
                }
            }

            List<WebElement> nextDisabled = driver.findElements(
                    By.xpath("//li[contains(@class, 'paginate_button') and contains(@class, 'disabled') and .//i[@class='ti ti-chevron-right']]"));

            if (!nextDisabled.isEmpty()) {
                break;
            }

            WebElement nextBtn = driver.findElement(
                    By.xpath("//li[contains(@class, 'paginate_button') and .//i[@class='ti ti-chevron-right']]"));
            nextBtn.click();

            try {
                Thread.sleep(800); // Optional: Use WebDriverWait for robustness
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return false;
    }
}
