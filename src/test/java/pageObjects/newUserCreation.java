package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class newUserCreation extends BasePage {
    public newUserCreation(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='username']")    WebElement userName;
    @FindBy(xpath = "//input[@name='password']")    WebElement password;
    @FindBy(xpath = "//button[normalize-space()='Sign In']")    WebElement ClickOnsignUp;
    @FindBy(xpath = "//button[normalize-space()='Generate OTP']")    WebElement generateOtp;
    @FindBy(xpath = "//input[@name='otp']")    WebElement otp;
    @FindBy(xpath = "//button[normalize-space()='Verify OTP']")    WebElement verifyOTP;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/i[1]")WebElement cancelClick;
    @FindBy(xpath = "//span[normalize-space()='User Mangement']")WebElement userManagenmentClick;
    @FindBy(xpath = "//span[normalize-space()='All User']")    WebElement allUserClick;
    @FindBy(xpath = "//select[@name='rowsPerPage']")WebElement selectRowsPerPage;
    @FindBy(xpath = "//div[@class='btn btn-primary d-flex align-items-center']")WebElement addUserClick;
    @FindBy(xpath = "//input[@name='firstName']")WebElement firstName;
    @FindBy(xpath = "//input[@name='lastName']")WebElement lastName;
    @FindBy(xpath = "//input[@name='age']")WebElement inputage;
    @FindBy(xpath = "//input[@name='email']")WebElement inputEmail;
    @FindBy(xpath = "//input[@name='userName']")WebElement inputUserName;
    @FindBy(xpath = "//input[@name='password']")WebElement InputPassword;
    @FindBy(xpath = "(//*[name()='svg'][@class='css-8mmkcg'])[1]")
    WebElement designationDropdown;
    @FindBy(xpath = "//div[contains(@class,'select__option')]")
    List<WebElement> dropdownOptions;
    @FindBy(xpath = "//input[@name='mobile_No']")WebElement inputMobileNo;
    @FindBy(xpath = "(//*[name()='svg'][@class='css-8mmkcg'])[2]")
    WebElement roleDropdown;
    @FindBy(xpath = "(//*[name()='svg'][@class='css-8mmkcg'])[3]")
    WebElement regionDropdown;
    @FindBy(xpath = "(//*[name()='svg'][@class='css-8mmkcg'])[4]")
    WebElement teamDropdown;
    @FindBy(xpath = "//button[normalize-space()='Save']")WebElement clickSave;
   // @FindBy(xpath = "//button[normalize-space()='Cancel']")WebElement canceluserClick;
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
    public void cancelClick(){cancelClick.click();}
public void userManagenmentClick(){userManagenmentClick.click();}
    public void AllUserClick() {
        allUserClick.click();
    }
    public void selectRowsperPage(String visibleText) {
        Select select = new Select(selectRowsPerPage);
        select.selectByVisibleText(visibleText);
    }
    public void addUserClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the bell icon disappears (if it's a popup or toast)
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("i.ti.ti-bell")));
        } catch (TimeoutException e) {
            System.out.println("Bell icon didn't disappear. Trying JavaScript click as fallback.");
        }

        // Scroll the button into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addUserClick);

        // Wait until the button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(addUserClick));

        // Use JavaScript click (bypasses interception issues)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addUserClick);
    }
public void firstName(String fname){firstName.sendKeys(fname);}

    public void lastName(String lname){lastName.sendKeys(lname);}
    public void age(String age){inputage.sendKeys(age);}
    public void email(String email){inputEmail.sendKeys(email);}
    public void UserName(String userId){inputUserName.sendKeys(userId);}
    public void inputpassword(String pwd){InputPassword.sendKeys(pwd);}
    public void selectDesignation(String designationValue) {
        designationDropdown.click();  // Open dropdown
        for (WebElement option : dropdownOptions) {
            if (option.getText().trim().equalsIgnoreCase(designationValue)) {
                option.click();
                break;
            }
        }
    }
    public void mobileInput(String mobileNo) {
        if (mobileNo.matches("\\d{10}")) {  // Exactly 10 digits, all numbers
            inputMobileNo.sendKeys(mobileNo);
        } else {
            throw new IllegalArgumentException("Invalid Mobile Number: " + mobileNo);
        }
    }
        public void selectRole(String roleValue) {
            roleDropdown.click();  // Open dropdown
            for (WebElement option : dropdownOptions) {
                if (option.getText().trim().equalsIgnoreCase(roleValue)) {
                    option.click();
                    break;
                }
            }
        }
        public void selectRegion(String regionValue) {
            regionDropdown.click();  // Open dropdown
            for (WebElement option : dropdownOptions) {
                if (option.getText().trim().equalsIgnoreCase(regionValue)) {
                    option.click();
                    break;
                }
            }
        }
        public void selectTeam(String teamValue) {
            teamDropdown.click();  // Open dropdown
            for (WebElement option : dropdownOptions) {
                if (option.getText().trim().equalsIgnoreCase(teamValue)) {
                    option.click();
                    break;
                }
            }
        }
public  void saveClick(){clickSave.click();}
    public boolean isUsernamePresent(String targetUsername) {
        // Set Rows Per Page to 300
        Select select = new Select(selectRowsPerPage);
        select.selectByVisibleText("300");

        // Scroll to bottom using JavaScript to load all users (if lazy-loaded)
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        List<WebElement> usernameCells = driver.findElements(
                By.xpath("//table[@class='table datatable dataTable no-footer']//tbody//td[8]"));

        for (WebElement cell : usernameCells) {
            if (cell.getText().trim().equalsIgnoreCase(targetUsername)) {
                return true; // Username already exists
            }
        }
        return false;
    }

}