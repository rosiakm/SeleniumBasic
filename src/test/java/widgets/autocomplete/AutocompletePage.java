package widgets.autocomplete;

import base.BasePage;
import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class AutocompletePage extends BasePage {
    private Random random = new Random();
    private static Logger log = LoggerFactory.getLogger(AutocompletePage.class);

    @FindBy(css = "#search")
    private WebElement searchInput;
    @FindBy(css = "#ui-id-1 li div")
    private List<WebElement> selectValues;

    public AutocompletePage(){
        super();
        log.info("Elements on the website are initialized");
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

    public void selectRandomOption(){
        WebElement selectedElement = selectValues.get(random.nextInt(selectValues.size()));
        log.info("The random element has been found");
        String selectedValue = selectedElement.getText();
        selectedElement.click();
        assertThat(selectedValue).isEqualTo(searchInput.getAttribute("value"));
    }
}
