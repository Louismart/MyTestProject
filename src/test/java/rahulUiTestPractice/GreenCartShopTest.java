package rahulUiTestPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        WebDriverWait wait = new WebDriverWait(driver, 20);
        int j = 0;
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Tomato"}; // declare Array with the list of vegetables
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("h4.product-name")));  // generic element for all 30 product

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
                Assert.assertTrue(itemsNeededList.contains(formattedName), "Verifying that itemsNeededList contains our needed products");

                List<WebElement> addToCartButton = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='product-action']/button")));
                addToCartButton.get(i).click();
                Assert.assertTrue(addToCartButton.size() > 0);
                //3 times
                if (j==itemsNeeded.length) {
                    break;
                }

            }
        }
        WebElement busketButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='cart-icon']/img")));
        busketButton.click();
        WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='action-block']/button")));
        proceedToCheckoutButton.click();
        String promoKey = "rahulshettyacademy";

        WebElement promocode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
        promocode.sendKeys(promoKey);
        //Assert.assertTrue(promocode.contains("rahulshettyacademy"));

        WebElement applyPromo = wait.until(ExpectedConditions.elementToBeClickable(By.className("promoBtn")));
        applyPromo.click();

        WebElement codeApplied = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Code applied ..!')]")));//driver.findElement(By.xpath("//span[contains(text(),'Code applied ..!')]"));
        Assert.assertTrue(true, codeApplied.getAttribute("Code applied ..!"));
        Assert.assertFalse(false, codeApplied.getAttribute("Invalid code ..!") ); //for negative test
        Assert.assertFalse(false, codeApplied.getAttribute("Empty code ..!") ); //for negative test

        WebElement placeOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Place Order')]")));
        placeOrder.click();

        //Choose country dropdown
        String searchCountryValue = "Poland";
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root']//select")));
        countryDropdown.click();
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByValue("Poland");
        String dropdownValue = dropdown.getFirstSelectedOption().getText();
        Assert.assertTrue(dropdownValue.contains(searchCountryValue));

        //Agree checkbox
        if (!driver.findElement(By.className("chkAgree")).isSelected()) {
            WebElement agreeCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.className("chkAgree")));
            agreeCheckbox.click();
        }

        if (driver.findElement(By.className("chkAgree")).isSelected()) {
            WebElement agreeCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.className("chkAgree")));
            //agreeCheckbox.click();
        }
        //count the number of checkboxes
        List<WebElement> listOfCheckboxElements =  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("chkAgree")));
        Assert.assertFalse(!driver.findElement(By.className("chkAgree")).isSelected(), "If checkbox is not selected");
        //Assert.assertTrue(!driver.findElement(By.xpath("//div[@id='ctl00_mainContent_SeniorCitizenDiv']")).isSelected(), "If checkbox is selected");
        Assert.assertTrue(listOfCheckboxElements.size() > 0, "Check , if number of checkboxes greater than 0");
        //Click on proceed button
        WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Proceed')]")));
        proceedButton.click();
    }

        /*  Wrap all find elements into Explicit Wait
        after products would be added to cart - done
        proceed to checkoutButton -
        In the field Enter promo code - input rahulshettyacademy, press Apply button
        verify if Promo code applied successfully! text is present
        Place order button  - done
        choose country - done
        Agree checkbox, Assert
        Proceed button, Assert
        */


    @AfterTest
    public void closeAndQuit() {
        driver.close();
        if (driver != null) {
            driver.quit();

        }
      }

}
