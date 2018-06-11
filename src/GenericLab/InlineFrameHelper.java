package GenericLab;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InlineFrameHelper extends ExtentReportsHelper {
	
private Logger log = LoggerHelper.getLogger(AlertHelper.class);
	
	public InlineFrameHelper(WebDriver driver) {
		this.driver = driver;
		log.debug("InlineFrameHelper : " + this.driver.hashCode());
	}
	
	
	public void switchToFrameId(int frame) {
		try {
			driver.switchTo().frame(frame);
			log.info("Navigated to frame with id " + frame);
		} catch (NoSuchFrameException e) {
			log.info("Unable to locate frame with id " + frame+ e.getStackTrace());
		} catch (Exception e) {
			log.info("Unable to navigate to frame with id " + frame+ e.getStackTrace());
		}
	}
	
	
	public void switchToFrameName(String frame) {
		try {
			driver.switchTo().frame(frame);
			
			log.info("Navigated to frame with name " + frame);
		} catch (NoSuchFrameException e) {
			log.info("Unable to locate frame with id " + frame+ e.getStackTrace());
			
		} catch (Exception e) {
			log.info("Unable to navigate to frame with id " + frame+ e.getStackTrace());
			
		}
	}
	
	
	
	public void switchToFrameWebElement(WebElement frameElement) {
		try {
			if (isElementPresent(frameElement)) {
				driver.switchTo().frame(frameElement);
				
				log.info("Navigated to frame with element "+ frameElement);
			} else {
				log.info("Unable to navigate to frame with element "+ frameElement);
				
			}
		} catch (NoSuchFrameException e) {
			log.info("Unable to locate frame with element " + frameElement + e.getStackTrace());
			
		} catch (StaleElementReferenceException e) {
			log.info("Element with " + frameElement + "is not attached to the page document" + e.getStackTrace());
			
		} catch (Exception e) {
			log.info("Unable to navigate to frame with element " + frameElement + e.getStackTrace());
			
		}
	}
	
	
	
	
	
	private boolean isElementPresent(WebElement frameElement) {
	    try {
	      driver.findElement((By) frameElement);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	
	
	public void switchToMultipleFrame(String ParentFrame, String ChildFrame) {
		try {
			driver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
			log.info("Navigated to innerframe with id " + ChildFrame+ "which is present on frame with id" + ParentFrame);
			
		} catch (NoSuchFrameException e) {
			log.info("Unable to locate frame with id " + ParentFrame+ " or " + ChildFrame + e.getStackTrace());
			
		} catch (Exception e) {
			log.info("Unable to navigate to innerframe with id "+ ChildFrame + "which is present on frame with id"+ ParentFrame + e.getStackTrace());
			
		}
	}
	
	
	public void switchtoDefaultFrame() {
		try {
			driver.switchTo().defaultContent();
			log.info("Navigated back to webpage from frame");
		} catch (Exception e) {
			
			log.info("unable to navigate back to main webpage from frame"+ e.getStackTrace());
		}
	}
	
	

}
