package unauthorizedUser;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import stellarBurger.api.User;
import stellarBurger.api.UserClient;
import stellarBurger.pages.LoginPage;
import stellarBurger.pages.MainPageBurgers;
import stellarBurger.pages.RegistrationFormPage;
import stellarBurger.pages.RestorePasswordPage;

import static org.junit.Assert.assertEquals;


public class LoginToAccountTest {
    private final UserClient client = new UserClient();
    private final String email = RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru";
    private final String password = RandomStringUtils.randomAlphanumeric(10);
    private final String name = RandomStringUtils.randomAlphabetic(10);
    private final String expectedChangedTextOnLoginButton = "Оформить заказ";
    private final User user = new User(email, password, name);
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Before
    public void createUser() {
        client.createNewUser(user);
    }

    @After
    public void deleteUser() {
        WebDriver driver = driverRule.getDriver();
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        client.delete(accessToken);
    }

    @Test
    public void loginToAccountUsingLogInButtonOnMainPage() {
        WebDriver driver = driverRule.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPageBurgers objMainPage = new MainPageBurgers(driver);
        objMainPage.clickLogInButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.fillLoginForm(email, password);
        objLoginPage.clickLogInButton();
        objMainPage.waitForLoadMainPage();
        String actualTextOnLoginButtonWhenLoggedIn = objMainPage.getTextFromLoginButton();
        assertEquals(expectedChangedTextOnLoginButton, actualTextOnLoginButtonWhenLoggedIn);
    }

    @Test
    public void loginToAccountUsingAccountButtonOnMainPage() {
        WebDriver driver = driverRule.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPageBurgers objMainPage = new MainPageBurgers(driver);
        objMainPage.clickAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.fillLoginForm(email, password);
        objLoginPage.clickLogInButton();
        objMainPage.waitForLoadMainPage();
        String actualTextOnLoginButtonWhenLoggedIn = objMainPage.getTextFromLoginButton();
        assertEquals(expectedChangedTextOnLoginButton, actualTextOnLoginButtonWhenLoggedIn);
    }

    @Test
    public void loginToAccountUsingLoginLinkInRegistrationForm() {
        WebDriver driver = driverRule.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationFormPage objRegisterPage = new RegistrationFormPage(driver);
        objRegisterPage.clickLoginLink();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.fillLoginForm(email, password);
        objLoginPage.clickLogInButton();
        MainPageBurgers objMainPage = new MainPageBurgers(driver);
        objMainPage.waitForLoadMainPage();
        String actualTextOnLoginButtonWhenLoggedIn = objMainPage.getTextFromLoginButton();
        assertEquals(expectedChangedTextOnLoginButton, actualTextOnLoginButtonWhenLoggedIn);
    }

    @Test
    public void loginToAccountUsingLoginLinkOnRestorePasswordPage() {
        WebDriver driver = driverRule.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        RestorePasswordPage objPasswordPage = new RestorePasswordPage(driver);
        objPasswordPage.clickLoginLink();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.fillLoginForm(email, password);
        objLoginPage.clickLogInButton();
        MainPageBurgers objMainPage = new MainPageBurgers(driver);
        objMainPage.waitForLoadMainPage();
        String actualTextOnLoginButtonWhenLoggedIn = objMainPage.getTextFromLoginButton();
        assertEquals(expectedChangedTextOnLoginButton, actualTextOnLoginButtonWhenLoggedIn);
    }
}
