package GenericLab;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class ListenerHelper  extends TestListenerAdapter{
	
private Logger log = LoggerHelper.getLogger(ListenerHelper.class);
	
	
	
	
	 public void onTestFailure(ITestResult tr){
		  
		   File scrFile = ((TakesScreenshot)ExtentReportsHelper.driver).getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(scrFile, new File("Screenshort File\\Failures\\"+ tr.getName()+".png"));
			    } 
			catch (IOException e) 
			{
				log.info("Exception Screenshot" + tr+ e.getStackTrace());
			}
			
	         }
	 
	 
	 
	 public void onTestSuccess(ITestResult tr){
		   
		 File scrFile = ((TakesScreenshot)ExtentReportsHelper.driver).getScreenshotAs(OutputType.FILE);
					
		try {
				FileUtils.copyFile(scrFile, new File("Screenshort File\\Success\\"+ tr.getName()+".png"));
			} 
		catch (IOException e) 
		    {
			 
			 log.info("Exception Screenshot" + tr+ e.getStackTrace());
			}
			
			}
	 
	 public void onTestSkipped(ITestResult tr){
			
			File scrFile = ((TakesScreenshot)ExtentReportsHelper.driver).getScreenshotAs(OutputType.FILE);
					
			try {
				FileUtils.copyFile(scrFile, new File("Screenshort File\\Skipped\\"+ tr.getName()+".png"));
				} 
			catch (IOException e)
			{
			  
			  log.info("Exception Screenshot" + tr+ e.getStackTrace());
			}
				
			}
	
	
	
	
	
	
	

}
