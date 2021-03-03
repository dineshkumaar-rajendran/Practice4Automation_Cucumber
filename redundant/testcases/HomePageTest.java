/*
 * package com.qa.testcases;
 * 
 * import org.openqa.selenium.By; import org.testng.Assert; import
 * org.testng.annotations.DataProvider; import org.testng.annotations.Test;
 * 
 * import com.BaseTest.app.BaseTest;
 * 
 * import DriverFactory.ThreadLocalDriver;
 * 
 * public final class HomePageTest extends BaseTest{
 * 
 * private HomePageTest() { // TODO Auto-generated constructor stub }
 * 
 * @Test public void GetTheTitle() { ThreadLocalDriver.getDriver().getTitle(); }
 * 
 * @Test(dataProvider = "DataProvider") public void login(String username,
 * String password) throws InterruptedException {
 * ThreadLocalDriver.getDriver().findElement(By.cssSelector("input[name='log']")
 * ).sendKeys(username);
 * ThreadLocalDriver.getDriver().findElement(By.cssSelector("input[name='pwd']")
 * ).sendKeys(password); ThreadLocalDriver.getDriver().findElement(By.
 * xpath("//input[contains(@value,'Log In')]")).click(); String Actual =
 * ThreadLocalDriver.getDriver().getTitle(); Assert.assertEquals(Actual,
 * "Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress"); }
 * 
 * @DataProvider public Object[][] DataProvider() {
 * 
 * Object[][] data = new Object[3][2]; data[0][0] = "mngr309843"; data[0][1] =
 * "jEsEvYv";
 * 
 * data[1][0] = "admin"; data[1][1] = "demo123";
 * 
 * data[2][0] = "admin"; data[2][1] = "password"; return data;
 * 
 * }
 * 
 * }
 */