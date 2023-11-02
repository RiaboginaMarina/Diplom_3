package unauthorizedUser;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stellarBurger.pages.MainPageBurgers;

import static org.junit.Assert.assertTrue;

public class SwitchBetweenMenuTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void switchToSauceMenu() {
        WebDriver driver = driverRule.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPageBurgers objMainPAge = new MainPageBurgers(driver);
        objMainPAge.selectSauceMenu();
        assertTrue(objMainPAge.checkSwitchToSauceMenu());
    }

    @Test
    public void switchToFillingsMenu() {
        WebDriver driver = driverRule.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPageBurgers objMainPAge = new MainPageBurgers(driver);
        objMainPAge.selectFillingsMenu();
        assertTrue(objMainPAge.checkSwitchToFillingsMenu());
    }

    @Test
    public void switchToBunsMenu() {
        WebDriver driver = driverRule.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPageBurgers objMainPAge = new MainPageBurgers(driver);
        objMainPAge.selectSauceMenu();
        objMainPAge.selectBunsMenu();
        assertTrue(objMainPAge.checkSwitchToBunsMenu());
    }
}
