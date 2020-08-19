package automationTestFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultPage {

    public static WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;
    private By resultLocator = By.id("page");

//    public ResultPage(WebDriver driver, WebElement element) {
//        this.driver = driver;
//        this.element = element;
//        this.wait = new WebDriverWait(this.driver, 10);
//    }
//
//    public WebDriverWait getWait() {
//        return wait;
//    }
//
//    public WebDriver getDriver() {
//        return driver;
//    }
//
//    public WebElement getElement() {
//        return element;
//    }
//
//    public List<WebElement> getResults() {
//        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(resultLocator));
//    }
//
//    public WebElement visibleText() {
//        WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
//        return webElement;
//
//
//    }
//
// //   public void waitForPageLoad() {
//
////        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
////        wait.until(new Function<WebDriver, Boolean>() {
////            public Boolean apply(WebDriver driver) {
////                System.out.println("Current Window State       : "
////                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
////                return String
////                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
////                        .equals("complete");
////            }
////        });


    public static boolean isElementVisible(By by) {

            boolean value = false;

            if (driver.findElements(by).size() > 0) {
                value = true;
            }
            return value;



    }
}
