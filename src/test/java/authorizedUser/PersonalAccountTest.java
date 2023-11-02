package authorizedUser;

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
import stellarBurger.pages.MyAccountPage;
import unauthorizedUser.DriverRule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonalAccountTest {

    private final UserClient client = new UserClient();
    @Rule
    public DriverRule driverRule = new DriverRule();
    private String accessToken;

    @Before
    public void loginUser() {
        String email = RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphanumeric(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        var user = new User(email, password, name);
        client.createNewUser(user);
        WebDriver driver = driverRule.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillLoginForm(user.getEmail(), user.getPassword());
        objLoginPage.clickLogInButton();
        MainPageBurgers objMainPage = new MainPageBurgers(driver);
        objMainPage.waitForLoadMainPage();
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
    }

    @After
    public void deleteUser() {
        client.delete(accessToken);
    }

    @Test
    public void goToPersonalAccountByAccountButtonOnMainPage() {
        WebDriver driver = driverRule.getDriver();
        MainPageBurgers objMainPage = new MainPageBurgers(driver);
        objMainPage.clickAccountButton();
        MyAccountPage objAccountPage = new MyAccountPage(driver);
        objAccountPage.waitForLoadMyAccountPage();
        assertTrue(objAccountPage.checkAccountPageLoaded());
    }

    @Test
    public void clickStellarLogoToMoveToMainPage() {
        WebDriver driver = driverRule.getDriver();
        MainPageBurgers objMainPage = new MainPageBurgers(driver);
        objMainPage.clickAccountButton();
        MyAccountPage objAccountPage = new MyAccountPage(driver);
        objAccountPage.waitForLoadMyAccountPage();
        objAccountPage.clickStellarBurgersLogo();
        objMainPage.waitForLoadMainPage();
        assertTrue(objMainPage.checkMainPageLoaded());
    }

    @Test
    public void clickConstructorHeaderLinkToMoveToMainPage() {
        WebDriver driver = driverRule.getDriver();
        MainPageBurgers objMainPage = new MainPageBurgers(driver);
        objMainPage.clickAccountButton();
        MyAccountPage objAccountPage = new MyAccountPage(driver);
        objAccountPage.waitForLoadMyAccountPage();
        objAccountPage.clickConstructorHeaderLink();
        objMainPage.waitForLoadMainPage();
        assertTrue(objMainPage.checkMainPageLoaded());
    }

    @Test
    public void logOutOfAccount() {
        WebDriver driver = driverRule.getDriver();
        MainPageBurgers objMainPage = new MainPageBurgers(driver);
        objMainPage.clickAccountButton();
        MyAccountPage objAccountPage = new MyAccountPage(driver);
        objAccountPage.waitForLoadMyAccountPage();
        objAccountPage.clickExitButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadLoginPage();
        objLoginPage.clickStellarLogo();
        objMainPage.waitForLoadMainPage();
        String expectedTextOnLoginButton = "Войти в аккаунт";
        String actualTextOnLoginButtonWhenLoggedOut = objMainPage.getTextFromLoginButton();
        assertEquals(expectedTextOnLoginButton, actualTextOnLoginButtonWhenLoggedOut);
    }
}
