package pageObjects;
import org.testng.annotations.BeforeSuite;
import java.awt.*;
import java.awt.event.KeyEvent;


public class robotVPN {
    @BeforeSuite
    public void robotVpn(){
        try {
            // Open FortiClient.exe directly
            Runtime.getRuntime().exec("C:\\Program Files\\Fortinet\\FortiClient\\FortiClient.exe");

            // Wait for it to launch
            Thread.sleep(7000);

            // Robot class to simulate keyboard interaction (optional)
            Robot robot = new Robot();

            // TAB to focus on "Connect" button (adjust count as needed)
            for (int i = 0; i < 3; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                Thread.sleep(300);
            }

            // Press ENTER to connect
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}