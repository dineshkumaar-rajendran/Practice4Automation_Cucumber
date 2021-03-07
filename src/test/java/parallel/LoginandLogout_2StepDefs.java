package parallel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import DriverFactory.ThreadLocalDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.enumer.WaitStrategy;
import qa.pages.BasePage;
import qa.reports.ExtentLogger;

public class LoginandLogout_2StepDefs {

	@Given("the user is on the yahoo search page")
	public void the_user_is_on_the_google_search_page() {
		ThreadLocalDriver.getDriver().get("https://google.com");
		ExtentLogger.pass("Lanuncing the browser and navigating the URL");
	}

	@When("the user Enters the search keyword in")
	public void the_user_enters_the_search_keyword() {
		WebElement TextBox = ThreadLocalDriver.getDriver().findElement(By.name("q"));
		BasePage.Sendkey(By.name("q"), "Selenium", WaitStrategy.Presence, "Search type box");
		// ExtentLogger.pass(" Entered the search keyword in the search");
	}

	@And("the user clicks on the Search page in")
	public void the_user_clicks_on_the_search_page() throws Exception {
		Thread.sleep(2000);
		WebElement ele = ThreadLocalDriver.getDriver()
				.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']/center/input[@name='btnK']"));
		JavascriptExecutor executor = (JavascriptExecutor) ThreadLocalDriver.getDriver();
		executor.executeScript("arguments[0].click()", ele);
		ExtentLogger.pass("Clicked on the Searched button", true);

	}

	@Then("the user validate the Signing button in")
	public void the_user_validate_the_signing_button() throws InterruptedException {
		// Thread.sleep(2000);
		WebElement Siginbtn = ThreadLocalDriver.getDriver().findElement(By.xpath("//a[text()='Sign in']"));
		boolean check = Siginbtn.isDisplayed();
		Assert.assertEquals(true, check);
		ExtentLogger.pass("Validated the Signin button");
	}

	@And("the user clicks on the Signing button in")
	public void the_user_clicks_on_the_signing_button() throws InterruptedException {
		WebElement Siginbtn = ThreadLocalDriver.getDriver().findElement(By.xpath("//a[text()='Sign in']"));
		// Siginbtn.click();
		BasePage.click(By.xpath("//a[text()='Sign in']"), WaitStrategy.Presence, "Signin Button");
		// ExtentLogger.pass("Clicked on the Signing button");
	}

	@Then("the user validates the Title of the page in")
	public void the_user_validates_the_title_of_the_page() {
		String title = "Sign i0 - Google Accounts";
		String Etitle = ThreadLocalDriver.getDriver().getTitle();
		Assert.assertEquals(Etitle, title);
		ExtentLogger.pass("Validated the Signin button");
	}

}
