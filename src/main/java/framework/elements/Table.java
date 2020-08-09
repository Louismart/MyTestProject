package framework.elements;

import framework.driver.BaseDriver;
import framework.elements.tableElements.Row;
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
    //return list of elements with row and rowsLocator refered to BaseElement class
    public List<Row> rows() {
        return findElements(Row.class, rowsLocator);
    }
}
