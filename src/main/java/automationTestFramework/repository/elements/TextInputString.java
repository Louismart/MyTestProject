package automationTestFramework.repository.elements;

import automationTestFramework.repository.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextInputString extends BaseElement {

    //take parameters from BaseElement class
    public TextInputString(BaseDriver baseDriver, WebElement webElement, By locator) {
        super(baseDriver, webElement, locator);
    }

    //Implements sendKeys method, used to in Test
    public TextInputString sendString(CharSequence... charSequences) {
        webElement.sendKeys(charSequences);
        return this;
    }


    public TextInputString clearString() {
        webElement.clear();
        return this;
    }
}
