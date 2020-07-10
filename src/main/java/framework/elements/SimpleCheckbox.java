package framework.elements;

import framework.driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SimpleCheckbox extends BaseElement {

    public SimpleCheckbox(BaseDriver baseDriver, WebElement webElement, By locator) {
        super(baseDriver, webElement, locator);
    }

    public void check(){
        if(!webElement.isSelected()){
            webElement.click();
        }
    }

    public void uncheck(){
        if(webElement.isSelected()){
            webElement.click();
        }
    }
}
