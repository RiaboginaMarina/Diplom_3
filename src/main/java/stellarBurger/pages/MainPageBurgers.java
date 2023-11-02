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
    private By bunsMenu = By.cssSelector(".tab_tab__1SPyG:nth-child(1)");
    private By sauceMenu = By.cssSelector(".tab_tab__1SPyG:nth-child(2)");
    private By fillingsMenu = By.cssSelector(".tab_tab__1SPyG:nth-child(3)");


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
    public boolean checkSwitchToSauceMenu(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(sauceMenu, "class", "current"));
    }
    public boolean checkSwitchToFillingsMenu(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(fillingsMenu, "class", "current"));
    }
    public boolean checkSwitchToBunsMenu(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(bunsMenu, "class", "current"));
    }
}
