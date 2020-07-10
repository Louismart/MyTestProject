import Model.Pages.CustomerStartPage;
import framework.driver.BaseDriver;
import framework.driver.WebDrivers;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;

public class Tests {
    private BaseDriver baseDriver;
    private CustomerStartPage testedPage;

    @BeforeSuite
    public void beforeSuite() {

        File resourcesDirectory = new File("src/main/resources");
        String path = resourcesDirectory.getAbsolutePath();


        baseDriver = new BaseDriver(WebDrivers.CHROME, 5);


        testedPage = new CustomerStartPage(baseDriver,  path + "\\ui\\index.html");
        baseDriver.maximize();
    }


    @BeforeTest
    public void beforeTest() {
        testedPage.openUrl();
    }

//1. Search for Customer by Name
    @Test
    public void userIsAbleToSearchByName() {

        String searchRequest = "Bon";
        testedPage.search().clearString().sendString(searchRequest);

        String searchName = testedPage.customerTable().rows().get(0).cells().get(1).visibleText();

        Assert.assertTrue(searchName.contains(searchRequest));
    }

    // 2. Search for Customer by Name with match case
    @Test
    public void userIsAbleToSearchByNameMatchCase() {

        String searchRequest = "bon";
        testedPage.search().clearString().sendString(searchRequest);
        testedPage.checkbox().check();

        String tableResult = testedPage.tableResume().visibleText();

        Assert.assertTrue(tableResult.startsWith("Showing 0"));
    }

    //3. Search for Customer by City
    @Test
    public void userIsAbleToSearchCustomerByCity() {

        String searchCity = "Belfast";
        testedPage.search().clearString().sendString(searchCity);
        testedPage.dropDown().selectByText("City");

        String tableCityResult = testedPage.customerTable().rows().get(0).cells().get(3).visibleText();

        Assert.assertTrue(tableCityResult.contains(searchCity));
    }



    @AfterTest
    public void afterTest() {

    }

    @AfterSuite
    public void afterSuite() {
        baseDriver.getWebDriver().close();
    }



    }

