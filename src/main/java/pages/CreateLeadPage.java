package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;

public class CreateLeadPage extends Annotations {

	public CreateLeadPage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="createLeadForm_companyName")
	WebElement eleCompanyName;
	@FindBy(id="createLeadForm_firstName")
	WebElement elefname;
	@FindBy(id="createLeadForm_lastName")
	WebElement elelname;	
	@FindBy(name="submitButton")
	WebElement elesubmit;
	
	public CreateLeadPage typeCompanyName(String cName) {
		type(eleCompanyName,cName);
		return this;
		
			}
	public CreateLeadPage typeFirstName(String fName) {
		type(elefname,fName);
		return this;
		
			}
	
	public CreateLeadPage typeLastName(String lName) {
		type(elelname,lName);
		return this;
		
			}
	public ViewLeadPage clickSubmit() {
		click(elesubmit);
		return new ViewLeadPage();
		
			}
	
}
