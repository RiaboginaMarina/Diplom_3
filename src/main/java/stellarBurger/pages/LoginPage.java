package stellarBurger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final By emailField = By.xpath(".//input[@name='name']");
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    private final By logInButton = By.xpath(".//button[text()='Войти']");
    private final By signUpLink = By.xpath(".//a[@href='/register']");
    private final By resetPasswordLink = By.xpath(".//a[@href='/forgot-password']");
    private final By stellarBurgersLogo = By.className("AppHeader_header__logo__2D0X2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogInButton() {
        driver.findElement(logInButton).click();
    }

    public void clickSignUpLink() {
        driver.findElement(signUpLink).click();
    }

    public void clickResetPasswordLink() {
        driver.findElement(resetPasswordLink).click();
    }

    public void clickStellarLogo() {
        driver.findElement(stellarBurgersLogo).click();
    }

    public void waitForLoadLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Вход']")));
    }

    public void fillLoginForm(String email, String password) {
        setEmail(email);
        setPassword(password);
    }
}
