package automationTestFramework.NotCompletedTask.Pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
