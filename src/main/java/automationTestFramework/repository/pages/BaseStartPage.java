package automationTestFramework.repository.pages;

import automationTestFramework.repository.driver.BaseDriver;

public abstract class BaseStartPage extends BasePage {

    private String link;

    //Use parameters from BaseDriver and initiate link
    public BaseStartPage(BaseDriver baseDriver, String link) {
        super(baseDriver);
        this.link = link;
    }

    // used to in Test for navigate referred
    public void openUrl(){
        getBaseDriver().getWebDriver().navigate().to(link);
    }
}
