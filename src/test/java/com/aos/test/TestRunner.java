package com.aos.test;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/Cadastro.feature", 
		glue = "com.aos.steps",
//		tags = "@Login3",
		monochrome = true
		)
public class TestRunner {

}
