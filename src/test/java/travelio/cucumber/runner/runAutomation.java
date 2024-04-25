package travelio.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/travelio/cucumber/features",
        glue = "travelio.cucumber.stepDefinitions",
        plugin = {"html:target/HTML_Report.html"},
        tags =  "@TDD"
)
public class runAutomation {
    //Run the program here
}
