package automationTestFrameworkTests;

import automationTestFramework.NotCompletedTask.Pages.pages.model.CustomerStartPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class Tests extends BaseTests {

    protected CustomerStartPage testedPage;


    @BeforeClass
    public void customerPageInitialization() {
        testedPage = new CustomerStartPage(baseDriver, path + "\\ui\\index.html");

    }

    @BeforeMethod
    public void init() {
        testedPage.openUrl();
    }

    @AfterMethod
    public void afterMethod() {
        testedPage.search().clearString();
    }


    //1. Search for Customer by Name
    @Test
    public void userIsAbleToSearchByName() {

        String searchRequest = "Bon";
        testedPage.search().sendString(searchRequest);
        String searchName = testedPage.customerTable().rows().get(0).cells().get(1).visibleText();
        Assert.assertTrue(searchName.contains(searchRequest));
    }

    // 2. Search for Customer by Name with match case and check filter
    @Test
    public void userIsAbleToSearchByNameMatchCase() {

        String searchRequest = "bon";
        testedPage.search().sendString(searchRequest);
        testedPage.checkbox().check();
        String tableResult = testedPage.tableResume().visibleText();
        Assert.assertTrue(tableResult.startsWith("Showing 0"));

    }

    //3. Search for Customer by City
    @Test
    public void userIsAbleToSearchCustomerByCity() {

        String searchCity = "Belfast";
        testedPage.search().sendString(searchCity);
        testedPage.dropDown().selectByText("City");
        String tableCityResult = testedPage.customerTable().rows().get(0).cells().get(3).visibleText();
        Assert.assertTrue(tableCityResult.contains(searchCity));


    }

    @Test
    public void userIsAbleToSearchCustomerByMail() {

        String searchEmail = "bond";
        testedPage.search().sendString(searchEmail);
        testedPage.dropDown().selectByText("Email");
        String tableEmailResult = testedPage.customerTable().rows().get(0).cells().get(2).visibleText();
        Assert.assertTrue(tableEmailResult.contains(searchEmail));

    }

    @Test
    public void userIsAbleClickFiltersButtonWhenSearchResultnIsNotExist() {

        String searchInvalidText = "xxx";
        testedPage.search().sendString(searchInvalidText);
        String tableResumeResult = testedPage.tableResume().visibleText();
        Assert.assertTrue(tableResumeResult.startsWith("Showing 0 of 3"));
        testedPage.clearButton().click();
        int tableRowsCount = testedPage.customerTable().rows().size();
        Assert.assertTrue(tableRowsCount > 0);


    }

    @Test
    public void userIsAbleToSearcNameM() {

        String searchRequest = "bon";
        testedPage.search().sendString(searchRequest);
        testedPage.checkbox().check();
        String tableResult = testedPage.tableResume().visibleText();
        Assert.assertTrue(tableResult.startsWith("Showing 0"));


    }

}


