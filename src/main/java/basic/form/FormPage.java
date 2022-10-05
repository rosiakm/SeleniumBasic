package basic.form;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class FormPage extends BasePage {
    private final Random random = new Random();
    private static final Logger log = LoggerFactory.getLogger(FormPage.class);

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInput;
    @FindBy(css = "#inputLastName3")
    private WebElement lastNameInput;
    @FindBy(css = "#inputEmail3")
    private WebElement emailInput;
    @FindBy(css = "input[name='gridRadiosSex']")
    private List<WebElement> sexRadioButtons;
    @FindBy(css = "#inputAge3")
    private WebElement ageInput;
    @FindBy(css = "input[name='gridRadiosExperience']")
    private List<WebElement> experienceRadioButtons;
    @FindBy(css = "#gridCheckAutomationTester")
    private WebElement automationTesterCheckbox;
    @FindBy(css = "#selectContinents")
    private WebElement selectContinents;
    @FindBy(css = "#selectContinents option")
    private List<WebElement> continentsOptions;
    @FindBy(css = "#selectSeleniumCommands option[value='switch-commands']")
    private WebElement switchCommandsOption;
    @FindBy(css = "#selectSeleniumCommands option[value='wait-commands']")
    private WebElement waitCommandsOption;
    @FindBy(css = "#chooseFile")
    private WebElement fileInput;
    @FindBy(css = "button[type='submit']")
    private WebElement signInButton;
    @FindBy(css = "#validator-message")
    private WebElement validationMessage;
    @FindBy(css = "a[class='btn btn-secondary btn-lg active']")
    private WebElement downloadButton;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void provideFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }
    public void provideLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }
    public void provideEmail(String email) {
        emailInput.sendKeys(email);
    }
    public void getRandomGender() {

        sexRadioButtons.get(random.nextInt(sexRadioButtons.size())).click();
    }
    public void provideRandomAge() {
        ageInput.sendKeys(Integer.toString(random.nextInt(18, 100)));
    }
    public void selectRandomExperience() {
        assertThat(experienceRadioButtons.size()).isGreaterThan(0);
        experienceRadioButtons.get(random.nextInt(experienceRadioButtons.size())).click();
    }
    public void selectAutomationTesterCheckbox() {
        automationTesterCheckbox.click();
    }
    public void selectRandomContinent() {
        assertThat(continentsOptions.size()).isGreaterThan(0);
        new Select(selectContinents).selectByIndex(random.nextInt(continentsOptions.size()));
    }
    public void selectCommandsOptions(WebDriver driver) {
        new Actions(driver).keyDown(Keys.CONTROL).click(switchCommandsOption).
                click(waitCommandsOption).build().perform();
    }
    public void sendFile(File file) {
        fileInput.sendKeys(file.getAbsolutePath());
    }
    public void clickTheSignInButton(){
        signInButton.click();
        log.info("Sign in button has been clicked");
    }
    public String getValidationMessage(){
        return validationMessage.getText();
    }
    public void clickOnDownloadButton(){
        downloadButton.click();
    }
}
