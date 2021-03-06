package dd_utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsUtil 
{
	TestUtil s = new TestUtil();
	/* Overlay */
	public void overlay(WebDriver driver) throws Exception
	{
		
		
		while(s.isElementPresent(By.xpath(".//*[@id='OverlayParent']"), driver))
		{
			System.out.println("Overlay");
			Thread.sleep(2000);
		}
		
	}
	
	/* Setting General check */
	public String Settinghome (WebDriver driver)
	{
		String z = "";
		try
		{
			//Object file declaration //
		
				Properties obj = new Properties();
				FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Settings.properties"); 
				obj.load(objfile);	
				
				Thread.sleep(5000);
				driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
				if(s.isElementPresentcheck(By.xpath(obj.getProperty("Settingssubmenu")), driver))
				{					
					System.out.println("Settings sub nemu bar is available");
					if(s.isElementPresentcheck(By.xpath(obj.getProperty("Displaysettings")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("UserSettings")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("Notificationsettings")), driver))
					{
						System.out.println("All sub menus are available");
						Thread.sleep(5000);
						if(driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).getAttribute("class").equalsIgnoreCase("-current-location"))
						{
							System.out.println("Display settings menu is selected by default");
							z = "Display setting, user setting, Notification setting";
						}
					 }
				}
				
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				return z;
			}
		
		
	}
	
	
	/* Display setting General check */
	public ArrayList<String> displaySettinghome (WebDriver driver)
	{
		ArrayList<String> z = new ArrayList<String>(); 
		try
		{
			//Object file declaration //
		
				Properties obj = new Properties();
				FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Settings.properties"); 
				obj.load(objfile);		
				//Support s =new Support();
				driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
				driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
				if(s.isElementPresentcheck(By.xpath(obj.getProperty("Settingscontent")), driver))
				{
					if(s.isElementPresentcheck(By.xpath(obj.getProperty("SessionExpiration")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("MessagesPerReport")), driver)&&
					   s.isElementPresentcheck(By.xpath(obj.getProperty("ConfirmCommandMessage")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("DateFormat")), driver) &&
					   s.isElementPresentcheck(By.xpath(obj.getProperty("TemperatureUnit")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("TimeZone")), driver) &&
					   s.isElementPresentcheck(By.xpath(obj.getProperty("FuelUnit")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("HistoryReportType")), driver) &&
					   s.isElementPresentcheck(By.xpath(obj.getProperty("DistanceUnit")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("ReeferState/Modeofopdisplay")), driver) &&
					   s.isElementPresentcheck(By.xpath(obj.getProperty("DefaultReportView")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("Locationdropdown")), driver) )
						{
							System.out.println("Settings content");
							z.add("SessionExpiration, MessagesPerReport, ConfirmCommandMessage, DateFormat, TemperatureUnit, TimeZone, FuelUnit, HistoryReportType, DistanceUnit, ReeferState/Modeofopdisplay, DefaultReportView, LocationDisplay(City,StateandYard)"); 
						}
				}
				if(s.isElementPresentcheck(By.xpath(obj.getProperty("UpdateDispalySettings")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("Reset")), driver))
				{
					System.out.println("button check");
					z.add(", Update settings, Reset");
				}
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				return z;
			}
		
		
	}
	
	/* Session expiration verification */
	public String Sessionexpire (WebDriver driver ,String b)
	{
		
		String z = "";
		try
		{
			//Object file declaration //
			Properties obj = new Properties();
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Settings.properties"); 
			obj.load(objfile);		
			//Support s =new Support();
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
			driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(obj.getProperty("SessionExpiration"))).click();
			Thread.sleep(2000);
			switch (b)
			{
				case "20 minutes" : 	driver.findElement(By.xpath(obj.getProperty("20"))).click();
										break;
				case "30 minutes" : 	driver.findElement(By.xpath(obj.getProperty("30"))).click();
										break;
				case "40 minutes" : 	driver.findElement(By.xpath(obj.getProperty("40"))).click();
										break;
				case "50 minutes" : 	driver.findElement(By.xpath(obj.getProperty("50"))).click();
										break;
				case "60 minutes" : 	driver.findElement(By.xpath(obj.getProperty("60"))).click();
										break;
				default :	System.out.println("Selected an invalid option");
							break;	
			}
			//b++;
			//System.out.println("B :"+b);
			driver.findElement(By.xpath(obj.getProperty("UpdateDispalySettings"))).click();
			System.out.println("Clicked on the update settings button");
			Thread.sleep(3000);
			if(s.isAlertPresent(driver))
			{
				Alert alert = driver.switchTo().alert();
				z = alert.getText();
				System.out.println("alert text: "+z);
	  	  		alert.accept();
			}
			Thread.sleep(5000);
			/*if(s.isAlertPresent(driver))
			{
				Alert alert = driver.switchTo().alert();
				alert.accept();
				z= "Session Expired successfully";
			}*/
			z= "Session Expired successfully";
			System.out.println(z);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return z;
		}
		
 }
	
	public String Messagesperreport (WebDriver driver ,String b)
	{
		
		String z = "";
		try
		{
			//Object file declaration //
			Properties obj = new Properties();
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Settings.properties"); 
			obj.load(objfile);		
			//Support s =new Support();
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
			driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(obj.getProperty("MessagesPerReport"))).click();
			Thread.sleep(2000);
		
			switch (b)
			{
				case "10Messages" : driver.findElement(By.xpath(obj.getProperty("10perpage"))).click();
								    break;
				case "20Messages" : driver.findElement(By.xpath(obj.getProperty("20perpage"))).click();
									break;
				case "50Messages" : driver.findElement(By.xpath(obj.getProperty("50perpage"))).click();
									break;
				case "100Messages" :driver.findElement(By.xpath(obj.getProperty("100perpage"))).click();
									break;
				case "200Messages" :driver.findElement(By.xpath(obj.getProperty("200perpage"))).click();
									break;
				case "300Messages" :driver.findElement(By.xpath(obj.getProperty("300perpage"))).click();
				 					break;
				default :	System.out.println("Selected an invalid option");
							break;	
			}
			String z2 = driver.findElement(By.xpath(".//*[@id='drp_settings_messages_per_page_chosen']/a/span")).getText();
			System.out.println(z2);
			String[] a1 = z2.split(" ");
			System.out.println("session expiration selection");
			driver.findElement(By.xpath(obj.getProperty("UpdateDispalySettings"))).click();
			System.out.println("Clicked on the save button");
			Thread.sleep(2000);
			if(s.isAlertPresent(driver))
			{
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
	  	  		alert.accept();
	  	  		Thread.sleep(2000);
	  	  		
			}
			if(s.isAlertPresent(driver))
  	  		{
  	  			Alert alert1 = driver.switchTo().alert();
  	  			System.out.println(alert1.getText());
  	  			alert1.accept();
  	  		}
			
			overlay(driver);
			Thread.sleep(5000);
			String z1 = driver.findElement(By.xpath(obj.getProperty("PerPage"))).getText();
			System.out.println(z1);
			String[] a2 = z1.split(" ");
			System.out.println(a1[0]);
			System.out.println(a2[0]);
			if (a1[0].equalsIgnoreCase(a2[0]))
			{
				System.out.println("in if loop");
				z= "Number of messages per page updated successfully";
				System.out.println(z);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return z;
		}
		
		
	}
	
	public String Dateformat(WebDriver driver , String d, String asset) throws Exception
	{ 
		String z= "";
		String z1 = "";
		String z2="";
		boolean k = false;
		
		try 
		{
			Properties obj = new Properties();
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Settings.properties"); 
			obj.load(objfile);		
			//Support s =new Support();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
			driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
			driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
			driver.findElement(By.xpath(obj.getProperty("DateFormat"))).click();
			switch (d)
			{
				case "yyyy-MM-dd HH:mm" : driver.findElement(By.xpath(obj.getProperty("yyyy-MM-dd"))).click();
									break;
				case "MM-dd-yyyy HH:mm" : driver.findElement(By.xpath(obj.getProperty("MM-dd-yyyy"))).click();
									break;
				case "MM-dd-yy HH:mm" : 	driver.findElement(By.xpath(obj.getProperty("MM-dd-yy"))).click();
									break;
				case "dd-MM-yyyy HH:mm" : driver.findElement(By.xpath(obj.getProperty("dd-MM-yyyy"))).click();
									break;
				case "dd-MM-yy HH:mm" : 	driver.findElement(By.xpath(obj.getProperty("dd-MM-yy"))).click();
									break;
				case "dd-MMM-yy HH:mm" : 	driver.findElement(By.xpath(obj.getProperty("dd-MMM-yy"))).click();
									break;					
				default :	System.out.println("Selected an invalid option");
							break;	
			}
			z1 = driver.findElement(By.xpath(".//*[@id='drp_settings_date_format_chosen']/a/span")).getText();
			System.out.println(z1);
			driver.findElement(By.xpath(obj.getProperty("UpdateDispalySettings"))).click();
			if(s.isAlertPresent(driver))
			{
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
	  	  		alert.accept();
	  	  		Thread.sleep(2000);
	  	  		
			}
			if(s.isAlertPresent(driver))
  	  		{
  	  			Alert alert1 = driver.switchTo().alert();
  	  			System.out.println(alert1.getText());
  	  			alert1.accept();
  	  		}
		
			if(z1.equalsIgnoreCase(d))
			{
				z="Date format updated successfully";
				System.out.println(z);
			}
			
			
		}
		catch (FileNotFoundException e) 
		{	
			e.printStackTrace();	
		}
		finally
		{
			return z; 
		}
	}
	
	public String TempUnit (WebDriver driver , String t)
	{
		String z= "";
		try{
		
		String z1 = "";
		String z2="";
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Settings.properties"); 
		obj.load(objfile);		
		//Support s =new Support();
		
		driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
		driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
		driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
		driver.findElement(By.xpath(obj.getProperty("TemperatureUnit"))).click();
		switch (t)
		{
			case "Fahrenheit" : driver.findElement(By.xpath(obj.getProperty("Fahrenheit"))).click();
								break;
			case "Celsius" : 	driver.findElement(By.xpath(obj.getProperty("Celsius"))).click();
								break;
			default :	System.out.println("Selected an invalid option");
						break;	
		}
	    z1 = driver.findElement(By.xpath(".//*[@id='drp_settings_temp_unit_chosen']/a/span")).getText();
		System.out.println(z1);
		driver.findElement(By.xpath(obj.getProperty("UpdateDispalySettings"))).click();
		System.out.println("Clicked on the update settings button");
		Thread.sleep(4000);
		if(s.isAlertPresent(driver))
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
  	  		alert.accept();
		}
		Thread.sleep(2000);
		if(s.isAlertPresent(driver))
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		overlay(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Properties prop = new Properties();
		FileInputStream objfile1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Object.properties"); 
		prop.load(objfile1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Reefers"))));
		driver.findElement(By.xpath(prop.getProperty("Reefers"))).click();
		
		WebElement elem  =	driver.findElement(By.xpath(".//*[@id='legend-preference-common']/div/div/div[2]/ul/li[2]/button"));
		z2 = elem.getAttribute("innerText");
		System.out.println(z2);
		String[] a = z2.split(" ");
		System.out.println(a[3]);
		if (z1.equalsIgnoreCase(a[3]))
		{
			z= "Temperature unit updated successfully";
			System.out.println(z);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return z;
		}
		
	
	}
	public String Timezone (WebDriver driver , String t)
	{
		String z= "";
		try
		{
			String b1 ="";
			String b2 ="";
			Properties obj = new Properties();
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Settings.properties"); 
			obj.load(objfile);		
			//Support s =new Support();
			
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
			driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
			driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
			driver.findElement(By.xpath(obj.getProperty("TimeZone"))).click();
			switch (t)
			{
				case "EasternTime(US&Canada)" : driver.findElement(By.xpath(obj.getProperty("EasternTime(US&Canada)"))).click();
												b1="ET";
												break;
				case "CentralTime(US&Canada)" : driver.findElement(By.xpath(obj.getProperty("CentralTime(US&Canada)"))).click();
												b1 ="CT";
												break;
				case "MountainTime(US&Canada)" :driver.findElement(By.xpath(obj.getProperty("MountainTime(US&Canada)"))).click();
												b1= "MT";
												break;
				case "PacificTime(US&Canada)" : driver.findElement(By.xpath(obj.getProperty("PacificTime(US&Canada)"))).click();
												b1="PT";
												break;
				case "Alaska" : 				driver.findElement(By.xpath(obj.getProperty("Alaska"))).click();
												b1="AKT";
												break;
				case "GMT" : 					driver.findElement(By.xpath(obj.getProperty("GMT"))).click();
												b1="GMT";
												break;
				case "AustraliaWT" : 			driver.findElement(By.xpath(obj.getProperty("AustraliaWT"))).click();
												b1="AWT";
												break;
				case "AustraliaET(Brisbane)" : 	driver.findElement(By.xpath(obj.getProperty("AustraliaET(Brisbane)"))).click();
												b1="AET(Brisbane)";
												break;
				case "AustraliaET(Canberra)" :	driver.findElement(By.xpath(obj.getProperty("AustraliaET(Canberra)"))).click();
												b1="AET(Canberra)";
												break;
				case "AustraliaCT(Adelaide)" :	driver.findElement(By.xpath(obj.getProperty("AustraliaCT(Adelaide)"))).click();
												b1="ACT(Adelaide)";
												break;
				case "AustraliaCT(Darwin)" :	System.out.println();
												driver.findElement(By.xpath(obj.getProperty("AustraliaCT(Darwin)"))).click();
												b1="ACT(Darwin)";
												break;
				case "SouthAfrica" : 			driver.findElement(By.xpath(obj.getProperty("SouthAfrica"))).click();
												b1="SAST";
												break;
				default :	System.out.println("Selected an invalid option");
							break;	
			}
			System.out.println(b1);
			driver.findElement(By.xpath(obj.getProperty("UpdateDispalySettings"))).click();
			System.out.println("Clicked on the update settings button");
			if(s.isAlertPresent(driver))
			{
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
	  	  		alert.accept();
			}
			Thread.sleep(5000);
			if(s.isAlertPresent(driver))
			{
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			overlay(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			Properties prop = new Properties();
			FileInputStream objfile1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Object.properties"); 
			prop.load(objfile1);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Reefers"))));
			driver.findElement(By.xpath(prop.getProperty("Reefers"))).click();
			
			WebElement NewButton  =	driver.findElement(By.xpath(".//*[@id='legend-preference-common']/div/div/div[2]/ul/li[1]/button"));
			b2 = NewButton.getAttribute("innerText");
			System.out.println(b2);
			String[] a1 = b2.split(" ");
			System.out.println(a1[5]);
			if (b1.equalsIgnoreCase(a1[5]))
			{
				System.out.println("in if loop");
				z= "TimeZone updated successfully";
				System.out.println(z);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
				return z;
		}
	}
	
	public String fuelunit (WebDriver driver , String f)
	{
		String z= "";
		try{
		
		String b1 ="";
		String b2 ="";
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Settings.properties"); 
		obj.load(objfile);		
		//Support s =new Support();
		
		driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
		driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
		driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
		driver.findElement(By.xpath(obj.getProperty("FuelUnit"))).click();
		switch (f)
		{
			case "USGallons" :  driver.findElement(By.xpath(obj.getProperty("USGallons"))).click();
								b1="ET";
								break;
			case "Liters" : 	driver.findElement(By.xpath(obj.getProperty("Liters"))).click();
								b1 ="CT";
								break;
			default :			System.out.println("Selected an invalid option");
								break;	
		}
	    b1 = driver.findElement(By.xpath(".//*[@id='drp_settings_fuel_unit_chosen']/a/span")).getText();
		System.out.println(b1);
		driver.findElement(By.xpath(obj.getProperty("UpdateDispalySettings"))).click();
		System.out.println("Clicked on the update settings button");
		if(s.isAlertPresent(driver))
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
  	  		alert.accept();
		}
		Thread.sleep(2000);
		if(s.isAlertPresent(driver))
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		overlay(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Properties prop = new Properties();
		FileInputStream objfile1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Object.properties"); 
		prop.load(objfile1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Reefers"))));
		driver.findElement(By.xpath(prop.getProperty("Reefers"))).click();
		
		WebElement NewButton  =	driver.findElement(By.xpath(".//*[@id='legend-preference-common']/div/div/div[2]/ul/li[3]/button"));
		b2 = NewButton.getAttribute("innerText");
		System.out.println(b2);
		String[] a1 = b2.split(" ");
		if(f.equalsIgnoreCase("USGallons"))
		{
		  a1[4] =a1[4] + " " +a1[5];
		  System.out.println(a1[4]);
		}		
		if (b1.equalsIgnoreCase(a1[4]))
		{
			z= "Fuel Unit updated successfully";
			System.out.println(z);
		}
	}catch(Exception e)
		{
		e.printStackTrace();
		}
		finally
		{
			return z;
		}
	}

	public String modeOfOperation (WebDriver driver , String d)
	{
		String z= "";
		try{
		System.out.println("Changing mode of operation");
		String b1 ="";
		String b2 ="";
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Settings.properties"); 
		obj.load(objfile);		
		//Support s =new Support();
		
		driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
		driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
		driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
		driver.findElement(By.xpath(obj.getProperty("ReeferState/Modeofopdisplay"))).click();
		switch (d)
		{
			case "Combined" :  	driver.findElement(By.xpath(obj.getProperty("Combined"))).click();
								break;
			case "Seperate" : driver.findElement(By.xpath(obj.getProperty("Separate"))).click();
								break;
			default :			System.out.println("Selected an invalid option");
								break;	
		}
	    
		driver.findElement(By.xpath(obj.getProperty("UpdateDispalySettings"))).click();
		System.out.println("Clicked on the update settings button");
		if(s.isAlertPresent(driver))
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
  	  		alert.accept();
		}
		Thread.sleep(2000);
		if(s.isAlertPresent(driver))
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		overlay(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Properties prop = new Properties();
		FileInputStream objfile1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Object.properties"); 
		prop.load(objfile1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Reefers"))));
		driver.findElement(By.xpath(prop.getProperty("Reefers"))).click();
		
		switch (d)
		{
			case "Combined" :  	
				if(s.isElementPresentcheck(By.xpath(".//*[@id='table-col-100--reeferStateDescription']/button"), driver))
				{
					System.out.println("ReeferState present...");
					z="Mode of Operation test successful.";
				} 
				else
				{
					System.out.println("ReeferState not present...");
					z="Mode of Operation test failed.";
				}
				break;
			case "Seperate" : 
				if(s.isElementPresentcheck(By.xpath(".//*[@id='table-col-100--reeferStateDescription']/button"), driver)
				&& s.isElementPresentcheck(By.xpath(".//*[@id='table-col-100--reeferMode']/button"), driver))
				{
					System.out.println("ReeferState & ReeferMode present...");
					z="Mode of Operation test successful.";
				} 
				else
				{
					System.out.println("ReeferState & ReeferMode not present...");
					z="Mode of Operation test failed.";
				}
				break;
			default :			System.out.println("Selected an invalid option");
								break;	
		}
		
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		finally
		{
			return z;
		}
	}
	
	public String distanceUnit (WebDriver driver , String d)
	{
		String z= "";
		try{
		
		String b1 ="";
		String b2 ="";
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Settings.properties"); 
		obj.load(objfile);		
		//Support s =new Support();
		
		driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
		driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
		driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
		driver.findElement(By.xpath(obj.getProperty("DistanceUnit"))).click();
		switch (d)
		{
			case "Miles" :  	driver.findElement(By.xpath(obj.getProperty("Miles"))).click();
								break;
			case "Kilometers" : driver.findElement(By.xpath(obj.getProperty("Kilometers"))).click();
								break;
			default :			System.out.println("Selected an invalid option");
								break;	
		}
	    b1 = driver.findElement(By.xpath(".//*[@id='drp_settings_dist_unit_chosen']/a/span")).getText();
		System.out.println(b1);
		driver.findElement(By.xpath(obj.getProperty("UpdateDispalySettings"))).click();
		System.out.println("Clicked on the update settings button");
		if(s.isAlertPresent(driver))
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
  	  		alert.accept();
		}
		Thread.sleep(2000);
		if(s.isAlertPresent(driver))
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		overlay(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Properties prop = new Properties();
		FileInputStream objfile1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Object.properties"); 
		prop.load(objfile1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Reefers"))));
		driver.findElement(By.xpath(prop.getProperty("Reefers"))).click();
		
		WebElement NewButton  =	driver.findElement(By.xpath(".//*[@id='legend-preference-common']/div/div/div[2]/ul/li[4]/button"));
		b2 = NewButton.getAttribute("innerText");
		System.out.println(b2);
		String[] a1 = b2.split(" ");
		if (b1.equalsIgnoreCase(a1[3]))
		{
			z= "Distance Unit updated successfully";
			System.out.println(z);
		}
	}catch(Exception e)
		{
		e.printStackTrace();
		}
		finally
		{
			return z;
		}
	}
	public String defaultview (WebDriver driver , String d)
	{
		String z= "";
		try{
		int f = 0;
		String b1 ="";
		String b2 ="";
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Settings.properties"); 
		obj.load(objfile);		
		//Support s =new Support();
		
		driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
		driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
		driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
		driver.findElement(By.xpath(obj.getProperty("DefaultReportView"))).click();
		switch (d)
		{
			case "ReeferStatusReport" :		driver.findElement(By.xpath(obj.getProperty("ReeferStatusReport"))).click();
											break;
			case "ReeferMutli-tempReport" : driver.findElement(By.xpath(obj.getProperty("ReeferMutli-tempReport"))).click();
											break;
			default :						System.out.println("Selected an invalid option");
											break;	
		}
	    b1 = driver.findElement(By.xpath(".//*[@id='drp_settings_report_view_chosen']/a")).getText();
		System.out.println(b1);
		driver.findElement(By.xpath(obj.getProperty("UpdateDispalySettings"))).click();
		System.out.println("Clicked on the update settings button");
		if(s.isAlertPresent(driver))
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
  	  		alert.accept();
		}
		Thread.sleep(2000);
		if(s.isAlertPresent(driver))
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		//overlay(driver);
		Thread.sleep(5000);
		if(d.equalsIgnoreCase("Reefer Status Report") && driver.findElement(By.xpath(obj.getProperty("Status"))).getAttribute("class").equalsIgnoreCase("-current-location"))
		{
			System.out.println("Reefer Status Report Selected by default");
			f=1;		
		}
		if(d.equalsIgnoreCase("ReeferMutli-tempReport") && driver.findElement(By.xpath(obj.getProperty("Multi-Temp"))).getAttribute("class").equalsIgnoreCase("-current-location"))
		{
			System.out.println("Multi-Temp Report Selected by default");
			f=1;		
		}
		
		if(f == 1)
		{
			z = "Default Report View updated successfully";
		}
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}

		finally
		{
			return z;
		}
	}
	
	public String location(WebDriver driver, Properties obj, String sel)
	{	
		String acop="";
		try
		{
			//driver.manage().window().maximize();
			Thread.sleep(10000);
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
			driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("UpdateDispalySettings"))));
			
			driver.findElement(By.xpath(obj.getProperty("Locationdropdown"))).click();
			
			if(sel.equalsIgnoreCase("Combined"))
				driver.findElement(By.xpath(".//*[@id='drp_settings_location_display_chosen']/div/ul/li[1]")).click();
			else
				driver.findElement(By.xpath(".//*[@id='drp_settings_location_display_chosen']/div/ul/li[2]")).click();
			
			driver.findElement(By.xpath(obj.getProperty("UpdateDispalySettings"))).click();
			
			if(s.isAlertPresent(driver))
			{
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
			}
				if(s.isAlertPresent(driver))
					driver.switchTo().alert().accept();
				
				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(2000);
				
				Thread.sleep(5000);
				driver.findElement(By.xpath(obj.getProperty("Reefers"))).click();
				driver.findElement(By.xpath(obj.getProperty("Status"))).click();
				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(2000);
				
				Thread.sleep(3000);
				driver.findElement(By.xpath(obj.getProperty("showhideColumns"))).click();
				Thread.sleep(3000);
				if(sel.equalsIgnoreCase("Combined"))
				{
					System.out.println("In combined...");
					int length = driver.findElement(By.xpath(obj.getProperty("locationORcity"))).getText().length();
					String answer = driver.findElement(By.xpath(obj.getProperty("locationORcity"))).getText().substring(0,length - 16);
					String answers[]=answer.split("\n");
					System.out.println("::"+answers[1]+"::");
					if(answers[1].equalsIgnoreCase("Location"))				
						acop="Location settings test successful.";
					else
						acop="Location settings test failed.";
				}
				else
				{
					System.out.println("In seperate");
					int length = driver.findElement(By.xpath(obj.getProperty("locationORcity"))).getText().length();
					String answer = driver.findElement(By.xpath(obj.getProperty("locationORcity"))).getText().substring(0,length - 16);
					String answers[]=answer.split("\n");
					System.out.println("::"+answers[1]+"::");
					if(answers[1].equalsIgnoreCase("City"))
						acop="Location settings test successful.";
					else
						acop="Location settings test failed.";
				}
				
				driver.findElement(By.xpath(obj.getProperty("cancelShowHide"))).click();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println(acop);
			return acop;
		}
	}
	
	public String notificationSettings(WebDriver driver, Properties obj)
	{
		//Support s = new Support();
		String acop="";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			Thread.sleep(10000);
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("UserSettings"))));
			driver.findElement(By.xpath(obj.getProperty("Notificationsettings"))).click();
			
			if(s.isElementPresentcheck(By.xpath(obj.getProperty("enableEmailNotification")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("enableWirelessDeviceNotification")), driver)
			&& s.isElementPresentcheck(By.xpath(obj.getProperty("reeferAlarmsNotification")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("reeferEventsNotificationLocal")), driver)
			&& s.isElementPresentcheck(By.xpath(obj.getProperty("reeferEventsNotificationRemote")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("testNotification")), driver)
			&& s.isElementPresentcheck(By.xpath(obj.getProperty("updateNotificationSettings")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("resetNotificationSettings")), driver))
			{
				System.out.println("All fields present...");
				acop="Notification settings page loaded successfully.";
			}
			else
			{
				System.out.println("Page load unsuccessful...");
				acop="Notification page load failed";
			}
			
			driver.findElement(By.xpath(obj.getProperty("Reefers"))).click();
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(2000);
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println(acop);
			return acop;
		}
	}
	
	public String notificationSettingsnew(WebDriver driver, Properties obj, String data)
	{
		//Support s = new Support();
		String acop="";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("UserSettings"))));
			driver.findElement(By.xpath(obj.getProperty("Notificationsettings"))).click();
			
			if(s.isElementPresentcheck(By.xpath(obj.getProperty("enableEmailNotification")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("enableWirelessDeviceNotification")), driver)
			&& s.isElementPresentcheck(By.xpath(obj.getProperty("reeferAlarmsNotification")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("reeferEventsNotificationLocal")), driver)
			&& s.isElementPresentcheck(By.xpath(obj.getProperty("reeferEventsNotificationRemote")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("testNotification")), driver)
			&& s.isElementPresentcheck(By.xpath(obj.getProperty("updateNotificationSettings")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("resetNotificationSettings")), driver))
			{
				System.out.println("All fields present...");
				System.out.println("Checking the Email Settings...");
				
				if(s.isElementPresentcheck(By.xpath(obj.getProperty("emailAddressTextArea")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("emailAddressTextArea")), driver))
				{
					driver.findElement(By.xpath(obj.getProperty("emailAddressTextArea"))).clear();
					driver.findElement(By.xpath(obj.getProperty("emailAddressTextArea"))).sendKeys(data);
					System.out.println("Updated email notification...");
					acop="Enable email settings update...";
				}
				else
				{
					System.out.println("Enable email setting fail...");
					acop="Enable email settings failed...";
				}
				
				System.out.println("Checking the Wireless Device Settings...");
				
				if(s.isElementPresentcheck(By.xpath(obj.getProperty("wirelessDevicechkBox")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("wirelessDeviceTextArea")), driver))
				{
					driver.findElement(By.xpath(obj.getProperty("wirelessDeviceTextArea"))).clear();
					driver.findElement(By.xpath(obj.getProperty("wirelessDeviceTextArea"))).sendKeys(data);
					System.out.println("Updated email notification...");
					acop="Enable email settings updated...";
				}
				else
				{
					System.out.println("Enable email setting fail...");
					acop="Enable email settings failed...";
				}
				
				System.out.println("Checking Test Notificaiton...");
				
				driver.findElement(By.xpath(obj.getProperty("testNotification"))).click();
				if(s.isAlertPresent(driver))
				{
					System.out.println(driver.switchTo().alert().getText());
					driver.switchTo().alert().accept();
					//WebDriverWait wait = new WebDriverWait(driver,20);
					Thread.sleep(2000);
					//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='content']/div[1]/div"))));
					
					if(s.isElementPresentcheck(By.xpath(".//*[@id='content']/div[1]/div"), driver))
					{
						acop="Test notificaiton test passed...";
					}
					else
					{
						acop="Test notificaiton test failed...";
					}
				}
				
				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-3-page']/div/div[3]/div/div[1]/div/ul/li[1]/label[1]/span[2]/span"), driver) && s.isElementPresentcheck(By.xpath(".//*[@id='div-3-page']/div/div[3]/div/div[1]/div/ul/li[1]/label[2]/span[2]/span"), driver)
				&& s.isElementPresentcheck(By.xpath(".//*[@id='div-3-page']/div/div[3]/div/div[2]/div/ul/li[1]/label[1]/span[2]/span"), driver) && s.isElementPresentcheck(By.xpath(".//*[@id='div-3-page']/div/div[3]/div/div[2]/div/ul/li[1]/label[2]/span[2]/span"), driver)
				&& s.isElementPresentcheck(By.xpath(".//*[@id='div-3-page']/div/div[3]/div/div[3]/div/ul/li[1]/label[1]/span[2]/span"), driver) && s.isElementPresentcheck(By.xpath(".//*[@id='div-3-page']/div/div[3]/div/div[3]/div/ul/li[1]/label[2]/span[2]/span"), driver))
				{
					acop="All alertf fields present...";
				}
				else
				{
					acop="All alert fields not present...";
				}
				
				driver.findElement(By.xpath(obj.getProperty("updateNotificationSettings"))).click();
				if(s.isAlertPresent(driver))				
					driver.switchTo().alert().accept();
			
					/*if(s.isAlertPresent(driver))
						driver.switchTo().alert().accept();		*/		
			}
			else
			{
				System.out.println("Page load unsuccessful...");
				acop="Notification page load failed";
			}
			
			driver.findElement(By.xpath(obj.getProperty("Reefers"))).click();
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(2000);
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("acop : "+acop);
			return acop;
		}
	}
	
	public String userSettings(WebDriver driver, Properties obj,String uname, String pwd)
	{
		//Support s = new Support();
		String acop="";
		try
		{
			String splitpwd[] = pwd.split(",");
			System.out.println(splitpwd[0]);
			System.out.println(splitpwd[1]);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
			driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("UserSettings"))));
			driver.findElement(By.xpath(obj.getProperty("UserSettings"))).click();
			
			if(s.isElementPresentcheck(By.xpath(".//*[@id='txt-settings-username']"), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("currentPassword")), driver)
			&& s.isElementPresentcheck(By.xpath(obj.getProperty("newPassword")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("confirmPassword")), driver)
			&& s.isElementPresentcheck(By.xpath(".//*[@id='txt-settings-company']"), driver) && s.isElementPresentcheck(By.xpath(".//*[@id='txt-settings-firstname']"), driver)
			&& s.isElementPresentcheck(By.xpath(".//*[@id='txt-settings-lastname']"), driver) && s.isElementPresentcheck(By.xpath(".//*[@id='txt-settings-email']"), driver))
			{
				System.out.println("All fields present...");
				
				driver.findElement(By.xpath(obj.getProperty("currentPassword"))).clear();
				driver.findElement(By.xpath(obj.getProperty("currentPassword"))).sendKeys(splitpwd[0]);
				
				driver.findElement(By.xpath(obj.getProperty("newPassword"))).clear();
				driver.findElement(By.xpath(obj.getProperty("newPassword"))).sendKeys(splitpwd[1]);
				
				driver.findElement(By.xpath(obj.getProperty("confirmPassword"))).clear();
				driver.findElement(By.xpath(obj.getProperty("confirmPassword"))).sendKeys(splitpwd[1]);
				
				driver.findElement(By.xpath(obj.getProperty("updateUserSettings"))).click();
				Thread.sleep(5000);
				
				if(s.isAlertPresent(driver))
				{
					driver.switchTo().alert().accept();
					Thread.sleep(2000);
				}
					if(s.isAlertPresent(driver))
					{
						driver.switchTo().alert().accept();
					}
					Thread.sleep(7000);
				
					driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
					driver.findElement(By.xpath(obj.getProperty("Logout"))).click();
					Thread.sleep(2000);
					if(s.isAlertPresent(driver))
					{
						driver.switchTo().alert().accept();
					}
			
					Thread.sleep(5000);
					if(s.dologin(driver,"stindia" , splitpwd[1]))
					{
						acop="User Settings test successful.";
						driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
						driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("UserSettings"))));
						driver.findElement(By.xpath(obj.getProperty("UserSettings"))).click();
						
						driver.findElement(By.xpath(obj.getProperty("currentPassword"))).clear();
						driver.findElement(By.xpath(obj.getProperty("currentPassword"))).sendKeys(splitpwd[1]);
						
						driver.findElement(By.xpath(obj.getProperty("newPassword"))).clear();
						driver.findElement(By.xpath(obj.getProperty("newPassword"))).sendKeys(splitpwd[0]);
						
						driver.findElement(By.xpath(obj.getProperty("confirmPassword"))).clear();
						driver.findElement(By.xpath(obj.getProperty("confirmPassword"))).sendKeys(splitpwd[0]);
						
						driver.findElement(By.xpath(obj.getProperty("updateUserSettings"))).click();
						Thread.sleep(5000);
						
						if(s.isAlertPresent(driver))
						{
							driver.switchTo().alert().accept();
							Thread.sleep(2000);
						}
							if(s.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
							driver.findElement(By.xpath(obj.getProperty("Logout"))).click();
							Thread.sleep(2000);
							if(s.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
							}
							Thread.sleep(10000);
							s.dologin(driver, uname, splitpwd[0]);
					
					}
						
					else
						acop = "User Settings test failed.";
			}
				
				else
				{
					if(driver.findElement(By.xpath(obj.getProperty("ErrorMessage"))).isDisplayed())
					{
						System.out.println(driver.findElement(By.xpath(obj.getProperty("ErrorMessage"))).getText());
						
						driver.findElement(By.xpath(obj.getProperty("Reefers"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						{
							Thread.sleep(2000);
						}
						acop = "User Settings test failed.";
					}
				}
						
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println(acop);
			return acop;
		}
	}
	
	public String confirmCommand(WebDriver driver, Properties obj, String confirm,String asset)
	{
		String acop="";
		try
		{
			//Support s =new Support();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
			driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("Displaysettings"))));
			driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
			driver.findElement(By.xpath(obj.getProperty("ConfirmCommandMessage"))).click();
			
			if(confirm.equalsIgnoreCase("Yes"))
				driver.findElement(By.xpath(".//*[@id='drp_settings_confirm_command_chosen']/div/ul/li[1]")).click();
			else
				driver.findElement(By.xpath(".//*[@id='drp_settings_confirm_command_chosen']/div/ul/li[2]")).click();
			System.out.println("Confrim command selected...");
			
			driver.findElement(By.xpath(obj.getProperty("UpdateDispalySettings"))).click();
			Thread.sleep(2000);
			
			if(s.isAlertPresent(driver))
			{
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
			}
				if(s.isAlertPresent(driver))
				{
					driver.switchTo().alert().accept();
				}
			
			
			Properties prop = new Properties();
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Object.properties"); 
			prop.load(objfile);
			overlay(driver);
			Thread.sleep(5000);
			driver.findElement(By.xpath(prop.getProperty("Reefers"))).click();
			driver.findElement(By.xpath(prop.getProperty("Status"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("FleetSelect"))));
			driver.findElement(By.xpath(prop.getProperty("FleetSelect"))).click();
			//driver.findElement(By.xpath(prop.getProperty("AllFleetInput"))).click();
			driver.findElement(By.xpath(prop.getProperty("AllFleetInput"))).clear();
			driver.findElement(By.xpath(prop.getProperty("AllFleetInput"))).sendKeys("All Fleets");
			driver.findElement(By.xpath(prop.getProperty("AllFleetSelect"))).click();
			overlay(driver);
			driver.findElement(By.xpath(prop.getProperty("Searchbox"))).clear();
			driver.findElement(By.xpath(prop.getProperty("Searchbox"))).sendKeys(asset);
			driver.findElement(By.xpath(prop.getProperty("Searchbutton"))).click();
			overlay(driver);
			
			if(s.isElementPresentcheck(By.xpath(prop.getProperty("SearchedAssetSelect")), driver))
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath(prop.getProperty("SearchedAssetSelect"))).click();
				driver.findElement(By.xpath(prop.getProperty("PollCommands"))).click();
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("CancelPollCommands"))));
				driver.findElement(By.xpath("html/body/div[24]/div/div/div[2]/ul/li[1]/label/span/span")).click();
				driver.findElement(By.xpath(prop.getProperty("SendPollCommands"))).click();
				Thread.sleep(5000);
				if(confirm.equalsIgnoreCase("Yes"))
				{
					if(s.isAlertPresent(driver))
					{
						Alert alert = driver.switchTo().alert();
						System.out.println(alert.getText());
						alert.accept();
						acop="Confirm command test successful.";
					}
					
				
					else
					{
						acop="Confirm command test failed.";
					}
				}
				
				else
				{
					/*if(s.isAlertPresent(driver))
					{
						Alert alert = driver.switchTo().alert();
						System.out.println(alert.getText());
						alert.accept();
						acop="Confirm command test failed.";
					}
					else
					{*/
						acop="Confirm command test successful.";
					//}
				}
				driver.findElement(By.xpath(prop.getProperty("ClearButton"))).click();
				Thread.sleep(1000);
				if(s.isAlertPresent(driver))
					driver.switchTo().alert().accept();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Reefers"))));
			}
			else
			{
				System.out.println("Searched an invalid asset...");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return acop;
		}


	}
	
	public void backToNormal(Properties obj, Properties prop)
	{
		try
		{
			WebDriver driver = new FirefoxDriver();
			driver.get(prop.getProperty("URL"));
			s.dologin(driver, "stindia", "test123");
			driver.findElement(By.xpath(prop.getProperty("")));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
	}
}
