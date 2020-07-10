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


    @Test
    public void userIsAbleToSearchByName() {
        //act
        String searchRequest = "Bon";
        testedPage.search().clearString().sendString(searchRequest);
        //arrange
        String searchName = testedPage.customerTable().rows().get(0).cells().get(1).visibleText();
        //assert
        Assert.assertTrue(searchName.contains(searchRequest));
    }

    @Test
    public void userIsAbleToSearchByNameMatchCase() {
        //act
        String searchRequest = "bon";
        testedPage.search().clearString().sendString(searchRequest);
        testedPage.checkbox().check();
        //arrange
        String tableResult = testedPage.tableResume().visibleText();
        //assert
        Assert.assertTrue(tableResult.startsWith("Showing 0"));
    }

    @Test
    public void userIsAbleToSearchCustomerByCity() {
        //act
        String searchCity = "Belfast";
        testedPage.search().clearString().sendString(searchCity);
        testedPage.dropDown().selectByText("City");
        //arrange
        String tableCityResult = testedPage.customerTable().rows().get(0).cells().get(3).visibleText();
        //assert
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

