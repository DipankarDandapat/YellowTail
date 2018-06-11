package GenericLab;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class DriverHelper extends ExtentReportsHelper {
	
 private static Logger log = LoggerHelper.getLogger(DriverHelper.class);
	
	public DriverHelper(WebDriver driver) {
		this.driver = driver;
		log.debug("DriverHelper : " + this.driver.hashCode());
		
	}
	
	
	
	public static WebDriver openBrowser(){
		
		
		if(System.getProperty("os.name").contains("Window")){
			
				if (ConstantsHelper.browser.equals("firefox") || ConstantsHelper.browser.equals("FIREFOX")) 
				{
					System.setProperty("webdriver.gecko.driver", "External Driver File\\geckodriver.exe");
					
					driver = new FirefoxDriver();
					log.info("Firefox Browser Open");
					Dimension dimension= new Dimension(ConstantsHelper.DimensionWidth,ConstantsHelper.DimensionHeight);
					driver.manage().window().setSize(dimension);
					log.info("Window Size.."+ dimension);
					
					
				} else if (ConstantsHelper.browser.equals("chrome") || ConstantsHelper.browser.equals("CHROME")) 
				{
					System.setProperty("webdriver.chrome.driver", "External Driver File\\chromedriver.exe");
			                
					driver = new ChromeDriver();
					log.info("Chrome Browser Open");
					Dimension dimension= new Dimension(ConstantsHelper.DimensionWidth,ConstantsHelper.DimensionHeight);
					driver.manage().window().setSize(dimension);
					log.info("Window Size.."+ dimension);
				
				}
			
		}
		else if(System.getProperty("os.name").contains("Mac")){
			
				
				if (ConstantsHelper.browser.equals("firefox") || ConstantsHelper.browser.equals("FIREFOX")) 
				{
					System.setProperty("webdriver.gecko.driver", "External Driver File\\geckodriver.exe");
					
					driver = new FirefoxDriver();
					log.info("Firefox Browser Open");
					Dimension dimension= new Dimension(ConstantsHelper.DimensionWidth,ConstantsHelper.DimensionHeight);
					driver.manage().window().setSize(dimension);
					log.info("Window Size.."+ dimension);
					
				} else if (ConstantsHelper.browser.equals("chrome") || ConstantsHelper.browser.equals("CHROME")) 
				{
					System.setProperty("webdriver.chrome.driver", "External Driver File\\chromedriver.exe");
			                
					driver = new ChromeDriver();
					log.info("Chrome Browser Open");
					Dimension dimension= new Dimension(ConstantsHelper.DimensionWidth,ConstantsHelper.DimensionHeight);
					driver.manage().window().setSize(dimension);
					log.info("Window Size.."+ dimension);
				}
				else if (ConstantsHelper.browser.equals("safari") ||ConstantsHelper.browser.equals("SAFARI")) 
				{
					driver = new SafariDriver();
					log.info("Safari Browser Open");
				}
				
			
			}
			
			
			
	
		
		return null;
	}
	
	
	public static WebDriver closeBrowser() {
		
		driver.close();
		log.info("Browser close");
		return null;
	}
	
	
	

}
