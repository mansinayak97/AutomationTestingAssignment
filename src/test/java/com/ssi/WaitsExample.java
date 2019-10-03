package com.ssi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitsExample {
	
	/*
	 Dynamic Waits :-
	 
	 1. Implicit Wait, elements ki searching ka time h, it is on element level.
	 2. Explicit Wait, we pass some condition (jb tk mujhe wait krna h, jb tk ki element visible na ho jaye, ya element enable na  ho jaye, ya element load na ho jaye, ye element jb tk clickable na ho jaye ).
	 
	 Static Waits :-
	 
	 1. Thread.sleep() 
	 
	 */

WebDriver driver;
	
	@Test(priority = 1)
	public void browser() {
		String path = System.getProperty("user.dir");
		String genericPath = path + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", genericPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}
	
	@Test(priority = 2)
	public void logIn() throws IOException {
		driver.get(GetConfig.getData("Environment"));
		
		// This is another way to find the html element to pass some data in it.
		WebElement element = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		element.sendKeys("8085676882");
		
		
		Actions action = new Actions(driver);
		//This is to write capital letter in any input box.
		
		/*
		Action build = action.moveToElement(element).keyDown(Keys.SHIFT).sendKeys("abcd").keyUp(Keys.SHIFT).build();
		build.perform();
		*/
		
		
		
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("password");
		
		//This action of clicking is done by Action class see below.
		//driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		WebElement elementClick = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		Action build = action.click(elementClick).build();
		build.perform();
		
		/*Explicit Wait ka code
		 *   
		 *WebDriverWait webwait = new WebDriverWait(driver, 30);//passed 30 second ka timeout.
		 *webwait.until(ExpectedConditions.visibilityOf(elementClick));
		 *
		 */
		
	}
}
