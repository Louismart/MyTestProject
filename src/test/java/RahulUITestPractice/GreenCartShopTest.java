package RahulUITestPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class GreenCartShopTest {

    private ChromeDriver driver;

    @BeforeTest
    public void beforeTests() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
    }

    @Test
    public void selectProductsToBusket() {

        String[] vegetableNames  = {"Cucumber - 1 Kg", "Brocolli - 1 Kg", "Beetroot - 1 Kg"}; // declare Array with the list of needed vegetables

       //Click Cucumber using list of elements, because have no unique locator there
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); // generic element for all 30 products
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            //check weather name you extracted is present in array or not
            //convert array into ArrayList
            List allVegetablesList = Arrays.asList(vegetableNames);
            if (allVegetablesList.contains(name)) {
                //if (name.contains("Cucumber")) {  if we opt only Cucumber into the busket
                //click on Add to CART
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
            }
        }

    }

    @Test
    public void selectProductToBusketAndProceedToCheckout() throws InterruptedException {
        //Using right unique names, without -1 kg
        int j = 0;
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Tomato"}; // declare Array with the list of vegetables
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); // generic element for all 30 product
        for (int i = 0; i < products.size(); i++) {

            //need to split Brocolli |- 1 kg|, using split method
            //to Brocolli,  1 kg
            String[] name = products.get(i).getText().split("-"); //using .split , variable was changed to Array
            String formattedName = name[0].trim(); //delete Space "-",by trim
            /* format it into get actual vegetables name
            convert Array into ArrayList for easy search
            check, whether name you extracted is present in ArrayList or not */
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);


            if(itemsNeededList.contains(formattedName)) {
                j++;
                //click to Add to Cart
                Thread.sleep(1000);
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                //3 times
                if (j==itemsNeeded.length) {
                    break;
                }

            }
        }
        /*  Wrap all find elements into
        after products would be added to cart,
        proceed to checkoutButton
        In the field Enter promo code - input rahulshettyacademy, press Apply button
        verify if Promo code applied succsessfully! text is present
        Place order button


        */


    }

    @AfterTest
    public void closeAndQuit() {
        driver.close();
        if (driver != null) {
            driver.quit();

        }
    }

}
