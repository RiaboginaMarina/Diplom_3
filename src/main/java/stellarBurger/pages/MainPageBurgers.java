package stellarBurger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageBurgers {
    private WebDriver driver;
    private By accountButton = By.xpath(".//a[@href='/account']");
    private By logInButton = By.cssSelector(".button_button__33qZ0");
    private By bunsMenu = By.xpath(".//span[text()='Булки']");
    private By sauceMenu = By.xpath(".//span[text()='Соусы']");
    private By fillingsMenu = By.xpath(".//span[text()='Начинки']");


    public MainPageBurgers(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAccountButton(){driver.findElement(accountButton).click();}
    public void clickLogInButton(){driver.findElement(logInButton).click();}
    public void selectBunsMenu(){driver.findElement(bunsMenu).click();}
    public void selectSauceMenu(){driver.findElement(sauceMenu).click();}
    public void selectFillingsMenu(){driver.findElement(fillingsMenu).click();}
    public void waitForLoadMainPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsMenu));
    }
    public String getTextFromLoginButton(){return driver.findElement(logInButton).getText();}
    public boolean checkMainPageLoaded(){return driver.findElement(bunsMenu).isDisplayed();}
}
