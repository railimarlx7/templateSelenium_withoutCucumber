package pageActions;
import org.openqa.selenium.WebDriver;

import pageElements.HomePageElements;

public class HomePageActions {
    private HomePageElements elements;

    public HomePageActions(WebDriver driver) {
        this.elements = new HomePageElements(driver);
    }

    public String getSuccessMessage() {
        return elements.getSuccessMessage().getText();
    }
}
