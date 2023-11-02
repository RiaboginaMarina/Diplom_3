package unauthorizedUser;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarBurger.api.UserClient;
import stellarBurger.pages.LoginPage;
import stellarBurger.pages.MainPageBurgers;
import stellarBurger.pages.RegistrationFormPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NewUserRegistrationTest {
    private final UserClient client = new UserClient();
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void registerNewUser() {
        WebDriver driver = driverRule.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        String name = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphanumeric(10);
        RegistrationFormPage objRegistrationPage = new RegistrationFormPage(driver);
        objRegistrationPage.fillRegistrationForm(name, email, password);
        objRegistrationPage.clickSignUpButton();
        LoginPage objLogin = new LoginPage(driver);
        objLogin.waitForLoadLoginPage();
        objLogin.fillLoginForm(email, password);
        objLogin.clickLogInButton();
        MainPageBurgers objMainPage = new MainPageBurgers(driver);
        objMainPage.waitForLoadMainPage();
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        assertNotNull(accessToken);
        client.delete(accessToken);
    }

    @Test
    public void registrationWithPasswordLessThenSixSymbols() {
        WebDriver driver = driverRule.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        String password = RandomStringUtils.randomAlphanumeric(5);
        var errorMessage = By.cssSelector(".input__error");
        RegistrationFormPage objRegistrationPage = new RegistrationFormPage(driver);
        objRegistrationPage.setPassword(password);
        objRegistrationPage.clickSignUpButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        String expectedErrorMessage = "Некорректный пароль";
        String actualErrorMessage = driver.findElement(errorMessage).getText();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
