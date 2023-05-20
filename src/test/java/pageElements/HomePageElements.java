package pageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageElements {
    private WebDriver driver;

    private By successMessage = By.cssSelector("p.has-text-align-center > strong");

    public HomePageElements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSuccessMessage() {
        return driver.findElement(successMessage);
    }
}