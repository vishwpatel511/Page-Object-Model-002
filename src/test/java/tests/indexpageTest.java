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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import data.DataProviderClass;
import pages.facebookindexpage;

public class indexpageTest extends TestBase {
	
	facebookindexpage indexpage;
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUp(String browserName) {
		
		 
		TestBase.intialization(browserName);
		driver.get("https://www.facebook.com/");
		indexpage = new facebookindexpage(TestBase.driver);
		
	}
	
	@Test
	public void titleTest() {
		
		Assert.assertEquals(indexpage.titleVerify(), TestBase.driver.getTitle());
		
	}
	
	@Test(dataProviderClass = data.DataProviderClass.class, dataProvider = "datapro")
	public void loginTest(String username, String password) throws InterruptedException {
		
		indexpage.loginVerification(username, password);
		Assert.assertTrue(true);
	}
	
	@Test
	public void delibratelyFailedTest() {
		
		Assert.assertFalse(true);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
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
