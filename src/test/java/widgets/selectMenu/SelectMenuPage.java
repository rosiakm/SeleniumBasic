package widgets.selectMenu;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static helpers.WaitHandler.waitForElementToBeVisible;
import static org.assertj.core.api.Assertions.assertThat;

public class SelectMenuPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(SelectMenuPage.class);
    Random random = new Random();

    @FindBy(css = "#speed-button")
    private WebElement speedButton;
    @FindBy(css = "#speed-menu li")
    private List<WebElement> speedOptions;
    @FindBy(css = "#speed-button span[class='ui-selectmenu-text']")
    private WebElement selectedSpeedOption;
    @FindBy(css = "#files-button")
    private WebElement filesButton;
    @FindBy(css = "#files-menu li[class='ui-menu-item'] div")
    private List<WebElement> filesOptions;
    @FindBy(css = "#files-button span[class='ui-selectmenu-text']")
    private WebElement selectedFilesOption;
    @FindBy(css = "#number-button")
    private WebElement numberButton;
    @FindBy(css = "#number-menu li div")
    private List<WebElement> numberOptions;
    @FindBy(css = "#number-button span[class='ui-selectmenu-text']")
    private WebElement selectedNumberOption;
    @FindBy(css = "#salutation-button")
    private WebElement salutationButton;
    @FindBy(css = "#salutation-menu li[class='ui-menu-item'] div")
    private List<WebElement> salutationOptions;
    @FindBy(css = "#salutation-button span[class='ui-selectmenu-text']")
    private WebElement selectedSalutationOption;

    public SelectMenuPage() {
        super();
    }

    public void selectOptions() {
        speedButton.click();
        waitForElementToBeVisible(speedOptions.get(0));
        assertThat(speedOptions.size()).isGreaterThan(0);
        speedOptions.get(random.nextInt(speedOptions.size())).click();
        log.info("My random speed option is: " + selectedSpeedOption.getText());
        filesButton.click();
        waitForElementToBeVisible(filesOptions.get(0));
        assertThat(filesOptions.size()).isGreaterThan(0);
        for (WebElement option : filesOptions) {
            clickOnOptionByText(option,"jQuery.js");
        }
        log.info("Selected option is: " + selectedFilesOption.getText());
        numberButton.click();
        waitForElementToBeVisible(numberOptions.get(0));
        assertThat(numberOptions.size()).isGreaterThan(0);
        numberOptions.get(10).click();
        log.info("Selected option is with index: " + selectedNumberOption.getText());
        salutationButton.click();
        waitForElementToBeVisible(salutationOptions.get(0));
        assertThat(salutationOptions.size()).isGreaterThan(0);
        salutationOptions.get(random.nextInt(salutationOptions.size())).click();
        log.info("My random salutation option is: " + selectedSalutationOption.getText());
    }

    private void clickOnOptionByText(WebElement element, String text){
        if(Objects.equals(element.getText(), text)){
            element.click();
        }
    }

}
