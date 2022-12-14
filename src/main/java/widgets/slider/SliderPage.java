package widgets.slider;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class SliderPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(SliderPage.class);

    @FindBy(css = "#custom-handle")
    private WebElement sliderHandle;

    public SliderPage(WebDriver driver){
        super(driver);
    }

    public void moveSliderToSpecificLocations(){
        int startPoint = Integer.parseInt(sliderHandle.getText());
        sliderHandle.click();
        for (int i = startPoint; i < 50-startPoint; i++){
            sliderHandle.sendKeys(Keys.ARROW_RIGHT);
        }
        assertThat(sliderHandle.getText()).isEqualTo("50");
        for (int i = 50; i < 80; i++){
            sliderHandle.sendKeys(Keys.ARROW_RIGHT);
        }
        assertThat(sliderHandle.getText()).isEqualTo("80");
        for (int i = 80; i > 20; i--){
            sliderHandle.sendKeys(Keys.ARROW_LEFT);
        }
        assertThat(sliderHandle.getText()).isEqualTo("20");
        for (int i = 20; i > 0; i--){
            sliderHandle.sendKeys(Keys.ARROW_LEFT);
        }
        assertThat(sliderHandle.getText()).isEqualTo("0");
    }
}
