package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    private WebDriver driver; // default value will be null and to iniialize it will use constructor

    // 1.  const of page class
    public LoginPage(WebDriver driver)
    {

        this.driver = driver;
    }

    // 2. private By locators - locators are kept private so that cant be easily accessed as they are risky
        private By emailId =   By.id("input-email");
        private By pwd = By.id("input-password");
        private By loginBtn = By.xpath("//input[@value=\"Login\"]");
        private By forgotPwd = By.linkText("Forgotten Password");
        private By logo = By.xpath("//img[contains(@src,'opencart-logo')]");

        // 3. public page actions/methods

    public String getLoginPageTitle(){
       String title =  driver.getTitle();
        System.out.println("Login page title :" + title);
       return title;
    }

    public String getLoginPageURL(){
       String URL =  driver.getCurrentUrl();
        System.out.println("Login page url :" + URL);
       return URL;
    }

    public boolean getLogo(){
       return driver.findElement(logo).isDisplayed();

    }
    public boolean forgotPasswordLinkExists()
    {
        return driver.findElement(forgotPwd).isDisplayed();
    }

    public List<String> getFooterLinksList()
    {
      List<WebElement> footerlist = driver.findElements(By.xpath("//footer//a"));
      List<String> footerTextList = new ArrayList<String>();
      for(WebElement e : footerlist)
      {
        String text =   e.getText();
          footerTextList.add(text);
      }
       return footerTextList;
    }

//    public WebElement getElement(By locator){
//        WebElement ele =  driver.findElement(locator);
//        return ele;
//
//    }

}
