package ru.yandex.practicum.inFireFoxBrowserTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

// Базовый класс для подключения драйвера FireFox
public class ConnectionFF {
    WebDriver driver;

    @Before
    // Подключение браузера и установление ожидания в 5 секунд
    public void open() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // Закрытие браузера
    @After
    public void close() {
        driver.quit();
    }
}
