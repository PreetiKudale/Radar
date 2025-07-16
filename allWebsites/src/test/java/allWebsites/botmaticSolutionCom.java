package allWebsites;

import allWebsites.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class botmaticSolutionCom extends baseClass {

    @Test(priority = 1)
    public void validateMenuItemsAreClickable() {
        logger.info("Validate botmatic Solution Com");

        driver.get("https://www.botmaticsolutions.com");
        System.out.println("Opened Botmatic Solutions");
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Botmatic Solution") || actualTitle.contains("1 new message")) {
            System.out.println("Home page title is correct: " + actualTitle);
        } else {
            System.out.println("Home page title validation failed. Found: " + actualTitle);
        }
        }
        @Test(priority = 2)
                public void homeLinkValidation() {
            logger.info("Validate Home link in botmatic Solution Com");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                    "//a[@class='page-scroll'][normalize-space()='Home']")));
            System.out.println("'Home' is clickable");
        }
    @Test(priority = 3)
            public void AboutUsLinkValidate() {
        logger.info("Validate About Us Link in botmatic Solution Com");
        WebElement aboutUsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//a[@class='page-scroll'][normalize-space()='About Us']")));
        System.out.println("'About Us' is clickable");
    }
    @Test(priority = 4)
    public void rpaUseCasesLinkValidation() {
        logger.info("Validate rpa Use Cases Link botmatic Solution Com");
        WebElement rpaUseCasesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//a[normalize-space()='RPA Use Cases']")));
        System.out.println("'RPA Use Cases' is clickable");
    }
    @Test(priority = 5)
    public void contactUsLinkValidation() {
        logger.info("Validate Contact Us link botmatic Solution Com");
        WebElement contactUsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//a[@class='page-scroll'][normalize-space()='Contact Us']")));
        System.out.println("'Contact Us' is clickable");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Test Name");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("testemail@test.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))).sendKeys("Automation test Script message");
        WebElement sendMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Send Message']")));
        sendMessage.click();
        WebElement careersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//a[@class='page-scroll'][normalize-space()='Careers']")));
        System.out.println("'Careers' is clickable");
    }

    @Test (priority = 6)
    public void validateProductOpensInNewTab() {
        logger.info("Validate Product Opens in botmatic Solution Com");
        String originalWindow = driver.getWindowHandle();
        // Click on the Product menu item
        WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Products']")));
        productLink.click();
        System.out.println("Clicked on 'Product' link");
        // Wait for the new tab to open
        wait.until(driver -> driver.getWindowHandles().size() > 1);
        // Switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Validate the URL in the new tab
        String expectedUrl = "https://myvyay.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("New tab URL is correct: " + actualUrl);
        } else {
            System.out.println("New tab URL is incorrect: " + actualUrl);
        }
    }
    @Test(priority = 7)
    public void brokenLink() {
        logger.info("Validate Broken Link botmatic Solution Com");
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
                    System.out.println(hrefValue + "=>Not a Broken Link");
                }
            } catch (Exception e) {

            }
        } System.out.println("No. of Broken links" + noOfBrokenLinks);
    }
}
