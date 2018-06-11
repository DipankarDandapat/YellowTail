package GenericLab;

import java.util.LinkedList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BrowserHelper extends ExtentReportsHelper {

	
	
	private Logger log = LoggerHelper.getLogger(BrowserHelper.class);

	public BrowserHelper(WebDriver driver) {
		this.driver = driver;
		log.debug("BrowserHelper : " + this.driver.hashCode());
	}

	public void backwardBrowserButton() {
		driver.navigate().back();
		log.info("Backward Browser");
	}
	public void forwardBrowserButton() {
		driver.navigate().forward();
		log.info("Forward Browser");
	}

	public void refreshBrowser() {
		driver.navigate().refresh();
		log.info("Refresh Browser");
		
	}

	public Set<String> getWindowHandlens() {
		log.info("");
		return driver.getWindowHandles();
	}

	public void SwitchToWindow(int index) {

		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

		if (index < 0 || index > windowsId.size()){
			throw new IllegalArgumentException("Invalid Index : " + index);
		}
		driver.switchTo().window(windowsId.get(index));
		log.info(index);
	}
	

	public void switchToParentWindow() {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		driver.switchTo().window(windowsId.get(0));
		log.info("");
	}

	public void switchToParentWithChildClose() {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

		for (int i = 1; i < windowsId.size(); i++) {
			log.info(windowsId.get(i));
			driver.switchTo().window(windowsId.get(i));
			driver.close();
		}

		switchToParentWindow();
	}
	

	
	
	
	
	
	
	
	
	
}
