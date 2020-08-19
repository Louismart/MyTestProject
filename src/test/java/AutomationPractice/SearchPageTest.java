package AutomationPractice;
import automationTestFramework.Variables;
import automationTestFramework.pages.CustomerPage;
import automationTestFramework.pages.ResultPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static automationTestFramework.Variables.getUrl;

public class SearchPageTest {

    private ChromeDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void  beforeTests() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(getUrl);
        driver.manage().window().maximize();
        driver.findElement(By.id("search_query_top")).sendKeys(Variables.searchField);
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement searchResult = wait.until(ExpectedConditions.elementToBeClickable(CustomerPage.searchFieldLocator));
        searchResult.sendKeys(Keys.ENTER);

    }
    /*
    Precondition for all tests : Navigate to main page and enter Short in the searchField
     */
    @Test
    public void userIsAbleToSeeGridAndListElementButton() {

        //Verify visibility of List and Grid buttons
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement gridButton = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerPage.gridButton));
        WebElement listButton = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerPage.listButton));
        listButton.click();

    }

    @Test
    public void userIsAbleToSeeNotEmptyListOfSearchedElement() {

        /*
        List of searched element more than 0
         */
        driver.findElement(CustomerPage.searchFieldShort);
        boolean value = false;

        if (driver.findElements(CustomerPage.searchFieldShort).size() > 0) {
            value = true;
        }
        System.out.println(value);

    }
}
