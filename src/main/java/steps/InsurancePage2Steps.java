package steps;

import org.junit.Assert;
import pages.InsurancePage2;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class InsurancePage2Steps {

    @Step("поле (0) заполняется значением (1)")
    public void fillFieldStep(String field, String value){
        new InsurancePage2().fillField(field,value);
    }

    @Step("заполняются поля:")
    public void fillFieldsStep(HashMap<String, String> fields){
        fields.forEach(this::fillFieldStep);
    }
    @Step("сравнение ошибки")
    public void checkErrorStep(String error){
        Assert.assertTrue(error.equals(new InsurancePage2().notAll.getText()));
    }

    @Step("поле (0) заполнено (1)")
    public void checkFillFieldStep(String field, String value){
        String act = new InsurancePage2().getfillField(field);
        Assert.assertTrue(value.equals(act));
    }
    @Step("поля заполнены верно")
    public void checkFillFieldsStep(HashMap<String, String> fields){
        fields.forEach(this::checkFillFieldStep);
    }
    @Step("выбор мужского пола")
    public void checkMaleStep(){
        new InsurancePage2().male.click();
    }
    @Step("нажатие кнопки Продолжить")
    public void clickNextStep(){
        new InsurancePage2().next.click();
    }
}
