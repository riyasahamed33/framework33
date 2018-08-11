package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src//main//java//feature//login1.feature",glue = {"pages","teststep","runner"},tags="@smoke",monochrome=true)
public class RunCheck {

}
