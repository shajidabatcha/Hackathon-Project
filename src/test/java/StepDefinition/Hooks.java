package StepDefinition;

import java.util.Properties;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import BaseClass.baseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
public class Hooks {
	WebDriver driver;
	 Properties p;
    
	 // Before hook: Setup method to initialize the browser and open the application URL
	 
	@Before
   public void setup() throws Exception 
   {
   	driver=baseClass.initilizeBrowser();
   	    	
   	p=baseClass.getProperties();
   	driver.get(p.getProperty("appURL"));
   	driver.manage().window().maximize();
   	
   	
	}
		
	 // Before hook: Setup method to initialize the browser and open the application URL
	
   @After
   public void tearDown(Scenario scenario) {
       		
      driver.quit();
      
   }
   
   // AfterStep hook: Capture a screenshot after each step (for reporting)
   
   @AfterStep
   public void addScreenshot(Scenario scenario) {
       
   	// this is for cucumber Junit report
	   // Capture screenshot if the scenario fails
	   
       if(scenario.isFailed()) {
       	
       	TakesScreenshot ts=(TakesScreenshot) driver;
       	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
       	scenario.attach(screenshot, "image/png",scenario.getName());
       	            
       }
     
    // Capture screenshot for successful steps as well
       else {
    	   TakesScreenshot ts=(TakesScreenshot) driver;
          	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
          	scenario.attach(screenshot, "image/png",scenario.getName());
       }
   }
 
}
 