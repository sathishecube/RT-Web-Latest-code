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
import java.util.TreeMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.*;


public class Logistic extends TestCore 
{
	static TestUtil t =new TestUtil();
	static LogisticUtils l =new LogisticUtils();
		
	@Test
	public static Map<String, Object[]>logisticutilization(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test ,int scase,int ecase) 
	{
			ExtentTest node = reports.startTest("LogisticUtilization");
			String[][] d1 =TestUtil.getData("LogisticUtilization");
			
			String acop =null;
			int counter =1;
			
			try 
			{
				driver = new FirefoxDriver(t.excelDownload());
				driver.get(Object.getProperty("URL"));
				if(t.dologin(driver ,d1[0][2], d1[0][3]))
				{
				System.out.println("Logistics Utilization Module");
				
				for(int i=scase-1;i<ecase;i++ )
				{
				
				long stime=System.currentTimeMillis();
				
				if (d1[i][0].equalsIgnoreCase("TC1"))
  				{
  					try
  					{					
  						System.out.println("TC1 Execution started.....");
  						Thread.sleep(4000);
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						Thread.sleep(4000);
  						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
  						driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  						
							Thread.sleep(1000);
					
  						driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
  						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
					
  					
  						if(!(t.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!t.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("LUDashboard")), driver)))
  						{
  							System.out.println("Page not loaded Successfully");
							acop = "Logistic Utilization Page not Loaded Successfully";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop,scr);							
  						}
  						else
  						{
  							System.out.println("Page loaded Successfully");
							acop = "Logistic Utilization Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);
							
  						}
  					}catch(Exception e)
  					{e.printStackTrace();}
  					
  				}
  					if (d1[i][0].equalsIgnoreCase("TC2"))
  					{
  						try
  						{
  							System.out.println("TC2 Execution started.....");
  							Thread.sleep(4000);
  							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  							Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
	  						driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);	  						
		  				
		  					driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
		  					driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(d1[i][5]);
		  					driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					String displayedVal = driver.findElement(By.cssSelector((".tooltip.href-history.tooltipstered"))).getText();
		  					System.out.println(displayedVal);
		  					int val1=0;
		  					String assetName="Null";
		  					if(displayedVal.contains("\n"))
		  					{
		  						val1=displayedVal.indexOf("\n");
		  						assetName = displayedVal.substring(0, val1);
		  						System.out.println(assetName);
		  					}
		  					
		  					if (assetName.equalsIgnoreCase(d1[i][5]))
		  					{
		  						System.out.println("Search value displayed Successfully");
	  							acop = "Selected search value"+ assetName +" displayed Successfully";
	  							node.log(LogStatus.PASS, acop);
	  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
	  							rc++;
	  							excel.writePass(d1[i][0], counter, sheet, acop);
	  							
	  							driver.findElement(By.xpath(Object.getProperty("LUClearSearch"))).click();
	  							if(t.isAlertPresent(driver))
	  							{
	  								Alert alert;
	  								alert = driver.switchTo().alert();
	  								System.out.println(alert.getText());
	  								String chk1 = driver.switchTo().alert().getText();  								
	  								alert.accept();
	  							}
		  					}
		  					else
		  					{
		  						System.out.println("Search value not displayed ");
	  							acop = "Selected search value"+ assetName +" not displayed Successfully";
	  							node.log(LogStatus.FAIL, acop);
	  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
	  							rc++;
	  							String scr = t.CaptureScreenshot();
	  							excel.writeFail(d1[i][0], counter, sheet, acop,scr);
	  							
	  							driver.findElement(By.xpath(Object.getProperty("LUClearSearch"))).click();
	  							if(t.isAlertPresent(driver))
	  							{
	  								Alert alert;
	  								alert = driver.switchTo().alert();
	  								System.out.println(alert.getText());
	  								String chk1 = driver.switchTo().alert().getText();
	
	  								
	  								alert.accept();
	  							}
		  					}
  						}catch(Exception e)
  						{
  							e.printStackTrace();}

  					}
  					if (d1[i][0].equalsIgnoreCase("TC3"))
  					{
  						try
  						{
  							String sDate =t.dateConvert(d1[i][6]);
  			  				String eDate =t.dateConvert(d1[i][7]);
  			  				
	  						System.out.println( "TC3 Execution started.....");
	  						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
		  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  					Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("Editdaterange"))).click();
		  					if(t.isElementPresentcheck(By.xpath(Object.getProperty("StartDate")),driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EndDate")),driver) 
		  					&& t.isElementPresentcheck(By.xpath(Object.getProperty("SetDateRange")),driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DateCancel")),driver))
		  			       {
		  						System.out.println("Verified the values in Edit date range pop up");
		  			       }
		  					else
		  					{
		  						System.out.println("Some of the values are wrong");
		  					}
		  						if(sDate.equalsIgnoreCase("NA"))
		  						{
		  							System.out.println("No Need to do anything");
		  						}
		  						else
		  						{
		  							driver.findElement(By.xpath(Object.getProperty("LUFromDate"))).sendKeys(sDate);
		  							driver.findElement(By.xpath(Object.getProperty("LUToDate"))).sendKeys(eDate);
		  							driver.findElement(By.xpath(Object.getProperty("LUSetDateRange"))).click();
		  							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))			  						
			  							Thread.sleep(1000);			  						
		  							
		  							String strMain = driver.findElement(By.xpath(Object.getProperty("DateRangeDisplay"))).getText();
	  								System.out.println("Date range displayed as expected");
	  								String[] arrSplit = strMain.split(" to ");
	  								int chkIndex=0;
		  							String TotalPages =driver.findElement(By.xpath(Object.getProperty("DAGetNoOfPages"))).getText();
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
		  								acop = "No data for this date range";
		  								node.log(LogStatus.PASS, acop);
		  	  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
		  	  							rc++;
		  	  							excel.writePass(d1[i][0], counter, sheet, acop);		  	  						
		  	  							
		  							}
		  							else
		  							{
		  							String EndDateGet = driver.findElement(By.xpath(Object.getProperty("LUReceivedMessageTime"))).getText();
		  							driver.findElement(By.xpath(Object.getProperty("LUMessageTime"))).click();
		  							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  	  						
		  	  							Thread.sleep(1000);
		  	  								  							
		  							String StartDateGet = driver.findElement(By.xpath(Object.getProperty("LUReceivedMessageTime"))).getText();
		  							System.out.println(EndDateGet);
		  							System.out.println(StartDateGet);
		  							
		  							StartDateGet=t.cutString(StartDateGet, "\n");
		  							EndDateGet=t.cutString(EndDateGet, "\n");
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
		  							if(t.dateCompare(sDate, eDate, StartDate)==1 && t.dateCompare(sDate, eDate, EndDate)==1 )
		  							{
		  								
		  								acop = "Date within range";
		  								node.log(LogStatus.PASS, acop);
		  	  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
		  	  							rc++;
		  	  							excel.writePass(d1[i][0], counter, sheet, acop);		  	  						
		  	  							
		  		  					}
		  		  					else
		  		  					{
		  		  						System.out.println("Search value not displayed ");
		  	  							acop = "Date not in range";
		  	  							node.log(LogStatus.FAIL, acop);
		  	  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
		  	  							rc++;
		  	  							String scr = t.CaptureScreenshot();	  	  					
		  	  							excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  	  							
		  	  						
		  		  					}	  							
		  							
		  						}
		  						
  						
	  					}
		  						t.clearDateRange(driver, Object);
		  						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  						{
		  							
		  							System.out.println("inside while");
		  							Thread.sleep(1000);
		  						}
  						}catch(Exception e)
  						{e.printStackTrace();}
  					}
  					
  					if (d1[i][0].equalsIgnoreCase("TC4"))
  					{
  						try
  						{
	  						System.out.println( "TC4 Execution started.....");
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
		  					Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  					
	  							Thread.sleep(1000);
	  					
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
		  					driver.findElement(By.xpath(Object.getProperty("LUShowFilter"))).click();
		  					boolean strFilterResult = false;
		  					Thread.sleep(5000);
	  						
	  						strFilterResult = l.checkFilterValue(driver, Object, "200", "isSingleTempEnabled", "3", false, "Text", "LUApplyButton","LUClearFilter");
	  						System.out.println("<<<<<<<<<<<<<<<<<<<<<Logistic Utilization Filter Status>>>>>>>>>>>>>"+strFilterResult);
	  						if (strFilterResult == true)
	  						{
	  							acop = "Filtered values are correct";
	  							node.log(LogStatus.PASS, acop);
		  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
		  							rc++;
		  							excel.writePass(d1[i][0], counter, sheet, acop);
	  						}
	  						else
	  						{
	  							acop = "Filtered values are not correct";
	  							node.log(LogStatus.FAIL, acop);
		  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
		  							rc++;
		  							String scr = t.CaptureScreenshot();
		  							excel.writeFail(d1[i][0], counter, sheet, acop,scr);
	  						}		  					
		  							
  						}catch(Exception e)
  						{e.printStackTrace();}
					}
							
  					if (d1[i][0].equalsIgnoreCase("TC5"))
  					{
  						
  						try
  						{
	  						System.out.println( "TC5 Execution started.....");	  						
	  						Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
		  					driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
		  					//Please select a Asset
		  					String getVal = driver.findElement(By.xpath(Object.getProperty("LUErrorPopup1"))).getText();
		  					if (d1[i][8].contains("#"))
		  					{
		  						String[] expt = d1[i][8].split("#");
		  						if (getVal.equals(expt[0]))
		  						{
		  							System.out.println("Alert Message should display Please Select a Asset message");
		  							System.out.println("Actual"+getVal);
		  							System.out.println("Filter functionality is working fine");
	  								acop = "Error Message = "+getVal;
	  								node.log(LogStatus.PASS, acop);
	  	  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], expt[0], acop, "Pass", t.timestamp(stime)});
	  	  							rc++;
	  	  							excel.writePass(d1[i][0], counter, sheet, acop);
		  						}
		  						else
		  						{
		  							System.out.println("Popup is not coming");
		  							acop = "Error Message = "+getVal;
		  							node.log(LogStatus.FAIL, acop);
		  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], expt[0], acop, "Fail", t.timestamp(stime)});
		  							rc++;
		  							String scr = t.CaptureScreenshot();
		  							excel.writeFail(d1[i][0], counter, sheet, acop,scr);		  							
		  						}		  						
		  						
		  						driver.findElement(By.xpath(".//*[@id='div-200-datagrid-tbody']/tr[1]/td[1]/label/span[2]/span")).click();
		  						driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
		  						if(t.isElementPresentcheck(By.xpath(Object.getProperty("LUClearAlarm")),driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("LUMicroRead")),driver)) 
		  			  					
		  			  			       {
		  							System.out.println("All the fields are present inside the More Action");
		  							
		  			  			       }
		  						else
		  						{
		  							System.out.println("Some values are wrong");
		  						}
		  						
		  					}
		  					System.out.println("subtest case 3 is excuting");
		  					Thread.sleep(5000);
		  					driver.findElement(By.xpath(Object.getProperty("LUClearAlarm"))).click();
		  					Thread.sleep(2000);
		  					driver.findElement(By.xpath(Object.getProperty("Lsendcmd"))).click();
		  					Thread.sleep(2000);
		  					if(t.isAlertPresent(driver))
								{
									Alert alert;
									alert = driver.switchTo().alert();
									System.out.println(alert.getText());
									String chk1 = driver.switchTo().alert().getText();
									alert.accept();
								}
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  						{
	  							
	  							System.out.println("inside while");
	  							Thread.sleep(1000);
	  						}
		  					String getVal1 = driver.findElement(By.xpath(Object.getProperty("LUErrorPopup1"))).getText();
		  					if (d1[i][8].contains("#"))
		  					{
		  						String[] expt = d1[i][8].split("#");
		  						if (getVal1.equals(expt[1]))
		  						{
		  							System.out.println("Clear Alarms should display a screen where the radio button is already checked for clear Alarms. Buttons: Send command or cancel button");
		  							System.out.println("Actual"+getVal1);
		  							System.out.println("Filter functionality is working fine");
	  								acop = "Popup Message = "+getVal1;
	  								node.log(LogStatus.PASS, acop);
	  	  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], expt[1], acop, "Pass", t.timestamp(stime)});
	  	  							rc++;
	  	  							excel.writePass(d1[i][0], counter, sheet, acop);
		  						}
		  						else
		  						{
		  							System.out.println("Popup is not coming");
		  							acop = "Popup Message = "+getVal1;
		  							node.log(LogStatus.FAIL, acop);
		  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], expt[1], acop, "Fail", t.timestamp(stime)});
		  							rc++;
		  							String scr = t.CaptureScreenshot();
		  							excel.writeFail(d1[i][0], counter, sheet, acop,scr);		  							
		  						}
		  					}
		  					System.out.println("subtest case 4 is excuting");
		  					driver.findElement(By.xpath(".//*[@id='div-200-datagrid-tbody']/tr[1]/td[1]/label/span[2]/span")).click();
	  						driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
		  					driver.findElement(By.xpath(Object.getProperty("LUMicroRead"))).click();
		  					Thread.sleep(2000);
		  					/*if(t.isAlertPresent(driver))
								{
									Alert alert;
									alert = driver.switchTo().alert();
									System.out.println(alert.getText());
									String chk1 = driver.switchTo().alert().getText();
									alert.accept();
								}
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);*/
	  					
		  					String getVal2 = driver.findElement(By.xpath(Object.getProperty("LUErrorPopup1"))).getText();
		  					if (d1[i][8].contains("#"))
		  					{
		  						String[] expt = d1[i][8].split("#");
		  						if (getVal2.equals(expt[2]))
		  						{
		  							System.out.println("Clear Alarms should display a screen where the radio button is already checked for clear Alarms. Buttons: Send command or cancel button");
		  							System.out.println("Actual"+getVal2);
		  							System.out.println("Filter functionality is working fine");
	  								acop = "Popup Message = "+getVal2;
	  								node.log(LogStatus.PASS, acop);
	  	  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], expt[2], acop, "Pass", t.timestamp(stime)});
	  	  							rc++;
	  	  							excel.writePass(d1[i][0], counter, sheet, acop);
		  						}
		  						else
		  						{
		  							System.out.println("Popup is not coming");
		  							acop = "Popup Message = "+getVal2;
		  							node.log(LogStatus.FAIL, acop);
		  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], expt[2], acop, "Fail", t.timestamp(stime)});
		  							rc++;
		  							String scr = t.CaptureScreenshot();
		  							excel.writeFail(d1[i][0], counter, sheet, acop,scr);		  							
		  						}
		  					}
  						}catch(Exception e)
  						{e.printStackTrace();}
		  					
	  				}
  					if (d1[i][0].equalsIgnoreCase("TC6"))
  					{
  						try
  						{
	  						System.out.println( "TC6 Execution started.....");
	  						Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
			  					List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-200-datagrid']/div/table[1]/thead/tr[2]"));
			  					List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
			  					System.out.println("No.of rows "+rows.size());
			  					for(WebElement row:rows){
			  					List<WebElement> rowElements = row.findElements(By.xpath("th"));
			  					//System.out.println("rowelement value"+rowElements);
	
			  					ArrayList<String> rowData = new ArrayList<String>();
			  					
			  					for(WebElement column:rowElements){
			  						System.out.println("column value "+column);
			  					    rowData.add(column.getText().toString());
			  					  //  System.out.println("rowData Values are"+rowData);
	
			  					}
			  					System.out.println("rowData  Size "+rowData.size());
			  					String strMain = d1[i][9];
							    String[] arrSplit4 = strMain.split(",");
							    System.out.println(arrSplit4);
							    int present =0;
							    int notPresent = 0;
							    for(int rnum=0;rnum<arrSplit4.length;rnum++)
									{
							    	System.out.println(arrSplit4[rnum]);
							    	if (rowData.contains(arrSplit4[rnum]))
							    	{
							    		present++;
							    		System.out.println("This Column is present"+arrSplit4[rnum]);
							    	}
							    	else
							    	{
							    		notPresent++;
							    		System.out.println("This Column is not present"+arrSplit4[rnum]);
							    	}
									}
							    if (notPresent == 0)
							    {
							    	System.out.println("All the column is present");
						    		acop = "All the column is present";
						    		node.log(LogStatus.PASS, acop);
		  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
		  							rc++;
		  							excel.writePass(d1[i][0], counter, sheet, acop);
							    }
							    else
							    {
							    	System.out.println("Some of the column values are wrong");
						    		acop = "Some of the column values are wrong";
						    		node.log(LogStatus.FAIL, acop);
		  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
		  							rc++;
		  							excel.writePass(d1[i][0], counter, sheet, acop);
							    }
			  					}
							
  						}catch(Exception e)
  						{e.printStackTrace();}
  					}
  					if (d1[i][0].equalsIgnoreCase("TC7"))
  					{
  						try
  						{
	  						System.out.println( "TC7 Execution started.....");
	  						Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("RefreshReport"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					if(!(t.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
	  								!(t.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
	  								!(t.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
	  								!(t.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
	  								!(t.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
	  								!(t.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!t.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
	  								!(t.isElementPresentcheck(By.xpath(Object.getProperty("LUDashboard")), driver)))
		  					{
		  						System.out.println("Page not loaded Successfully");
	  							acop = "Logistic Utilization Page not Loaded Successfully";
	  							node.log(LogStatus.PASS, acop);
	  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
	  							rc++;
	  							String scr = t.CaptureScreenshot();
	  							excel.writeFail(d1[i][0], counter, sheet, acop,scr);	  							
		  					}
		  					else
		  					{
		  						System.out.println("Page loaded Successfully");
	  							acop = "Logistic Utilization Page Loaded Successfully";
	  							node.log(LogStatus.FAIL, acop);
	  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
	  							rc++;
	  							excel.writePass(d1[i][0], counter, sheet, acop);	  							
		  					}
  						}catch(Exception e)
  						{e.printStackTrace();}
  						
  					}
	  						  					
  					if (d1[i][0].equalsIgnoreCase("TC8"))
  					{
  						try
  						{
	  						
	  						System.out.println( "TC8 Execution started.....");
	  						Thread.sleep(10000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					
		  					driver.findElement(By.xpath(".//*[@id='table-col-200--all-none']/label/span[2]/span")).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);	  					
		  					
		  					String parentHandle = driver.getWindowHandle(); // get the current window handle
		  				    System.out.println(parentHandle);               //Prints the parent window handle 
		  				    driver.findElement(By.xpath(Object.getProperty("ViewMap"))).click();
		  				    Thread.sleep(4000);//Clicking on this window
		  				    for (String winHandle : driver.getWindowHandles()) { //Gets the new window handle
		  				        System.out.println(winHandle);
		  				        driver.switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)              
		  				    }
		  				  if(t.isElementPresentcheck(By.xpath(Object.getProperty("LUMapVerification")),driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("LUPrintMap")),driver) )
				  		 {
				  			       System.out.println("All the filds are present in the Map view");
		  							acop = "Logistic Utilization Map View Loaded Successfully";
		  							node.log(LogStatus.PASS, acop);
		  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
		  							rc++;
		  							excel.writePass(d1[i][0], counter, sheet, acop);
				  			       }
		  				  else
		  				  {
		  					  System.out.println("Mismatch Found");
		  					acop = "Logistic Utilization Map View not Loaded Successfully";
		  					node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);
		  				  }
		  				  
		  				driver.findElement(By.xpath(Object.getProperty("LUPrintMap"))).click();
		  				Thread.sleep(5000);
		  				Robot r = new Robot();
		  				r.keyPress(KeyEvent.VK_ESCAPE);
		  				r.keyRelease(KeyEvent.VK_ESCAPE);
		  				driver.findElement(By.xpath(".//*[@id='map_list']/ul/li[10]/a")).click();
		  				Thread.sleep(1000);
		  				if(!t.isElementPresentcheck(By.xpath(Object.getProperty("LUShowAll")), driver))
		  				{
		  					System.out.println("Show all is not visible");
		  				WebElement w = driver.findElement(By.xpath(".//*[@id='map_list']"));
		  				JavascriptExecutor jse = (JavascriptExecutor)driver;
		  				jse.executeScript("window.scrollBy(0,250)", "");		  				
		  				driver.findElement(By.xpath(Object.getProperty("LUShowAll"))).click();
		  				}
		  				else
		  				{
		  					System.out.println("Show all is visible");
		  					WebElement w = driver.findElement(By.xpath(".//*[@id='map_list']"));
			  				JavascriptExecutor jse = (JavascriptExecutor)driver;
			  				jse.executeScript("window.scrollBy(0,250)", "");
		  					driver.findElement(By.xpath(Object.getProperty("LUShowAll"))).click();
		  					driver.findElement(By.xpath(Object.getProperty("LUShowAll"))).click();
		  				}
		  				
		  				Thread.sleep(2000);
		  				if(t.isElementPresentcheck(By.xpath(Object.getProperty("LUMapVerification")),driver))
		  				{
		  					System.out.println("Show All is working as expected");
								acop = "Logistic Utilization Map View all the asset maps Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
		  				}
		  				else
		  				{
		  					System.out.println("Show All is not working");
		  					acop = "Logistic Utilization Show All is not working";
		  					node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);
		  				}
		  				Thread.sleep(10000);
		  				driver.findElement(By.xpath(".//*[@id='map']/div/div/div[10]/div[2]/div[1]")).click();
		  				Thread.sleep(5000);
		  				driver.findElement(By.xpath(".//*[@id='map']/div/div/div[10]/div[3]/div")).click();
		  				Thread.sleep(5000);
		  				  driver.close();                           
		  				    driver.switchTo().window(parentHandle);		  				  
  						}catch(Exception e)
  						{e.printStackTrace();}
  					}
  					
  					if (d1[i][0].equalsIgnoreCase("TC9"))
  					{
  						try
  						{
	  						System.out.println( "TC9 Execution started.....");
	  						Thread.sleep(10000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						  					
		  					String parentHandle = driver.getWindowHandle(); // get the current window handle
		  				    System.out.println(parentHandle);
		  					driver.findElement(By.xpath(Object.getProperty("Printthispage"))).click();
		  				    for (String winHandle : driver.getWindowHandles()) { //Gets the new window handle
		  				        System.out.println(winHandle);
		  				        driver.switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)              
		  				    }
		  					Thread.sleep(2000);
		  					Robot r = new Robot();
			  				r.keyPress(KeyEvent.VK_ESCAPE);
			  				r.keyRelease(KeyEvent.VK_ESCAPE);
			  				
								driver.close();                           // close newly opened window when done with it
		  				    driver.switchTo().window(parentHandle);
		  				    System.out.println("Print window opened successfully");
							acop = "Logistic Utilization - Print window opened successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);
							
  						}catch(Exception e)
  						{e.printStackTrace();}
  					}
  					if (d1[i][0].equalsIgnoreCase("TC10"))
  					{
  						try
  						{
  							Thread.sleep(10000);
  							System.out.println( "TC10 Execution started.....");	  						
	  						ArrayList<String> tr=new ArrayList<String>();
	  						int pageSize=0,recordsCount=0;
	  						
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  					
	  							Thread.sleep(1000);
	  					
		  					driver.findElement(By.xpath(Object.getProperty("Downloadthispage"))).click();
		  					driver.findElement(By.xpath(".//*[@id='btnExportExcel']")).click();
		  					Thread.sleep(2000);
		  					WebElement ele = driver.findElement(By.xpath(".//*[@id='div-200-datagrid-tbody']"));
	  						System.out.println(ele.getTagName());
	  						List<WebElement>page=ele.findElements(By.tagName("tr"));
	  						System.out.println("PageSize : "+page.size());
	  						//System.out.println("PageSize : "+pageSize);
	  						pageSize=page.size();
		  					try
		  					{
		  					BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\UtilizationReport.xls"));
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
		  						System.out.println("Utilization Report Count");
			  				 	System.out.println("Print window opened successfully");
								acop = "Logistic Utilization - Print window opened successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);								
		  					}
		  					else
		  					{
		  						System.out.println("Records count mismatch... Fail");
		  						acop = "Count mismatch";
		  						node.log(LogStatus.FAIL, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
			  					rc++;
			  					String scr = t.CaptureScreenshot();
			  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);			  					
		  					}		  					 
		  					
  						}catch(Exception e)
  						{e.printStackTrace();}
	
  					}
  					
  					
  					if(d1[i][0].equalsIgnoreCase("TC11"))
	  				{
  						try
  						{ 						
		  					System.out.println( "TC11 Execution started.....");
		  					Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
				  				if(t.unitofMeasure(driver, Object, Object.getProperty("Logistic"), Object.getProperty("LULogisticClick"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
				  				{
				  					System.out.println("Time zone Displayed Successfully");
				  					acop = "Time zone displayed as expected";
				  					node.log(LogStatus.PASS, acop);
				  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
				  					rc++;
				  					excel.writePass(d1[i][0], counter, sheet, acop);
				  					
				  				}
				  				else
				  				{
				  					System.out.println("Time zone not Displayed ");
				  					acop = "Time zone not displayed as expected";
				  					node.log(LogStatus.FAIL, acop);
				  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
				  					rc++;
				  					String scr = t.CaptureScreenshot();
				  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);				  					
				  				}
  						}catch(Exception e)
  						{e.printStackTrace();}
			  					
			  		}
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC12"))
	  				{
	  					try
	  					{
		  					System.out.println( "TC12 Execution started.....");
		  					Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
			  				if(t.unitofMeasure(driver, Object, Object.getProperty("Logistic"), Object.getProperty("LULogisticClick"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
			  				{
			  					System.out.println("Temperature Unit Displayed Successfully");
			  					acop = "Temperature Unit displayed as expected";
			  					node.log(LogStatus.PASS, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
			  					rc++;
			  					excel.writePass(d1[i][0], counter, sheet, acop);			  					
			  				}
			  				else
			  				{
			  					System.out.println("Temperature Unit not Displayed ");
			  					acop = "Temperature Unit not displayed as expected";
			  					node.log(LogStatus.FAIL, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
			  					rc++;
			  					String scr = t.CaptureScreenshot();
			  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);			  					
			  				}
	  					}catch(Exception e)
	  					{e.printStackTrace();}
		  			}
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC13"))
	  				{
	  					try
	  					{
		  					System.out.println( "TC13 Execution started.....");
		  					Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  				
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
			  				if(t.unitofMeasure(driver, Object, Object.getProperty("Logistic"), Object.getProperty("LULogisticClick"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
			  				{
			  					System.out.println("Fuel Level Displayed Successfully");
			  					acop = "Fuel Level displayed as expected";
			  					node.log(LogStatus.PASS, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
			  					rc++;
			  					excel.writePass(d1[i][0], counter, sheet, acop);			  					
			  				}
			  				else
			  				{
			  					System.out.println("Fuel Level not Displayed ");
			  					acop = "Fuel Level not displayed as expected";
			  					node.log(LogStatus.FAIL, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
			  					rc++;
			  					String scr = t.CaptureScreenshot();
			  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);			  				
			  				}
	  					}catch(Exception e)
	  					{
	  						e.printStackTrace();
	  					}
		  				}
	  			
	  				if(d1[i][0].equalsIgnoreCase("TC14"))
	  				{
	  					try
	  					{
		  					System.out.println( "TC14 Execution started.....");
		  					Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
			  				if(t.unitofMeasure(driver, Object, Object.getProperty("Logistic"), Object.getProperty("LULogisticClick"), Object.getProperty("DistanceCalcIcon"), Object.getProperty("DistanceTooltip"), Object.getProperty("DistanceTooltipval"), Object.getProperty("DistanceUnit")))
			  				{
			  					System.out.println("Distance Unit Displayed Successfully");
			  					acop = "Distance Unit displayed as expected";
			  					node.log(LogStatus.PASS, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
			  					rc++;
			  					excel.writePass(d1[i][0], counter, sheet, acop);			  					
			  				}
			  				else
			  				{
			  					System.out.println("Distance Unit not Displayed ");
			  					acop = "Distance Unit not displayed as expected";
			  					node.log(LogStatus.FAIL, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
			  					rc++;
			  					String scr = t.CaptureScreenshot();
			  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);			  					
			  				}
	  					}catch(Exception e)
	  					{
	  						e.printStackTrace();
	  					}
		  				}
	  				if(d1[i][0].equalsIgnoreCase("TC15"))
	  				{
	  					try
	  					{
		  					System.out.println( "TC15 Execution started.....");
		  					Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					if (t.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver))
		  					{
		  						System.out.println("Control Probe ICON Displayed Successfully");
			  					acop = "Control Probe ICON Displayed as expected";
			  					node.log(LogStatus.PASS, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
			  					rc++;
			  					excel.writePass(d1[i][0], counter, sheet, acop);			  					
			  				}
			  				else
			  				{
			  					System.out.println("Control Probe ICON not Displayed ");
			  					acop = "Control Probe ICON not displayed as expected";
			  					node.log(LogStatus.FAIL, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
			  					rc++;
			  					String scr = t.CaptureScreenshot();
			  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);			  					
			  				}
	  					}catch(Exception e)
	  					{
	  						e.printStackTrace();
	  					}
	  				}
	  				if(d1[i][0].equalsIgnoreCase("TC16"))
	  				{
	  					try
	  					{
		  					System.out.println( "TC16 Execution started.....");
		  					Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  					
	  							Thread.sleep(1000);
	  					
		  					boolean strFilterResult = false;
	  						strFilterResult = l.checkSortedValue(driver, Object, "200");
	  						System.out.println("<<<<<<<<<<<<<<<<<<<<<Logistic Utilization Sorting Status>>>>>>>>>>>>>"+strFilterResult);
	  						if (strFilterResult == true)
	  						{
	  							System.out.println("Column sorted successfully");
	  							acop = "Column sorted successfully";
	  							node.log(LogStatus.PASS, acop);
	  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
			  					rc++;
			  					excel.writePass(d1[i][0], counter, sheet, acop);
	  						}
	  						else
	  						{
	  							System.out.println("Column sorting Failed");
	  							acop = "Column sorting Failed";
	  							node.log(LogStatus.FAIL, acop);
	  							data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
			  					rc++;
			  					String scr = t.CaptureScreenshot();
			  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);
	  						}
	  					}catch(Exception e)
	  					{
	  						e.printStackTrace();
	  					}
	  					

	  				}
	  				if(d1[i][0].equalsIgnoreCase("TC17"))
	  				{
	  					try
	  					{
		  					System.out.println( "TC17 Execution started.....");
		  					Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
		  					WebElement htmltable=driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
							List<WebElement> rows=htmltable.findElements(By.tagName("li"));
							System.out.println("No. of Rows in the WebTable: "+rows.size());
							//System.out.println(rows);
							//System.out.println("CHK1");
						for(int rnum=1;rnum<=rows.size()-1;rnum++)
						{
							String pageNav = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul/li["+rnum+"]")).getText();
							if (t.isElementPresentcheck(By.xpath(".//*[@id='pagination-holder']/ul/li["+rnum+"]"), driver))
							{
								System.out.println("Button is present");
							}
							else
							{
								System.out.println("Fail");
							}
							
						}
						for(int click=1;click<=rows.size()-1;click++)
						{
							System.out.println("Row Size -1 = "+click);
							
							if(click == 3)
							{
								driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul/li["+click+"]")).click();
								System.out.println("Page # 2 clicked successfully");
								while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  						{
		  							
		  							System.out.println("inside while");
		  							Thread.sleep(1000);
		  						}
							}
							if(click == rows.size()-1)
							{
								driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul/li["+click+"]")).click();
								System.out.println("Next button clicked successfully");
								while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
		  						{
		  							
		  							System.out.println("inside while");
		  							Thread.sleep(1000);
		  						}
							}
						}
		  					
		  					
		  					driver.findElement(By.xpath(Object.getProperty("LUPageDropdoen"))).click();
		  					Thread.sleep(1000);
		  					driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul/li[9]/div/div/div/div/div/input")).sendKeys("2");
		  					Thread.sleep(1000);
		  					//driver.findElement(By.xpath(Object.getProperty(".//*[@id='pagination-holder']/ul/li[9]/div/div/div/div/ul/li[1]/em"))).click();
		  					Robot robot = new Robot();
		  					robot.keyPress(KeyEvent.VK_ENTER);
		  					robot.keyRelease(KeyEvent.VK_ENTER);
		  					Thread.sleep(2000);
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  						{
	  							
	  							System.out.println("inside while");
	  							Thread.sleep(1000);
	  						}
		  					String Val = driver.findElement(By.xpath(Object.getProperty("DAGetNoOfPages"))).getText();
		  					String [] arrVal = Val.split(" ");
		  					if (arrVal[0].equalsIgnoreCase("21"))
		  							{
		  						System.out.println("Clicked Page Loaded successfully");
			  					acop = "Clicked Page Loaded successfully";
			  					node.log(LogStatus.PASS, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
			  					rc++;
			  					excel.writePass(d1[i][0], counter, sheet, acop);			  					
			  				}
			  				else
			  				{
			  					System.out.println("Clicked page not loaded");
			  					acop = "Page not loaded";
			  					node.log(LogStatus.FAIL, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
			  					rc++;
			  					String scr = t.CaptureScreenshot();
			  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);			  					
		  							}
		  					
	  					}catch(Exception e)
	  					{
	  						e.printStackTrace();
	  					}
	  					
	  				}
	  				if(d1[i][0].equalsIgnoreCase("TC18"))
	  				{
	  					try
	  					{
		  					System.out.println( "TC18 Execution started.....");
		  					Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  					
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
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
								while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  						
		  							Thread.sleep(1000);
		  						
								WebElement ele = driver.findElement(By.xpath(".//*[@id='div-200-datagrid-tbody']"));
		  						System.out.println(ele.getTagName());
		  						List<WebElement>page=ele.findElements(By.tagName("tr"));
		  						System.out.println("PageSize : "+page.size());
		  						System.out.println(pageCnt[0]+"="+page.size());
		  						if (pageCnt[0].equals(""+page.size()))
		  						{
		  							System.out.println(page.size()+" Per page loaded successfully");
				  					acop = page.size()+" Per Page Loaded successfully";
				  					node.log(LogStatus.PASS, acop);
				  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
				  					rc++;
				  					excel.writePass(d1[i][0], counter, sheet, acop);				  					
				  				}
				  				else
				  				{
				  					System.out.println(page.size()+" Per page not loaded");
				  					acop = page.size()+" Per Page not Loaded successfully";
				  					node.log(LogStatus.FAIL, acop);
				  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
				  					rc++;
				  					String scr = t.CaptureScreenshot();
				  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);				  					
				  				}
		  						
								
							}
							driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
							driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li[2]")).click();
	  					}catch(Exception e)
	  					{
	  						e.printStackTrace();
	  					}
	  					
	  				}
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC19"))
	  				{
	  					
	  					try
	  					{
		  					System.out.println( "TC19 Execution started.....");
		  					Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  					
	  							Thread.sleep(1000);
	  					
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
		  					
		  					driver.findElement(By.xpath(".//*[@id='table-col-200--all-none']/label/span[2]/span")).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
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
	  						String chkVal = driver.findElement(By.xpath(Object.getProperty("DAGetNoOfPages"))).getText();
	  						String [] getVal = chkVal.split(" - ");
	  						System.out.println(getVal[1]);
	  						String [] finalVal = getVal[1].split(" of ");
	  						System.out.println(finalVal[0]);
	  						if (finalVal[0].equals(""+arr.size()))
	  						{
	  							System.out.println("Select All is working as expected");
			  					acop = " All None is working";
			  					node.log(LogStatus.PASS, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
			  					rc++;
			  					excel.writePass(d1[i][0], counter, sheet, acop);			  					
			  				}
			  				else
			  				{
			  					System.out.println(" Per page not loaded");
			  					acop = " Per Page not Loaded successfully";
			  					node.log(LogStatus.FAIL, acop);
			  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
			  					rc++;
			  					String scr = t.CaptureScreenshot();
			  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);			  					
			  				}
	  						
	  					}catch(Exception e)
	  					{ e.printStackTrace();}
	  					
	  				}
	  				
	  				
	  				
	  				
	  				if(d1[i][0].equalsIgnoreCase("TC20"))
	  				{
	  					
	  					try
	  					{
		  					System.out.println( "TC20 Execution started.....");
		  					Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					driver.findElement(By.xpath(Object.getProperty("LUAssetClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
		  					String reportName = driver.findElement(By.xpath(Object.getProperty("LUReportName"))).getText();
		  					System.out.println(reportName);
		  							if (reportName.contains("Utilization History Report"))
		  							{
		  								System.out.println("Utilization history loaded successfully");
					  					acop = "Utilization history loaded successfully";
					  					node.log(LogStatus.PASS, acop);
					  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
					  					rc++;
					  					excel.writePass(d1[i][0], counter, sheet, acop);					  					
					  				}
					  				else
					  				{
					  					System.out.println("History page not loaded");
					  					acop = "History page not loaded";
					  					node.log(LogStatus.FAIL, acop);
					  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
					  					rc++;
					  					String scr = t.CaptureScreenshot();
					  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);
					  					
					  				}
	  					}catch(Exception e)
	  					{
	  						e.printStackTrace();
	  					}
	  					
	  				}
	  				if(d1[i][0].equalsIgnoreCase("TC21"))
	  				{
	  					try
	  					{
		  					System.out.println( "TC21 Execution started.....");
		  					Thread.sleep(4000);
	  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  						Thread.sleep(4000);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
		  					driver.findElement(By.xpath(Object.getProperty("LULogisticClick"))).click();
		  					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  					
		  					boolean flag = false;
		  					String parentHandle = driver.getWindowHandle(); 
		  				    System.out.println(parentHandle);               
		  				    String valChk = driver.findElement(By.xpath(".//*[@id='div-200-datagrid-tbody']/tr[1]/td[6]/a")).getText();
		  				    String mysz2 = valChk.replaceAll(",\\s",",");
		  				    System.out.println(mysz2);
		  				    driver.findElement(By.xpath(".//*[@id='div-200-datagrid-tbody']/tr[1]/td[6]/a")).click();
			  				 for (String winHandle : driver.getWindowHandles()) 
			  				 { //Gets the new window handle
		  				        System.out.println(winHandle);
		  				        driver.switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)              
		  				    }
			  				  Thread.sleep(6000);
			  				 WebElement htmltable=driver.findElement(By.cssSelector(".map__window>ul"));
			  				 List<WebElement> rows=htmltable.findElements(By.tagName("li"));
							System.out.println("No. of Rows in the WebTable: "+rows.size());
												
						for(int rnum=1;rnum<=rows.size();rnum++)
						{
							
							String pageNav = driver.findElement(By.cssSelector(".-location")).getText();
							System.out.println(pageNav);
							if (pageNav.equals(mysz2))
							{
								System.out.println("Location Loded Successfully");
								flag = true;
			  					
			  				}
			  				else
			  				{
			  					System.out.println("Location not loaded");
			  					flag = false;
			  					
			  				}
							
		  				    
		  				}
						if (flag = true)
						{
							acop = "Location loaded Successfully";
							node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
		  					rc++;
		  					excel.writePass(d1[i][0], counter, sheet, acop);		  					
						}
						else
						{
							acop = "Location not loaded";
							node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {d1[i][0], "LogisticUtilization", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
		  					rc++;
		  					String scr = t.CaptureScreenshot();
		  					excel.writeFail(d1[i][0], counter, sheet, acop,scr);		  					
						}
						driver.close();
						driver.switchTo().window(parentHandle);
	  					}catch(Exception  e)
	  					{
	  						e.printStackTrace();
	  					}
	  				}
			}
				}
	}	catch(Exception e)
	{
		e.printStackTrace();
	}
			System.out.println("---------------------------------------------------------");
		driver.close();
		reports.endTest(node);
		reports.flush();
		return data;

}

}
