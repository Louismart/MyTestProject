package RahulUITestPractice;

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

import static automationTestFramework.Variables.getUrl;

public class StaticDropdown {

    private ChromeDriver driver;

    @BeforeTest
    public void beforeTests() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //driver.get("https://book.spicejet.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testCurrencyStaticDropDown() {
        //dropdown with selected tag
        String searchValue = "USD";
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);// or by value or by visible text
        String dropdownValue = dropdown.getFirstSelectedOption().getText();

        Assert.assertTrue(dropdownValue.contains(searchValue));

    }

    @Test
    //Need use Rahul Sheety site
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

        Thread.sleep(800);
        int i = 1;
        while (i < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();  // click Adult button 4 times
            i++;
        }
        Thread.sleep(800);
        driver.findElement(By.id("hrefIncChd")).click();
        Thread.sleep(800);
        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertTrue(driver.findElement(By.id("divpaxinfo")).getText().contains("5 Adult, 1 Child")
                ,"Verifying that Passengers element contains 5 Adult, 1 Child");

    }

    @Test
    public void testDynamicDropDown() throws InterruptedException {

        // //a[@value="MAA"] - Chennai xpath
        // //a[@value="BLR"] - Bengaluru
        // ctl00_mainContent_ddl_originStation1_CTXT
        //input[@id='ctl00_mainContent_rbtnl_Trip_1']

        Thread.sleep(1500);
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click(); //Selenium select by default first element from the left side "FROM"
        Thread.sleep(1000);
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); incorrect XPATH practise   // point out to second element in "TO"
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); //XPATH with parent indication
        Thread.sleep(1500);
        //Test Calendar
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click(); //Departure date
        // Select future date needs sorting out


       // System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.xpath(" //input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click(); //Round trip -Radio button check
        //System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            Assert.assertTrue(true, "It's Enabled");
        }
        else {
            //driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
            Assert.fail("It's Disabled");
        }
        Thread.sleep(800);
        //driver.findElement(By.
        // name("ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListCurrency")).click();
        driver.findElement(By.xpath("//select[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency']")).click();

        driver.findElement(By.xpath("//input[@type= 'submit']")).click();  //Search button check


    }

    @Test
    //spicejet.com

    public void endToEndBookingSearchTest() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        WebElement originDestinationLocator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']")));
//        originDestinationLocator.click();
        //driver.findElement(By.xpath("//input[@id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']"));

        driver.findElement(By.xpath("//input[@id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']")).click();


        //driver.findElement(By.xpath("//a[@value='BLR']")).click(); //Selenium select by default first element from the left "FROM"
        //Thread.sleep(1000);
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); incorrect XPATH practise   // point out to second element in "TO"
        driver.findElement(By.xpath("//input[@id='ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT'] //a[@value='MAA']")).click(); //XPATH with parent indication
        Thread.sleep(1500);
        //Test Calendar
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click(); //Departure date
        // Select future date needs sorting out


        // System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.xpath(" //input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click(); //Round trip -Radio button check
        //System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            Assert.assertTrue(true, "It's Enabled");
        }
        else {
            //driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
            Assert.fail("It's Disabled");
        }
        Thread.sleep(800);
        //driver.findElement(By.
        // name("ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListCurrency")).click();
        driver.findElement(By.xpath("//select[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency']")).click();

        driver.findElement(By.xpath("//input[@type= 'submit']")).click();  //Search button check





    }


    @Test
    public void testCheckBoxAndCheckboxSize() {


        if (!driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).isSelected()) {
             driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).click();
        }

        if (driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).isSelected()) {
            driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).click();
        }

        //count the number of checkboxes
        int checkBoxCount = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        Assert.assertFalse(driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).isSelected(), "If checkbox is not selected");
        //Assert.assertTrue(!driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).isSelected(), "If checkbox is selected");
        Assert.assertTrue(checkBoxCount > 0, "Check , if number of checkboxes gtreate than 0");

    }

    @AfterTest
    public void closeAndQuit() {
        driver.close();
        if (driver != null) {
            driver.quit();

        }
    }
}
