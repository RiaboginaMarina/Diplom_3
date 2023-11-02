package stellarBurger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {
    private WebDriver driver;
    private By loginLink = By.className("Auth_link__1fOlj");

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLoginLink(){driver.findElement(loginLink).click();}
}
