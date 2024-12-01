package com.api.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources"
        ,glue={"src/test/com/api/steps/"}
        ,monochrome = false
)

public class TestRunner {
}
