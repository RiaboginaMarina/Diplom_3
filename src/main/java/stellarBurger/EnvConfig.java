package stellarBurger;

public class EnvConfig {
    public static final String CHROME_DRIVER = System.getProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
    public static final String CHROME_BINARY = System.getProperty("webdriver.chrome.binary", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
    public static final String YANDEX_DRIVER = System.getProperty("webdriver.yandex.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
    public static final String YANDEX_BINARY = System.getProperty("webdriver.yandex.binary", "C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe");
}
