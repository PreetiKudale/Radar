package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.superAdminRawData;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class TC_020_superAdminRawData extends BaseClass{
    @Test
    public void superAdminExportImportRawData() {
        try {
            // Login and navigate to export
            superAdminRawData lp = new superAdminRawData(driver);
            lp.setUserName(p.getProperty("SuperAdminuserName"));
            lp.setPassword(p.getProperty("Password"));
            lp.setClickOnsignUp();
            lp.otpGenerate();
            lp.otpinput(p.getProperty("OTP"));
            lp.VerifyOtp();
            lp.passwordPopUpcancelClick();
            lp.clickAllFiles();
            lp.clickOnRawData();
            lp.exportClick();
            logger.info("Download initiated");

            // Handle download insecure file popup in Chrome
            clickKeepAndOpenDownload();

            // Wait for download to finish (wait up to 60 seconds)
            File downloadedFile = waitForCompleteDownload("SuperAdminTempletNew", 60);
            if (downloadedFile != null && downloadedFile.exists()) {
                Desktop.getDesktop().open(downloadedFile);
                logger.info("File opened: " + downloadedFile.getAbsolutePath());

                // Click "Enable Editing"
                clickEnableEditing();
            } else {
                logger.error("Downloaded .xlsx file not found or download didn't complete.");
                Assert.fail("Downloaded file not found.");
            }

        } catch (Exception e) {
            logger.error("Test Failed", e);
            Assert.fail("Test case failed due to exception: " + e.getMessage());
        }
    }

    // Automatically click "Keep" and "Download anyway" for blocked Chrome downloads
    public void clickKeepAndOpenDownload() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Thread.sleep(3000); // Wait for Chrome to show download bar

        // Open Chrome downloads with Ctrl+J
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_J);
        robot.keyRelease(KeyEvent.VK_J);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000); // Wait for chrome://downloads to open

        // Click 3-dot menu on blocked download (adjust x/y based on screen)
        robot.mouseMove(1350, 260);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);

        // Arrow down to "Keep" option
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        // Press Enter to confirm download
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000); // Wait for file to start downloading
    }

    public static File waitForCompleteDownload(String fileNameStartsWith, int timeoutSeconds) throws InterruptedException {
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        int waited = 0;

        while (waited < timeoutSeconds) {
            File[] crFiles = downloadDir.listFiles((dir, name) ->
                    name.startsWith(fileNameStartsWith) && name.endsWith(".crdownload"));

            File[] xlsxFiles = downloadDir.listFiles((dir, name) ->
                    name.startsWith(fileNameStartsWith) && name.endsWith(".xlsx"));

            // Only return when .crdownload is gone and .xlsx exists
            if ((crFiles == null || crFiles.length == 0) && xlsxFiles != null && xlsxFiles.length > 0) {
                return xlsxFiles[0];
            }

            Thread.sleep(1000); // wait 1 second
            waited++;
        }

        return null; // timeout
    }

    // Click "Enable Editing" in Excel yellow ribbon
    public void clickEnableEditing() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Thread.sleep(5000); // Wait for Excel to load

        // Move mouse to approximate location of "Enable Editing" button
        robot.mouseMove(600, 150); // Adjust these values as per your screen
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        logger.info("Clicked 'Enable Editing' in Excel.");
    }
}