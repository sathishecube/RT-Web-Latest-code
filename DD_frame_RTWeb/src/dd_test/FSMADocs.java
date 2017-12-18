package dd_test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.TestUtil;

public class FSMADocs extends TestCore
{
	@Test
	public static Map<String, Object[]> fsmadocstestcases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase)
	{
		TestUtil s =new TestUtil();
		int start = (int) System.nanoTime();
		String acop = null;
		int counter =1;
		ExtentTest node = reports.startTest("FSMADocs");
		String[][] d1 =s.getData("FSMADocs");
		try
		{
			
			driver = new FirefoxDriver(s.excelDownload());
			driver.get(Object.getProperty("URL1"));
			if(s.dologin(driver ,d1[0][2], d1[0][3]))
			{
			System.out.println("FSMA Docs Module");
			for(int i=scase-1;i<ecase;i++)
			{
				long stime=System.currentTimeMillis();
				if(d1[i][0].equalsIgnoreCase("TC1"))
				{	
					try
					{
					System.out.println("TC1 Execution started.....");
					Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					driver.findElement(By.xpath(Object.getProperty("FSMADocs"))).click();
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
				
					if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("Searchbox")), driver)) ||
							!(s.isElementPresentcheck(By.xpath(Object.getProperty("Editdaterange")), driver)) || 
							!(s.isElementPresentcheck(By.xpath(Object.getProperty("MoreActions")), driver)) || 
							!(s.isElementPresentcheck(By.xpath(Object.getProperty("FSMADashboard")), driver)) ||
							!(s.isElementPresentcheck(By.xpath(Object.getProperty("FSMADropdown")), driver)))
					{
						System.out.println("The elements are not present in FSMA Docs");
						acop = "The elements are not present in FSMA Docs";
						String scr = s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Fail", s.timestamp(stime)});
						rc++;
						excel.writeFail(d1[i][0], counter, sheet, acop,scr);
					}
					else
					{
						System.out.println("The elements are present in FSMA Docs");
						acop = "The elements are present in FSMA Docs";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);
					}
						
						driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
						if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTemp")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Maintenance")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("Pretrip")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Alarm")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("TempProfile")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ITA")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("SM")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelFlow")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("DoorAlarm")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Status")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("Route1")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("HMIDisplay")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("FTA")), driver)) ||	!(s.isElementPresentcheck(By.xpath(Object.getProperty("FSMADocs")), driver)))
						{
							System.out.println("FSMA Status Page not loaded Successfully");
							acop = "FSMA Status Page not Loaded Successfully";
							String scr = s.CaptureScreenshot();
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Fail", s.timestamp(stime)});
							rc++;	
							excel.writeFail(d1[i][0], counter, sheet, acop, scr);						
						}
						else
						{
							System.out.println("Page loaded Successfully");
							acop = "FSMA Status Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);							
						}	
					}catch(Exception e)
					{e.printStackTrace();
					}
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
							Thread.sleep(1000);						
						
						driver.findElement(By.xpath(Object.getProperty("FSMADocs"))).click();
						Thread.sleep(10000);
						if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("FSMADashboard")), driver)))
							System.out.println("Dashboard not present");
						
						else
						{
							System.out.println("Dashboard is present");
							List<WebElement> head = driver.findElements(By.xpath(".//*[@id='div-142-datagrid']/div/table/thead/tr[2]"));
							List<String> rowData = new ArrayList<String>();
							for(WebElement row:head)
							{
								List<WebElement> elem = row.findElements(By.xpath("th"));
																
								for(WebElement column:elem)
								{
								if(!column.getText().equalsIgnoreCase(" "))
								rowData.add(column.getText().toString());
								}
							}
								System.out.println("rowData Values are"+rowData);
								System.out.println("rowData  Size "+rowData.size());
								String str = d1[i][5];
								String[] split = str.split(",");
								for(int l=0;l<split.length;l++)
								System.out.println("split val: "+split[l]);
								int count=0;
								for(int r=1;r<split.length;r++)
								{
									for(String rd: rowData)
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
									System.out.println("All Column is Present");
									acop = "Dashboard displayed as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(d1[i][0], counter, sheet, acop);
								}
								else
								{
									System.out.println("Column Not Present");
									acop = "Dashboard not displayed as expected";
									String scr = s.CaptureScreenshot();
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Fail", s.timestamp(stime)});
									rc++;
									excel.writeFail(d1[i][0], counter, sheet, acop, scr);
								}					
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				
				//file upload
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
						
						Thread.sleep(10000);
						driver.findElement(By.xpath(Object.getProperty("FSMADocs"))).click();
						Thread.sleep(10000);
						driver.findElement(By.xpath(".//*[@id='div-142-datagrid-tbody']/tr[1]/td[1]/label/span[2]/span")).click();
						driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
						driver.findElement(By.xpath(".//*[@id='btn-upload-FSMA-doc-command']/button")).click();
						Thread.sleep(3000);
					
						driver.findElement(By.xpath(".//*[@id='cmbFSMADocType_chosen']/a")).click();
						driver.findElement(By.xpath(".//*[@id='cmbFSMADocType_chosen']/div/ul/li[2]")).click();
						driver.findElement(By.xpath(".//*[@id='txtFSMAVendorname']")).sendKeys(d1[i][5]);
						driver.findElement(By.xpath("html/body/div[55]/div/div/div[2]/div[2]/div/div/label/strong")).click();
						Process p = Runtime.getRuntime().exec("D:\\Test.exe");
						p.waitFor();
						
						driver.findElement(By.xpath(Object.getProperty("Upload"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);
						
						if(s.isElementPresentcheck(By.xpath(".//*[@id='content']/div[1]/div"), driver))
						{
						if(d1[i][6].equalsIgnoreCase("upload"))
						{
							
							System.out.println("File uploaded Successfully");
							acop = "File uploaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);
							
						}
						else if(d1[i][6].equalsIgnoreCase("cancel"))
						{
							driver.findElement(By.xpath("html/body/div[55]/div/div/div[2]/div[3]/button[2]")).click();
							System.out.println("File upload is cancelled successfully");
							acop = "File upload is cancelled successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Pass", s.timestamp(stime)});
							rc++;
							
						}
						else
						{
							System.out.println("File is not uploaded successfully");
							acop = "File is not uploaded successfully";
							String scr = s.CaptureScreenshot();
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Fail", s.timestamp(stime)});
							rc++;
							excel.writeFail(d1[i][0], counter, sheet, acop, scr);
						}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
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
						
						driver.findElement(By.xpath(Object.getProperty("FSMADocs"))).click();
						Thread.sleep(10000);
						WebElement w = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
						List<WebElement> page = w.findElements(By.tagName("li"));
						System.out.println("Size is : " +page.size());
						for(WebElement s1: page)
						{
							System.out.println(s1.getText());
						}
						if(page.get(0).getText().equalsIgnoreCase("Prev") && page.get(page.size()-2).getText().equalsIgnoreCase("Next") && page.get(page.size()-1).getText().contains("Go To Page"))
						{
							System.out.println("Page displayed successfully");
							if(d1[i][5].isEmpty())
							{
								System.out.println("The selected page is displayed");
								acop = "FSMA Page is displayed successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
								
							}
							else
							{
								driver.findElement(By.xpath(Object.getProperty("FSMADropdown"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("DropboxInput"))).sendKeys(d1[i][5]);
								driver.findElement(By.xpath(Object.getProperty("SelectPage"))).click();
							
								Thread.sleep(10000);
								w = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
								page = w.findElements(By.tagName("li"));
								System.out.println("Size " +page.size());
								for(int j=0;j<page.size();j++)
								{
									if(page.get(j).getText().equalsIgnoreCase(d1[i][5]))
									{
										if(page.get(j).getAttribute("class").equalsIgnoreCase("active"))
										{
											System.out.println("Selected Page Displayed as expected");
											acop = "Selected Page Displayed as expected";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Pass", s.timestamp(stime)});
											rc++;
											excel.writePass(d1[i][0], counter, sheet, acop);											
											break;
										}
										else
										{
											System.out.println("Current Page does not match the Page which is selected ");
											acop = "Page not displayed as expected";
											String scr = s.CaptureScreenshot();
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Fail", s.timestamp(stime)});
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
							acop = "FSMA Page is not displayed successfully";
							String scr = s.CaptureScreenshot();
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Fail", s.timestamp(stime)});
							rc++;	
							excel.writeFail(d1[i][0], counter, sheet, acop, scr);
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
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
						
						Thread.sleep(10000);
						driver.findElement(By.xpath(Object.getProperty("FSMADocs"))).click();
						Thread.sleep(10000);
						Select s2 = new Select(driver.findElement(By.id("per-page__select")));
						List<WebElement> l = s2.getOptions();
						System.out.println("No of rows: " +l.size());
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
						String pageno = driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
						System.out.println("page number : " +pageno);
						int ind=0; 
						String exactpg = null;
						if(pageno.contains("of"))
						{
							ind = pageno.indexOf("of");
							exactpg = pageno.substring(ind+3);
							System.out.println("Page is : " +exactpg);
						}
					 	if((exactpg.equals("0")))
						{
							System.out.println("No records Found");
							acop = "No Records found";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);							
							break;
						}
						else 
						{
						for(int sel=1;sel<=l.size();sel++)
						{						
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li["+sel+"]")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);
							
							WebElement ele = driver.findElement(By.xpath(".//*[@id='div-142-datagrid-tbody']"));
							System.out.println(ele.getTagName());
							List<WebElement> page = ele.findElements(By.tagName("tr"));
							System.out.println("PageSize : "+page.size());
							
							if((page.size()>=10)||(page.size()>=20)||(page.size()>=50)||(page.size()>=100)||(page.size()>=200)||(page.size()>=300))
							{
								System.out.println("Records Per page loaded successfully");
								acop = "Records Per Page is Loaded successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
								driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
								
							}
							else
							{
								System.out.println("Records Per page not loaded");
								acop ="Records Per Page is not Loaded successfully";
								String scr = s.CaptureScreenshot();
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Fail", s.timestamp(stime)});
								rc++;
								excel.writeFail(d1[i][0], counter, sheet, acop, scr);
								driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
								
							}
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
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
												
						driver.findElement(By.xpath(Object.getProperty("FSMADocs"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);
					
						driver.findElement(By.xpath(Object.getProperty("RefreshIcon"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
						Thread.sleep(1000);
						
						if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("Searchbox")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("Editdaterange")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("MoreActions")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("FSMADashboard")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) ||  !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("Status")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTemp")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("Maintenance")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FSMADocs")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("SM")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ITA")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelFlow")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DoorAlarm")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("TempProfile")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Route1")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("HMIDisplay")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FTA")), driver)) ||
								!(s.isElementPresentcheck(By.xpath(Object.getProperty("Pretrip")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("Alarm")), driver)))
						{
							System.out.println("The page is not refreshed properly");
							acop = "FSMA Page is not refreshed properly";
							String scr = s.CaptureScreenshot();
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Fail", s.timestamp(stime)});
							rc++;	
							excel.writeFail(d1[i][0], counter, sheet, acop, scr);
						}
						else
						{
							System.out.println("The page is refreshed properly");
							acop = "FSMA Page is refreshed properly";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Pass", s.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);							
						}
						driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
						driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
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
						
						driver.findElement(By.xpath(Object.getProperty("FSMADocs"))).click();
						Thread.sleep(10000);
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
						data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);
						
						}
						else
						{
						System.out.println("Print page not displayed");
						acop = "Print Page not displayed as expected";
						String scr = s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Fail", s.timestamp(stime)});
						rc++;
						excel.writeFail(d1[i][0], counter, sheet, acop, scr);
						
						}
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_ESCAPE);
						Thread.sleep(200);
						robot.keyRelease(KeyEvent.VK_ESCAPE);
						driver.close();
						driver.switchTo().window(tabs2.get(0));
						Thread.sleep(5000);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				if(d1[i][0].equalsIgnoreCase("TC8"))
				{
					try{
						System.out.println("TC8 Execution started.....");
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
						driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
						driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);						
						
						ArrayList<String> tr=new ArrayList<String>();
						int pgSz=0,recordsCount=0;
						driver.findElement(By.xpath(Object.getProperty("FSMADocs"))).click();
						Thread.sleep(10000);
						driver.findElement(By.xpath(Object.getProperty("ExcelDownload"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);
						
						WebElement ele1 = driver.findElement(By.xpath(".//*[@id='div-142-datagrid-tbody']"));
						System.out.println(ele1.getTagName());
						List<WebElement> pg=ele1.findElements(By.tagName("tr"));
						driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
						driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
						System.out.println("Size of the page : "+pg.size());
						pgSz=pg.size();

						try
						{
						BufferedReader reader = new BufferedReader(new FileReader("\\\\amxserver\\amx-share\\STW_QA\\Rtweb Automation\\Downloaded Excel\\FSMADocsReport.xls"));
						String line;
						//int m=0;
						while ((line = reader.readLine()) != null)
						{
						if(line.contains("<tr"))
						tr.add(line);
						//m++;
						}
						reader.close();
						recordsCount=tr.size()-2;
						System.out.println(recordsCount);
						
						}
						catch(Exception e)
						{
						e.printStackTrace();
						}
						System.out.println(recordsCount+" : "+pgSz);
						if(recordsCount == pgSz)
						{
						System.out.println("FSMA Docs Download of this page is downloaded successfully");
						acop = "FSMA Docs Download of this page is downloaded successfully";
						node.log(LogStatus.PASS, acop);
						data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Pass", s.timestamp(stime)});
						rc++;
						excel.writePass(d1[i][0], counter, sheet, acop);						
						}
						else
						{
						System.out.println("Count mismatc");
						acop = "Count mismatch";
						String scr =s.CaptureScreenshot();
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[] {d1[i][0], "FSMA Docs", d1[i][1], d1[i][7], acop, "Fail", s.timestamp(stime)});
						rc++;
						excel.writeFail(d1[i][0], counter, sheet, acop, scr);						
						}	
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
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
