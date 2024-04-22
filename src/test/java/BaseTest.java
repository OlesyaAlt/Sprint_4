import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.WebDriverFactory;

import static ru.yandex.praktikum.scooter.constants.Url.URL_SCOOTER;

public abstract class BaseTest {
    public static WebDriver webDriver;
    private static final String BROWSER = "chrom";
@Before
    public void setup(){
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.get(URL_SCOOTER);
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }

}
