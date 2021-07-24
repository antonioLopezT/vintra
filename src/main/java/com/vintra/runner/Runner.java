package com.vintra.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features", glue = {"com/vintra/steps"}, monochrome = true, plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class Runner extends AbstractTestNGCucumberTests {
}
