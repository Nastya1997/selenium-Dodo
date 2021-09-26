package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.example.MainTest.driver;
import static org.example.MainTest.driverWait;

public class MainPage {
    
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //локатор для нахождения Поиска на странице
    @FindBy(xpath = "//*[contains(@data-testid, 'locality-selector-popup__search-input')]")
    private WebElement searchCity;

    //локатор для нахождения нужного города на странице
    @FindBy(xpath = "//*[contains(text(), 'Омск')]")
    private WebElement clickCity;

    //локатор для нахождения подменю "Пицца"
    @FindBy(xpath = "//a[contains(text(), 'Пицца')]")
    private WebElement chooseMenuPizza;

    //локатор для нахождения определенного вида пиццы
    @FindBy(xpath = "//div[contains(text(), 'Четыре сезона')]")
    private WebElement searchKindPizza;

    //локатор для нахождения кнопки Выбрать (при выборе определенного вида пиццы)
    @FindBy(xpath = "//article[contains(@data-testid,'menu__meta-product_86')]//button[contains(text(), 'Выбрать')]")
    private WebElement buttonChoose;

    //локатор для нахождения кнопки Добавить в корзину за ..
    @FindBy(xpath = "//button[contains(text(), 'Добавить в корзину за ')]")
    private WebElement buttonAdd;

    //локатор для нахождения заголовка в открываемой карточке пиццы при нахождении
    @FindBy(xpath = "//span[contains(text(), 'Четыре сезона')]")
    private WebElement checkTitle;

    //локатор для нахождения кнопки Корзина
    @FindBy(xpath = "//button[contains(@class, 'sc-91ilwk-0 bwflEA sc-1bwqahw-2 eWmtEY')]")
    private WebElement bucket;

    //локатор для нахождения заголовка в открытой корзине
    @FindBy(xpath = "//h3[contains(text(), 'Четыре сезона')]")
    private WebElement checkTitleBucket;

    @FindBy(xpath = "//nav//a")
    private List<WebElement> menuBar;

    //инпут, работающий с поиском по городам
    public void inputSearchCity(String city) {
        searchCity.sendKeys(city);
    }

    //клик по нужному городу
    public void chooseCity() {
        clickCity.click();
    }

    //клик по подменю Пицца
    public void chooseMenu() {
        chooseMenuPizza.click();
    }

    //поиск определенного вида пиццы
    public void searchKindOfPizza() {
        scrollToElement(searchKindPizza);
        driverWait.until(ExpectedConditions.visibilityOf(searchKindPizza));
        scrollToElement(buttonChoose);
        driverWait.until(ExpectedConditions.visibilityOf(buttonChoose));
        driverWait.until(ExpectedConditions.elementToBeClickable(buttonChoose));
        buttonChoose.click();
    }

    //скролл к элементу
    public void scrollToElement(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    //проверка отображения заголовка в открытой карточке пиццы
    public void checkPizza() {
        driverWait.until(ExpectedConditions.visibilityOf(checkTitle));
        checkTitle.isDisplayed();
    }

    //добавление пиццы в корзину
    public void addToBucket() throws InterruptedException {
        buttonAdd.click();
        Thread.sleep(3000);
    }

    //клик по кнопке Корзина
    public void goToBucket() {
        driverWait.until(ExpectedConditions.visibilityOf(bucket));
        driverWait.until(ExpectedConditions.elementToBeClickable(bucket));
        bucket.click();
    }

    //проверка отображения заголовка в открытой корзине
    public void checkingBucket() {
        driverWait.until(ExpectedConditions.visibilityOf(checkTitleBucket));
    }



}