package q4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest extends BasePageTest {

    @Test
    public void testLoginWithInvalidCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid@example.com", "wrongpassword");

        assertTrue(loginPage.isErrorMessageDisplayed(), "A mensagem de erro não foi exibida!");
    }
}