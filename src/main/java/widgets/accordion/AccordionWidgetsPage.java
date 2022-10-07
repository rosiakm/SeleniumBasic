package widgets.accordion;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static helpers.WaitHandler.waitForElementToBeVisible;

public class AccordionWidgetsPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(AccordionWidgetsPage.class);

    @FindBy(css = "#ui-id-1")
    private WebElement sectionOne;
    @FindBy(css = "#ui-id-2 p")
    private WebElement sectionOneText;
    @FindBy(css = "#ui-id-3")
    private WebElement sectionTwo;
    @FindBy(css = "#ui-id-4 p")
    private WebElement sectionTwoText;
    @FindBy(css = "#ui-id-5")
    private WebElement sectionThree;
    @FindBy(css = "#ui-id-6 p")
    private WebElement sectionThreeMainText;
    @FindBy(css = "#ui-id-6 ul li")
    private List<WebElement> sectionThreePoints;
    @FindBy(css = "#ui-id-7")
    private WebElement sectionFour;
    @FindBy(css = "#ui-id-8 p")
    private List<WebElement> sectionFourTexts;


    public AccordionWidgetsPage(WebDriver driver) {
        super(driver);
    }

    public void printOutTheTextFromSectionOne() {
        sectionOne.click();
        System.out.println(sectionOneText.getText());
    }

    public void printOutTheTextFromSectionTwo() {
        sectionTwo.click();
        System.out.println(sectionTwoText.getText());
    }

    public void printOutTheTextFromSectionThree(WebDriver driver) {
        sectionThree.click();
        System.out.println(sectionThreeMainText.getText());
        waitForElementToBeVisible(driver, sectionThreePoints.get(0));
        for (WebElement point : sectionThreePoints) {
            System.out.println(point.getText());
        }
    }

    public void printOutTheTextFromSectionFour(WebDriver driver) {
        sectionFour.click();
        waitForElementToBeVisible(driver, sectionFourTexts.get(0));
        for (WebElement text : sectionFourTexts) {
            System.out.println(text.getText());
        }
    }
}
