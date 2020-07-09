package framework.elements;

import framework.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextLabelElement extends BaseElement {
    public TextLabelElement(BaseDriver baseDriver, WebElement webElement, By locator) {
        super(baseDriver, webElement, locator);

    }
}
