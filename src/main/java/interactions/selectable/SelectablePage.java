package interactions.selectable;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectablePage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(SelectablePage.class);

    @FindBy(css = "#selectable li")
    private List<WebElement> selectsList;
    @FindBy(css = "#feedback span")
    private List<WebElement> feedback;

    public SelectablePage(WebDriver driver){
        super(driver);
    }

    public void selectItems(WebDriver driver){
        assertThat(selectsList.size()).isGreaterThan(0);
        new Actions(driver).keyDown(Keys.CONTROL).click(selectsList.get(0)).click(selectsList.get(2)).
                click(selectsList.get(3)).build().perform();
    }
    @Override
    public String toString(){
        return feedback.get(0).getText() + " " + feedback.get(1).getText();
    }
}
