package automationTestFrameworkTests;

import automationTestFramework.repository.driver.BaseDriver;
import automationTestFramework.repository.driver.WebDrivers;
import org.testng.annotations.AfterClass;
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


    @AfterClass
    public void afterSuite() {
        baseDriver.closeAndQuit();
    }
}
