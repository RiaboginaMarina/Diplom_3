package unauthorizedUser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import stellarBurger.EnvConfig;

import java.io.File;
import java.time.Duration;

public class DriverRule extends ExternalResource {
    WebDriver driver;

    @Override
    protected void before() throws Throwable {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        if ("yandex".equals(System.getProperty("browser")))
            setUpYandex();
        else
            setUpChrome();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    private void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    public void setUpYandex() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(EnvConfig.YANDEX_DRIVER))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary(EnvConfig.YANDEX_BINARY);

        driver = new ChromeDriver(service, options);
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
