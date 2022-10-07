package basic.iframes;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class iFramesPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(iFramesPage.class);
    private final Random random = new Random();

    @FindBy(css = "iframe[name=iframe1]")
    private WebElement iFrameOne;
    @FindBy(css = "iframe[name=iframe2]")
    private WebElement iFrameTwo;
    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInput;
    @FindBy(css = "#inputSurname3")
    private WebElement surnameInput;
    @FindBy(css = "#inputLogin")
    private WebElement loginInput;
    @FindBy(css = "#inputPassword")
    private WebElement passwordInput;
    @FindBy(css = "#inlineFormCustomSelectPref")
    private WebElement selectDropDownList;
    @FindBy(css = "div [class='form-check']")
    private List<WebElement> radioButtons;
    @FindBy(linkText = "Basic")
    private WebElement basicLinkText;

    public iFramesPage(WebDriver driver){
        super(driver);
        log.info("Elements on the website are initialized");
    }

    public void switchToIFrameOne(WebDriver driver){
        driver.switchTo().frame(iFrameOne);
        log.info("Switched to iFrame nr 1");
    }
    public void setFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }
    public void setSurname(String surname){
        surnameInput.sendKeys(surname);
    }
    public void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
        log.info("Switch back to default content");
    }
    public void switchToIFrameTwo(WebDriver driver){
        driver.switchTo().frame(iFrameTwo);
        log.info("Switched to iFrame nr 2");
    }
    public void setLogin(String login){
        loginInput.sendKeys(login);
    }
    public void setPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void selectFromDropdownListByValue (String continent){
        new Select(selectDropDownList).selectByValue(continent);
    }
    public void getRandomRadioButton(){
        assertThat(radioButtons.size()).isGreaterThan(0);
        radioButtons.get(random.nextInt(7)).click();
    }
    public void clickOnBasicLinkText(){
        basicLinkText.click();
        log.info("Basic button has been clicked");
    }
}
