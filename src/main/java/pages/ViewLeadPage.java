package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;

public class ViewLeadPage extends Annotations {

	public ViewLeadPage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="viewLead_firstName_sp")
	WebElement elefname;
	
	public ViewLeadPage verifyfirstname(String expectedText) {
		verifyExactText(elefname, expectedText);
		
		return this;
	}
}
