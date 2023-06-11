package automationTestFramework.repository.driver;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class BaseWaiter {
    private WebDriverWait wait;

    //Class constructor
    public BaseWaiter(WebDriverWait wait) {
        this.wait = wait;
        //to ignore flagged exceptions
        wait.ignoring(NotFoundException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchElementException.class);
    }
//Getter
    public WebDriverWait getWait() {
        return wait;
    }
}
