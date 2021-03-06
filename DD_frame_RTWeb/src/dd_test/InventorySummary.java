package dd_test;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.LogisticUtils;
import dd_utils.TestUtil;


public class InventorySummary extends TestCore 
{
	static TestUtil s =new TestUtil();
	static LogisticUtils Cs =new LogisticUtils();
		
	@Test
	public static Map<String, Object[]> inventorysummarytestcases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase) 
	{
		String acop =null;
		int counter =1;
		ExtentTest node = reports.startTest("InventorySummary");
		String[][] input =TestUtil.getData("InventorySummary");
		
		
		try
		{
			driver = new FirefoxDriver(s.excelDownload());
			driver.get(Object.getProperty("URL"));
			if(s.dologin(driver ,input[0][2], input[0][3]))
			{
				System.out.println("Inventory Summary Module");
			
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
	  					Thread.sleep(8000);
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("InventoryClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					
	  					if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("IHAssetInventoryHistory")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) ||
	  							!(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) || 
	  		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
	  		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
	  		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("RecordsPerPage")), driver)) ||
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("IHDashBoard")), driver)))
	  					{
	  						System.out.println("Page loaded Successfully");
  							acop = "Inventory Summary Page Loaded Successfully";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);							
	  						
	  					}
	  					else
	  					{
	  						System.out.println("Page not loaded Successfully");
  							acop = "Inventory Summary Page not Loaded Successfully";
  							node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(tc, counter, sheet, acop,scr);  							
	  					}
	  					}catch(Exception e)
	  					{e.printStackTrace();}
	  				}
	  				
	  				
	  				if (tc.equalsIgnoreCase("TC2"))
  					{
	  					try
	  					{
  						System.out.println( "TC2 Execution started.....");
  						Thread.sleep(5000);
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("InventoryClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					
		  					List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-6003-datagrid-tbody']"));
		  					List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
		  					System.out.println("No.of rows "+rows.size());
		  					for(WebElement row:rows){
		  					List<WebElement> rowElements = row.findElements(By.xpath("tr/td[1]"));
		  					//System.out.println("rowelement value"+rowElements);

		  					ArrayList<String> rowData = new ArrayList<String>();
		  					int val1=0;
		  					String assetName="Null";
		  					for(WebElement column:rowElements)
		  					{
		  						System.out.println("column value "+column);
		  						String actVal = column.getText();
		  						System.out.println(":::::::::::::::"+actVal);
		  						
		  					   rowData.add(actVal);
		  					  System.out.println("rowData Values are<<<<<<<<<<<<<<<<<"+rowData);

		  					}
		  					System.out.println("rowData  Size "+rowData.size());
		  					String strMain = input[i][9];
						    String[] arrSplit4 = strMain.split(",");
						    System.out.println(arrSplit4);
						    for(int rnum=0;rnum<arrSplit4.length;rnum++)
							{
						    	System.out.println(arrSplit4[rnum]);
						    	System.out.println(rowData);
						    	if (rowData.contains(arrSplit4[rnum]))
						    	{
						    		
						    		System.out.println("This Column is present"+arrSplit4[rnum]);
						    		acop = "Column values are correct";
						    		node.log(LogStatus.PASS, acop);
		  							data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
			  						rc++;
			  						excel.writePass(tc, counter, sheet, acop);
						    		    		
						    	}
						    	else
						    	{
						    		System.out.println("This Column is not present"+arrSplit4[rnum]);
						    		acop = "Some of the Column values are wrong";
						    		node.log(LogStatus.FAIL, acop);
		  							data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
			  						rc++;
			  						String scr = s.CaptureScreenshot();
			  						excel.writeFail(tc, counter, sheet, acop,scr);
						    		
						    	}
								}
		  					}		  					
						
	  					}catch(Exception e)
	  					{e.printStackTrace();}
  					}
	  				
	  				
	  				if (tc.equalsIgnoreCase("TC3"))
  					{
	  					try
	  					{
  						System.out.println( "TC3 Execution started.....");
  						Thread.sleep(5000);
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
  						Thread.sleep(5000);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("InventoryClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					
	  					driver.findElement(By.xpath(Object.getProperty("RefreshReport"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("IHAssetInventoryHistory")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) ||
	  							!(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) || 
	  		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
	  		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
	  		  					!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("RecordsPerPage")), driver)) ||
  								!(s.isElementPresentcheck(By.xpath(Object.getProperty("IHDashBoard")), driver)))
	  					{
	  						System.out.println("Page loaded Successfully");
  							acop = "Inventory Summary Page Loaded Successfully";
  							node.log(LogStatus.PASS, acop);
  							data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
  							rc++;
  							excel.writePass(tc, counter, sheet, acop);
  							
  							
	  					}
	  					else
	  					{
	  						System.out.println("Page not loaded Successfully");
  							acop = "Inventory Summary Page not Loaded Successfully";
  							node.log(LogStatus.FAIL, acop);
  							data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
  							rc++;
  							String scr = s.CaptureScreenshot();
  							excel.writeFail(tc, counter, sheet, acop,scr);
	  					}
	  					
	  					}catch(Exception e)
	  					{e.printStackTrace();}
	  					
  					}
	  				if (tc.equalsIgnoreCase("TC4"))
  					{
	  					try
	  					{
  						System.out.println( "TC4 Execution started.....");
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("InventoryClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
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
						acop = "Inventory History - Print window opened successfully";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(tc, counter, sheet, acop);
						
	  					}catch(Exception e)
	  					{e.printStackTrace();}
  					}
	  				if (tc.equalsIgnoreCase("TC5"))
  					{
	  					try
	  					{
  						ArrayList<String> tr=new ArrayList<String>();
  						int pageSize=0,recordsCount=0;
  						System.out.println( "TC5 Execution started.....");
  						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("InventoryClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					
	  					driver.findElement(By.xpath(Object.getProperty("Downloadthispage"))).click();
	  					Thread.sleep(2000);
	  					WebElement ele = driver.findElement(By.xpath(".//*[@id='div-6003-datagrid-tbody']"));
  						System.out.println(ele.getTagName());
  						List<WebElement>page=ele.findElements(By.tagName("tr"));
  						System.out.println("PageSize : "+page.size());
  						//System.out.println("PageSize : "+pageSize);
  						pageSize=page.size();
	  					try
	  					{
	  					BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\InventorySummaryReport.xls"));
	  					String line;
	  					
	  					int m=0;
	  					while ((line = reader.readLine()) != null)
	  					{
	  					//System.out.println(line);
	  					
	  					if(line.contains("</td"))
	  					tr.add(line);
	  					//System.out.println(records.get(i));
	  					m++;
	  					}
	  					reader.close();
	  					
	  					recordsCount=tr.size()-8;
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
							acop = "InventorySummary - Download Page successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(tc, counter, sheet, acop);
							
	  					}
	  					else
	  					{
	  						System.out.println("Records count mismatch... Fail");
	  						acop = "Count mismatch";
	  						node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);
	  					}	  					
	  					}catch(Exception e)
	  					{e.printStackTrace();
	  					}

  					}
	  				if(tc.equalsIgnoreCase("TC6"))
	  				{
	  					try
	  					{
	  					System.out.println( "TC6 Execution started.....");
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("InventoryClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  					
	  					
			  				if(s.unitofMeasure(driver, Object, Object.getProperty("InventoryClick"), Object.getProperty("InventoryClick"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
			  				{
			  					System.out.println("Time zone Displayed Successfully");
			  					acop = "Time zone displayed as expected";
			  					node.log(LogStatus.PASS, acop);
			  					data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
			  					rc++;
			  					excel.writePass(tc, counter, sheet, acop);
			  					
			  				}
			  				else
			  				{
			  					System.out.println("Time zone not Displayed ");
			  					acop = "Time zone not displayed as expected";
			  					node.log(LogStatus.FAIL, acop);
			  					data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
			  					rc++;
			  					String scr = s.CaptureScreenshot();
			  					excel.writeFail(tc, counter, sheet, acop,scr);
			  					
			  				}
			  				
	  					}catch(Exception e)
	  					{e.printStackTrace();}
	  				}
  					if(tc.equalsIgnoreCase("TC7"))
	  				{
  						try
  						{
	  					System.out.println( "TC7 Execution started.....");
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("InventoryClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					
		  				if(s.unitofMeasure(driver, Object, Object.getProperty("InventoryClick"), Object.getProperty("InventoryClick"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
		  				{
		  					System.out.println("Temperature Unit Displayed Successfully");
		  					acop = "Temperature Unit displayed as expected";
		  					node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);
		  					
		  				}
		  				else
		  				{
		  					System.out.println("Temperature Unit not Displayed ");
		  					acop = "Temperature Unit not displayed as expected";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);
		  					
		  				}		  				
  						}catch(Exception e)
  						{e.printStackTrace();}
	  				}
  					if(tc.equalsIgnoreCase("TC8"))
	  				{
  						try
  						{
	  					System.out.println( "TC8 Execution started.....");
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("InventoryClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					
		  				if(s.unitofMeasure(driver, Object, Object.getProperty("InventoryClick"), Object.getProperty("InventoryClick"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
		  				{
		  					System.out.println("Fuel Level Displayed Successfully");
		  					acop = "Fuel Level displayed as expected";
		  					node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);
		  					
		  				}
		  				else
		  				{
		  					System.out.println("Fuel Level not Displayed ");
		  					acop = "Fuel Level not displayed as expected";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);
		  					
		  				}		  				
  						}catch(Exception e)
  						{e.printStackTrace();}
	  				}
  					if(tc.equalsIgnoreCase("TC9"))
	  				{
  						try
  						{
	  					System.out.println( "TC9 Execution started.....");
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("InventoryClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  					
	  					
		  				if(s.unitofMeasure(driver, Object, Object.getProperty("InventoryClick"), Object.getProperty("InventoryClick"), Object.getProperty("DistanceCalcIcon"), Object.getProperty("DistanceTooltip"), Object.getProperty("DistanceTooltipval"), Object.getProperty("DistanceUnit")))
		  				{
		  					System.out.println("Distance Unit Displayed Successfully");
		  					acop = "Distance Unit displayed as expected";
		  					node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);
		  					
		  				}
		  				else
		  				{
		  					System.out.println("Distance Unit not Displayed ");
		  					acop = "Distance Unit not displayed as expected";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);
		  					
		  				}
		  				
  						}catch(Exception e)
  						{e.printStackTrace();}
	  				}
  					if(tc.equalsIgnoreCase("TC10"))
	  				{
  						try
  						{
	  					System.out.println( "TC10 Execution started.....");
	  					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
	  					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					driver.findElement(By.xpath(Object.getProperty("InventoryClick"))).click();
	  					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						Thread.sleep(1000);
  						
	  					
	  					if (s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver))
	  					{
	  						System.out.println("Control Probe ICON Displayed Successfully");
		  					acop = "Control Probe ICON Displayed as expected";
		  					node.log(LogStatus.PASS, acop);
		  					data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
		  					rc++;
		  					excel.writePass(tc, counter, sheet, acop);
		  					
		  				}
		  				else
		  				{
		  					System.out.println("Control Probe ICON not Displayed ");
		  					acop = "Control Probe ICON not displayed as expected";
		  					node.log(LogStatus.FAIL, acop);
		  					data.put(""+rc, new Object[] {tc, "InventorySummary", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
		  					rc++;
		  					String scr = s.CaptureScreenshot();
		  					excel.writeFail(tc, counter, sheet, acop,scr);
		  					
		  				}
	  					
  						}catch(Exception e)
  						{e.printStackTrace();}
	  				}
	  				
				}
				
				
			}
					
				}
				catch(Exception e)
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
