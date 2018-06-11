package GenericLab;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper extends ExtentReportsHelper{
	
	private static final Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		log.debug("WaitHelper : " + this.driver.hashCode());
	}
	
	public void waitForPageLoad(long timeout, TimeUnit unit) {
		
		log.info(timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
		
	}
	
	public void waitForPageLoadTimeout(long timeout, TimeUnit unit) {
		log.info(timeout);
		driver.manage().timeouts().pageLoadTimeout(timeout, unit == null ? TimeUnit.SECONDS : unit);
		
	}
	
	private WebDriverWait getWait(int timeOutInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		return wait;
	}
	
	public void waitForElementVisible(WebElement locator, int timeOutInSeconds) {
		log.info(locator);
		WebDriverWait wait = getWait(timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	
	public void waitForElementClickable(WebElement locator,int timeOutInSeconds){
		log.info(locator);
		WebDriverWait wait = getWait(timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	

}
