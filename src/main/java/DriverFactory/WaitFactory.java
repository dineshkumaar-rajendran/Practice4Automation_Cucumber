package DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.dinesh.constants.FrameworkConstants;

import qa.enumer.WaitStrategy;

public class WaitFactory {

	public static WebElement explicitWait(By by, WaitStrategy waitStrategy) {
		WebElement element = null;
		if (waitStrategy == WaitStrategy.Clickable) {
			element = new WebDriverWait(ThreadLocalDriver.getDriver(), FrameworkConstants.getExwaittime())
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitStrategy == WaitStrategy.Presence) {
			element = new WebDriverWait(ThreadLocalDriver.getDriver(), FrameworkConstants.getExwaittime())
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}

		else if (waitStrategy == WaitStrategy.Visible) {
			element = new WebDriverWait(ThreadLocalDriver.getDriver(), FrameworkConstants.getExwaittime())
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}

		else if (waitStrategy == WaitStrategy.None) {
			element = ThreadLocalDriver.getDriver().findElement(by);
		}
		return element;

	}
}
