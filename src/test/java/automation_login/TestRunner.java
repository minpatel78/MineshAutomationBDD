package automation_login;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

//  path for features files and tags and cucumber html report

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features/",
        tags ="@login1",
        format = "html:target/CucumberHTMLReports")


public class TestRunner
{

}
