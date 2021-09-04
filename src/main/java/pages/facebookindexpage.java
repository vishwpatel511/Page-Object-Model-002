package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class facebookindexpage extends TestBase{

	@FindBy(name = "email")
	WebElement emailbox;
	
	@FindBy(name = "pass")
	WebElement passwordbox;
	
	@FindBy(name = "login")
	WebElement loginbtn;


	public facebookindexpage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	}
	
	public String titleVerify() {
		
		return "Facebook - Log In or Sign Up";
	
	}
	
	
	
	public void loginVerification(String username, String password) throws InterruptedException {
		
		this.emailbox.sendKeys(username);
		Thread.sleep(2000);
		this.passwordbox.sendKeys(password);
		this.loginbtn.click();
		
	}
	
}
