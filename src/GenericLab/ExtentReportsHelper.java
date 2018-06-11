package GenericLab;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReportsHelper {
	
	public static WebDriver driver;
	
	
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extentReport;
	
	public static ExtentTest parentlogger;
	public static ExtentTest childlogger;
	
	public static String Seperator=System.getProperty("file.separator");
	
	@BeforeSuite
	public static void setUp() {
		
		
		htmlreporter= new ExtentHtmlReporter("ExtentReports"+ Seperator +"Build"+"-"+timestamp()+Seperator+"ProjectReport.html");
		extentReport=new ExtentReports();
		extentReport.attachReporter(htmlreporter);
		
		extentReport.setSystemInfo("OS", "Windows 10");
		extentReport.setSystemInfo("Host Name", "Dipankar");
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("User Name", "Dipankar Dandapat");
		
		htmlreporter.config().setDocumentTitle("Automation Testing Report Template");

		// report or build name
		htmlreporter.config().setReportName("Build-001");
		
		// chart location - top, bottom
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		
		// theme - standard, dark
		htmlreporter.config().setTheme(Theme.STANDARD);
		
		
	}
	
	
	
	
   @AfterMethod	
    public void takeScreenshort(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			 
			 String Screenshort=ScreenshortHelper.captureScreenshot(driver,result.getName());
			 ExtentTest image=childlogger.addScreenCaptureFromPath(Screenshort);
			 childlogger.log(Status.PASS, "The Test Method Name as "+result.getName()+"Is Pass");
			 childlogger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"test case Pass", ExtentColor.GREEN));
		 
		}else if(result.getStatus()==ITestResult.FAILURE) {
			
			 String screenshort=ScreenshortHelper.captureScreenshot(driver,result.getName());
			 ExtentTest image=childlogger.addScreenCaptureFromPath(screenshort);
			childlogger.log(Status.FAIL, "The Test Method Name as "+result.getName()+"Is Fail");
			childlogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"test case fail due to below issue", ExtentColor.RED));
			 //logger.fail(result.getThrowable());
			childlogger.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
			
		}else if(result.getStatus() == ITestResult.SKIP){
			  
			 String screenshort=ScreenshortHelper.captureScreenshot(driver,result.getName());
			 ExtentTest image=childlogger.addScreenCaptureFromPath(screenshort);
			  childlogger.log(Status.SKIP, "The Test Method Name as "+result.getName()+"Is Skip");
			  childlogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"test case skip due to below issue", ExtentColor.PURPLE));
			 //logger.fail(result.getThrowable());
			  childlogger.log(Status.SKIP, "Test Case skip is "+result.getThrowable());
			  
		   }
		
		
		
		
	}
   
   @AfterTest
   public void tearDown() {
	   extentReport.flush();
		
   }
	
   
	public static String timestamp() {

      return new SimpleDateFormat("dd MMMM yyyy").format(new Date());
      
      }
   
	
	

}
