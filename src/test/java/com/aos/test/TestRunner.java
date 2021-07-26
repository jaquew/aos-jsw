package com.aos.test;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin ={"pretty"},
		features = "src/test/resources/features/", 
		glue = "com.aos.steps",
		monochrome = true
		)
public class TestRunner {

}
