package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс страницы "Про аренду"
public class RentOrderPage {

    private final WebDriver driver;

    // Локатор для поля "Когда привезти самокат"
    private final By orderDataWhenDelivery = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    // Локатор для поля "Срок аренды"
    private final By rentalPeriod = By.className("Dropdown-placeholder");

    // Локатор для поля "Срок аренды - сутки"
    private final By period_1day = By.xpath(".//*[@class='Dropdown-option'][1]");

    // Локатор для поля "Срок аренды - 2 суток"
    private final By period_2days = By.xpath(".//*[@class='Dropdown-option'][2]");

    // Локатор для поля "Срок аренды - 3 суток"
    private final By period_3days = By.xpath(".//*[@class='Dropdown-option'][3]");

    // Локатор для поля "Срок аренды - 4 суток"
    private final By period_4days = By.xpath(".//*[@class='Dropdown-option'][4]");

    // Локатор для поля "Срок аренды - 5 суток"
    private final By period_5days = By.xpath(".//*[@class='Dropdown-option'][5]");

    // Локатор для поля "Срок аренды - 6 суток"
    private final By period_6days = By.xpath(".//*[@class='Dropdown-option'][6]");

    // Локатор для поля "Срок аренды - 7 суток"
    private final By period_7days = By.xpath(".//*[@class='Dropdown-option'][7]");

    // Локатор "Цвет самоката Церный жемчуг"
    private final By blackPearl = By.xpath(".//input[@id='black']");

    // Локатор "Цвет самоката Серая безысходность"
    private final By grayHopelessness = By.xpath(".//input[@id='grey']");

    // Локатор для поля "Комментарий для курьера"
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Локатор для кнопки "Заказать"
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public RentOrderPage(WebDriver driver) {

        this.driver = driver;
    }

    // Метод для выбора даты в поле "Когда привезти самокат"
    public void enterDate(String newDate) {
        driver.findElement(orderDataWhenDelivery).sendKeys(newDate);
        driver.findElement(orderDataWhenDelivery).sendKeys(Keys.ENTER);
    }

    // Метод для выборя количества дней аренды
    public void choosePeriod(int days) {
        driver.findElement(rentalPeriod).click();
        if (days == 1) {
            driver.findElement(period_1day).click();
        } else if (days == 2) {
            driver.findElement(period_2days).click();
        } else if (days == 3) {
            driver.findElement(period_3days).click();
        } else if (days == 4) {
            driver.findElement(period_4days).click();
        } else if (days == 5) {
            driver.findElement(period_5days).click();
        } else if (days == 6) {
            driver.findElement(period_6days).click();
        } else if (days == 7) {
            driver.findElement(period_7days).click();
        }
    }

    // Метод для выбора цвета самоката "Церный жемчуг"
    public void clickBlackPearl() {
        driver.findElement(blackPearl).click();
    }

    // Метод для выбора цвета самоката "Серая безысходность"
    public void clickGrayHopelessness() {
        driver.findElement(grayHopelessness).click();
    }

    // Метод для выбора цвета
    public void chooseColor(String newColor) {
        if (newColor.equals("black")) {
            clickBlackPearl();
        } else if (newColor.equals("grey")) {
            clickGrayHopelessness();
        }
    }

    // Метод дял ввода комментария для курьера
    public RentOrderPage enterComment(String newComment) {
        driver.findElement(comment).sendKeys(newComment);
        return this;
    }

    // Метод для нажатия кнопки "Заказать"
    public RentOrderPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    // Общий метод для ввода даты, выбора периода, выбора цвета, ввода комментария и нажатия на кнопку "Заказать" на странице "Про аренду"
    public RentOrderPage enterAllDataRentOrder(String newDate, int days, String newColor, String newComment) {
        enterDate(newDate);
        choosePeriod(days);
        chooseColor(newColor);
        enterComment(newComment);
        new WebDriverWait(driver, Duration.ofSeconds(3)); // Задержка на 3 секунды, чтобы успеть проверить
        clickOrderButton();
        return this;
    }

}