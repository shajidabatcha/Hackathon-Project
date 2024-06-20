package StepDefinition;

import java.io.IOException;

import BaseClass.baseClass;
import Bikes.homePage;
import Bikes.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class invalidLoginTest {
	
	loginPage lp;
	homePage hpp;

	@Given("Click the userLogin button")
	public void click_the_user_login_button() throws InterruptedException {
		baseClass.getLogger().info("--------- starting the process of invalid login page ---------");
	    lp=new loginPage(baseClass.getDriver());
	    hpp = new homePage(baseClass.getDriver());
	    Thread.sleep(3000);
	    baseClass.getLogger().info("Click the userLogin button");
	    hpp.pageLogin();
	}

	@When("click on signIn button")
	public void click_on_sign_in_button() throws Exception {
		baseClass.getLogger().info("click on signIn button");
	  lp.pageSignin();
	}

	@When("Enter the Email credentials")
	public void enter_the_email_credentials() {
		baseClass.getLogger().info("switching frames");
	    lp.switchFrame();
	    baseClass.getLogger().info("Enter the Email credentials");
	    lp.clickEmail();
	    baseClass.getLogger().info("Click next Button");
	    lp.clickNext();
	}

	@Then("Print the error message")
	public void print_the_error_message() throws IOException {
		baseClass.getLogger().info("Print the error message");
	    lp.displayErrorMsg();
	    baseClass.getLogger().info("ending of invalid login page");
	    
	}

}
