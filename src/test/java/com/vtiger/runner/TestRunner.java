package com.vtiger.runner;


import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = {"com/vtiger/stepDefinitions"},
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        monochrome = false,
        tags = "@GetAPI"
)

public class TestRunner  {


}
