package ru.yandex.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePageScooter {
    private final WebDriver webDriver;
    //Кнопка "Заказать" в верху главной страницы
    private final By makeOrderButtonTopLocator = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[text()='Заказать']");
    //Кнопка "Заказать" после раздела "Как это работает"
    private final By makeOrderButtonDownLocator = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");
//Кнопка согласия с куки
    private final By agreeCookieLocator = By.id("rcc-confirm-button");

    //Расскрывающийся список с вопросами и ответами
    private final String questionLocator = "accordion__heading-%s";
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";

    public HomePageScooter(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
public void clickMakeOrderButtonTop(){
        WebElement makeOrderButtonTop = webDriver.findElement(makeOrderButtonTopLocator);
    makeOrderButtonTop.click();
}
    public void clickMakeOrderButtonDown(){
        WebElement makeOrderButtonDown = webDriver.findElement(makeOrderButtonDownLocator);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();",makeOrderButtonDown);
        new WebDriverWait(webDriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable (makeOrderButtonDown));
        makeOrderButtonDown.click();
    }
public void clickAgreeCookie(){
        webDriver.findElement(agreeCookieLocator).click();
}
public void clickFieldQuestion (int index){
        WebElement element = webDriver.findElement(By.id(String.format(questionLocator,index)));
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();",element);
    new WebDriverWait(webDriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable (element));
        element.click();
}
public boolean answerIsDisplayed(String expectedAnswer){
WebElement element = webDriver.findElement(By.xpath(String.format(answerLocator,expectedAnswer)));
    new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf (element));
    return element.isDisplayed();
}
}
