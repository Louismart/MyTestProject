package automationTestFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomerPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElement element;
    //private BaseWaiter baseWaiter;

    private TextInput searchField;
    private TextLabelElement buttonsSection;
    private TextLabelElement contactUs;
    private TextLabelElement signIn;
    private TextLabelElement logo;
    private TextLabelElement shoppinCard;
    private TextLabelElement womanDropDown;
    private TextLabelElement phoneNumber;
    private TextLabelElement dressesDropDown;
    private TextLabelElement tshortdropDown;
    private TextLabelElement homeSlidesDescription;
    private TextLabelElement image1;
    private TextLabelElement image2;
    private TextLabelElement popularButtonT;
    private TextLabelElement bestSellers;
    private TextLabelElement newsLetter;
    private TextLabelElement emailInputField;
    private TextLabelElement homePageTabs;
    private TextLabelElement gridButton;
    private TextLabelElement listButton;
    private TextLabelElement liActive;


    public static By searchFieldLocator = By.xpath("//input[@id='search_query_top']");

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

    public static By buttonsSectionLocator = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']");

    public static By homePageTabsLocator = By.id("home-page-tabs");

    public static By liActiveClassLocator = By.id("li");


    public CustomerPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

//    public TextInput search() {
//        return element(TextInput.class, searchFieldLocator);
//    }

    public TextInput getSearchField() {
        searchField = new TextInput(driver, element, searchFieldLocator);
        return searchField;
    }
    public TextLabelElement getButtonsSection() {
        buttonsSection = new TextLabelElement(driver, buttonsSectionLocator);
        return buttonsSection;
    }
    public TextLabelElement getContactUs() {
        contactUs = new TextLabelElement(driver, contactUsLocator);
        return contactUs;
    }
    public TextLabelElement getSignIn() {
        signIn = new TextLabelElement(driver, signInLocator);
        return signIn;
    }
    public TextLabelElement getLogo() {
        logo = new TextLabelElement(driver, logoLocator);
        return logo;
    }
    public TextLabelElement getShoppinCard() {
        shoppinCard = new TextLabelElement(driver, shoppingCardLocator);
        return shoppinCard;
    }
    public TextLabelElement getWomanDropDown() {
        womanDropDown = new TextLabelElement(driver, womanDropDownButtonLocator);
        return womanDropDown;
    }
    public TextLabelElement getPhoneNumber() {
        phoneNumber = new TextLabelElement(driver, phoneNumberLocator);
        return phoneNumber;
    }
    public TextLabelElement getDressesDropDown() {
        dressesDropDown = new TextLabelElement(driver, dressesDropDownLocator);
        return dressesDropDown;
    }
    public TextLabelElement getTshortdropDown() {
        tshortdropDown = new TextLabelElement(driver, tshirtsDropDownLocator);
        return tshortdropDown;
    }
    public TextLabelElement getHomeSlidesDescription() {
        homeSlidesDescription = new TextLabelElement(driver, homeslideDescriptionLocator);
        return homeSlidesDescription;
    }
    public TextLabelElement getImage1() {
        image1 = new TextLabelElement(driver, image1Locator);
        return image1;
    }
    public TextLabelElement getImage2() {
        image2 = new TextLabelElement(driver, image2Locator);
        return image2;
    }
    public TextLabelElement getPopularButtonT() {
        popularButtonT  = new TextLabelElement(driver, popularButtonLocator);
        return popularButtonT;
    }
    public TextLabelElement getBestSellers() {
        bestSellers = new TextLabelElement(driver, bestSellersButtonLocator);
        return bestSellers;
    }
    public TextLabelElement getNewsLetter() {
        newsLetter = new TextLabelElement(driver, newsLatterlocator);
        return newsLetter;
    }
    public TextLabelElement getEmailInputField() {
        emailInputField = new TextLabelElement(driver, emailInputFieldLocator);
        return emailInputField;
    }
    public TextLabelElement getHomePageTabs() {
        homePageTabs = new TextLabelElement(driver, homePageTabsLocator);
        return homePageTabs;
    }
    public TextLabelElement getGridButton() {
        gridButton = new TextLabelElement(driver, gridButtonlocator);
        return gridButton;
    }
    public TextLabelElement getListButton() {
        listButton = new TextLabelElement(driver, listButtonLocator);
        return listButton;

    }
    public TextLabelElement getLiActive() {
        liActive = new TextLabelElement(driver, liActiveClassLocator);
        return liActive;
    }
//    public BaseWaiter getBaseWaiter() {
//        baseWaiter = new BaseWaiter(wait );
//        return baseWaiter;
//    }


    public boolean isLoaded(){

        return getSearchField().isVisible() && getButtonsSection().isVisible() && getContactUs().isVisible()
                && getContactUs().isVisible() && getSignIn().isVisible() && getLogo().isVisible() && getPhoneNumber().isVisible()
                && getTshortdropDown().isVisible() && getShoppinCard().isVisible() && getWomanDropDown().isVisible()
                && getImage1().isVisible() && getImage2().isVisible() && getPopularButtonT().isVisible() && getBestSellers().isVisible()
                && getNewsLetter().isVisible() && getEmailInputField().isVisible() && getHomePageTabs().isVisible();

                 //&& getGridButton().isVisible();&& getListButton().isVisible();
                 // && getHomeSlidesDescription().isVisible();
                //&& getDressesDropDown().isVisible();
    }


    public boolean loadedElementsAreGreaterThanZero() {

       return getHomePageTabs().sizeOfLoadedElementsGreaterThanZero();
    }

    public List<WebElement> popularButton() {

        return getPopularButtonT().buttonsListIsPresent();
    }

    public List<WebElement> bestSellersButton() {

        return getBestSellers().buttonsListIsPresent();
    }

    public List<WebElement> homePageTabsSection() {

        return getHomePageTabs().buttonsListIsPresent();
    }

    public List<WebElement>liActiveClass() {

        return getLiActive().searchWebElements();
    }

//    public String visibleText() {
//        return getBaseWaiter().getWait().until(ExpectedConditions.visibilityOf(element)).getText();
//    }
    public WebElement search() {

        return getSearchField().searchWebElement();
    }


}
