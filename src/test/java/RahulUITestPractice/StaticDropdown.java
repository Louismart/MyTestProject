package RahulUITestPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static automationTestFramework.Variables.getUrl;

public class StaticDropdown {

    private ChromeDriver driver;

    @BeforeTest
    public void beforeTests() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
    }

    @Test
    public void testStaticDropDown() {
        //dropdown with selected tag
        String searchValue = "USD";
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);// or by value or by visible text
        String dropdownValue = dropdown.getFirstSelectedOption().getText();

        Assert.assertTrue(dropdownValue.contains(searchValue));

    }

    @Test
    public void testSuggestedDropdown() throws InterruptedException {

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000);
        String genericXpathForInd = "li[class='ui-menu-item'] a";
        List<WebElement> options = driver.findElements(By.cssSelector(genericXpathForInd)); //generic XPATH for all countries start from Ind
        String searchRequest = "India";
        //Store all Ind elements in List
        for (WebElement option : options) {
         if(option.getText().equalsIgnoreCase(searchRequest))  // select India and click
         {
             option.click();
             break;
         }
        }

        //Assert.assertTrue(options.contains(genericXpathForInd));

    }

    @Test
    public void testdropDownWithClickableButtons() throws InterruptedException {

        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(500);
        int i = 1;
        while (i < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        Thread.sleep(400);
        driver.findElement(By.id("hrefIncChd")).click();
        Thread.sleep(400);
        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertTrue(driver.findElement(By.id("divpaxinfo")).getText().contains("5 Adult, 1 Child")
                ,"Verifying that Passengers element contains 5 Adult, 1 Child");

    }

    @Test
    public void testDynamicDropDown() throws InterruptedException {

        // //a[@value="MAA"] - Chennai xpath
        // //a[@value="BLR"] - Bengaluru
        // ctl00_mainContent_ddl_originStation1_CTXT
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click(); //Selenium select by default first element from the left "FROM"
        Thread.sleep(1000);
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); incorrect XPATH practise   // point out to second element in "TO"
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); //XPATH with parent indication


    }



    @AfterTest
    public void closeAndQuit() {
        driver.close();
        if (driver != null) {
            driver.quit();

        }
    }
}
