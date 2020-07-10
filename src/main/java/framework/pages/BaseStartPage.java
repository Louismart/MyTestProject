package framework.pages;

import framework.driver.BaseDriver;

public abstract class BaseStartPage extends BasePage {

    private String link;

    public BaseStartPage(BaseDriver baseDriver, String link) {
        super(baseDriver);
        this.link = link;
    }

    public void openUrl(){
        getBaseDriver().getWebDriver().navigate().to(link);
    }
}
