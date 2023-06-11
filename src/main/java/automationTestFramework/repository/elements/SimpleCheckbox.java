package automationTestFramework.repository.elements;

import automationTestFramework.repository.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SimpleCheckbox extends BaseElement {

    //take parameters from BaseElement
    public SimpleCheckbox(BaseDriver baseDriver, WebElement webElement, By locator) {
        super(baseDriver, webElement, locator);
    }

    //checkBox implementation if unpressed
    public void check(){
        if(!webElement.isSelected()){
            webElement.click();
        }
    }

    //checkBox implementation if pressed
    public void uncheck(){
        if(webElement.isSelected()){
            webElement.click();
        }
    }
}
