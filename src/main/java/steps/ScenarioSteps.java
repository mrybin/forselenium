package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    InsuranceTravelSteps insTravel = new InsuranceTravelSteps();
    InsurancePage1Steps insPage1 = new InsurancePage1Steps();
    InsurancePage2Steps insPage2 = new InsurancePage2Steps();

    @When("^выбран пункт меню\"(.*)\"$")
    public void stepSelectMainMenu(String item){
        mainSteps.stepSelectMainMenu(item);
    }
    @When("^выбран вид страхования - \"(.*)\"$")
    public void stepSelectSubMenu(String item){
        mainSteps.stepSelectSubMenu(item);
    }
    @Then("^проверка на странице Путешествия и покупки заголовка - \"(.*)\"$")
    public void checkTitle(String title){
        insTravel.checkTitle(title);
    }
    @When("нажатие на кнопку оформить страховку")
    public void sendInsuranceTravelStep(){
        insTravel.sendInsuranceTravelStep();
        insTravel.nextpage();
    }
    @When("выбрать минимальное страхование")
    public void selectmin(){
        insPage1.selectmin();
    }
    @When("нажатие кнопку Оформить")
    public void clickIssue(){
        insPage1.clickIssue();
    }
    @When("запонлняются поля:")
    public void fillFieldsStep(DataTable fields){
        fields.asMap(String.class, String.class).forEach((key,value)-> insPage2.fillFieldStep(key,value));
    }
    @When("выбрать мужской пол")
    public void checkMaleStep(){
        insPage2.checkMaleStep();
    }
    @Then ("проверяются заполненные поля:")
    public void checkFieldsStep(DataTable fields){
        fields.asMap(String.class, String.class).forEach((key,value) ->insPage2.checkFillFieldStep(key,value));
    }
    @When ("нажимается кнопка продолжить")
    public void clickNextStep(){
        insPage2.clickNextStep();
    }
    @Then("^проверяется ошибка \"(.*)\"$")
    public void checkErrorStep (String error){
        insPage2.checkErrorStep(error);
    }
}
