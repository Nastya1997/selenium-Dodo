package managers;

import configuration.ConfigProperties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
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
    
    public static WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            initDriver(ConfigProperties.getProperty("run"));
        }
        return driver;
    }
    
    public static WebDriverWait initWait(){
        return new WebDriverWait(driver, 10, 1000);
    }
    
    public static void initDriver(String typeRun) throws MalformedURLException {
        switch (typeRun) {
            case ("SELENOID"):
                runWithSelenoid();
                break;
            case ("LOCAL"):
                runLocal(ConfigProperties.getProperty("browsername"));
                break;
            default:
                break;
        }
    }

    private static void runLocal(String browserName) {
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

    private static void runWithSelenoid() throws MalformedURLException {
        String browserSelenoid = ConfigProperties.getProperty("browsername");
        switch (browserSelenoid) {
            case ("chrome"):
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("browserVersion", "80.0");
                chromeOptions.setCapability("name", "dodo");
                chromeOptions.setCapability("enableVNC", true);
                driver = new RemoteWebDriver(new URL("http://161.35.194.216:4444/wd/hub"), chromeOptions);
                driver.manage().window().setSize(new Dimension(1920, 1080));
                break;
            case ("opera"):
                OperaOptions operaOptions = new OperaOptions();
                DesiredCapabilities capabilities = new DesiredCapabilities(operaOptions);
                capabilities.setBrowserName("opera");
                capabilities.setVersion("67.0");
                capabilities.setCapability("enableVNC", true);
//                operaOptions.setCapability("browserVersion", "67.0");
//                operaOptions.setCapability("name", "dodo");
//                operaOptions.setCapability("enableVNC", true);
                driver = new RemoteWebDriver(new URL("http://161.35.194.216:4444/wd/hub"), capabilities);
                driver.manage().window().setSize(new Dimension(1920, 1080));
                break;
            case ("firefox"):
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("browserVersion", "75.0");
                firefoxOptions.setCapability("name", "dodo");
                firefoxOptions.setCapability("enableVNC", true);
                driver = new RemoteWebDriver(new URL("http://161.35.194.216:4444/wd/hub"), firefoxOptions);
                driver.manage().window().setSize(new Dimension(1920, 1080));
                break;
        }
    }
}
