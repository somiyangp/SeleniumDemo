package com.orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

//	WebDriver driver;
//	@Test(dataProvider="dp")
//	  public void login(String uname,String pass,String key1,String key2) {
//		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
//		  driver=new ChromeDriver();
//		  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//		  driver.findElement(By.name(uname)).sendKeys(key1);
//		  driver.findElement(By.name(pass)).sendKeys(key2);
//		  driver.findElement(By.name("Submit")).click();
//	  }
  @DataProvider(name="dp")
  public Object[][] dp() {
    return new Object[][] {
       { "txtUsername","txtPassword","test", "test123" },
       { "txtUsername","txtPassword","Admin", "admin123" }
    };
  }
}
