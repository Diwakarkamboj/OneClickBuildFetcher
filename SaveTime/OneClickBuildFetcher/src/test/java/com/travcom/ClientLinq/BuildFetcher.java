package com.travcom.ClientLinq;



import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuildFetcher extends FolderName{
		
		public static String downloadPath;
	
	public static void main(String[] args) {
		FolderName name=new FolderName();
		downloadPath="D:\\Machinework\\TestWorkspace\\MasterBuild\\"; 
		File file=new File(name.getText()); //Calling Folder Name here
		downloadPath=downloadPath+file;
		File dir=new File(downloadPath); 
		dir.mkdir();
		Map<String, Object> prefs = new HashMap<String, Object>(); //setting desired download path
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", downloadPath);
		System.out.println("Build Folder "+name.getText()+" created successfully");
		
			WebDriverManager.chromedriver().version("87.0.4280.88").setup();
			
			  ChromeOptions options = new ChromeOptions();
			  options.setExperimentalOption("prefs", prefs); 
			  DesiredCapabilities cap =DesiredCapabilities.chrome();
			  cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			  cap.setCapability(ChromeOptions.CAPABILITY, options);
			  
			  @SuppressWarnings("deprecation") 
			  WebDriver driver=new ChromeDriver(cap);
			  driver.get("http://build.dev.imbibe.in:2015/login.html");//Invoke TeamCity 
			  
			  driver.get("http://build.dev.imbibe.in:2015/login.html");
			  driver.findElement(By.id("username")).sendKeys("admin");
			  driver.findElement(By.id("password")).sendKeys("admin");
			  driver.findElement(By.xpath(
			  "//body/div[@id='loginPage']/div[1]/div[1]/form[1]/div[5]/input[1]")).click();
			  System.out.println("Congratulations you've login to Teamcity succesfully.");
			  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			  driver.manage().window().maximize(); JavascriptExecutor js =
			  (JavascriptExecutor) driver; js.executeScript("window.scrollBy(0,550)"); //Scroll Down (+) 
			  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS); 
			  System.out.println("Scrolled Down...");
			  driver.findElement(By.
			  xpath("//a[contains(text(),'Server Master Release Build')]")).click();
			  
			  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS); WebElement
			  build1= driver.findElement(By.
			  cssSelector("body.pageBG.gt800.gt1000.gt1200:nth-child(2) div.fixedWidth.clearfix:nth-child(7) div.refreshable div.refreshableInner div.recentHistory div.recentHistory_builds:nth-child(2) div.grid__container-fluid--3g.Builds__builds--2u.global__font--1w div.BuildDetails__build--3a:nth-child(1) div.ListItem__listItem--Jo.global__font--1w.Build__build--2l.global__font-smaller--2q.global__font-lower--3X.global__font--1w.StarBuild__wrapper--I1.Build__build--2l.global__font-smaller--2q.global__font-lower--3X.global__font--1w.StarBuild__wrapper--I1.Build__without-path--3v.Build__oneLine--2Y div.ListItem__row--33.Build__row--3a.grid__row--1I.grid__baseline-xs--1s div.Build__not-comment-wrapper--3y div.grid__col--3c.Build__durationIcons-tags--2J.Build__withExactDuration--qD:nth-child(4) div.Build__icons-tags--3A div.BuildArtifacts__wrapper--iH:nth-child(3) div.dropdown__dropdown--1p > a.button__button--21.button-group__button--1R.button-set__button--2r.button-toolbar__button--1s.button__withIcon--9B.BuildArtifacts__button--2S.undefined.button__light--D6.button__primary--1o:nth-child(1)"
			  )); build1.click(); WebElement build2=driver.findElement(By.xpath(
			  "//span[contains(text(),'ClientLinq.zip')]")); build2.click();
			  System.out.println("Hey!! build is downloading...");
			 		
	}

}
	
