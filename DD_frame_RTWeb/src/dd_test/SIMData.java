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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.LogisticUtils;
import dd_utils.TestUtil;

public class SIMData extends TestCore 
{
	
	static TestUtil t =new TestUtil();
	static LogisticUtils l =new LogisticUtils();
	@Test
	public static Map<String, Object[]>simdatatestcase(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase)
	{
		//TestUtil s =new TestUtil();
		String acop = null;
		int counter = 1;
		ExtentTest node = reports.startTest("SIMData");
		String[][] d1 = t.getData("SIMData");
		try
		{
			
			driver = new FirefoxDriver(t.excelDownload());
			driver.get(Object.getProperty("URL"));
			if(t.dologin(driver, d1[0][2], d1[0][3]))
			{			
				System.out.println("SIMData Module");
			for(int i=scase-1;i<ecase;i++)
			{
				long stime = System.currentTimeMillis();
				if(d1[i][0].equalsIgnoreCase("TC1"))
				{
					try
					{
						System.out.println( "TC1 Execution started.....");
						Thread.sleep(4000);
						driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						driver.findElement(By.xpath(Object.getProperty("SIMData"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);
						if(!(t.isElementPresentcheck(By.xpath(Object.getProperty("UploadOcp")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("IntroduceUnit")), driver)) || 
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("GetGSMData")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("GetSATData")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("GetUnitData")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("ScrapUnit")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("PowerONStatusReport")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("GeofenceData")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("GeoRefresh")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("GeofanceSearch")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("GeoExcellAll")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("SIMDataDashboard")), driver)))
						{
							System.out.println("Page not loaded Successfully");
							acop = "SIMData Page not Loaded Successfully";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d1[i][0], "SIMData", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop,scr);							
						}
						else
						{	
							System.out.println("Page loaded Successfully");
							acop = "SIMData Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0], "SIMData", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);							
						}
					}catch(Exception e)
					{node.log(LogStatus.SKIP, "Skipped TC1 Execution, it is because of page loading issue or due to some other issue");
					e.printStackTrace();
					}

				}


				if(d1[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
						System.out.println( "TC2 Execution started.....");
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						driver.findElement(By.xpath(Object.getProperty("SIMData"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);
						driver.findElement(By.xpath(Object.getProperty("GeofanceSearch"))).sendKeys(d1[i][5]);
						driver.findElement(By.xpath(Object.getProperty("GeofenceSearchButton"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(3000);

						if(t.isElementPresentcheck(By.xpath(".//*[@id='div-7-datagrid-tbody']/tr/td[2]/a"), driver))
						{

							String Chk=driver.findElement(By.xpath(".//*[@id='div-7-datagrid-tbody']/tr/td[2]/a")).getText();
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
								data.put(""+rc, new Object[] {d1[i][0], "SIMData", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);								
							}
							else
							{
								System.out.println("Search value not displayed ");
								acop = "Selected search value"+ Chk +" not displayed Successfully";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0] ,"SIMData", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);								
							}
						}
						else
						{
							System.out.println("Search Failed ... No data Found ");
						}
						driver.findElement(By.xpath(Object.getProperty("GeoClearSearch"))).click();
						if(t.isAlertPresent(driver))
						{
							driver.switchTo().alert().accept();
						}		
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						{
							System.out.println("inside while");
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
						System.out.println( "TC3 Execution started.....");
						
						driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						driver.findElement(By.xpath(Object.getProperty("SIMData"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-7-datagrid']/div/table[1]/thead/tr[2]"));
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
							for(int rnum=0;rnum<arrSplit4.length;rnum++)
							{
								System.out.println(arrSplit4[rnum]);
								if (rowData.contains(arrSplit4[rnum]))
								{
									System.out.println("This Column is present:::"+arrSplit4[rnum]);
									acop = "Dashboard displayed as expected";
									data.put(""+rc, new Object[] {d1[i][0], "SIMData", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
									rc++;
									excel.writePass(d1[i][0], counter, sheet, acop);

								}
								else
								{
									System.out.println("This Column is not present:::"+arrSplit4[rnum]);
									acop = "Dashboard displayed as expected";
									data.put(""+rc, new Object[] {d1[i][0], "SIMData", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									excel.writeFail(d1[i][0], counter, sheet, acop,scr);

								}
							}
						}

					}catch(Exception e)
					{node.log(LogStatus.SKIP, "Skipped TC3 Execution, it is because of page loading issue or due to some other issue");
					e.printStackTrace();}
				}
				if(d1[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						ArrayList<String> tr=new ArrayList<String>();
						int pageSize=0,recordsCount=0;				 	
						System.out.println( "TC4 Execution started.....");
						Thread.sleep(4000);
						
						driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						driver.findElement(By.xpath(Object.getProperty("SIMData"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						driver.findElement(By.xpath(Object.getProperty("GeoExcellAll"))).click();
						Thread.sleep(6000);
						
						WebElement Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder-SIM']/ul"));
						List<WebElement> PageList = Pagination.findElements(By.tagName("li"));
						System.out.println("Size of the page"+PageList.size());
						
						String pageVal = PageList.get(PageList.size()-3).getText();
						System.out.println("Total Pages are "+pageVal);
						PageList.get(PageList.size()-3).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(3000);
						int iTest = Integer.parseInt(pageVal);
						int total = iTest * 10;
						int sum = total - 10;
						System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"+sum);
						
						WebElement ele = driver.findElement(By.xpath(".//*[@id='div-7-datagrid-tbody']"));
						System.out.println(ele.getTagName());
						List<WebElement>page=ele.findElements(By.tagName("tr"));
						System.out.println("PageSize : "+page.size());
						pageSize=page.size();
						int totalSum = sum + page.size();
						System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"+totalSum);

						try
						{
							BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\SIMData-All.xls"));
							String line;			 	
							int m=0;
							while ((line = reader.readLine()) != null)
							{
								if(line.contains("<tr"))
									tr.add(line);			  
								m++;
							}
							reader.close();			 	
							recordsCount=tr.size()-2;
							System.out.println(recordsCount);
						}
						catch (Exception e)
						{e.printStackTrace();}
						System.out.println(recordsCount+":"+totalSum);
						if(recordsCount == totalSum)
						{
							System.out.println("Records count matching... Pass");			 	
							acop = "Reefers DoorAlarm - Print window opened successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0], "SIMData", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);

						}
						else
						{
							System.out.println("Records count mismatch... Fail");
							acop = "Count mismatch";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d1[i][0], "SIMData", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
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
						System.out.println( "TC5 Execution started.....");
						Thread.sleep(4000);
						driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						driver.findElement(By.xpath(Object.getProperty("SIMData"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						driver.findElement(By.xpath(Object.getProperty("GeoRefresh"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						if(!(t.isElementPresentcheck(By.xpath(Object.getProperty("UploadOcp")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("IntroduceUnit")), driver)) || 
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("GetGSMData")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("GetSATData")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("GetUnitData")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("ScrapUnit")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("PowerONStatusReport")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("GeofenceData")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("GeoRefresh")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("GeofanceSearch")), driver)) ||
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("GeoExcellAll")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("SIMDataDashboard")), driver)))
						{
							System.out.println("Page not Re-loaded Successfully");
							acop = "Door Alarm Page Re-Loading Failed";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d1[i][0], "SIMData", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop,scr);								
						}
						else
						{
							System.out.println("Page Re-loaded Successfully");
							acop = "Door Alarm Page Re-Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0], "SIMData", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
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
						System.out.println( "TC6 Execution started.....");
						Thread.sleep(4000);
			
						driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						driver.findElement(By.xpath(Object.getProperty("SIMData"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);			
						WebElement Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder-SIM']/ul"));
						List<WebElement> PageList = Pagination.findElements(By.tagName("li"));
						System.out.println("Size of the page"+PageList.size());

						for(int j=0;j<PageList.size();j++)
						{						
							System.out.println(PageList.get(j).getText());
						}					
						if(PageList.get(0).getText().equalsIgnoreCase("Prev") && PageList.get(PageList.size()-2).getText().equalsIgnoreCase("Next") && PageList.get(PageList.size()-1).getText().contains("Go To Page"))
						{  					
							System.out.println("Pagination Displayed Successfully");
							if(d1[i][5].isEmpty())
							{
								acop = "Pagination Displayed as expected";
								data.put(""+rc, new Object[] {d1[i][0], "UserAdminGeofenceData", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);

							}
							else
							{
								driver.findElement(By.xpath(Object.getProperty("GeoPageDrpdown"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("GeoPageValue"))).sendKeys(d1[i][5]);
								driver.findElement(By.xpath(Object.getProperty("GeoPageSelect"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))								
									Thread.sleep(1000);

								Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder-SIM']/ul"));
								PageList = Pagination.findElements(By.tagName("li"));
								System.out.println(PageList.size());
								for(int j=0;j<PageList.size();j++)
								{
									//PageList.get(j).getAttribute("class");
									if(PageList.get(j).getText().equalsIgnoreCase(d1[i][5]))
									{
										if(PageList.get(j).getAttribute("class").equalsIgnoreCase("active"))
										{
											System.out.println("Selected Page Displayed as expected");
											acop = "Selected Page Displayed as expected";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d1[i][0], "SIMData", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
											rc++;
											excel.writePass(d1[i][0], counter, sheet, acop);	  			  		  					
											break;
										}
										else
										{
											System.out.println("Current Page doesnot match the Page which is selected ");
											acop = "Pagination not displayed as expected";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d1[i][0], "SIMData", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
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
							data.put(""+rc, new Object[] {d1[i][0], "SIMData", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop,scr);								
						}
					}catch(Exception e)
					{node.log(LogStatus.SKIP, "Skipped TC6 Execution, it is because of page loading issue or due to some other issue");
					e.printStackTrace();}
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
