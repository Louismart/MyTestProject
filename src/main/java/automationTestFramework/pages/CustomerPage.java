package automationTestFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerPage {

    public static By searchFieldLocator = By.id("search_query_top");

    public static By signInLocator = By.className("login");

    public static By contactUsLocator = By.xpath("//div[@id='contact-link']//a[contains(text(),'Contact us')]");

    public static By logoLocator = By.xpath("//img[@class='logo img-responsive']");

    public static By shoppingCard = By.xpath("//div[@class='shopping_cart']/a[1]");

    public static By womanDropDownButtonLocator = By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]");

    public static By dressesDropDownLocator = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[@class='sfHoverForce']");

    private static By tshirtsDropDownLocator = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[1]");

    public static By phoneNumber = By.xpath("//strong[contains(text(),'0123-456-789')]");

    public static By homeslideDescription = By.xpath("//div[@id='slider_row']//li[4]//div[1]");

    public static By image1 = By.xpath("//div[@id='htmlcontent_top']//li[1]//img[1]");

    public static By image2 = By.xpath("//div[@id='htmlcontent_top']//li[2]//img[1]");

    public static By newsLatter = By.xpath("//h4[contains(text(),'Newsletter')]");

    public static By emailInputField = By.xpath("//h4[contains(text(),'Newsletter')]");

    public static By popularButton = By.className("homefeatured");

    public static By bestSellersButton = By.className("blockbestsellers");

    public static By gridButton = By.xpath("//a[contains(text(),'Grid')]");

    public static By listButton = By.xpath("//i[@class='icon-th-list']");

    public static By searchFieldShort = By.xpath("//li//div[1]//a[1]//img[1]");


}
