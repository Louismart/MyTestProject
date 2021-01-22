package Model.Pages;

import framework.driver.BaseDriver;
import framework.elements.*;
import framework.pages.BaseStartPage;
import org.openqa.selenium.By;

public class CustomerStartPage extends BaseStartPage {

    //All elements form the page

    private static By searchFieldLocator = By.id("search-input");

    private static By searchDropDownLocator = By.id("search-column");

    private static By matchCaseCheckBoxLocator = By.id("match-case");

    private static By customerTableLocator = By.xpath("//table[@class = 'table table-hover']");

    private static By tableResumeLocator = By.id("table-resume");

    private static By clearButtonLocator = By.id("clear-button");


    //class constructor
    public CustomerStartPage(BaseDriver baseDriver, String link) {
        super(baseDriver, link);
    }

    //return element to BasePage , used to in Test
    public TextInputString search() {
        return element(TextInputString.class, searchFieldLocator);
    }

    //return element to BasePage , used to in Test
    public PageDropDown dropDown() {
        return element(PageDropDown.class, searchDropDownLocator);
    }

    public SimpleCheckbox checkbox() {
        return element(SimpleCheckbox.class, matchCaseCheckBoxLocator);
    }

    public Table customerTable() {
        return element(Table.class, customerTableLocator);
    }

    public TextLabelElement tableResume() {
        return element(TextLabelElement.class,  tableResumeLocator);
    }

    public Button clearButton() {
        return element(Button.class, clearButtonLocator);
    }


    }



