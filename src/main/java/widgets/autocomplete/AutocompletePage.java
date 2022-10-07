package widgets.autocomplete;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class AutocompletePage extends BasePage {
    private Random random = new Random();
    private static Logger log = LoggerFactory.getLogger(AutocompletePage.class);

    @FindBy(css = "#search")
    private WebElement searchInput;
    @FindBy(css = "#ui-id-1 li div")
    private List<WebElement> selectValues;

    public AutocompletePage(WebDriver driver){
        super(driver);
    }

    public void typeInSearchInput(){
        searchInput.sendKeys("a");
        log.info("A letter was sent to input");
    }

    public void printAllOptions(){
        for (WebElement value : selectValues) {
            System.out.println(value.getText());
        }
    }
    public String getSelectedElementAttribute(String attribute){
        return searchInput.getAttribute(attribute);
    }
    public WebElement selectRandomOption(){
        WebElement selectedElement = selectValues.get(random.nextInt(selectValues.size()));
        log.info("The random element has been found");
        return selectedElement;
    }
    public String getSelectedOptionValue(){
        return selectRandomOption().getText();
    }
    public void clickOnSelectedElement(){
        selectRandomOption().click();
    }
}
