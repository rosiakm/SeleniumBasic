package widgets.menu;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static helpers.WaitHandler.waitForElementToBeClickable;

public class MenuPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(MenuPage.class);

    @FindBy(css = "#ui-id-9")
    private WebElement musicOption;
    @FindBy(css = "#ui-id-13")
    private WebElement jazzOption;
    @FindBy(css = "#ui-id-16")
    private WebElement modernOption;

    public MenuPage(WebDriver driver){
        super(driver);
    }

    public void clickOnMusicOption(){
        musicOption.click();
    }
    public void waitForJazzOptionToBeClickable(WebDriver driver){
        waitForElementToBeClickable(driver, jazzOption);
    }
    public void clickOnJazzOption(){
        jazzOption.click();
    }
    public void waitForModernOptionToBeClickable(WebDriver driver){
        waitForElementToBeClickable(driver, modernOption);
    }
    public void clickOnModernOption(){
        modernOption.click();
    }
}
