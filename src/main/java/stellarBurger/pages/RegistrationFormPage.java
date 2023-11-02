package stellarBurger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationFormPage {
    private WebDriver driver;
    private By nameField = By.xpath(".//fieldset[1]//input");
    private By emailField = By.xpath(".//fieldset[2]//input");
    private By passwordField = By.xpath(".//fieldset[3]//input");
    private By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By loginLink = By.xpath(".//a[@href='/login']");

    public RegistrationFormPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setName(String name){driver.findElement(nameField).sendKeys(name);}
    public void setEmail(String email){driver.findElement(emailField).sendKeys(email);}
    public void setPassword(String password){driver.findElement(passwordField).sendKeys(password);}
    public void clickSignUpButton(){driver.findElement(signUpButton).click();}
    public void clickLoginLink(){driver.findElement(loginLink).click();}
    public void waitForLoadRegistrationForm(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Регистрация']")));
    }
    public void fillRegistrationForm(String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
    }

}
