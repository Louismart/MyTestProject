package automationTestFramework.repository.elements.tableElements;

import automationTestFramework.repository.elements.BaseElement;
import automationTestFramework.repository.driver.BaseDriver;
import automationTestFramework.repository.elements.TextLabelElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Row extends BaseElement {

    //locator row
    private static By cellsLocator = By.xpath("td");

    //constructor which inherited from BaseDriver
    public Row(BaseDriver baseDriver, WebElement webElement, By locator) {
        super(baseDriver, webElement, locator);

    }
// return list of elements from cells referred to TextLableElement class
    public List<TextLabelElement> cells() {
        return findElements(TextLabelElement.class, cellsLocator);
    }
}
