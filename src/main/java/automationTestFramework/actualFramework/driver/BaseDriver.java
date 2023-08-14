package automationTestFramework.actualFramework.driver;

import automationTestFramework.actualFramework.elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class BaseDriver {
    //class variables

    private WebDriver webDriver;

    private BaseWaiter baseWaiter;

    private  int defaultWaitIntSeconds;

// Class constructor
    public BaseDriver(WebDrivers driver, int defaultWaitIntSeconds) {
        this.defaultWaitIntSeconds = defaultWaitIntSeconds;
        this.webDriver = DriverFactory.getDriver(driver);  // refer to driverFactory
        this.baseWaiter = new BaseWaiter(new WebDriverWait(webDriver, defaultWaitIntSeconds));


    }
//Getters in order to call them if it needs
    public WebDriver getWebDriver() {
        return webDriver;
    }

    public BaseWaiter getBaseWaiter() {
        return baseWaiter;
    }

////   Wrapper which return element + waiter, method inplementation at the bottom of this class
    public <T extends BaseElement> T findElement(Class<T> clazz, By locator){
        WebElement webElement = baseWaiter.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        return createElement(clazz, webElement, locator);
    }
// Wrapper which return list of elements + waiter
    public  <T extends  BaseElement> List<T> findElements(Class<T> clazz, final By locator){
        List<WebElement> elements = baseWaiter.getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        if (elements.size()> 0)
        {
            List<T> list = new ArrayList<>();
            for (WebElement baseElement : elements) {
                T element = createElement(clazz, baseElement, locator);
                list.add(element);
            }
            return list;
        }
        return null;
    }

    //create element
    private <T extends BaseElement> T createElement(Class<T> clazz, WebElement webElement, By locator){
        try {
            return clazz.getConstructor(BaseDriver.class, WebElement.class, By.class)
                    .newInstance(this, webElement, locator);
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
//maximize browser window
    public void maximize() {
        webDriver.manage().window().maximize();
    }


    public void closeAndQuit(){
        webDriver.close();
        if(webDriver != null){
            webDriver.quit();
        }
    }
}
