package com.qa.opencart.tests;
import com.qa.opencart.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    WebDriver driver;
    LoginPage loginpage;

    @BeforeTest
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginpage = new LoginPage(driver);

    }

    @Test
    public void loginPageTitleTest()
    {
     String actTitle =   loginpage.getLoginPageTitle();
        Assert.assertEquals(actTitle,"Account Login");
    }

    @Test
    public void loginPageURLTest()
    {
       String actURL =  loginpage.getLoginPageURL();
      // Assert.assertEquals(actURL, "https://naveenautomationlabs.com/opencart/index.php?route=account/login");
       Assert.assertTrue(actURL.contains("route=account/login"));
    }

    @Test
    public void ForgotPasswordLinkExistsTest()
    {
        Assert.assertTrue(loginpage.forgotPasswordLinkExists());
    }

    @Test
    public void logoTest()
    {
        Assert.assertTrue(loginpage.getLogo());
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();

    }
}
