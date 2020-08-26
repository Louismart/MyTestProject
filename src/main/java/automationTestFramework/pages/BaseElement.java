package automationTestFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseElement {

    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected By locator;


    public BaseElement(WebDriver driver, By locator) {
        this.webDriver = driver;
        this.wait = wait;
        this.locator = locator;

    }
    public boolean isVisible(){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (TimeoutException ex){
            return  false;
        }
        return true;
    }
}




