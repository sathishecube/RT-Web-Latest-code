package dd_test;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.LogisticUtils;
import dd_utils.TestUtil;


public class OrdersDisparity extends TestCore 
{
	static TestUtil s =new TestUtil();
	static LogisticUtils Cs =new LogisticUtils();
		
	@Test
	public static Map<String, Object[]> orderdisparitytestcases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase) 
	{
		String acop =null;
		int counter =1;
		ExtentTest node = reports.startTest("OrdersDisparity");
		String[][] input =TestUtil.getData("OrdersDisparity");		
		try
		{
			driver = new FirefoxDriver(s.excelDownload());
			driver.get(Object.getProperty("URL"));
			if(s.dologin(driver ,input[0][2], input[0][3]))
			{
				System.out.println("Order Disparity Module");
				for (int i=scase-1;i<ecase;i++)
				{
					long stime = System.currentTimeMillis();
	  				
	  				String tc=input[i][0];
	  				String tcdesc =input[i][1];	  				
	  				String eopt = input[i][8];

	  				
	  				System.out.println(tc + tcdesc);
	  				if (tc.equalsIgnoreCase("TC1"))
	  				{
	  					try
	  					{
	  					System.out.println("TC1 Execution started.....");
	  					Thread.sleep(4000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(4000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("OSFrozenFoodSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  					
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver))
	  					{
	  					if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("ODDashboard")), driver)))
	  					{
	  						System.out.println("Page not loaded Successfully");
  							acop = "Order Disparity Page not Loaded Successfully";
  							node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(tc, counter, sheet, acop,scr);  							
	  					}
	  					else
	  					{
	  						System.out.println("Page loaded Successfully");
  							acop = "Order Disparity Page Loaded Successfully";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}
	  					}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}
	  					}catch(Exception e)
	  					{e.printStackTrace();}	  				
	  				
	  				}
	  				if (tc.equalsIgnoreCase("TC2"))
  					{
	  					try
	  					{  						
  						System.out.println("TC2 Execution started.....");  					
	  					
	  					String displayedVal ="";
	  					
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("OSFrozenFoodSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  						
  						Thread.sleep(1000);
	  					
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  							  				
	  					driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
	  					driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
	  					driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						 
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver))
	  					{	  					
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr/td[2]/a"), driver))
	  					{
	  						displayedVal = driver.findElement(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr/td[2]/a")).getText();
		  					System.out.println(displayedVal);
	  					}
	  					else
	  					{
	  						System.out.println("###########NO DATA FOUND FOR THE SEARCH###########");
	  					}	  					
	  					if (displayedVal.contains(input[i][5]))
	  					{
	  						System.out.println("Search value displayed Successfully");
  							acop = "Selected search value"+ displayedVal +" displayed Successfully";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);
  							driver.findElement(By.xpath(Object.getProperty("ClearButton"))).click();
  							if(s.isAlertPresent(driver))
  							{
  								Alert alert;
  								alert = driver.switchTo().alert();
  								System.out.println(alert.getText());
  								String chk1 = driver.switchTo().alert().getText();

  								
  								alert.accept();
  							}
	  					}
	  					else if(displayedVal.contains(""))
	  					{
	  						System.out.println("No data ");
	  						acop = "No data  for this search";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);
  							driver.findElement(By.xpath(Object.getProperty("ClearButton"))).click();
  							if(s.isAlertPresent(driver))
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
  							acop = "Selected search value"+ displayedVal +" not displayed Successfully";
  							node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(tc, counter, sheet, acop,scr);
  							driver.findElement(By.xpath(Object.getProperty("ClearButton"))).click();
  							if(s.isAlertPresent(driver))
  							{
  								Alert alert;
  								alert = driver.switchTo().alert();
  								System.out.println(alert.getText());
  								String chk1 = driver.switchTo().alert().getText();  								
  								alert.accept();
  							}
	  					}	  					
	  					}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}
	  					}catch(Exception e)
	  					{e.printStackTrace();}

  					}
  					if (tc.equalsIgnoreCase("TC3"))
  					{
  						try
  						{
  							String sDate =s.dateConvert(input[i][6]);
  			  				String eDate =s.dateConvert(input[i][7]);
  			  			System.out.println("TC3 Execution started.....");
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("OSFrozenFoodSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  					
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver))
	  					{
	  					driver.findElement(By.xpath(Object.getProperty("Editdaterange"))).click();
	  					if(s.isElementPresentcheck(By.xpath(Object.getProperty("StartDate")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("EndDate")),driver) 
	  					&& s.isElementPresentcheck(By.xpath(Object.getProperty("SetDateRange")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("DateCancel")),driver))
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
	  							driver.findElement(By.xpath(Object.getProperty("StartDate"))).sendKeys(sDate);
	  							driver.findElement(By.xpath(Object.getProperty("EndDate"))).sendKeys(eDate);
	  							driver.findElement(By.xpath(Object.getProperty("SetDateRange"))).click();
	  							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
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
	  								acop = "No data for the selected date range";
	  								node.log(LogStatus.PASS, acop);
	  	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  	  							rc++;
	  	  							excel.writePass(tc, counter, sheet, acop);  	  						
	  	  							
	  							}
	  							else
	  							{
	  							String EndDateGet="", StartDateGet=""; 
	  							EndDateGet = driver.findElement(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr[1]/td[3]/b")).getText();
	  							driver.findElement(By.xpath(Object.getProperty("ODTransDateClick"))).click();
	  							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  	  						Thread.sleep(1000);
	  	  					
	  							StartDateGet = driver.findElement(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr[1]/td[3]/b")).getText();
	  							System.out.println(EndDateGet);
	  							System.out.println(StartDateGet);	  							
	  							
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
	  	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  	  							rc++;
	  	  							excel.writePass(tc, counter, sheet, acop);  	  						
	  	  							
	  		  					}
	  		  					else
	  		  					{
	  		  						System.out.println("Search value not displayed ");
	  	  							acop = "Date not in range";
	  	  						node.log(LogStatus.FAIL, acop);
	  	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
	  	  							rc++;
	  	  						String scr = s.CaptureScreenshot();
	  	  							excel.writeFail(tc, counter, sheet, acop,scr);	  	  							
	  		  					}
	  						}
  					}
	  						s.clearDateRange(driver, Object);
	  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  	  					{
	  	  						System.out.println("inside while");
	  	  						Thread.sleep(1000);
	  	  					}
	  					}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}

  						}catch(Exception e)
  						{e.printStackTrace();}
  					}
  					
  					if (tc.equalsIgnoreCase("TC4"))
  					{
  						try
  						{
  							System.out.println("TC4 Execution started.....");
  						Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("OSFrozenFoodSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  							Thread.sleep(1000);
  					
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  							Thread.sleep(1000);
  					
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  							Thread.sleep(1000);
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver))
	  					{
	  					driver.findElement(By.xpath(Object.getProperty("ODShowFilter"))).click();
	  					
	  					if((!(s.isElementPresentcheck(By.xpath(Object.getProperty("ODOrigin")),driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ODDistination")),driver)) ||
			  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("ODDisparity")),driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ODDispStatus")),driver)) ||
			  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("ODAckStatus")),driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ODApplyButton")),driver))))
			  			       {
			  						System.out.println("Some of the values are wrong");
			  			       }
			  					else
			  					{
			  						System.out.println("Verified the values in SHow Filter pop up");
			  					}
	  					
	  					System.out.println(driver.findElement(By.xpath(".//*[@id='div-125-filters']/div/div/div[1]/div[1]/label")).getText());
	  					if (driver.findElement(By.xpath(".//*[@id='div-125-filters']/div/div/div[1]/div[1]/label")).getText().equals("Origin"))
	  					{
	  						
	  						driver.findElement(By.xpath(Object.getProperty("ODOrigin"))).clear();
	  						driver.findElement(By.xpath(Object.getProperty("ODOrigin"))).sendKeys("Tar Heel, NC");
	  						driver.findElement(By.xpath(Object.getProperty("ODApplyButton"))).click();
	  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  						
	  							Thread.sleep(1000);
	  						
	  						WebElement ele1 = driver.findElement(By.xpath(".//*[@id='div-125-datagrid-tbody']"));
							System.out.println(ele1.getTagName());
							List<WebElement>page1=ele1.findElements(By.tagName("tr"));
							System.out.println("PageSize : "+page1.size());
							for (int p = 1; p <=page1.size();p++)
							{
								String getVal = driver.findElement(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr["+p+"]/td[7]")).getText();								
								if (getVal.equals("LANCTX"))
								{
									System.out.println("Filterex Value displayed");
								}
								else
								{
									System.out.println("Some Values are wrong");
								}
							}
							driver.findElement(By.xpath(Object.getProperty("ODShowFilter"))).click();
							s.clearFilter(driver, Object, "ODClearFilter");
							
	  					}	  					
	  					
	  						System.out.println("<<<<<<<<<<<<<<<<<<<<<< Destination>>>>>>>>>>>>>>>>>>>>");
	  						driver.findElement(By.xpath(Object.getProperty("ODShowFilter"))).click();
	  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  							Thread.sleep(1000);
	  						
	  						driver.findElement(By.xpath(Object.getProperty("ODDistination"))).clear();
	  						driver.findElement(By.xpath(Object.getProperty("ODDistination"))).sendKeys("Hammond, LA");
	  						driver.findElement(By.xpath(Object.getProperty("ODApplyButton"))).click();
	  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  							Thread.sleep(1000);
	  						
	  						WebElement ele1 = driver.findElement(By.xpath(".//*[@id='div-125-datagrid-tbody']"));
							System.out.println(ele1.getTagName());
							List<WebElement>page1=ele1.findElements(By.tagName("tr"));
							System.out.println("PageSize : "+page1.size());
							for (int p = 1; p <=page1.size();p++)
							{
								String getVal = driver.findElement(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr["+p+"]/td[8]")).getText();
							
								if (getVal.equals("DUNDFL"))
								{
									System.out.println("Filtered Value displayed");
								}
								else
								{
									System.out.println("Some Values are wrong");
								}
							}
							driver.findElement(By.xpath(Object.getProperty("ODShowFilter"))).click();
							s.clearFilter(driver, Object, "ODClearFilter");
	  						
	  					driver.findElement(By.xpath(Object.getProperty("ODShowFilter"))).click();					
  						
  						
  						boolean strFilterResult = false;
  						strFilterResult = Cs.checkFilterValue(driver, Object, "125", "disparityCodeFilter", "4", true, "Text", "ODApplyButton","ODClearFilter");
  						System.out.println("<<<<<<<<<<<<<<<<<<<<<Disparity Filter Status>>>>>>>>>>>>>"+strFilterResult);
  						
  						if (strFilterResult == true)
  						{
  								acop = "Filtered value displayed corrctly";
  								node.log(LogStatus.PASS, acop);
	  							data.put(""+rc, new Object[] {tc, "Ordermanifest", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  							rc++;
	  							excel.writePass(tc, counter, sheet, acop);
  						}
  						else
  						{
  							acop = "Filtered value not displayed corrctly";
  							node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {tc, "Ordermanifest", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(tc, counter, sheet, acop,scr);
  						}
  						strFilterResult = Cs.checkFilterValue(driver, Object, "125", "disparityStatus", "5", false, "Text", "ODApplyButton","ODClearFilter");  					
  						System.out.println("<<<<<<<<<<<<<<<<<<<<<Disparity Filter Status>>>>>>>>>>>>>"+strFilterResult);
  						if (strFilterResult == true)
  						{
  								acop = "Filtered value displayed corrctly";
  								node.log(LogStatus.PASS, acop);
	  							data.put(""+rc, new Object[] {tc, "Ordermanifest", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  							rc++;
	  							excel.writePass(tc, counter, sheet, acop);
  						}
  						else
  						{
  							acop = "Filtered value not displayed correctly";
  							node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {tc, "Ordermanifest", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(tc, counter, sheet, acop,scr);
  						}
  						strFilterResult = Cs.checkFilterValue(driver, Object, "125", "ackStatus", "5", false, "Text", "ODApplyButton","ODClearFilter");  						
  						System.out.println("<<<<<<<<<<<<<<<<<<<<<Disparity Filter Status>>>>>>>>>>>>>"+strFilterResult);
  						if (strFilterResult == true)
  						{
  								acop = "Filtered value displayed corrctly";
  								node.log(LogStatus.PASS, acop);
	  							data.put(""+rc, new Object[] {tc, "Ordermanifest", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  							rc++;
	  							excel.writePass(tc, counter, sheet, acop);
  						}
  						else
  						{
  							acop = "Filtered value not displayed corrctly";
  							node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {tc, "Ordermanifest", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(tc, counter, sheet, acop,scr);
  						}
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}

  						}catch(Exception e)
  						{e.printStackTrace();}
	  					
  					}
  					if (tc.equalsIgnoreCase("TC5"))
  					{
  						try
  						{
  						System.out.println("TC5 Execution started.....");
  						Thread.sleep(10000);
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);  					
	  					
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver)){
		  					List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-125-datagrid']/div/table[1]/thead/tr[2]"));
		  					List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
		  					System.out.println("No.of rows "+rows.size());
		  					for(WebElement row:rows){
		  					List<WebElement> rowElements = row.findElements(By.xpath("th"));
		  					//System.out.println("rowelement value"+rowElements);

		  					ArrayList<String> rowData = new ArrayList<String>();
		  					
		  					for(WebElement column:rowElements){
		  						System.out.println("column value "+column);
		  					    rowData.add(column.getText().toString());
		  					  System.out.println("rowData Values are<<<<<<<<<<<<<<<<<"+rowData);

		  					}
		  					System.out.println("rowData  Size "+rowData.size());
		  					String strMain = input[i][9];
						    String[] arrSplit4 = strMain.split(",");
						    System.out.println(arrSplit4);
						    int present = 0;
						    int notPresent = 0;
						    for(int rnum=0;rnum<arrSplit4.length;rnum++)
								{
						    	System.out.println(arrSplit4[rnum]);
						    	if (rowData.contains(arrSplit4[rnum]))
						    	{
						    		System.out.println("This Column is present"+arrSplit4[rnum]);
						    		present++;
						    		
						    	}
						    	else
						    	{
						    		System.out.println("This Column is not present"+arrSplit4[rnum]);
						    		notPresent++;
						    		
						    	}
								}
						    if (notPresent == 0)
						    {
						    	System.out.println("All the column is present");
					    		acop = "All the column is present";
					    		node.log(LogStatus.PASS, acop);
	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  							rc++;
	  							excel.writePass(tc, counter, sheet, acop);
						    }
						    else
						    {
						    	System.out.println("Some of the column values are wrong");
					    		acop = "Some of the column values are wrong";
					    		node.log(LogStatus.FAIL, acop);
	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
	  							rc++;
	  							String scr = s.CaptureScreenshot();
	  							excel.writeFail(tc, counter, sheet, acop,scr);
						    }
		  					}
						
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}

  						}catch(Exception e)
  						{e.printStackTrace();}
  					}
  					if (tc.equalsIgnoreCase("TC6"))
  					{
  						try
  						{
  							System.out.println("TC6 Execution started.....");
  						Thread.sleep(10000);
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  					
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("RefreshReport"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver)){
	  					if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("ODDashboard")), driver)))
	  					{
	  						System.out.println("Page not loaded Successfully");
  							acop = "Order Status Page not Loaded Successfully";
  							node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(tc, counter, sheet, acop,scr);
  							
	  					}
	  					else
	  					{
	  						System.out.println("Page loaded Successfully");
  							acop = "OrderStatus Page Loaded Successfully";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);
  							
	  					}	  					
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}

  						}catch(Exception e)
  						{e.printStackTrace();}
	  					
  					}
  					if (tc.equalsIgnoreCase("TC7"))
  					{
  						try
  						{
  						System.out.println("TC7 Execution started.....");
  						Thread.sleep(10000);
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						Thread.sleep(12000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver)){
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
						acop = "Order Disparity - Print window opened successfully";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {tc, "OrderManifest", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(tc, counter, sheet, acop);						
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}

						
  						}catch(Exception e)
						{e.printStackTrace();
  					}
  					}
  					if (tc.equalsIgnoreCase("TC8"))
  					{
  						try
  						{  					
  						Thread.sleep(5000);
  						System.out.println("TC8 Execution started.....");
  						Thread.sleep(15000);
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						Thread.sleep(1000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver)){
	  					ArrayList<String> tr=new ArrayList<String>();
  						int pageSize=0,recordsCount=0;
	  					driver.findElement(By.xpath(Object.getProperty("Downloadthispage"))).click();
	  					Thread.sleep(2000);
	  					WebElement ele = driver.findElement(By.xpath(".//*[@id='div-125-datagrid-tbody']"));
  						System.out.println(ele.getTagName());
  						List<WebElement>page=ele.findElements(By.tagName("tr"));
  						System.out.println("PageSize : "+page.size());
  						//System.out.println("PageSize : "+pageSize);
  						pageSize=page.size();
	  					try
	  					{
	  					BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\DisparityStatusReport.xls"));
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
							acop = "OrderDisparityt - Download Page successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(tc, counter, sheet, acop);
							
	  					}
	  					else if(pageSize == 0)
	  					{
	  						System.out.println("No record");
							acop = "No Record";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(tc, counter, sheet, acop);
	  					}
	  					else
	  					{
	  						System.out.println("Records count mismatch... Fail");
	  						acop = "Count mismatch";
	  						node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);
	  					}
	  					
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
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
	  				
  						System.out.println("TC9 Execution started.....");
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(12000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver)){
			  				if(s.unitofMeasure(driver, Object, Object.getProperty("OrdersClick"), Object.getProperty("ODClick"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
			  				{
			  					System.out.println("Time zone Displayed Successfully");
			  					acop = "Time zone displayed as expected";
			  					node.log(LogStatus.PASS, acop);
			  					data.put(""+rc, new Object[] {tc, "Ordermanifest", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
			  					rc++;
			  					excel.writePass(tc, counter, sheet, acop);
			  					
			  				}
			  				else
			  				{
			  					System.out.println("Time zone not Displayed ");
			  					acop = "Time zone not displayed as expected";
			  					node.log(LogStatus.FAIL, acop);
			  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
			  					rc++;
			  					String scr = s.CaptureScreenshot();
			  					excel.writeFail(tc, counter, sheet, acop,scr);
			  					
			  				}			  				
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
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
  						System.out.println("TC10 Execution started.....");
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
	  					
  						if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver))
	  					{
		  				if(s.unitofMeasure(driver, Object, Object.getProperty("OrdersClick"), Object.getProperty("ODClick"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
		  				{
		  					System.out.println("Temperature Unit Displayed Successfully");
		  					acop = "Temperature Unit displayed as expected";
		  					node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);
		  					
		  				}
		  				else
		  				{
		  					System.out.println("Temperature Unit not Displayed ");
		  					acop = "Temperature Unit not displayed as expected";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);
		  					
		  				}		  				
	  				
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
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
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver)){
		  				if(s.unitofMeasure(driver, Object, Object.getProperty("OrdersClick"), Object.getProperty("ODClick"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
		  				{
		  					System.out.println("Fuel Level Displayed Successfully");
		  					acop = "Fuel Level displayed as expected";
		  					node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderManifest", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);
		  					
		  				}
		  				else
		  				{
		  					System.out.println("Fuel Level not Displayed ");
		  					acop = "Fuel Level not displayed as expected";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);
		  					
		  				}		  				
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
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
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver)){
		  				if(s.unitofMeasure(driver, Object, Object.getProperty("OrdersClick"), Object.getProperty("ODClick"), Object.getProperty("DistanceCalcIcon"), Object.getProperty("DistanceTooltip"), Object.getProperty("DistanceTooltipval"), Object.getProperty("DistanceUnit")))
		  				{
		  					System.out.println("Distance Unit Displayed Successfully");
		  					acop = "Distance Unit displayed as expected";
		  					node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);
		  					
		  				}
		  				else
		  				{
		  					System.out.println("Distance Unit not Displayed ");
		  					acop = "Distance Unit not displayed as expected";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);
		  					
		  				}		  				
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
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
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver)){
	  					if (s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver))
	  					{
	  						System.out.println("Control Probe ICON Displayed Successfully");
		  					acop = "Control Probe ICON Displayed as expected";
		  					node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);
		  					
		  				}
		  				else
		  				{
		  					System.out.println("Control Probe ICON not Displayed ");
		  					acop = "Control Probe ICON not displayed as expected";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);
		  					
		  				}	  					
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
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
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver)){
	  					boolean strFilterResult = false;
  						strFilterResult = Cs.checkSortedValue(driver, Object, "125");
  						System.out.println("<<<<<<<<<<<<<<<<<<<<<Order Disparity Sorting Status>>>>>>>>>>>>>"+strFilterResult);
  						if (strFilterResult == true)
  						{
  							System.out.println("Column sorted successfully");
  							acop = "Column sorted successfully";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);
  						}
  						else
  						{
  							System.out.println("Column sorting Failed");
  							acop = "Column sorting Failed";
  							node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);
  						}
  					
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}

  						}catch(Exception e)
  						{e.printStackTrace();}
	  				}
  					if(tc.equalsIgnoreCase("TC15"))
	  				{
  						try
  						{
	  					System.out.println( "TC15 Execution started.....");
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  					
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);  						
	  					
	  					
	  					Thread.sleep(1000);	
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver)){
  						
  						WebElement Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));  						
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
  	  		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  	  		  					rc++;
  	  		  					excel.writePass(tc, counter, sheet, acop);  	  		  					
  							}
  							else
  							{
  								driver.findElement(By.xpath(Object.getProperty("PageDrpdown"))).click();
  	  							Thread.sleep(2000);
  	  							driver.findElement(By.xpath(Object.getProperty("PageValue"))).sendKeys(input[i][5]);
  	  							driver.findElement(By.xpath(Object.getProperty("PageSelect"))).click();
  	  							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  	  							Thread.sleep(1000);
  	  							
  	  							Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
  	  							PageList = Pagination.findElements(By.tagName("li"));
  	  							System.out.println(PageList.size());
  	  							for(int j=0;j<PageList.size();j++)
  	  							{
  	  								//PageList.get(j).getAttribute("class");
  		  							if(PageList.get(j).getText().equalsIgnoreCase(input[i][5]))
  									{
  		  								if(PageList.get(j).getAttribute("class").equalsIgnoreCase("active"))
  		  								{
  		  										acop = "Selected Page Displayed as expected";
  		  									node.log(LogStatus.PASS, acop);
  		  			  		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  		  			  		  					rc++;
  		  			  		  					excel.writePass(tc, counter, sheet, acop);  		  			  		  					
  		  			  		  					break;
  		  									}
  		  									else
  		  									{
  		  										System.out.println("Current Page doesnot match the Page which is selected ");
  		  			  		  					acop = "Pagination not displayed as expected";
  		  			  		  			node.log(LogStatus.FAIL, acop);
  		  			  		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
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
  		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
  		  					rc++;
  		  				String scr = s.CaptureScreenshot();
  		  					excel.writeFail(tc, counter, sheet, acop,scr);  		  					
  						}
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}

	  								
  						}catch(Exception e)
  						{e.printStackTrace();}
	  					
	  				}
  					if(tc.equalsIgnoreCase("TC16"))
	  				{
  						try
  						{
  							Thread.sleep(10000);
	  					System.out.println( "TC16 Execution started.....");
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver))
	  					{
	  					if(s.isElementPresent(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr"), driver))
	  					{
						Select se = new Select(driver.findElement(By.id("per-page__select")));
						List<WebElement> l = se.getOptions();
						l.size();
						System.out.println("No.of Rows in dropdown"+l.size());
						driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
						Thread.sleep(1000);
						String[] dropVal = new String[l.size()+1];
						boolean flagVal = false;
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
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
		  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li["+sel+"]")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  						Thread.sleep(1000);
	  						
							WebElement ele = driver.findElement(By.xpath(".//*[@id='div-125-datagrid-tbody']"));
	  						System.out.println(ele.getTagName());
	  						List<WebElement>page=ele.findElements(By.tagName("tr"));
	  						System.out.println("PageSize : "+page.size());
	  						System.out.println(pageCnt[0]+"="+page.size());
	  						if (pageCnt[0].equals(""+page.size()))
	  						{
	  							System.out.println(page.size()+" Per page loaded successfully");
	  							flagVal = true;
			  					
			  					
			  				}
			  				else
			  				{
			  					System.out.println(page.size()+" Per page not loaded");
			  					flagVal = false;			  					
			  					
			  				}
	  						
	  						
							
						}
						if (flagVal == true)
						{
							acop = "Pages Loaded successfully";
							node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);
						}
						else
						{
							acop = "Pages not Loaded successfully";
							node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);
						} 				
						
						driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
						driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li[2]")).click();
	  					}
	  					else
	  					{
	  						acop = "No data ";
							node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);
	  					}
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}

  						}catch(Exception e)
  						{e.printStackTrace();}
	  					
	  				}
  					if(tc.equalsIgnoreCase("TC17"))
	  				{
  						try
  						{	  
	  					System.out.println( "TC17 Execution started.....");
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  					
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver)){
	  					driver.findElement(By.xpath(".//*[@id='table-col-125--all-none']/label/span[2]/span")).click();
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
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);		  					
		  				}
		  				else
		  				{
		  					System.out.println(" Per page not loaded");
		  					acop = " Per Page not Loaded successfully";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);		  					
		  				}
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}

  						}catch(Exception e)
  						{e.printStackTrace();}
	  				}
  					
  					if (tc.equalsIgnoreCase("TC18"))
  					{
  						try
  						{  		
  							String[] expt= null;
  						System.out.println( "TC18 Execution started.....");  						
  						
  						System.out.println("Page Refreshing");
  						
  						driver.navigate().refresh();
  	  					Thread.sleep(2000);
  	  					if(s.isAlertPresent(driver))
  	  					{
  	  						driver.switchTo().alert().accept();
  	  					}
  	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
  						
  	  				Thread.sleep(10000);
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver))
	  					{
	  					WebDriverWait wait1 = new WebDriverWait(driver, 10);
	  					wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(Object.getProperty("MoreActions"))));
	  					driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
	  					//Please select a Asset
	  					String getVal = driver.findElement(By.xpath(Object.getProperty("LUErrorPopup1"))).getText();
	  					if (eopt.contains("#"))
	  					{
	  						 expt = eopt.split("#");
	  						if (getVal.equals(expt[0]) || getVal.equals(expt[1]) || getVal.equals(expt[2]) || getVal.equals(expt[2]))
	  						{
	  							System.out.println("Alert Message should display Please Select a Asset message");
	  							System.out.println("Actual"+getVal);
	  							//System.out.println("Filter functionality is working fine");
  								acop = "Error Message = "+getVal;
  								node.log(LogStatus.PASS, acop);
  	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, expt[0], acop, "Pass", s.timestamp(stime)});
  	  							rc++;
  	  							excel.writePass(tc, counter, sheet, acop);
	  						}
	  						else
	  						{
	  							System.out.println("Popup is not coming");
	  							acop = "Error Message = "+getVal;
	  							node.log(LogStatus.FAIL, acop);
	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, expt[0], acop, "Fail", s.timestamp(stime)});
	  							rc++;
	  							String scr = s.CaptureScreenshot();
	  							excel.writeFail(tc, counter, sheet, acop,scr);
	  							
	  						}	  						
	  						
	  						Thread.sleep(2000);
	  							driver.findElement(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr[1]/td[1]/label/span[2]/span")).click();
	  						driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
	  						if(s.isElementPresentcheck(By.xpath(Object.getProperty("LUClearAlarm")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("ODMoreActionAck")),driver)) 
	  			  					
	  			  			       {
	  							System.out.println("All the fields are present inside the More Action");
	  							
	  			  			       }
	  						else
	  						{
	  							System.out.println("Some values are wrong");
	  						}
	  						
	  					
	  					
	  					driver.findElement(By.xpath(Object.getProperty("LUClearAlarm"))).click();
	  					if(s.isElementPresentcheck(By.xpath(Object.getProperty("LUSendCommand")), driver))
	  					{
	  					driver.findElement(By.xpath(Object.getProperty("LUSendCommand"))).click();
	  					}
	  					
	  					if(s.isAlertPresent(driver))
							{
								Alert alert;
								alert = driver.switchTo().alert();
								System.out.println(alert.getText());
								String chk1 = driver.switchTo().alert().getText();
								alert.accept();
							}
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						{
  							
  							System.out.println("inside while");
  							Thread.sleep(1000);
  						}
	  					String getVal1 = driver.findElement(By.xpath(Object.getProperty("LUErrorPopup1"))).getText();
	  					System.out.println("::::::::::::::::::"+getVal1);
	  					if (eopt.contains("#"))
	  					{
	  						 expt = eopt.split("#");
	  						if (getVal1.equals(expt[4]) || getVal1.equals(expt[1]) || getVal1.equals(expt[2]) || getVal1.equals(expt[2]))
	  						{
	  							System.out.println("Clear Alarms should display a screen where the radio button is already checked for clear Alarms. Buttons: Send command or cancel button");
	  							System.out.println("Actual"+getVal1);
	  							System.out.println("Filter functionality is working fine");
  								acop = "Popup Message = "+getVal1;
  								node.log(LogStatus.PASS, acop);
  	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, expt[1], acop, "Pass", s.timestamp(stime)});
  	  							rc++;
  	  							excel.writePass(tc, counter, sheet, acop);
	  						}
	  						else
	  						{
	  							System.out.println("Popup is not coming");
	  							acop = "Popup Message = "+getVal1;
	  							node.log(LogStatus.FAIL, acop);
	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, expt[1], acop, "Fail", s.timestamp(stime)});
	  							rc++;
	  							String scr = s.CaptureScreenshot();
	  							excel.writeFail(tc, counter, sheet, acop,scr);	  							
	  						}
	  					}
	  					System.out.println("subtest case 4 is excuting");
	  					driver.findElement(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr[2]/td[1]/label/span[2]/span")).click();
  						driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
  						Thread.sleep(2000);
  						
	  					//driver.findElement(By.xpath(Object.getProperty("ODMoreActionAck"))).click();
	  					driver.findElement(By.xpath(".//*[@id='btn-Ack-command']/button")).click();
	  					Thread.sleep(1000);
	  					WebDriverWait wait = new WebDriverWait(driver, 10);
	  					wait.until(ExpectedConditions.alertIsPresent());
	  					if(s.isAlertPresent(driver))
							{
	  						driver.switchTo().alert().accept();
							}
	  					
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						{
  							
  							System.out.println("inside while");
  							Thread.sleep(1000);
  						}
	  					////////////////////////////////////////////////////////////////////////////////////////////////////////
	  					String getVal2 = driver.findElement(By.xpath(Object.getProperty("LUErrorPopup1"))).getText();
	  					System.out.println("<<<<<<<<<<<<<<<<<<popup value = "+getVal2);
	  					
	  					if (eopt.contains("#"))
	  					{
	  						 expt = eopt.split("#");
	  						if (getVal2.equals(expt[0]) || getVal2.equals(expt[1]) || getVal2.equals(expt[2]) || getVal2.equals(expt[2]))
	  						{
	  							System.out.println("Clear Alarms should display a screen where the radio button is already checked for clear Alarms. Buttons: Send command or cancel button");
	  							System.out.println("Actual"+getVal2);
	  							System.out.println("More Action is working fine");
  								acop = "Popup Message = "+getVal2;
  								node.log(LogStatus.PASS, acop);  								
  	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, expt[2], acop, "Pass", s.timestamp(stime)});
  	  							rc++;
  	  							excel.writePass(tc, counter, sheet, acop);
	  						}
	  						else
	  						{
	  							System.out.println("Popup is not coming");
	  							
	  							acop = "Popup Message = "+getVal2;
	  							node.log(LogStatus.FAIL, acop);
	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, expt[2], acop, "Fail", s.timestamp(stime)});
	  							rc++;
	  							String scr = s.CaptureScreenshot();
	  							excel.writeFail(tc, counter, sheet, acop,scr);
	  							
	  						}	  						
	  					}
	  					}
	  					else
	  					{
	  						
								acop = "No data ";
								node.log(LogStatus.PASS, acop);  								
	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, expt[2], acop, "Pass", s.timestamp(stime)});
	  							rc++;
	  							excel.writePass(tc, counter, sheet, acop);
	  					}
	  					}
	  					else
	  					{
	  						acop = "No data ";
							node.log(LogStatus.PASS, acop);  								
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);
	  						
	  					}  						

  						}catch(Exception e)
  						{e.printStackTrace();}
	  					
	  				}
  					if (tc.equalsIgnoreCase("TC19"))
  					{
  						try
  						{
  						System.out.println( "TC19 Execution started.....");
  						//System.out.println("Subtest case 2 is executing");
  						Thread.sleep(10000);
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						Thread.sleep(10000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  							Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("ODClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(s.isElementPresentcheck(By.xpath(".//*[@id='div-125-datagrid-tbody']/tr"), driver)){
	  					driver.findElement(By.xpath(Object.getProperty("ODReeferDataClick"))).click();
	  					if (s.isElementPresent(By.xpath(".//*[@id='table-group--reeferData']"),driver))
	  					{				
	  							acop = "Reefer Data is dispalyed in Dashboard";
	  							node.log(LogStatus.PASS, acop);
	  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
	  							rc++;
	  							excel.writePass(tc, counter, sheet, acop);
	  						
	  					}
	  					else
	  					{
	  						
	  						acop = "Reefer Data is not dispalyed in Dashboard";
	  						node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(tc, counter, sheet, acop,scr);
	  					}
	  					driver.findElement(By.xpath(Object.getProperty("ODReeferDataClick"))).click();
	  					if (s.isElementPresent(By.xpath(".//*[@id='table-group--reeferData']"),driver))
	  					{
	  						acop = "Reefer Data is  dispalyed in Dashboard without seleting ReeferData checkbox";
	  						node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(tc, counter, sheet, acop,scr);
	  					}
	  					else
	  					{
	  						acop = "Reefer Data is not dispalyed in Dashboard, because Reefer data check box is uncheked";
	  						node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);
	  					}
  						}else
	  					{
	  					
  							acop = "No data ";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "OrderDisparity", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);  							
	  					}

  						}catch(Exception e)
  						{e.printStackTrace();}
  					
	  					
  					}
  				
					
					
				}
			}
			
				}catch(Exception e)
				{
					e.printStackTrace();
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
