package dd_test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.LogisticUtils;
import dd_utils.TestUtil;

public class AssetCommandHistory extends TestCore
{
	static TestUtil s =new TestUtil();
	static LogisticUtils CS =new LogisticUtils();
	
	public static Map<String, Object[]> AssetCmdHistory(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test ,int scase,int ecase)
	{
		ExtentTest node = reports.startTest("ReeferAssetCommadHist");
		String[][] input =TestUtil.getData("ReeferAssetCommadHist");
		
		String acop =null;
		int counter =1;
		
		try
		{
			
			driver = new FirefoxDriver(s.excelDownload());
			driver.get(Object.getProperty("URL"));			
			
			if(s.dologin(driver, input[0][2], input[0][3]))
			{
				System.out.println("Reefer Asset Command History Module");
				for (int i=scase-1;i<ecase;i++)
	  			{
					Robot robot = new Robot();
  					robot.keyPress(KeyEvent.VK_ESCAPE);
  					
  					long stime = System.currentTimeMillis();
	  				
	  				String tc=input[i][0];
	  				String tcdesc =input[i][1];
	  				String eopt =input[i][8];
	  	
	  				System.out.println(tc);
	  				String Chk ="Null";
	  				
	  				if(tc.equalsIgnoreCase("TC1"))
	  				{
	  					try
	  					{
	  					System.out.println( "TC1 Execution started.....");
	  					Thread.sleep(4000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  					Thread.sleep(1000);
		  		
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
	  					System.out.println("before while");
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  			
		  					Thread.sleep(1000);
		  		
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  			
		  					Thread.sleep(1000);
		  			
		  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))
	  				
		  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  			
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  				
		  					Thread.sleep(1000);
		  			
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{
		  				
	  				if( (!s.isElementPresentcheck(By.xpath(Object.getProperty("AssetCommandHistory")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
	  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
	  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
	  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
	  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||	  					
	  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("pollCommands")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlCommands")), driver)) ||
	  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("MoreActions")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) ||
	  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("AssetCmdHistoryDashboard")), driver)))
	  				{
	  					System.out.println("Page not loaded Successfully");
	  					acop = "Reefers History Page not Loaded Successfully";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(tc, counter, sheet, acop,scr);	  					
	  				}
	  				else
	  				{	
	  					System.out.println("Page loaded Successfully");
	  					acop = "Reefers History Page Loaded Successfully";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(tc, counter, sheet, acop);	  					
	  				}
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}	
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
						driver.findElement(By.xpath(Object.getProperty("ClearButton"))).click();
						if(s.isAlertPresent(driver))
						{
							Alert alert;
							alert = driver.switchTo().alert();
							System.out.println(alert.getText());
							String chk1 = driver.switchTo().alert().getText();								
							alert.accept();
						}
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
	  					}catch(Exception e)
	  					{e.printStackTrace();}
	  				
	  				}
	  				
	  				if(tc.equalsIgnoreCase("TC2"))
	  				{
	  					try
	  					{
	  					String sDate =s.dateConvert(input[i][6]);
		  				String eDate =s.dateConvert(input[i][7]);
		  				  				
	  					System.out.println( "TC2 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  		
		  					Thread.sleep(1000);
		  		
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
	  					System.out.println("before while");
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  			
		  					Thread.sleep(1000);
		  				
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  			
		  					Thread.sleep(1000);
		  			
		  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))	  				
		  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  				
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  				
		  					Thread.sleep(1000);
		  				
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{
	  					
	  					driver.findElement(By.xpath(Object.getProperty("EditDateRange"))).click();
		  				if(s.isElementPresentcheck(By.xpath(Object.getProperty("StartDate")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("EndDate")),driver) 
		  					&& s.isElementPresentcheck(By.xpath(Object.getProperty("SetDateRange")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("DateCancel")),driver))
		  				{
		  					System.out.println("Edit date range pop up displayed Successfully");
		  				if(sDate.equalsIgnoreCase("NA"))
		  				{
		  					acop = "Edit date range window should open.";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);		  					
		  				}
		  				else
		  				{
		  					driver.findElement(By.xpath(Object.getProperty("StartDate"))).sendKeys(sDate);
		  					driver.findElement(By.xpath(Object.getProperty("EndDate"))).sendKeys(eDate);
		  					driver.findElement(By.xpath(Object.getProperty("SetDateRange"))).click();
		  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  					
		  						Thread.sleep(1000);		  					
		  					String strMain = driver.findElement(By.xpath(Object.getProperty("DateRangeDisplay"))).getText();
		  					System.out.println("Date range displayed as expected");
		  					
		  					int chkIndex=0;
		  					String TotalPages =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
		  					System.out.println(TotalPages);
		  					String Records="Null";
		  				if(TotalPages.contains(" of "))
		  				{
		  					chkIndex=TotalPages.indexOf(" of ");
		  					Records = TotalPages.substring(chkIndex+4);
		  					System.out.println(Records);
		  				}
		  							
		  				if(Records.equalsIgnoreCase("0"))
		  				{
		  					System.out.println("No data found for the event Search");	
		  					acop = "No data";
		  	  				data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  	  				rc++;
		  	  				excel.writePass(tc, counter, sheet, acop);
		  	  			}
		  				else
		  				{
		  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))			  	  			
			  	  				Thread.sleep(1000);
			  	  	
		  					
		  					Thread.sleep(3000);
		  					String EndDateGet = driver.findElement(By.xpath(Object.getProperty("AssetHistorySendTime"))).getText();
		  					Thread.sleep(2000);
		  					driver.findElement(By.xpath(Object.getProperty("AssetHistoryCmdSend"))).click();
			  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))			  	  			
			  	  				Thread.sleep(1000);
			  	  		
		  					String StartDateGet = driver.findElement(By.xpath(Object.getProperty("AssetHistorySendTime"))).getText();
		  					System.out.println(EndDateGet);
		  					System.out.println(StartDateGet);
		  							
		  					StartDateGet=s.cutString(StartDateGet, "\n");
		  					EndDateGet=s.cutString(EndDateGet, "\n");
		  					System.out.println("StartDate="+StartDateGet);
		  					System.out.println("EndDate="+EndDateGet);
		  					DateFormat df = new SimpleDateFormat("MM-dd-yy");
		  					Date date1=df.parse(StartDateGet);
		  					Date date2=df.parse(EndDateGet);
		  					SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		  					String StartDate = sdf.format(date1);
		  					String EndDate = sdf.format(date2);
		  					System.out.println("Converted to"+StartDate);
		  					System.out.println("Converted to"+EndDate);
		  				if(s.dateCompare(sDate, eDate, StartDate)==1 && s.dateCompare(sDate, eDate, EndDate)==1 )
		  				{
		  								
		  					acop = "Date within range";
		  					node.log(LogStatus.PASS, acop);
		  	  				data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  	  				rc++;
		  	  				excel.writePass(tc, counter, sheet, acop);		  	  				
		  		  		}
		  		  		else
		  		  		{
		  		  			System.out.println("Search value not displayed ");
		  	  				acop = "Date not in range";
		  	  				node.log(LogStatus.FAIL, acop);
		  	  				data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  	  				rc++;
		  	  				String scr = s.CaptureScreenshot();
		  	  				excel.writeFail(tc, counter, sheet, acop,scr);		  	  				
		  		  		}
		  							
		  				}
		  				}
		  				}
		  				else
		  				{
		  					System.out.println("Edit date range pop up not displayed");
	  						acop = "Edit date range window not yet opened.";
	  						node.log(LogStatus.FAIL, acop);
	  						data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
	  						rc++;
	  						String scr = s.CaptureScreenshot();
	  						excel.writeFail(tc, counter, sheet, acop,scr);	  						
		  				}
		  					s.clearDateRange(driver, Object);
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  					{
	  						System.out.println("inside while");
	  						Thread.sleep(1000);
	  					}
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);  						  
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}
	  					}catch(Exception e)
	  					{e.printStackTrace();}
	  				}
	  				
	  				if(tc.equalsIgnoreCase("TC3"))
	  				{
	  					try
	  					{
	  					System.out.println( "TC3 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  			
		  					Thread.sleep(1000);
		  			
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
	  					System.out.println("before while");
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  				
		  					Thread.sleep(1000);
		  			
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			{
  						System.out.println("inside while");
		  				Thread.sleep(1000);
		  			}
		  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))	  				
		  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  				
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				{		
		  					System.out.println("inside while");
		  					Thread.sleep(1000);
		  				}
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{	
		  				Thread.sleep(2000);
  					driver.findElement(By.xpath(Object.getProperty("RefreshIcon"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  					{	
  						System.out.println("inside while");
  						Thread.sleep(1000);
  					}
	  				if( (!s.isElementPresentcheck(By.xpath(Object.getProperty("AssetCommandHistory")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||	  					
		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("pollCommands")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlCommands")), driver)) ||
		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("MoreActions")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) ||
		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("AssetCmdHistoryDashboard")), driver)))
		  				{
		  					System.out.println("Page not Re-loaded Successfully");
		  					acop = "Reefers History Page not Re-Loaded Successfully";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);		  					
		  				}
		  				else
		  				{	
		  					System.out.println("Page Re-loaded Successfully");
		  					acop = "Reefers History Page Re-Loaded Successfully";
		  					node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);		  					
		  				}
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}	
	  					}catch(Exception e)
	  					{e.printStackTrace();}
  					
	  				}
	  				
	  				if(tc.equalsIgnoreCase("TC4"))
	  				{
	  					try
	  					{
	  						System.out.println( "TC4 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
	  					System.out.println("before while");
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
		  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))	  				
		  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  			
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{	
		  				Thread.sleep(2000);
	  				
	  				driver.findElement(By.xpath(Object.getProperty("PrintIcon"))).click();
  					Thread.sleep(5000);
  					ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
  					
  					System.out.println(tabs2.get(0));
  					System.out.println(driver.getWindowHandle());
  					
  					driver.switchTo().window(tabs2.get(1));
  					
  					System.out.println(tabs2.get(1));
  					System.out.println(driver.getWindowHandle());
  					
  				if(s.isElementPresentcheck(By.xpath("html/body/table"), driver))
  				{
  					System.out.println("Print page displayed");
  					acop = "Print page displayed as expected";
  					node.log(LogStatus.PASS, acop);
  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  					rc++;
  					excel.writePass(tc, counter, sheet, acop);
  						
  				}
  				else
  				{
  					System.out.println("Print page not displayed");
  					acop = "Print Page not displayed as expected";
  					node.log(LogStatus.FAIL, acop);
  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
  					rc++;
  					String scr = s.CaptureScreenshot();
  					excel.writeFail(tc, counter, sheet, acop,scr);
  				
  				}
  					//Robot robot = new Robot();
  					robot.keyPress(KeyEvent.VK_ESCAPE);
  					Thread.sleep(200);
  					robot.keyRelease(KeyEvent.VK_ESCAPE);
  					Thread.sleep(2000);
  					driver.close();
  					Thread.sleep(2000);
  					driver.switchTo().window(tabs2.get(0));
  					Thread.sleep(2000);
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}	
	  					}catch(Exception e)
	  					{e.printStackTrace();}
	  				
	  				}
	  				
	  				if(tc.equalsIgnoreCase("TC5"))
	  				{
	  					try
	  					{
	  						System.out.println( "TC5 Execution started.....");
	  				Thread.sleep(5000);
	  				driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  			Thread.sleep(1000);
	  			
	  			driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
	  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  			Thread.sleep(1000);
	  			
  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
  					System.out.println("before while");
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  					Thread.sleep(1000);
	  				
	  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
	  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
	  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
	  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  			Thread.sleep(1000);
	  			
	  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))
  				{
	  				Chk =driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).getText();
	  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
  				}
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  				Thread.sleep(1000);
	  				
  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
  					{	
  					System.out.println(Chk);
	  				System.out.println(Chk.length());
  					
	  				int pt=0;
	  				String cut="Null";
	  			if(Chk.contains("\n"))
	  			{
	  				pt=Chk.indexOf("\n");
	  				cut = Chk.substring(0, pt);
	  			}
	  			if(!Chk.equalsIgnoreCase(cut))
	  			{
	  				Chk=cut;
		  			System.out.println(cut.length());
		  			System.out.println(cut);
		  			System.out.println(Chk);
	  			}
	  			Thread.sleep(2000);
	  				
	  				
	  				ArrayList<String> tr=new ArrayList<String>();
  				 	int pageSize=0,recordsCount=0;
	  				
	  				driver.findElement(By.xpath(Object.getProperty("ExcelDownload"))).click();
  					
  					WebElement ele = driver.findElement(By.xpath(".//*[@id='div-302-datagrid-tbody']"));
	  			 	System.out.println(ele.getTagName());
	  			 	List<WebElement>page=ele.findElements(By.tagName("tr"));
	  			 	System.out.println("PageSize : "+page.size());
	  			 	//System.out.println("PageSize : "+pageSize);
	  			 	pageSize=page.size();
	  			 	try
	  			 	{
	  			 	BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\AssetCommandHistoryReport("+Chk+").xls"));
	  			 	String line;
	  			 	
	  			 	int m=0;
	  			 	while ((line = reader.readLine()) != null)
	  			 	{
	  			 	//System.out.println(line);
	  			 	
	  			 	if(line.contains("<tr"))
	  			 	tr.add(line);
	  			 	//System.out.println(records.get(i));
	  			 	m++;
	  			 	}
	  			 	reader.close();
	  			 	
	  			 	recordsCount=tr.size()-2;
	  			  System.out.println(recordsCount);
	  			 	}
	  			 	catch (Exception e)
	  			 	{
	  			 	
	  			 	e.printStackTrace();
	  			 	
	  			 	}
	  			  System.out.println(recordsCount+":"+pageSize);
	  			 	if(recordsCount == pageSize)
	  			 	{
	  			 		System.out.println("Reocrds count matching... Pass");
	  			 	
			  			acop = "Count Matching";
			  			node.log(LogStatus.PASS, acop);
			  			data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
			  			rc++;
			  			excel.writePass(tc, counter, sheet, acop);			  			
	  			 	}
	  			 	else
	  			 	{
		  			 	System.out.println("Records count mismatch... Fail");
		  			 	acop = "Count mismatch";
		  			 	node.log(LogStatus.FAIL, acop);
		  			 	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  			 	rc++;
		  			 	String scr = s.CaptureScreenshot();		  	
		  			 	excel.writeFail(tc, counter, sheet, acop,scr); 			 	
		  			 	
		  			 	
	  			 	}
  					}else
  					{
  						acop = "No data";
						  	node.log(LogStatus.PASS, acop);
						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
						  	rc++;
						  	excel.writePass(tc, counter, sheet, acop);  						  
  					}	
	  					}catch(Exception e)
	  					{e.printStackTrace();}
	  			 	
	  				}
	  				
	  				if(tc.equalsIgnoreCase("TC6"))
	  				{
	  					try
	  					{
	  						System.out.println( "TC6 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
	  					System.out.println("before while");
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
		  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))
	  					driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  			
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{	
		  				Thread.sleep(2000);
	  				
	  				if(s.unitofMeasure1(driver, Object, Object.getProperty("Commands") ,Object.getProperty("CommandStatus"), "300", Object.getProperty("AssetCommandHistory"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
	  				{
	  					System.out.println("Time zone Displayed Successfully");
	  					acop = "Time zone displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(tc, counter, sheet, acop);
	  					System.out.println( "###################Test case 6 execution completed############################");
	  				}
	  				else
	  				{
	  					System.out.println("Time zone not Displayed ");
	  					acop = "Time zone not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(tc, counter, sheet, acop,scr);
	  					System.out.println( "###################Test case 6 execution completed############################");
	  				}
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}	
	  					}catch(Exception e)
	  					{e.printStackTrace();}	  				
	  				}
	  			
	  				if(tc.equalsIgnoreCase("TC7"))
	  				{
	  					try
	  					{
	  						System.out.println( "TC7 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
	  					System.out.println("before while");
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
		  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))	  				
		  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  				
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{	
		  				Thread.sleep(2000);
		  				
	  				if(s.unitofMeasure1(driver, Object, Object.getProperty("Commands"), Object.getProperty("CommandStatus"), "300", Object.getProperty("AssetCommandHistory"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
	  				{
	  					System.out.println("Temperature Unit Displayed Successfully");
	  					acop = "Temperature Unit displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(tc, counter, sheet, acop);	  					
	  				}
	  				else
	  				{
	  					System.out.println("Temperature Unit not Displayed ");
	  					acop = "Temperature Unit not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(tc, counter, sheet, acop,scr);	  					
	  				}
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}	
	  					}catch(Exception e)
	  					{e.printStackTrace();}	  				
	  				}
	  				
	  				if(tc.equalsIgnoreCase("TC8"))
	  				{
	  					try
	  					{
	  						System.out.println( "TC8 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
	  					System.out.println("before while");
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
		  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))	  				
		  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  				
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{	
		  				Thread.sleep(2000);
		  				
	  				if(s.unitofMeasure1(driver, Object, Object.getProperty("Commands"), Object.getProperty("CommandStatus"), "300", Object.getProperty("AssetCommandHistory"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
	  				{
	  					System.out.println("Fuel Level Displayed Successfully");
	  					acop = "Fuel Level displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(tc, counter, sheet, acop);
	  						  				}
	  				else
	  				{
	  					System.out.println("Fuel Level not Displayed ");
	  					acop = "Fuel Level not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(tc, counter, sheet, acop,scr);
	  					
	  				}
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}	
	  					}catch(Exception e)
	  					{e.printStackTrace();}	  				
	  				}
	  				
	  				if(tc.equalsIgnoreCase("TC9"))
	  				{
	  					try
	  					{
	  						System.out.println( "TC9 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
	  					System.out.println("before while");
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
		  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))	  				
		  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  				
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{	
		  				Thread.sleep(2000);
	  				
	  				if(s.unitofMeasure1(driver, Object, Object.getProperty("Commands"), Object.getProperty("CommandStatus"), "300", Object.getProperty("AssetCommandHistory"), Object.getProperty("DistanceCalcIcon"), Object.getProperty("DistanceTooltip"), Object.getProperty("DistanceTooltipval"), Object.getProperty("DistanceUnit")))
	  				{
	  					System.out.println("Distance Unit Displayed Successfully");
	  					acop = "Distance Unit displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(tc, counter, sheet, acop);	  					
	  				}
	  				else
	  				{
	  					System.out.println("Distance Unit not Displayed ");
	  					acop = "Distance Unit not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(tc, counter, sheet, acop,scr);	  					
	  				}
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}	
	  					}catch(Exception e)
	  					{e.printStackTrace();}	  				
	  				}
	  				
	  				
	  				if(tc.equalsIgnoreCase("TC10"))
	  				{
	  					try
	  					{
	  						System.out.println( "TC10 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
	  					System.out.println("before while");
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
		  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))	  				
		  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  				
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{	
		  				Thread.sleep(2000);
		  				
	  				if((s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)))
	  				{
	  					
	  					System.out.println("Control Probe loaded Successfully");
	  					acop = "Control Probe displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(tc, counter, sheet, acop);	  					
	  				}
	  				else
	  				{	
	  					System.out.println("Control Probe not loaded Successfully");
	  					acop = "Control Probe not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(tc, counter, sheet, acop,scr);	  					
	  				}
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}	
	  					}catch(Exception e)
	  					{e.printStackTrace();}
	  				
	  				}
	  				
	  				
	  				if(tc.equalsIgnoreCase("TC11"))
	  				{
	  					try
	  					{
	  						System.out.println( "TC11 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
	  					System.out.println("before while");
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
		  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))	  				
		  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  				
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{	
		  				Thread.sleep(2000);
	  				
	  				List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-302-datagrid']/div/table[1]/thead/tr[2]"));
  				 	List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();

  				 	for(WebElement row:rows)
  				 	{
  				 	List<WebElement> rowElements = row.findElements(By.xpath("th"));

  				 	ArrayList<String> rowData = new ArrayList<String>();
  				 	
  				 	for(WebElement column:rowElements)
  				 	{
  				 		if(!column.getText().equalsIgnoreCase(" "))
  				 			rowData.add(column.getText().toString());
  				 	}
  				 	System.out.println("rowData Values are"+rowData);
  				 	System.out.println("rowData  Size "+rowData.size());
  				 	String strMain = input[i][6];
	  				String[] arrSplit4 = strMain.split(",");
	  				System.out.println(arrSplit4.length);
	  				int cnt = 0;
  				   
	  				for(int rnum=0;rnum<arrSplit4.length;rnum++)
	  				{
		  				for(String string : rowData)
		  				{
		  					if(string.equalsIgnoreCase(arrSplit4[rnum]))
		  					{
		  						cnt++;
		  						System.out.println(arrSplit4[rnum]+" is present...");
		  					}
		  					
		  					//System.out.println(cnt+"::"+arrSplit4.length);
		  				}
		  				System.out.println(cnt+"::"+arrSplit4.length);
  				   }
	  				System.out.println(cnt+"::"+arrSplit4.length);
	  				if(cnt==arrSplit4.length)
  				    {
  				    	System.out.println("All Column is Present");
		  				acop = "Dashboard displayed as expected";
		  				node.log(LogStatus.PASS, acop);
		  				data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  				rc++;
		  				excel.writePass(tc, counter, sheet, acop);
		  				
  				    }
  				  else
  				    {
  					  	System.out.println("Column Not Present");
	  				   	acop = "Dashboard NOT displayed as expected";
	  				  node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(tc, counter, sheet, acop,scr);
	  					
  				    }
  				    
  				 	}  				 	
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}
	  					}catch(Exception e)
	  					{e.printStackTrace();}
  				 	
	  				}
	  				
	  				if(tc.equalsIgnoreCase("TC12"))
	  				{
	  					try
	  					{
	  						System.out.println( "TC12 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
	  					System.out.println("before while");
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
		  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))	  				
		  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  				
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{	
		  				Thread.sleep(2000);
	  				
	  				boolean strFilterResult = false;
  				 	strFilterResult = CS.checkSortedValue(driver, Object, "302");
  				 	System.out.println("<<<<<<<<<<<<<<<<<<<<<Reefer AssetCommand History Status>>>>>>>>>>>>>"+strFilterResult);
  				 	if (strFilterResult == true)
  				 	{
  				 		System.out.println("Column Sorting Successful");
  				 		acop = "Column Sorting Successful";
  				 		node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(tc, counter, sheet, acop);	  					
  				 	}
  				 	else
  				 	{
  				 		System.out.println("Column Sorting Failed");
  				 		acop = "Column Sorting Failed";
  				 		node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(tc, counter, sheet, acop,scr);	  					
  				 	}
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}	
	  					}catch(Exception e)
	  					{e.printStackTrace();}
 		  			
	  				}
	  				
	  				if(tc.equalsIgnoreCase("TC13"))
	  				{
	  					try
	  					{
	  						System.out.println( "TC13 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();	  					
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
		  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))
		  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  			
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{	
		  				Thread.sleep(2000);		
						
						WebElement Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
						//List<WebElement> PageGroup = Pagination.findElements(By.tagName("ul"));
						List<WebElement> PageList = Pagination.findElements(By.tagName("li"));
						System.out.println("Size of the page"+PageList.size());
						
						for(int j=0;j<PageList.size();j++)
						{
							
							System.out.println(PageList.get(j).getText());
						}
						
						if(PageList.get(0).getText().equalsIgnoreCase("Prev") && PageList.get(PageList.size()-2).getText().equalsIgnoreCase("Next") && PageList.get(PageList.size()-1).getText().contains("Go To Page"))
						{
							
		  					
							System.out.println("Pagination Displayed Successfully");
							//System.out.println(Object.getProperty("DAPageDrpdown"));
							if(input[i][5].isEmpty())
							{
								acop = "Pagination Displayed as expected";
								node.log(LogStatus.PASS, acop);
	  		  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  		  					rc++;
	  		  					excel.writePass(tc, counter, sheet, acop);	  		  					
							}
							else
							{
								driver.findElement(By.xpath(Object.getProperty("PageDrpdown"))).click();
	  							Thread.sleep(2000);
	  							driver.findElement(By.xpath(Object.getProperty("PageValue"))).sendKeys(input[i][6]);
	  							driver.findElement(By.xpath(Object.getProperty("PageSelect"))).click();
	  							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  							Thread.sleep(1000);
	  							
	  							Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
	  							PageList = Pagination.findElements(By.tagName("li"));
	  							System.out.println(PageList.size());
	  							for(int j=0;j<PageList.size();j++)
	  							{
	  								//PageList.get(j).getAttribute("class");
		  							if(PageList.get(j).getText().equalsIgnoreCase(input[i][6]))
									{
		  								if(PageList.get(j).getAttribute("class").equalsIgnoreCase("active"))
		  								{
		  									System.out.println("Selected Page Displayed as expected");
		  										acop = "Selected Page Displayed as expected";
		  										node.log(LogStatus.PASS, acop);
		  			  		  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  			  		  					rc++;
		  			  		  					excel.writePass(tc, counter, sheet, acop);		  			  		  					
		  			  		  					break;
		  									}
		  									else
		  									{
		  										System.out.println("Current Page doesnot match the Page which is selected ");
		  			  		  					acop = "Pagination not displayed as expected";
		  			  		  				node.log(LogStatus.FAIL, acop);
		  			  		  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  			  		  					rc++;
		  			  		  				String scr = s.CaptureScreenshot();
		  			  		  					excel.writeFail(tc, counter, sheet, acop,scr);		  			  		  					
		  			  		  					break;
		  									}
		  								}
		  							}
							}
							
						}
						else
						{
							System.out.println("Pagination not Displayed ");
		  					acop = "Pagination not displayed as expected";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);		  					
						}
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}	
	  					}catch(Exception e)
	  					{e.printStackTrace();}
	  				
	  				}
	  			
	  				if(tc.equalsIgnoreCase("TC14"))
	  				{
	  					try
	  					{
	  						System.out.println( "TC14 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
	  					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();
	  					System.out.println("before while");
		  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  				
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  			Thread.sleep(1000);
		  			
		  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a"), driver))
	  				{
		  				driver.findElement(By.xpath(".//*[@id='div-300-datagrid-tbody']/tr[1]/td[2]/a")).click();
	  				}
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  				Thread.sleep(1000);
		  				
	  					Thread.sleep(3000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-302-datagrid-tbody']/tr"), driver))
	  					{	
		  				Thread.sleep(2000);
	  				
	  				int chkIndex=0;
  					String TotalPages =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
  					System.out.println("Total no. of Pages"+TotalPages);
  					String Records = "Null";
  				if(TotalPages.contains(" of "))
  				{
  					chkIndex=TotalPages.indexOf(" of ");
  					Records = TotalPages.substring(chkIndex+4);
  					
  					System.out.println("No. of Records"+Records);
  				}
	  				
	  				
	  				Select se = new Select(driver.findElement(By.id("per-page__select")));
		  			List<WebElement> l = se.getOptions();
		  			l.size();
		  			System.out.println("No.of Rows in dropdown"+l.size());
		  			driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
		  			Thread.sleep(1000);
		  			String[] dropVal = new String[l.size()+1];

	  			for(int click=1;click<=l.size();click++)
	  			{
	  			String dropDownVal = driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li["+click+"]")).getText();
	  			dropVal[click] = dropDownVal;
	  			System.out.println(dropVal[click]);
	  			}
	  			if (dropVal[1].equalsIgnoreCase("10 per page") && dropVal[2].equalsIgnoreCase("20 per page") && dropVal[3].equalsIgnoreCase("50 per page") &&
	  			dropVal[4].equalsIgnoreCase("100 per page") && dropVal[5].equalsIgnoreCase("200 per page") && dropVal[6].equalsIgnoreCase("300 per page"))
	  			{
	  			System.out.println("All the fields are present successfully.");
	  			}
	  			for(int sel=1;sel<=l.size();sel++)
	  			{
	  				/////////////////////Door Alarm has only 28 Records so here we are breaking the loop////////////////////
	  				if(sel==2)
	  				{
	  					break;
	  				} 
	  				////////////////////////////////////////////////////////////////////////////////////////////////////////////
		  			String [] pageCnt = dropVal[sel].split(" ");
		  			
		  			driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  			driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  			driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  			driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
		  			Thread.sleep(2000);
		  			driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li["+sel+"]")).click();
		  		while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  		 Thread.sleep(1000);
		  		
		  			WebElement ele = driver.findElement(By.xpath(".//*[@id='div-302-datagrid-tbody']"));
		  			System.out.println(ele.getTagName());
		  			List<WebElement>page=ele.findElements(By.tagName("tr"));
		  			System.out.println("PageSize : "+page.size());
		  			System.out.println(pageCnt[0]+"="+page.size());
		  			System.out.println(Records+":::::::::::"+page.size());
		  			if(page.size()<10)
		  			{
		  				if (Records.equals(""+page.size()))
		  				{
		  					System.out.println(page.size()+" Per page loaded successfully");
			  				 driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
			  				 driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
			  				 acop = page.size()+" Per Page Loaded successfully";
			  				 data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
			  				 rc++;
			  				 excel.writePass(tc, counter, sheet, acop);			  				
		  				}
		  				else
		  				{
		  					System.out.println(page.size()+" Per page not loaded");
			  				 driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
			  				 driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
			  				 acop = page.size()+" Per Page not Loaded successfully";
			  				node.log(LogStatus.FAIL, acop);
			  				 data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
			  				 rc++;
			  				String scr = s.CaptureScreenshot();
			  				 excel.writeFail(tc, counter, sheet, acop,scr);			  				
		  				}
		  			}
		  			else
		  			{
		  				
		  			 if (pageCnt[0].equals(""+page.size()))
		  			 {
		  				 System.out.println(page.size()+" Per page loaded successfully");
		  				 driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
		  				 driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
		  				 acop = page.size()+" Per Page Loaded successfully";
		  				node.log(LogStatus.PASS, acop);
		  				 data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  				 rc++;
		  				 excel.writePass(tc, counter, sheet, acop);		  				
		  			 }
		  			 else
		  			 {
		  				 System.out.println(page.size()+" Per page not loaded");
		  				 driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
		  				 driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
		  				 acop = page.size()+" Per Page not Loaded successfully";
		  				node.log(LogStatus.FAIL, acop);
		  				 data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  				 rc++;
		  				String scr = s.CaptureScreenshot();
		  				 excel.writeFail(tc, counter, sheet, acop,scr);		  				
		  			 }
		  			}
		  			 //
	  			}
	  					}else
	  					{
	  						acop = "No data";
  						  	node.log(LogStatus.PASS, acop);
  						  	data.put(""+rc, new Object[] {tc, "AssetCommandHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  						  	rc++;
  						  	excel.writePass(tc, counter, sheet, acop);  						  
	  					}	
	  					}catch(Exception e)
	  					{e.printStackTrace();}
	  				
	  				}
	  				
	  				
	  				
	  			}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			System.out.println("---------------------------------------------------------");
			driver.close();
			reports.endTest(node);
			reports.flush();
			return data;
		}
		
		
	}

}
