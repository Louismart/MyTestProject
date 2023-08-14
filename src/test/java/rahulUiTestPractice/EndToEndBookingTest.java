package rahulUiTestPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

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
        WebDriverWait wait = new WebDriverWait(driver, 20);
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
        } else {
            //driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
            Assert.fail("Return date is Disabled");
        }
    }
        @Test
    public void passengerDropdownTest() {

            //Adult dropdown
            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement passengersLocator = wait.until(ExpectedConditions.elementToBeClickable(By.id("divpaxinfo")));
            passengersLocator.click();
            String searchPassValue = "4";
            WebElement staticPassDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_ddl_Adult")));
            Select passDropdown = new Select(staticPassDropdown);
            passDropdown.selectByValue("4");
            String passDropdownValue = passDropdown.getFirstSelectedOption().getText();
            Assert.assertTrue(passDropdownValue.contains(searchPassValue));
            //Infant dropdown
            String searchInfantValue = "2";
            WebElement staticInfantDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_ddl_Infant")));
            Select infantDropdown = new Select(staticInfantDropdown);
            infantDropdown.selectByValue("2");
            String infantDropdownValue = infantDropdown.getFirstSelectedOption().getText();
            Assert.assertTrue(infantDropdownValue.contains(searchInfantValue));

        }

        @Test
        public void currencyDropdownTest() {

            WebDriverWait wait = new WebDriverWait(driver, 20);
            String searchValue = "USD";
            WebElement staticDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_DropDownListCurrency")));
            Select dropdown = new Select(staticDropdown);
            dropdown.selectByValue("USD");  // or by value or by visible text
            String dropdownValue = dropdown.getFirstSelectedOption().getText();
            Assert.assertTrue(dropdownValue.contains(searchValue));

        }
        @Test
        public void checkBoxTest() {

            WebDriverWait wait = new WebDriverWait(driver, 20);

            if (!driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).isSelected()) {
                WebElement seniorCheckBoxLocator1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']"))); //driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).click();
                seniorCheckBoxLocator1.click();
            }

            if (driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).isSelected()) {
                WebElement seniorCheckBoxLocator2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']"))); //driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).click();
                seniorCheckBoxLocator2.click();
            }
            //count the number of checkboxes
            List<WebElement> listOfCheckboxElements =  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("input[type='checkbox']")));
            Assert.assertFalse(driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).isSelected(), "If checkbox is not selected");
            //Assert.assertTrue(!driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).isSelected(), "If checkbox is selected");
            Assert.assertTrue(listOfCheckboxElements.size() > 0, "Check , if number of checkboxes gtreate than 0");

        }

        @Test
        public void searchFlight() {

            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement searchButtonLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type= 'submit']")));
            searchButtonLocator.click();
    }

        @AfterTest
        public void closeAndQuit() {
            driver.close();
            if (driver != null) {
               driver.quit();

        }
    }
}
