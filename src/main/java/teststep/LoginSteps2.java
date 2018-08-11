package teststep;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps2 {
	public ChromeDriver driver;
	
	@Given("open the Browser")
	public void opentheBrowser1() {
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@And("Maximize the window")
  public void maximizetheWindow1() {
	
		driver.manage().window().maximize();
  }
	@And("Load the URL")
	public void loadUrl1() {
		driver.get("http:/leaftaps.com/opentaps/");
	}
	
	@And("set the TimeOut")
	public void timeout1() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Given("Enter the UserName as (.*)")
	public void entertheUserName1(String Uname) {
		driver.findElementById("username").sendKeys(Uname);
	}
	@And("Enter the password as (.*)")
	public void enterthePassword1(String uPassword) {
		driver.findElement(By.id("password")).sendKeys(uPassword);
	}
	
	@When("Click on Login button")
	public void loginstep1() {
		driver.findElementByClassName("decorativeSubmit").click();
	}
	
	@Then("Verify Login Is Successful")
	public void verifyLogin() {
		System.out.println("Login is successful");
	}
	
	@But("Verify Login Is unSuccessful")
	public void verifyLoginunsuccess() {
		System.out.println("Login is unsuccessful");
	}
	
}


