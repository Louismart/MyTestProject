package framework.elements;

import framework.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseElement {

    protected BaseDriver baseDriver;
    protected WebElement webElement;
    private By locator;

    public BaseElement(BaseDriver baseDriver, WebElement webElement, By locator) {
        this.baseDriver = baseDriver;
        this.webElement = webElement;
        this.locator = locator;

    }

    public WebElement getWebElement() {
        return webElement;
    }

    public String visibleText() {
        return baseDriver.getBaseWaiter().getWait().until(ExpectedConditions.visibilityOf(webElement)).getText();
    }

    public <T extends BaseElement> T findElement(Class<T> clazz, By locator) {
        WebElement webElement = baseDriver.getBaseWaiter().getWait().until(ExpectedConditions.presenceOfNestedElementLocatedBy(getWebElement(), locator));
        return createElement(clazz, webElement, locator);
    }

    public <T extends BaseElement> List<T> findElements(Class<T> clazz, final By locator) {
        List<WebElement> elements = baseDriver.getBaseWaiter().getWait().until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(getWebElement(), locator));
        if (elements.size() > 0) {
            List<T> list = new ArrayList<>();
            for (WebElement baseElement : elements) {
                T element = createElement(clazz, baseElement, locator);
                list.add(element);
            }
            return list;
        }
        return null;
    }

    private <T extends BaseElement> T createElement(Class<T> clazz, WebElement webElement, By locator) {
        try {
            return clazz.getConstructor(BaseDriver.class, WebElement.class, By.class)
                    .newInstance(baseDriver, webElement, locator);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}

