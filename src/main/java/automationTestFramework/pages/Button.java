package automationTestFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Button extends BaseElement {

    public Button(WebDriver driver, WebElement element, By locator) {
        super(driver, element, locator);

    }

//    public void click()
//    {
//                getBaseWaiter().getWait()
//                  .until(ExpectedConditions.elementToBeClickable(element))
//                  .click();
//    }

}
