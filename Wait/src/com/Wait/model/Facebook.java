package com.Wait.model;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Facebook {
public static void main(String[] args) {
 System.setProperty("webdriver.chrome.driver", "E:\\16122018\\chromedriver_win32\\chromedriver.exe");
 WebDriver driver=new ChromeDriver();
 driver.manage().window().maximize();
 driver.get("https://www.facebook.com/");
 driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
 String title=driver.getTitle();
 System.out.println("The title of this page is:"+title);
 
 driver.findElement(By.linkText("Forgotten account?")).click();
 //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 String title1=driver.getTitle();
 System.out.println("The title of this line is:"+title1);
 
 String title2=driver.findElement(By.xpath("//h2[@class='uiHeaderTitle']")).getText();
 System.out.println("The message displayed after forgot password is:"+title2);
 driver.navigate().back();
 
 WebDriverWait wait=new WebDriverWait(driver, 15);
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']")));
 driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Vishal");
 driver.findElement(By.cssSelector("input#u_0_l")).sendKeys("Rathod");
 driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("vishurathod111@gmail.com");
 driver.findElement(By.xpath("//div[@class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']/child::input[@name='reg_email_confirmation__']")).sendKeys("vishurathod111@gmail.com");
 driver.findElement(By.xpath("//div[@class='placeholder']/following-sibling::input[@id='u_0_v']")).sendKeys("Vishal@123");
 WebElement day=driver.findElement(By.id("day"));
 Select selday=new Select(day);
 selday.selectByIndex(1);
 WebElement month=driver.findElement(By.id("month"));
 Select selmonth=new Select(month);
 selmonth.selectByVisibleText("Nov");
 WebElement year=driver.findElement(By.id("year"));
 Select selyear=new Select(year);
 selyear.selectByValue("1995");
 driver.findElement(By.xpath("//label[@for='u_0_a']")).click();
 driver.findElement(By.cssSelector("button[name='websubmit']")).click();
 driver.navigate().back();
}
}
