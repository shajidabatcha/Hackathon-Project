package StepDefinition;

import java.io.IOException;

import BaseClass.baseClass;
import Bikes.usedCars;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class usedCarsTest {
	
	usedCars uc;

	@Given("Hover on usedCars DropDown")
	public void hover_on_used_cars_drop_down() throws IOException {
		baseClass.getLogger().info("--------- starting the process of used cars---------");
	    uc= new usedCars(baseClass.getDriver());
	    baseClass.getLogger().info("Hover on usedCars DropDown");
	    uc.clickUsedCars();
	    
	}

	@When("Click usedCars in CHENNAI")
	public void click_used_cars_in_chennai() {
		baseClass.getLogger().info("Click usedCars in CHENNAI");
		uc.clickChnCars();
	    
	}

	@When("Click Read more Button")
	public void click_read_more_button() {
		baseClass.getLogger().info("Click Read more Button");
	    uc.readMore();
	}

	@Then("Print the information of Popular used cars")
	public void print_the_information_of_popular_used_cars() throws IOException {
		baseClass.getLogger().info("Print the information of Popular used cars");
	    uc.printTable();
	    baseClass.getLogger().info("------ ending of used cars ------");
	}

}
