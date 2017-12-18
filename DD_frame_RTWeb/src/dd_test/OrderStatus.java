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

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.LogisticUtils;
import dd_utils.TestUtil;

public class OrderStatus extends TestCore 
{
	static TestUtil s =new TestUtil();
	static LogisticUtils Cs =new LogisticUtils();
		
	@Test
	public static Map<String, Object[]> OrderStatustestcase(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test ,int scase,int ecase) 
	{
		String acop =null;
		int counter =1;
		ExtentTest node = reports.startTest("OrderStatus");
		String[][] input =TestUtil.getData("OrderStatus");
		
		try
		{
			driver = new FirefoxDriver(s.excelDownload());
			driver.get(Object.getProperty("URL"));
			if(s.dologin(driver ,input[0][2], input[0][3]))
			{
				System.out.println("Order Status Module");
			for(int i=scase-1;i<ecase;i++ )
			{								
				long stime=System.currentTimeMillis();
				String sDate =s.dateConvert(input[i][6]);
  				String eDate =s.dateConvert(input[i][7]);
  				if (input[i][0].equalsIgnoreCase("TC1"))
  				{
  					
  					try
  					{
  						System.out.println("TC1 Execution started.....");
  						Thread.sleep(8000);
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						Thread.sleep(8000);
  						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
  						driver.findElement(By.xpath(Object.getProperty("OSFrozenFoodSelect"))).click();
  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
  						driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
  						if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("OSDashboard")), driver)))
  						{
  							System.out.println("Page not loaded Successfully");
  							acop = "Order Status Page not Loaded Successfully";
  							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
							rc++;
							String scr = s.CaptureScreenshot();
							excel.writeFail(input[i][0], counter, sheet, acop,scr);							
  					}
  					else
  					{
  							System.out.println("Page loaded Successfully");
							acop = "Order Status Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(input[i][0], counter, sheet, acop);							
  					}
  					}catch(Exception e)
  					{e.printStackTrace();}  				
  				
  				}
  				
  				if (input[i][0].equalsIgnoreCase("TC2"))
				{
  					try
  					{						
						System.out.println("TC2 Execution started.....");
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
						  				
  						driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
  						driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
  						driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
					
  						if(s.isElementPresentcheck(By.xpath(".//*[@id='div-121-datagrid-tbody']/tr/td[1]/a"), driver))
  						{
  						
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
  						
  					
  						if (assetName.equalsIgnoreCase(input[i][5]))
  						{
  							System.out.println("Search value displayed Successfully");
							acop = "Selected search value"+ assetName +" displayed Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(input[i][0], counter, sheet, acop);
							
							
  						}
  						else
  						{
  							System.out.println("Search value not displayed ");
							acop = "Selected search value"+ assetName +" not displayed Successfully";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
							rc++;
							String scr= s.CaptureScreenshot();
							excel.writeFail(input[i][0], counter, sheet, acop,scr);
							
							
  					}
  						}
  						else
  						{
  							System.out.println("No data");
						acop = "No data";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(input[i][0], counter, sheet, acop);
  						
  						
  						}
  						driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
  						
  					}catch(Exception e)
  					{e.printStackTrace();}

				}
  				
  				
  				
				if (input[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						System.out.println("TC3 Execution started.....");
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
						driver.findElement(By.xpath(Object.getProperty("OSFrozenFoodSelect"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
						if(s.isElementPresentcheck(By.xpath(".//*[@id='div-121-datagrid-tbody']/tr/td[1]/a"), driver))
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
  								
  							}
  							else
  							{
  							String EndDateGet = driver.findElement(By.xpath(Object.getProperty("OSStartDate"))).getText();
  							driver.findElement(By.xpath(Object.getProperty("OSStartDateClick"))).click();
  							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  	  						
  	  							Thread.sleep(1000);
  	  						  							
  							String StartDateGet = driver.findElement(By.xpath(Object.getProperty("OSStartDate"))).getText();
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
  								
  								System.out.println("Search value not displayed ");
  	  							acop = "Date not in range";
  	  							node.log(LogStatus.FAIL, acop);
  	  							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
  	  							rc++;
  	  							String scr = s.CaptureScreenshot();
  	  							excel.writeFail(input[i][0], counter, sheet, acop,scr); 	  							
  								
  		  					}
  		  					else
  		  					{
  		  						acop = "Date within range";
								node.log(LogStatus.PASS, acop);
	  							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
	  							rc++;
	  							excel.writePass(input[i][0], counter, sheet, acop);	  							
  	  						
  		  					}
  							
  							
  							}
						
  						}
  						s.clearDateRange(driver, Object);
  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  						
  							Thread.sleep(1000);
  						
  						}
  						else
  						{
  							System.out.println("No data");
						acop = "No data";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(input[i][0], counter, sheet, acop);
  						
  						
  						}
					}catch(Exception e)
					{e.printStackTrace();}
					}
					
				if (input[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						System.out.println( "TC4 Execution started.....");
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
						driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("OSShowFilter"))).click();
						if((!(s.isElementPresentcheck(By.xpath(Object.getProperty("OSOrigin")),driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("OSDestination")),driver)) ||
		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("OSDisparity")),driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("OSBusinessCode")),driver)) ||
		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("OSCallType")),driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("OSFCDM")),driver)) ||
		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("OSDisparityStatus")),driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("OSOrderStatus")),driver)) ||
		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("OSAckStatus")),driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("OSApplyButton")),driver))))
		  			       {
		  						System.out.println("Some of the values are wrong");
		  			       }
		  					else
		  					{
		  						System.out.println("Verified the values in SHow Filter pop up");
		  					}
						System.out.println(driver.findElement(By.xpath(".//*[@id='div-121-filters']/div/div/div[1]/div[1]/label")).getText());
						if (driver.findElement(By.xpath(".//*[@id='div-121-filters']/div/div/div[1]/div[1]/label")).getText().equals("Origin"))
						{
  						
							driver.findElement(By.xpath(Object.getProperty("OSOrigin"))).clear();
							driver.findElement(By.xpath(Object.getProperty("OSOrigin"))).sendKeys("LANCTX");
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("OSApplyButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							{
								Thread.sleep(1000);
							}
  							WebElement ele1 = driver.findElement(By.xpath(".//*[@id='div-121-datagrid-tbody']"));
  							System.out.println(ele1.getTagName());
  							List<WebElement>page1=ele1.findElements(By.tagName("tr"));
  							System.out.println("PageSize : "+page1.size());
  							for (int p = 1; p <=page1.size();p++)
  							{
  								String getVal = driver.findElement(By.xpath(".//*[@id='div-121-datagrid-tbody']/tr["+p+"]/td[11]")).getText();
  								//System.out.println(getVal);
  								if (getVal.equals("LANCTX"))
								{
  									System.out.println("Filterex Value displayed");
								}
  								else
  								{	
  									System.out.println("Some Values are wrong");
  								}
  							}
  							driver.findElement(By.xpath(Object.getProperty("OSShowFilter"))).click();
  							s.clearFilter(driver, Object, "OSClearFilter");					
  					}
						System.out.println("<<<<<<<<<<<<<<<<<<<<<< Destination>>>>>>>>>>>>>>>>>>>>");
  						driver.findElement(By.xpath(Object.getProperty("OSShowFilter"))).click();
  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  						
  							Thread.sleep(1000);
  						
  						driver.findElement(By.xpath(Object.getProperty("OSDestination"))).clear();
  						driver.findElement(By.xpath(Object.getProperty("OSDestination"))).sendKeys("DUNDFL");
  						driver.findElement(By.xpath(Object.getProperty("OSApplyButton"))).click();
  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  						
  							Thread.sleep(1000);
  						
  						WebElement ele1 = driver.findElement(By.xpath(".//*[@id='div-121-datagrid-tbody']"));
						System.out.println(ele1.getTagName());
						List<WebElement>page1=ele1.findElements(By.tagName("tr"));
						System.out.println("PageSize : "+page1.size());
						for (int p = 1; p <=page1.size();p++)
						{
							String getVal = driver.findElement(By.xpath(".//*[@id='div-121-datagrid-tbody']/tr["+p+"]/td[12]")).getText();
							//System.out.println(getVal);
							if (getVal.equals("DUNDFL"))
							{
								System.out.println("Filtered Value displayed");
							}
							else
							{
								System.out.println("Some Values are wrong");
							}
						}
						driver.findElement(By.xpath(Object.getProperty("OSShowFilter"))).click();
						s.clearFilter(driver, Object, "OSClearFilter");
  						
  					driver.findElement(By.xpath(Object.getProperty("OSShowFilter"))).click();
  					
						
						//checkFilterValue(WebDriver driver, Properties Object, String strReportCode, String selFilterOption, String columnToCheck, boolean isSendKeyPresent, String columnType, String xPathApplyButton)
						boolean strFilterResult = false;
						strFilterResult = Cs.disparity(driver, Object, "121", "disparityCodeFilter", "2", true, "Anchor", "OSApplyButton","OSClearFilter");
						//s.clearFilter(driver, Object, "OSClearFilter");
						System.out.println("<<<<<<<<<<<<<<<<<<<<<Disparity Filter Status>>>>>>>>>>>>>"+strFilterResult);
						if (strFilterResult == true)
						{
							acop = "Displayed filter values are correct";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(input[i][0], counter, sheet, acop);
						}
						else
						{
							acop = "Displayed filter values are wrong";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(input[i][0], counter, sheet, acop,scr);
						}
						
						strFilterResult = Cs.disparity(driver, Object, "121", "businessCode", "13", false, "Text", "OSApplyButton","OSClearFilter");
						//s.clearFilter(driver, Object, "OSClearFilter");
						System.out.println("<<<<<<<<<<<<<<<<<<<Business Code Filter Status>>>>>>>>>>>>>"+strFilterResult);
						
						if (strFilterResult == true)
						{
							acop = "Displayed filter values are correct";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(input[i][0], counter, sheet, acop);
						}
						else
						{
							acop = "Displayed filter values are wrong";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(input[i][0], counter, sheet, acop,scr);
						}
						strFilterResult = Cs.disparity(driver, Object, "121", "callType", "4", false, "Text", "OSApplyButton","OSClearFilter");
						//s.clearFilter(driver, Object, "OSClearFilter");
						System.out.println("<<<<<<<<<<<<<<<<<<<Call Type Filter Status>>>>>>>>>>>>>"+strFilterResult);
						
						if (strFilterResult == true)
						{
							acop = "Displayed filter values are correct";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(input[i][0], counter, sheet, acop);
						}
						else
						{
							acop = "Displayed filter values are wrong";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(input[i][0], counter, sheet, acop,scr);
						}
						strFilterResult = Cs.disparity(driver, Object, "121", "commodityType", "15", false, "Text", "OSApplyButton","OSClearFilter");
						//s.clearFilter(driver, Object, "OSClearFilter");
						System.out.println("<<<<<<<<<<<<<<<<<<<FCDM Filter Status>>>>>>>>>>>>>"+strFilterResult);
						
						if (strFilterResult == true)
						{
							acop = "Displayed filter values are correct";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(input[i][0], counter, sheet, acop);
						}
						else
						{
							acop = "Displayed filter values are wrong";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(input[i][0], counter, sheet, acop,scr);
						}
						strFilterResult = Cs.disparity(driver, Object, "121", "disparityStatus", "2", false, "Anchor", "OSApplyButton","OSClearFilter");
						//s.clearFilter(driver, Object, "OSClearFilter");
						System.out.println("<<<<<<<<<<<<<<<<<<<Disparity Status Filter Status>>>>>>>>>>>>>"+strFilterResult);
						
						if (strFilterResult == true)
						{
							acop = "Displayed filter values are correct";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(input[i][0], counter, sheet, acop);
						}
						else
						{
							acop = "Displayed filter values are wrong";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(input[i][0], counter, sheet, acop,scr);
						}
						Thread.sleep(8000);
						strFilterResult = Cs.disparity(driver, Object, "121", "orderStatus", "7", false, "Text", "OSApplyButton","OSClearFilter");
						//s.clearFilter(driver, Object, "OSClearFilter");
						System.out.println("<<<<<<<<<<<<<<<<<<<Disparity Status Filter Status>>>>>>>>>>>>>"+strFilterResult);
						
						if (strFilterResult == true)
						{
							acop = "Displayed filter values are correct";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(input[i][0], counter, sheet, acop);
						}
						else
						{
							acop = "Displayed filter values are wrong";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(input[i][0], counter, sheet, acop,scr);
						}
						strFilterResult = Cs.disparity(driver, Object, "121", "ackStatus", "2", false, "Anchor", "OSApplyButton","OSClearFilter");
						//s.clearFilter(driver, Object, "OSClearFilter");
						System.out.println("<<<<<<<<<<<<<<<<<<<Acknowledge Status Filter Status>>>>>>>>>>>>>"+strFilterResult);
						
						if (strFilterResult == true)
						{
							acop = "Displayed filter values are correct";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(input[i][0], counter, sheet, acop);
						}
						else
						{
							acop = "Displayed filter values are wrong";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(input[i][0], counter, sheet, acop,scr);
						}
					}catch(Exception e)
					{e.printStackTrace();}
					}
								
				if (input[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
						System.out.println( "TC5 Execution started.....");
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
						driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
					
						List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-121-datagrid']/div/table[1]/thead/tr[2]"));
	  					List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
	  					System.out.println("No.of rows "+rows.size());
	  					for(WebElement row:rows){
	  					List<WebElement> rowElements = row.findElements(By.xpath("th"));	  	
	  							//System.out.println("rowelement value"+rowElements);

	  					ArrayList<String> rowData = new ArrayList<String>();
	  					
	  					for(WebElement column:rowElements){
	  						
	  					    rowData.add(column.getText().toString());
	  					 //System.out.println("column value "+column);
	  					    System.out.println("rowData Values are"+rowData);

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
					    		System.out.println("This Column is present "+arrSplit4[rnum]);
					    		present++;
					    		
					    	}
					    	else
					    	{
					    		System.out.println("This Column is not present "+arrSplit4[rnum]);
					    		notPresent++;
					    		
					    	}
							}
					    if (notPresent == 0)
					    {
					    	System.out.println("All the column is present");
				    		acop = "All the column is present";
				    		node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(input[i][0], counter, sheet, acop);
					    }
					    else
					    {
					    	System.out.println("Some of the column values are wrong");
				    		acop = "Some of the column values are wrong";
				    		node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(input[i][0], counter, sheet, acop,scr);
					    }
	  					}
						
						
	  					
					}catch(Exception e)
					{e.printStackTrace();}
					
				}
				
				
			if (input[i][0].equalsIgnoreCase("TC6"))
			{
				try
				{
					System.out.println( "TC6 Execution started.....");
					Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
					Thread.sleep(5000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
							Thread.sleep(1000);
					
  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
							Thread.sleep(1000);
					
  					driver.findElement(By.xpath(Object.getProperty("RefreshReport"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					

							Thread.sleep(1000);
					
  					if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("OSDashboard")), driver)))
  					{
  							System.out.println("Page not loaded Successfully");
							acop = "Order Status Page not Loaded Successfully";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
							rc++;
							String scr = s.CaptureScreenshot();
							excel.writeFail(input[i][0], counter, sheet, acop,scr);
							
  					}
  					else
  					{
  							System.out.println("Page loaded Successfully");
							acop = "OrderStatus Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(input[i][0], counter, sheet, acop);
							
  					}  					
				}catch(Exception e)
				{e.printStackTrace();}
  					
				}
			
				if (input[i][0].equalsIgnoreCase("TC7"))
				{
					try
					{
						System.out.println( "TC7 Execution started.....");
						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
						driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);					
  					
  					
						String parentHandle = driver.getWindowHandle(); // get the current window handle
						System.out.println(parentHandle);
						driver.findElement(By.xpath(Object.getProperty("Printthispage"))).click();
						for (String winHandle : driver.getWindowHandles()) 
						{ //Gets the new window handle
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
						acop = "Order Status - Print window opened successfully";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(input[i][0], counter, sheet, acop);
						
					}catch(Exception e)
					{e.printStackTrace();}
				}
				
				if (input[i][0].equalsIgnoreCase("TC8"))
				{
					try
					{
						ArrayList<String> tr=new ArrayList<String>();
						int pageSize=0,recordsCount=0;
						System.out.println( "TC8 Execution started.....");
						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
						driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
									Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("Downloadthispage"))).click();
						Thread.sleep(2000);
						WebElement ele = driver.findElement(By.xpath(".//*[@id='div-121-datagrid-tbody']"));
						System.out.println(ele.getTagName());
						List<WebElement>page=ele.findElements(By.tagName("tr"));
						System.out.println("PageSize : "+page.size());
						pageSize=page.size();
  					try
  					{
  					BufferedReader reader = new BufferedReader(new FileReader("\\\\amxserver\\amx-share\\STW_QA\\Rtweb Automation\\Downloaded Excel\\OrderStatusReport.xls"));
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
						acop = "OrderStatus - Download Page successfully";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(input[i][0], counter, sheet, acop);
						
  					}
  					else
  					{
  						System.out.println("Records count mismatch... Fail");
  						acop = "Count mismatch";
  						node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(input[i][0], counter, sheet, acop,scr);
  					}
  					
					}catch(Exception e)
					{e.printStackTrace();}

				}
				
				
				if(input[i][0].equalsIgnoreCase("TC9"))
  				{
					try
					{
						System.out.println( "TC9 Execution started.....");
						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
						driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))				

							Thread.sleep(1000);
					
		  				if(s.unitofMeasure(driver, Object, Object.getProperty("OrdersClick"), Object.getProperty("OrdersClick"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
		  				{
		  					System.out.println("Time zone Displayed Successfully");
		  					acop = "Time zone displayed as expected";
		  					node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(input[i][0], counter, sheet, acop);
		  					
		  				}
		  				else
		  				{
		  					System.out.println("Time zone not Displayed ");
		  					acop = "Time zone not displayed as expected";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String  scr = s.CaptureScreenshot();
		  					excel.writeFail(input[i][0], counter, sheet, acop,scr);
		  					
		  				}
		  			
					}catch (Exception e)
					{e.printStackTrace();}
		  					
		  		}
  				
				
  				if(input[i][0].equalsIgnoreCase("TC10"))
  				{
  					try
  					{
  						System.out.println( "TC10 Execution started.....");
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
  						driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
  						driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
							Thread.sleep(1000);
						
  						if(s.unitofMeasure(driver, Object, Object.getProperty("OrdersClick"), Object.getProperty("OrdersClick"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
  						{
  							System.out.println("Temperature Unit Displayed Successfully");
  							acop = "Temperature Unit displayed as expected";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(input[i][0], counter, sheet, acop);	  					
  						}
  						else
  						{
  							System.out.println("Temperature Unit not Displayed ");
	  						acop = "Temperature Unit not displayed as expected";
	  						node.log(LogStatus.FAIL, acop);
	  						data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
	  						rc++;
	  						String scr = s.CaptureScreenshot();
	  						excel.writeFail(input[i][0], counter, sheet, acop,scr);
	  					
	  				}
	  				
  					}catch(Exception e )
  					{e.printStackTrace();}
  				}

  				
  				if(input[i][0].equalsIgnoreCase("TC11"))
  				{
  					try
  					{
  						System.out.println( "TC11 Execution started.....");
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
  							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
							Thread.sleep(1000);
						
  							driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
  							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
							Thread.sleep(1000);
					
  						if(s.unitofMeasure(driver, Object, Object.getProperty("OrdersClick"), Object.getProperty("OrdersClick"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
  						{
  							System.out.println("Fuel Level Displayed Successfully");
  							acop = "Fuel Level displayed as expected";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(input[i][0], counter, sheet, acop);
  							
  						}
  						else
  						{
  							System.out.println("Fuel Level not Displayed ");
  							acop = "Fuel Level not displayed as expected";
  							node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr= s.CaptureScreenshot();
  							excel.writeFail(input[i][0], counter, sheet, acop,scr);
	  					
  						}	  				
  					}catch(Exception e)
  					{e.printStackTrace();}
  				}
  				

  				if(input[i][0].equalsIgnoreCase("TC12"))
  				{
  					try
  					{
  					System.out.println( "TC12 Execution started.....");
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
							Thread.sleep(1000);
					
  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
					
	  				if(s.unitofMeasure(driver, Object, Object.getProperty("OrdersClick"), Object.getProperty("OrdersClick"), Object.getProperty("DistanceCalcIcon"), Object.getProperty("DistanceTooltip"), Object.getProperty("DistanceTooltipval"), Object.getProperty("DistanceUnit")))
	  				{
	  					System.out.println("Distance Unit Displayed Successfully");
	  					acop = "Distance Unit displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(input[i][0], counter, sheet, acop);	  					
	  				}
	  				else
	  				{
	  					System.out.println("Distance Unit not Displayed ");
	  					acop = "Distance Unit not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(input[i][0], counter, sheet, acop,scr);
	  					
	  				}
	  				
  					}catch(Exception e)
  					{e.printStackTrace();}
  				}
	  			
  				if(input[i][0].equalsIgnoreCase("TC13"))
  				{
  					try
  					{
  						System.out.println( "TC13 Execution started.....");
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
  						driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
  						driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
						
  					if (s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver))
  					{
  						System.out.println("Control Probe ICON Displayed Successfully");
	  					acop = "Control Probe ICON Displayed as expected";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(input[i][0], counter, sheet, acop);
	  					
	  				}
	  				else
	  				{
	  					System.out.println("Control Probe ICON not Displayed ");
	  					acop = "Control Probe ICON not displayed as expected";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(input[i][0], counter, sheet, acop,scr);
	  					
	  				}
  					  					
  					}catch(Exception e)
  					{e.printStackTrace();}
  				}
  				
  				if(input[i][0].equalsIgnoreCase("TC14"))
  				{
  					
  					try
  					{
  						System.out.println( "TC14 Execution started.....");
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
  						driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
  						driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
  						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
					
  						boolean strFilterResult = false;
						strFilterResult = Cs.checkSortedValue(driver, Object, "121");
						System.out.println("<<<<<<<<<<<<<<<<<<<<<Order Status Sorting Status>>>>>>>>>>>>>"+strFilterResult);
						if (strFilterResult == true)
						{
							System.out.println("Column sorted successfully");
							acop = "Column sorted successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(input[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Column sorting Failed");
							acop = "Column sorting Failed";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
							rc++;
							String scr = s.CaptureScreenshot();
							excel.writeFail(input[i][0], counter, sheet, acop,scr);
						}					
  					}catch(Exception e)
  					{e.printStackTrace();}
  				}
  				
  				
  				if(input[i][0].equalsIgnoreCase("TC15"))
  				{
  					try
  					{
  					System.out.println( "TC15 Execution started.....");
  					Thread.sleep(8000);
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					Thread.sleep(8000);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
					
  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
				
  					WebElement htmltable=driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
					List<WebElement> rows=htmltable.findElements(By.tagName("li"));
					System.out.println("No. of Rows in the WebTable: "+rows.size());
					
				for(int rnum=1;rnum<=rows.size()-1;rnum++)
				{
					String pageNav = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul/li["+rnum+"]")).getText();
					if (s.isElementPresentcheck(By.xpath(".//*[@id='pagination-holder']/ul/li["+rnum+"]"), driver))
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
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  						
  							Thread.sleep(1000);
  						
					}
					if(click == rows.size()-1)
					{
						driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul/li["+click+"]")).click();
						System.out.println("Next button clicked successfully");
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  							Thread.sleep(1000);
  						
					}
				}
  					
				if(s.isElementPresentcheck(By.xpath(".//*[@id='pagination-holder']/ul/li[9]/div/div/div/a"), driver))
				{
  					driver.findElement(By.xpath(Object.getProperty("LUPageDropdoen"))).click();
  					Thread.sleep(1000);
  					driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul/li[9]/div/div/div/div/div/input")).sendKeys("2");
  					Thread.sleep(1000);
  					//driver.findElement(By.xpath(Object.getProperty(".//*[@id='pagination-holder']/ul/li[9]/div/div/div/div/ul/li[1]/em"))).click();
  					Robot robot = new Robot();
  					robot.keyPress(KeyEvent.VK_ENTER);
  					robot.keyRelease(KeyEvent.VK_ENTER);
  					Thread.sleep(2000);
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
  						String Val = driver.findElement(By.xpath(Object.getProperty("DAGetNoOfPages"))).getText();
  						String [] arrVal = Val.split(" ");
  						if (arrVal[0].equalsIgnoreCase("21"))
  							{
  						System.out.println("Clicked Page Loaded successfully");
	  					acop = "Clicked Page Loaded successfully";
	  					node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(input[i][0], counter, sheet, acop);
	  					
	  				}
	  				else
	  				{
	  					System.out.println("Clicked page not loaded");
	  					acop = "Page not loaded";
	  					node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(input[i][0], counter, sheet, acop,scr);
	  					
  					}
  					
				}
				else
				{	
					System.out.println("No data");
					acop = "No data";
					node.log(LogStatus.PASS, acop);
					data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
					rc++;
					excel.writePass(input[i][0], counter, sheet, acop);
				}
  					}catch(Exception e)
  					{e.printStackTrace();}
  					
  				}
  				if(input[i][0].equalsIgnoreCase("TC16"))
  				{
  					try
  					{
  					System.out.println( "TC16 Execution started.....");
  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
					
  					driver.findElement(By.xpath(Object.getProperty("OrdersClick"))).click();
  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
						
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
  						{
  							
  							System.out.println("inside while");
  							Thread.sleep(1000);
  						}
						WebElement ele = driver.findElement(By.xpath(".//*[@id='div-121-datagrid-tbody']"));
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
					if (flagVal = true)
					{
						acop = "All the Pages Loaded successfully";
						node.log(LogStatus.PASS, acop);
	  					data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Pass", s.timestamp(stime)});
	  					rc++;
	  					excel.writePass(input[i][0], counter, sheet, acop);
	  					
					}
					else
					{
						acop = "Pages not Loaded successfully";
						node.log(LogStatus.FAIL, acop);
	  					data.put(""+rc, new Object[] {input[i][0], "OrderStatus",input[i][1], input[i][8], acop, "Fail", s.timestamp(stime)});
	  					rc++;
	  					String scr = s.CaptureScreenshot();
	  					excel.writeFail(input[i][0], counter, sheet, acop,scr);
	  					
					}
				
					
					driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
					driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li[2]")).click();
  					}catch(Exception e)
  					{e.printStackTrace();}
  					
  				}
			}
			}
	
	
		}catch(Exception e)
		{e.printStackTrace();}
		 System.out.println("---------------------------------------------------------");
		driver.close();
		reports.endTest(node);
		reports.flush();		
		return data;
	
	}
}


