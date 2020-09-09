
package AutomationPractice;

import automationTestFramework.Variables;
import automationTestFramework.pages.CustomerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static automationTestFramework.Variables.getUrl;

public class AutomationPracticeTests {

    private ChromeDriver driver;
    protected CustomerPage testPage;
    //private WebDriverWait wait;
    private String liClassLocator = "li";



    @BeforeClass
    public void baseTests () {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        testPage = new CustomerPage(driver);
        //1. Open link http://automationpractice.com/index.php
        driver.get(getUrl);
        //Maximize or set size of browser window.
       // driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void userIsAbleToLoadPage() {

        /*
        Validate that loaded page has fields:
Contact us, Sign in, phone number
Logo, searchField, shopping card
Dropdown menu : Women, Dresses, T-shorts
Homeslides-description, image1, image 2
Buttons: Popular,Best Sellers
Bottom menu: NewsLatter, EmailInputField

*/
        getUrl = driver.getCurrentUrl();
        Assert.assertEquals(getUrl, Variables.expectedUrl);
        Assert.assertTrue(testPage.isLoaded());

        //Without Page Object
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        WebElement searchFieldLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerPage.searchFieldLocator));
//        WebElement contactUsLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerPage.contactUsLocator));
        // Assert.assertTrue(isElementvisibleBy(CustomerPage.searchFieldLocator) && isElementvisibleBy(CustomerPage.contactUsLocator), "Verifying visibility of searchFieldLocator");
}


    @Test
    public void userVerifyButtonPopularProductsection() {
        /*
Verify is button is selected by default and list of all elements greater than 0
       */
       // WebDriverWait wait = new WebDriverWait(driver,30);
       // Assert.assertTrue(testPage.isLoaded(), "Verifying that page is loading");

//        boolean result = testPage.loadedElementsAreGreaterThanZero();
//        Assert.assertTrue(result, "Verifying if elements Pop and Best are loaded elements and greater than 0");


//        WebElement buttonsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home-page-tabs")));
//        List<WebElement> buttons = buttonsSection.findElements(By.xpath("li"));
//        Assert.assertTrue(buttons.size() > 1, "Verifying if elelements Pop and Best se exists on Page" );

        //List<WebElement>buttonsPop =
        Assert.assertTrue(testPage.popularButton().get(0).getText().contains("POPULAR"), "Verifying that Popular element contains POPULAR");
        //List<WebElement>buttonBest
        Assert.assertTrue(testPage.bestSellersButton().get(0).getText().contains("BEST SELLERS"), "Verifying that Best Sellers element contains BEST SELLERS");
//        WebElement popular = buttons.get(0);
//        WebElement bestSellers = buttons.get(1);
//        Assert.assertTrue(popular.getText().contains("POPULAR"));
//        Assert.assertTrue(bestSellers.getText().contains("BEST SELLERS"));

        List<WebElement> liActive = testPage.homePageTabsSection().get(0).findElements(By.xpath(liClassLocator));   //visibility of home-page-tabs   //findElements(By.xpath("li"));

         //List<WebElement>liActive= homePageTabs.findElements(By.xpath("li"));


         Assert.assertTrue(liActive.get(0).getAttribute("class").equals("active"), "Verifying if Popular is active");
         Assert.assertFalse(liActive.get(1).getAttribute("class").equals("active"), "Verifying if Best Sellers is not active");

//         Assert.assertFalse(testPage.bestSellersButton().get(0).getAttribute("class").equals("active"), "Verifying if bestSellers is not active");
//        bestSellers.click();
//        Assert.assertFalse(popular.getAttribute("class").equals("active"), "Verifying if Popular is not active");
//        Assert.assertTrue(bestSellers.getAttribute("class").equals("active"), "Verifying if bestSellers is active");
//        Assert.assertTrue(popular.getText().contains("POPULAR"));
//        Assert.assertTrue(bestSellers.getText().contains("BEST SELLERS"));



    }

    @Test
    public void userVerifyButtonBestSellersSection() {
        /*
        Click the button and verify than list of elements is greater than 0
         */

        WebElement bestSellers = driver.findElement(CustomerPage.bestSellersButtonLocator);
        boolean value2 = false;

        if (driver.findElements(CustomerPage.bestSellersButtonLocator).size() > 0) {
            value2 = true;
        }
        bestSellers.click();
        System.out.println(value2);

        }

    @Test
    public void userVerifySearchField() {

        /*
        Preconditions: searched element Faded short
        Input searched element in searched field
        User is redirected on searchPage, and searchPage is visible (verify visibility of search element[navigation-page element])
         */
        driver.findElement(By.id("search_query_top")).sendKeys(Variables.searchFieldResult);
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement searchResult = wait.until(ExpectedConditions.elementToBeClickable(CustomerPage.searchFieldLocator));
        searchResult.sendKeys(Keys.ENTER);


    }
    @AfterTest
    public void tearDown() {
        if(driver != null)
            driver.quit();
    }

//    private boolean isElementvisibleBy(By locator){
//        try{
//            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        }
//        catch (TimeoutException ex){
//            return  false;
//        }
//        return true;
//    }

}



