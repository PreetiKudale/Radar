package allWebsites;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class myVyayCom extends baseClass {

    @Test(priority = 1)
    public void validateDashboardMenusAndContactForm() {
        logger.info("Validate myVyayCom");
        driver.get("https://myvyay.com/");
        System.out.println("Opened myvaya.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement rejectButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Reject All') or contains(text(),'Reject all')]")));
            rejectButton.click();
            System.out.println("Rejected cookies successfully.");
        } catch (TimeoutException e) {
            System.out.println("No cookie banner appeared.");
        }

        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Botmatic Solution") || actualTitle.contains("1 new message")) {
            System.out.println("Home page title is correct: " + actualTitle);
        } else {
            System.out.println("Home page title validation failed. Found: " + actualTitle);
        }
    }

    @Test(priority = 2)
    public void validateProductLinks() {
        logger.info("Validate Product Link");
        Actions actions = new Actions(driver);
        WebElement productMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Product']")));
        actions.moveToElement(productMenu).perform();

        /*List<WebElement> productLinks = driver.findElements(By.xpath("//a[contains(@href,'/product')]"));
        for (WebElement link : productLinks) {
            Assert.assertTrue(link.isDisplayed(), "Link is not visible: " + link.getText());
            Assert.assertTrue(link.isEnabled(), "Link is not clickable: " + link.getText());
            System.out.println("Product Link Validated: " + link.getText());
        }*/
    }

    @Test(priority = 3)
    public void validateServicesClickable() {
        logger.info("Validate Service Link myVyayCom");
        WebElement services = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Services']")));
        services.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("services"), "Services page did not open properly");
    }

    @Test(priority = 4)
    public void validateResourcesLinks() {
        logger.info("Validate Resource link myVyayCom");
        Actions actions = new Actions(driver);
        WebElement resourcesMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Resources']")));
        actions.moveToElement(resourcesMenu).perform();

        List<WebElement> resourceLinks = driver.findElements(By.xpath("//a[contains(@href,'/resources')]"));
        for (WebElement link : resourceLinks) {
            Assert.assertTrue(link.isDisplayed(), "Resource link not visible: " + link.getText());
            Assert.assertTrue(link.isEnabled(), "Resource link not clickable: " + link.getText());
            System.out.println("Resource Link Validated: " + link.getText());
        }
    }

    @Test(priority = 5)
    public void validateAboutUsClickable() {
        logger.info("Validate About Us myVyayCom");
        WebElement aboutUs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='About Us']")));
        aboutUs.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("about"), "About Us page did not open properly");
    }

    @Test(priority = 6)
    public void fillContactFormAndValidate() throws InterruptedException {
        logger.info("Validate Contact form myVyayCom");
        WebElement contactUs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Contact Us']")));
        contactUs.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='form_fields[name]']"))).sendKeys("Preeti k");
        driver.findElement(By.xpath("//input[@name='form_fields[email]']")).sendKeys("preet@example.com");
        driver.findElement(By.xpath("//input[@name='form_fields[field_a967fea]']")).sendKeys("9999999999");
        driver.findElement(By.xpath("//input[@name='form_fields[field_e44e24b]']")).sendKeys("Company Name");
        driver.findElement(By.xpath("//textarea[@name='form_fields[message]']")).sendKeys("This is a test message.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'successful')]")));
        Assert.assertTrue(successMessage.isDisplayed(), "Your submission was successful");
        driver.navigate().back();
    }
}

