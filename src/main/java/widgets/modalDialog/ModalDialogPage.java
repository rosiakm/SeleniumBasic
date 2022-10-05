package widgets.modalDialog;

import base.BasePage;
import helpers.DataFaker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static helpers.WaitHandler.waitForElementToBeClickable;
import static org.assertj.core.api.Assertions.assertThat;

public class ModalDialogPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(ModalDialogPage.class);
    DataFaker dataFaker = new DataFaker();

    @FindBy(css = "#create-user")
    private WebElement createUserButton;
    @FindBy(css = "#name")
    private WebElement nameInput;
    @FindBy(css = "#email")
    private WebElement emailInput;
    @FindBy(css = "#password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(text(),'Create an account')]")
    private WebElement createAccountButton;
    @FindBy(css = "#users tbody tr")
    private List<WebElement> usersTableRows;
    @FindBy(xpath = "//tbody/tr[last()]/td")
    private List<WebElement> newRowData;

    public ModalDialogPage(){
        super();
    }

    public void addNewUser(){
        int userTableRowsStartSize = usersTableRows.size();
        createUserButton.click();
        String name = dataFaker.setFirstName() + " " + dataFaker.setLastName();
        log.info("My name is: " + name);
        nameInput.clear();
        nameInput.sendKeys(name);
        String email = dataFaker.setEmail();
        log.info("My email is: " + email);
        emailInput.clear();
        emailInput.sendKeys(email);
        String password = dataFaker.setPassword();
        log.info("My password is: " + password);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        createAccountButton.click();
        waitForElementToBeClickable(createUserButton);
        int userTableRowsEndSize = usersTableRows.size();

        Assertions.assertThat(userTableRowsEndSize).isEqualTo(userTableRowsStartSize+1);
        Assertions.assertThat(newRowData.get(0).getText()).isEqualTo(name);
        Assertions.assertThat(newRowData.get(1).getText()).isEqualTo(email);
        Assertions.assertThat(newRowData.get(2).getText()).isEqualTo(password);
    }
}
