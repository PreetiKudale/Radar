package allWebsites;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class caJpd extends baseClass{

    @Test(priority = 1)
    public void navigateAndValidatePages() {
        logger.info("Validate CAJPD");
        driver.get("https://www.cajpd.com/");
        WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Home")));
        Assert.assertTrue(homeLink.isDisplayed() && homeLink.isEnabled(), "Home link is not clickable");
    }
    @Test(priority = 2)
        public void aboutLinkvalidate () {
        logger.info("Validate About Us Link CAJPD");
            WebElement aboutLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("About Us")));
        Assert.assertTrue(aboutLink.isDisplayed() && aboutLink.isEnabled(), "About Us link is not clickable");
    }
    @Test(priority = 3)
    public void services () {
        logger.info("Validate Services page CAJPD");
        WebElement servicesLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Services")));
        Assert.assertTrue(servicesLink.isDisplayed() && servicesLink.isEnabled(), "Services link is not clickable");
    }
    @Test(priority = 4)
    public void knowledge () {
        logger.info("Validate Knowlede Page CAJPD");
    WebElement knowledgeLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Knowledge Center")));
        Assert.assertTrue(knowledgeLink.isDisplayed() && knowledgeLink.isEnabled(), "Knowledge Center link is not clickable");

    }
    @Test(priority = 6)
    public void fillContactForm() {
        logger.info("Validate fill Contact page CAJPD");
        driver.findElement(By.xpath("//div[@id='contact-section']")).click();
        WebElement knowledgeLink = driver.findElement(By.xpath("//ul[@class='site-menu main-menu js-clone-nav ml-auto d-none d-lg-block']//a[@class='nav-link active'][normalize-space()='Contact Us']"));
        knowledgeLink.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 900)");
        driver.findElement(By.xpath("//input[@id='Name']")).sendKeys("Preeti Test");
        driver.findElement(By.xpath("//input[@id='lname']")).sendKeys("LastName");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("test@example.com");
        driver.findElement(By.xpath("//textarea[@id='Message']")).sendKeys("This is a test message Automation Testing");
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='90%'");
        driver.findElement(By.xpath("//input[@type='submit']")).submit();

    }

    @Test(priority = 5)
    private void clickAndValidateSocialMedia() throws InterruptedException {
        logger.info("Validate Social Media Pages CAJPD");
        WebElement facebookIcon = driver.findElement(By.xpath("//span[@class='icon-facebook-official']"));
        facebookIcon.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("facebook.com")) {
            System.out.println("PASS: URL contains 'facebook.com'");
        } else {
            System.out.println("FAIL: URL does not contain 'facebook.com'");
        }
        driver.navigate().back();
        Thread.sleep(3000);
        WebElement twitterIcon =  driver.findElement(By.xpath("//span[@class='icon-twitter']"));
        twitterIcon.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        String currentUrltwitter = driver.getCurrentUrl();
        if (currentUrltwitter.contains("https://x.com/")) {
            System.out.println("PASS: URL contains 'Twitter.com'");
        } else {
            System.out.println("FAIL: URL does not contain 'Twitter.com'");
        }
        driver.navigate().back();
        Thread.sleep(3000);
        WebElement linkedIn =   driver.findElement(By.xpath("//span[@class='icon-linkedin']"));
        linkedIn.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        String currentUrllinkedIn = driver.getCurrentUrl();
        if (currentUrllinkedIn.contains("https://www.linkedin.com/")) {
            System.out.println("PASS: URL contains 'https://www.linkedin.com/'");
        } else {
            System.out.println("FAIL: URL does not contain 'linkedIn.com'");
        }
        driver.navigate().back();
        Thread.sleep(3000);
    }
    @Test(priority = 7)
    public void brokenLink() {
        logger.info("Validate Broken Link CAJPD");
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
                   // System.out.println(hrefValue + "=>Not a Broken Link");
                }
            } catch (Exception e) {

            }
        } System.out.println("No. of Broken links" + noOfBrokenLinks);
    }
}
