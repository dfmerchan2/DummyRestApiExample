package co.com.restapiexample.tasks;

import co.com.restapiexample.utils.ActorNotepad;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static co.com.restapiexample.utils.ServiceName.SERVICE_ALL_EMPLOYEES;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ConsultAllEmployee implements Task {

    @Step("{0} consult the employees of the company")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(SERVICE_ALL_EMPLOYEES.getValue())
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
    }

    public static Performable withServiceGet(){
        return instrumented(ConsultAllEmployee.class);
    }
}
