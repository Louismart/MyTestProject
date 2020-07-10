package framework.elements;

import framework.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageDropDown extends BaseElement {

    private static By optionsLocator = By.xpath("option");

    public PageDropDown(BaseDriver baseDriver, WebElement webElement, By locator) {
        super(baseDriver, webElement, locator);
    }

    public List<Button> options() {
        return findElements(Button.class, optionsLocator);
    }

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
