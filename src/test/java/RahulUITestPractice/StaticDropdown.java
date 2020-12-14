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
    public void testdropDownWithClickableButtons() {

        WebElement clickDropdown = driver.findElement(By.id("divpaxinfo"));
        clickDropdown.click();

        Select dropdown = new Select(clickDropdown);


    }

    @AfterTest
    public void closeAndQuit() {

            if(driver != null)
                driver.quit();
             //   driver.close();


    }
}
