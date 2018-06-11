package PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Linkedin_SignUp_PageLocators {
	
	
	@FindBy(name="firstName")
	private WebElement firstName;
	
	@FindBy(id="reg-lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='reg-email']")
	private WebElement emailId;
	
	@FindBy(xpath="//input[@id='reg-password']")
	private WebElement passWord;
	
	@FindBy(xpath="//input[@id='registration-submit']")
	public WebElement JoinNow;
	
	@FindBy(xpath="//form[@id='regForm']/div/div/p/span")
	public WebElement validationsMessage;
	
	
	
	
	public void linkedinSignup(String FirstName,String LastName,String EmailId,String Password) {
		
		firstName.clear();
		firstName.sendKeys(FirstName);
		
		lastName.clear();
		lastName.sendKeys(LastName);
		
		emailId.clear();
		emailId.sendKeys(EmailId);
		
		passWord.clear();
		passWord.sendKeys(Password);
		
	  }
	
	public String validationsMessage() {
		return validationsMessage.getText();
	}
	
	public void clickJoinNow() {
		
		JoinNow.click();
	}
	
	
	
	
	

}
