package Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageActions.LoginPageActions;
import pages.HomePage;

public class LoginAutomationTest {

    private static WebDriver driver;
    private static final String URL = "https://practicetestautomation.com/practice-test-login/";

    @BeforeAll
    static void webdrivermanagerSetup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setHeadless(false);

        driver = new ChromeDriver(options);

        driver.get(URL);
    }

    @AfterAll
    static void quitBrowser() {
        driver.quit();
    }

    @Test
    @DisplayName("Successful Login Test")
    public void testLogin() {
        LoginPageActions loginPage = new LoginPageActions(driver);

        // Preencher o nome de usuário e a senha
        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");

        // Clicar no botão de envio e obter a página inicial
        HomePage homePage = loginPage.clickSubmitButton();

        // Obter a mensagem de sucesso
        String successMessage = homePage.getSuccessMessage();

        // Verificar se a mensagem de sucesso é a esperada
        Assertions.assertEquals("Congratulations student. You successfully logged in!", successMessage,
                "Mensagem de sucesso incorreta");
    }
}
