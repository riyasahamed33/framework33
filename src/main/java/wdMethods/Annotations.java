package wdMethods;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week6.day1.ReadExcel;

public class Annotations extends SeMethods {
	public String excelFilename,testName,testDesc,category,author,moduleName;
	
	@BeforeSuite
	public void startSuite() {
		beginResult();

	}
	@BeforeClass
	public void startTest() {
		startTest(testName,testDesc);
	}
	@Parameters({"url","uname","pwd"})
	@BeforeMethod(groups= {"smoke","sanity"})
	public void login(String url, String uname, String pwd) {
		//startTestIteration(moduleName,author,category);	
		startApp("chrome", url);
		System.out.println("start app is started");
		type(locateElement("id", "username"),uname);
		type(locateElement("id","password"), pwd);
		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		WebElement eleLink = locateElement("LinkText","CRM/SFA");
		click(eleLink);

	}
	@AfterMethod(groups= {"smoke","sanity"})
	 public void closeapp() {
	 closeBrowser();
	 }
	public void stopSuite()
	{
		endResult();
	}

	@DataProvider(name="fetchData")
	public Object [][] getData() throws IOException{
		ReadExcel excel = new ReadExcel();
		return excel.readExcel(excelFilename);

	}

}
