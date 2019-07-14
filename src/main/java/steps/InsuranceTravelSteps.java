package steps;


import org.junit.Assert;
import pages.InsuranceTravel;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceTravelSteps extends BaseSteps{

    @Step ("Выполнено нажатие на кнопку Оформить заявку")
    public void sendInsuranceTravelStep(){
        new InsuranceTravel().insurance.click();
    }
    @Step ("Сравнение с заголовка с текстом (0)")
    public void checkTitle(String title){
        Assert.assertTrue(title.equals(new InsuranceTravel().instrav.getText()) );
    }

}
