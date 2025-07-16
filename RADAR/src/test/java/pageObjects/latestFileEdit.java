package pageObjects;

import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class latestFileEdit extends BasePage{
    public latestFileEdit(WebDriver driver)
{
    super(driver);
}
public void fileEdit() throws Exception{
    String downloadPath = System.getProperty("user.home") + "\\Downloads";
    // Get the latest .xlsx file
    File downloadFolder = new File(downloadPath);
    File latestExcelFile = Arrays.stream(downloadFolder.listFiles((dir, name) -> name.endsWith(".xlsx")))
            .max(Comparator.comparingLong(File::lastModified))
            .orElseThrow(() -> new RuntimeException("No .xlsx files found in Downloads"));
    System.out.println("Latest file found: " + latestExcelFile.getName());
    Desktop.getDesktop().open(latestExcelFile);
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_ALT);
    robot.keyPress(KeyEvent.VK_H);
    robot.keyRelease(KeyEvent.VK_H);
    robot.keyPress(KeyEvent.VK_E);
    robot.keyRelease(KeyEvent.VK_E);
    robot.keyRelease(KeyEvent.VK_ALT);

}
}
