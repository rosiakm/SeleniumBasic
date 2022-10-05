package basic.form;

import base.TestBase;
import helpers.DataFaker;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static helpers.FilesHandler.countTheFiles;
import static helpers.FilesHandler.getTheListOfFiles;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FormTest extends TestBase {

    private final DataFaker dataFaker = new DataFaker();
    private final File file = new File("src/main/resources/file.txt");
    private static Logger log = LoggerFactory.getLogger(FormTest.class);
    private final String websiteAddress = "https://seleniumui.moderntester.pl/form.php";

    @Test
    @Tag("Form")
    @Order(1)
    public void fillFormWithValidValuesTest() {
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        FormPage formPage = new FormPage();
        formPage.provideFirstName(dataFaker.setFirstName());
        formPage.provideLastName(dataFaker.setLastName());
        formPage.provideEmail(dataFaker.setEmail());
        formPage.getRandomGender();
        formPage.provideRandomAge();
        formPage.selectRandomExperience();
        formPage.selectAutomationTesterCheckbox();
        formPage.selectRandomContinent();
        formPage.selectCommandsOptions();
        formPage.sendFile(file);
        formPage.clickTheSignInButton();
        assertThat(formPage.getValidationMessage()).isEqualTo("Form send with success");
    }

    @Test
    @Tag("Form")
    @Order(2)
    public void downloadFilesTest() throws InterruptedException {
        getDriver().get(websiteAddress);
        log.info("Website address is: " + websiteAddress);
        int startNbrOfFiles = countTheFiles();
        log.info("Starting number of files: " + startNbrOfFiles);
        new FormPage().clickOnDownloadButton();
        Thread.sleep(2000);
        int endNbrOfFiles = countTheFiles();

        assertThat(endNbrOfFiles).isEqualTo(startNbrOfFiles + 1);
    }

    @Test
    @Tag("Form")
    @Order(3)
    public void checkTheFileNameTest() {
        File fileName = new File("C:\\Users\\matros\\IdeaProjects\\SeleniumBasic\\downloads\\test-file-to-download.xlsx");
        assertThat(getTheListOfFiles()).contains(fileName);
    }
}