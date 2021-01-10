package RahulUITestPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EndToEndBookingTest {

    private ChromeDriver driver;

    @BeforeTest
    public void beforeTests() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void bookingTest() throws InterruptedException {
        //Point of origin- Bengaluru
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement originDestinationLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='ctl00_mainContent_ddl_originStation1_CTXT']")));
        originDestinationLocator.click();
        WebElement originBengaluruLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@value='BLR']")));
        originBengaluruLocator.click();
        //Point of destination Chennai
        WebElement destinationChennaiLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")));
        destinationChennaiLocator.click();
        //Test Calendar
        WebElement startDateCalendarLocator = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-state-default.ui-state-active")));
        startDateCalendarLocator.click();         //Depart date
        // Select future date needs sorting out-------------------
        //Round Trip button check
        WebElement roundTripButtonLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")));
        roundTripButtonLocator.click();
        //Return date Enable check
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            Assert.assertTrue(true, "Return date is Enabled");
        }
        else {
            //driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
            Assert.fail("Return date is Disabled");
        }
        //Passengers test
        //Senior Citizen checkbox
        //Currency
        //Search Flight


    }
    @AfterTest
    public void closeAndQuit() {
        driver.close();
        if (driver != null) {
            driver.quit();

        }
    }
}
