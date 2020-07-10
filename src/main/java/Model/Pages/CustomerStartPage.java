package Model.Pages;

import framework.driver.BaseDriver;
import framework.elements.*;
import framework.pages.BaseStartPage;
import org.openqa.selenium.By;

public class CustomerStartPage extends BaseStartPage {

    private static By searchFieldLocator = By.id("search-input");

    private static By searchDropDownLocator = By.id("search-column");

    private static By matchCaseCheckBoxLocator = By.id("match-case");

    private static By customerTableLocator = By.xpath("//table[@class = 'table table-hover']");

    private static By tableResumeLocator = By.id("table-resume");

    public CustomerStartPage(BaseDriver baseDriver, String link) {
        super(baseDriver, link);
    }

    public TextInputString search() {
        return element(TextInputString.class, searchFieldLocator);
    }

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

}
