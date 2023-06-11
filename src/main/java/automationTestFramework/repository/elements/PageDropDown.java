package automationTestFramework.repository.elements;

import automationTestFramework.repository.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageDropDown extends BaseElement {

    //locator option for: Id, Name, Email, City
    private static By optionsLocator = By.xpath("option");

    //take parameters from BaseElement
    public PageDropDown(BaseDriver baseDriver, WebElement webElement, By locator) {
        super(baseDriver, webElement, locator);
    }

    //list of buttons within option locator
    public List<Button> options() {
        return findElements(Button.class, optionsLocator);
    }

    //method describes wrapper with visibleText+ waiters implementation  used to in test
    public void selectByText(String text) {
        webElement.click();
        Button option = null;
        for (Button opt : options()) {
            if (opt.visibleText().equals(text)) {
                option = opt;
                break;
            }
        }
        if (option != null) {
            option.click();
        } else throw new IllegalArgumentException("Value is not found on dropdown list value: " + text);
    }
}
