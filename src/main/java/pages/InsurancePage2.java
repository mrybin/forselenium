package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage2 {

    @FindBy(name="insured0_surname")
    public WebElement surnameEng;

    @FindBy(name = "insured0_name")
    public WebElement nameEng;

    @FindBy(name = "surname")
    public WebElement surname;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "middlename")
    public WebElement middlename;

    @FindBy (name="birthDate")
    public WebElement birth;

    @FindBy (name="male")
    public WebElement male;

    @FindBy (name = "passport_series")
    public WebElement passportSeries;

    @FindBy (name = "passport_number")
    public WebElement passportNumber;

    @FindBy (name = "issueDate")
    public WebElement issueDate;

    @FindBy (name = "issuePlace")
    public WebElement issuePlace;

    @FindBy (xpath = "//*[text()='Продолжить']")
    public WebElement next;

    @FindBy (xpath = "//*[text()='Заполнены не все обязательные поля']")
    public WebElement notAll;

    public InsurancePage2(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Surname":
                fillField(surnameEng, value);
                break;
            case  "Name":
                fillField(nameEng, value);
                break;
            case  "Фамилия":
                fillField(surname, value);
                break;
            case  "Имя":
                fillField(name, value);
                break;
            case  "Отчество":
                fillField(middlename, value);
                break;
            case  "Дата рождения":
                fillField(birth, value);
                break;
            case  "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case  "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case  "Кем выдан":
                fillField(issuePlace, value);
                break;
            case  "Когда":
                fillField(issueDate, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
    public void fillField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public String getfillField(String fieldName){
        switch (fieldName){
            case  "Surname":
                return surnameEng.getAttribute("value");
            case  "Name":
                return nameEng.getAttribute("value");
            case  "Фамилия":
                return surname.getAttribute("value");
            case  "Имя":
                return name.getAttribute("value");
            case  "Отчество":
                return middlename.getAttribute("value");
            case  "Дата рождения":
                return birth.getAttribute("value");
            case  "Серия паспорта":
                return passportSeries.getAttribute("value");
            case  "Номер паспорта":
                return passportNumber.getAttribute("value");
            case  "Кем выдан":
                return issuePlace.getAttribute("value");
            case  "Когда":
                return issueDate.getAttribute("value");
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
}
