package automationTestFramework.actualFramework.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormSubmission {

    public static void fillForm(WebDriver driver, String pageUrl) {

        driver.findElement(By.id("FirstName")).sendKeys("Fizz");
        driver.findElement(By.id("LastName")).sendKeys("Buzz");
        driver.findElement(By.id("Email")).sendKeys("fizz_buzz@hackerrank.com");
        driver.findElement(By.id("Password")).sendKeys("fizz_buzz@Hrw");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("c_fizz_buzz@Hrw");
        // fill form code goes here
    }
    public static void submitForm(WebDriver driver) {

        driver.findElement(By.id("Submit")).submit();
        // Assume this method is called only after calling fillForm(driver,url) method
    }

    public static void main(String[] args) {

        String pageUrl = "file:///selenium-java-form-submission/website/home.html";
        WebDriver driver = new ChromeDriver();

        FormSubmission.fillForm(driver,pageUrl);
        FormSubmission.submitForm(driver);

    }
}



