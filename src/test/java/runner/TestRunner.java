package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@happypath", // Cambia esta etiqueta según sea necesario
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}

