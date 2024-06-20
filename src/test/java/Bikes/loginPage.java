package Bikes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;

public class loginPage {

	WebDriver driver;
	
	public loginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//div[@class='nsm7Bb-HzV7m-LgbsSe-Bz112c']") WebElement signin;
	@FindBy(xpath="//input[@type='email']")WebElement email;
	@FindBy(xpath="(//button[@type='button'])[3]") WebElement next;
	@FindBy(xpath="//div[@class='Ekjuhf Jj6Lae']") WebElement errorMsg;
	
	
	
	
	//click on sign in button
	public void pageSignin(){
		signin.click();
	}
	
	//switch frames from home page to login window
	public void switchFrame() {
		Set<String> window = driver.getWindowHandles();
		List<String> HandleList = new ArrayList<String>(window);
		driver.switchTo().window(HandleList.get(1));
	}
	
	//click on email textbox and enter the value
	public void clickEmail() {
		email.sendKeys("ghghgghghghg@gmail.com");
	}
	
	//click on next button
	public void clickNext() {
		next.click();
			
	}
	
	//display the error message
	public void displayErrorMsg() throws IOException {
		String error = errorMsg.getText();
		System.out.println(error);
		ExcelUtility.setCellData(error, "GoogleLogin", 1, 0);
	}
	
}
