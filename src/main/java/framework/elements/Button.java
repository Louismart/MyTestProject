package framework.elements;

import framework.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Button extends BaseElement {

    public Button(BaseDriver baseDriver, WebElement webElement, By locator) {
    super(baseDriver, webElement, locator);
}
    public void click()
    {
        baseDriver.getBaseWaiter().getWait()
                .until(ExpectedConditions.elementToBeClickable(webElement))
                .click();
    }
}
