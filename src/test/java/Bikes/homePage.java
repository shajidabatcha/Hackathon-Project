package Bikes;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class homePage{
	
	WebDriver driver;
	//constructor
	public homePage(WebDriver driver){
		this.driver = driver; // assigning driver to local driver
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy (xpath="//div[@class='fixed w-full bottom-0 left-0 lg:left-1/2 lg:bottom-1/2 lg:-translate-x-1/2 lg:w-[360px]  bg-white lg:rounded-lg p-4 z-[999]']//span[contains(text(),'Maybe later')]") WebElement maybe_later ;
	@FindBy (xpath="//span[@title='Bikes' and @class='leading-6 text-sm lg:text-base flex justify-start gap-x-0  font-semibold uppercase py-3 pt-4  group-hover:text-primary hover:text-primary cursor-pointer items-center text-slate-900  ']") WebElement dropdown_bike ;
	@FindBy (xpath="//li[@class='group/subitem relative']//a[@title='Upcoming Bikes in India']")WebElement upcoming_bike;
	@FindBy(xpath="//div[@class='nsm7Bb-HzV7m-LgbsSe-Bz112c']") WebElement signin;
	@FindBy(xpath="//div[@class='relative flex items-center justify-center cursor-pointer']")WebElement login;
	
	//actions
	
//	public void clickMaybeLater() {
//		maybe_later.click();
//	}
	
	
	//click bike option form drop down
	public void clickBike() {
		
		Actions act = new Actions(driver);
		
		act.moveToElement(dropdown_bike).perform();
	
	}
	
	//click upcoming bikes from drop down
	public void clickUpcomingBike() {
		upcoming_bike.click();
	}
	
	//click on login button
	public void pageLogin() {
		login.click();
	}
	
	
	
}
