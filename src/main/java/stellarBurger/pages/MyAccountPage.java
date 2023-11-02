package stellarBurger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {
    private WebDriver driver;
    private By constructorHeaderLink = By.xpath(".//p[text()='Конструктор']");
    private By stellarBurgersLogo = By.className("AppHeader_header__logo__2D0X2");
    private By exitButton = By.xpath(".//button[text()='Выход']");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickConstructorHeaderLink(){driver.findElement(constructorHeaderLink).click();}
    public void clickStellarBurgersLogo(){driver.findElement(stellarBurgersLogo).click();}
    public void clickExitButton(){driver.findElement(exitButton).click();}
    public void waitForLoadMyAccountPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Account_listItem__35dAP")));
    }
    public boolean checkAccountPageLoaded(){return driver.findElement(By.xpath(".//a[text()='Профиль']")).isDisplayed();}

}
