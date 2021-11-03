package org.example.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static managers.DriverManager.getDriver;
import static managers.DriverManager.getWait;

public class MainTest extends BaseTest{

    public static MainPage mainPage = new MainPage(getDriver());

    @Test
    @DisplayName("Заказ пиццы Аррива!")
    public void loginTest(){
        mainPage.chooseCity("Омск")
                .chooseMenu("Пицца")
                .chooseTitlePizza("Аррива!")
                .checkPizza("Аррива!")
                .addToBucket()
                .goToBucket();
               // .checkingBucket(); // проверка, что в корзине нужная пицца
    }
}
