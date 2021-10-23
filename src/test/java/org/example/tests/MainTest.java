package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.List;

import static managers.DriverManager.getDriver;
import static managers.DriverManager.getWait;

public class MainTest extends BaseTest{

    public static MainPage mainPage = new MainPage(getDriver());

//    static {
//        try {
           // mainPage = new MainPage(getDriver());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    @DisplayName("Заказ пиццы Аррива!")
    public void loginTest(){
        //mainPage.chooseCity("Омск");
        //chooseCity("Омск");// выбор города из списка
        mainPage.chooseCity("Омск")
                .chooseMenu("Пицца") // выбор вида еды "Пицца"
                .chooseTitlePizza("Аррива!") // скролл до нужной пиццы и выбор
                .checkPizza("Аррива!") // проверка, что открыта нужная пицца
                .addToBucket() // добавление в корзину
                .goToBucket(); // переход в корзину
               // .checkingBucket(); // проверка, что в корзине нужная пицца
    }
}
