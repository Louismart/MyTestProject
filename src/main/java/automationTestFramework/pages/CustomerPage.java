package automationTestFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomerPage {

    private WebDriver driver;



    public static By searchFieldLocator = By.id("search_query_top");

    public static By signInLocator = By.className("login");

    public static By contactUsLocator = By.xpath("//div[@id='contact-link']//a[contains(text(),'Contact us')]");

    public static By logoLocator = By.xpath("//img[@class='logo img-responsive']");

    public static By shoppingCardLocator = By.xpath("//div[@class='shopping_cart']/a[1]");

    public static By womanDropDownButtonLocator = By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]");

    public static By dressesDropDownLocator = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[@class='sfHoverForce']");

    public static By tshirtsDropDownLocator = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[1]");

    public static By phoneNumberLocator = By.xpath("//strong[contains(text(),'0123-456-789')]");

    public static By homeslideDescriptionLocator = By.xpath("//div[@id='slider_row']//li[4]//div[1]");

    public static By image1Locator = By.xpath("//div[@id='htmlcontent_top']//li[1]//img[1]");

    public static By image2Locator = By.xpath("//div[@id='htmlcontent_top']//li[2]//img[1]");

    public static By newsLatterlocator = By.xpath("//h4[contains(text(),'Newsletter')]");

    public static By emailInputFieldLocator = By.xpath("//h4[contains(text(),'Newsletter')]");

    public static By popularButtonLocator = By.className("homefeatured");

    public static By bestSellersButtonLocator = By.className("blockbestsellers");

    public static By gridButtonlocator = By.xpath("//a[contains(text(),'Grid')]");

    public static By listButtonLocator = By.xpath("//i[@class='icon-th-list']");

    public static By searchFieldShortLocator = By.xpath("//li//div[1]//a[1]//img[1]");


    public CustomerPage(WebDriver driver) {

        this.driver = driver;
    }

    public TextLabelElement searchField = new TextLabelElement(driver, searchFieldLocator);
    public TextLabelElement contactUs = new TextLabelElement(driver, contactUsLocator);
    public TextLabelElement signIn = new TextLabelElement(driver, signInLocator);
    public TextLabelElement logo = new TextLabelElement(driver, logoLocator);
    public TextLabelElement shoppinCard = new TextLabelElement(driver, shoppingCardLocator);
    public TextLabelElement womanDropDown = new TextLabelElement(driver, womanDropDownButtonLocator);
    public TextLabelElement phoneNumber = new TextLabelElement(driver, phoneNumberLocator);
    public TextLabelElement dressesDropDown = new TextLabelElement(driver, dressesDropDownLocator);
    public TextLabelElement tshortdropDown = new TextLabelElement(driver, tshirtsDropDownLocator);
    public TextLabelElement homeSlidesDescription = new TextLabelElement(driver, homeslideDescriptionLocator);
    public TextLabelElement image1 = new TextLabelElement(driver, image1Locator);
    public TextLabelElement image2 = new TextLabelElement(driver, image2Locator);
    public TextLabelElement popularButtonT = new TextLabelElement(driver, popularButtonLocator);
    public TextLabelElement bestSellers = new TextLabelElement(driver, bestSellersButtonLocator);
    public TextLabelElement newsLetter = new TextLabelElement(driver, newsLatterlocator);
    public TextLabelElement emailInputField = new TextLabelElement(driver, emailInputFieldLocator);



    public boolean IsLoaded(){

        return searchField.isVisible() && contactUs.isVisible();     // && lableKakojto2.IsVisible();
    }


}
