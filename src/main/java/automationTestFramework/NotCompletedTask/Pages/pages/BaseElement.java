package automationTestFramework.NotCompletedTask.Pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BaseElement {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElement element;
    //public BaseWaiter baseWaiter;
    //private  int defaultWaitIntSeconds;
    protected By locator;


    public BaseElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.locator = locator;
       // this.baseWaiter = new BaseWaiter(new WebDriverWait(driver, 20));

    }

    public BaseElement(WebElement element, By locator) {

        this.element = element;
        this.locator = locator;
        this.wait = new WebDriverWait(driver, 20);
    }
    public BaseElement(WebDriver driver, WebElement element, By locator) {
        this.driver = driver;
        this.element = element;
        this.locator = locator;
        this.wait = new WebDriverWait(driver, 20);
    }


//    public BaseWaiter getBaseWaiter() {
//        return baseWaiter;
//    }


    public boolean isVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public boolean isClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public boolean sizeOfLoadedElementsGreaterThanZero() {

        boolean value = false;

        if (driver.findElements(locator).size() > 0) {
            value = true;
        }
        return value;
    }

    public List<WebElement> buttonsListIsPresent() {

        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> searchWebElements() {
        return driver.findElements(locator);

        }

        public WebElement searchWebElement() {

        return driver.findElement(locator);


        }





}




