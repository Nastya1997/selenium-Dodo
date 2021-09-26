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
        System.setProperty("webdriver.chrome.driver", "C:\\projects\\lib\\chromedriver.exe");

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
        mainPage.chooseCity();
        mainPage.chooseMenu();
        mainPage.searchKindOfPizza();
        mainPage.checkPizza();
        mainPage.addToBucket();
        mainPage.goToBucket();
        mainPage.checkingBucket();
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

}
