package automationTestFramework.repository.elements;

import automationTestFramework.repository.driver.BaseDriver;
import automationTestFramework.repository.elements.tableElements.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Table extends BaseElement {

    //general table xpath
    public static By rowsLocator = By.xpath("tbody/tr");

    //take parameters from BaseElement class
    public Table(BaseDriver baseDriver, WebElement webElement, By locator) {
        super(baseDriver, webElement, locator);
    }
    //return list of elements with row and rowsLocator referred to BaseElement class
    public List<Row> rows() {
        return findElements(Row.class, rowsLocator);
    }
}
