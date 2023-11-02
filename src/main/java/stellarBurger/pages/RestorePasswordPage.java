package stellarBurger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {
    private final WebDriver driver;
    private final By loginLink = By.className("Auth_link__1fOlj");

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
