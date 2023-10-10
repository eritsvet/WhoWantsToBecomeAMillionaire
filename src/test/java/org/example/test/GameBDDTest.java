package org.example.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/example/test/features",
        glue = {"org.example.test", "org.example"},
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class GameBDDTest {
}
