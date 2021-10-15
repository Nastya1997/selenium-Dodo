package org.example.tests;

import pages.MainPage;
import org.junit.Test;

import java.net.MalformedURLException;

import static managers.DriverManager.getDriver;

public class MainTest extends BaseTest{

    public static MainPage mainPage;

    static {
        try {
            mainPage = new MainPage(getDriver());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginTest() throws MalformedURLException {
        mainPage.chooseCity("Омск") // выбор города из списка
                .chooseMenu("Пицца") // выбор вида еды "Пицца"
                .chooseTitlePizza("Аррива!") // скролл до нужной пиццы и выбор
                .checkPizza("Аррива!") // проверка, что открыта нужная пицца
                .addToBucket() // добавление в корзину
                .goToBucket(); // переход в корзину
               // .checkingBucket(); // проверка, что в корзине нужная пицца
    }
}
