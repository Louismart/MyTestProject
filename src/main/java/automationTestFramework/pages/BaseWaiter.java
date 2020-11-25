package automationTestFramework.pages;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class BaseWaiter {

    private WebDriverWait wait;
    private WebDriver driver;

    //Class constructor
    public BaseWaiter(WebDriverWait wait) {
        this.driver = driver;   ///is it need?
        this.wait = new WebDriverWait(driver, 10);

        //to ignore flagged exceptions
        wait.ignoring(NotFoundException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchElementException.class);
       // this.baseWaiter = new BaseWaiter(new WebDriverWait(webDriver, defaultWaitIntSeconds));
    }
    //Getter
    public WebDriverWait getWait() {
        return wait;
    }
}
