package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainTest {

    public static MainPage mainPage;
    public static WebDriver driver;
    public static WebDriverWait driverWait;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");

        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driverWait = new WebDriverWait(driver, 10, 1000);

        driver.get("https://dodopizza.ru");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void loginTest() throws InterruptedException {
        mainPage.inputSearchCity("омск");
        mainPage.chooseCity(); // выбор найденного города из списка
        mainPage.chooseMenu(); // выбор вида еды "Пицца"
        mainPage.searchKindOfPizza(); // скролл до пиццы "Четыре сезона" и выбор
        mainPage.checkPizza(); // открытие карточки пиццы и сверка, что открыта "Четыре сезона"
        mainPage.addToBucket(); // добавление в корзину
        mainPage.goToBucket(); // переход в корзину
        mainPage.checkingBucket(); // проверка, что в корзине "Четыре сезона"
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

}
