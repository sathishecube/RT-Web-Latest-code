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

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.LogisticUtils;
import dd_utils.TestUtil;


public class ReefersITA extends TestCore 
{
	static TestUtil s =new TestUtil();
	static LogisticUtils Cs =new LogisticUtils();

	@Test
	public static Map<String, Object[]> reeferITAtestcases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase) 
	{
		String acop =null;
		int counter =1;
		ExtentTest node = reports.startTest("ReefersITA");
		String[][] input =TestUtil.getData("ReefersITA");
		driver = new FirefoxDriver(s.excelDownload());
		driver.get(Object.getProperty("URL"));

		try
		{
			if(s.dologin(driver ,input[0][2], input[0][3]))
			{
				System.out.println("Reefer ITA Module");
				for (int i=scase-1;i<ecase;i++)
				{
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ESCAPE);
					Thread.sleep(200);
					robot.keyRelease(KeyEvent.VK_ESCAPE);

					long stime = System.currentTimeMillis();

					String tc=input[i][0];
					String tcdesc =input[i][1];
					String eopt =input[i][11];

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

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  					
								Thread.sleep(1000);

							Thread.sleep(5000);
							if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) || 
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("ITADashboard")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ITAShowFilters")), driver)))
							{
								System.out.println("Page not loaded Successfully");
								acop = "Reefers ITA Page not Loaded Successfully";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  					
							}
							else
							{	
								System.out.println("Page loaded Successfully");
								acop = "Reefers ITA Page Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC1 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

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

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  			
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  			
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-114-datagrid-tbody']/tr/td[2]/a"), driver))
							{

								String Chk=driver.findElement(By.xpath(".//*[@id='div-114-datagrid-tbody']/tr/td[2]/a")).getText();
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
									data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);		  				
								}
								else
								{
									System.out.println("Search value not displayed ");
									acop = "Selected search value"+ Chk +" not displayed Successfully";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);	  					
								}
							}
							else
							{
								System.out.println("Search Failed ... No data Found ");
							}
							driver.findElement(By.xpath(Object.getProperty("ClearSearch"))).click();
							if(s.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
							}		
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC2 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

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

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
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
									data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
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
										data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
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
										String EndDateGet = driver.findElement(By.xpath(Object.getProperty("ITAConfigONDate"))).getText();
										driver.findElement(By.xpath(Object.getProperty("ITAConfigON"))).click();
										while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
										{	
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										String StartDateGet = driver.findElement(By.xpath(Object.getProperty("ITAConfigONDate"))).getText();
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
											data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
											rc++;
											excel.writePass(tc, counter, sheet, acop);	  	  				
										}
										else
										{
											System.out.println("Search value not displayed ");
											acop = "Date not in range";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
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
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);

							}
							s.clearDateRange(driver, Object);
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC3 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
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

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);

							String totalRecords =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
							driver.findElement(By.xpath(Object.getProperty("ITAShowFilters"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(Object.getProperty("ITASensordrpdwn")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("ITATempdrpdwn")), driver) 
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("ITAStatusdrpdwn")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("ITAApply")), driver) 
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("ITACancel")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("ITAClearFilters")), driver))
							{
								System.out.println("Filter Popup window opened Successfully");
								driver.findElement(By.xpath(Object.getProperty("ITASensordrpdwn"))).click();
								driver.findElement(By.xpath(Object.getProperty("ITASensorAmbTemp"))).click();
								System.out.println("Filter values entered");
								driver.findElement(By.xpath(Object.getProperty("ITACancel"))).click();
								String ChkRecords =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
								System.out.println(totalRecords+"::"+ChkRecords);
								if(totalRecords.equalsIgnoreCase(ChkRecords))
								{
									System.out.println("show filter cancel button working as expected");
									acop = "cancel button working as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);		  	  				
								}
								else
								{
									System.out.println("Show filter Cancel Button not working as expected");
									acop = "Cancel button not working as Expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);		  	  				
								}
							}
							else
							{
								acop = "Filter Popup window not Displayed Successfully";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  	  				
							}

							driver.findElement(By.xpath(Object.getProperty("ITAShowFilters"))).click();
							boolean strFilterResult = false;
							strFilterResult = Cs.alarm(driver, Object, "114", "sensor", "6", false, "Text", "ITAApply","ITAClearFilters");
							//s.clearFilter(driver, Object, "StatusClearFilter");
							System.out.println("<<<<<<<<<<<<<<<<<<<<<ITA Sensor Filter Status>>>>>>>>>>>>>"+strFilterResult);
							if(strFilterResult==true)
							{
								System.out.println("ITA Sensor data filter is working as expected");
								acop = "ITA Sensor data filter is working as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  	  				
							}
							else
							{
								System.out.println("ITA Sensor data filter is not working as expected");
								acop = "ITA Sensor data filter is not working as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  	  				
							}
							Thread.sleep(2000);

							driver.findElement(By.xpath(Object.getProperty("ITAShowFilters"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
								Thread.sleep(1000);

							Thread.sleep(1000);

							strFilterResult = Cs.impact(driver, Object, "114", "itaStatus", "21", false, "Text", "ITAApply","ITAClearFilters");
							//s.clearFilter(driver, Object, "StatusClearFilter");
							System.out.println("<<<<<<<<<<<<<<<<<<<<<ITA Status Filter Status>>>>>>>>>>>>>"+strFilterResult);
							if(strFilterResult==true)
							{
								System.out.println("ITA Status data filter is working as expected");
								acop = "ITA Status data filter is working as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);		  	  				
							}
							else
							{
								System.out.println("ITA Status data filter is not working as expected");
								acop = "ITA Status data filter is not working as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);		  	  				
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC4 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
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

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);

							for(int k=1;k<=2;k++)
							{
								List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-114-datagrid']/div/table[1]/thead/tr["+k+"]"));
								List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();

								for(WebElement row:rows)
								{
									List<WebElement> rowElements = row.findElements(By.xpath("th"));

									ArrayList<String> rowData = new ArrayList<String>();

									for(WebElement column:rowElements)
									{
										rowData.add(column.getText().toString());
										// System.out.println("rowData Values are"+rowData);

									}
									System.out.println("rowData  Size "+rowData.size());
									String strMain = input[i][5];
									if(strMain.contains("&"))
									{
										String [] firstSplit =strMain.split("&");
										String[] secondSplit = firstSplit[0].split(",");
										String[] thirdSplit = firstSplit[1].split(",");
										if(k==1)

										{
											for(int rnum=0;rnum<secondSplit.length;rnum++)
											{
												System.out.println(secondSplit[rnum]);
												if (rowData.contains(secondSplit[rnum]))
												{
													System.out.println("This Column is present:::"+secondSplit[rnum]);
													acop = "Dashboard displayed as expected";
													node.log(LogStatus.PASS, acop);
													data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
													rc++;
													excel.writePass(tc, counter, sheet, acop);

												}
												else
												{
													System.out.println("This Column is not present:::"+secondSplit[rnum]);
													acop = "Dashboard displayed as expected";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
													rc++;
													String scr = s.CaptureScreenshot();
													excel.writeFail(tc, counter, sheet, acop,scr);

												}
											}
										}
										if(k==2)

										{
											for(int rnum=0;rnum<thirdSplit.length;rnum++)
											{
												System.out.println(thirdSplit[rnum]);
												if (rowData.contains(thirdSplit[rnum]))
												{
													System.out.println("This Column is present:::"+thirdSplit[rnum]);
													acop = "Dashboard displayed as expected";
													node.log(LogStatus.PASS, acop);
													data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
													rc++;
													excel.writePass(tc, counter, sheet, acop);

												}
												else
												{
													System.out.println("This Column is not present:::"+thirdSplit[rnum]);
													acop = "Dashboard displayed as expected";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
													rc++;
													String scr = s.CaptureScreenshot();
													excel.writeFail(tc, counter, sheet, acop,scr);

												}
											}
										}
									}
								}
							}

						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC5 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}


					if(tc.equalsIgnoreCase("TC6"))
					{
						try
						{
							System.out.println( "TC6 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(input[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-114-datagrid-tbody']/tr/td[2]/a"), driver))
							{
								driver.findElement(By.xpath(".//*[@id='div-114-datagrid-tbody']/tr/td[2]/a")).click();
							}                                
							else
							{
								System.out.println("Search Failed ... No data Found ");
							}
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							//Thread.sleep(3000);
							String pageNo = driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
							int pointToCut=0;
							String totalRecord="Null";
							if(pageNo.contains(" of "))
							{
								pointToCut=pageNo.indexOf(" of ");
								totalRecord = pageNo.substring(pointToCut+4);
								System.out.println(totalRecord);
							}
							else
							{
								System.out.println("Error!!!!!!"+pageNo);
							}
							if(totalRecord.equalsIgnoreCase("0"))
							{
								System.out.println("No Record Found");
								acop = "No Record Found";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);

								Thread.sleep(4000);
								driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
								Thread.sleep(4000);
								driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
								driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
									Thread.sleep(1000);
							}
							else
							{
								System.out.println("Asset History displayed successfully");
								acop = "Asset History displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);						
							}


							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ClearSearch"))).click();

							if(s.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC6 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

					}

					if(tc.equalsIgnoreCase("TC7"))
					{
						try
						{
							System.out.println( "TC7 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))	  				
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
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
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("ITADashboard")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ITAShowFilters")), driver)))
							{
								System.out.println("Page not Re-loaded Successfully");
								acop = "Reefers ITA Page Re-Loading Failed";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  					
							}
							else
							{
								System.out.println("Page Re-loaded Successfully");
								acop = "Reefers ITA Page Re-Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC7 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

					}

					if(tc.equalsIgnoreCase("TC8"))
					{
						try
						{
							System.out.println( "TC8 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);

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
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  						
							}
							else
							{
								System.out.println("Print page not displayed");
								acop = "Print Page not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  					
							}

							robot.keyPress(KeyEvent.VK_ESCAPE);
							Thread.sleep(200);
							robot.keyRelease(KeyEvent.VK_ESCAPE);
							driver.close(); 
							driver.switchTo().window(tabs2.get(0));
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC8 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

					}

					if(tc.equalsIgnoreCase("TC9"))
					{
						try
						{
							ArrayList<String> tr=new ArrayList<String>();
							int pageSize=0,recordsCount=0;

							System.out.println( "TC9 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ExcelDownload"))).click();
							//driver.findElement(By.xpath(".//*[@id='btnExportExcel']")).click();
							Thread.sleep(2000);

							WebElement ele = driver.findElement(By.xpath(".//*[@id='div-114-datagrid-tbody']"));
							System.out.println(ele.getTagName());
							List<WebElement>page=ele.findElements(By.tagName("tr"));
							System.out.println("PageSize : "+page.size());
							pageSize=page.size();


							try
							{
								BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\ITAReport.xls"));
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
							{

								e.printStackTrace();

							}
							System.out.println(recordsCount+":"+pageSize);
							if(recordsCount == pageSize)
							{
								System.out.println("Reocrds count matching... Pass");

								acop = "Count Matching";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);				  			
							}
							else
							{
								System.out.println("Records count mismatch... Fail");
								acop = "Count mismatch";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);			  			 	
							}	  	
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC9 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
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

							if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers") ,Object.getProperty("ITA"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
							{
								System.out.println("Time zone Displayed Successfully");
								acop = "Time zone displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
							else
							{
								System.out.println("Time zone not Displayed ");
								acop = "Time zone not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  					
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC10 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

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

							if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("ITA"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
							{
								System.out.println("Temperature Unit Displayed Successfully");
								acop = "Temperature Unit displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
							else
							{
								System.out.println("Temperature Unit not Displayed ");
								acop = "Temperature Unit not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  					
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC11 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
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

							if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("ITA"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
							{
								System.out.println("Fuel Level Displayed Successfully");
								acop = "Fuel Level displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
							else
							{
								System.out.println("Fuel Level not Displayed ");
								acop = "Fuel Level not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  					
							}
						}catch(Exception e)
						{
							node.log(LogStatus.SKIP, "Skipped TC12 Execution, it is because of page loading issue or due to some other issue");e.printStackTrace();}
					}

					if(tc.equalsIgnoreCase("TC13"))
					{
						try
						{
							System.out.println( "TC13 Execution started......");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))

								Thread.sleep(1000);
							if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("ITA"), Object.getProperty("DADistanceCalcIcon"), Object.getProperty("DADistanceTooltip"), Object.getProperty("DADistanceTooltipval"), Object.getProperty("DADistanceUnit")))
							{
								System.out.println("Distance Unit Displayed Successfully");
								acop = "Distance Unit displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
							else
							{
								System.out.println("Distance Unit not Displayed ");
								acop = "Distance Unit not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  				
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC13 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}

					if(tc.equalsIgnoreCase("TC14"))
					{
						try
						{
							System.out.println( "TC14 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))  					
								Thread.sleep(1000);

							Thread.sleep(3000);

							if((s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)))
							{

								System.out.println("Control Probe loaded Successfully");
								acop = "Control Probe displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
							else
							{	
								System.out.println("Control Probe not loaded Successfully");
								acop = "Control Probe not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);	  					
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC14 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}



					if(tc.equalsIgnoreCase("TC15"))
					{
						try
						{
							System.out.println( "TC15 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))				
								Thread.sleep(1000);

							boolean strFilterResult = false;
							strFilterResult = Cs.checkSortedValue(driver, Object, "114");
							System.out.println("<<<<<<<<<<<<<<<<<<<<<Reefers ITA  Status>>>>>>>>>>>>>"+strFilterResult);
							if (strFilterResult == true)
							{
								System.out.println("Column Sorting Successful");
								acop = "Column Sorting Successful";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);	  					
							}
							else
							{
								System.out.println("Column Sorting Failed");
								acop = "Column Sorting Failed";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}

						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC15 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

					}

					if(tc.equalsIgnoreCase("TC16"))
					{
						try
						{
							System.out.println( "TC16 execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
								Thread.sleep(1000);

							Thread.sleep(1000);	

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
									data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
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
												data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
												rc++;
												excel.writePass(tc, counter, sheet, acop);  		  			  		  					
												break;
											}
											else
											{
												System.out.println("Current Page doesnot match the Page which is selected ");
												acop = "Pagination not displayed as expected";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
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
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);  		  					
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC16 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}

					if(tc.equalsIgnoreCase("TC17"))
					{
						try
						{
							System.out.println( "TC17 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  			 	
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))		  			 	
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
								driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
								driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
								driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li["+sel+"]")).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))			  		
									Thread.sleep(1000);

								WebElement ele = driver.findElement(By.xpath(".//*[@id='div-114-datagrid-tbody']"));
								System.out.println(ele.getTagName());
								List<WebElement>page=ele.findElements(By.tagName("tr"));
								System.out.println("PageSize : "+page.size());
								System.out.println(pageCnt[0]+"="+page.size());
								if (pageCnt[0].equals(""+page.size()))
								{
									System.out.println(page.size()+" Per page loaded successfully");
									driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
									driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
									acop = page.size()+" Per Page Loaded successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(tc, counter, sheet, acop);			  				
								}
								else
								{
									System.out.println(page.size()+" Per page not loaded");
									driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
									driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
									acop = page.size()+" Per Page not Loaded successfully";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(tc, counter, sheet, acop,scr);			  				 
								}
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC17 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}

					if(tc.equalsIgnoreCase("TC18"))
					{
						try
						{
							System.out.println( "TC18 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))                         
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ITA"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))                        
								Thread.sleep(1000);

							driver.findElement(By.xpath(".//*[@id='table-col-114--all-none']/label/span[2]/span")).click();
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
							String chkVal = driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
							String [] getVal = chkVal.split(" - ");
							System.out.println(getVal[1]);
							String [] finalVal = getVal[1].split(" of ");
							System.out.println(finalVal[0]);
							if (finalVal[0].equals(""+arr.size()))
							{
								System.out.println("Select All is working as expected");
								acop = " All None is working";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(tc, counter, sheet, acop);                              
							}
							else
							{
								System.out.println("All none is not working");
								acop = "All none is not working as expected ";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {tc, "ReefersITA", tcdesc, eopt, acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);                              
							} 
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC18 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}


					}

				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw(e);
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
