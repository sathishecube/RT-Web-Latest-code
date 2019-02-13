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

public class ReeferMaintenance extends TestCore 
{
	static TestUtil s =new TestUtil();
	static LogisticUtils Cs =new LogisticUtils();
		
	@Test
	public static Map<String, Object[]> reeferMaintenancetestcases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase)
	{
		String acop =null;
		int counter =1;
		ExtentTest node = reports.startTest("ReefersMaintenance");
		String[][] d1 =TestUtil.getData("ReefersMaintenance");
		
		try
		{
			driver = new FirefoxDriver(s.excelDownload());
			driver.get(Object.getProperty("URL"));
			if(s.dologin(driver ,d1[0][2], d1[0][3]))
			{		
				System.out.println("Reefer Maintenance Module");
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
							driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();							
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);
							if(s.isElementPresent(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
		  					{
							if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("MaintenanceDashboard")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("MaintenanceShowFilter")), driver)))
							{
								System.out.println("Page not loaded Successfully");
								acop = "Reefers Maintenance Page not Loaded Successfully";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);
								
							}
							else
							{	
								System.out.println("Page loaded Successfully");
								acop = "Reefers Maintenance Page Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
								
							}		
		  					}else
		  					{
		  						System.out.println("No data found");
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
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
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
							
							driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
							
							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(d1[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
							if(s.isElementPresent(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
		  					{
							
							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr/td[2]/a"), driver))
							{
  					
								String Chk=driver.findElement(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr/td[2]/a")).getText();
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
								if(Chk.equalsIgnoreCase(d1[i][5]))
								{
									System.out.println("Search value displayed Successfully");
									acop = "Selected search value"+ Chk +" displayed Successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(d1[i][0], counter, sheet, acop);
									
								}
								else
								{
									System.out.println("Search value not displayed ");
									acop = "Selected search value"+ Chk +" not displayed Successfully";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(d1[i][0], counter, sheet, acop,scr);
									
								}
							}
							else
							{
								System.out.println("Search Failed ... No data Found ");
							}
		  					}else
		  					{
		  						System.out.println("No data found");
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
		  						
		  					}
							driver.findElement(By.xpath(Object.getProperty("ClearSearch"))).click();
							if(s.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
							}	
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
														
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC2 Execution, it is because of page loading issue or due to some other issue");
							e.printStackTrace();}
					}
  				
  				
  				if(d1[i][0].equalsIgnoreCase("TC3"))
  				{
  					try
  					{
  					String sDate =s.dateConvert(d1[i][6]);
	  				String eDate =s.dateConvert(d1[i][7]);
	  				
	  				System.out.println("TC3 Execution started.....");
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
  					driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"
  						+ ""), driver))
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
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
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
  					node.log(LogStatus.PASS, acop);
  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
  	  				rc++;
  	  				excel.writePass(d1[i][0], counter, sheet, acop);  	  				
  					
  				}
  				else
  				{
  					String EndDateGet = driver.findElement(By.xpath(Object.getProperty("MaintenanceMsgTimeDate"))).getText();
  					driver.findElement(By.xpath(Object.getProperty("MaintenanceMsgTime"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  	  			Thread.sleep(1000);
  	  			
  					String StartDateGet = driver.findElement(By.xpath(Object.getProperty("MaintenanceMsgTimeDate"))).getText();
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
  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
  	  				rc++;
  	  				excel.writePass(d1[i][0], counter, sheet, acop);  	  				
  		  		}
  		  		else
  		  		{
  		  			System.out.println("Search value not displayed ");
  	  				acop = "Date not in range";
  	  				node.log(LogStatus.FAIL, acop);
  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
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
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
						rc++;
						String scr = s.CaptureScreenshot();
						excel.writeFail(d1[i][0], counter, sheet, acop,scr);						
  				}
  					s.clearDateRange(driver, Object);
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
				}else
				{
					System.out.println("No data found");
					acop = "No data";
					node.log(LogStatus.PASS, acop);
					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
					rc++;
					excel.writePass(d1[i][0], counter, sheet, acop);
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
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
  				driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				Thread.sleep(1000);
  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
				{ 
  				String totalRecords =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
  				driver.findElement(By.xpath(Object.getProperty("MaintenanceShowFilter"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
  								
					
  				if(s.isElementPresentcheck(By.xpath(Object.getProperty("FilterFuelSensorDrpdwn")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("MaintenanceFilterApply")), driver) 
  						&& s.isElementPresentcheck(By.xpath(Object.getProperty("MaintenanceFilterCancel")), driver))
  				{
  					System.out.println("Filter Popup window opened Successfully");
  					//driver.findElement(By.xpath(Object.getProperty("ImpactShowFilters"))).click();
  					driver.findElement(By.xpath(Object.getProperty("FilterFuelSensorDrpdwn"))).click();
  					driver.findElement(By.xpath(Object.getProperty("Razor20"))).click();
  					System.out.println("Filter values entered");
  					driver.findElement(By.xpath(Object.getProperty("MaintenanceFilterCancel"))).click();
  					String ChkRecords =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
  					System.out.println(totalRecords+"::"+ChkRecords);
  					if(totalRecords.equalsIgnoreCase(ChkRecords))
  					{
  						System.out.println("show filter cancel button working as expected");
  						acop = "cancel button working as expected";
  						node.log(LogStatus.PASS, acop);
	  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
	  	  				rc++;
	  	  				excel.writePass(d1[i][0], counter, sheet, acop);
	  	  				
  					}
  					else
  					{
		  	  			System.out.println("Show filter Cancel Button not working as expected");
  						acop = "Cancel button not working as Expected";
  						node.log(LogStatus.FAIL, acop);
	  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
	  	  				rc++;
	  	  				String scr = s.CaptureScreenshot();
	  	  				excel.writeFail(d1[i][0], counter, sheet, acop,scr);
	  	  				
  					}
  				}
  				else
  				{
  					acop = "Filter Popup window not Displayed Successfully";
  					node.log(LogStatus.FAIL, acop);
  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
  	  				rc++;
  	  				String scr = s.CaptureScreenshot();
  	  				excel.writeFail(d1[i][0], counter, sheet, acop,scr);
  	  				
  				}
  				driver.findElement(By.xpath(Object.getProperty("MaintenanceShowFilter"))).click();
  				boolean strFilterResult = false;
				strFilterResult = Cs.disparity(driver, Object, "101", "fuelSensorType", "17", true, "Text", "MaintenanceFilterApply","MaintenanceClearFilter");
				System.out.println("<<<<<<<<<<<<<<<<<<<<<Fuel Level Filter Status>>>>>>>>>>>>>"+strFilterResult);
				if(strFilterResult==true)
				{
					System.out.println("Fuel Sensor data filter is working as expected");
						acop = "Fuel Sensor data filter is working as expected";
						node.log(LogStatus.PASS, acop);
  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
  	  				rc++;
  	  				excel.writePass(d1[i][0], counter, sheet, acop);  	  				
				}
				else
				{
					System.out.println("Maintenance Type data filter is not working as expected");
						acop = "Fuel Sensor data filter is not working as expected";
						node.log(LogStatus.FAIL, acop);
  	  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
  	  				rc++;
  	  				String scr = s.CaptureScreenshot();
  	  				excel.writeFail(d1[i][0], counter, sheet, acop,scr);  	  				
				}
  					
  					}else
  					{
  						System.out.println("No data found");
						acop = "No data";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);
  					}
  					}catch(Exception ex)
  					{node.log(LogStatus.SKIP, "Skipped TC4 Execution, it is because of page loading issue or due to some other issue");
  						ex.printStackTrace();
  						driver.findElement(By.xpath(Object.getProperty("MaintenanceFilterCancel"))).click();
  					}
  				}
  				
  				
  				if(d1[i][0].equalsIgnoreCase("TC5"))
  				{
  					try
  					{
  						Thread.sleep(10000);
  						System.out.println("TC5 Execution started.....");
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
					
  					driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  					
  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
					{
  					driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
					if(s.isElementPresentcheck(By.xpath(Object.getProperty("ErrorMsg")), driver))
					{
						String errormsg =driver.findElement(By.xpath(Object.getProperty("ErrorMsg"))).getText();
						String errormsg1 ="Please select a Asset";
						if(errormsg.equalsIgnoreCase(errormsg1))
							System.out.println("Error Message Matching");
						else
							System.out.println("Error Msg Missmatch");
						
					}
					else
						System.out.println("Error message not found");
					
					
					driver.findElement(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr/td[1]/label/span[2]/span")).click();
					driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
					boolean CheckActions = true;
					if(s.isElementPresentcheck(By.xpath(Object.getProperty("ClearAlarms")), driver)
							&& s.isElementPresentcheck(By.xpath(Object.getProperty("ReadAllIntelliset")), driver)
							&& s.isElementPresentcheck(By.xpath(Object.getProperty("ChangePM")), driver) 
							&& s.isElementPresentcheck(By.xpath(Object.getProperty("MicroRead")), driver))
					{
						System.out.println("All Elements are Present in MoreActions");
						WebElement moreActionsList = driver.findElement(By.xpath(".//*[@id='btn-moreaction-cmd']/div/ul"));
						List<WebElement> moreActions = moreActionsList.findElements(By.tagName("li"));
						ArrayList<String> Actions = new ArrayList<String>();
						for(WebElement row : moreActions)
						{
							if(!row.getText().equalsIgnoreCase(" "))
							{
								System.out.println(row.getText());
								Actions.add(row.getText().toString());
							}
						}
						driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
						for(String string: Actions)
						{
							System.out.println(string);
							switch(string)
							{
							case "Clear Alarms":
							{
								Thread.sleep(8000);
								
								driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
								if(s.isElementPresentcheck(By.xpath(Object.getProperty("ErrorMsg")), driver))
								{
									driver.findElement(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr/td[1]/label/span[2]/span")).click();
								}
								driver.findElement(By.xpath(".//*[@id='btn-clear-alarms-cmd']/button")).click();
								
								if(s.isElementPresentcheck(By.xpath(Object.getProperty("ClearAlarm")), driver) 
										&& s.isElementPresentcheck(By.xpath(Object.getProperty("AlarmSendCommand")), driver)
										&& s.isElementPresentcheck(By.xpath(Object.getProperty("AlarmCancel")), driver))
								{
									System.out.println("####################Clear Alarms Displayed as Expected###################");
								}
								else
								{
									System.out.println("####################Clear Alarms NOT Displayed as Expected###################");
									CheckActions=false;
								}
								driver.findElement(By.xpath(Object.getProperty("AlarmCancel"))).click();
								Thread.sleep(5000);
								break;
							}
							case "Read All Intelliset":
							{								
								driver.findElement(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr/td[1]/label/span[2]/span")).click();
								driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();								
								driver.findElement(By.xpath(Object.getProperty("ReadAllIntelliset"))).click();
								
								if(s.isElementPresentcheck(By.xpath(Object.getProperty("ReadAllIntelliset1")), driver) 
										&& s.isElementPresentcheck(By.xpath(Object.getProperty("IntellisetSendCommand")), driver)
										&& s.isElementPresentcheck(By.xpath(Object.getProperty("IntellisetCancel")), driver))
								{
									System.out.println("####################Read Intelliset Displayed as Expected###################");
								}
								else
								{
									System.out.println("####################Read Intelliset NOT Displayed as Expected###################");
									CheckActions=false;
								}
								driver.findElement(By.xpath(Object.getProperty("IntellisetCancel"))).click();
								Thread.sleep(5000);
								break;
							}
							case "Change PM Hours":
							{
								driver.findElement(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr/td[1]/label/span[2]/span")).click();
								driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();								
								driver.findElement(By.xpath(Object.getProperty("ChangePM"))).click();
								
								if(s.isElementPresentcheck(By.xpath(Object.getProperty("NewPMHours")), driver) 
										&& s.isElementPresentcheck(By.xpath(Object.getProperty("chgpmhrsbtn")), driver)
										&& s.isElementPresentcheck(By.xpath(Object.getProperty("chgpmhrcncl")), driver))
								{
									System.out.println("####################Change PM Hours Displayed as Expected###################");
								}
								else
								{
									System.out.println("####################Change PM Hours NOT Displayed as Expected###################");
									CheckActions=false;
								}
								driver.findElement(By.xpath(Object.getProperty("chgpmhrcncl"))).click();
								Thread.sleep(5000);
								break;
							}
							case "Micro Read":
							{
								driver.findElement(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr/td[1]/label/span[2]/span")).click();
								driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
								
								if(!s.isElementPresentcheck(By.xpath(Object.getProperty("ErrorMsg")), driver))
								{
									System.out.println("####################Micro Read Command Displayed as Expected###################");
								}
								else
								{
									System.out.println("####################Micro Read Command NOT Displayed as Expected###################");
									CheckActions=false;
								}
								Thread.sleep(5000);
								break;
							}
							default:break;
						}
					}
					if(CheckActions == true)
					{
						System.out.println("############More Actions Displaying as Expected##############");
						acop = "More Actions Working as expected";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance", d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);						
					}
					else
					{
						System.out.println("############More Actions Not Displaying as Expected##############");
						acop = "More Actions NOT Working as expected";
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance", d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
						rc++;
						String scr = s.CaptureScreenshot();
						excel.writeFail(d1[i][0], counter, sheet, acop,scr);
					
					}
				}
				else
				{
					System.out.println("Element Missing in More Action");
					acop = "More Actions Elements are Missing";
					node.log(LogStatus.FAIL, acop);
					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance", d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
					rc++;
					String scr = s.CaptureScreenshot();
					excel.writeFail(d1[i][0], counter, sheet, acop,scr);				
				}					
					}else
					{
						System.out.println("No data found");
						acop = "No data";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);
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
  					Thread.sleep(3000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				Thread.sleep(1000);
					
  					driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
  					Thread.sleep(3000);
  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
					{

  					List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-101-datagrid']/div/table[1]/thead/tr[2]"));
  				 	List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();

  				 	for(WebElement row:rows)
  				 	{
  				 	List<WebElement> rowElements = row.findElements(By.xpath("th"));

  				 	ArrayList<String> rowData = new ArrayList<String>();
  				 	
  				 	for(WebElement column:rowElements)
  				 	{
  				 	   rowData.add(column.getText().toString());
  				 	 System.out.println("rowData Values are"+rowData);

  				 	}
  				 	System.out.println("rowData  Size "+rowData.size());
  				 	String strMain = d1[i][5];
	  				String[] arrSplit4 = strMain.split(",");
	  				System.out.println(arrSplit4);
	  				int cnt = 0;
  				    for(int rnum=0;rnum<arrSplit4.length;rnum++)
  				    {
  				    	System.out.println(arrSplit4[rnum]);
  				    if (rowData.contains(arrSplit4[rnum]))
  				    {
  				    	cnt++;	  				       	
  				    }
  				    else
  				    {
  				    	System.out.println("**********************Count Failed**********************");
  				    }
  				    }
  				    if(cnt==arrSplit4.length)
  				    {
  				    	
  				    	System.out.println("All Column is Present");
		  				acop = "Dashboard displayed as expected";
		  				node.log(LogStatus.PASS, acop);
		  				data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
		  				rc++;
		  				excel.writePass(d1[i][0], counter, sheet, acop);
		  				
  				    }
  				  else
  				    {
  				    	
  				    	
  					  System.out.println("Column Not Present");
	  				   	acop = "Dashboard displayed as expected";
	  				  node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);
	  					
  				    }
  				 	} 
					}else
					{
						System.out.println("No data found");
						acop = "No data";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);
					}
  					}catch(Exception e)
  					{node.log(LogStatus.SKIP, "Skipped TC6 Execution, it is because of page loading issue or due to some other issue");
  						e.printStackTrace();}

  				}
  				
  				if(d1[i][0].equalsIgnoreCase("TC7"))
  				{
  					try
  					{
  						System.out.println("TC7 Execution started.....");
  					Thread.sleep(5000);
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					Thread.sleep(3000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
  					
  					driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
				{
  					driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(d1[i][5]);
  					driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr/td[2]/a"), driver))
  				{
  					driver.findElement(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr/td[2]/a")).click();
  				}                                
  				else
  				{
  					System.out.println("Search Failed ... No data Found ");
  				}
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
  					//Thread.sleep(3000);
  					String pageNo = driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
  					int pointToCut=0;
  					String totalRecord="Null";
  				if(pageNo.contains(" of "))
  				{
  					pointToCut=pageNo.indexOf(" of ");
  					totalRecord = pageNo.substring(pointToCut+4);
  					System.out.println(totalRecord);
  				}
  				else
  				{
  					System.out.println("Error!!!!!!"+pageNo);
  				}
  				if(totalRecord.equalsIgnoreCase("0"))
  				{
  					System.out.println("No Record Found");
  					acop = "No Record Found";
  					node.log(LogStatus.PASS, acop);
					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
					rc++;
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
					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
					rc++;
					excel.writePass(d1[i][0], counter, sheet, acop);
				
  				}
  				
  				
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
  				driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
  				driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);
					
  				driver.findElement(By.xpath(Object.getProperty("ClearSearch"))).click();
  				
  				if(s.isAlertPresent(driver))
	  			{
	  				driver.switchTo().alert().accept();
	  			}
				}else
				{
					System.out.println("No data found");
					acop = "No data";
					node.log(LogStatus.PASS, acop);
					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
					rc++;
					excel.writePass(d1[i][0], counter, sheet, acop);
				}
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
  					Thread.sleep(3000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  				Thread.sleep(1000);
					
  					
  					driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
				{
					
  					driver.findElement(By.xpath(Object.getProperty("RefreshIcon"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				Thread.sleep(1000);
					
  				if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
			  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
			  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
			  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
			  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
			  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
			  				!(s.isElementPresentcheck(By.xpath(Object.getProperty("MaintenanceDashboard")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("MaintenanceShowFilter")), driver)))
  				{
  					System.out.println("Page not Re-loaded Successfully");
  					acop = "Reefers Maintenance Page Re-Loading Failed";
  					node.log(LogStatus.FAIL, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
  					rc++;
  					String scr = s.CaptureScreenshot();
  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);  					
  				}
  				else
  				{
  					System.out.println("Page Re-loaded Successfully");
  					acop = "Reefers Maintenance Page Re-Loaded Successfully";
  					node.log(LogStatus.PASS, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
  					rc++;
  					excel.writePass(d1[i][0], counter, sheet, acop);  				
  				}
				}else
				{
					System.out.println("No data found");
					acop = "No data";
					node.log(LogStatus.PASS, acop);
					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
					rc++;
					excel.writePass(d1[i][0], counter, sheet, acop);
				}
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
					
  					
  					driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				Thread.sleep(1000);
					
  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
				{
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
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
  					rc++;
  					excel.writePass(d1[i][0], counter, sheet, acop);  						
  				}
  				else
  				{
  					System.out.println("Print page not displayed");
  					acop = "Print Page not displayed as expected";
  					node.log(LogStatus.FAIL, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
  					rc++;
  					String scr = s.CaptureScreenshot();
  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);  					
  				}
  					//Robot robot = new Robot();
  					robot.keyPress(KeyEvent.VK_ESCAPE);
  					Thread.sleep(200);
  					robot.keyRelease(KeyEvent.VK_ESCAPE);
  					driver.close(); 
  					driver.switchTo().window(tabs2.get(0));
				}else
				{
					System.out.println("No data found");
					acop = "No data";
					node.log(LogStatus.PASS, acop);
					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
					rc++;
					excel.writePass(d1[i][0], counter, sheet, acop);
				}
  					}catch(Exception e)
  					{node.log(LogStatus.SKIP, "Skipped TC9 Execution, it is because of page loading issue or due to some other issue");
  						e.printStackTrace();}
  					
  					
  				}
  				
  				if(d1[i][0].equalsIgnoreCase("TC10"))
  				{
  					try
  					{
  					ArrayList<String> tr=new ArrayList<String>();
  				 	int pageSize=0,recordsCount=0;
  				 	
  				 	System.out.println("TC10 Execution started.....");
  					Thread.sleep(5000);
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					Thread.sleep(3000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				Thread.sleep(1000);
				
  					
  					driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				Thread.sleep(1000);
				
  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
				{
  					driver.findElement(By.xpath(Object.getProperty("ExcelDownload"))).click();
  					
  					WebElement ele = driver.findElement(By.xpath(".//*[@id='div-101-datagrid-tbody']"));
	  			 	System.out.println(ele.getTagName());
	  			 	List<WebElement>page=ele.findElements(By.tagName("tr"));
	  			 	System.out.println("PageSize : "+page.size());
	  			 	//System.out.println("PageSize : "+pageSize);
	  			 	pageSize=page.size();
	  			 	try
	  			 	{
	  			 	BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\MaintenanceReport.xls"));
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
	  			 	
			  			acop = "Reefers Maintenance Print window opened successfully";
			  			node.log(LogStatus.PASS, acop);
			  			data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
			  			rc++;
			  			excel.writePass(d1[i][0], counter, sheet, acop);			  			
	  			 	}
	  			 	else
	  			 	{
		  			 	System.out.println("Records count mismatch... Fail");
		  			 	acop = "Count mismatch";
		  			 	node.log(LogStatus.FAIL, acop);
		  			 	data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
		  			 	rc++;
		  			 	String scr = s.CaptureScreenshot();
		  			 	excel.writeFail(d1[i][0], counter, sheet, acop,scr);		  			 	
	  			 	}
				}
  				else
  				{
  					System.out.println("No data found");
					acop = "No data";
					node.log(LogStatus.PASS, acop);
					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
					rc++;
					excel.writePass(d1[i][0], counter, sheet, acop);
  				}
  					}catch(Exception e)
  					{node.log(LogStatus.SKIP, "Skipped TC10 Execution, it is because of page loading issue or due to some other issue");
  						e.printStackTrace();}
  				}
  			
  				if(d1[i][0].equalsIgnoreCase("TC11"))
  				{
  					try
  					{
  					ArrayList<String> tr=new ArrayList<String>();
  				 	int pageSize=0,recordsCount=0;
  				 	int chkIndex=0;
  				 	String Records="Null";
  				 	
  				 	System.out.println("TC11 Execution started.....");
  					Thread.sleep(5000);
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					Thread.sleep(3000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
				
  					
  					driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
				{
  				String TotalPages =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
  				System.out.println(TotalPages);
  				if(TotalPages.contains(" of "))
  				{
  					chkIndex=TotalPages.indexOf(" of ");
  					Records = TotalPages.substring(chkIndex+4);
  					System.out.println(Records);
  				}
  				//Integer.parseInt(myBuilderOrBuffer.toString());
  					int Record = Integer.parseInt(Records);
					System.out.println("Number of Records "+Record);
					driver.findElement(By.xpath(Object.getProperty("ExcelDownloadAll"))).click();	  					
					Thread.sleep(9000);
	  			 	
	  			 		CSVReader reader = new CSVReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\MaintenanceReport-All.csv"));
	  			 	/*String line;
	  			 	
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
	  			 	
	  			 	recordsCount=tr.size()-3;
	  			  System.out.println(recordsCount);*/
	  			 		List<String[]> li=reader.readAll();
	  			 		System.out.println("Total rows which we have is "+li.size());
	  			 		recordsCount = li.size()-1;
	  			 	
	  					  System.out.println(recordsCount+":"+Record);
	  			 	if(recordsCount == Record)
	  			 	{
	  			 		System.out.println("Reefers Maintenance Download-All downloaded successfully");
	  			 	
			  			acop = "Reefers Maintenance Download-All downloaded successfully";
			  			data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
			  			rc++;
			  			excel.writePass(d1[i][0], counter, sheet, acop);			  			
	  			 	}
	  			 	else
	  			 	{
		  			 	System.out.println("Reefers Maintenance Download-All downloaded successfully but the counts are not matching");
		  			 	acop = "Count mismatch";
		  			 	data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
		  			 	rc++;
		  			 	String scr =s.CaptureScreenshot();
		  			 	excel.writeFail(d1[i][0], counter, sheet, acop,scr);		  			 
	  			 	}	 
				}
  				else
  				{
  					System.out.println("No data found");
					acop = "No data";
					node.log(LogStatus.PASS, acop);
					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
					rc++;
					excel.writePass(d1[i][0], counter, sheet, acop);
  				}
  					}catch(Exception e)
  					{node.log(LogStatus.SKIP, "Skipped TC11 Execution, it is because of page loading issue or due to some other issue");
  						e.printStackTrace();}
  				}
  				
  				if(d1[i][0].equalsIgnoreCase("TC12"))
  				{
  					try
  					{
  						System.out.println("TC12 Execution started.....");
  					Thread.sleep(5000);
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					Thread.sleep(3000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
  				//if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
				//{
  				if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers") ,Object.getProperty("Maintenance"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
  				{
  					System.out.println("Time zone Displayed Successfully");
  					acop = "Time zone displayed as expected";
  					node.log(LogStatus.PASS, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
  					rc++;
  					excel.writePass(d1[i][0], counter, sheet, acop);  					
  				}
  				else
  				{
  					System.out.println("Time zone not Displayed ");
  					acop = "Time zone not displayed as expected";
  					node.log(LogStatus.FAIL, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
  					rc++;
  					String scr = s.CaptureScreenshot();
  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);  					
  				}
				//}
  				//else
  				//{
  				//	System.out.println("No data found");
				//	acop = "No data";
				//	node.log(LogStatus.PASS, acop);
				//	data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
				//	rc++;
				//	excel.writePass(d1[i][0], counter, sheet, acop);
  				//}
  					}catch(Exception e)
  					{
  						node.log(LogStatus.SKIP, "Skipped TC12 Execution, it is because of page loading issue or due to some other issue");e.printStackTrace();}
  					
  				}
  				
  				if(d1[i][0].equalsIgnoreCase("TC13"))
  				{
  					try
  					{
  						System.out.println("TC13 Execution started.....");
  					Thread.sleep(5000);
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					Thread.sleep(3000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  				Thread.sleep(1000);
  				
  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
				{
  				if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("Maintenance"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
  				{
  					System.out.println("Temperature Unit Displayed Successfully");
  					acop = "Temperature Unit displayed as expected";
  					node.log(LogStatus.PASS, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
  					rc++;
  					excel.writePass(d1[i][0], counter, sheet, acop);  					
  				}
  				else
  				{
  					System.out.println("Temperature Unit not Displayed ");
  					acop = "Temperature Unit not displayed as expected";
  					node.log(LogStatus.FAIL, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
  					rc++;
  					String scr = s.CaptureScreenshot();
  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);  					
  				}
  					}else
  					{
  						System.out.println("No data found");
						acop = "No data";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);
  					}
  					
  					}catch(Exception e)
  					{node.log(LogStatus.SKIP, "Skipped TC13 Execution, it is because of page loading issue or due to some other issue");
  						e.printStackTrace();}
  				}
  				
  				if(d1[i][0].equalsIgnoreCase("TC14"))
  				{
  					try
  					{
  						System.out.println("TC14 Execution started.....");
  					Thread.sleep(5000);
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					Thread.sleep(3000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  				Thread.sleep(1000);
  				
  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
				{
  				if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("Maintenance"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
  				{
  					System.out.println("Fuel Level Displayed Successfully");
  					acop = "Fuel Level displayed as expected";
  					node.log(LogStatus.PASS, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
  					rc++;
  					excel.writePass(d1[i][0], counter, sheet, acop);  					
  				}
  				else
  				{
  					System.out.println("Fuel Level not Displayed ");
  					acop = "Fuel Level not displayed as expected";
  					node.log(LogStatus.FAIL, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
  					rc++;
  					String scr = s.CaptureScreenshot();
  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);  					
  				}
				}else
				{
					System.out.println("No data found");
					acop = "No data";
					node.log(LogStatus.PASS, acop);
					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
					rc++;
					excel.writePass(d1[i][0], counter, sheet, acop);
				}
  					}catch(Exception e)
  					{node.log(LogStatus.SKIP, "Skipped TC14 Execution, it is because of page loading issue or due to some other issue");
  						e.printStackTrace();}
  				}
  				
  				if(d1[i][0].equalsIgnoreCase("TC15"))
  				{
  					try
  					{
  						System.out.println("TC15 Execution started.....");
  					Thread.sleep(5000);
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					Thread.sleep(3000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  				Thread.sleep(1000);
  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
				{
  				if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("Maintenance"), Object.getProperty("DistanceCalcIcon"), Object.getProperty("DistanceTooltip"), Object.getProperty("DistanceTooltipval"), Object.getProperty("DistanceUnit")))
  				{
  					System.out.println("Distance Unit Displayed Successfully");
  					acop = "Distance Unit displayed as expected";
  					node.log(LogStatus.PASS, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
  					rc++;
  					excel.writePass(d1[i][0], counter, sheet, acop);
  					
  				}
  				else
  				{
  					System.out.println("Distance Unit not Displayed ");
  					acop = "Distance Unit not displayed as expected";
  					node.log(LogStatus.FAIL, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
  					rc++;
  					String scr= s.CaptureScreenshot();
  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);
  					
  				}
  					}else
  					{
  						System.out.println("No data found");
						acop = "No data";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);
  					}
  					}catch(Exception e)
  					{node.log(LogStatus.SKIP, "Skipped TC15 Execution, it is because of page loading issue or due to some other issue");
  						e.printStackTrace();}
  				}
  				
  				if(d1[i][0].equalsIgnoreCase("TC16"))
  				{
  					try
  					{
  						System.out.println("TC16 Execution started.....");
  					Thread.sleep(5000);
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					Thread.sleep(3000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
  					driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
  				if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
				{
					
  					Thread.sleep(3000);
  					
  				if((s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)))
  				{
  					
  					System.out.println("Control Probe loaded Successfully");
  					acop = "Control Probe displayed as expected";
  					node.log(LogStatus.PASS, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
  					rc++;
  					excel.writePass(d1[i][0], counter, sheet, acop);  					
  				}
  				else
  				{	
  					System.out.println("Control Probe not loaded Successfully");
  					acop = "Control Probe not displayed as expected";
  					node.log(LogStatus.FAIL, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
  					rc++;
  					String scr = s.CaptureScreenshot();
  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);  					
  				}
				}else
				{
					System.out.println("No data found");
					acop = "No data";
					node.log(LogStatus.PASS, acop);
					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
					rc++;
					excel.writePass(d1[i][0], counter, sheet, acop);
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
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				Thread.sleep(1000);
				
						driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				Thread.sleep(1000);
					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
					{				
					
					boolean strFilterResult = false;
				 	strFilterResult = Cs.checkSortedValue(driver, Object, "101");
				 	System.out.println("<<<<<<<<<<<<<<<<<<<<<Reefers Maintenance  Status>>>>>>>>>>>>>"+strFilterResult);
				 	if (strFilterResult == true)
				 	{
				 		System.out.println("Column Sorted Successfully");
				 		acop = "Column Sorted Successfully";
				 		node.log(LogStatus.PASS, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
  					rc++;
  					excel.writePass(d1[i][0], counter, sheet, acop);  					
				 	}
				 	else
				 	{
				 		System.out.println("Column Sorting Failed");
				 		acop = "Column Sorting Failed";
				 		node.log(LogStatus.FAIL, acop);
  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
  					rc++;
  					String scr =s.CaptureScreenshot();
  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);  					
				 		
				 	}
					}else
					{
						System.out.println("No data found");
						acop = "No data";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);
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
  					Thread.sleep(3000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				Thread.sleep(1000);
				
						driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				Thread.sleep(1000);
				
					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
					{
						Thread.sleep(1000);	
						
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
							if(d1[i][5].isEmpty())
							{
								acop = "Pagination Displayed as expected";
								node.log(LogStatus.PASS, acop);
	  		  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
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
	  							Thread.sleep(1000);
	  							
	  							Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
	  							PageList = Pagination.findElements(By.tagName("li"));
	  							System.out.println(PageList.size());
	  							for(int j=0;j<PageList.size();j++)
	  							{
	  								//PageList.get(j).getAttribute("class");
		  							if(PageList.get(j).getText().equalsIgnoreCase(d1[i][5]))
									{
		  								if(PageList.get(j).getAttribute("class").equalsIgnoreCase("active"))
		  								{
		  										acop = "Selected Page Displayed as expected";
		  										node.log(LogStatus.PASS, acop);
		  			  		  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
		  			  		  					rc++;
		  			  		  					excel.writePass(d1[i][0], counter, sheet, acop);		  			  		  					
		  			  		  					break;
		  									}
		  									else
		  									{
		  										System.out.println("Current Page doesnot match the Page which is selected ");
		  			  		  					acop = "Pagination not displayed as expected";
		  			  		  					node.log(LogStatus.FAIL, acop);
		  			  		  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
		  			  		  					rc++;
		  			  		  					String scr = s.CaptureScreenshot();
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
		  					data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);		  					
						}
					}else
					{
						System.out.println("No data found");
						acop = "No data";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);
					}
  					}catch(Exception e)
  					{node.log(LogStatus.SKIP, "Skipped TC18 Execution, it is because of page loading issue or due to some other issue");
  						e.printStackTrace();}
  				}
  			
	  			if(d1[i][0].equalsIgnoreCase("TC19"))
	  			{
	  				try
	  				{
	  					System.out.println("TC19 Execution started.....");
	  			 	Thread.sleep(5000);
	  			  driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  			Thread.sleep(3000);
	  			  driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  			  driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  			  while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  			 	Thread.sleep(1000);
	  			 	
	  			  driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
	  			  while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  			 	Thread.sleep(1000);
	  			 	
	  			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
				{
		  			Select se = new Select(driver.findElement(By.id("per-page__select")));
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
	  			System.out.println(dropVal[click]);
	  			}
	  			if (dropVal[1].equalsIgnoreCase("10 per page") && dropVal[2].equalsIgnoreCase("20 per page") && dropVal[3].equalsIgnoreCase("50 per page") &&
	  			dropVal[4].equalsIgnoreCase("100 per page") && dropVal[5].equalsIgnoreCase("200 per page") && dropVal[6].equalsIgnoreCase("300 per page"))
	  			{
	  			System.out.println("All the fields are present successfully.");
	  			}
	  			for(int sel=1;sel<=l.size();sel++)
	  			{
	  				
		  			String [] pageCnt = dropVal[sel].split(" ");
		  			driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  			driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  			driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  			driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
		  			Thread.sleep(2000);
		  			driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li["+sel+"]")).click();
		  		while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  		 Thread.sleep(1000);
		  		
		  			WebElement ele = driver.findElement(By.xpath(".//*[@id='div-101-datagrid-tbody']"));
		  			System.out.println(ele.getTagName());
		  			List<WebElement>page=ele.findElements(By.tagName("tr"));
		  			System.out.println("PageSize : "+page.size());
		  			System.out.println(pageCnt[0]+"="+page.size());
		  			 if (pageCnt[0].equals(""+page.size()))
		  			 {
		  				 System.out.println(page.size()+" Per page loaded successfully");
		  				 driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
		  				 driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
		  				 acop = page.size()+" Per Page Loaded successfully";
		  				 node.log(LogStatus.PASS, acop);
		  				 data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
		  				 rc++;
		  				 excel.writePass(d1[i][0], counter, sheet, acop);
		  				
		  			 }
		  			 else
		  			 {
		  				 System.out.println(page.size()+" Per page not loaded");
		  				 driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
		  				 driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
		  				 acop = page.size()+" Per Page not Loaded successfully";
		  				node.log(LogStatus.FAIL, acop);
		  				 data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
		  				 rc++;
		  				 String scr = s.CaptureScreenshot();
		  				 excel.writeFail(d1[i][0], counter, sheet, acop,scr);
		  				 
		  			 }
	  			}
	  				}else
	  				{
	  					System.out.println("No data found");
						acop = "No data";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);
	  				}
	  				}catch(Exception e)
	  				{node.log(LogStatus.SKIP, "Skipped TC19 Execution, it is because of page loading issue or due to some other issue");
	  					e.printStackTrace();}
  			 	
  			 	}
  			
  				if(d1[i][0].equalsIgnoreCase("TC20"))
                {
  					try
  					{
  						System.out.println("TC20 Execution started.....");
                       Thread.sleep(5000);
                       driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
                       Thread.sleep(3000);
                       driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
                       driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
                       while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
                        Thread.sleep(1000);
                       
                       driver.findElement(By.xpath(Object.getProperty("Maintenance"))).click();
                       while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
                       Thread.sleep(1000);
                       if(s.isElementPresentcheck(By.xpath(".//*[@id='div-101-datagrid-tbody']/tr"), driver))
						{                      
                       driver.findElement(By.xpath(".//*[@id='table-col-101--all-none']/label/span[2]/span")).click();
                       while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
                       Thread.sleep(1000);
                      
                       List <WebElement> selectElements= driver.findElements(By.cssSelector(".cls-checked"));
                       System.out.println(">>>>>>>>>>>>>>>"+selectElements.size());
                       int rowCount = 0;
                       Map<String,String> arr = new TreeMap<>();
                       //ArrayList <String> arrRowList = new ArrayList <String>();
                       for(int ij=0;ij<selectElements.size();ij++)
                       {                                                     
                          System.out.println("id::>>"+ij+"<<"+selectElements.get(ij).getAttribute("id"));

                       if( (selectElements.get(ij).isSelected())&&!(selectElements.get(ij).getAttribute("id").equalsIgnoreCase(""))&&!(selectElements.get(ij).getAttribute("id").startsWith("select-All-Column")))
                       {
                            System.out.println("Check box selected");
                            rowCount = rowCount + 1;
                            //arrRowList.add(selectElements.get(ij).getAttribute("id"));
                            arr.put(selectElements.get(ij).getAttribute("id"), selectElements.get(ij).getAttribute("id"));
                       }
                       else
                       {
                          System.out.println("Check box NOT selected");
                       }
                         
                       }
                       System.out.println("row count:"+ rowCount);
                       System.out.println("Map Size: "+arr.size());
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
                          data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
                          rc++;
                          excel.writePass(d1[i][0], counter, sheet, acop);                         
                       }
                       else
                       {
                    	   System.out.println("All none is not working");
                           acop = "All none is not working as expected ";
                           node.log(LogStatus.FAIL, acop);
                          data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Fail", s.timestamp(stime)});
                          rc++;
                          String scr = s.CaptureScreenshot();
                          excel.writeFail(d1[i][0], counter, sheet, acop,scr);                        
                       }
						}else
						{
							System.out.println("No data found");
							acop = "No data";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0], "ReefersMaintenance",d1[i][1], d1[i][9], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
  					}catch(Exception e)
  					{node.log(LogStatus.SKIP, "Skipped TC20 Execution, it is because of page loading issue or due to some other issue");
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
	driver.close();
	reports.endTest(node);
	reports.flush();
	return data;
	
	

}

}

