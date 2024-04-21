package ru.yandex.praktikum.scooter;

import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.WebDriverFactory;


import static ru.yandex.praktikum.scooter.constants.Url.URL_SCOOTER;

public abstract class BeforeAfterAbstract {
    public static WebDriver webDriver;
    private static final String BROWSER = "chrom";

    public void setup(){
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.get(URL_SCOOTER);
    }
    public void tearDown(){
        webDriver.quit();
    }

}
