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
import qa.reports.ExtentLogger;

public class LoginandLogout_2StepDefs {

	@Given("the user is on the yahoo search page")
	public void the_user_is_on_the_google_search_page() {
		ExtentLogger.logInfo("Lanuncing the browser and navigating the URL");
		ThreadLocalDriver.getDriver().get("https://google.com");
	}

	@When("the user Enters the search keyword in")
	public void the_user_enters_the_search_keyword() {
		WebElement TextBox = ThreadLocalDriver.getDriver().findElement(By.name("q"));
		TextBox.sendKeys("Selenium");
		ExtentLogger.logInfo(" Entered the search keyword in the search");
	}

	@And("the user clicks on the Search page in")
	public void the_user_clicks_on_the_search_page() throws Exception {
		Thread.sleep(5000);
		WebElement ele = ThreadLocalDriver.getDriver().findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']/center/input[@name='btnK']"));
		JavascriptExecutor executor = (JavascriptExecutor)ThreadLocalDriver.getDriver();
		executor.executeScript("arguments[0].click()",ele);
		ExtentLogger.logInfo("Clicked on the Searched button");

	}

	@Then("the user validate the Signing button in")
	public void the_user_validate_the_signing_button() throws InterruptedException {
		Thread.sleep(3000);
		WebElement Siginbtn = ThreadLocalDriver.getDriver().findElement(By.xpath("//a[text()='Sign in']"));
		System.out.println(Siginbtn.isDisplayed());
		ExtentLogger.logInfo("Validated the Signin button");
	}

	@And("the user clicks on the Signing button in")
	public void the_user_clicks_on_the_signing_button() throws InterruptedException {
		WebElement Siginbtn = ThreadLocalDriver.getDriver().findElement(By.xpath("//a[text()='Sign in']"));
		Thread.sleep(3000);
		Siginbtn.click();
		ExtentLogger.logInfo("Clicked on the Signing button");
	}

	@Then("the user validates the Title of the page in")
	public void the_user_validates_the_title_of_the_page() {
		String title = "Sign i0 - Google Accounts";
		String Etitle =ThreadLocalDriver.getDriver().getTitle();
		Assert.assertEquals(Etitle, title);
		ExtentLogger.logInfo("Validated the Signin button");
	}

}
