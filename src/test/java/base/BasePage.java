package base;

import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(TestBase.getDriver(),this);
    }
}
