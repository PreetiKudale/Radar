package allWebsites;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class claimMyShares extends baseClass{

    @Test(priority = 1)
    public void openHomePageAndValidateTitle() {
        logger.info("Validate claim My SharesHome Page");
        driver.get("https://claimmyshares.com/");
        WebElement rejectButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Reject All']")));
        rejectButton.click();
        System.out.println("Rejected cookies.");
        String expectedTitle = "CLAIM MY SHARES – money money";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("CLAIM MY SHARES") || actualTitle.contains("1 new message")) {
            System.out.println("Home page title is correct: " + actualTitle);
        } else {
            System.out.println("Home page title validation failed. Found: " + actualTitle);}
    }
    @Test(priority = 2)
    public void validateHomeLinkClickable() {
        logger.info("Validate home link claim My Shares");
        WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='menu-item-1664']//a[@class='menu-link'][normalize-space()='HOME']")));
        Assert.assertTrue(homeLink.isDisplayed() && homeLink.isEnabled(), "Home link not clickable");
        homeLink.click();
    }
    @Test(priority = 3)
    public void validateAboutUsLinkClickable() throws InterruptedException {
        logger.info("Validate About Us in claim My Shares");
        Thread.sleep(3000);
        WebElement aboutUsLink = driver.findElement(By.xpath("//li[@id='menu-item-1992']//a[@class='menu-link'][normalize-space()='ABOUT US']"));
        Assert.assertTrue(aboutUsLink.isDisplayed() || aboutUsLink.isEnabled(), "About Us link not clickable");
        aboutUsLink.click();
    }

    @Test(priority = 4)
    public void validateFAQLinkClickable() {
        logger.info("Validate FAQ Link claim My Shares");
        WebElement faqLink = driver.findElement(By.xpath("//li[@id='menu-item-194']//a[@class='menu-link'][normalize-space()='FAQ']"));
        Assert.assertTrue(faqLink.isDisplayed() || faqLink.isEnabled(), "FAQ link not clickable");
        faqLink.click();
    }

   /* @Test(priority = 6)
    public void validateServicesDropdownOptions() {
        driver.get("https://claimmyshares.com/contact-us-2/#");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Actions actions = new Actions(driver);
        String[][] services = {
                {"Demat of Shares", "//li[@id='menu-item-453']//a[normalize-space()='Demat of Shares']"},
                {"Duplicate Shares", "//li[@id='menu-item-457']//a[normalize-space()='Duplicate Shares']"},
             //   {"Probate", "//li[@id='menu-item-452']//a[normalize-space()='Probate']"},
                {"IEPF", "//li[@id='menu-item-450']//a[normalize-space()='IEPF']"}};
        for (String[] service : services) {
            String serviceName = service[0];
            String serviceXpath = service[1];
            WebElement serviceMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//li[@id='menu-item-946']//a[normalize-space()='SERVICES']")));
            actions.moveToElement(serviceMenu).perform();
            WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(serviceXpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
            actions.moveToElement(link).click().perform();
            try {
                wait.until(ExpectedConditions.or(ExpectedConditions.titleContains(serviceName),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'" + serviceName + "')]"))
                ));
                System.out.println( serviceName + " page opened successfully.");
            } catch (TimeoutException e) {
                System.out.println("Failed to open " + serviceName + " page.");
            }
            driver.navigate().back();
        }
    }*/
    @Test(priority = 5)
    public void fillContactForm() throws InterruptedException {
        logger.info("Validate Contact Form claim My Shares");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%'");
        WebElement contactUsLink = driver.findElement(By.xpath("//li[@id='menu-item-1044']//a[@class='menu-link'][normalize-space()='CONTACT US']"));
        contactUsLink.click();
        Thread.sleep(3000);
        WebElement nameField = driver.findElement(By.xpath("//input[@id='wpforms-3336-field_0']"));
        js.executeScript("arguments[0].scrollIntoView(true);", nameField);
        nameField.sendKeys("Preeti Test");
        WebElement emailField =driver.findElement(By.xpath("//input[@id='wpforms-3336-field_1']"));
        js.executeScript("arguments[0].scrollIntoView(true);", emailField);
        emailField.sendKeys("test@example.com");
        WebElement number = driver.findElement(By.xpath("//input[@id='wpforms-3336-field_3']"));
        js.executeScript("arguments[0].scrollIntoView(true);", number);
        number.sendKeys("999999999");
        WebElement subjectDropdown = driver.findElement(By.xpath("//select[@id='wpforms-3336-field_4']"));
        js.executeScript("arguments[0].scrollIntoView(true);", subjectDropdown);
        Select select = new Select(subjectDropdown);
        select.selectByVisibleText("Succession");
        WebElement message = driver.findElement(By.xpath("//textarea[@id='wpforms-3336-field_2']"));
        js.executeScript("arguments[0].scrollIntoView(true);", message);
        message.sendKeys("This is a test message.");
        WebElement submit = driver.findElement(By.xpath("//button[@id='wpforms-submit-3336']"));
        js.executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.submit();

    }
    @Test(priority = 7)
    public void brokenLink() {
        logger.info("Validate Broken Link claim My Shares");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of Links" + links.size());
        int noOfBrokenLinks=0;
        for (WebElement linkElement : links) {
            String hrefValue = linkElement.getAttribute("href");
            if (hrefValue == null || hrefValue.isEmpty()) {
                System.out.println("Not Possible to check");
                continue;
            }
            try {
                URL linkUrl = new URL(hrefValue);
                HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection();
                conn.connect();
                if (conn.getResponseCode() >= 400) {
                    System.out.println(hrefValue + "===> Link is Broken");
                    noOfBrokenLinks++;
                } else {
                    //System.out.println(hrefValue + "=>Not a Broken Link");
                    }
            } catch (Exception e) {

            }
        } System.out.println("No. of Broken links" + noOfBrokenLinks);
    }
}
