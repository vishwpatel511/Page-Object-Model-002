package tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HalisBurtonCountyPage;
import pages.facebookindexpage;

public class HalisBurtonCountyTest extends TestBase{
	
	HalisBurtonCountyPage halisburycountypage;
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUp(String browserName) {
		TestBase.intialization(browserName);
		
		driver.get("https://www.haliburtoncounty.ca/en/index.aspx");
	
		halisburycountypage = new HalisBurtonCountyPage(TestBase.driver);
		
	}
	
	
	
	@Test
	public void TitleTest() {
	
		Assert.assertTrue(halisburycountypage.VerifyTitle().contains("County of Haliburton"));
		
	}

	@Test
	public void dropDownTest() throws InterruptedException {
		
		halisburycountypage.DropDownItems();
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void DropDownItemsTest() throws InterruptedException {
		
		halisburycountypage.VerifyDropDownFeature();
		
	}
	
	@AfterMethod
	public void quit(ITestResult result) {
		
	if(result.getStatus() == ITestResult.FAILURE) {
			
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(SrcFile, new File("./Screenshots/"+result.getName()+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Something went wrong while taking the screenshot");
			}
			System.out.println("Screenshot taken");
		
			
		}
		TestBase.exit();
	}
}
