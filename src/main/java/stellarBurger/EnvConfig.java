package stellarBurger;

public class EnvConfig {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String YANDEX_DRIVER = System.getProperty("webdriver.yandex.driver", "./src/main/resources/yandexdriver.exe");
    public static final String YANDEX_BINARY = System.getProperty("webdriver.yandex.binary", "C:/Program Files/Yandex/YandexBrowser/Application/browser.exe");
}
