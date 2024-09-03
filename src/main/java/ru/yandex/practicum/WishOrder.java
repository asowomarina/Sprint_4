package ru.yandex.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс страницы "Хотите оформить заказ?"
public class WishOrder {

    private final WebDriver driver;

    // Локатор для кнопки "Да" в окне "Хотите оформить заказ?"
    private final By okButton = By.xpath(".//*[text()='Да']");

    public WishOrder(WebDriver driver) {

        this.driver = driver;
    }

    // Метод для нажатия на кнопку "Да"
    public WishOrder clickOkButton() {
        driver.findElement(okButton).click();
        return this;
    }

}