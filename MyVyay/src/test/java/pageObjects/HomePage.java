package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver)
    {        super(driver);     }
    @FindBy(xpath = "//i[@class='fas fa-bars']")WebElement clickOnBars;
    @FindBy(xpath = "//body/div[@class='wrapper']/aside[@class='main-sidebar sidebar-dark-primary elevation-4']/div[@class='sidebar os-host os-theme-light os-host-resize-disabled os-host-scrollbar-horizontal-hidden os-host-scrollbar-vertical-hidden os-host-transition']/div[@class='os-padding']/div[@class='os-viewport os-viewport-native-scrollbars-invisible']/div[@class='os-content']/nav[@class='mt-2']/ul[@role='menu']/li[@class='nav-item has-treeview']/a[1]")WebElement clickOnManagement;
    @FindBy(xpath = "//li[@class='nav-item has-treeview menu-open']//li[1]//a[1]")WebElement clcikEmulateUser;
    @FindBy(xpath = "//input[@placeholder='Search...']")WebElement search;
    @FindBy(xpath = "//div[normalize-space()='Test JK Tyre (3)']")WebElement selectJkTyre;
}