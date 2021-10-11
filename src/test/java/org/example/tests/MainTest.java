package org.example.tests;

import pages.MainPage;
import org.junit.Test;

import static managers.DriverManager.getDriver;

public class MainTest extends BaseTest{

    public static MainPage mainPage = new MainPage(getDriver());

    @Test
    public void loginTest() {
        mainPage.chooseCity("Омск") // выбор найденного города из списка
                .chooseMenu(); // выбор вида еды "Пицца"
        mainPage.searchKindOfPizza(); // скролл до пиццы "Четыре сезона" и выбор
        mainPage.checkPizza(); // открытие карточки пиццы и сверка, что открыта "Четыре сезона"
        mainPage.addToBucket(); // добавление в корзину
        mainPage.goToBucket(); // переход в корзину
        mainPage.checkingBucket(); // проверка, что в корзине "Четыре сезона"
    }
}
