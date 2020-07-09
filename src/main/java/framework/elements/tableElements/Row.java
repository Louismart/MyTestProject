package framework.elements.tableElements;

import framework.driver.BaseDriver;
import framework.elements.BaseElement;
import framework.elements.TextLabelElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Row extends BaseElement {

    private static By cellsLocator = By.xpath("td");

    public Row(BaseDriver baseDriver, WebElement webElement, By locator) {
        super(baseDriver, webElement, locator);
    }

    public List<TextLabelElement> cells(){
        return findElements(TextLabelElement.class, cellsLocator);
    }
}
