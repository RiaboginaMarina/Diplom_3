package stellarBurger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By emailField = By.xpath(".//input[@name='name']");
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    private By logInButton = By.xpath(".//button[text()='Войти']");
    private By signUpLink = By.xpath(".//a[@href='/register']");
    private By resetPasswordLink = By.xpath(".//a[@href='/forgot-password']");
    private By stellarBurgersLogo = By.className("AppHeader_header__logo__2D0X2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setEmail(String email){driver.findElement(emailField).sendKeys(email);}
    public void setPassword(String password){driver.findElement(passwordField).sendKeys(password);}
    public void clickLogInButton(){driver.findElement(logInButton).click();}
    public void clickSignUpLink(){driver.findElement(signUpLink).click();}
    public void clickResetPasswordLink(){driver.findElement(resetPasswordLink).click();}
    public void clickStellarLogo(){driver.findElement(stellarBurgersLogo).click();}
    public void waitForLoadLoginPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Вход']")));
    }
    public void fillLoginForm(String email, String password){
        setEmail(email);
        setPassword(password);
    }
}
