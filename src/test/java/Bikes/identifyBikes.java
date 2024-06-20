package Bikes;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class identifyBikes {
	public static void main(String args[]) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.91wheels.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='fixed w-full bottom-0 left-0 lg:left-1/2 lg:bottom-1/2 lg:-translate-x-1/2 lg:w-[360px]  bg-white lg:rounded-lg p-4 z-[999]']//span[contains(text(),'Maybe later')]")).click();
		
		
		WebElement Bikes = driver.findElement(By.xpath("//span[@title='Bikes' and @class='leading-6 text-sm lg:text-base flex justify-start gap-x-0  font-semibold uppercase py-3 pt-4  group-hover:text-primary hover:text-primary cursor-pointer items-center text-slate-900  ']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(Bikes).perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//li[@class='group/subitem relative']//a[@title='Upcoming Bikes in India']")).click();
		
		//driver.findElement(By.xpath("//div[@class='relative']//select[@class='w-full rounded-md border p-2 defaultInput bg-white text-black outline-none  lg:min-w-full min-h-[48px] border-gray-300 px-4']")).click();
		
		//driver.findElement(By.xpath("//div[@class='relative']//select[@class='w-full rounded-md border p-2 defaultInput bg-white text-black outline-none  lg:min-w-full min-h-[48px] border-gray-300 px-4']//option[@value='honda']")).click();
		
		Select dropdown = new Select(driver.findElement(By.xpath("//div[@class='relative']/select[@class='w-full rounded-md border p-2 defaultInput bg-white text-black outline-none  lg:min-w-full min-h-[48px] border-gray-300 px-4']")));
		dropdown.selectByVisibleText("Honda");
		
		Thread.sleep(3000);
		
		WebElement loadMore = driver.findElement(By.xpath("//span[@id='loadmoreBtn']"));
			if(loadMore.isDisplayed()) {
			
				loadMore.click();
			}
	
		
		
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='bg-gray-50 p-2 rounded-md']//div[@class='font-semibold text-sm']"));

//		for(WebElement count:divElement) {
//			String value = count.getText();
//			System.out.println(value);
//		}
			
		
		
		String[] bikeprice = new String[price.size()];
		
		
		for(int i=0;i<price.size();i++) {
			
			String finalPrice = price.get(i).getText();
			
			if(finalPrice.contains("-")) {
				String[] temp = new String[2];
				temp = finalPrice.split(" - ");
				String l = temp[1].replace("Lakh","");
				String s = l.replace("*","");
				bikeprice[i] = s.replace("₹", "");
				
				
			}
			
			else {
				String l = finalPrice.replace("Lakh","");
				String s = l.replace("*","");
				bikeprice[i] = s.replace("₹", "");
				
			}
		}
		
		double[] doubleArray = new double[bikeprice.length];
		
		for(int i=0;i<bikeprice.length;i++) {
			doubleArray[i] = Double.parseDouble(bikeprice[i]);
		}
		
		
//		for (double num : doubleArray) {
//		    System.out.print(num);
//		    System.out.println();
//		}
		
		List<WebElement> bikeNames = driver.findElements(By.xpath("//div[@class='p-4 pt-2']//a"));
		List<WebElement> launchDate = driver.findElements(By.xpath("//div[@class='bg-gray-50 p-2 rounded-md block']"));
		
		for(int i=0;i<bikeprice.length;i++) {
			if(doubleArray[i] < 4) {
				
				System.out.println("Bike Name : " + bikeNames.get(i).getText());
				System.out.println("Bike price : " + price.get(i).getText());
				System.out.println("Launch date : " + launchDate.get(i).getText());
				System.out.println(" ----------------------------------- ");
				
			}
			
		}
		
		Thread.sleep(5000);
		
		System.out.println();
		
		WebElement usedCars = driver.findElement(By.xpath("//li[@id='menuusedcars3']"));
		act.moveToElement(usedCars).perform();
		
		WebElement chnCars = driver.findElement(By.xpath("//li[@id='submenu_4usedcars']"));
		chnCars.click();
		
		WebElement readMore = driver.findElement(By.xpath("//span[@class='underline cursor-pointer']"));
		readMore.click();
		
		List<WebElement> table = driver.findElements(By.xpath("//td"));
		
		for(WebElement value:table) {
			String values = value.getText();
			
			System.out.println(values);
			
		}
		
		System.out.println();
		
		WebElement login = driver.findElement(By.xpath("//div[@class='relative flex items-center justify-center cursor-pointer']"));
		login.click();
		
		WebElement Signin = driver.findElement(By.xpath("//div[@class='nsm7Bb-HzV7m-LgbsSe-Bz112c']"));
		Signin.click();
		
		Set<String> window = driver.getWindowHandles();
		List<String> HandleList = new ArrayList<String>(window);
		driver.switchTo().window(HandleList.get(1));
		
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		
		email.sendKeys("ghghgghghghg@gmail.com");
		
		WebElement next = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
		next.click();
		
		Thread.sleep(3000);
		
		
		
		String errorMsg = driver.findElement(By.xpath("//div[@class='Ekjuhf Jj6Lae']")).getText();
		System.out.println(errorMsg);
		
		
		
		
		
		driver.quit();
	}
}
