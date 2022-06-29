package co.com.restapiexample.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Employee.feature",
        glue = "co.com.restapiexample.stepdefinitions",
        plugin = {"rerun:target/rerunFailed/EmployeeRerun.txt", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class EmployeeRunner {
}
