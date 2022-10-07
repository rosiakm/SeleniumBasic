package widgets.modalDialog;

import base.BasePage;
import helpers.DataFaker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static helpers.WaitHandler.waitForElementToBeClickable;

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

    public ModalDialogPage(WebDriver driver){
        super(driver);
    }

    public int returnUserTableRowsSize(){
        return usersTableRows.size();
    }
    public void clickOnCreateUserButton(){
        createAccountButton.click();
    }
    public void clearNameInput(){
        nameInput.clear();
    }
    public void provideName(String name){
        nameInput.sendKeys(name);
    }
    public void clearEmailInput(){
        emailInput.clear();
    }
    public void provideEmail(String email){
        emailInput.sendKeys(email);
    }
    public void clearPasswordInput(){
        passwordInput.clear();
    }
    public void providePassword(String password){
        passwordInput.sendKeys(password);
    }
    public void clickOnCreateAccountButton(){
        createAccountButton.click();
    }
    public void waitForCreateUserButtonToBeClickable(WebDriver driver){
        waitForElementToBeClickable(driver, createUserButton);
    }
    public String getNameFromNewRowData(){
        return newRowData.get(0).getText();
    }
    public String getEmailFromNewRowData(){
        return newRowData.get(1).getText();
    }
    public String getPasswordFromNewRowData(){
        return newRowData.get(2).getText();
    }

}
