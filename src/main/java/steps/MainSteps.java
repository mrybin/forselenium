package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    @Step ("выбран пункт меню {0}")
    public  void  stepSelectMainMenu(String item){
        new MainPage().selectMainMenu(item);
    }
    @Step ("выбран вид страхования {0}")
    public  void  stepSelectSubMenu(String item){
        new MainPage().selectSubMenu(item);
    }

}
