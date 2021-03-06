package dd_test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.LogisticUtils;
import dd_utils.TestUtil;

public class ReeferMultitemp extends TestCore 
{
	static TestUtil s =new TestUtil();
	static LogisticUtils Cs =new LogisticUtils();
		
	@Test
	public static Map<String, Object[]> reeferMultitemptestcases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase)
	{
		String acop =null;
		int counter =1;
		ExtentTest node = reports.startTest("ReefersMultiTemp");
		String[][] d1 =TestUtil.getData("ReefersMultiTemp");
		System.out.println("Reefer Multi-Temp Module");
		
		try
		{
			driver = new FirefoxDriver(s.excelDownload());
			
			driver.get(Object.getProperty("URL"));
			if(s.dologin(driver ,d1[0][2], d1[0][3]))
			{
			for(int i=scase-1;i<ecase;i++ )
			{
				
				long stime=System.currentTimeMillis();
				
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ESCAPE);
					Thread.sleep(200);
					robot.keyRelease(KeyEvent.VK_ESCAPE);
					
					if(d1[i][0].equalsIgnoreCase("TC1"))
	  				{
						try
						{
							System.out.println("TC1 Execution started.....");
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							{	
								//System.out.println("inside while");
								Thread.sleep(1000);
							}
							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							//System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							{		
								//System.out.println("inside while");
								Thread.sleep(1000);
							}
	  						Thread.sleep(5000);
	  						if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
	  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
	  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
	  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
	  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
	  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownloadAll")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempShowFilter")), driver)) ||
	  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempShowAll")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Compartment3")), driver)) ||
	  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
	  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempDashboard")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ViewMap")), driver)))
	  						{
	  							System.out.println("Page not loaded Successfully");
	  							acop = "Reefers MultiTemp Page not Loaded Successfully";
	  							node.log(LogStatus.FAIL, acop);
	  							data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  							rc++;
	  							String scr = s.CaptureScreenshot();
	  							excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  					
	  						}
	  						else
	  						{	
	  							System.out.println("Page loaded Successfully");
	  							acop = "Reefers MultiTemp Page Loaded Successfully";
	  							node.log(LogStatus.PASS, acop);
	  							data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  							rc++;
	  							excel.writePass(d1[i][0], counter, sheet, acop);	  							
	  						}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC1 Execution, it is because of page loading issue or due to some other issue");
							e.printStackTrace();}
	  				
	  				}
	  				
					
	  				if(d1[i][0].equalsIgnoreCase("TC2"))
	  				{
		  				try
		  				{
		  					System.out.println("TC2 Execution started.....");
	  					Thread.sleep(5000);
		  				driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  				driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
			  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			  			{	
		  					//System.out.println("inside while");
		  					Thread.sleep(1000);
			  			}
		  				driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
			  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			  			{	
			  				//System.out.println("inside while");
			  				Thread.sleep(1000);
			  			}
		  				driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(d1[i][5]);
		  				driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
			  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			  			{
	  						//System.out.println("inside while");
			  				Thread.sleep(1000);
			  			}
			  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
		  				{
		  					
			  				String Chk=driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).getText();
			  				//System.out.println(":::::::::::::::::::::"+Chk);
			  				//System.out.println(Chk.length());
		  					
			  				int pt=0;
			  				String cut="Null";
				  			if(Chk.contains("\n"))
				  			{
				  				pt=Chk.indexOf("\n");
				  				cut = Chk.substring(0, pt);
				  				//System.out.println("***************"+cut);
				  			}
				  			if(cut.equalsIgnoreCase(d1[i][5]))
				  			{
					  			System.out.println("Search value displayed Successfully");
				  				acop = "Selected search value"+ Chk +" displayed Successfully";
				  				node.log(LogStatus.PASS, acop);
				  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
				  				rc++;
				  				excel.writePass(d1[i][0], counter, sheet, acop);				  				
				  			}
				  			else
				  			{
				  				System.out.println("Search value not displayed ");
			  					acop = "Selected search value"+ Chk +" not displayed Successfully";
			  					node.log(LogStatus.FAIL, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
			  					rc++;
			  					String scr = s.CaptureScreenshot();
			  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);			  					
				  			}
		  				}
		  				else
		  				{
		  					System.out.println("Search Failed ... No data Found ");
		  				}
			  			driver.findElement(By.xpath(".//*[@id='btnClearSearch']")).click();
		  				//driver.findElement(By.xpath(Object.getProperty("ClearSearch"))).click();
			  			if(s.isAlertPresent(driver))
			  			{
			  				driver.switchTo().alert().accept();
			  			}		
			  			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  					{
	  						//System.out.println("inside while");
	  						Thread.sleep(1000);
	  					}
			  			
		  				}catch(Exception e)
		  				{node.log(LogStatus.SKIP, "Skipped TC2 Execution, it is because of page loading issue or due to some other issue");
		  					e.printStackTrace();}
	  				}
	  				
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC3"))
	  				{
	  					try
	  					{
	  						System.out.println("TC3 Execution started.....");
	  					String sDate =s.dateConvert(d1[i][6]);
		  				String eDate =s.dateConvert(d1[i][7]);
		  				
		  				Thread.sleep(5000);	  					
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  					
	  						Thread.sleep(1000);
	  					
	  					driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  					
  						Thread.sleep(1000);
	  					
	  					driver.findElement(By.xpath(Object.getProperty("EditDateRange"))).click();
	  					Thread.sleep(5000);
	  				if(s.isElementPresentcheck(By.xpath(Object.getProperty("StartDate")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("EndDate")),driver) 
	  					&& s.isElementPresentcheck(By.xpath(Object.getProperty("SetDateRange")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("DateCancel")),driver))
	  				{
	  					System.out.println("Edit date range pop up displayed Successfully");
	  				if(sDate.equalsIgnoreCase("NA"))
	  				{
	  					acop = "Edit date range window should open.";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  					
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
	  					//String[] arrSplit = strMain.split(" to ");
	  					int chkIndex=0;
	  					String TotalPages =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
	  					//System.out.println(TotalPages);
	  					String Records="Null";
	  				if(TotalPages.contains(" of "))
	  				{
	  					chkIndex=TotalPages.indexOf(" of ");
	  					Records = TotalPages.substring(chkIndex+4);
	  					//System.out.println(Records);
	  				}
	  							
	  				if(Records.equalsIgnoreCase("0"))
	  				{
	  					System.out.println("No data found for the event Search");	
	  					acop = "No data";
	  					node.log(LogStatus.PASS, acop);
	  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  	  				rc++;
	  	  				excel.writePass(d1[i][0], counter, sheet, acop);	  	  				
	  					
	  				}
	  				else
	  				{
	  					String EndDateGet = driver.findElement(By.xpath(Object.getProperty("MultiTempLstCntDate"))).getText();
	  					driver.findElement(By.xpath(Object.getProperty("MultiTempLstCnt"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  	  			{	
	  	  				//System.out.println("inside while");
	  	  				Thread.sleep(1000);
	  	  			}
	  					String StartDateGet = driver.findElement(By.xpath(Object.getProperty("MultiTempLstCntDate"))).getText();
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
	  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  	  				rc++;
	  	  				excel.writePass(d1[i][0], counter, sheet, acop);
	  	  				
	  		  		}
	  		  		else
	  		  		{
	  		  			System.out.println("Search value not displayed ");
	  	  				acop = "Date not in range";
	  	  				node.log(LogStatus.FAIL, acop);
	  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  	  				rc++;
	  	  				String scr = s.CaptureScreenshot();
	  	  				excel.writeFail(d1[i][0], counter, sheet, acop,scr);
	  	  				
	  		  		}
	  							
	  				}
	  				}
	  				}
	  				else
	  				{
	  					System.out.println("Edit date range pop up not displayed");
  						acop = "Edit date range window not yet opened.";
  						node.log(LogStatus.FAIL, acop);
  						data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
  						rc++;
  						String scr = s.CaptureScreenshot();
  						excel.writeFail(d1[i][0], counter, sheet, acop,scr);  						
	  				}
	  					s.clearDateRange(driver, Object);
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  					{
  						System.out.println("inside while");
  						Thread.sleep(1000);
  					}
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC3 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
	  				}
	  				
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC4"))
	  				{
	  					try
	  					{
	  					System.out.println("TC4 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  						
  						Thread.sleep(1000);
	  				
	  					driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  				
  						Thread.sleep(1000);
	  			
	  					String totalRecords =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
	  					driver.findElement(By.xpath(Object.getProperty("MultiTempShowFilter"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  					
  						Thread.sleep(1000);
	  			
						
	  				if(s.isElementPresentcheck(By.xpath(Object.getProperty("YardDrpdwn")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("LoadStatusDrpdwn")), driver) 
	  					&& s.isElementPresentcheck(By.xpath(Object.getProperty("AlertsDrpdwn")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferPowerdrpdwn")), driver) 
	  					&& s.isElementPresentcheck(By.xpath(Object.getProperty("AlarmsDrpDwn")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempFilterApply")), driver)
	  					&& s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempFilterCancel")), driver))
	  				{
	  					System.out.println("Filter Popup window opened Successfully");
	  					driver.findElement(By.xpath(Object.getProperty("AlertsDrpdwn"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("LowBattery"))).click();
	  					System.out.println("Filter values entered");
	  					driver.findElement(By.xpath(Object.getProperty("MultiTempFilterCancel"))).click();
	  					String ChkRecords =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
	  					System.out.println(totalRecords+"::"+ChkRecords);
	  					if(totalRecords.equalsIgnoreCase(ChkRecords))
	  					{
	  						System.out.println("show filter cancel button working as expected");
	  						acop = "cancel button working as expected";
	  						node.log(LogStatus.PASS, acop);
		  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
		  	  				rc++;
		  	  				excel.writePass(d1[i][0], counter, sheet, acop);		  	  				
	  					}
	  					else
	  					{
			  	  			System.out.println("Show filter Cancel Button not working as expected");
	  						acop = "Cancel button not working as Expected";
	  						node.log(LogStatus.FAIL, acop);
		  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
		  	  				rc++;
		  	  				String scr = s.CaptureScreenshot();
		  	  				excel.writeFail(d1[i][0], counter, sheet, acop,scr);		  	  				
	  					}
	  				}
	  				else
	  				{
	  					acop = "Filter Popup window not Displayed Successfully";
	  					node.log(LogStatus.FAIL, acop);
	  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  	  				rc++;
	  	  				String scr = s.CaptureScreenshot();
	  	  				excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  	  				
	  				}
	  				
	  				driver.findElement(By.xpath(Object.getProperty("MultiTempShowFilter"))).click();
	  				boolean strFilterResult = false;
					strFilterResult = Cs.impact(driver, Object, "105", "loadStatus", "10", true, "Text", "MultiTempFilterApply","MultiTempClearFilter");
					System.out.println("<<<<<<<<<<<<<<<<<<<<<Load Status Filter Status>>>>>>>>>>>>>"+strFilterResult);
					if(strFilterResult==true)
					{
						System.out.println("Load Status data filter is working as expected");
  						acop = "Load Status data filter is working as expected";
  						node.log(LogStatus.PASS, acop);
	  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  	  				rc++;
	  	  				excel.writePass(d1[i][0], counter, sheet, acop);	  	  				
					}
					else
					{
						System.out.println("Load Status data filter is not working as expected");
  						acop = "Load Status data filter is not working as expected";
  						node.log(LogStatus.FAIL, acop);
	  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  	  				rc++;
	  	  				String scr = s.CaptureScreenshot();
	  	  				excel.writeFail(d1[i][0], counter, sheet, acop,scr);
	  	  				System.out.println( "###################Test case 4 execution failed############################");
					}
					strFilterResult = Cs.alarm(driver, Object, "105", "activeAlarmStatus", "4", false, "Text", "MultiTempFilterApply","MultiTempClearFilter");				
					System.out.println("<<<<<<<<<<<<<<<<<<<<<Alarm Filter Status>>>>>>>>>>>>>"+strFilterResult);
					if(strFilterResult==true)
					{
						System.out.println("Alarm data filter is working as expected");
  						acop = "Alarm data filter is working as expected";
  						node.log(LogStatus.PASS, acop);
	  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  	  				rc++;
	  	  				excel.writePass(d1[i][0], counter, sheet, acop);	  	  				
					}
					else
					{
						System.out.println("Alarm data filter is not working as expected");
  						acop = "Alarm data filter is not working as expected";
  						node.log(LogStatus.FAIL, acop);
	  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  	  				rc++;
	  	  				String scr = s.CaptureScreenshot();
	  	  				excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  	  				
					}
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC4 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}

	  					
	  				}
	  				
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC5"))
	  				{
	  					try
	  					{
	  						System.out.println("TC5 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  					
  							Thread.sleep(1000);
	  					
	  					driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  					
  						Thread.sleep(1000);
	  					
	  					driver.findElement(By.xpath(Object.getProperty("Comp3ChkBox"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  					
	  				if(s.isElementPresentcheck(By.xpath(Object.getProperty("Temperature3")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("Power3")), driver)
	  					&& s.isElementPresentcheck(By.xpath(Object.getProperty("SetPoint3")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("ReturnTemperature3")), driver)
	  					&& s.isElementPresentcheck(By.xpath(Object.getProperty("DischargeTemp3")), driver))
	  					
	  				{
	  					System.out.println("Compartment 3 is displaying as expected");
  						acop = "Compartment 3 is displaying as expected";
  						node.log(LogStatus.PASS, acop);
	  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  	  				rc++;
	  	  				excel.writePass(d1[i][0], counter, sheet, acop);	  	  				
	  				}
	  				else
	  				{
	  					System.out.println("Compartment 3 is not displaying as expected");
  						acop = "Compartment 3 is not displaying as expected";
  						node.log(LogStatus.FAIL, acop);
	  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  	  				rc++;
	  	  				String scr = s.CaptureScreenshot();
	  	  				excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  	  				
	  				}
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC5 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
	  				}
	  				
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC6"))
	  				{
	  					try
	  					{
	  						System.out.println("TC6 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  				
  						Thread.sleep(1000);
  				
	  					driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  				
	  					Thread.sleep(3000);

	  					List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-105-datagrid']/div/table[1]/thead/tr[2]"));
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
	  				 	
	  				 	String strMain = d1[i][5];
		  				String[] arrSplit4 = strMain.split(",");
		  				
		  				int cnt = 0;
	  				   
		  				for(int rnum=0;rnum<arrSplit4.length;rnum++)
		  				{
			  				for(String string : rowData)
			  				{
			  					if(string.equalsIgnoreCase(arrSplit4[rnum]))
			  					{
			  						cnt++;
			  						
			  					}
			  					
			  					
			  				}
			  				
	  				   }
		  				
		  				if(cnt==arrSplit4.length)
	  				    {
	  				    	System.out.println("All Column is Present");
			  				acop = "Dashboard displayed as expected";
			  				node.log(LogStatus.PASS, acop);
			  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
			  				rc++;
			  				excel.writePass(d1[i][0], counter, sheet, acop);
			  				
	  				    }
	  				  else
	  				    {
	  					  	System.out.println("Column Not Present");
		  				   	acop = "Dashboard NOT displayed as expected";
		  				   	node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  					
	  				    }
	  				    
	  				 	}
	  				 
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC6 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}

	  				}
	  				//End of Test Case 6
	  				
	  			// Test Case 7
	  				if(d1[i][0].equalsIgnoreCase("TC7"))
	  				{
	  					try
	  					{
	  						System.out.println("TC7 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  					
	  					driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  					
	  					driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(d1[i][5]);
	  					driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  					
	  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
	  				{
	  					driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
	  				}                                
	  				else
	  				{
	  					System.out.println("Search Failed ... No data Found ");
	  				}
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  					{
	  					System.out.println("inside while");
  						Thread.sleep(1000);
  					}
	  					//Thread.sleep(3000);
	  					String pageNo = driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
	  					int pointToCut=0;
	  					String totalRecord="Null";
	  				if(pageNo.contains(" of "))
	  				{
	  					pointToCut=pageNo.indexOf(" of ");
	  					totalRecord = pageNo.substring(pointToCut+4);
	  					//System.out.println(totalRecord);
	  				}
	  				else
	  				{
	  					//System.out.println("Error!!!!!!"+pageNo);
	  				}
	  				if(totalRecord.equalsIgnoreCase("0"))
	  				{
	  					System.out.println("No Record Found");
	  					acop = "No Record Found";
	  					node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
						rc++;
						String scr = s.CaptureScreenshot();
						excel.writePass(d1[i][0], counter, sheet, acop);
  						
  						Thread.sleep(5000);
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  					
	  				}
	  				else
	  				{
	  					System.out.println("Asset History displayed successfully");
	  					acop = "Asset History displayed as expected";
	  					node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
						rc++;
						String scr = s.CaptureScreenshot();
						excel.writePass(d1[i][0], counter, sheet, acop);						
	  				}
	  				
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  					
	  				driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  				
  						Thread.sleep(1000);
  					
	  				driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  				
	  				driver.findElement(By.xpath(".//*[@id='btnClearSearch']")).click();
	  				
	  				if(s.isAlertPresent(driver))		  			
		  				driver.switchTo().alert().accept();
		  					
	  				
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC7 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}	  				
	  					
	  				}
	  				 
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC8"))
                    {
	  					try
	  					{
                          System.out.println("TC8 Execution started.....");
                           Thread.sleep(5000);
                           driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
                           Thread.sleep(5000);
                           driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
                           driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
                           while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))                          
                                  Thread.sleep(1000);
                          
                           driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
                           while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))                           
                                  Thread.sleep(1000);
                          
                           String parentHandle = driver.getWindowHandle(); // get the current window handle
                       // System.out.println(parentHandle);               //Prints the parent window handle .
                        String valChk = driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr[1]/td[13]/a")).getText();
                        //String trimVal = valChk.trim();
                        String mysz2 = valChk.replaceAll(",\\s",",");
                      //  System.out.println(mysz2);
                        Thread.sleep(8000);
                        driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr[1]/td[14]/a")).click();
                        Thread.sleep(5000);
                        for (String winHandle : driver.getWindowHandles()) 
                        { //Gets the new window handle
                            System.out.println(winHandle);
                        }
                        //Thread.sleep(4000);//Clicking on this window
                        for (String winHandle : driver.getWindowHandles()) 
                        { //Gets the new window handle
                        //    System.out.println(winHandle);
                            driver.switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)             
                        }
                        int count=0;
                        while(!s.isElementPresentcheck(By.xpath(".//*[@id='map']/div/div[1]/div[4]/div[4]/div[1]/h2"), driver))
                        {
                        	count++;
                        	Thread.sleep(2000);
                        	if(count>=10)
                        	{
                        		break;
                        	}
                        }
                             //Thread.sleep(6000);
                        String pageNav="";
                        if(count<10)
                        {
                            WebElement htmltable=driver.findElement(By.cssSelector(".map__window>ul"));
                            //System.out.println(htmltable.getAttribute("value"));
                           //htmltable = htmltable.findElement(By.tagName("ul"));
                           List<WebElement> rows=htmltable.findElements(By.tagName("li"));
                         //  System.out.println("No. of Rows in the WebTable: "+rows.size());
                           //System.out.println(rows);
                           //System.out.println("CHK1");
                   // for(int rnum=1;rnum<=rows.size();rnum++)
                   // {
                          
                           pageNav = driver.findElement(By.cssSelector(".-location")).getText();
                           //String pageNav = driver.findElement(By.xpath(".//*[@id='map']/div/div[1]/div[4]/div[4]/div[2]/ul/li["+rnum+"]")).getAttribute("value");
                          // System.out.println(pageNav);
                        }
                           if (pageNav.equals(mysz2))
                           {
                                  System.out.println("Location Loded Successfully");
                                  acop = "Location Loded Successfully";
                                  node.log(LogStatus.PASS, acop);
                                  data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
                                  rc++;
                                  excel.writePass(d1[i][0], counter, sheet, acop);                                
                           }
                           else
                           {
                                  System.out.println("Location not loaded");
                                  acop = "Location not loaded";
                                  node.log(LogStatus.FAIL, acop);
                                  data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
                                  rc++;
                                  String scr = s.CaptureScreenshot();
                                  excel.writeFail(d1[i][0], counter, sheet, acop,scr);                                  
                           }
                        
                    //}
                    driver.close();
                    driver.switchTo().window(parentHandle);
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC8 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
                    }
	  			
	  				if(d1[i][0].equalsIgnoreCase("TC9"))
	  				{
	  					try
	  					{
	  						System.out.println("TC9 Execution started.....");
	  						Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(3000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  			
  						Thread.sleep(1000);
  					
	  					
	  					driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  				
  						Thread.sleep(1000);
  					
	  					driver.findElement(By.xpath(Object.getProperty("RefreshIcon"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  				
	  				if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
		  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
		  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
		  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
		  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
		  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownloadAll")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempShowFilter")), driver)) ||
		  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempShowAll")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Compartment3")), driver)) ||
		  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
		  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempDashboard")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ViewMap")), driver)))
	  				{
	  					System.out.println("Page not Re-loaded Successfully");
	  					acop = "MultiTemp Page Re-Loading Failed";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});  
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  					
	  				}
	  				else
	  				{
	  					System.out.println("Page Re-loaded Successfully");
	  					acop = "MultiTemp Page Re-Loaded Successfully";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(d1[i][0], counter, sheet, acop);	  					
	  				}
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC9 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
	  				
	  				}
	  				
	  				if (d1[i][0].equalsIgnoreCase("TC10"))
                    {
	  					try
	  					{
                          System.out.println("TC10 Execution started.....");
                           Thread.sleep(5000);
                           driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
                           Thread.sleep(3000);
                           driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
                           driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
                           while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))                          
                                  Thread.sleep(1000);
                        
                           driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
                           while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))                          
                                  Thread.sleep(1000);
                          
                          
                           driver.findElement(By.xpath(".//*[@id='table-col-105--all-none']/label/span[2]/span")).click();
                           while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))                         
                                  Thread.sleep(1000);
                         
                          
                           String parentHandle = driver.getWindowHandle(); // get the current window handle
                      //  System.out.println(parentHandle);               //Prints the parent window handle
                        driver.findElement(By.xpath(Object.getProperty("ViewMap"))).click();
                        Thread.sleep(4000);//Clicking on this window
                        for (String winHandle : driver.getWindowHandles()) { //Gets the new window handle
                           // System.out.println(winHandle);
                            driver.switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)             
                        }
                      if(s.isElementPresentcheck(By.xpath(Object.getProperty("MapVerification")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("PrintMap")),driver)
                                        && s.isElementPresentcheck(By.xpath(Object.getProperty("ShowAll")),driver))
                                  {
                                  System.out.println("All the filds are present in the Map view");
                                         acop = "MultiTemp Map View Loaded Successfully";
                                         node.log(LogStatus.PASS, acop);
                                         data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
                                         rc++;
                                         excel.writePass(d1[i][0], counter, sheet, acop);
                                  }
                      else
                      {
                             System.out.println("Mismatch Found");
                           acop = "MultiTemp Map View not Loaded Successfully";
                           node.log(LogStatus.FAIL, acop);
                           data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
                           rc++;
                           String scr = s.CaptureScreenshot();
                           excel.writeFail(d1[i][0], counter, sheet, acop,scr);
                      }
                      
                     driver.findElement(By.xpath(Object.getProperty("PrintMap"))).click();
                    Thread.sleep(3000);
                    Robot r = new Robot();
                    r.keyPress(KeyEvent.VK_ESCAPE);
                    Thread.sleep(200);
                    r.keyRelease(KeyEvent.VK_ESCAPE);
                     driver.findElement(By.xpath(".//*[@id='map_list']/ul/li[1]/a")).click();
                    Thread.sleep(1000);           
                     driver.findElement(By.xpath(Object.getProperty("ShowAll"))).click();
                    
                    Thread.sleep(2000);
                     if(s.isElementPresentcheck(By.xpath(Object.getProperty("MapVerification")),driver))
                    {
                           System.out.println("Show All is working as expected");
                           acop = "MultiTemp Map View all the asset maps Loaded Successfully";
                           node.log(LogStatus.PASS, acop);
                           data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
                           rc++;
                           excel.writePass(d1[i][0], counter, sheet, acop);
                    }
                    else
                    {
                           System.out.println("Show All is not working");
                           acop = "MultiTemp Show All is not working";
                           node.log(LogStatus.FAIL, acop);
                           data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
                           rc++;
                           String scr= s.CaptureScreenshot();
                           excel.writeFail(d1[i][0], counter, sheet, acop,scr);
                    }
                     driver.findElement(By.xpath(".//*[@id='map']/div/div/div[10]/div[2]/div[1]")).click();
                    Thread.sleep(5000);
                     driver.findElement(By.xpath(".//*[@id='map']/div/div/div[10]/div[3]/div")).click();
                    Thread.sleep(5000);
                   
                    //Now your driver works on the current new handle
                    //Do some work here.....
                    //Time to go back to parent window
                        driver.close();                           // close newly opened window when done with it
                        driver.switchTo().window(parentHandle);
                      System.out.println( "###################Test case 10 Execution completed############################");
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC10 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
                    }
	  				
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC11"))
	  				{
	  					try
	  					{
	  						System.out.println("TC11 Execution started.....");
	  						Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(3000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  				
	  					
	  					driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  				
	  					driver.findElement(By.xpath(Object.getProperty("PrintIcon"))).click();
	  					Thread.sleep(5000);
	  					ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	  					
	  					//System.out.println(tabs2.get(0));
	  					//System.out.println(driver.getWindowHandle());
	  					
	  					driver.switchTo().window(tabs2.get(1));
	  					
	  					System.out.println(tabs2.get(1));
	  					System.out.println(driver.getWindowHandle());
	  					
	  				if(s.isElementPresentcheck(By.xpath("html/body/table"), driver))
	  				{
	  					System.out.println("Print page displayed");
	  					acop = "Print page displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(d1[i][0], counter, sheet, acop);	  						
	  				}
	  				else
	  				{
	  					System.out.println("Print page not displayed");
	  					acop = "Print Page not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;	  					
	  					String scr= s.CaptureScreenshot();
	  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  					
	  				}
	  					//Robot robot = new Robot();
	  					robot.keyPress(KeyEvent.VK_ESCAPE);
	  					Thread.sleep(200);
	  					robot.keyRelease(KeyEvent.VK_ESCAPE);
	  					Thread.sleep(2000);
	  					
	  					driver.close(); 
	  					Thread.sleep(2000);
	  					
	  					driver.switchTo().window(tabs2.get(0));
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC11 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
	  					
	  				}
	  				
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC12"))
	  				{
	  					try
	  					{
	  						System.out.println("TC12 Execution started.....");
	  					ArrayList<String> tr=new ArrayList<String>();
	  				 	int pageSize=0,recordsCount=0;
	  				 	
	  					
	  				 	Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(3000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
  							Thread.sleep(1000);
	  					 					
	  					driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  					
	  						Thread.sleep(1000);
	  					
	  					driver.findElement(By.xpath(Object.getProperty("ExcelDownload"))).click();
	  					Thread.sleep(5000);
	  					
	  					WebElement ele = driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']"));
		  			 	List<WebElement>page=ele.findElements(By.tagName("tr"));
		  			 	//Thread.sleep(7000);
		  			 	pageSize=page.size();
		  			 	try
		  			 	{
		  			 	BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\Multi-TempReport.xls"));
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
		  			//  System.out.println(recordsCount);
		  			 	}
		  			 	catch (Exception e)
		  			 	{
		  			 	
		  			 	e.printStackTrace();
		  			 	
		  			 	}
		  			//  System.out.println(recordsCount+":"+pageSize);
		  			 	if(recordsCount == pageSize)
		  			 	{
		  			 		System.out.println("Reocrds count matching... Pass");
		  			 	
				  			acop = "Count Matching";
				  			node.log(LogStatus.PASS, acop);
				  			data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
				  			rc++;
				  			excel.writePass(d1[i][0], counter, sheet, acop);				  			
		  			 	}
		  			 	else
		  			 	{
			  			 	System.out.println("Records count mismatch... Fail");
			  			 	acop = "Count mismatch";
			  			 	node.log(LogStatus.FAIL, acop);
			  			 	data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
			  			 	rc++;
			  			 	String scr = s.CaptureScreenshot();
			  			 	excel.writeFail(d1[i][0], counter, sheet, acop,scr);			  			 	
		  			 	}	 
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC12 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
	  					
	  				}
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC13"))
	  				{
	  					try
	  					{
	  					System.out.println("TC13 Execution started.....");
	  					ArrayList<String> tr=new ArrayList<String>();
	  				 	int pageSize=0,recordsCount=0;
	  				 	int chkIndex=0;
	  				 	String Records="Null";	  				 	
	  					
	  				 	Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(3000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  				
	  					
	  					driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  				
  						Thread.sleep(1000);
  					
	  				String TotalPages =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
	  				System.out.println(TotalPages);
	  				if(TotalPages.contains(" of "))
	  				{
	  					chkIndex=TotalPages.indexOf(" of ");
	  					Records = TotalPages.substring(chkIndex+4);	  				
	  				}
	  				
	  					int Record = Integer.parseInt(Records);
	  					System.out.println("Number of Records"+Record);
	  					driver.findElement(By.xpath(Object.getProperty("ExcelDownloadAll"))).click();	  					
	  					Thread.sleep(8000);
	  					
	  					/*WebElement ele = driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']"));
		  			 	List<WebElement>page=ele.findElements(By.tagName("tr"));
		  			 	pageSize=page.size();*/
		  			 /*	try
		  			 	{
		  			 	BufferedReader reader = new BufferedReader(new FileReader("\\\\amxserver\\amx-share\\STW_QA\\Rtweb Automation\\Downloaded Excel\\Multi-TempReport-All.csv "));
		  			 	String line;
		  			 	
		  			 	int m=0;
		  			 	while ((line = reader.readLine()) != null)
		  			 	{
		  			 	 			 	
		  			 	if(line.contains("<tr"))
		  			 		tr.add(line);		  			  
		  			 	m++;
		  			 	}
		  			 	reader.close();		  			 	
		  			 	recordsCount=tr.size();	
		  			 	System.out.println(recordsCount);
		  			 	}
		  			 	
		  			 	catch (Exception e)
		  			 	{
		  			 	e.printStackTrace();		  			 	
		  			 	}*/
		  			 	
		  			 /*	if(Record>10000)									
							Record = 10000;*/
		  			
	  					CSVReader reader = new CSVReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\Multi-TempReport-All.csv"));
	  					 
	  					 // this will load content into list
	  					  List<String[]> li=reader.readAll();
	  					  System.out.println("Total rows which we have is "+li.size());
	  					  recordsCount = li.size()-1;
	  					  
		  			 	if(recordsCount == Record)
		  			 	{
		  			 		System.out.println("Reefers MultiTemp Download-All downloaded successfully");
		  			 		 acop = "Reefers MultiTemp Download-All downloaded successfully";
				  			node.log(LogStatus.PASS, acop);
				  			data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
				  			rc++;
				  			excel.writePass(d1[i][0], counter, sheet, acop);				  			
		  			 	}
		  			 	else
		  			 	{
		  			 		System.out.println("Count mismatch");
			  			 	acop = "Count mismatch";
			  			 	node.log(LogStatus.FAIL, acop);
			  			 	data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
			  			 	rc++;
			  			 	String scr =s.CaptureScreenshot();
			  			 	excel.writeFail(d1[i][0], counter, sheet, acop,scr);			  			 	
		  			 	}
	  					}
		  			 	catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC13 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
	  				}
	  				//End of Test Case 13	
	  				
	  			//Test Case 14
	  				if(d1[i][0].equalsIgnoreCase("TC14"))
	  				{
	  					try
	  					{
	  						System.out.println("TC14 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  					
	  				if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers") ,Object.getProperty("MultiTemp"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
	  				{
	  					System.out.println("Time zone Displayed Successfully");
	  					acop = "Time zone displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(d1[i][0], counter, sheet, acop);	  					
	  				}
	  				else
	  				{
	  					System.out.println("Time zone not Displayed ");
	  					acop = "Time zone not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  					
	  				}
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC14 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
	  					
	  				}
	  				//End of Test Case 14	
	  				
	  			//Test Case 15
	  				if(d1[i][0].equalsIgnoreCase("TC15"))
	  				{
	  					try
	  					{
	  						System.out.println("TC15 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  				
	  					Thread.sleep(1000);
	  				
	  				if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("MultiTemp"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
	  				{
	  					System.out.println("Temperature Unit Displayed Successfully");
	  					acop = "Temperature Unit displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(d1[i][0], counter, sheet, acop);	  					
	  				}
	  				else
	  				{
	  					System.out.println("Temperature Unit not Displayed ");
	  					acop = "Temperature Unit not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  					
	  				}
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC15 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
	  				}
	  				//End of Test case 15
	  				
	  			//Test Case 16
	  				if(d1[i][0].equalsIgnoreCase("TC16"))
	  				{
	  					try
	  					{	
	  						System.out.println("TC16 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  				
	  					Thread.sleep(1000);
	  				
	  				if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("MultiTemp"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
	  				{
	  					System.out.println("Fuel Level Displayed Successfully");
	  					acop = "Fuel Level displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(d1[i][0], counter, sheet, acop);	  					
	  				}
	  				else
	  				{
	  					System.out.println("Fuel Level not Displayed ");
	  					acop = "Fuel Level not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  					
	  				}
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC16 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
	  				}
	  				
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC17"))
	  				{
	  					try
	  					{
	  						System.out.println("TC17 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  				
	  					Thread.sleep(1000);
	  			
	  				if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("MultiTemp"), Object.getProperty("DistanceCalcIcon"), Object.getProperty("DistanceTooltip"), Object.getProperty("DistanceTooltipval"), Object.getProperty("DistanceUnit")))
	  				{
	  					System.out.println("Distance Unit Displayed Successfully");
	  					acop = "Distance Unit displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(d1[i][0], counter, sheet, acop);	  					
	  				}
	  				else
	  				{
	  					System.out.println("Distance Unit not Displayed ");
	  					acop = "Distance Unit not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  					
	  				}
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC17 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
	  				}
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC18"))
	  				{
	  					try
	  					{
	  					System.out.println("TC18 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  					
	  					driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
  						Thread.sleep(1000);
  					
	  					Thread.sleep(3000);
	  					
	  				if((s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)))
	  				{
	  					
	  					System.out.println("Control Probe loaded Successfully");
	  					acop = "Control Probe displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(d1[i][0], counter, sheet, acop);	  					
	  				}
	  				else
	  				{	
	  					System.out.println("Control Probe not loaded Successfully");
	  					acop = "Control Probe not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  					
	  				}
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC18 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
	  				}
	  				
	  				//End of Test Case 18
	  				
	  			//Test Case 19
	  				if(d1[i][0].equalsIgnoreCase("TC19"))
	  				{
	  					try
	  					{
	  						System.out.println("TC19 Execution started.....");
	  					Thread.sleep(5000);
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
					
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
						Thread.sleep(1000);
			
  						driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
						Thread.sleep(1000);
					
  					
  					
  					boolean strFilterResult = false;
  				 	strFilterResult = Cs.checkSortedValue(driver, Object, "105");
  				 //	System.out.println("<<<<<<<<<<<<<<<<<<<<<Reefers MultiTemp  Status>>>>>>>>>>>>>"+strFilterResult);
  				 	if (strFilterResult == true)
  				 	{
  				 		System.out.println("PASSSSSSSSSSSSSS");
  				 		acop = "Column Sorting Successful";
  				 		node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(d1[i][0], counter, sheet, acop);	  				
  				 	}
  				 	else
  				 	{
  				 		System.out.println("FAILLLLLLLLLLLLLLLLL");
  				 		acop = "Column Sorting Failed";
  				 		node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  					
  				 	}
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC19 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
  						
  				}
				//End of Test Case 19
	  				
	  			//Test Case 20
	  				if(d1[i][0].equalsIgnoreCase("TC20"))
	  				{
	  					try
	  					{
	  						System.out.println("TC20 Execution started.....");
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
						Thread.sleep(1000);
					
  						driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
						Thread.sleep(1000);
				
  						Thread.sleep(1000);	
  						
  						WebElement Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
  						//List<WebElement> PageGroup = Pagination.findElements(By.tagName("ul"));
  						List<WebElement> PageList = Pagination.findElements(By.tagName("li"));
  						//System.out.println("Size of the page"+PageList.size());
  						
  						for(int j=0;j<PageList.size();j++)
  						{
  							
  							System.out.println(PageList.get(j).getText());
  						}
  						
  						if(PageList.get(0).getText().equalsIgnoreCase("Prev") && PageList.get(PageList.size()-2).getText().equalsIgnoreCase("Next") && PageList.get(PageList.size()-1).getText().contains("Go To Page"))
  						{
  							
  		  					
  							//System.out.println("Pagination Displayed Successfully");
  							//System.out.println(Object.getProperty("PageDrpdown"));
  							if(d1[i][5].isEmpty())
  							{
  								acop = "Pagination Displayed as expected";
  								node.log(LogStatus.PASS, acop);
  	  		  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
  	  		  					rc++;
  	  		  					excel.writePass(d1[i][0], counter, sheet, acop);  	  		  					
  							}
  							else
  							{
  								driver.findElement(By.xpath(Object.getProperty("PageDrpdown"))).click();
  	  							Thread.sleep(2000);
  	  							driver.findElement(By.xpath(Object.getProperty("PageValue"))).sendKeys(d1[i][5]);
  	  							driver.findElement(By.xpath(Object.getProperty("PageSelect"))).click();
  	  							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  	  							{
  	  								System.out.println("inside while");
  	  								Thread.sleep(1000);
  	  							}
  	  							Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
  	  							PageList = Pagination.findElements(By.tagName("li"));
  	  							//System.out.println(PageList.size());
  	  							for(int j=0;j<PageList.size();j++)
  	  							{
  	  								//PageList.get(j).getAttribute("class");
  		  							if(PageList.get(j).getText().equalsIgnoreCase(d1[i][5]))
  									{
  		  								if(PageList.get(j).getAttribute("class").equalsIgnoreCase("active"))
  		  								{
  		  										acop = "Selected Page Displayed as expected";
  		  										node.log(LogStatus.PASS, acop);
  		  			  		  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
  		  			  		  					rc++;
  		  			  		  					excel.writePass(d1[i][0], counter, sheet, acop);
  		  			  		  					break;
  		  									}
  		  									else
  		  									{
  		  										System.out.println("Current Page doesnot match the Page which is selected ");
  		  			  		  					acop = "Pagination not displayed as expected";
  		  			  		  					node.log(LogStatus.FAIL, acop);
  		  			  		  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
  		  			  		  					rc++;
  		  			  		  					String scr= s.CaptureScreenshot();
  		  			  		  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);  		  			  		  					
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
  		  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
  		  					rc++;
  		  					String scr= s.CaptureScreenshot();
  		  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);  		  					
  						}
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC20 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
	  				}
	  			//End of Test Case 20
	  				
	  			//Test Case 21
		  			if(d1[i][0].equalsIgnoreCase("TC21"))
		  			{
		  				try
		  				{
		  			 	System.out.println("TC21 Execution started.....");
		  			 	Thread.sleep(5000);
		  			  driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  			  driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  			  driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  			  while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  			 	
		  			 	Thread.sleep(1000);
		  			
		  			  driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
		  			  while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  			 	
		  			 	Thread.sleep(1000);
		  			
			  			Select se = new Select(driver.findElement(By.id("per-page__select")));
		  			  	//Select se = new Select(driver.findElement(By.cssSelector("#per-page__select")));
			  			List<WebElement> l = se.getOptions();
			  			l.size();
			  			System.out.println("No.of Rows in dropdown"+l.size());
			  			driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
			  			Thread.sleep(1000);
			  			String[] dropVal = new String[l.size()+1];
	
		  			for(int click=1;click<=l.size();click++)
		  			{
		  			String dropDownVal = driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li["+click+"]")).getText();
		  			dropVal[click] = dropDownVal;
		  			//System.out.println(dropVal[click]);
		  			}
		  			if (dropVal[1].equalsIgnoreCase("10 per page") && dropVal[2].equalsIgnoreCase("20 per page") && dropVal[3].equalsIgnoreCase("50 per page") &&
		  			dropVal[4].equalsIgnoreCase("100 per page") && dropVal[5].equalsIgnoreCase("200 per page") && dropVal[6].equalsIgnoreCase("300 per page"))
		  			{
		  			//System.out.println("All the fields are present successfully.");
		  			}
		  			for(int sel=1;sel<=l.size();sel++)
		  			{
		  				/////////////////////Door Alarm has only 28 Records so here we are breaking the loop////////////////////
		  				/*if(sel==3)
		  				{
		  					break;
		  				}*/
		  				////////////////////////////////////////////////////////////////////////////////////////////////////////////
			  			String [] pageCnt = dropVal[sel].split(" ");
			  			driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
			  			driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
			  			driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
			  			driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
			  			Thread.sleep(2000);
			  			driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li["+sel+"]")).click();
			  		while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			  		{	
			  			// System.out.println("inside while");
			  			 Thread.sleep(1000);
			  		}
			  			WebElement ele = driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']"));
			  			//System.out.println(ele.getTagName());
			  			List<WebElement>page=ele.findElements(By.tagName("tr"));
			  			//System.out.println("PageSize : "+page.size());
			  		//	System.out.println(pageCnt[0]+"="+page.size());
			  			 if (pageCnt[0].equals(""+page.size()))
			  			 {
			  				 System.out.println(page.size()+" Per page loaded successfully");
			  				 driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
			  				 driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
			  				 acop = page.size()+" Per Page Loaded successfully";
			  				node.log(LogStatus.PASS, acop);
			  				 data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
			  				 rc++;
			  				 excel.writePass(d1[i][0], counter, sheet, acop);			  				
			  			 }
			  			 else
			  			 {
			  				 System.out.println(page.size()+" Per page not loaded");
			  				 driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
			  				 driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
			  				 acop = page.size()+" Per Page not Loaded successfully";
			  				 node.log(LogStatus.FAIL, acop);
			  				 data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
			  				 rc++;
			  				 String scr = s.CaptureScreenshot();
			  				 excel.writeFail(d1[i][0], counter, sheet, acop,scr);			  				 
			  			 }
		  			}
		  				}catch(Exception e)
		  				{node.log(LogStatus.SKIP, "Skipped TC21 Execution, it is because of page loading issue or due to some other issue");
		  					e.printStackTrace();}
	  			 	
	  			 	}
	  			//End of Test Case 21
		  			
		  		//Test Case 22
	  				if(d1[i][0].equalsIgnoreCase("TC22"))
                    {
	  					try
	  					{
                          System.out.println("TC22 Execution started.....");
                           Thread.sleep(5000);
                           driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
                           driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
                           driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
                           while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))                         
                              Thread.sleep(1000);
                      
                           driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
                           while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))                         
                              Thread.sleep(1000);
                           
                           driver.findElement(By.xpath(".//*[@id='table-col-105--all-none']/label/span[2]/span")).click();
                           while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))                          
                              Thread.sleep(1000);
                       
                           List <WebElement> selectElements= driver.findElements(By.cssSelector(".cls-checked"));
                          // System.out.println(">>>>>>>>>>>>>>>"+selectElements.size());
                           int rowCount = 0;
                           Map<String,String> arr = new TreeMap<>();
                           //ArrayList <String> arrRowList = new ArrayList <String>();
                           for(int ij=0;ij<selectElements.size();ij++)
                           {                                                     
                              System.out.println("id::>>"+ij+"<<"+selectElements.get(ij).getAttribute("id"));

                           if( (selectElements.get(ij).isSelected())&&!(selectElements.get(ij).getAttribute("id").equalsIgnoreCase(""))&&!(selectElements.get(ij).getAttribute("id").startsWith("select-All-Column")))
                           {
                              //  System.out.println("Check box selected");
                                rowCount = rowCount + 1;
                                //arrRowList.add(selectElements.get(ij).getAttribute("id"));
                                arr.put(selectElements.get(ij).getAttribute("id"), selectElements.get(ij).getAttribute("id"));
                           }
                           else
                           {
                              System.out.println("Check box NOT selected");
                           }
                             
                           }
                          // System.out.println("row count:"+ rowCount);
                         //  System.out.println("Map Size: "+arr.size());
                           String chkVal = driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
                           String [] getVal = chkVal.split(" - ");
                           System.out.println(getVal[1]);
                           String [] finalVal = getVal[1].split(" of ");
                           System.out.println(finalVal[0]);
                           if (finalVal[0].equals(""+arr.size()))
                           {
                              System.out.println("Select All is working as expected");
                              acop = " All None is working";
                              node.log(LogStatus.PASS, acop);
                              data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
                              rc++;
                              excel.writePass(d1[i][0], counter, sheet, acop);                             
                           }
                           else
                           {
                        	  System.out.println("All none is not working");
                              acop = "All none is not working as expected ";
                              node.log(LogStatus.FAIL, acop);
                              data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
                              rc++;
                              String scr = s.CaptureScreenshot();
                              excel.writeFail(d1[i][0], counter, sheet, acop,scr);                            
                           }
                           }catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC22 Execution, it is because of page loading issue or due to some other issue");
                        	   e.printStackTrace();}
	  					
                    }
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC23"))
                    {
	  					try
	  					{
                           System.out.println("TC23 Execution started.....");
                           Thread.sleep(5000);
                           driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
                           driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
                           driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
                           while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))                           
                              Thread.sleep(1000);
                     
                           driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
                           while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))                         
                              Thread.sleep(1000);
                          
		                   driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(d1[i][5]);
		                   driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		                   while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		                   
   		  					Thread.sleep(1000);
		                
   		  					String Fleet = driver.findElement(By.xpath(Object.getProperty("MultiTempFleet"))).getText();
   		  					driver.findElement(By.xpath(Object.getProperty("MultiTempSnapshot"))).click();
   		  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		                   
   		  						Thread.sleep(1000);
		             
   		  							  					
		  					
   		  					if(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempReport")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("MaintenanceStatusReport")), driver)
   		  					  && s.isElementPresentcheck(By.xpath(Object.getProperty("PreTripReport")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("AlarmReport")), driver) 
   		  					  && s.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationReport")), driver))
   		  					{
   		  					System.out.println("All Reports are Present");
                            acop = "All Reports are Present";
                            node.log(LogStatus.PASS, acop);
                            data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
                            rc++;
                            excel.writePass(d1[i][0], counter, sheet, acop);                           
   		  					}
   		  					else
   		  					{
   		  					System.out.println(" Reports not Present");
                            acop = "Reports not Present";
                            node.log(LogStatus.FAIL, acop);
                            data.put(""+rc, new Object[] {d1[i][0], "ReefersMultiTemp", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
                            rc++;
                            String scr = s.CaptureScreenshot();
                            excel.writeFail(d1[i][0], counter, sheet, acop,scr);                            
   		  					}
   		  				
   		  				
		  				
		  			
	  					}catch(Exception e)
	  					{node.log(LogStatus.SKIP, "Skipped TC23 Execution, it is because of page loading issue or due to some other issue");
	  						e.printStackTrace();}
   		  				
                           
                    }
	  				
	  				
	  				
	  				
	  			}
				
			}
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("---------------------------------------------------------");		
		reports.endTest(node);
		reports.flush();
		driver.close();
		return data;
		
	}

}

				
