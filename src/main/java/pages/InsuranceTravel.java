package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceTravel {

    @FindBy (xpath = "//a[contains(@href,'https://online.sberbankins.ru/store/vzr/')]")
    public WebElement insurance;

    @FindBy (xpath = "//h3[text()='Страхование путешественников']")
    public WebElement instrav;

    public InsuranceTravel(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
