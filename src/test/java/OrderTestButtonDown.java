import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.WebDriverFactory;
import ru.yandex.praktikum.scooter.HomePageScooter;
import ru.yandex.praktikum.scooter.OrderPageFirst;
import ru.yandex.praktikum.scooter.OrderPageSecond;

import static org.junit.Assert.assertTrue;

public class OrderTestButtonDown {
        private static final String BROWSER = "chrom";
        private WebDriver webDriver;

        @Before
        public void setup() {
            webDriver = WebDriverFactory.getWebDriver(BROWSER);
            webDriver.get("https://qa-scooter.praktikum-services.ru");
        }
        @Test
        public void orderTestButtonDown () {
            HomePageScooter homePageScooter = new HomePageScooter(webDriver);
            homePageScooter.clickMakeOrderButtonDown();

            OrderPageFirst orderPageFirst = new OrderPageFirst(webDriver);
            orderPageFirst.inputOrderInfoClient("Мария", "Маринова", "г. Москва, ул.Оружейный, 41", "Комсомольская", "321321321321");
            orderPageFirst.clickNextButton();

            OrderPageSecond orderPageSecond = new OrderPageSecond(webDriver);
            orderPageSecond.inputOrderInfoClient("01.12.2024", "трое суток");
            orderPageSecond.choiceColorGray();
            orderPageSecond.inputComment("как можно раньше");
            orderPageSecond.clickMakeOrderButton();
            orderPageSecond.clickYesButton();
            assertTrue(orderPageSecond.orderIsMakeIsDisplayed());

        }
        @After
        public void tearDown () {
            webDriver.quit();
        }
    }

