package authorizedUser;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import stellarBurger.api.User;
import stellarBurger.api.UserClient;
import stellarBurger.pages.LoginPage;
import stellarBurger.pages.MainPageBurgers;
import stellarBurger.pages.MyAccountPage;
import unauthorizedUser.DriverRule;

import static org.junit.Assert.assertTrue;

public class MainPageTest {
    private final UserClient client = new UserClient();
    private final String email = RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru";
    private final String password = RandomStringUtils.randomAlphanumeric(10);
    private final String name = RandomStringUtils.randomAlphabetic(10);
    private final User user = new User(email, password, name);
    @Rule
    public DriverRule driverRule = new DriverRule();
    private MainPageBurgers mainPage;

    @Before
    public void loginUser() {
        client.createNewUser(user);

        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        loginPage.open()
                .waitForLoadLoginPage()
                .fillLoginForm(user.getEmail(), user.getPassword());

        mainPage = loginPage.clickLogInButton();
        mainPage.waitForLoadMainPage();
    }

    @Test
    public void goToPersonalAccountByAccountButton() {
        MyAccountPage accountPage = mainPage.clickAccountButtonWithLoggedUser();
        accountPage.waitForLoadMyAccountPage();
        assertTrue(accountPage.checkAccountPageLoaded());
    }
}
