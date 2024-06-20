package StepDefinition;

import java.io.IOException;

import BaseClass.baseClass;
import Bikes.homePage;
import Bikes.upcomingBikes;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class upcomingBikesTest {
	
	homePage h;
	upcomingBikes ub;
	
//	@Given("click on Maybe Later")
//	public void click_on_maybe_later() {
//	    h=new homePage(baseClass.getDriver());
//	   // h.clickMaybeLater();
//	    
//	}

	@Given("Hover on Bikes DropDown")
	public void hover_on_bikes_drop_down() throws Exception{
		baseClass.getLogger().info("--------- starting the process of upcoming bikes ---------");
		h=new homePage(baseClass.getDriver());
		baseClass.getLogger().info("Hover the bike dropdown");
		h.clickBike();
	    ExcelUtility.Data();
	}

	@When("Click on Upcoming Bikes")
	public void click_on_upcoming_bikes() {
		baseClass.getLogger().info("Click on Upcoming Bikes");
	    h.clickUpcomingBike();
	}

	@When("Select Honda Bikes from Select Brand DropDown and click LoadMore")
	public void select_honda_bikes_from_select_brand_drop_down_and_click_load_more() throws Exception {
	    ub=new upcomingBikes(baseClass.getDriver());
	    baseClass.getLogger().info("Select Honda Bikes from Select Brand DropDown");
	    ub.dropdownBtn();
	    baseClass.getLogger().info("click LoadMore");
	    ub.clickLoadMore();
	}

	@Then("print the Honda Bikes price under fourLakhs")
	public void print_the_honda_bikes_price_under_four_lakhs() throws IOException {
		baseClass.getLogger().info("print the Honda Bikes price under fourLakhs");
	    ub.compareBikePrice();
	    baseClass.getLogger().info("------ Ending of upcoming bikes ------");
	}



}
