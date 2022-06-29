package co.com.restapiexample.stepdefinitions;

import co.com.restapiexample.tasks.ConsultAllEmployee;
import co.com.restapiexample.tasks.ConsultEmployee;
import co.com.restapiexample.tasks.CreateEmployee;
import co.com.restapiexample.tasks.DeleteEmployee;
import co.com.restapiexample.utils.ActorNotepad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EmployeeStepDefinition {

    @Given("that {string} wants to manage the company's employee registry")
    public void thatWantsToManageTheCompanySEmployeeRegistry(String actor) {
        theActorCalled(actor).whoCan(CallAnApi.at("https://dummy.restapiexample.com/api/v1/"));
    }

    @When("he create the user {string} of {string} years with a salary of {string}")
    public void heCreateTheUserOfYearsWithASalaryOf(String name, String age, String salary) {
        theActorInTheSpotlight().attemptsTo(
                CreateEmployee.withServicePost(name, age, salary)
        );
    }

    @When("he deletes the record of the employee with his identifier {string}")
    public void heDeletesTheRecordOfTheEmployeeWithHisIdentifier(String idEmployee) {
        theActorInTheSpotlight().attemptsTo(
                DeleteEmployee.withServiceDelete(idEmployee)
        );
    }

    @When("he consults all the employees of the company")
    public void heConsultsAllTheEmployeesOfTheCompany() {
        theActorInTheSpotlight().attemptsTo(
                ConsultAllEmployee.withServiceGet()
        );
    }

    @When("he consults the employee with his identifier {string}")
    public void heConsultsTheEmployeeWithHisIdentifier(String idEmployee) {
        theActorInTheSpotlight().attemptsTo(
                ConsultEmployee.withServiceGet(idEmployee)
        );
    }

    @Then("he should see the status {string} and message {string}")
    public void heShouldSeeTheStatusAndMessage(String status, String message) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(theActorInTheSpotlight().recall(ActorNotepad.STATUS.getKey()).toString()).isEqualTo(status),
                Ensure.that(theActorInTheSpotlight().recall(ActorNotepad.MESSAGE.getKey()).toString()).isEqualTo(message)
        );
    }

    @Then("he should see the name {string}, age {string} and salary {string} of the employee")
    public void heShouldSeeTheNameAgeAndSalaryOfTheEmployee(String name, String age, String salary) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(theActorInTheSpotlight().recall(ActorNotepad.NAME.getKey()).toString()).isEqualTo(name),
                Ensure.that(theActorInTheSpotlight().recall(ActorNotepad.AGE.getKey()).toString()).isEqualTo(age),
                Ensure.that(theActorInTheSpotlight().recall(ActorNotepad.SALARY.getKey()).toString()).isEqualTo(salary)
        );
    }

}
