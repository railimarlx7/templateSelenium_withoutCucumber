package Test;

import driverFactory.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAutomationTest {

    private static WebDriver driver;
    private static final String URL = "https://practicetestautomation.com/practice-test-login/";

    @BeforeAll
    static void setup() {

        // Configurar e inicializar o driver
        driver = DriverFactory.createDriver();

        // Navegar para a URL
        driver.get(URL);
    }

    @AfterAll
    static void tearDown() {

        // Encerrar o driver
        DriverFactory.quitDriver();
    }

    @Test
    public void testLogin() {

        // Instanciar a página de login
        LoginPage loginPage = new LoginPage(driver);

        // Preencher os campos de login e senha
        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");

        // Clicar no botão de login e redirecionar para a página inicial
        HomePage homePage = loginPage.clickSubmitButton();

        // Obter a mensagem de sucesso
        String successMessage = homePage.getSuccessMessage();

        // Verificar se a mensagem de sucesso é exibida corretamente
        assertEquals("Congratulations student. You successfully logged in!", successMessage,
                "Mensagem de sucesso incorreta");
    }
}
