package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        log.info("Elements on the website are initialized");
    }
}
