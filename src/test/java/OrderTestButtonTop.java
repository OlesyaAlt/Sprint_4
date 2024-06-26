
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.scooter.HomePageScooter;
import ru.yandex.praktikum.scooter.OrderPageFirst;
import ru.yandex.praktikum.scooter.OrderPageSecond;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTestButtonTop extends BaseTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String station;
    private final String telephone;
    private final String dateForOrder;
    private final String rentalPeriod;
    private final String comment;

    public OrderTestButtonTop( String name, String surname, String address, String station, String telephone, String dateForOrder, String rentalPeriod, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.telephone = telephone;
        this.dateForOrder = dateForOrder;
        this.rentalPeriod = rentalPeriod;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] getFormOrder() {
        return new Object[][] {
                { "Иван", "Иванов", "г. Москва", "Арбатская", "12345678912", "25.04.2024", "двое суток", "в 8 утра"},
                { "Алена", "Кикабидзе", "г. Москва, Набережная", "Курская", "111111111111", "30.05.2024", "четверо суток", "в 9 утра"}
        };
    }

        @Test
        public void orderTest () {
            HomePageScooter homePageScooter = new HomePageScooter(webDriver);
            homePageScooter.clickMakeOrderButtonTop();

            OrderPageFirst orderPageFirst = new OrderPageFirst(webDriver);
            orderPageFirst.inputOrderInfoClient(name, surname, address, station, telephone);
            orderPageFirst.clickNextButton();

            OrderPageSecond orderPageSecond = new OrderPageSecond(webDriver);
            orderPageSecond.inputOrderInfoClient(dateForOrder, rentalPeriod);
            orderPageSecond.choiceColorBlack();
            orderPageSecond.inputComment(comment);
            orderPageSecond.clickMakeOrderButton();
            orderPageSecond.clickYesButton();
            assertTrue(orderPageSecond.orderIsMakeIsDisplayed());

        }
    }