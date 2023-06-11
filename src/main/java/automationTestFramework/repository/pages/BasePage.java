package automationTestFramework.repository.pages;

import automationTestFramework.repository.elements.BaseElement;
import automationTestFramework.repository.driver.BaseDriver;
import org.openqa.selenium.By;

import java.util.List;

public abstract class BasePage {
    private BaseDriver baseDriver;

    //Getter
    public BaseDriver getBaseDriver() {
        return baseDriver;
    }

    //class constructor
    public BasePage(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
    }

    //
    public <T extends BaseElement> T element(Class<T> clazz, By locator) {
        return baseDriver.findElement(clazz, locator);
    }

    //
    public <T extends BaseElement> List<T> elements(Class<T> clazz, final By locator) {
        return baseDriver.findElements(clazz, locator);
    }
}
