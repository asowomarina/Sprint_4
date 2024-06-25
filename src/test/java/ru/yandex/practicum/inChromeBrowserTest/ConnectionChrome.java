package ru.yandex.practicum.inChromeBrowserTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// Базовый класс для подключения драйвера Chrome
public class ConnectionChrome {

    WebDriver driver;

    // Подключение драйвера браузера и установление ожидания в 5 секунд
    @Before
    public void open() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // Закрытие браузера
    @After
    public void close() {
        driver.quit();
    }
}
