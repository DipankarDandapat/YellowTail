package TracksPageScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import CommonRepositoryLab.OpenUrl;
import GenericLab.CookiesHelper;
import GenericLab.DriverHelper;
import GenericLab.ExcelHelper;
import GenericLab.ExtentReportsHelper;
import PageLocators.Linkedin_SignUp_PageLocators;


public class Linkedin_SignUp_PageScripts extends ExtentReportsHelper{
	
	
	
	Linkedin_SignUp_PageLocators SignUpPage;
	OpenUrl openUrl;
	ExcelHelper excel;
	CookiesHelper cookieshelper;
	
	
	@BeforeClass
	public void Setup()
	{
		DriverHelper.openBrowser();
		Assert.assertTrue(true);
		
		SignUpPage = PageFactory.initElements(driver, Linkedin_SignUp_PageLocators.class);
		
		excel = PageFactory.initElements(driver, ExcelHelper.class);
		cookieshelper=PageFactory.initElements(driver, CookiesHelper.class);
		openUrl=PageFactory.initElements(driver, OpenUrl.class);
	
		parentlogger= extentReport.createTest("Linkedin SignUp Page Verify");
		
	}
	
	
	@Test(priority=1)
    public void firstTestCase() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		String ErrorMessage=excel.getExcelData("Testing", 1,3);
		
		
		childlogger=parentlogger.createNode("Open Url, Click on Join Now Button and Verify Validations Message in First Input box");
		SoftAssert softAssert= new SoftAssert();
		
		 openUrl.getUrl();
		 
		 
		 SignUpPage.clickJoinNow();
		 
		 Thread.sleep(2000); 
		 softAssert.assertEquals(SignUpPage.validationsMessage(), ErrorMessage);
		
	
        childlogger.log(Status.INFO, "Verify Error Message ==>Please enter your first name.");
        softAssert.assertAll();
    }

    @Test(priority=2)
    public void secondTestCase() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
    	String ErrorMessage=excel.getExcelData("Testing", 2,3);
    	String FirstName=excel.getExcelData("Testing", 2,4);
    	String LastName=excel.getExcelData("Testing", 2,5);
    	String EmailId=excel.getExcelData("Testing", 2,6);
    	String Password=excel.getExcelData("Testing", 2,7);
    	

		childlogger=parentlogger.createNode("Open Url, Enter First Name,Click on Join Now Button and Verify Validations Message in Second Input box");
		SoftAssert softAssert= new SoftAssert();
		openUrl.getUrl();
		
		SignUpPage.linkedinSignup(FirstName, LastName, EmailId, Password);
		
		SignUpPage.clickJoinNow();
		
		Thread.sleep(2000); 
		softAssert.assertEquals(SignUpPage.validationsMessage(), ErrorMessage);
		
		childlogger.log(Status.INFO, "Verify Error Message ==>Please enter your last name.");
        softAssert.assertAll();
		
		
    }
    
    @Test(priority=3)
    public void thirdTestCase() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException  {
    	String ErrorMessage=excel.getExcelData("Testing", 3,3);
    	String FirstName=excel.getExcelData("Testing", 3,4);
    	String LastName=excel.getExcelData("Testing", 3,5);
    	String EmailId=excel.getExcelData("Testing", 3,6);
    	String Password=excel.getExcelData("Testing", 3,7);
    	

		childlogger=parentlogger.createNode("Open Url, Enter First Name,Enter Last Name,Click on Join Now Button and Verify Validations Message in Third Input box");
		SoftAssert softAssert= new SoftAssert();
		openUrl.getUrl();
		
		SignUpPage.linkedinSignup(FirstName, LastName, EmailId, Password);
		
		SignUpPage.clickJoinNow();
		
		Thread.sleep(2000); 
		softAssert.assertEquals(SignUpPage.validationsMessage(), ErrorMessage);
		
		childlogger.log(Status.INFO, "Verify Error Message ==>Please enter your email address.");
        softAssert.assertAll();
    }
    
    @Test(priority=4)
    public void fourthTestCase() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException  {
        
    	String ErrorMessage=excel.getExcelData("Testing", 4,3);
    	String FirstName=excel.getExcelData("Testing", 4,4);
    	String LastName=excel.getExcelData("Testing", 4,5);
    	String EmailId=excel.getExcelData("Testing", 4,6);
    	String Password=excel.getExcelData("Testing", 4,7);
    	

		childlogger=parentlogger.createNode("Open Url, Enter First Name,Enter Last Name,Enter Valid Email Id, Click on Join Now Button and Verify Validations Message in Fourth Input box");
		SoftAssert softAssert= new SoftAssert();
		openUrl.getUrl();
		
		SignUpPage.linkedinSignup(FirstName, LastName, EmailId, Password);
		
		SignUpPage.clickJoinNow();
		
		Thread.sleep(2000); 
		softAssert.assertEquals(SignUpPage.validationsMessage(), ErrorMessage);
		
		childlogger.log(Status.INFO, "Verify Error Message ==>Please enter your password.");
        softAssert.assertAll();
    }
    
    @Test(priority=5)
    public void fifthTestCase() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException  {
        
    	String ErrorMessage=excel.getExcelData("Testing", 5,3);
    	String FirstName=excel.getExcelData("Testing", 5,4);
    	String LastName=excel.getExcelData("Testing", 5,5);
    	String EmailId=excel.getExcelData("Testing", 5,6);
    	String Password=excel.getExcelData("Testing", 5,7);
    	

		childlogger=parentlogger.createNode("Open Url, Enter First Name,Enter Last Name,Enter InValid Email Id,Enter Valid Password, Click on Join Now Button and Verify Validations Message in Fourth Input box");
		SoftAssert softAssert= new SoftAssert();
		openUrl.getUrl();
		
		SignUpPage.linkedinSignup(FirstName, LastName, EmailId, Password);
		
		SignUpPage.clickJoinNow();
		
		Thread.sleep(2000); 
		softAssert.assertEquals(SignUpPage.validationsMessage(), ErrorMessage);
		
		childlogger.log(Status.INFO, "Verify Error Message ==>Please enter a valid email address.");
        softAssert.assertAll();
    }
	
	
	
	
    @AfterClass
	public void Teardown()
	{
    	cookieshelper.getCookiesFromBrowser();
    	DriverHelper.closeBrowser();
		
	}
	
	
	
	
	
	

}
