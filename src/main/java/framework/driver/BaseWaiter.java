package framework.driver;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class BaseWaiter {
    private WebDriverWait wait;

    public BaseWaiter(WebDriverWait wait) {
        this.wait = wait;
        wait.ignoring(NotFoundException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchElementException.class);
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
