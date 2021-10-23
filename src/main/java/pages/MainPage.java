package pages;

import io.qameta.allure.Step;
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
    private List<WebElement> location;

    //локатор для выбора вида блюда
    @FindBy(xpath = "//a..li[@class='ymp2tw-2 gWaecf']")
    private List<WebElement> menuBar;

    //локатор для нахождения определенного вида пиццы
    @FindBy(xpath = "//section[contains(@id, 'pizzas')]//div[@data-gtm-id='product-title']")
    private List<WebElement> titlePizza;

    //локатор для нахождения кнопки Добавить в корзину за ..
    @FindBy(xpath = "//button[contains(text(), 'Добавить в корзину за ')]")
    private WebElement buttonAdd;

    //локатор для нахождения заголовка в открываемой карточке пиццы при нахождении
    @FindBy(xpath = "//div[@class='k0j10-1 eqmleZ']//span")
    private List<WebElement> checkingTitle;

    //локатор для нахождения кнопки Корзина
    @FindBy(xpath = "//button[text()='Корзина']")
    private WebElement buttonBucket;

    //локатор для нахождения заголовка в открытой корзине
    @FindBy(xpath = "//h3")
    private WebElement checkingTitleBucket;

//    @FindBy(xpath = "//nav//a")
//    private List<WebElement> menuBar;

    //клик по нужному городу
    @Step("Выбор города")
    public MainPage chooseCity(String cityDesirable)  {
        for (WebElement city : location) {
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
    @Step("Choose menu")
    public MainPage chooseMenu(String menuType) {
        for(WebElement menu : menuBar) {
            if(menu.getText().equals(menuType)) {
                waitUntilClickable(menu);
                menu.click();
                break;
            }
        }
        return this;
    }

    //поиск и выбор определенного вида пиццы
    @Step("Search pizza")
    public MainPage chooseTitlePizza(String title) {
        for(WebElement name : titlePizza) {
            if(name.getText().equals(title)) {
                scrollToElement(name);
                waitUntilVisible(name);
                waitUntilClickable(name);
                name.click();
                break;
            }
        }
        return this;
    }

    //ожидание пока элемент станет доступным для клика по нему
    private void waitUntilClickable(WebElement buttonChoose) {
        getWait().until(ExpectedConditions.elementToBeClickable(buttonChoose));
    }

    //скролл к элементу
    public void scrollToElement(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    //проверка отображения заголовка в открытой карточке пиццы
    @Step("Check pizza")
    public MainPage checkPizza(String title) {
        for(WebElement name : checkingTitle) {
            if(name.getText().equals(title)) {
                waitUntilVisible(name);
                name.isDisplayed();
                break;
            }
        }
        return this;
    }

    //добавление пиццы в корзину
    @Step("Add to bucket")
    public MainPage addToBucket() {
        waitUntilClickable(buttonAdd);
        buttonAdd.click();
        return this;
    }

    //клик по кнопке Корзина
    @Step("Search")
    public MainPage goToBucket() {
        waitUntilVisible(buttonBucket);
        waitUntilClickable(buttonBucket);
        buttonBucket.click();
        return this;
    }

    //ожидание видимости элемента
    private void waitUntilVisible(WebElement bucket) {
        getWait().until(ExpectedConditions.visibilityOf(bucket));
    }

    //проверка отображения заголовка в открытой корзине
    public void checkingBucket() {
        waitUntilVisible(checkingTitleBucket);
    }
}