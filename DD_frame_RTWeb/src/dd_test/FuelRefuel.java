package dd_test;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.LogisticUtils;
import dd_utils.TestUtil;


public class FuelRefuel extends TestCore 
{
	static TestUtil s =new TestUtil();
	static LogisticUtils Cs =new LogisticUtils();

	@Test
	public static Map<String, Object[]> fuelrefueltestcases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase) 
	{
		String acop =null;
		int counter =1;
		ExtentTest node = reports.startTest("FuelRefuel");
		String[][] input =TestUtil.getData("FuelRefuel");

		try
		{
			driver = new FirefoxDriver(s.excelDownload());
			driver.get(Object.getProperty("URL"));
			if(s.dologin(driver ,input[0][2], input[0][3]))
			{
				System.out.println("Fuel Refuel Module");
				for (int i=scase-1;i<ecase;i++)
				{
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ESCAPE);
					Thread.sleep(200);
					robot.keyRelease(KeyEvent.VK_ESCAPE);


					long stime = System.currentTimeMillis();

					String tc=input[i][0];
					String tcdesc =input[i][1];
					String eopt =input[i][8];

					System.out.println(tc);
					if(tc.equalsIgnoreCase("TC1"))
					{
						try
						{
							System.out.println( "TC1 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Fuel"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							Thread.sleep(4000);
							if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownloadAll")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || 
									(!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelDashboard")), driver)))
							{
								System.out.println("Page not loaded Successfully");
								acop = "FuelRefuel Page not Loaded Successfully";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);

							}
							else
							{	
								System.out.println("Page loaded Successfully");
								acop = "FuelRefuel Page Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);

							}
						}catch(Exception e)
						{e.printStackTrace();}

					}

					if(tc.equalsIgnoreCase("TC2"))
					{
						try
						{
							System.out.println( "TC2 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Fuel"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).clear();
							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							Thread.sleep(4000);
							if(s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver))
							{

								String Chk=driver.findElement(By.xpath(".//*[@id='div-126-datagrid-tbody']/tr[1]/td[1]")).getText();
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
								if(Chk.equalsIgnoreCase(input[i][5]))
								{
									System.out.println("Search value displayed Successfully");
									acop = "Selected search value"+ Chk +" displayed Successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);

								}
								else
								{
									System.out.println("Search value not displayed ");
									acop = "Selected search value"+ Chk +" not displayed Successfully";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);

								}
							}
							else
							{
								System.out.println("Search Failed ... No data Found ");
								acop = "No data found";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);

							}
							driver.findElement(By.xpath(Object.getProperty("ClearSearch"))).click();
							if(s.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
							}		
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

						}catch(Exception e)
						{e.printStackTrace();}
					}

					if(tc.equalsIgnoreCase("TC3"))
					{
						try
						{
							String sDate =s.dateConvert(input[i][6]);
							String eDate =s.dateConvert(input[i][7]);

							System.out.println( "TC3 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Fuel"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("EditDateRange"))).click();
							if(s.isElementPresentcheck(By.xpath(Object.getProperty("StartDate")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("EndDate")),driver) 
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("SetDateRange")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("DateCancel")),driver))
							{
								System.out.println("Edit date range pop up displayed Successfully");
								if(sDate.equalsIgnoreCase("NA"))
								{
									acop = "Edit date range window should open.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);

								}
								else
								{
									driver.findElement(By.xpath(Object.getProperty("StartDate"))).sendKeys(sDate);
									driver.findElement(By.xpath(Object.getProperty("EndDate"))).sendKeys(eDate);
									driver.findElement(By.xpath(Object.getProperty("SetDateRange"))).click();
									String strMain = driver.findElement(By.xpath(Object.getProperty("DateRangeDisplay"))).getText();
									System.out.println("Date range displayed as expected");

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
										data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
										rc++;
										excel.writePass(tc, counter, sheet, acop);

									}
									else
									{
										String EndDateGet = driver.findElement(By.xpath(Object.getProperty("EventStampTime"))).getText();
										driver.findElement(By.xpath(Object.getProperty("EventStamp"))).click();
										while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
											Thread.sleep(1000);
										String StartDateGet = driver.findElement(By.xpath(Object.getProperty("EventStampTime"))).getText();
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
											data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
											rc++;
											excel.writePass(tc, counter, sheet, acop);

										}
										else
										{
											System.out.println("Search value not displayed ");
											acop = "Date not in range";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
											rc++;
											String scr = s.CaptureScreenshot();
											excel.writeFail(tc, counter, sheet, acop,scr);
											System.out.println( "###################Test case 3 execution failed############################");
										}

									}
								}
							}
							else
							{
								System.out.println("Edit date range pop up not displayed");
								acop = "Edit date range window not yet opened.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);

							}
							s.clearDateRange(driver, Object);
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

						}catch(Exception e)
						{e.printStackTrace();}
					}

					if(tc.equalsIgnoreCase("TC4"))
					{
						try
						{
							System.out.println( "TC4 execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Fuel"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							Thread.sleep(3000);

							List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-126-datagrid']/div/table[1]/thead/tr[2]"));
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
								System.out.println("rowData Values are"+rowData);
								System.out.println("rowData  Size "+rowData.size());
								String strMain = input[i][5];
								String[] arrSplit4 = strMain.split(",");

								int cnt = 0;

								for(int rnum=0;rnum<arrSplit4.length;rnum++)
								{
									for(String string : rowData)
									{
										if(string.equalsIgnoreCase(arrSplit4[rnum]))
										{
											cnt++;
											System.out.println(arrSplit4[rnum]+" is present...");
										}
										//System.out.println(cnt+"::"+arrSplit4.length);
									}
									//System.out.println(cnt+"::"+arrSplit4.length);
								}
								System.out.println(cnt+"::"+arrSplit4.length);
								if(cnt==arrSplit4.length)
								{
									System.out.println("All Column is Present");
									acop = "Dashboard displayed as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);

								}
								else
								{
									System.out.println("Column Not Present");
									acop = "Dashboard Not displayed as expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);

								}

							}	  				 	
						}catch(Exception e)
						{e.printStackTrace();}

					}

					if(tc.equalsIgnoreCase("TC5"))
					{
						try
						{
							System.out.println( "TC5 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("Fuel"))).click();
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
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownloadAll")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || 
									(!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelDashboard")), driver)))
							{
								System.out.println("Page not Re-loaded Successfully");
								acop = "Fuel Page Re-Loading Failed";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});  
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  					
							}
							else
							{
								System.out.println("Page Re-loaded Successfully");
								acop = "Fuel Page Re-Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
						}catch(Exception e)
						{e.printStackTrace();}

					}

					if(tc.equalsIgnoreCase("TC6"))
					{
						try
						{
							System.out.println( "TC6 execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("Fuel"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("PrintIcon"))).click();
							Thread.sleep(4000);
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
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  						
							}
							else
							{
								System.out.println("Print page not displayed");
								acop = "Print Page not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);

							}
							//Robot robot = new Robot();
							robot.keyPress(KeyEvent.VK_ESCAPE);
							Thread.sleep(200);
							robot.keyRelease(KeyEvent.VK_ESCAPE);
							driver.close(); 
							driver.switchTo().window(tabs2.get(0));
						}catch(Exception e)
						{e.printStackTrace();}

					}

					if(tc.equalsIgnoreCase("TC7"))
					{
						try
						{
							ArrayList<String> tr=new ArrayList<String>();
							int pageSize=0,recordsCount=0;

							System.out.println( "TC7 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("Fuel"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ExcelDownload"))).click();

							WebElement ele = driver.findElement(By.xpath(".//*[@id='div-126-datagrid-tbody']"));
							System.out.println(ele.getTagName());
							List<WebElement>page=ele.findElements(By.tagName("tr"));
							System.out.println("PageSize : "+page.size());
							//System.out.println("PageSize : "+pageSize);
							pageSize=page.size();
							try
							{
								BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\RefuelReport.xls"));
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

								acop = "Fuel - Print window opened successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);				  			
							}
							else
							{
								System.out.println("Records count mismatch... Fail");
								acop = "Count mismatch";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
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
							ArrayList<String> tr=new ArrayList<String>();
							int pageSize=0,recordsCount=0;
							int chkIndex=0;
							String Records="Null";

							System.out.println( "TC8 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("Fuel"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							String TotalPages =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
							if(TotalPages.contains(" of "))
							{
								chkIndex=TotalPages.indexOf(" of ");
								Records = TotalPages.substring(chkIndex+4);
								System.out.println(Records);
							}
							//Integer.parseInt(myBuilderOrBuffer.toString());
							int Record = Integer.parseInt(Records);
							driver.findElement(By.xpath(Object.getProperty("ExcelDownloadAll"))).click();
							Thread.sleep(12000);
							try
							{
								CSVReader reader = new CSVReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\RefuelReport-All.csv"));
								List<String[]> li=reader.readAll();
								System.out.println("Total rows which we have is "+li.size());
								recordsCount = li.size()-1;

								
							}
							catch (Exception e)
							{

								e.printStackTrace();

							}
							System.out.println(recordsCount+":"+pageSize);
							if(recordsCount == Record)
							{
								System.out.println("Reocrds count matching... Pass");

								acop = "Fuel Download-All downloaded successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);

							}
							else
							{
								System.out.println("Records count mismatch... Fail");
								acop = "Count mismatch";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
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
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers") ,Object.getProperty("Fuel"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
							{
								System.out.println("Time zone Displayed Successfully");
								acop = "Time zone displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
							else
							{
								System.out.println("Time zone not Displayed ");
								acop = "Time zone not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
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
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("Fuel"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
							{
								System.out.println("Temperature Unit Displayed Successfully");
								acop = "Temperature Unit displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
							else
							{
								System.out.println("Temperature Unit not Displayed ");
								acop = "Temperature Unit not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  					
							}
						}catch(Exception e)
						{e.printStackTrace();}
					}

					if(tc.equalsIgnoreCase("TC11"))
					{
						try
						{
							System.out.println( "TC11 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("Fuel"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
							{
								System.out.println("Fuel Level Displayed Successfully");
								acop = "Fuel Level displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
							else
							{
								System.out.println("Fuel Level not Displayed ");
								acop = "Fuel Level not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  					
							}
						}catch(Exception e)
						{e.printStackTrace();}
					}

					if(tc.equalsIgnoreCase("TC12"))
					{
						try
						{
							System.out.println( "TC12 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("Fuel"), Object.getProperty("DistanceCalcIcon"), Object.getProperty("DistanceTooltip"), Object.getProperty("DistanceTooltipval"), Object.getProperty("DistanceUnit")))
							{
								System.out.println("Distance Unit Displayed Successfully");
								acop = "Distance Unit displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
							else
							{
								System.out.println("Distance Unit not Displayed ");
								acop = "Distance Unit not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  					
							}
						}catch(Exception e)
						{e.printStackTrace();}
					}

					if(tc.equalsIgnoreCase("TC13"))
					{
						try
						{
							System.out.println( "TC13 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Fuel"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							Thread.sleep(3000);

							if((s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)))
							{

								System.out.println("Control Probe loaded Successfully");
								acop = "Control Probe displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "FuelRefuel", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
							else
							{	
								System.out.println("Control Probe not loaded Successfully");
								acop = "Control Probe not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersMultiTemp", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  					
							}
						}catch(Exception e)
						{e.printStackTrace();}
					}




				}
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
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
