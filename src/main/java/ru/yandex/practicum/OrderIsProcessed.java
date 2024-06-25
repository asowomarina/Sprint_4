package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс страницы "Заказ оформлен"
public class OrderIsProcessed {

    private final WebDriver driver;

    // Локатор поля Заказ оформлен
    private final By orderIsProcessed = By.xpath("//div[text()='Заказ оформлен']");

    public OrderIsProcessed(WebDriver driver) {

        this.driver = driver;
    }

    // Метод возвращает истину, если поле "Заказ оформлен" отображено
    public boolean orderIsProcessedTextIsDisplayed() {
        return driver.findElement(orderIsProcessed).isDisplayed();
    }
}