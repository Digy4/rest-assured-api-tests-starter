package com.digy4.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//
// Copyright (c) 2021 Digy4 Inc. and its affiliates. All rights reserved.
// Unauthorized copying of this file, via any medium is strictly prohibited
// Proprietary and confidential
// Any illegal or unauthorised usage or violations will result in immediate legal action.
//
@CucumberOptions(
		monochrome = true,
		features = {"src/test/resources/features"},
		glue = {"com.digy4.cucumber.steps","com.digy4.java.cucumber"},
		plugin = {"pretty","json:target/cucumber/report.json", "html:target/cucumber/report.html",
				  "com.digy4.java.cucumber.Digy4CucumberSupport"}
		)
public class DigyTestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}

