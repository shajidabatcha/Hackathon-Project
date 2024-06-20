package Bikes;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelUtility;



public class upcomingBikes {
	
	WebDriver driver;
	WebDriverWait myWait;
	
	public upcomingBikes(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
		myWait =  new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy (xpath="//div[@class='fixed w-full bottom-0 left-0 lg:left-1/2 lg:bottom-1/2 lg:-translate-x-1/2 lg:w-[360px]  bg-white lg:rounded-lg p-4 z-[999]']//span[contains(text(),'Maybe later')]") WebElement maybe_later ;
	@FindBy(xpath="//div[@class='relative']/select[@class='w-full rounded-md border p-2 defaultInput bg-white text-black outline-none  lg:min-w-full min-h-[48px] border-gray-300 px-4']")WebElement clickHonda; 
	@FindBy(xpath="//span[@id='loadmoreBtn']")WebElement loadMore;
	@FindBy(xpath="//div[@class='bg-gray-50 p-2 rounded-md']//div[@class='font-semibold text-sm']") List<WebElement> price;
	@FindBy(xpath="//div[@class='p-4 pt-2 max-w-full']//a")List<WebElement> bikeNames;
	@FindBy(xpath="//div[@class='bg-gray-50 p-2 rounded-md block']")List<WebElement> launchDate ;
	
	
	//select Honda from the drop down button
	public void dropdownBtn() throws InterruptedException{
		myWait.until(ExpectedConditions.visibilityOf(clickHonda));
		Select dropdown = new Select(clickHonda);
		dropdown.selectByVisibleText("Honda");
		Thread.sleep(1000);
	}
	
	//click on load more button
	public void clickLoadMore() throws Exception {
		myWait.until(ExpectedConditions.visibilityOf(loadMore));		
		if(loadMore.isDisplayed()) {
			Thread.sleep(3000);
			loadMore.click();
			
		}
	}
	
	//display bikes less than 4lakhs and display bike name, bike price and launch date
	public void compareBikePrice() throws IOException{
		
		String[] bikeprice = new String[price.size()];
		
		
		for(int i=0;i<price.size();i++) {
			
			String finalPrice = price.get(i).getText();
			
			if(finalPrice.contains("-")) {
				String[] temp = new String[2];
				temp = finalPrice.split(" - ");
				String l = temp[1].replaceAll("[^0-9.]","");
//				String s = l.replace("*","");
				bikeprice[i] = l;
				
				
			}
			else {
				String l = finalPrice.replaceAll("[^0-9.]","");
//				String s = l.replace("*","");
				bikeprice[i] =l;
				
			}
		}
		
		double[] doubleArray = new double[bikeprice.length];
		
		for(int i=0;i<bikeprice.length;i++) {
			doubleArray[i] = Double.parseDouble(bikeprice[i]);
		}
		
		int j=1;
		
		for(int i=0;i<bikeprice.length;i++) {
			if(doubleArray[i] < 4) {
				
				
				System.out.println("Bike Name : " + bikeNames.get(i).getText());
				System.out.println("Bike price : " + price.get(i).getText());
				System.out.println("Launch date : " + launchDate.get(i).getText());
				System.out.println(" ----------------------------------- ");
				
				
				ExcelUtility.setCellData(bikeNames.get(i).getText(),"NewBikes", j, 0);
				ExcelUtility.setCellData(price.get(i).getText(),"NewBikes", j, 1);
				ExcelUtility.setCellData(launchDate.get(i).getText(),"NewBikes", j, 2);
			
				j++;
			
			}
			
			
		}
		
		
		
		
		System.out.println();
	}
	
	
	
}
