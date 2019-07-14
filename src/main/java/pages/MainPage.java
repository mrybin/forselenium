package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage {

    @FindBy(xpath="//div[contains(@class,'lg-menu__row')]")
    WebElement mainMenu;

    @FindBy(xpath="//div[contains(@id, 'submenu-5')]")
    WebElement subMenu;

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void selectMainMenu(String item){
        mainMenu.findElement(By.xpath(".//li//span[contains(text(),'"+item+"')]")).click();
    }
    public void selectSubMenu(String item){
        subMenu.findElement(By.xpath(".//li//a[contains(text(),'"+item+"')]")).click();
    }

}
