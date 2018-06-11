package GenericLab;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class DisplayHelper extends ExtentReportsHelper {
	
	private static final Logger log = LoggerHelper.getLogger(DisplayHelper.class);
	
	public DisplayHelper(WebDriver driver) {
		this.driver = driver;
		log.debug("DisplayHelper : " + this.driver.hashCode());
	}
	
	
	public String readValueFromElement(WebElement element) {

		if (null == element){
			log.info("WebElement is null..");
			return null;
		}

		boolean displayed = false;
		try {
			displayed = isDisplayed(element);
		} catch (Exception ex) {
			log.error("WebElement Not Found.."+ex);
			Reporter.log(ex.fillInStackTrace().toString());
			return null;
		}

		if (!displayed){
			return null;
		}
		String text = element.getText();
		log.info("WebElement Text Valus Is.."+text);
		return text;
	}
	

	public String readValueFromInput(WebElement element) {
		if (null == element){
			return null;
		}
		if (!isDisplayed(element)){
			return null;
		}
		String value = element.getAttribute("value");
		log.info("WebElement Attribute Valus Is.."+value);
		return value;
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("WebElement Is Displayed.."+element);
			return true;
		} catch (Exception ex) {
			log.info("WebElement Not Found.."+ex);
			Reporter.log(ex.fillInStackTrace().toString());
			return false;
		}
	}
	
	protected boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("WebElement Is Displayed.."+element);
			return false;
		} catch (Exception ex) {
			log.error("WebElement Not Found.."+ex);
			Reporter.log(ex.fillInStackTrace().toString());
			return true;
		}
	}
	
	protected String getDisplayText(WebElement element) {
		if (null == element){
			return null;
		}
		if (!isDisplayed(element)){
			return null;
		}
		return element.getText();
	}
	

	public static synchronized String getElementText( WebElement element) {
		if (null == element) {
			log.info("WebElement Is Null.."+element);
			return null;
		}
		String elementText = null;
		try {
			elementText = element.getText();
		} catch (Exception ex) {
			log.info("WebElement Not Found.." + ex);
			Reporter.log(ex.fillInStackTrace().toString());
		}
		return elementText;
	}

}
