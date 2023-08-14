package automationTestFrameworkTests;

import automationTestFramework.actualFramework.driver.BaseDriver;
import automationTestFramework.actualFramework.driver.WebDrivers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.File;

public class BaseTests {

    protected BaseDriver baseDriver;
    protected String path;


    @BeforeClass
    public void beforeClass() {

        File resourcesDirectory = new File("src/main/resources");
        path = resourcesDirectory.getAbsolutePath();
        baseDriver = new BaseDriver(WebDrivers.CHROME, 5);
        baseDriver.maximize();
    }


    @AfterSuite
    public void afterSuite() {
        baseDriver.closeAndQuit();
    }
}
