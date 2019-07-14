package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class InsurancePage1 {

    @FindBy(xpath = "//div[contains(text(),'Необходимый минимум')]")
    public WebElement need;

    @FindBy (xpath = "//span[text()='Оформить']")
    public WebElement issue;

    public InsurancePage1(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }
}
