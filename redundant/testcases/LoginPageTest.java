/*
 * package com.qa.testcases;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebElement; import
 * org.testng.Assert; import org.testng.annotations.Test;
 * 
 * import com.BaseTest.app.BaseTest;
 * 
 * import DriverFactory.ThreadLocalDriver;
 * 
 * public final class LoginPageTest extends BaseTest {
 * 
 * // Never Hardcode}
 * 
 * private LoginPageTest() { // TODO Auto-generated constructor stub }
 * 
 * 
 * 
 * @Test public void verifyLogo() {
 * 
 * WebElement logo = ThreadLocalDriver.getDriver()
 * .findElement(By.xpath("//a[contains(@title,'Powered by WordPress')]"));
 * 
 * Assert.assertEquals(true, logo.isDisplayed()); }
 * 
 * @Test public void verifyForgot() {
 * 
 * WebElement pwd = ThreadLocalDriver.getDriver()
 * .findElement(By.xpath("//a[contains(text(),'Lost your password?')]"));
 * pwd.click();
 * 
 * Assert.assertEquals(true,
 * ThreadLocalDriver.getDriver().getTitle().contains("Lost Password ")); }
 * 
 * 
 * @Test public void ValidateGoogle() {
 * 
 * }
 * 
 * }
 */