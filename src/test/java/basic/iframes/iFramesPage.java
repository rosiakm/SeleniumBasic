package basic.iframes;

import base.BasePage;
import helpers.DataFaker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

import static base.TestBase.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class iFramesPage extends BasePage {
    private final DataFaker dataFaker = new DataFaker();
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

    public iFramesPage(){
        super();
        log.info("Elements on the website are initialized");
    }

    public void fillAllFramesOnTheSite(){
        TestBase.getDriver().switchTo().frame(iFrameOne);
        log.info("Switched to iFrame nr 1");
        firstNameInput.sendKeys(dataFaker.setFirstName());
        surnameInput.sendKeys(dataFaker.setLastName());
        log.info("Fields in iFrame nr 1 has been filled");
        TestBase.getDriver().switchTo().defaultContent();
        log.info("Switch back to default content");
        TestBase.getDriver().switchTo().frame(iFrameTwo);
        log.info("Switched to iFrame nr 2");
        loginInput.sendKeys("matros");
        passwordInput.sendKeys("12345");
        new Select(selectDropDownList).selectByValue("europe");
        Assertions.assertThat(radioButtons.size()).isGreaterThan(0);
        radioButtons.get(random.nextInt(7)).click();
        log.info("Fields and selects in iFrame nr 2 has been filled");
        TestBase.getDriver().switchTo().defaultContent();
        log.info("Switch back to default content");
        basicLinkText.click();
        log.info("Basic button has been clicked");
    }
}
