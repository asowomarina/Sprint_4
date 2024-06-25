package ru.yandex.practicum.inFireFoxBrowserTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.MainPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ImportantQuestionTest extends ConnectionFF {

    private final int listIndex;

    // Конструктор тест-класса "Вопросы о важном" с 2 параметрами
    public ImportantQuestionTest(int listIndex) {
        this.listIndex = listIndex;
    }

    // Набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
        };
    }

    @Test
    public void IsVisibleTextWhenClickedButton() {

        // Создание объекта класса главной страницы
        MainPage objHomePage = new MainPage(driver);

        // Открытие главной страницы
        objHomePage.openScooterPage();

        // Клик по кнопке с вопросом в зависимости от индекса
        objHomePage.clickButtonsImportantQuestions(listIndex);

        // Сравнение результатов
        assertTrue(objHomePage.contentIsDisplayed(listIndex));
    }

}