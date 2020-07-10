package framework.elements;

import framework.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextInputString extends BaseElement {

    public TextInputString(BaseDriver baseDriver, WebElement webElement, By locator) {
        super(baseDriver, webElement, locator);
    }

    public TextInputString sendString(CharSequence... charSequences) {
        webElement.sendKeys(charSequences);
        return this;
    }

    public TextInputString clearString() {
        webElement.clear();
        return this;
    }
}
