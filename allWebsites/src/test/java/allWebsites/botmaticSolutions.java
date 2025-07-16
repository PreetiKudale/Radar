package allWebsites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class botmaticSolutions extends baseClass {
    @Test(priority = 1)
    public void botmaticsolutionsInOpen() {
        logger.info("Validate botmatic Solutions In");
        driver.get("https://www.botmaticsolutions.com"); //(www.myvyay.com both are same)
        System.out.println("Opened Botmatic Solutions");
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Botmatic Solution") || actualTitle.contains("1 new message")) {
            System.out.println("Home page title is correct: " + actualTitle);
        } else {
            System.out.println("Home page title validation failed. Found: " + actualTitle);
        }
    }

    @Test(priority = 2)
    public void aboutUsValidate() {
        logger.info("Validate About Us in botmatic Solutions In");
        WebElement aboutUsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//a[@class='page-scroll'][normalize-space()='About Us']")));
        System.out.println("'About Us' is clickable");
    }

    @Test(priority = 3)
    public void RPAUsecasesValidate() {
        logger.info("Validate RPA Use Cases in botmatic Solutions In");
        WebElement RPAUsecases = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//a[normalize-space()='RPA Use Cases']")));
        System.out.println(" 'RPA Use Cases' is clickable");
    }
    @Test(priority = 5)
    public void careersValidation(){
        logger.info("Validate Careers alidation in botmatic Solutions In");
        WebElement careers = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Careers']")));
        System.out.println(" 'Careers' is clickable");
    }
    @Test(priority = 6)
    public void validateProductsLinkInNewTab() {
        logger.info("Validate Product Link botmatic Solutions In");
        WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li//a[@class='page-scroll blink'][normalize-space()='Products']")));
        productsLink.click();
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        wait.until(ExpectedConditions.urlContains("myvyay.com"));
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://myvyay.com/")) {
            System.out.println("Products link opened the correct URL in new tab: " + currentUrl);
        } else {
            System.out.println("Unexpected URL opened: " + currentUrl);
        }
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @Test(priority = 7)
    public void contactUsValidate() {
        logger.info("Validate Contact Us botmatic Solutions In");
        WebElement contactUs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//a[@class='page-scroll'][normalize-space()='Contact Us']")));
        System.out.println(" 'Contact Us' is clickable");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test Name");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@example.com");
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Automation test Script message");
        driver.findElement(By.xpath("//button[normalize-space()='Send Message']")).click();
        WebElement sendMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//button[normalize-space()='Send Message']")));
        System.out.println(" 'Send message' is clickable");
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert message: " + alertText);
            if (alertText.contains("Thank you for your message. We will get back to you soon.")) {
                System.out.println("Confirmation message is correct");
            } else {
                System.out.println("Unexpected alert text");
            }
            alert.accept();
            System.out.println("Alert accepted");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    @Test(priority = 4)
    public void brokenLink() {
        logger.info("Validate Broken Links in botmatic Solutions In");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of Links" + links.size());
        int noOfBrokenLinks = 0;
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
        }
        System.out.println("No. of Broken links" + noOfBrokenLinks);
    }
}
