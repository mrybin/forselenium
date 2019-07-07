import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Task_1 {
    WebDriver driver;
    String baseURL;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseURL ="https://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
    @Test
    public void maintest() {
        driver.findElement(By.xpath("//li//span[(text()='Страхование')]")).click();
        driver.findElement(By.xpath("//li[@class='lg-menu__sub-item']//*[contains(text(),'Путешествия и покупки')]")).click();
        Assert.assertEquals("Страхование путешественников",driver.findElement(By.xpath("//h3[text()='Страхование путешественников']")).getText());
        driver.findElement(By.xpath("//a[contains(@href,'https://online.sberbankins.ru/store/vzr/')]")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(By.xpath("//div[contains(text(),'Необходимый минимум')]")).click();
        driver.findElement(By.xpath("//span[text()='Оформить']")).click();

        fillField(By.name("insured0_surname"),"Ivanov");
        fillField(By.name("insured0_name"),"Ivan");
        fillField(By.name("surname"),"Васин");
        fillField(By.name("name"),"Василий");
        fillField(By.name("middlename"),"Васильевич");
        fillField(By.name("birthDate"),"20.01.1988");
        driver.findElement(By.name("male")).click();
        fillField(By.name("passport_series"),"4477");
        fillField(By.name("passport_number"),"368812");
        fillField(By.name("issueDate"),"26.01.2008");
        fillField(By.name("issuePlace"),"Россией");

        Assert.assertEquals("Ivanov",driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        Assert.assertEquals("Ivan",driver.findElement(By.name("insured0_name")).getAttribute("value"));
        Assert.assertEquals("Васин",driver.findElement(By.name("surname")).getAttribute("value"));
        Assert.assertEquals("Василий",driver.findElement(By.name("name")).getAttribute("value"));
        Assert.assertEquals("Васильевич",driver.findElement(By.name("middlename")).getAttribute("value"));
        Assert.assertEquals("20.01.1988",driver.findElement(By.name("birthDate")).getAttribute("value"));
        Assert.assertEquals("4477",driver.findElement(By.name("passport_series")).getAttribute("value"));
        Assert.assertEquals("368812",driver.findElement(By.name("passport_number")).getAttribute("value"));
        Assert.assertEquals("26.01.2008",driver.findElement(By.name("issueDate")).getAttribute("value"));
        Assert.assertEquals("Россией",driver.findElement(By.name("issuePlace")).getAttribute("value"));

        driver.findElement(By.xpath("//*[text()='Продолжить']")).click();
        Assert.assertEquals("Заполнены не все обязательные поля",driver.findElement(By.xpath("//*[text()='Заполнены не все обязательные поля']")).getText());
    }

    public void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public void afterTest(){
      driver.quit();
    }
}
