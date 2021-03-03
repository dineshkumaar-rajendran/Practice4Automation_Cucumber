package qa.pages;

import org.openqa.selenium.By;

import qa.enumer.WaitStrategy;

public final class HomePage_Orange extends BasePage {

	private final By welcomeButton = By.id("welcome");
	private final By logoutBtn = By.xpath("//a[text()='Logout']");

	public HomePage_Orange ClickWelcomebtn() {
		click(welcomeButton, WaitStrategy.Clickable, "WelcomeButton");
		return new HomePage_Orange();
	}

	public LoginPageOrange logoutBtn() {
		click(logoutBtn, WaitStrategy.Clickable, "LogoutButton");
		return new LoginPageOrange();
	}

	public String ValidateUserTitle() {

		return getText(welcomeButton, WaitStrategy.Presence, "UserTitle");

	}

}
