package runner;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import wdMethods.SeMethods;


public class Hooks extends SeMethods {
    
	@Before
	public void before(Scenario sc) {
		beginResult();
		startApp("chrome","http://leaftaps.com/opentaps");
		startTest(sc.getName(),sc.getId());
		test = startTestIteration(sc.getName());
		test.assignCategory("smoke");
		test.assignAuthor("riyaz");
		
	}
	
	@After
	public void after(Scenario sc) {
//		System.out.println(sc.getStatus());
//		System.out.println(sc.isFailed());
		closeAllBrowsers();
		endResult();
	}
}

