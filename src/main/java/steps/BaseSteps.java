package steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected static WebDriver driver;
    protected static String baseURL;
    public static Properties properties = TestProperties.getInstance().getProperties();

    @BeforeClass
    public static void beforeTest(){
        switch (properties.getProperty("browser")){
            case "firefox":
                System.setProperty("webdriver.gecko.driver",properties.getProperty("webdriver.gecko.driver"));
                driver=new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver=new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver=new ChromeDriver();
        }

        baseURL =properties.getProperty("app.url");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);

    }
    @AfterClass
    public static void afterTest(){
        driver.quit();
    }
    public void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
}
