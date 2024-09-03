package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

// Класс страницы "Для кого самокат"
public class OrderDataPage {

    private final WebDriver driver;

    // Локатор для поля "Имя"
    private final By orderDataName = By.xpath("//input[@placeholder='* Имя']");

    // Локатор для поля "Фамилия"
    private final By orderDataSurname = By.xpath("//input[@placeholder='* Фамилия']");

    // Локатор для поля "Адрес куда везти"
    private final By orderDataAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    // Локатор для поля "Станция метро"
    private final By orderDataSubwayStation = By.className("select-search__input");

    // Локатор селектора "Станция метро"
    private final By orderSelectorSubwayStation = By.className("select-search__select");

    // Локатор для поля "Телефон"
    private final By orderDataTelephone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Локатор кнопки "Далее"
    private final By orderButtonFurther = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    public OrderDataPage(WebDriver driver) {

        this.driver = driver;
    }

    // Метод для ввода имени
    public void enterOrderDataName(String name) {
        driver.findElement(orderDataName).sendKeys(name);
    }

    // Метод для ввода фамилии
    public void enterOrderDataSurname(String surname) {
        driver.findElement(orderDataSurname).sendKeys(surname);
    }

    // Метод для ввода адреса
    public void enterOrderDataAddress(String address) {
        driver.findElement(orderDataAddress).sendKeys(address);
    }

    // Метод обращения к полю "Станция метро" и выбора станции
    public void clickOrderDataSubwayStation() {
        driver.findElement(orderDataSubwayStation).click();
        driver.findElement(orderSelectorSubwayStation).isDisplayed();
        driver.findElement(orderDataSubwayStation).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    // Метод для ввода номера телефона
    public void enterOrderDataTelephone(String telephone) {
        driver.findElement(orderDataTelephone).sendKeys(telephone);
    }

    // Метод для клика по кнопке "Далее" на странице "Для кого самокат"
    public void clickOrderButtonFurther() {
        driver.findElement(orderButtonFurther).click();
    }

    // Общий метод для ввода имени, фамилии, адреса, выбора станции, телефона, клика по кнопке "Далее"
    public OrderDataPage enterOrderAllData(String name, String surname, String address, String telephone) {
        enterOrderDataName(name);
        enterOrderDataSurname(surname);
        enterOrderDataAddress(address);
        clickOrderDataSubwayStation();
        enterOrderDataTelephone(telephone);
        clickOrderButtonFurther();
        return this;
    }

}