package step.defination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoBlazeHomePage;
import pages.DemoBlazeLoginPage;
import utilities.BrowserUtil;
import utilities.Constants;

public class Steps {
	RemoteWebDriver driver;
	
	@Given("User opened the browser")
	public void user_opened_the_browser() {
	   driver=BrowserUtil.getDriver();
	}

	@When("User navigated to the Google search page")
	public void user_navigated_to_the_google_search_page() {
	   driver.get("https://www.google.com");
	}

	@When("User enter search keyword")
	public void user_enter_search_keyword() {
	   driver.findElement(By.name("q")).sendKeys("Selenium Dev");
	}
	
	@When("User enter search word {string}")
	public void user_enter_search_word(String inputKeyword) {
		 driver.findElement(By.name("q")).sendKeys(inputKeyword);
	}

	@When("Clicks on Search button")
	public void clicks_on_search_button() throws InterruptedException {
	   Thread.sleep(5000);
	   driver.findElement(By.className("gNO89b")).click();
	}

	@Then("Search results are displayed on Google search page")
	public void search_results_are_displayed_on_google_search_page() {
	   String title=driver.getTitle();
	   //Verification steps
	}
	
	
	
	
	
	@Given("user opened the browser")
	public void openBrowser() {
	   driver=BrowserUtil.getDriver();
	}

	@When("user navigated to DemoBlaze Application URL")
	public void user_navigated_to_demo_blaze_application_url() {
	    driver.get("https://www.demoblaze.com/index.html");
	}

	@When("clicks on Login link")
	public void clicks_on_login_link() {
		 DemoBlazeHomePage homePage=new DemoBlazeHomePage(driver);
		  homePage.clickOnLoginLink();
	}

	@When("user enters user name {string} and password as {string}")
	public void user_enters_user_name_and_password_as(String userName, String password) {
		 DemoBlazeLoginPage loginPage=new DemoBlazeLoginPage(driver);
		 loginPage.setUserName(userName);
		 loginPage.setPassword(password);
	}

	@When("click on Login button")
	public void click_on_login_button() {
		 DemoBlazeLoginPage loginPage=new DemoBlazeLoginPage(driver);
		 loginPage.clickLoginButton();
	}

	@Then("the home page is displayed")
	public void the_home_page_is_displayed() {
		 DemoBlazeHomePage homePage=new DemoBlazeHomePage(driver);
		 boolean flag=homePage.isLogoutLinkDisplayed();
		 Assert.assertEquals(flag, true);
	}

	@Then("error popup is displayed")
	public void error_popup_is_displayed() throws InterruptedException {
		DemoBlazeLoginPage loginPage=new DemoBlazeLoginPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.Web_Driver_Wait_Time));
		wait.until(ExpectedConditions.alertIsPresent());
		boolean flag=loginPage.isAlertPresent();
		Assert.assertEquals(flag, true);
	}
	
	@And("User closes the browser")
	public void closeBrowser() {
		driver.close();
	}

}
