package automationTestFramework.pages;

import framework.driver.BaseWaiter;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BaseElement {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElement element;
    protected By locator;


    public BaseElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.locator = locator;
        //this.baseWaiter = new BaseWaiter(new WebDriverWait(webDriver, defaultWaitIntSeconds));

    }

    public BaseElement(WebDriver driver, WebElement element, By locator) {
        this.driver = driver;
        this.element = element;
        this.locator = locator;
    }

    public boolean isVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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

//        try {
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
//        } catch (TimeoutException ex) {
//
//            System.out.println("Something went wrong in buttonsListPresent");
//        }
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> searchWebElements() {
        return driver.findElements(locator);

        }





}




