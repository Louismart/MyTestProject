package automationTestFramework.repository.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static WebDriver webDriver;
//implements Enum
    public static WebDriver GetDriver(WebDrivers driver) {
        if (driver == WebDrivers.CHROME) {
            if (webDriver == null) {
                //set up chromedriver
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                return webDriver;
            } else return webDriver;
        }
        if(driver == WebDrivers.IE) {
            if (webDriver == null) {
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                return webDriver;
            }else return webDriver;
        }
        throw new IllegalArgumentException("The driver is not implemented :" + driver.name());

    }
}
