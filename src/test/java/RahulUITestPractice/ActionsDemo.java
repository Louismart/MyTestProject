package RahulUITestPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class ActionsDemo {

    private ChromeDriver driver;

    @BeforeTest
    public void beforeTests() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.get("https://www.amazon.com/"); // for test amazon
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");  // for windows handles test
        driver.manage().window().maximize();
    }

    @Test
    public void amazonMouseActionsTest() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //WebElement originDestinationLocator = wait.until
        Actions a = new Actions(driver);
        WebElement accountAndListDropDownLocator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-link-accountList")));
        //Move to specific element
        a.moveToElement(accountAndListDropDownLocator).build().perform();

        WebElement searchFieldLocator = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#twotabsearchtextbox")));

        a.moveToElement(searchFieldLocator).click()
                .keyDown(Keys.LEFT_SHIFT)
                .sendKeys("hello")
                .build()
                .perform();
        a.moveToElement(accountAndListDropDownLocator).contextClick().build().perform();  //click right mouse button



    }
    @Test
    public void getWindowsHandlesTest() {

        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); //[parentId, childId]


    }
}
