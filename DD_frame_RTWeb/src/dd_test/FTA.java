package dd_test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.TestUtil;

public class FTA extends TestCore 
{
	@Test
	public static Map<String, Object[]>ftatestcases(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase)
	{
		TestUtil s =new TestUtil();
		String acop = null;
		int counter = 1;
		ExtentTest node = reports.startTest("FTA");
		String[][] d1 = s.getData("FTA");
		try
		{
			
			driver = new FirefoxDriver(s.excelDownload());
			driver.get(Object.getProperty("URL1"));
			if(s.dologin(driver, d1[0][2], d1[0][3]))
			{			
				System.out.println("FTA Module");
			for(int i=scase-1;i<ecase;i++)
			{
				long stime = System.currentTimeMillis();
				if(d1[i][0].equalsIgnoreCase("TC1"))
				{try
				{
					System.out.println("TC1 Execution started.....");
					Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[0][4]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);					
					
					driver.findElement(By.xpath(Object.getProperty("FTA"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("Searchbox")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("Status")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTemp")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("Alarm")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Maintenance")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("TempProfile")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Pretrip")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("Impact")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelFlow")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("SM")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ITA")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("DoorAlarm")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("HMIDisplay")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("FSMADocs")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FTADashboard")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("PageDrpdown")), driver)))
					{
						System.out.println("The elements are not present in FTA");
						acop = "The elements are not present in FTA";
						String scr = s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
						rc++;
						excel.writeFail(d1[i][0], counter, sheet, acop, scr);
					}
					else
					{
						System.out.println("The elements are present in FTA");
						acop = "The elements are present in FTA";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
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
					
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[0][4]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);					
					
					driver.findElement(By.xpath(Object.getProperty("FTA"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("FTADashboard")), driver)))
						System.out.println("Dashboard is not present in FTA");
					
					else
					{
						System.out.println("Dashboard is present in FTA");
						List<WebElement> head = driver.findElements(By.xpath(".//*[@id='div-141-datagrid']/div/table[1]/thead/tr[2]"));
						List<String> rowData = new ArrayList<String>();
						for(WebElement row: head)
						{
							List<WebElement> ele = row.findElements(By.xpath("th"));
							for(WebElement col: ele)
							{
								if(!col.getText().equalsIgnoreCase(" "))
									rowData.add(col.getText().toString());
							}
						}
						
						System.out.println("Row values: " +rowData);
						System.out.println("Row size is: " +rowData.size());
						String str = d1[i][5];
						String[] split = str.split(",");
						int count = 0;
						for(int r=1;r<split.length;r++)
						{
							System.out.println("split val " +split[r]);
						}						
						
						
						for(int v=1;v<rowData.size();v++)
						{
							if(rowData.contains("ABS. / REL"))
								rowData.add(v, "Abs. / Rel\nAbsolute / Relative");
							if(rowData.get(v).equalsIgnoreCase(split[v]))
								count++;
						}							
						
						System.out.println("Count: " +count);
						System.out.println("Split: " +(split.length-1));
						if(count==(split.length-1))
						{
							System.out.println("All the element are present in the FTA Dashboard");
							acop = "All the element are present in the FTA Dashboard";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);							
						}
						else
						{
							System.out.println("All the elements are not present in the FTA Dashboard");
							acop = "All the elements are not present in the FTA Dashboard";
							String scr = s.CaptureScreenshot();
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
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
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[0][4]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);					
					
					driver.findElement(By.xpath(Object.getProperty("FTA"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);
					
					WebElement w = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
					List<WebElement> page = w.findElements(By.tagName("li"));
					System.out.println("Page size: " +page.size());
					for(WebElement s1: page)
						System.out.println(s1.getText());
					
					if(page.get(0).getText().equalsIgnoreCase("Prev") && page.get(page.size()-2).getText().equalsIgnoreCase("Next") && page.get(page.size()-1).getText().contains("Go To Page"))
					{
						System.out.println("The page is displayed successfully");
						if(d1[i][5].isEmpty())
						{
							System.out.println("The selected page is displayed successfully");
							acop = "The selected page is displayed successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);							
						}
						else
						{
							driver.findElement(By.xpath(Object.getProperty("FTADropdown"))).click();
							driver.findElement(By.xpath(Object.getProperty("FTADropboxInput"))).sendKeys(d1[i][5]);
							driver.findElement(By.xpath(Object.getProperty("FTASelectPage"))).click();
							w = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
							page = w.findElements(By.tagName("li"));
							System.out.println("Page size: " +page.size());
							for(int k=0;k<page.size();k++)
							{
								if(page.get(k).getText().equalsIgnoreCase(d1[i][5]))
								{
									if(page.get(k).getAttribute("class").equalsIgnoreCase("active"))
									{
										System.out.println("The selected page is displayed successfully");
										acop = "The selected page is displayed successfully";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
										rc++;
										excel.writePass(d1[i][0], counter, sheet, acop);										
										break;
									}
									else
									{
										System.out.println("The current page does not match with the selected page");
										acop = "The selected page is not displayed as expected";
										String scr = s.CaptureScreenshot();
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
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
						System.out.println("The selected page is not displayed as expected");
						acop = "The selected page is not displayed as expected";
						String scr = s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
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
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[0][4]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					 Thread.sleep(1000);
										
					driver.findElement(By.xpath(Object.getProperty("FTA"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("RefreshReport"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);
					
					if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("Searchbox")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver))
							||!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageDrpdown")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("FTADashboard")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Status")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("Alarm")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTemp")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("Pretrip")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Maintenance")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("TempProfile")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Impact")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("SM")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ITA")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("DoorAlarm")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelFlow")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("HMIDisplay")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FSMADocs")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver))
							|| !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)))
					{
						System.out.println("The page is not refreshed properly");
						acop = "The page is not refreshed properly";
						String scr = s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
						rc++;
						excel.writeFail(d1[i][0], counter, sheet, acop, scr);
					}
					else
					{
						System.out.println("The page is refreshed successfully");
						acop = "The page is refreshed successfully";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
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
					
					driver.findElement(By.xpath(Object.getProperty("FTA"))).click();
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
						data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1],d1[i][6], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);
						
					}
					else
					{
						System.out.println("Print page is not displayed properly");
						acop = "Print page is not displayed as expected";
						String scr = s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1],d1[i][6], acop, "Fail", s.timestamp(stime)});
						rc++;
						excel.writeFail(d1[i][0], counter, sheet, acop, scr);
					}
					Robot robo = new Robot();
					robo.keyPress(KeyEvent.VK_ESCAPE);
					Thread.sleep(500);
					robo.keyRelease(KeyEvent.VK_ESCAPE);
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
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[0][4]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);					
					
					driver.findElement(By.xpath(Object.getProperty("FTA"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("ExcelDownload"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					ArrayList<String> tr = new ArrayList<String>();
					int pgsz=0,recCnt=0;
					WebElement w = driver.findElement(By.xpath(".//*[@id='div-141-datagrid-tbody']"));
					List<WebElement> pg = w.findElements(By.tagName("tr"));
					driver.findElement(By.xpath(Object.getProperty("RecordsPerPage"))).click();
					driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
					System.out.println("Page size is: " +pg.size());
					pgsz = pg.size();
					try
					{
						BufferedReader buf = new BufferedReader(new FileReader("\\\\AMXSERVER\\amx-share\\STW_QA\\Rtweb Automation\\Downloaded Excel\\FTAReport.xls"));
						String line;
						while((line=buf.readLine())!=null)
						{
							if(line.contains("<tr"))
								tr.add(line);
						}
						buf.close();
						recCnt = tr.size()-2;
						System.out.println("Record count: " +recCnt);				
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					if(recCnt == pgsz)
					{
						System.out.println("Records count matched");
						acop = "FTA download of this page is downloaded successfully";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);						
					}
					else
					{
						System.out.println("Records count mismatch");
						acop = "FTA download of this page is not downloaded properly";
						String scr = s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Fail", s.timestamp(stime)});
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
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[0][4]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);					
					
					driver.findElement(By.xpath(Object.getProperty("FTA"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					Select s2 = new Select(driver.findElement(By.id("per-page__select")));
					List<WebElement> l = s2.getOptions();
					System.out.println("no of rows: " +l.size());
					driver.findElement(By.xpath(Object.getProperty("RecordsPerPage"))).click();
					String[] dropVal = new String[l.size()+1];
					for(int x=1;x<=l.size();x++)
					{
						String dropdownVal = driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li[" +x+ "]")).getText();
						dropVal[x] = dropdownVal;
						System.out.println("Values are: " +dropVal[x]);
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
						data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1], d1[i][6], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);						
					}
					else
					{
						for(int sel=1;sel<=l.size();sel++)
						{
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[0][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
							
							driver.findElement(By.xpath(Object.getProperty("FTA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);
							
							driver.findElement(By.xpath(Object.getProperty("RecordsPerPage"))).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li[" +sel+ "]")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
							
							WebElement ele = driver.findElement(By.xpath(".//*[@id='div-141-datagrid-tbody']"));
							List<WebElement> page = ele.findElements(By.tagName("tr"));
							System.out.println("Page size: " +page.size());
							if(page.size()<=10 || page.size()<=20 || page.size()<=50 || page.size()<=100 ||page.size()<=200 || page.size()<=300)
							{
								System.out.println("Record per page are displayed properly");
								acop = "Records page are displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1],d1[i][6], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);								
							}
							else
							{
								System.out.println("Record per page are not displayed properly");
								acop = "Records page are not displayed as expected";
								String scr = s.CaptureScreenshot();
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[]{d1[i][0], "FTA", d1[i][1],d1[i][6], acop, "Fail", s.timestamp(stime)});
								rc++;
								excel.writeFail(d1[i][0], counter, sheet, acop, scr);
							}
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
		}
		
		return data;
	}
}
