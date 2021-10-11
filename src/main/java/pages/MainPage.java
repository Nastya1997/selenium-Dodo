package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static managers.DriverManager.getDriver;
import static managers.DriverManager.getWait;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //локатор для нахождения нужного города на странице
    @FindBy(xpath = "//a[@class='sc-176km0j-0 fiArIx locality-selector-popup__link ']")
    private List<WebElement> clickCity;

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

    //клик по нужному городу
    public MainPage chooseCity(String cityDesirable) {
        for (WebElement city : clickCity) {
            if (city.getText().equals(cityDesirable)) {
                scrollToElement(city);
                waitUntilVisible(city);
                city.click();
                break;
            }
        }
        return this;
    }

    //клик по подменю Пицца
    public void chooseMenu() {
        chooseMenuPizza.click();
    }

    //поиск определенного вида пиццы
    public void searchKindOfPizza() {
        scrollToElement(searchKindPizza);
        waitUntilVisible(searchKindPizza);
        scrollToElement(buttonChoose);
        waitUntilVisible(buttonChoose);
        waitUntilClickable(buttonChoose);
        buttonChoose.click();
    }

    private void waitUntilClickable(WebElement buttonChoose) {
        getWait().until(ExpectedConditions.elementToBeClickable(buttonChoose));
    }

    //скролл к элементу
    public void scrollToElement(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    //проверка отображения заголовка в открытой карточке пиццы
    public void checkPizza() {
        waitUntilVisible(checkTitle);
        checkTitle.isDisplayed();
    }

    //добавление пиццы в корзину
    public void addToBucket() {
        buttonAdd.click();
    }

    //клик по кнопке Корзина
    public void goToBucket() {
        waitUntilVisible(bucket);
        waitUntilClickable(bucket);
        bucket.click();
    }

    private void waitUntilVisible(WebElement bucket) {
        getWait().until(ExpectedConditions.visibilityOf(bucket));
    }

    //проверка отображения заголовка в открытой корзине
    public void checkingBucket() {
        waitUntilVisible(checkTitleBucket);
    }
}