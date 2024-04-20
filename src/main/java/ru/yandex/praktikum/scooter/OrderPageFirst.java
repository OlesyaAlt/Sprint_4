package ru.yandex.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageFirst {
    private final WebDriver webDriver;
    //Поле имя
    private final By nameClientFieldLocator = By.xpath("//input[contains(@placeholder,'Имя')]");
    //Поле фамилия
    private final By surnameClientFieldLocator = By.xpath("//input[contains(@placeholder,'Фамилия')]");
    //Поле Адрес
    private final By addressForOrderFieldLocator = By.xpath("//input[contains(@placeholder,'Адрес')]");
    //Поле станция метро
    private final By selectSubwayFieldLocator = By.xpath("//input[contains(@placeholder,'Станция метро')]");
    //Выбор станции метро
    private final String stationLocator = "//div[text()='%s']";
    //Поле телефон
    private final By telephoneClientFieldLocator = By.xpath("//input[contains(@placeholder,'Телефон')]");
    //Кнопка "далее"
    private final By nextButtonLocator = By.xpath("//button[text()='Далее']");

    public OrderPageFirst(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
public void inputOrderInfoClient(String name,String surname, String address, String station, String telephon){
    WebElement nameInput = webDriver.findElement(nameClientFieldLocator);
    nameInput.sendKeys(name);
    WebElement surnameInput = webDriver.findElement(surnameClientFieldLocator);
    surnameInput.sendKeys(surname);
    WebElement addressInput = webDriver.findElement(addressForOrderFieldLocator);
    addressInput.sendKeys(address);
    WebElement subwayInput = webDriver.findElement(selectSubwayFieldLocator);
    subwayInput.click();
    WebElement stationInput = webDriver.findElement(By.xpath(String.format(stationLocator,station)));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();",stationInput);
    stationInput.click();
    WebElement telephonInput = webDriver.findElement(telephoneClientFieldLocator);
    telephonInput.sendKeys(telephon);
}
public void clickNextButton(){
        WebElement nextButton = webDriver.findElement(nextButtonLocator);
        nextButton.click();
}

}
