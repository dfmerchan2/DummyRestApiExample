package co.com.restapiexample.tasks;

import co.com.restapiexample.utils.ActorNotepad;
import co.com.restapiexample.utils.JsonObject;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;


import static co.com.restapiexample.utils.ServiceName.SERVICE_CREATE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CreateEmployee implements Task {

    private final String name;
    private final String age;
    private final String salary;

    public CreateEmployee(String name, String age, String salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Step("{0} create a new user called: #name")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(SERVICE_CREATE.getValue())
                        .with(
                                request ->
                                        request
                                                .contentType(ContentType.JSON)
                                                .body(JsonObject.ofCreateUser(name, age, salary))
                                                .log()
                                                .all()));
        SerenityRest.lastResponse().print();
        actor.should(seeThatResponse(response -> response.statusCode(200)));
        actor.remember(ActorNotepad.STATUS.getKey(), SerenityRest.lastResponse().jsonPath().getString("status"));
        actor.remember(ActorNotepad.MESSAGE.getKey(), SerenityRest.lastResponse().jsonPath().getString("message"));
    }

    public static Performable withServicePost(String name, String age, String salary) {
        return instrumented(CreateEmployee.class, name, age, salary);
    }
}
