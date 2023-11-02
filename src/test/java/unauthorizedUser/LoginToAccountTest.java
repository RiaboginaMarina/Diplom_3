package unauthorizedUser;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stellarBurger.pages.LoginPage;
import stellarBurger.pages.MainPageBurgers;
import stellarBurger.pages.RegistrationFormPage;
import stellarBurger.pages.RestorePasswordPage;

import static org.junit.Assert.assertEquals;


public class LoginToAccountTest {
    private final String email = "pochta1234@yandex.ru";
    private final String password = "passwordword123";
    private final String expectedChangedTextOnLoginButton = "Оформить заказ";
    @Rule
    public DriverRule driverRule = new DriverRule();

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
