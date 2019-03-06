package dd_test;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.LogisticUtils;
import dd_utils.TestUtil;



public class ReefersMultiTempHistory extends TestCore 
{
	static TestUtil s =new TestUtil();
	static LogisticUtils Cs =new LogisticUtils();

	@Test
	public static Map<String, Object[]> reefermultitemphistroytestcase(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test ,int scase,int ecase) 
	{
		ExtentTest node = reports.startTest("ReeferMultitempHistory");
		String[][] input =TestUtil.getData("ReeferMultitempHistory");

		String acop =null;
		int counter =1;

		try 
		{
			driver = new FirefoxDriver(s.excelDownload());
			driver.get(Object.getProperty("URL"));
			if(s.dologin(driver, input[0][2], input[0][3]))
			{
				System.out.println("Reefer Multi-Temp History Module");
				for (int i=scase-1;i<ecase;i++)
				{
					Robot robot = new Robot();
					String n = null;
					long stime = System.currentTimeMillis();
					String tc=input[i][0];
					String tcdesc =input[i][1];
					String eopt =input[i][8];
					System.out.println(tc);
					String Chk ="Null";

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

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);	


							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr[1]/td[2]/a"), driver))
							{
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr[1]/td[2]/a")).click();

								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
									Thread.sleep(1000);

								Thread.sleep(3000);  						

								if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempHistory")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownloadAll")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ViewMap")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("pollCommands")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlCommands")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("MoreActions")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempHistoryDashboard")), driver)))
								{
									System.out.println("Page not loaded Successfully");
									acop = "Reefers History Page not Loaded Successfully";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);	  				
								}
								else
								{	
									System.out.println("Page loaded Successfully");
									acop = "Reefers History Page Loaded Successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);  					
								}

							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);		  					
							}
							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);  			
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

					if(tc.equalsIgnoreCase("TC2"))
					{
						try
						{
							String sDate =s.dateConvert(input[i][6]);
							String eDate =s.dateConvert(input[i][7]);
							String LastCntDate ="Null";

							System.out.println( "TC2 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
							{
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
									Thread.sleep(1000);

								Thread.sleep(3000);
								if(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver))
								{  		 				

									driver.findElement(By.xpath(Object.getProperty("EditDateRange"))).click();
									if(s.isElementPresentcheck(By.xpath(Object.getProperty("StartDate")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("EndDate")),driver) 	&& s.isElementPresentcheck(By.xpath(Object.getProperty("SetDateRange")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("DateCancel")),driver))
									{
										System.out.println("Edit date range pop up displayed Successfully");
										if(sDate.equalsIgnoreCase("NA"))
										{
											acop = "Edit date range window should open.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
											rc++;
											String scr = s.CaptureScreenshot();
											excel.writeFail(tc, counter, sheet, acop,scr);	  						  				
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
												data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
												rc++;
												excel.writePass(tc, counter, sheet, acop);	  						  	  					  					
											}
											else
											{
												while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
												{	
													System.out.println("inside while");
													Thread.sleep(1000);
												}
												if(Records=="1")
												{
													LastCntDate =".//*[@id='div-405-datagrid-tbody']/tr/td[6]";
												}
												else
												{
													LastCntDate =".//*[@id='div-405-datagrid-tbody']/tr[1]/td[6]";
												}

												String EndDateGet = driver.findElement(By.xpath(LastCntDate)).getText();
												Thread.sleep(2000);
												driver.findElement(By.xpath(Object.getProperty("HistoryMultiTempCnt"))).click();
												while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
												{	
													System.out.println("inside while");
													Thread.sleep(1000);
												}
												String StartDateGet = driver.findElement(By.xpath(LastCntDate)).getText();
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
													data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
													rc++;
													excel.writePass(tc, counter, sheet, acop);

												}
												else
												{
													System.out.println("Search value not displayed ");
													acop = "Date not in range";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
													rc++;
													String scr = s.CaptureScreenshot();
													excel.writeFail(tc, counter, sheet, acop,scr);

												}

											}
										}
									}
									else
									{
										System.out.println("Edit date range pop up not displayed");
										acop = "Edit date range window not yet opened.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
										rc++;
										String scr = s.CaptureScreenshot();
										excel.writeFail(tc, counter, sheet, acop,scr);

									}
									//s.clearDateRange(driver, Object);
									//while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
									//Thread.sleep(1000);

								}
								else
								{	
									acop = "No data";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);	  								
								}
							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  						  
							}
							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);  				  			
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
							System.out.println( "TC3 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(3000);

							Thread.sleep(3000);
							if(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver))
							{

								driver.findElement(By.xpath(Object.getProperty("RefreshIcon"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
									Thread.sleep(1000);

								if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("StatusHistory")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempHistory")), driver)) || 
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("MaintenanceHistory")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PretripHistory")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("AlarmHistory")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationHistory")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("TempProfileHistory")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ImpactHistory")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("ITAHistory")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("SMHistory")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelFlowHistory")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("WaybillHistory")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("DoorAlarmHistory")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownloadAll")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ViewMap")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("pollCommands")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlCommands")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("MoreActions")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) ||
										!(s.isElementPresentcheck(By.xpath(Object.getProperty("MultiTempHistoryDashboard")), driver)))
								{
									System.out.println("Page not Re-loaded Successfully");
									acop = "Reefers History Page not Re-Loaded Successfully";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);		  					
								}
								else
								{	
									System.out.println("Page Re-loaded Successfully");
									acop = "Reefers History Page Re-Loaded Successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);		  					
								}
								//s.clearDateRange(driver, Object);
								//while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								//Thread.sleep(1000);



							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  						  	
							}
							

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);  				  			
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

					if(tc.equalsIgnoreCase("TC4"))
					{
						try
						{
							System.out.println( "TC4 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(Object.getProperty("ViewMap")), driver))
							{					

								String parentHandle = driver.getWindowHandle(); // get the current window handle
								System.out.println(parentHandle);               //Prints the parent window handle
								driver.findElement(By.xpath(Object.getProperty("ViewMap"))).click();
								Thread.sleep(4000);//Clicking on this window

								for (String winHandle : driver.getWindowHandles()) 
								{ //Gets the new window handle
									System.out.println(winHandle);
									driver.switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)             
								}

								int count=0;
								while(!s.isElementPresentcheck(By.xpath(".//*[@id='map']/div/div[1]/div[4]/div[4]/div/h2"), driver))
								{
									count++;
									Thread.sleep(2000);
									if(count>=10)
										break;
								}    


								if(s.isElementPresentcheck(By.xpath(".//*[@id='map_reportName']"),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("PrintMap")),driver)
										&& s.isElementPresentcheck(By.xpath(Object.getProperty("ShowAll")),driver))
								{
									System.out.println("All the filds are present in the Map view");
									acop = "Status Map View Loaded Successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);
								}
								else
								{
									System.out.println("Mismatch Found");
									acop = "Status Map View not Loaded Successfully";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);
								}

								driver.findElement(By.xpath(Object.getProperty("PrintMap"))).click();
								Thread.sleep(3000);
								Robot r = new Robot();
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(200);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								Thread.sleep(2000);
								driver.findElement(By.xpath(".//*[@id='map_list']/ul/li[1]/a")).click();
								Thread.sleep(1000);           
								driver.findElement(By.xpath(Object.getProperty("ShowAll"))).click();

								Thread.sleep(2000);
								if(s.isElementPresentcheck(By.xpath(".//*[@id='showDoorStatus']"),driver))
								{
									System.out.println("Show All is working as expected");
									acop = "Status Map View all the asset maps Loaded Successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);
								}
								else
								{
									System.out.println("Show All is not working");
									acop = "Status Show All is not working";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);
								}
								driver.findElement(By.xpath(".//*[@id='map']/div/div[11]/div[2]/div[1]")).click();
								Thread.sleep(4000);
								driver.findElement(By.xpath(".//*[@id='map']/div/div[11]/div[3]/div")).click();
								Thread.sleep(4000);


								driver.close();                           // close newly opened window when done with it
								driver.switchTo().window(parentHandle);                 
								//s.clearDateRange(driver, Object);
								//while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								//	Thread.sleep(1000);



							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}
							

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);  				  			
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

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();

							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver))
							{
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
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);  						
								}
								else
								{
									System.out.println("Print page not displayed");
									acop = "Print Page not displayed as expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);  					
								}
								//Robot robot = new Robot();
								robot.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(200);
								robot.keyRelease(KeyEvent.VK_ESCAPE);
								Thread.sleep(2000);
								driver.close();
								Thread.sleep(2000);
								driver.switchTo().window(tabs2.get(0));
								Thread.sleep(2000);
								//s.clearDateRange(driver, Object);
								//while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								//	Thread.sleep(1000);  					  				

							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}
							driver.findElement(By.xpath(".//*[@id='div-100']")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

 			
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

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
							{
								Chk =driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).getText();
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							}

							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver))
							{

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
								Thread.sleep(2000);

								ArrayList<String> tr=new ArrayList<String>();
								int pageSize=0,recordsCount=0;

								driver.findElement(By.xpath(Object.getProperty("ExcelDownload"))).click();

								WebElement ele = driver.findElement(By.xpath(".//*[@id='div-405-datagrid-tbody']"));
								System.out.println(ele.getTagName());
								List<WebElement>page=ele.findElements(By.tagName("tr"));
								System.out.println("PageSize : "+page.size());
								//System.out.println("PageSize : "+pageSize);
								pageSize=page.size();
								try
								{
									BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\MultiTempHistoryReport("+Chk+").xls"));
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

									acop = "Count Matching";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);			  			
								}
								else
								{
									System.out.println("Records count mismatch... Fail");
									acop = "Count mismatch";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);		  			 	
								}
								//s.clearDateRange(driver, Object);
								//while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								//	Thread.sleep(1000);



							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}
							driver.findElement(By.xpath(".//*[@id='div-100']")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

		
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

					if(tc.equalsIgnoreCase("TC7"))
					{
						try
						{
							ArrayList<String> tr=new ArrayList<String>();
							int pageSize=0,recordsCount=0;
							int chkIndex=0;
							String Records="Null";
							System.out.println( "TC7 Execution started.....");
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
							{
								Chk =driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).getText();
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							}
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(Object.getProperty("GetNoOfPages")), driver))
							{

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
								Thread.sleep(4000);
								Runtime.getRuntime().exec("\\\\amxserver\\amx-share\\STW_QA\\Rtweb Automation\\Auto_It\\chumma.exe");
								Thread.sleep(10000);

								System.out.println(recordsCount+":"+pageSize);
								if(Record>10000)
								{
									Record = 10000;
								}

								int lineNumberCount = 0;
								String filePath =	"E:\\workspace\\RT_Web_Automation_Excel_Download\\ReeferMultiTempHistory-All_"+Chk+".csv";
								System.out.println(filePath); 
								File file = new File(filePath); 
								if (file.exists()) 
								{ 
									System.out.println("File found :" ); 
									FileReader fr = new FileReader(file); 
									LineNumberReader linenumberreader = new LineNumberReader(fr); 
									while (linenumberreader.readLine() != null) 
									{
										lineNumberCount++; 
									} //To remove the header 
									lineNumberCount=lineNumberCount-1; 
									System.out.println("Total number of lines found in csv : " + (lineNumberCount)); 
									linenumberreader.close(); 
								} 
								else 
								{ 
									System.out.println("File does not exists");
								}

								if(lineNumberCount == Record)
								{
									System.out.println("Reocrds count matching... Pass");

									acop = "Reefers Status History Download-All downloaded successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);				  			
								}
								else
								{
									System.out.println("Records count mismatch... Fail");
									acop = "Count mismatch";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);			  			 
								}
								//s.clearDateRange(driver, Object);
								//while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								//	Thread.sleep(1000);


							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}

							driver.findElement(By.xpath(".//*[@id='div-100']")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

	  			
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

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();

							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);



							if(s.isElementPresentcheck(By.xpath(Object.getProperty("Reefers")), driver))
							{
								if(s.unitofMeasure1(driver, Object, Object.getProperty("Reefers") ,Object.getProperty("MultiTemp"), "105", Object.getProperty("MultiTempHistory"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
								{
									System.out.println("Time zone Displayed Successfully");
									acop = "Time zone displayed as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);	  					
								}
								else
								{
									System.out.println("Time zone not Displayed ");
									acop = "Time zone not displayed as expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);	  					
								}
								//s.clearDateRange(driver, Object);
								//while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								//	Thread.sleep(1000);


							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}
							driver.findElement(By.xpath(".//*[@id='div-100']")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

 			
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

					if(tc.equalsIgnoreCase("TC9"))
					{
						Thread.sleep(2000);
						try
						{
							System.out.println( "TC9 Execution started.....");
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(Object.getProperty("Reefers")), driver))
							{
								if(s.unitofMeasure1(driver, Object, Object.getProperty("Reefers"), Object.getProperty("MultiTemp"), "105", Object.getProperty("MultiTempHistory"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
								{
									System.out.println("Temperature Unit Displayed Successfully");
									acop = "Temperature Unit displayed as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);	  					
								}
								else
								{
									System.out.println("Temperature Unit not Displayed ");
									acop = "Temperature Unit not displayed as expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);	  					
								}
								//s.clearDateRange(driver, Object);
								//while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								//	Thread.sleep(1000);

								driver.findElement(By.xpath(".//*[@id='div-100']")).click();

							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

  			
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

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(Object.getProperty("Reefers")), driver))
							{
								if(s.unitofMeasure1(driver, Object, Object.getProperty("Reefers"), Object.getProperty("MultiTemp"), "105", Object.getProperty("MultiTempHistory"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
								{
									System.out.println("Fuel Level Displayed Successfully");
									acop = "Fuel Level displayed as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);	  					
								}
								else
								{
									System.out.println("Fuel Level not Displayed ");
									acop = "Fuel Level not displayed as expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);	  					
								}
								


							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}
							driver.findElement(By.xpath(".//*[@id='div-100']")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

			
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

					if(tc.equalsIgnoreCase("TC11"))
					{
						Thread.sleep(2000);
						try
						{
							System.out.println( "TC11 Execution started.....");
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							Thread.sleep(2000);
							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
							{
								System.out.println("Element is Present.........................................................");
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							}
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							Thread.sleep(2000);
							if(s.isElementPresentcheck(By.xpath(Object.getProperty("Reefers")), driver))
							{

								if(s.unitofMeasure1(driver, Object, Object.getProperty("Reefers"), Object.getProperty("MultiTemp"), "105", Object.getProperty("MultiTempHistory"), Object.getProperty("DistanceCalcIcon"), Object.getProperty("DistanceTooltip"), Object.getProperty("DistanceTooltipval"), Object.getProperty("DistanceUnit")))
								{
									System.out.println("Distance Unit Displayed Successfully");
									acop = "Distance Unit displayed as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);	  					
								}
								else
								{
									System.out.println("Distance Unit not Displayed ");
									acop = "Distance Unit not displayed as expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);	  					
								}

							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}
							driver.findElement(By.xpath(".//*[@id='div-100']")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

  			
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

					if(tc.equalsIgnoreCase("TC12"))
					{
						Thread.sleep(2000);
						try
						{
							System.out.println( "TC12 Execution started.....");
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
							{
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							}
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver))
							{
								if((s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)))
								{

									System.out.println("Control Probe loaded Successfully");
									acop = "Control Probe displayed as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);	  					
								}
								else
								{	
									System.out.println("Control Probe not loaded Successfully");
									acop = "Control Probe not displayed as expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);	  					
								}
								driver.findElement(By.xpath(".//*[@id='div-100']")).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
									Thread.sleep(1000);
								driver.findElement(By.xpath(Object.getProperty("ClearSearch"))).click();
								if(s.isAlertPresent(driver))
								{
									driver.switchTo().alert().accept();
								}		
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
									Thread.sleep(1000);

							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}

							driver.findElement(By.xpath(".//*[@id='div-100']")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

 			
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

					if(tc.equalsIgnoreCase("TC13"))
					{
						Thread.sleep(2000);
						try
						{
							System.out.println( "TC13 Execution started.....");
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
							{
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							}
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath("//*[@id='btnEditDateRange']"), driver))
							{

								List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-405-datagrid']/div/table[1]/thead/tr[2]"));
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
									String strMain = input[i][6];
									String[] arrSplit4 = strMain.split(",");
									System.out.println(arrSplit4.length);
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
										System.out.println(cnt+"::"+arrSplit4.length);
									}
									System.out.println(cnt+"::"+arrSplit4.length);
									if(cnt==arrSplit4.length)
									{
										System.out.println("All Column is Present");
										acop = "Dashboard displayed as expected";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
										rc++;
										excel.writePass(tc, counter, sheet, acop);

									}
									else
									{
										System.out.println("Column Not Present");
										acop = "Dashboard NOT displayed as expected";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
										rc++;
										String scr = s.CaptureScreenshot();
										excel.writeFail(tc, counter, sheet, acop,scr);

									}

								}  				 	
							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}
							

							driver.findElement(By.xpath(".//*[@id='div-100']")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

	
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

					if(tc.equalsIgnoreCase("TC14"))
					{
						Thread.sleep(2000);
						try
						{
							System.out.println( "TC14 Execution started.....");
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
							{
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							}
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath("//*[@id='btnEditDateRange']"), driver))
							{

								boolean strFilterResult = false;
								strFilterResult = Cs.checkSortedValue(driver, Object, "405");
								System.out.println("<<<<<<<<<<<<<<<<<<<<<Reefer MultiTemp History Status>>>>>>>>>>>>>"+strFilterResult);
								if (strFilterResult == true)
								{
									System.out.println("Column Sorting Successful");
									acop = "Column Sorting Successful";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);	  					
								}
								else
								{
									System.out.println("Column Sorting Failed");
									acop = "Column Sorting Failed";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);	  					
								}
							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}

							driver.findElement(By.xpath(".//*[@id='div-100']")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

			
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

					if(tc.equalsIgnoreCase("TC15"))
					{
						Thread.sleep(2000);
						try
						{
							System.out.println( "TC15 Execution started.....");
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
							{
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							}
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							Thread.sleep(1000);	
							if(s.isElementPresentcheck(By.xpath("//*[@id='btnEditDateRange']"), driver))
							{						
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
									if(input[i][5].isEmpty())
									{
										acop = "Pagination Displayed as expected";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
										rc++;
										excel.writePass(tc, counter, sheet, acop);	  		  				
									}
									else
									{
										driver.findElement(By.xpath(Object.getProperty("PageDrpdown"))).click();
										Thread.sleep(2000);
										driver.findElement(By.xpath(Object.getProperty("PageValue"))).sendKeys(input[i][6]);
										driver.findElement(By.xpath(Object.getProperty("PageSelect"))).click();
										while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
											Thread.sleep(1000);

										Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
										PageList = Pagination.findElements(By.tagName("li"));
										System.out.println(PageList.size());
										for(int j=0;j<PageList.size();j++)
										{
											//PageList.get(j).getAttribute("class");
											if(PageList.get(j).getText().equalsIgnoreCase(input[i][6]))
											{
												if(PageList.get(j).getAttribute("class").equalsIgnoreCase("active"))
												{
													System.out.println("Selected Page Displayed as expected");
													acop = "Selected Page Displayed as expected";
													node.log(LogStatus.PASS, acop);
													data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
													rc++;
													excel.writePass(tc, counter, sheet, acop);		  			  		  					
													break;
												}
												else
												{
													System.out.println("Current Page doesnot match the Page which is selected ");
													acop = "Pagination not displayed as expected";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
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
									data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);		  					
								}

							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}

							driver.findElement(By.xpath(".//*[@id='div-100']")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

			
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

					if(tc.equalsIgnoreCase("TC16"))
					{
						Thread.sleep(2000);
						try
						{
							System.out.println( "TC16 Execution started.....");
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
							{
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							}
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(Object.getProperty("GetNoOfPages")), driver))
							{
								int chkIndex=0;
								String TotalPages =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
								System.out.println("Total no. of Pages"+TotalPages);
								String Records = "Null";
								if(TotalPages.contains(" of "))
								{
									chkIndex=TotalPages.indexOf(" of ");
									Records = TotalPages.substring(chkIndex+4);

									System.out.println("No. of Records"+Records);
								}


								Select se = new Select(driver.findElement(By.id("per-page__select")));
								List<WebElement> l = se.getOptions();
								l.size();
								System.out.println("No.of Rows in dropdown"+l.size());
								driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
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
									/////////////////////Door Alarm has only 28 Records so here we are breaking the loop////////////////////
									if(sel==2)
									{
										break;
									} 
									////////////////////////////////////////////////////////////////////////////////////////////////////////////
									String [] pageCnt = dropVal[sel].split(" ");

									driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
									driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
									driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
									driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
									Thread.sleep(2000);
									driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li["+sel+"]")).click();
									while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
										Thread.sleep(1000);

									WebElement ele = driver.findElement(By.xpath(".//*[@id='div-405-datagrid-tbody']"));
									System.out.println(ele.getTagName());
									List<WebElement>page=ele.findElements(By.tagName("tr"));
									System.out.println("PageSize : "+page.size());
									System.out.println(pageCnt[0]+"="+page.size());
									System.out.println(Records+":::::::::::"+page.size());
									if(page.size()<10)
									{
										if (Records.equals(""+page.size()))
										{
											System.out.println(page.size()+" Per page loaded successfully");
											driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
											driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
											acop = page.size()+" Per Page Loaded successfully";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
											rc++;
											excel.writePass(tc, counter, sheet, acop);

										}
										else
										{
											System.out.println(page.size()+" Per page not loaded");
											driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
											driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
											acop = page.size()+" Per Page not Loaded successfully";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
											rc++;
											String scr = s.CaptureScreenshot();
											excel.writeFail(tc, counter, sheet, acop,scr);

										}
									}
									else
									{

										if (pageCnt[0].equals(""+page.size()))
										{
											System.out.println(page.size()+" Per page loaded successfully");
											driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
											driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
											acop = page.size()+" Per Page Loaded successfully";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
											rc++;
											excel.writePass(tc, counter, sheet, acop);

										}
										else
										{
											System.out.println(page.size()+" Per page not loaded");
											driver.findElement(By.xpath(Object.getProperty("Recordsperpage"))).click();
											driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
											acop = page.size()+" Per Page not Loaded successfully";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
											rc++;
											String scr = s.CaptureScreenshot();
											excel.writeFail(tc, counter, sheet, acop,scr);

										}
									}
									//
								}
							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}

							driver.findElement(By.xpath(".//*[@id='div-100']")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

		
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

					if(tc.equalsIgnoreCase("TC17"))
					{
						Thread.sleep(2000);
						try
						{
							System.out.println( "TC17 Execution started.....");
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							//Thread.sleep(3000);
							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a"), driver))
							{
								Thread.sleep(2000);
								driver.findElement(By.xpath(".//*[@id='div-105-datagrid-tbody']/tr/td[2]/a")).click();
							}
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);	  				

							Thread.sleep(4000);
							if(s.isElementPresentcheck(By.xpath(Object.getProperty("HistoryShowComp3")), driver))
							{
								driver.findElement(By.xpath(Object.getProperty("HistoryShowComp3"))).click();
								Thread.sleep(4000);

								List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-405-datagrid']/div/table[1]/thead/tr[2]"));
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
									String strMain = input[i][6];
									String[] arrSplit4 = strMain.split(",");
									System.out.println(arrSplit4.length);
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
										System.out.println(cnt+"::"+arrSplit4.length);
									}
									System.out.println(cnt+"::"+arrSplit4.length);
									if(cnt==arrSplit4.length)
									{
										System.out.println("All Column is Present including Compartment3");
										acop = "Dashboard displayed as expected";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
										rc++;
										excel.writePass(tc, counter, sheet, acop);

									}
									else
									{
										System.out.println("Compartment3 Column Not Present");
										acop = "Dashboard NOT displayed as expected";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
										rc++;
										String scr = s.CaptureScreenshot();
										excel.writeFail(tc, counter, sheet, acop,scr);

									}

								}  				 	
							}
							else
							{
								acop = "No data";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReeferMultiTempHistory", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);  						  
							}
							s.clearDateRange(driver, Object);
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(".//*[@id='div-100']")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

  			
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


				}
			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			System.out.println("---------------------------------------------------------");
			//driver.close();
			reports.endTest(node);
			reports.flush();
			return data;
		}


	}
}
