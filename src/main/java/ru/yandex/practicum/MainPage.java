package ru.yandex.practicum;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс главной страницы сайта Самокат
public class MainPage {

    private final WebDriver driver;

    // Локатор для кнопки закрытия баннера с согласием на использование cookies
    private final By cookieConsentCloseButton = By.cssSelector(".App_CookieConsent__1yUIN button");

    // Локатор для верхней кнопки "Заказать"
    private final By higherOrderButton = By.xpath(".//button[(@class ='Button_Button__ra12g' and text()='Заказать')]");

    // Локатор для нижней кнопки "Заказать"
    private final By lowerOrderButton = By.className("Button_Middle__1CSJM");

    // Локаторы кнопкок вопросов раздела "Вопросы о важном"
    private final By buttonsImportantQuestionsList_0 = By.id("accordion__heading-0");
    private final By buttonsImportantQuestionsList_1 = By.id("accordion__heading-1");
    private final By buttonsImportantQuestionsList_2 = By.id("accordion__heading-2");
    private final By buttonsImportantQuestionsList_3 = By.id("accordion__heading-3");
    private final By buttonsImportantQuestionsList_4 = By.id("accordion__heading-4");
    private final By buttonsImportantQuestionsList_5 = By.id("accordion__heading-5");
    private final By buttonsImportantQuestionsList_6 = By.id("accordion__heading-6");
    private final By buttonsImportantQuestionsList_7 = By.id("accordion__heading-7");

    // Массив из локаторов кнопок раздела "Вопрсоы о важном"
    private final By[] buttonsImportantQuestionsArray = {buttonsImportantQuestionsList_0, buttonsImportantQuestionsList_1, buttonsImportantQuestionsList_2, buttonsImportantQuestionsList_3, buttonsImportantQuestionsList_4, buttonsImportantQuestionsList_5, buttonsImportantQuestionsList_6, buttonsImportantQuestionsList_7};

    // Локаторы к текстовым ответам раздела "Вопросы о важном"
    private final By answersImportantQuestionsList_0 = By.xpath(".//div[@id='accordion__panel-0']/p");
    private final By answersImportantQuestionsList_1 = By.xpath(".//div[@id='accordion__panel-1']/p");
    private final By answersImportantQuestionsList_2 = By.xpath(".//div[@id='accordion__panel-2']/p");
    private final By answersImportantQuestionsList_3 = By.xpath(".//div[@id='accordion__panel-3']/p");
    private final By answersImportantQuestionsList_4 = By.xpath(".//div[@id='accordion__panel-4']/p");
    private final By answersImportantQuestionsList_5 = By.xpath(".//div[@id='accordion__panel-5']/p");
    private final By answersImportantQuestionsList_6 = By.xpath(".//div[@id='accordion__panel-6']/p");
    private final By answersImportantQuestionsList_7 = By.xpath(".//div[@id='accordion__panel-7']/p");

    // Массив локаторов из текстовых ответов раздела "Вопрсоы о важном"
    private final By[] answersImportantQuestionsArray = {answersImportantQuestionsList_0, answersImportantQuestionsList_1, answersImportantQuestionsList_2, answersImportantQuestionsList_3, answersImportantQuestionsList_4, answersImportantQuestionsList_5, answersImportantQuestionsList_6, answersImportantQuestionsList_7};

    // Массив ожидаемых ответов к вопросам
    private final String[] expectedAnswersImportantQuestions = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    // Метод для закрытия баннера с согласием на использование cookies
    public void closeCookieConsentBanner() {
        try {
            WebElement closeButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(cookieConsentCloseButton));
            closeButton.click();
        } catch (TimeoutException e) {
            // Если баннер не присутствует, ничего не делаем
        }
    }

    // Метод для открытия главной страницы Самоката
    public void openScooterPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // Метод для прокрутки страницы и кликна по кнопке в разделе "Вопросы о важном"
    public void clickButtonsImportantQuestions(int listIndex) {
        By locator = buttonsImportantQuestionsArray[listIndex];
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    // Метод для клика по верхней кнопке "Заказать" на главной странице
    public void higherOrderButtonClick() {
        driver.findElement(higherOrderButton).click();
    }

    // Метод для кликна по нижней кнопке "Заказать"
    public MainPage lowerOrderButtonClick() {
        WebElement element = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(lowerOrderButton).click();
        return this;
    }

    // Метод для выбора кнопки "Заказать" на странице
    public MainPage chooseOrderButtonAndClick(String buttonLocation) {
        closeCookieConsentBanner(); // Закрываем баннер с согласием на использование cookies, если он присутствует
        if (buttonLocation.equals("up")) {
            higherOrderButtonClick();
            return this;
        } else if (buttonLocation.equals("down")) {
            lowerOrderButtonClick();
            return this;
        }
        return this;
    }

    // Метод для получения текста из текстовых ответов раздела "Вопрсоы о важном"
    public String getAnswersImportantQuestions(int listIndex) {
        By locator = answersImportantQuestionsArray[listIndex];
        return driver.findElement(locator).getText();
    }

    // Метод для сравнения текстовых ответов с ожидаемыми ответами
    public boolean contentIsDisplayed(int listIndex) {
        By locator = answersImportantQuestionsArray[listIndex];
        String expectedAnswersText = expectedAnswersImportantQuestions[listIndex];
        new WebDriverWait(driver, Duration.ofSeconds(5)) // Добавляем 5 секунд оожидания, чтобы успеть проверить
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).isDisplayed() && getAnswersImportantQuestions(listIndex).equals(expectedAnswersText);
    }

}