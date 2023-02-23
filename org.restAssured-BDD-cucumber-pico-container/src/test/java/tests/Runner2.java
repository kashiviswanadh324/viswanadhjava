package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class Runner2 {
	//For smoke testing(run @smoke test tagged scenarios only to check basic functionality)
		@CucumberOptions(features={"src\\test\\resources\\features"},
		                 glue={"gluecode"},
		                 monochrome=true,
		       plugin={"pretty","html:target\\realtestres.html",
		    		   "rerun:target\\failedrealtests.txt"})
		public class runner1 extends AbstractTestNGCucumberTests
		{
		}
}
