package basic.form;

import base.BasePage;
import helpers.DataFaker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Random;

import static base.TestBase.getDriver;
import static helpers.FilesHandler.countTheFiles;
import static helpers.FilesHandler.getTheListOfFiles;
import static org.assertj.core.api.Assertions.assertThat;

public class FormPage extends BasePage {
    private final DataFaker dataFaker = new DataFaker();
    private final Random random = new Random();
    private File file = new File("src/main/resources/file.txt");
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

    public FormPage() {
        super();
    }

    public void fillFormWithSuccess() {
        firstNameInput.sendKeys(dataFaker.setFirstName());
        lastNameInput.sendKeys(dataFaker.setLastName());
        emailInput.sendKeys(dataFaker.setEmail());
        assertThat(sexRadioButtons.size()).isGreaterThan(0);
        sexRadioButtons.get(random.nextInt(sexRadioButtons.size())).click();
        ageInput.sendKeys(Integer.toString(random.nextInt(18, 100)));
        assertThat(experienceRadioButtons.size()).isGreaterThan(0);
        experienceRadioButtons.get(random.nextInt(experienceRadioButtons.size())).click();
        automationTesterCheckbox.click();
        assertThat(continentsOptions.size()).isGreaterThan(0);
        new Select(selectContinents).selectByIndex(random.nextInt(continentsOptions.size()));
        new Actions(getDriver()).keyDown(Keys.CONTROL).click(switchCommandsOption).
                click(waitCommandsOption).build().perform();
        fileInput.sendKeys(file.getAbsolutePath());
        log.info("The form has been filled");
        signInButton.click();
        log.info("Sign in button has been clicked");

        assertThat(validationMessage.getText()).isEqualTo("Form send with success");
    }

    public void downloadFileFromForm() throws InterruptedException {
        int startNbrOfFiles = countTheFiles();
        log.info("Starting number of files: " + startNbrOfFiles);
        downloadButton.click();
        Thread.sleep(2000);
        int endNbrOfFiles = countTheFiles();

        assertThat(endNbrOfFiles).isEqualTo(startNbrOfFiles + 1);
    }

    public void checkTheFileName() {
        File fileName = new File("C:\\Users\\matros\\IdeaProjects\\SeleniumBasic\\downloads\\test-file-to-download.xlsx");
        assertThat(getTheListOfFiles()).contains(fileName);
    }
}
