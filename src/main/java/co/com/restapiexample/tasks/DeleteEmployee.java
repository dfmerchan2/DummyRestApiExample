package co.com.restapiexample.tasks;

import co.com.restapiexample.utils.ActorNotepad;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;

import static co.com.restapiexample.utils.ServiceName.SERVICE_DELETE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class DeleteEmployee implements Task {

    private final String idEmployee;

    public DeleteEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Step("{0} delete the user identified with the id: #idEmployee")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(SERVICE_DELETE.getValue() + idEmployee)
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

    public static Performable withServiceDelete(String idEmployee) {
        return instrumented(DeleteEmployee.class, idEmployee);
    }
}
