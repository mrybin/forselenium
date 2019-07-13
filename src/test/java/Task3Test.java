import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Task3Test extends BaseSteps{


    @Test
    @Title("Страхование")
    public void insure_Test () {
        MainSteps mainSteps = new MainSteps();
        InsuranceTravelSteps insuranceTravel = new InsuranceTravelSteps();
        InsurancePage1Steps insurancePage1 = new InsurancePage1Steps();
        InsurancePage2Steps insurancePage2 = new InsurancePage2Steps();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Surname","Ivanov");
        testData.put("Name", "Ivan");
        testData.put("Фамилия","Васин");
        testData.put("Имя","Василий");
        testData.put("Отчество", "Васильевич");
        testData.put("Дата рождения", "15.10.1988");
        testData.put("Серия паспорта","6611");
        testData.put("Номер паспорта","115534");
        testData.put("Когда", "14.05.2007");
        testData.put("Кем выдан","Россией");

        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepSelectSubMenu("Путешествия и покупки");
        insuranceTravel.checkTitle("Страхование путешественников");
        insuranceTravel.sendInsuranceTravelStep();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        insurancePage1.selectmin();
        insurancePage1.clickIssue();

        insurancePage2.fillFieldsStep(testData);
        insurancePage2.checkMaleStep();
        insurancePage2.checkFillFieldsStep(testData);
        insurancePage2.clickNextStep();
        insurancePage2.checkErrorStep("Заполнены не все обязательные поля");
    }
}
