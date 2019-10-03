/*package com.ssi;

import org.testng.annotations.Test;

public class FlipkartTest {
  @Test
  public void f() {
	  System.out.println("chall gyaaaaaaaaaaaaa FFFFFFFFFFFFFF");
  }
  @Test
  public void a() {
	  System.out.println("chall gyaaaaaaaaaaaaa AAAAAAAAAAAAAAA");
  }
  @Test
  public void b() {
	  System.out.println("chall gyaaaaaaaaaaaaa BBBBBBBBBBBBBBBBB");
  }
}*/


package com.ssi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipkartTest {

	WebDriver driverChrome;
	@BeforeTest
	public void browser() {
		String path=System.getProperty("user.dir");
		String genericPathChrome=path+"\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", genericPathChrome);
		driverChrome= new ChromeDriver();
		driverChrome.manage().window().maximize();
		driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driverChrome.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driverChrome.manage().deleteAllCookies();
	}
	@Test(priority=1)
	public void cart() throws InterruptedException, IOException {
		
		/*driverChrome.get("https://www.flipkart.com");
		driverChrome.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("");
		driverChrome.findElement(By.xpath("(//input[@type=\"text\"])[2]")).clear();
		Thread.sleep(10000);
		driverChrome.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("");
		driverChrome.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();
		Thread.sleep(5000);
		driverChrome.findElement(By.xpath("//a[@class=\"_3ko_Ud\"]")).click();
		Thread.sleep(5000);*/
		
		driverChrome.get(Config.getData("Environment"));
		WebElement element=driverChrome.findElement(By.xpath(""));
		element.sendKeys("Ankush");
		//Enter data using more keys like in caps
		Actions action=new Actions(driverChrome);
		Action build=action.moveToElement(element).keyDown(Keys.SHIFT).sendKeys("ankush").build();
		build.perform();
		//clicking the submit button
		WebElement elementClick=driverChrome.findElement(By.xpath(""));
		Action builds=action.click(elementClick).build();
		builds.perform();
		
		Thread.sleep(10000);
	}
	@Test(priority=2)
	public void popup(){
		
	}
	@Test(enabled=false)
	public void sikuliMethod() throws FindFailed, InterruptedException {
		
		Screen screen= new Screen();
		Pattern searchBox= new Pattern("C:\\Users\\Ankush\\Desktop\\Selenium Data\\doc\\searchBox.PNG");
		screen.type(searchBox, "Book");
		screen.click(searchBox);
		Thread.sleep(5000);
	}
	
	public static void main(String[] args) throws InterruptedException, FindFailed {
		FlipkartTest flip= new FlipkartTest();
		flip.browser();
		/*flip.cart();*/
		flip.sikuliMethod();
	}
	

}
 