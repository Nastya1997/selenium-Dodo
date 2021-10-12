package org.example.tests;

import pages.MainPage;
import org.junit.Test;

import static managers.DriverManager.getDriver;

public class MainTest extends BaseTest{

    public static MainPage mainPage = new MainPage(getDriver());

    @Test
    public void loginTest() {
        mainPage.chooseCity("Омск") // выбор города из списка
                .chooseMenu("Пицца") // выбор вида еды "Пицца"
                .chooseTitlePizza("Четыре сезона") // скролл до нужной пиццы и выбор
                .checkPizza("Четыре сезона") // проверка, что открыта "Четыре сезона"
                .addToBucket() // добавление в корзину
                .goToBucket(); // переход в корзину
               // .checkingBucket(); // проверка, что в корзине "Четыре сезона"
    }
}
