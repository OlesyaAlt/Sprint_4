package ru.yandex.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPageSecond {
    private final WebDriver webDriver;
    //Поле - когда привезти самокат
    private final By dateForOrderFieldLocator = By.xpath("//input[contains(@placeholder,'привезти')]");
    //Поле - срок аренды
    private final By rentalPeriodFieldLocator = By.xpath("//span[@class='Dropdown-arrow']");
    //выпадающий список со сроком аренды
    private final String rentalPeriodItemLocator = "//div[text()='%s']";
    //Чекбокс - черный жемчуг
    private final By colourScooterBlackLocator = By.id("black");
    //Чекбокс - серая безысходность
    private final By colourScooterGrayLocator = By.id("grey");
    //Поле - комментарий
    private final By commentFieldLokator = By.xpath("//input[contains(@placeholder,'Комментарий')]");
    //Кнопка - "Заказать"
    private final By makeOrderButtonLocator = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Кнопка "Да" в всплывающем окне
    private final By yesButtonLocator = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    //Окно заказ оформлен
    private final By orderIsMakeLocator = By.xpath("//div[text()='Заказ оформлен']");

    public OrderPageSecond(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void inputOrderInfoClient(String dateForOrder,String rentalPeriod){
        WebElement dateForOrderInput = webDriver.findElement(dateForOrderFieldLocator);
        dateForOrderInput.sendKeys(dateForOrder);
        WebElement rentalPeriodField = webDriver.findElement(rentalPeriodFieldLocator);
        rentalPeriodField.click();
        WebElement rentalPeriodInput = webDriver.findElement(By.xpath(String.format(rentalPeriodItemLocator,rentalPeriod)));
        rentalPeriodInput.click();
    }
    public void choiceColorBlack(){
        WebElement blackPearls = webDriver.findElement(colourScooterBlackLocator);
        blackPearls.click();
    }
    public void choiceColorGray(){
        WebElement grayDespair = webDriver.findElement(colourScooterGrayLocator);
        grayDespair.click();
    }

    public void inputComment(String comment){
        WebElement commentInput = webDriver.findElement(commentFieldLokator);
        commentInput.sendKeys(comment);
    }


    public void clickMakeOrderButton(){
        WebElement makeOrderButton = webDriver.findElement(makeOrderButtonLocator);
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable (makeOrderButton));
        makeOrderButton.click();
    }
    public void clickYesButton(){
        WebElement yesButton = webDriver.findElement(yesButtonLocator);
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable (yesButton));
        yesButton.click();
    }
public boolean orderIsMakeIsDisplayed (){
      return webDriver.findElement(orderIsMakeLocator).isDisplayed();
}
}
