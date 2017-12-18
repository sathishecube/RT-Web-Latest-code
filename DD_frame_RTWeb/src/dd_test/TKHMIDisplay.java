package dd_test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.TestUtil;

public class TKHMIDisplay extends TestCore
{
	@Test
	public static Map<String, Object[]>hmidisplaytestcases(Map<String, Object[]> data, int rc, String sheet, ExtentTest test,int scase,int ecase)
	{
		TestUtil s =new TestUtil();
		String acop = null;
		int counter = 1;
		ExtentTest node = reports.startTest("TKHMIDisplay");
		String[][] d1 = s.getData("TKHMIDisplay");
		try
		{
			
			driver = new FirefoxDriver(s.excelDownload());
			driver.get(Object.getProperty("URL1"));
			if(s.dologin(driver, d1[0][2], d1[0][3]))
			{		
				System.out.println("TK HMI Dispaly Module");
			for(int i=scase-1;i<ecase;i++)
			{
				long stime = System.currentTimeMillis();
				
				if(d1[i][0].equalsIgnoreCase("TC1"))
				{
					try
					{
					System.out.println("TC1 Execution started.....");
					Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);
				
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("HMIDisplay"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);
						
					if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("Searchbox")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("MoreActions")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PageDrpdown")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("HMIDisplayDashboard")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Status")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("Alarm")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTemp")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("Pretrip")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Maintenance")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("TempProfile")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Impact")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("SM")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ITA")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("DoorAlarm")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelFlow")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("FTA")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FSMADocs")), driver)))
					{
						System.out.println("The elements are not present in TK HMI Display");
						acop = "The elements are not present in TK HMI Display";
						String scr = s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[] {d1[i][0],"TK HMI Display",d1[i][1],d1[i][6],acop,"Fail",s.timestamp(stime)});
						rc++;
						excel.writeFail(d1[i][0], counter, sheet, acop, scr);						
					}
					else
					{
						System.out.println("The elements are present in TK HMI Display");
						acop = "The elements are present in TK HMI Display";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0],"TK HMI Display",d1[i][1],d1[i][6],acop,"Pass",s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);						
					}
					}catch(Exception e)
					{e.printStackTrace();}
				}
				
				if(d1[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
					System.out.println("TC2 Execution started.....");
					Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("HMIDisplay"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("HMIDisplayDashboard")), driver)))
						System.out.println("TK HMI Display Dashboard is not present");
					
					else
					{
						System.out.println("TK HMI Display Dashboard is present");
						List<WebElement> head = driver.findElements(By.xpath(".//*[@id='div-140-datagrid']/div/table/thead/tr[2]"));
						List<String> rowData = new ArrayList<String>();
						for(WebElement row: head)
						{
							List<WebElement> ele = row.findElements(By.xpath("th"));
							for(WebElement col : ele)
							{
								if(!col.getText().equalsIgnoreCase(" "))
									rowData.add(col.getText().toString());									
							}
						}
						System.out.println("Row values: " +rowData);
						System.out.println("Row size is: " +rowData.size());
						String str = d1[i][5];
						String[] split = str.split(",");
						for(int j=0;j<split.length;j++)
							System.out.println("the split elements are: "+split[j]);
						int count=0;
						for(int r=1;r<split.length;r++)
						{
							for(String rd : rowData)
							{
								if(rd.equalsIgnoreCase(split[r]))
								{
									count++;
									System.out.println(split[r]+ " is present");
								}
							}
						}
						
						if(count==(split.length-1))
						{
							System.out.println("All the elements are present in the TK HMI Display dashboard");
							acop = "The elements are present in TK HMI Display Dashboard";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0],"TK HMI Display",d1[i][1],d1[i][6],acop,"Pass",s.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);							
						}
						else
						{
							System.out.println("All the elements are not present in the TK HMI Display dashboard");
							acop = "The elements are not present in TK HMI Display Dashboard";
							String scr = s.CaptureScreenshot();
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d1[i][0],"TK HMI Display",d1[i][1],d1[i][6],acop,"Fail",s.timestamp(stime)});
							rc++;
							excel.writeFail(d1[i][0], counter, sheet, acop, scr);							
						}						
					}
					}catch(Exception e)
					{e.printStackTrace();}
				}
				
				if(d1[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
					System.out.println("TC3 Execution started.....");
					Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("HMIDisplay"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					WebElement w = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
					List<WebElement> page = w.findElements(By.tagName("li"));
					System.out.println("Page size: " +page.size());
					for(WebElement s1: page)
					System.out.println(s1.getText());
					
					if(page.get(0).getText().equalsIgnoreCase("Prev") && page.get(page.size()-2).getText().equalsIgnoreCase("Next") && page.get(page.size()-1).getText().contains("Go To Page"))
					{
						System.out.println("Page is displayed successfully");
						if(d1[i][5].isEmpty())
						{
							System.out.println("The selected page is displayed succcessfully");
							acop = "The selected page is displayed succcessfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);							
						}
						else
						{
							driver.findElement(By.xpath(Object.getProperty("HMIDropdown"))).click();
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("HMIDropboxInput"))).sendKeys(d1[i][5]);
							driver.findElement(By.xpath(Object.getProperty("HMISelectPage"))).click();
							w = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
							page = w.findElements(By.tagName("li"));
							System.out.println("Page size: " +page.size());
							for(int k=0;k<page.size();k++)
							{
								if(page.get(k).getText().equalsIgnoreCase(d1[i][5]))
								{
									if(page.get(k).getAttribute("class").equalsIgnoreCase("active"))
									{
										System.out.println("The selected page is displayed succcessfully");
										acop = "The selected page is displayed succcessfully";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
										rc++;
										excel.writePass(d1[i][0], counter, sheet, acop);										
										break;
									}
									else
									{
										System.out.println("The current page does not match with the page selected");
										acop = "The selected page is not displayed as expected";
										String scr = s.CaptureScreenshot();
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
										rc++;
										excel.writeFail(d1[i][0], counter, sheet, acop, scr);										
										break;
									}
								}
							}	
						}
					}
					else
					{
						System.out.println("The selected page is not displayed");
						acop = "The selected page is not displayed";
						String scr = s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
						rc++;
						excel.writeFail(d1[i][0], counter, sheet, acop, scr);
						
					}
					}catch(Exception e)
					{e.printStackTrace();}
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
					
					driver.findElement(By.xpath(Object.getProperty("HMIDisplay"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("RefreshReport"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("Searchbox")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("MoreActions")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PageDrpdown")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("HMIDisplayDashboard")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Status")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("Alarm")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTemp")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("Pretrip")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Maintenance")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("TempProfile")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Impact")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("SM")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ITA")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("DoorAlarm")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelFlow")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("FTA")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FSMADocs")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)))
					{
						System.out.println("The page is not refreshed properly");
						acop = "The page is not refreshed properly";
						String scr =s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
						rc++;
						excel.writeFail(d1[i][0], counter, sheet, acop, scr);
						
					}
					else
					{
						System.out.println("The page is refreshed successfully");
						acop = "The page is refreshed successfully";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);						
					}
					}catch(Exception e)
					{e.printStackTrace();}
				}
				
				if(d1[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
					System.out.println("TC5 Execution started.....");
					Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[0][4]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);				
					
					driver.findElement(By.xpath(Object.getProperty("HMIDisplay"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("PrintIcon"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					System.out.println(tabs.get(0));
					System.out.println(driver.getWindowHandle());
					driver.switchTo().window(tabs.get(1));
					System.out.println(tabs.get(1));
					System.out.println(driver.getWindowHandle());
					
					if(s.isElementPresentcheck(By.xpath("html/body/table"), driver))
					{
						System.out.println("Print page is displayed properly");
						acop = "Print page is displayed as expected";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1],d1[i][6], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);
						
					}
					else
					{
						System.out.println("Print page is not displyed as expected");
						acop = "Print page is not displyed as expected";
						String scr = s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
						rc++;
						excel.writeFail(d1[i][0], counter, sheet, acop, scr);
					}
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ESCAPE);
					Thread.sleep(300);
					robot.keyRelease(KeyEvent.VK_ESCAPE);
					driver.close();
					driver.switchTo().window(tabs.get(0));
					Thread.sleep(3000);
					}catch(Exception e)
					{e.printStackTrace();}
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
					
					driver.findElement(By.xpath(Object.getProperty("HMIDisplay"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("ExcelDownload"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					ArrayList<String> tr = new ArrayList<String>();
					int pgsz=0,recCount=0;
					WebElement w = driver.findElement(By.xpath(".//*[@id='div-140-datagrid-tbody']"));
					List<WebElement> pg = w.findElements(By.tagName("tr"));
					driver.findElement(By.xpath(Object.getProperty("RecordsPerPage"))).click();
					driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
					System.out.println("Page size is: " +pg.size());
					pgsz = pg.size();
					try
					{
						BufferedReader buf = new BufferedReader(new FileReader("\\\\AMXSERVER\\amx-share\\STW_QA\\Rtweb Automation\\Downloaded Excel\\TKHMIDisplayReport.xls"));
						String line;
						while((line = buf.readLine())!= null)
						{
							if(line.contains("<tr"))
								tr.add(line);
						}
						buf.close();
						recCount = tr.size()-2;
						System.out.println("Record Count: " +recCount);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					if(recCount == pgsz)
					{
						System.out.println("Records count matched");
						acop = "TK HMI Display download of this page is downloaded successfully";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);						
					}
					else
					{
						System.out.println("Records count mismatch");
						acop = "TK HMI Display download of this page is not downloaded properly";
						String scr = s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
						rc++;
						excel.writeFail(d1[i][0], counter, sheet, acop, scr);
					}
					}catch(Exception e)
					{e.printStackTrace();}
				}
				
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
					
					driver.findElement(By.xpath(Object.getProperty("HMIDisplay"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					Select s1 = new Select(driver.findElement(By.id("per-page__select")));
					List<WebElement> l = s1.getOptions();
					System.out.println("No of rows: " +l.size());
					driver.findElement(By.xpath(Object.getProperty("RecordsPerPage"))).click();
					Thread.sleep(2000);
					String[] dropVal = new String[l.size()+1];
					for(int x=1;x<=l.size();x++)
					{
						String dropDownVal = driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li["+x+"]")).getText();
						dropVal[x] = dropDownVal;
						System.out.println(dropVal[x]);
					}
					if(dropVal[1].equalsIgnoreCase("10 per page") && dropVal[2].equalsIgnoreCase("20 per page") && dropVal[3].equalsIgnoreCase("50 per page")
							&& dropVal[4].equalsIgnoreCase("100 per page") && dropVal[5].equalsIgnoreCase("200 per page") && dropVal[6].equalsIgnoreCase("300 per page"))
					{
						System.out.println("All fields are present");
					}
					String pageno = driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
					System.out.println("Page num: " +pageno);
					int ind=0;
					String exactpg = null;
					if(pageno.contains("of"))
					{
						ind = pageno.indexOf("of");
						exactpg = pageno.substring(ind+3);
						System.out.println("Exact pg: " +exactpg);
					}
					if(exactpg.equals("0"))
					{
						System.out.println("No Records Found");
						acop = "No Records Found";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);						
					}
					else
					{
						for(int sel=1;sel<=l.size();sel++)
						{
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
							
							driver.findElement(By.xpath(Object.getProperty("HMIDisplay"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
							
							driver.findElement(By.xpath(Object.getProperty("RecordsPerPage"))).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li[" +sel+ "]")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
							
							WebElement ele = driver.findElement(By.xpath(".//*[@id='div-140-datagrid-tbody']"));
							System.out.println(ele.getTagName());
							List<WebElement> page = ele.findElements(By.tagName("tr"));
							System.out.println("Page size: " +page.size());
							if(page.size()>=10 || page.size()>=20 || page.size()>=50 || page.size()>=100 || page.size()>=200 || page.size()>=300)
							{
								System.out.println("Records per page is displayed successfully");
								acop = "Records per page is displayed successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);								
							} 
							else
							{
								System.out.println("Records per page is not loaded properly");
								acop = "Records per page is not loaded properly";
								String scr = s.CaptureScreenshot();
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[]{d1[i][0], "TK HMIDisplay", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
								rc++;
								excel.writeFail(d1[i][0], counter, sheet, acop, scr);
								
							}
						}
						driver.findElement(By.xpath(Object.getProperty("RecordsPerPage"))).click();
						driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
					}
					}catch(Exception e)
					{e.printStackTrace();}
				}
				
				if(d1[i][0].equalsIgnoreCase("TC8"))
				{
					try
					{
					System.out.println("TC8 Execution started.....");
					Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);				
					
					driver.findElement(By.xpath(Object.getProperty("HMIDisplay"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					WebElement web = driver.findElement(By.xpath(".//*[@id='div-140-datagrid-tbody']/tr[3]"));
					List<WebElement> le = web.findElements(By.tagName("td"));
					String[] str = new String[le.size()];
					for(int k=0;k<le.size();k++)
					{
						str[k] = le.get(k).getText();
						System.out.println(str[k]);
					}
					
					driver.findElement(By.xpath(".//*[@id='div-140-datagrid-tbody']/tr[3]/td[1]/label/span[2]/span")).click();
					driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
					driver.findElement(By.xpath(".//*[@id='btn-TKHMITemp-command']/button")).click();
					if(str[6].equalsIgnoreCase("Fahrenheit"))
					{
						driver.findElement(By.xpath("html/body/div[48]/div/div/div[2]/ul/li[1]/label/span/span")).click();
						driver.findElement(By.xpath(Object.getProperty("SendCommand"))).click();
						Alert a = driver.switchTo().alert();
						a.accept();
					}
					else if(str[6].equalsIgnoreCase("Celsius"))
					{
						driver.findElement(By.xpath("html/body/div[48]/div/div/div[2]/ul/li[2]/label/span/span")).click();
						driver.findElement(By.xpath(Object.getProperty("SendCommand"))).click();
						Alert a = driver.switchTo().alert();
						a.accept();
					}
					
					Thread.sleep(5000);
					if(driver.findElement(By.xpath(".//*[@id='content']/div[1]/div")).isDisplayed())
					{
						if(driver.findElement(By.xpath(".//*[@id='content']/div[1]/div")).getText().equalsIgnoreCase("Command Send Failed. The system is still processing the last command sent to this Asset"))
						{
							System.out.println("Conversion failed");
							acop = "The temperature conversion is failed";
							String scr = s.CaptureScreenshot();
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[]{d1[i][0], "TK HMIDisplay", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
							rc++;		
							excel.writeFail(d1[i][0], counter, sheet, acop, scr);
						}
						else
						{
							System.out.println("The temperature is converted successfully");
							acop = "The temperature is converted successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);
							
						}
					}
					
					//poll
					System.out.println("Poll");
					driver.findElement(By.xpath(".//*[@id='div-140-datagrid-tbody']/tr[4]/td[1]/label/span[2]/span")).click();
					driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
					driver.findElement(By.xpath(".//*[@id='btn-TKHMITemp-command']/button")).click();
					driver.findElement(By.xpath("html/body/div[48]/div/div/div[2]/ul/li[3]/label/span/span")).click();
					driver.findElement(By.xpath(Object.getProperty("SendCommand"))).click();
					Alert a = driver.switchTo().alert();
					a.accept();
					Thread.sleep(5000);
					if(driver.findElement(By.xpath(".//*[@id='content']/div[1]/div")).isDisplayed())
					{
						if(driver.findElement(By.xpath(".//*[@id='content']/div[1]/div")).getText().equalsIgnoreCase("Command Send Failed. The system is still processing the last command sent to this Asset"))
						{
							System.out.println("Conversion failed for poll command");
							acop = "The temperature conversion for poll is failed";
							String scr = s.CaptureScreenshot();
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[]{d1[i][0], "TK HMIDisplay", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
							rc++;
							excel.writeFail(d1[i][0], counter, sheet, acop, scr);
						}
						else
						{
							System.out.println("The temperature is converted for poll successfully");
							acop = "The temperature is converted for poll successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[]{d1[i][0], "TK HMI Display", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);							
						}
					
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
