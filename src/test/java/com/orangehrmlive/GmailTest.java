package com.orangehrmlive;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GmailTest {
	
	WebDriver driver;
	
  @BeforeClass
  public void openGmail() {
	  
	  System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
  }
  
  @Parameters({"tname","tpassw","valueUname","valuePassw"})
  @BeforeMethod
  public void login(String uname,String pass,String key1,String key2) {
	  driver.findElement(By.name(uname)).sendKeys(key1);
	  driver.findElement(By.name(pass)).sendKeys(key2);
	  driver.findElement(By.name("Submit")).click();
  }
  
  @Test
  public void adminTest() {
	  driver.findElement(By.linkText("Admin")).click();
  }
  
  @Test
  public void LeaveTest() {
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("Leave")).click();
	  driver.findElement(By.linkText("Entitlements")).click();
	  driver.findElement(By.linkText("My Entitlements")).click();
  }

  @Test
  public void pimTest() {
	  driver.findElement(By.linkText("PIM")).click();
	  driver.findElement(By.xpath("//*[@id=\"menu_pim_Configuration\"]")).click();
	  driver.findElement(By.cssSelector("#menu_pim_viewTerminationReasons")).click();
}
  
  @AfterMethod
  public void logout() {
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.findElement(By.id("welcome")).click();
	  driver.findElement(By.cssSelector("#welcome-menu > ul > li:nth-child(2) > a")).click();
  }
  
  @AfterClass
  public void closeBrowser() {
	  driver.close();
  }
}
