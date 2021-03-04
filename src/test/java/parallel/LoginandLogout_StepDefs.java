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

public class LoginandLogout_StepDefs {

	@Given("the user is on the google search page")
	public void the_user_is_on_the_google_search_page() {
		ThreadLocalDriver.getDriver().get("https://google.com");
	}

	@When("the user Enters the search keyword")
	public void the_user_enters_the_search_keyword() {
		WebElement TextBox = ThreadLocalDriver.getDriver().findElement(By.name("q"));
		TextBox.sendKeys("Core Java");
	}

	@And("the user clicks on the Search page")
	public void the_user_clicks_on_the_search_page() throws InterruptedException {
		Thread.sleep(5000);
		WebElement ele = ThreadLocalDriver.getDriver().findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']/center/input[@name='btnK']"));
		JavascriptExecutor executor = (JavascriptExecutor)ThreadLocalDriver.getDriver();
		executor.executeScript("arguments[0].click()",ele);
	}

	@Then("the user validate the Signing button")
	public void the_user_validate_the_signing_button() throws InterruptedException {
		Thread.sleep(3000);
		WebElement Siginbtn = ThreadLocalDriver.getDriver().findElement(By.xpath("//a[text()='Sign in']"));
		System.out.println(Siginbtn.isDisplayed());
	}

	@And("the user clicks on the Signing button")
	public void the_user_clicks_on_the_signing_button() {
		WebElement Siginbtn = ThreadLocalDriver.getDriver().findElement(By.xpath("//a[text()='Sign in']"));
		Siginbtn.click();
	}

	@Then("the user validates the Title of the page")
	public void the_user_validates_the_title_of_the_page() {
		String title = "Sign in - Google Accounts";
		String Etitle = ThreadLocalDriver.getDriver().getTitle();
		Assert.assertEquals(Etitle, title);
	}

}
