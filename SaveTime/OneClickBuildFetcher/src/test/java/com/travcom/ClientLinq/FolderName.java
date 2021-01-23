package com.travcom.ClientLinq;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FolderName {
	public  String text;
	public String getText() {
		return this.text;
	}
	public static void main(String[] args) {

		FolderName call=new FolderName();

	}
	public  FolderName() {

		WebDriverManager.chromedriver().version("87.0.4280.88").setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless","--window-size=1920,1200"); //invisible browser window is only 800x600 in size
		WebDriver driver=new ChromeDriver(options);  
		driver.get("http://build.dev.imbibe.in:2015/login.html");//Invoke TC 
		//String Title=driver.getTitle();

		driver.get("http://build.dev.imbibe.in:2015/login.html");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.xpath("//body/div[@id='loginPage']/div[1]/div[1]/form[1]/div[5]/input[1]")).click();
		System.out.println("Congratulations you've login to Teamcity succesfully.");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)"); //Scroll Down (+)
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		System.out.println("Scrolled Down...");
		driver.findElement(By.xpath("//a[contains(text(),'Server Master Release Build')]")).click();

		text= driver.findElement(By.xpath("//span[contains(text(),'#')]")).getText();
		text=text.substring(1);
		System.out.println(text+" is the name of folder");
		driver.findElement(By.xpath("//header/div[1]/div[4]/div[1]/span[2]/span[2]/span[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		driver.close();
		System.out.println("Instance Closed and Logged out!");
	}
}
