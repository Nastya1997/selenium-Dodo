package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;
    public static WebDriverWait driverWait;

    public static WebDriverWait getWait(){
        if (driverWait == null) {
            driverWait = initWait();
        }
        return driverWait;
    }
    
    public static WebDriver getDriver(){
        if (driver == null) {
            initDriver();
        }
        return driver;
    }
    
    public static WebDriverWait initWait(){
        return new WebDriverWait(driver, 10, 1000);
    }
    
    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = getWait();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}
