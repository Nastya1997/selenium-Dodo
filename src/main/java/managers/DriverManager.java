package managers;

import configuration.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
            initDriver(ConfigProperties.getProperty("browsername"));
        }
        return driver;
    }
    
    public static WebDriverWait initWait(){
        return new WebDriverWait(driver, 10, 1000);
    }
    
    public static void initDriver(String browserName){
        switch (browserName) {
            case ("chrome"):
                System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case ("firefox"):
                System.setProperty("webdriver.gecko.driver", "lib\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case ("edge"):
                System.setProperty("webdriver.edge.driver", "lib\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                break;
        }
        driverWait = getWait();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}
