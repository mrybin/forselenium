package steps;

import pages.InsurancePage1;
import ru.yandex.qatools.allure.annotations.Step;

public class InsurancePage1Steps extends BaseSteps{

    @Step("Выбор минимального страхования")
    public void selectmin(){
        new InsurancePage1(driver).need.click();
    }

    @Step("Нажатие кнопки Оформить")
    public void clickIssue(){
        new InsurancePage1(driver).issue.click();
    }
}
