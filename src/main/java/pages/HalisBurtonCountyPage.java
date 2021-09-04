package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HalisBurtonCountyPage extends TestBase{
	
	// OR: Object Repo
	
	@FindBy(xpath = "//ul[@id='nav']/li[2]/a")
	WebElement hover;
	
	@FindBy(xpath = "(//ul[@class='dropdown'])[3]/li/a")
	List<WebElement> dropdown;
	
	
	public HalisBurtonCountyPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	public String VerifyTitle() {
		
		return driver.getTitle();
		
	}
	
	
	public void VerifyDropDownFeature() throws InterruptedException {
		
		Actions action = new Actions(driver);
		action.moveToElement(hover).build().perform();
		Thread.sleep(2000);
	
	}
	
	public void DropDownItems() throws InterruptedException {
		
		VerifyDropDownFeature();
		for(WebElement m : dropdown) {
			System.out.println(m.getText());
		}
	}
	
	
}
