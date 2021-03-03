/*
 * package com.qa.testcases;
 * 
 * import org.testng.Assert; import org.testng.annotations.DataProvider; import
 * org.testng.annotations.Test;
 * 
 * import com.BaseTest.app.BaseTest;
 * 
 * import qa.pages.HomePage_Orange; import qa.pages.LoginPageOrange;
 * 
 * public final class LoginPageTestOrange extends BaseTest {
 * 
 * private LoginPageTestOrange() {
 * 
 * }
 * 
 * HomePage_Orange HPO;
 * 
 * @Test() public void LoginLogoutTest(String username, String password) throws
 * InterruptedException {
 * 
 * LoginPageOrange LPO = new LoginPageOrange(); LPO.EnterUsername(username);
 * LPO.EnterPassword(password); HPO = LPO.loginbtn(); String originalTitle =
 * HPO.ValidateUserTitle(); String[] splitString = originalTitle.split(" ");
 * System.out.println(splitString[0]); String expectedTitle = "Welcome";
 * HPO.ClickWelcomebtn(); HPO.logoutBtn();
 * Assert.assertEquals(splitString[0],expectedTitle); }
 * 
 * @DataProvider(name = "Multiple login", parallel = true) public Object[][]
 * getData() { return new Object[][] { { "Admins", "admin123" }, { "Admin",
 * "admin123" }, { "Admin", "admin123" } }; } }
 */