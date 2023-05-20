package pageActions;
import org.openqa.selenium.WebDriver;

import pageElements.LoginPageElements;
import pages.HomePage;

public class LoginPageActions {
    private LoginPageElements elements;

    public LoginPageActions(WebDriver driver) {
        this.elements = new LoginPageElements(driver);
    }

    public void enterUsername(String username) {
        elements.getUsernameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        elements.getPasswordField().sendKeys(password);
    }

    public HomePage clickSubmitButton() {
        elements.getSubmitButton().click();
        return new HomePage(elements.getDriver());
    }
}