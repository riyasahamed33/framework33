package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;

public class MyLeadsPage extends Annotations {

	public MyLeadsPage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[text()='Create Lead']")
	WebElement eleCLeads;
		
	public CreateLeadPage clickMyLead() {
		click(eleCLeads);
		return new CreateLeadPage();
	}
}
