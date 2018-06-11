package GenericLab;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverHelper extends ExtentReportsHelper {
	
private Logger log = LoggerHelper.getLogger(MouseHoverHelper.class);
	
	public MouseHoverHelper(WebDriver driver) {
		this.driver = driver;
		log.debug("MouseHoverHelper : " + this.driver.hashCode());
		
	}
	

	
	public void moveToSingleElementAndClick(WebElement locator) {
		
		 try {
			Actions builder = new Actions(driver);
			 
			 Action mouseOver= builder.moveToElement(locator).click().build();
			 mouseOver.perform();
		} catch (Exception e) {
			
			e.printStackTrace();
			log.info("WebElement Not Clickable"+locator+e);
		}      
		
	}
	
	
	public void moveToDoubleElementAndClick(WebElement firstlocator,WebElement secondlocator) throws InterruptedException {
		
		  try {
			Actions builder = new Actions(driver);
			  Action mouseOver = builder.moveToElement(firstlocator).build();
			  mouseOver.perform(); 
			  Thread.sleep(2000);
			  Action mouseOver1=  builder.moveToElement(secondlocator).click().build();
			  mouseOver1.perform();
		} catch (Exception e) {
			
			e.printStackTrace();
			log.info("WebElement Not Clickable"+e);
		} 
	}
	
	
	public void moveToTripleElementAndClick(WebElement firstlocator,WebElement secondlocator,WebElement thirdlocator) {
		
		  try {
			Actions builder = new Actions(driver);
			  Action mouseOver = builder.moveToElement(firstlocator).build();
			  mouseOver.perform(); 
			  Thread.sleep(2000);
			  Action mouseOver1=  builder.moveToElement(secondlocator).build();
			  mouseOver1.perform(); 
			  Thread.sleep(2000);
			  Action mouseOver2=  builder.moveToElement(thirdlocator).click().build();
			  mouseOver2.perform();
		} catch (Exception e) {
			
			e.printStackTrace();
			log.info("WebElement Not Clickable"+e);
		} 
	}
	
	
	
	
	public void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
		try {
			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
				Actions action = new Actions(driver);
				action.dragAndDrop(sourceElement, destinationElement).build().perform();
			} else {
				
				log.info("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			log.info("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "+ e.getStackTrace());
			
		} catch (NoSuchElementException e) {
			log.info("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace());
			
		} catch (Exception e) {
			log.info("Error occurred while performing drag and drop operation "+ e.getStackTrace());
			
		}
	}
	
	
	
	
	

}
