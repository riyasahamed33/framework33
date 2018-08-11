package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.MyHomePage;
import wdMethods.Annotations;

public class TC001_Leads extends Annotations {

	@BeforeTest
	public void setValues() {
		excelFilename="CreateLead";
		testName="Create Lead";
		testDesc=" Create a new lead";
		category= "smoke";
		author="riyaz";
		moduleName="Leads";
		
	}
	@Test(dataProvider="fetchData")
	public void createLead( String cName, String fName, String lName) {
		
		new MyHomePage()
		.clickLeads()
		.clickMyLead()
		.typeCompanyName(cName)
		.typeFirstName(fName)
		.typeLastName(lName)
		.clickSubmit()
		.verifyfirstname(fName);
			
		
	}
}
