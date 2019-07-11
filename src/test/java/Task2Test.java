import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pages.InsurancePage1;
import pages.InsurancePage2;
import pages.InsuranceTravel;
import pages.MainPage;
import steps.BaseSteps;

import java.util.ArrayList;

public class Task2_Test extends BaseSteps {

    @Test
    @Ignore
    public void newTask_Test(){
        MainPage main= new MainPage(driver);
        main.selectMainMenu("Страхование");
        main.selectSubMenu("Путешествия и покупки");
        InsuranceTravel ins = new InsuranceTravel(driver);
        Assert.assertEquals("Страхование путешественников", ins.instrav.getText());
        ins.insurance.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        InsurancePage1 page1 = new InsurancePage1(driver);
        page1.need.click();
        page1.issue.click();
        InsurancePage2 page2 = new InsurancePage2(driver);
        page2.fillField("Surname","Ivanov");
        page2.fillField("Name", "Ivan");
        page2.fillField("Фамилия","Васин");
        page2.fillField("Имя","Василий");
        page2.fillField("Отчество", "Васильевич");
        page2.fillField("Дата рождения", "15.10.1988");
        page2.male.click();
        page2.fillField("Серия паспорта","6611");
        page2.fillField("Номер паспорта","115534");
        page2.fillField("Когда", "14.05.2007");
        page2.fillField("Кем выдан","Россией");
        Assert.assertEquals("Ivanov",page2.getfillField("Surname"));
        Assert.assertEquals("Ivan",page2.getfillField("Name"));
        Assert.assertEquals("Васин",page2.getfillField("Фамилия"));
        Assert.assertEquals("Василий",page2.getfillField("Имя"));
        Assert.assertEquals("Васильевич",page2.getfillField("Отчество"));
        Assert.assertEquals("15.10.1988",page2.getfillField("Дата рождения"));
        Assert.assertEquals("6611",page2.getfillField("Серия паспорта"));
        Assert.assertEquals("115534",page2.getfillField("Номер паспорта"));
        Assert.assertEquals("14.05.2007",page2.getfillField("Когда"));
        Assert.assertEquals("Россией",page2.getfillField("Кем выдан"));
        page2.next.click();
        Assert.assertEquals("Заполнены не все обязательные поля",page2.notAll.getText());
    }

}
