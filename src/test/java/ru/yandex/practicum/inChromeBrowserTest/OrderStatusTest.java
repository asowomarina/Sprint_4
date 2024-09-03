package ru.yandex.practicum.inChromeBrowserTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.*;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderStatusTest extends ConnectionChrome {

    private final String buttonLocation;
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;
    private final String newDate;
    private final int days;
    private final String newColor;
    private final String newComment;

    // Конструктор тест-класса
    public OrderStatusTest(String buttonLocation, String name, String surname, String address, String telephone, String newDate, int days, String newColor, String newComment) {
        this.buttonLocation = buttonLocation;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.newDate = newDate;
        this.days = days;
        this.newColor = newColor;
        this.newComment = newComment;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"up", "Максим", "Смирнов", "Сокольники", "89507842612", "01.07.2024", 3, "black", "Привезите как можно быстрее!"},
                {"down", "Анастасия", "Григорьева", "Лубянка", "89230801341", "24.06.2024", 5, "grey", "Обязательно серого цвета"},

        };
    }

    @Test
    public void enterOrderAllDataTest() {

        // Создание объекта главной страницы
        MainPage objHomePage = new MainPage(driver);

        // Обращение к сайту Самоката
        objHomePage.openScooterPage();

        // Выбор кнопки "Заказать" для клика
        objHomePage.chooseOrderButtonAndClick(buttonLocation);

        // Создание объекта страницы "Для кого самокат"
        new OrderDataPage(driver)
                // Вызов метода для ввода данных на странице "Для кого самокат"
                .enterOrderAllData(name, surname, address, telephone);

        // Создание объекта страницы "Про аренду"
        new RentOrderPage(driver)
                // Вызов метода для ввода данных на странице "Про аренду"
                .enterAllDataRentOrder(newDate, days, newColor, newComment);

        // Создание объекта страницы "Хотите оформить заказ?"
        new WishOrder(driver)
                // Клик на кнопку "Да" в окне "Хотите оформить заказ?"
                .clickOkButton();

        // Создание объекта страницы "Заказ оформлен"
        OrderIsProcessed objOrderIsProcessed = new OrderIsProcessed(driver);

        // Проверка "Заказ оформлен". В приложении есть баг, который не дает оформить заказ. Он воспроизводится только в Chrome
        assertTrue(objOrderIsProcessed.orderIsProcessedTextIsDisplayed());
    }

}