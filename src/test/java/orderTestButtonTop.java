import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.WebDriverFactory;
import ru.yandex.praktikum.scooter.HomePageScooter;
import ru.yandex.praktikum.scooter.OrderPageFirst;
import ru.yandex.praktikum.scooter.OrderPageSecond;

import static org.junit.Assert.assertTrue;

public class orderTestButtonTop {
    private static final String BROWSER = "chrom";
    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.get("https://qa-scooter.praktikum-services.ru");
    }
        @Test
        public void OrderTest () {
            HomePageScooter homePageScooter = new HomePageScooter(webDriver);
            homePageScooter.clickMakeOrderButtonTop();

            OrderPageFirst orderPageFirst = new OrderPageFirst(webDriver);
            orderPageFirst.inputOrderInfoClient("Иван", "Иванов", "г. Москва", "Арбатская", "12345678912");
            orderPageFirst.clickNextButton();

            OrderPageSecond orderPageSecond = new OrderPageSecond(webDriver);
            orderPageSecond.inputOrderInfoClient("25.04.2024", "двое суток");
            orderPageSecond.choiceColorBlack();
            orderPageSecond.inputComment("в 8 утра");
            orderPageSecond.clickMakeOrderButton();
            orderPageSecond.clickYesButton();
            assertTrue(orderPageSecond.orderIsMakeIsDisplayed());

        }
        @After
        public void tearDown () {
            webDriver.quit();
        }
    }