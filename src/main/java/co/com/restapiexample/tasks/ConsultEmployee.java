package co.com.restapiexample.tasks;

import co.com.restapiexample.utils.ActorNotepad;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static co.com.restapiexample.utils.ServiceName.SERVICE_EMPLOYEES;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultEmployee implements Task {

    private final String idEmployee;

    public ConsultEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Step("{0} consult the employee identified with the id: #idEmployee")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(SERVICE_EMPLOYEES.getValue() + idEmployee)
                        .with(
                                request ->
                                        request
                                                .contentType(ContentType.JSON)
                                                .log()
                                                .all()));
        SerenityRest.lastResponse().print();
        actor.should(seeThatResponse(response -> response.statusCode(200)));
        actor.remember(ActorNotepad.STATUS.getKey(), SerenityRest.lastResponse().jsonPath().getString("status"));
        actor.remember(ActorNotepad.MESSAGE.getKey(), SerenityRest.lastResponse().jsonPath().getString("message"));
        actor.remember(ActorNotepad.NAME.getKey(), SerenityRest.lastResponse().jsonPath().getString("data.employee_name"));
        actor.remember(ActorNotepad.SALARY.getKey(), SerenityRest.lastResponse().jsonPath().getString("data.employee_salary"));
        actor.remember(ActorNotepad.AGE.getKey(), SerenityRest.lastResponse().jsonPath().getString("data.employee_age"));
    }

    public static Performable withServiceGet(String idEmployee) {
        return instrumented(ConsultEmployee.class, idEmployee);
    }
}
