
package AutomationPractice;

import automationTestFramework.Variables;
import automationTestFramework.pages.CustomerPage;
import automationTestFramework.pages.HomePage;
import automationTestFramework.pages.ResultPage;
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
import java.util.concurrent.TimeUnit;

import static automationTestFramework.Variables.getUrl;

public class AutomationPracticeTests {

    private ChromeDriver driver;
    private WebDriverWait wait;


//    public AutomationPracticeTests(WebDriverWait wait) {
//        this.wait = wait;
//        this.wait = new WebDriverWait(this.driver,10);

    @BeforeClass
    public void baseTests () {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //1. Open link http://automationpractice.com/index.php
        driver.get(getUrl);
        //Maximize or set size of browser window.
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
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

        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement searchFieldLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerPage.searchFieldLocator));
        WebElement contactUsLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerPage.contactUsLocator));
        WebElement signInLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerPage.signInLocator));
        WebElement logoLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerPage.logoLocator));
        WebElement shoppingCardLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerPage.shoppingCardLocator));
        WebElement womanDropDownButtonInLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerPage.womanDropDownButtonLocator));

        Assert.assertTrue(isElementvisibleBy(CustomerPage.searchFieldLocator) && isElementvisibleBy(CustomerPage.contactUsLocator), "Verifying visibility of searchFieldLocator");
/*
BaseElement{

Consturtor:
BaseElement(driver, waiter, locator){
bla bla
}

public boolean isVisible(){
try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (TimeoutException ex){
            return  false;
        }
        return true;
}
}

TextLabel extends BaseElement

consrtuctor
public TexxLabel(driver, waiter, locator){
super(driver, waiter, locator)
}

}
PageObjXXX{
locators
loc1d
loc12
loc13
loc14

Constructor
PageObjXxx(driver, i chto nado)



public TextLabel lableKakojto = new TextLabel(driver, locator1)
public TextLabel lableKakojto2 = new TextLabel(driver, locator2)

public boolean IsLoaded(){
return lableKakojto.isVisible() && return lableKakojto.isVisible() &&
lableKakojto2.IsVisible()
}



@Test
sdjkfhailsugdhas(){
PageObjXxx xxx = new PageObjXxx(driver, i chto nado)
Assert.asssertTrue(xxx.IsLoaded());
}



}
 */
    }

    @Test
    public void userVerifyButtonPopularProductsection() {
        /*
Verify is button is selected by default and list of all elements greater than 0
       */
        //WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement popularButton1 = driver.findElement(CustomerPage.popularButtonLocator);



        Assert.assertTrue(popularButton1.isSelected(), "Verifying if dskfh selected");


       if (popularButton1.isSelected()) {
            System.out.println("Popular button is selected by default");
        } else {
           System.out.println("Popular button is not selected");
       }
       //WebElement popularButtonClick = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerPage.popularButton));
       popularButton1.click();

            //popularButton1.click();

        boolean value = false;

        if (driver.findElements(CustomerPage.popularButtonLocator).size() > 0) {
            value = true;
        }
        System.out.println(value);

    }

    @Test
    public void userVerifyButtonPopularProductsection2() {
        WebDriverWait wait = new WebDriverWait(driver,20);

        WebElement buttonsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home-page-tabs")));
        List<WebElement> buttons = buttonsSection.findElements(By.xpath("li"));
        Assert.assertTrue(buttons.size() > 1, "Verifying if elelemnts Pop and Best se exists on Page" );

        WebElement popular = buttons.get(0);
        WebElement bestSellers = buttons.get(1);
        Assert.assertTrue(popular.getText().contains("POPULAR"));
        Assert.assertTrue(bestSellers.getText().contains("BEST SELLERS"));
        Assert.assertTrue(popular.getAttribute("class").equals("active"), "Verifying if Popular is active");
        Assert.assertFalse(bestSellers.getAttribute("class").equals("active"), "Verifying if bestSellers is not active");
        bestSellers.click();
        Assert.assertFalse(popular.getAttribute("class").equals("active"), "Verifying if Popular is not active");
        Assert.assertTrue(bestSellers.getAttribute("class").equals("active"), "Verifying if bestSellers is active");
        Assert.assertTrue(popular.getText().contains("POPULAR"));
        Assert.assertTrue(bestSellers.getText().contains("BEST SELLERS"));



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

    private boolean isElementvisibleBy(By locator){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (TimeoutException ex){
            return  false;
        }
        return true;
    }

}



