package authorizedUser;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stellarBurger.pages.LoginPage;
import stellarBurger.pages.MainPageBurgers;
import stellarBurger.pages.MyAccountPage;
import unauthorizedUser.DriverRule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonalAccountTest {
    private final String email = "pochta1234@yandex.ru";
    private final String password = "passwordword123";

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Before
    public void loginUser() {
        WebDriver driver = driverRule.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillLoginForm(email, password);
        objLoginPage.clickLogInButton();
        MainPageBurgers objMainPage = new MainPageBurgers(driver);
        objMainPage.waitForLoadMainPage();
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
    public void clickConstructorHeaderLinkToMoveToMainPage(){
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
    public void logOutOfAccount(){
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
