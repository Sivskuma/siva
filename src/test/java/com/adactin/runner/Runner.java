package com.adactin.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.adactin.bassclass.cucumberproject.BassClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\adactin\\feature", 
glue = "com\\adactin\\stepdefinition", 
plugin = "html:report"
//dryRun = true,
//strict = true,
//monochrome = true
)

public class Runner {

	public static WebDriver driver;

	@BeforeClass
	public static void Setup() {

		driver = BassClass.getdriver("chrome");

	}

}
