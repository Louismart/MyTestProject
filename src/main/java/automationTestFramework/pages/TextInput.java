package automationTestFramework.pages;

import framework.elements.TextInputString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextInput extends BaseElement {

    public TextInput(WebDriver driver, WebElement element, By locator) {
        super(driver, element, locator);

    }

    public TextInput sendString(CharSequence... charSequences) {
        element.sendKeys(charSequences);
        return this;
    }


    public TextInput clearString() {
        element.clear();
        return this;
    }

}
