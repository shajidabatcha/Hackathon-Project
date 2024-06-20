package Bikes;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;

public class usedCars {

WebDriver driver;
Actions act;
	
	public usedCars(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
		act=new Actions(driver);
	}
	
	@FindBy(xpath="//li[@id='menuusedcars3']") WebElement usedCars;
	@FindBy(xpath="//li[@id='submenu_4usedcars']") WebElement chnCars;
	@FindBy(xpath="//span[@class='underline cursor-pointer']") WebElement readMore;
	@FindBy(xpath="//td") List<WebElement> table;
	
	//click on used cars from drop down
	public void clickUsedCars() {
		act.moveToElement(usedCars).perform();
	}
	
	//click on used cars in Chennai
	public void clickChnCars() {
		chnCars.click();
	}
	
	//click on read more button
	public void readMore() {
		readMore.click();
	}
	
	// print the popular used cars in chennai
	public void printTable() throws IOException {
		for(int i=0;i<table.size();i++) {
			//String values = table.get(i).getText();
			
			System.out.println(table.get(i).getText());
			
			ExcelUtility.setCellData(table.get(i).getText(), "UsedCars", i+1, 0);
			
		}
		
		System.out.println();
	}
}
