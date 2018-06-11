package GenericLab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;



public class CookiesHelper extends ExtentReportsHelper {
	public static String Seperator=System.getProperty("file.separator");
	
	private Logger log = LoggerHelper.getLogger(CookiesHelper.class);
	
	public CookiesHelper(WebDriver driver) {
		this.driver = driver;
		log.debug("CookiesHelper : " + this.driver.hashCode());
	}
	
	
	public void getCookiesFromBrowser() {
		
		File file = new File("Cookies File"+Seperator+"Cookies-"+timestamp()+".html");
		log.info("Create Cookie File");
		
		try { 
		file.delete();
		
		file.createNewFile();
		
		FileWriter fileWriter = new FileWriter(file);
		
		BufferedWriter bufferwrite = new BufferedWriter(fileWriter);
		
		for(Cookie cook : driver.manage().getCookies()){
		
		String writeup = "Cookie Name ---"+cook.getName()+";"+"Cookie Value ---"+cook.getValue()+";"+"Cookie Domain ---"+cook.getDomain()+";"+"Cookie Path ---"+cook.getPath()+""+ ";"+"Cookie Expiry ---"+cook.getExpiry()+";"+"Cookie Secure ---"+cook.isSecure();
		
		bufferwrite.write(writeup);
		bufferwrite.newLine();
		log.info("Cookie Name"+writeup);
		
		}
		
		bufferwrite.flush();bufferwrite.close();fileWriter.close();
		
		
		}catch(Exception exp){
		
		exp.printStackTrace();
		
		}
	
	}

	


      public void addCookieToBrowser(String name, String value, String domain, String path, Date expiry){    
             driver.manage().addCookie( new Cookie(name, value, domain, path, expiry));
               }

	
      
     /* public void addSetOfCookiesToBrowser(Set<Cookie> cookies, String domain) { 
    	  for (Cookie c : cookies) {

          if (c != null) {

          if (c.getDomain().contains(domain)){

           driver.manage().addCookie(

         new Cookie(name, value,domain, path, expiry));

           } }   }

          driver.navigate().refresh();
          }
	*/
	
	
      
      public void deleteCookieNamed(String name){
         log.info("Delete Cookie"+name);
          driver.manage().deleteCookieNamed(name);
          }
	
      public void deleteAllCookies() {
          
          driver.manage().deleteAllCookies();
          }
      
      
      
      
      
      public static String timestamp() {

          return new SimpleDateFormat("dd MMMM yyyy").format(new Date());
          
      }
       
      
}
	
	
	
