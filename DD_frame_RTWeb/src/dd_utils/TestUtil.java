package dd_utils;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dd_core.TestCore;

public class TestUtil extends TestCore 
{
	public static String mailscreenshotpath;
	
	
	/*Setup Function before login */
	public static void set() throws IOException
	{
		if(driver==null)
		{
			System.out.println("Test Exceution started");
			
			//Loading Object property file
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Object.properties");
			Object.load(fis);
			log.debug("Object properties file loaded");
			
			FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Settings.properties");
			Object1.load(fis1);
			log.debug("Property file loaded");
			
			//Reading the browser type from property file
			if(Object.getProperty("browser").equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "////amxserver//amx-share//STW_QA//Jar files//geckodriver.exe");
				
			}else if(Object.getProperty("browser").equals("ie"))
			{
				System.setProperty("webdriver.ie.driver", "D:\\workspace\\internetexplorerdriver.exe");
							
			}else if(Object.getProperty("browser").equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
				
			}
		}
	}

	
	/*Login function */
	public  boolean dologin(WebDriver driver,String uname, String Pwd) throws Exception
	{
		//driver.manage().window().maximize();
		
		driver.findElement(By.xpath(Object.getProperty("UserID"))).clear();
		System.out.println("Entering username");
		driver.findElement(By.xpath(Object.getProperty("UserID"))).sendKeys(uname);
		driver.findElement(By.xpath(Object.getProperty("Password"))).clear();
		System.out.println("Entering Password");
		driver.findElement(By.xpath(Object.getProperty("Password"))).sendKeys(Pwd);
		
		System.out.println("Clicking on the login button");
		WebElement w = driver.findElement(By.xpath(Object.getProperty("Login")));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.delay(200);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		w.click();
		Thread.sleep(5000);
		return true;
	}
	
	/* This method is used to get the exceution time of each function */ 
	public String timestamp(long Stime)
	{
		long Etime = System.currentTimeMillis();
		long Ttime = Etime - Stime;
		long Exetime =Ttime /1000 ;
		return Long.toString(Exetime);
	}
	

	/*Generating timestamp */
	public static String generateTimeStamp()
	{
		Calendar cal = new GregorianCalendar();
		  int month = cal.get(Calendar.MONTH); //3
		  int year = cal.get(Calendar.YEAR); //2014
		  int sec =cal.get(Calendar.SECOND);
		  int min =cal.get(Calendar.MINUTE);
		  int date = cal.get(Calendar.DATE);
		  int day =cal.get(Calendar.HOUR_OF_DAY);
		  String timestamp = year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec;
		  return timestamp;
	}

	/* Capturing screenshot*/
	public static String CaptureScreenshot() throws IOException
	{
		  Calendar cal = new GregorianCalendar();
		  int month = cal.get(Calendar.MONTH); 
		  int year = cal.get(Calendar.YEAR); 
		  int sec =cal.get(Calendar.SECOND);
		  int min =cal.get(Calendar.MINUTE);
		  int date = cal.get(Calendar.DATE);
		  int day =cal.get(Calendar.HOUR_OF_DAY);
		  mailscreenshotpath = System.getProperty("user.dir")+"\\Screenshot\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
		  return mailscreenshotpath;
	}
	
	/* This method is used to compare expected with Actual */
	public boolean testStatus(String eopt, String aopt)
	{
		//System.out.println(eopt+":"+aopt);
		if(eopt.equalsIgnoreCase(aopt))
		{
			return true;
		}
		else
			return false;
	}
	
	//Checking whether the element is present or not		
	public boolean isElementPresentcheck(By by, WebDriver driver)
	{
		try
		{
			//System.out.println("searching for "+driver.findElement(by).getAttribute("id"));
			if(driver.findElement(by).isDisplayed())
			{
				//System.out.println(driver.findElement(by).getAttribute("id")+" is present...");
				return true;
			}
			else
			{
				//System.out.println(driver.findElement(by).getAttribute("id")+" is not present...");
				return false;
			}
		}
		catch (Exception e)
		{
			//System.out.println("Element is not present...");
			return false;
		}
	}
	
	 /* This method finds and returns if there is an alert present. */
	 public boolean isAlertPresent(WebDriver driver)
		{ 
		 try 
		    { 
		        driver.switchTo().alert(); 
		        return true; 
		    }  
		    catch (NoAlertPresentException Ex) 
		    { 
		    	Ex.printStackTrace();
		        return false; 
		    }   
		} 
	
	
	// Reading the data from excel sheet
	public static String[][] getData(String sheetName)
	{
		int rows = excel.getRowCount(sheetName);
		int cols= excel.getColumnCount(sheetName);
		
		String[][] data = new String[rows-1][cols];
		
		for(int rowNum = 2 ; rowNum <= rows ; rowNum++)
		{ 		
			
			for(int colNum=0 ; colNum< cols; colNum++)
			{
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); 
			}
		}
		
		return data;
		
	}
	
	//Converting the folder /file into zip format
	public static void zip(String filepath)
	{
	 	try
	 	{
	 		File inFolder=new File(filepath);
	 		File outFolder=new File("TestResults.zip");
	 		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
	 		BufferedInputStream in = null;
	 		byte[] data  = new byte[1000];
	 		String files[] = inFolder.list();
	 		for (int i=0; i<files.length; i++)
	 		{
	 			in = new BufferedInputStream(new FileInputStream
	 			(inFolder.getPath() + "/" + files[i]), 1000);  
	 			out.putNextEntry(new ZipEntry(files[i])); 
	 			int count;
	 			while((count = in.read(data,0,1000)) != -1)
	 			{
	 				out.write(data, 0, count);
	 			}
	 			out.closeEntry();
	 		}
	 		out.flush();
	 		out.close();
	 	
	 	}catch(Exception e)
	 	{
	 		e.printStackTrace();
	 	} 
	}

	/* Element checking function */
	public boolean isElementPresent(By by, WebDriver driver)
	{
		try
		{
			driver.findElement(by).click();
			//System.out.println("Element found...");
			return true;
		}
		catch (Exception e)
		{
			//System.out.println("Element not found...");
			return false;
		}
	}
	public String cutString(String s1,String s2)
	{
		try
		{
			int pt1=0;
					String cut1="Null";
					//if(s1.isEmpty())
						//System.out.println("Empty String..");
					if(s1.contains(s2))
					{
						pt1=s1.indexOf(s2);
						cut1 = s1.substring(0, pt1);
					}
					if(!s1.equalsIgnoreCase(cut1))
					{
						s1=cut1;
						System.out.println(cut1.length());
						System.out.println(cut1);
						System.out.println(s1);
					}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			return s1;
		}
	}
	public String dateConvert(String sdate)
	{
		String out = null;
		int sdateNew=0;
		if(sdate.length()>=6)
		{
			 sdateNew = Integer.parseInt(sdate.substring(6));
		}
		try
		{
			
			if(sdate.length()>5 && sdate.startsWith("Today"))
			{
				if(sdate.charAt(5)=='+')
				{
					sdate=sdate.substring(6);
					System.out.println(sdate);
					Calendar c = Calendar.getInstance();
			        c.add(Calendar.DATE, sdateNew);
			        Date date = c.getTime();
			        System.out.println(date);
			        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yy");
			        String todayDate = sdf1.format(date);
					//System.out.println("Today date : "+todayDate);
					out =todayDate;
				}
				else if(sdate.charAt(5)=='-')
				{
					sdate=sdate.substring(6);
					System.out.println(sdate);
					Calendar c = Calendar.getInstance();
			        c.add(Calendar.DATE, -sdateNew);
			        Date date = c.getTime();
			        System.out.println(date);
			        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yy");
			        String todayDate = sdf1.format(date);
					//System.out.println("Today date : "+todayDate);
					out =todayDate;
				}
				else
				{
					//System.out.println(sdate+" is invalid...");
					out ="NA";
				}
			}
			else if(sdate.equalsIgnoreCase("Today"))
			{
				//System.out.println(sdate+" is today...");
				Calendar c = Calendar.getInstance();
				Date date = c.getTime();
				System.out.println(date);
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yy");
		        String todayDate = sdf1.format(date);
				//System.out.println("Today date : "+todayDate);
				out =todayDate;
			}
			else
			{
				System.out.println("Invalid start date...");
				out="NA";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//System.out.println(out);
			return out;
		}
	}
	public int dateCompare(String startDateString, String endDateString, String DateString)
	{
		int ret=0;
		try
		{
			DateFormat df = new SimpleDateFormat("dd-MMM-yy"); 
		    Date startDate = null,endDate = null,date = null;
		    startDate = df.parse(startDateString);
		    //System.out.println(startDate); 
		    endDate = df.parse(endDateString);
		 // System.out.println(endDate); 
		    date = df.parse(DateString);
		 // System.out.println(date); 
		    
		    if(date.compareTo(startDate)>=0 && date.compareTo(endDate)<=0)
		  	{
				System.out.println("Date is within range");
				ret = 1;
			}
			else
			{
				System.out.println("Date is out of range");
				ret = 0;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return ret;
		}

	}
	public boolean unitofMeasure(WebDriver driver, Properties obj, String mainMenu,String page,String button, String toolTip, String toolTipval, String settingsUnit)
	{
		boolean status = false;
		try
		{
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
				driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
				driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
				String Units = driver.findElement(By.xpath(settingsUnit)).getText();
				driver.findElement(By.xpath(mainMenu)).click();
				while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))			
					Thread.sleep(1000);
			
				driver.findElement(By.xpath(page)).click();
				while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))			
					Thread.sleep(1000);
				
				driver.findElement(By.xpath(button)).click();
				String unitsTooltip="Null";
				Thread.sleep(1000);
				
				if(driver.findElement(By.xpath(toolTip)).isDisplayed()){
					unitsTooltip = driver.findElement(By.xpath(toolTipval)).getAttribute("textContent");
				}
				else
				{	//System.out.println("Not displayed...");
					System.out.println(Units+":"+unitsTooltip);
				}
				if(unitsTooltip.contains("Fahrenheit") || unitsTooltip.contains("Celsius"))
				{
					String[] arrSplit = unitsTooltip.split(" ");
					unitsTooltip = arrSplit[0];
					//System.out.println("Inside If Loop"+unitsTooltip);
				}
				else
				{
					System.out.println(unitsTooltip);
				}
				if(Units.equalsIgnoreCase(unitsTooltip))
				{
					status = true;
				}
				else
				{
					status = false;
				}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			return status;
		}
	}
	
	public void clearDateRange(WebDriver driver,Properties obj)
	{
	try
	{
	driver.findElement(By.xpath(obj.getProperty("EditDateRange"))).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(obj.getProperty("ClearDaterange"))).click();
	}
	catch(Exception ex)
	{
	ex.printStackTrace();
	}
	
	
	}
	
	////////////////////Clear Filter ///////////////////
	public void clearFilter(WebDriver driver,Properties obj,String clearFilter)
	{	
		try
		{

			Thread.sleep(2000);
			driver.findElement(By.xpath(obj.getProperty(clearFilter))).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			if(isAlertPresent(driver))
			{
				Alert alert;
				alert = driver.switchTo().alert();	
				String chk1 = driver.switchTo().alert().getText();
				System.out.println(alert.getText());
				alert.accept();
			}
			while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
			/*while(isAlertPresent(driver))
			{
				Alert alert;
				alert = driver.switchTo().alert();	
				alert.accept();
			}
			while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(1000);
			}
			Thread.sleep(1000);*/

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/////////////////////////////////////////////////////
	
	public boolean dateSort(String[] dateArray)
	{
		boolean status=false;
		String [] returnString = new String[dateArray.length];
		String [] returnString1 = new String[dateArray.length];
		try
		{
			String [][] arr = new String[dateArray.length][];
			
			
			for(int i=0;i<dateArray.length;i++)
				{

				if(dateArray[i].length()==10)
					arr[i]=dateArray[i].split("-");
				else
				{
					String [] array ={"-","-","-"};
					arr[i]=array;
				}
				}

			for(int i=0;i<arr.length;i++)
			{
				returnString[i]=arr[i][2]+arr[i][0]+arr[i][1];
				returnString1[i]=arr[i][2]+arr[i][0]+arr[i][1];
				//System.out.println(returnString[i]);
			}
			
			Arrays.sort(returnString);

			for(int i=0;i<returnString1.length;i++)
				System.out.println(returnString[i]+"::"+returnString1[i]);
			status = Arrays.equals(returnString, returnString1);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return status;
		}
	}
	
	public static String downloadPath = "\\\\amxserver\\amx-share\\STW_QA\\Rtweb Automation\\Downloaded Excel";
	public static FirefoxOptions excelDownload()
	{
		  isFileDownloaded(downloadPath);
		  /*FirefoxOptions options = new FirefoxOptions();
	      options.addPreference("browser.download.folderList", 2);
	      options.addPreference("browser.download.manager.showWhenStarting",false);	    
	      options.addPreference("browser.download.dir", downloadPath);
	      options.addPreference("browser.helperApps.neverAsk.saveToDisk","text/csv , application/vnd.ms-excel");*/	
		  //Added the below code for CSV download
		  FirefoxOptions options = new FirefoxOptions();
	      options.addPreference("browser.download.folderList", 2);
	      options.addPreference("browser.download.manager.showWhenStarting",false);	    
	      options.addPreference("browser.download.dir", downloadPath);
	      options.addPreference("browser.helperApps.neverAsk.openFile","text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
	      options.addPreference("browser.helperApps.neverAsk.saveToDisk","application/msword,application/csv,text/csv, application/vnd.ms-excel");		  
		  return options;		
	}
	
	//FDelete the download file
	 public static boolean isFileDownloaded(String downloadPath) {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
		      
		          dirContents[i].delete();
		         
		          }
		      return false;
		  }
	 
	
	 
	 /*public  FirefoxProfile excelDownload1()  throws Exception {
	{
		ChromeOptions profile = new ChromeOptions();
		try{
			
				profile..CAPABILITY.
			
		        profile.setPreference("browser.download.folderList", 2);
		        profile.setPreference("browser.download.manager.showWhenStarting", false);
		        profile.setPreference("browser.download.dir", downloadPath);
		        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/vnd.ms-excel");
		        profile.setExperimentalOption(name, value);

		        
		        
		        HashMap<String, Object> chromePrefs = new HashMap<String, Object>(); 
		        chromePrefs.put("profile.default_content_settings.popups", 0); 
		        chromePrefs.put("download.default_directory", downloadPath); 
		        chromePrefs.put("browser.helperApps.neverAsk.saveToDisk","application/vnd.ms-excel");
		        
		        ChromeOptions options = new ChromeOptions(); 
		        HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>(); 
		        profile.setExperimentalOption("prefs", chromePrefs); 
		        options.addArguments("--test-type"); 
		        DesiredCapabilities cap = DesiredCapabilities.chrome(); 
		        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap); 
		        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
		        cap.setCapability(ChromeOptions.CAPABILITY, profile); 
		FirefoxProfile profile = new FirefoxProfile();	
	    try{
			
		        profile.setPreference("browser.download.folderList", 2);
		        profile.setPreference("browser.download.manager.showWhenStarting", false);
		        profile.setPreference("browser.download.dir", downloadPath);
		        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		       
		
		finally
		{
			return profile;
		}
	}
	}*/
	public boolean unitofMeasure1(WebDriver driver, Properties obj, String mainMenu, String page, String reportCode, String HistoryReport, String button, String toolTip, String toolTipval, String settingsUnit)
	{
		
		boolean status = false;
		try
		{
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
				driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
				driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
				String Units = driver.findElement(By.xpath(settingsUnit)).getText();
				driver.findElement(By.xpath(mainMenu)).click();
				while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))			
				Thread.sleep(1000);
			
				driver.findElement(By.xpath(page)).click();
				while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))				
					Thread.sleep(1000);
			
				//driver.findElement(By.xpath(obj.getProperty("ReeferSearch"))).sendKeys(Asset);
				driver.findElement(By.xpath(obj.getProperty("SearchButton"))).click();
  			while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  			
  				Thread.sleep(1000);
  			
  			/*if(isElementPresentcheck(By.xpath(".//*[@id='div-"+reportCode+"-datagrid-tbody']/tr/td[2]/a"), driver))
				{
  				driver.findElement(By.xpath(".//*[@id='div-"+reportCode+"-datagrid-tbody']/tr/td[2]/a")).click();	
				}
  			else if(isElementPresentcheck(By.xpath(".//*[@id='div-"+reportCode+"-datagrid-tbody']/tr/td[1]/a"), driver))
			{
				driver.findElement(By.xpath(".//*[@id='div-"+reportCode+"-datagrid-tbody']/tr/td[1]/a")).click();	
			} 
  			while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				System.out.println("inside while loop");
				Thread.sleep(1000);
			} 
  			Thread.sleep(4000);
			driver.findElement(By.xpath(HistoryReport)).click();
			while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				System.out.println("inside while");
				Thread.sleep(1000);
			}*/
				driver.findElement(By.xpath(button)).click();
				String unitsTooltip="Null";
				Thread.sleep(1000);
				
				if(driver.findElement(By.xpath(toolTip)).isDisplayed()){
					unitsTooltip = driver.findElement(By.xpath(toolTipval)).getAttribute("textContent");
				}
				else
				{	//System.out.println("Not displayed...");
				System.out.println(Units+":"+unitsTooltip);
				}
				if(unitsTooltip.contains("Fahrenheit") || unitsTooltip.contains("Celsius"))
				{
					String[] arrSplit = unitsTooltip.split(" ");
					unitsTooltip = arrSplit[0];
					System.out.println("Inside If Loop"+unitsTooltip);
				}
				else
				{
					System.out.println(unitsTooltip);
				}
				if(Units.equalsIgnoreCase(unitsTooltip))
				{
					status = true;
				}
				else
				{
					status = false;
				}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			return status;
		}
	}
	public static boolean isElementEnabledcheck(By by, WebDriver driver)
	{

		try
		{
			//System.out.println("searching for "+driver.findElement(by).getAttribute("id"));
			if(driver.findElement(by).isEnabled())
			{
				//System.out.println(driver.findElement(by).getAttribute("id")+" is present...");
				return true;
			}
			else
			{
				//System.out.println(driver.findElement(by).getAttribute("id")+" is not present...");
				return false;
			}
		}
		catch (Exception e)
		{
			//System.out.println("Element is not present...");
			return false;
		}
	}
}

