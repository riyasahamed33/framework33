package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeMethods extends Reporter implements WdMethods{
	public static	RemoteWebDriver driver ;
	int i = 1;
	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();			
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckoriver.exe");
				driver = new FirefoxDriver();		
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//reportStep("The Browser "+browser+" is Launched Successfully","pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//reportStep("The Browser "+browser+" is not Launched Successfully","fail");
			throw new RuntimeException();
		}

		takeSnap();

	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case "id": 	  return driver.findElementById(locValue);
			case "class": return driver.findElementByClassName(locValue);
			case "xpath": return driver.findElementByXPath(locValue);	
			case  "LinkText": return driver.findElementByLinkText(locValue);
			case "name": return driver.findElementByName(locValue);
			case "PartialLinkText": return driver.findElementByPartialLinkText(locValue);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception has occured in LocateElement");
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}

	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			//reportStep("The Data "+data+" is Entered Successfully", "pass");
			takeSnap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//reportStep("The Data "+data+" could not Entered Successfully", "pass");
		}
	}

	public void click(WebElement ele) {
		ele.click();
		System.out.println("The Element "+ele+" is clicked Successfully");
		takeSnap();		
	}

	public void clickWithoutSnap(WebElement ele) {
		ele.click();
		System.out.println("The Element"+ ele+ "is clicked successfully");
	}

	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		String s= ele.getText();
		System.out.println("The value of get text is "+s);
		return s;

	}


	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		try {
			Select dd1= new Select(ele);
			dd1.selectByVisibleText(value);
			System.out.println("The Element "+ele+ "is selected successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception has occured");
		}
		finally{
			takeSnap();
		}
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		Select dd = new Select (ele);
		dd.selectByIndex(index);	
		System.out.println("The Element"+ele+ "is selected successfully");
	}

	public void selectDropDownUsingValue(WebElement ele, String j) {
		// TODO Auto-generated method stub
		Select dd2= new Select(ele);
		dd2.selectByValue(j);
		System.out.println("The Element"+ ele+ "is selected successfully");

	}

	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		boolean bReturn=false;
		try {
			if(driver.getTitle().equals(expectedTitle)) {
				System.out.println("The Title is matched successfully");
				bReturn=true;
			}
			else
			{
				System.out.println("The Title is not matched successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception has occured");
		}
		return bReturn;
	}


	public void verifyExactText(WebElement ele, String expectedText) {

		try {
			if(ele.getText().equals(expectedText)) {
				System.out.println("The expectedText is Matched succesfully");
			}
			else {
				System.out.println("The expectedText is not Matched successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception has occured");
		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		try {
			if(ele.getText().contains(expectedText)) {
				System.out.println("The expectedText is Matched succesfully");
			}
			else {
				System.out.println("The expectedText is not Matched successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception has occured");

		}

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		if(ele.getAttribute(attribute).equals(value)) {
			System.out.println("The expectedText is matched successfully");
		}
		else {
			System.out.println("The exepectedText is not matched succesfully");
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

		if(ele.getAttribute(attribute).contains(value)) {
			System.out.println("The expectedText is matched successfully");
		}
		else {
			System.out.println("The exepectedText is not matched succesfully");
		}

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

		try {
			if(ele.isSelected()== true) {
				System.out.println("The Element is selected successfully");
			}

			else {
				System.out.println("The Element is not selected successfully");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("NoSuchElement has occured");
		}
	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

		try {
			if(ele.isDisplayed()== true) {
				System.out.println("The Element is Displayed successfully");
			}

			else {
				System.out.println("The Element is not Displayed successfully");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("NoSuchElement exception has occured");
		}
	}

	public void keystab(){


	}
	public void switchToWindow(int index) {
		try {
			Set <String> allWindow1 = driver.getWindowHandles();
			List <String> listWindow1 = new ArrayList<String>();
			listWindow1.addAll(allWindow1);
			driver.switchTo().window(listWindow1.get(index));
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("NoSuchWindow Exception has occured");
		}
		finally{
			takeSnap();
		}
	}
	public void switchToDefaultContent() {
		// TODO Auto-generated method stub
		driver.switchTo().defaultContent();
	}


	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().frame(ele);
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			System.err.println("NoSuchFrameExecption has occured");
		}
		finally{
			takeSnap();
		}
	}


	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("NoAlertPresent exception has occured");
		}
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("NoAlertPresent exception has occured");
		}

	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().getText();
		return null;
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img"+i+".png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();

	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		driver.quit();
	}

}
