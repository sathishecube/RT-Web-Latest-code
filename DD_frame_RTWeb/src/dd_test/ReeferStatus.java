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
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.LogisticUtils;
import dd_utils.TestUtil;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ReeferStatus extends TestCore
{
	static TestUtil s =new TestUtil();
	static LogisticUtils Cs =new LogisticUtils();

	@Test
	public static Map<String, Object[]> reeferStatustestcases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase)
	{
		System.out.println("Reefer Status Module");
		String acop =null;
		int counter =1;

		ExtentTest node = reports.startTest("ReeferStatus");
		String[][] d1 =TestUtil.getData("ReeferStatus");
		try
		{
			driver = new FirefoxDriver(s.excelDownload());
			driver.get(Object.getProperty("URL"));

			if(s.dologin(driver ,d1[0][2], d1[0][3]))
			{
				for(int i=scase-1;i<ecase;i++ )
				{

					long stime=System.currentTimeMillis();
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ESCAPE);
					Thread.sleep(200);
					robot.keyRelease(KeyEvent.VK_ESCAPE);




					if(d1[i][0].equalsIgnoreCase("TC1"))
					{
						try
						{
							System.out.println( "TC1 Execution Started.....");
							Thread.sleep(10000);

							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();				
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							System.out.println("before while");
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(5000);

							driver.findElement(By.xpath(Object.getProperty("ColumnShowHide"))).click();
							do
							{
								Thread.sleep(1000);
							}while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver));

							if(driver.findElement(By.xpath(".//*[@id='div-100-columnSettings']/div/div/div[1]/div[1]/label/span/span")).isSelected())
							{
								System.out.println("All Columns selected");
								driver.findElement(By.xpath(Object.getProperty("ShowHideColumnCancel"))).click();
								Thread.sleep(1000);
							}
							else
							{
								driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();
								driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
									Thread.sleep(1000);


							}


							if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("ReeferSearch")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("EditDateRange")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("RefreshIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("PrintIcon")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("PageNumber")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownload")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("DateTimeIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("TemperatureIcon")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("FuelLevelIcon")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("DistanceCalcIcon")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownloadAll")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("StatusShowFilter")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("SelectAssetTags")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ColumnShowHide")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("StatusDashboard")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ViewMap")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("pollCommands")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlCommands")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("MoreActions")), driver)))
							{
								System.out.println("Page not loaded Successfully");
								acop = "Reefers Status Page not Loaded Successfully";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);								
							}
							else
							{
								System.out.println("Page loaded Successfully");
								acop = "Reefers Status Page Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);							
							}
							System.out.println("TC1 Execution completed.");

						}catch(Exception e)
						{
							//Assert.assertTrue(false);
							node.log(LogStatus.INFO, ExceptionUtils.getStackTrace(e));
							
							e.printStackTrace();}


					}


					if(d1[i][0].equalsIgnoreCase("TC2"))
					{
						try
						{
							System.out.println( "TC2 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();

							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							//driver.findElement(By.xpath(Object.getProperty("ColumnShowHide"))).click();
							do
							{
								Thread.sleep(5000);
							}while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver));

							if(driver.findElement(By.xpath(".//*[@id='div-100-columnSettings']/div/div/div[1]/div[1]/label/span")).isSelected())
							{
								System.out.println("All Columns selected");
								//driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
									Thread.sleep(5000);
								Thread.sleep(5000);
							}
							else
							{
								//driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();
							//	driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
									Thread.sleep(5000);					
								Thread.sleep(5000);
							}

							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(d1[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							Thread.sleep(5000);
							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr"), driver))
							{
								String Chk=driver.findElement(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr/td[2]/a")).getText();

								int pt=0;
								String cut="Null";
								if(Chk.contains("\n"))
								{
									pt=Chk.indexOf("\n");
									cut = Chk.substring(0, pt);
								}
								if(!Chk.equalsIgnoreCase(cut))							
									Chk=cut;

								System.out.println(Chk);
								if(Chk.equalsIgnoreCase(d1[i][5]))
								{
									System.out.println("Search value displayed Successfully");
									acop = "Selected search value"+ Chk +" displayed Successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(d1[i][0], counter, sheet, acop);

								}
								else
								{
									System.out.println("Search value not displayed ");
									acop = "Selected search value"+ Chk +" not displayed Successfully";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(d1[i][0], counter, sheet, acop,scr);

								}
							}
							else
								System.out.println("Search Failed ... No data Found ");

							driver.findElement(By.xpath(Object.getProperty("ClearSearch"))).click();
							if(s.isAlertPresent(driver))
								driver.switchTo().alert().accept();

							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))

								Thread.sleep(1000);

							System.out.println("TC2 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC2 Execution, because the page is not loading properly");
						e.printStackTrace();}
					}



					if(d1[i][0].equalsIgnoreCase("TC3"))
					{
						try
						{
							String sDate =s.dateConvert(d1[i][6]);
							String eDate =s.dateConvert(d1[i][7]);
							System.out.println( "TC3 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();

							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							{	
								Thread.sleep(1000);
							}
							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							do
							{
								Thread.sleep(1000);
							}while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver));
							//driver.findElement(By.xpath(Object.getProperty("ColumnShowHide"))).click();
							do
							{
								Thread.sleep(1000);
							}while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver));

							if(driver.findElement(By.xpath(".//*[@id='div-100-columnSettings']/div/div/div[1]/div[1]/label/span")).isSelected())
							{
								System.out.println("All Columns selected");
								//driver.findElement(By.xpath(Object.getProperty("ShowHideColumnCancel"))).click();
								Thread.sleep(1000);
							}
							else
							{
								//driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();
								//driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
									Thread.sleep(1000);


							}
							driver.findElement(By.xpath(Object.getProperty("EditDateRange"))).click();
							if(s.isElementPresentcheck(By.xpath(Object.getProperty("StartDate")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("EndDate")),driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("SetDateRange")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("DateCancel")),driver))
							{

								if(sDate.equalsIgnoreCase("NA"))
								{
									acop = "Edit date range window should open.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
								}
								else
								{
									driver.findElement(By.xpath(Object.getProperty("StartDate"))).sendKeys(sDate);
									driver.findElement(By.xpath(Object.getProperty("EndDate"))).sendKeys(eDate);
									driver.findElement(By.xpath(Object.getProperty("SetDateRange"))).click();
									while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))								
										Thread.sleep(1000);

									String strMain = driver.findElement(By.xpath(Object.getProperty("DateRangeDisplay"))).getText();

									int chkIndex=0;
									String TotalPages =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();

									String Records="Null";
									if(TotalPages.contains(" of "))
									{
										chkIndex=TotalPages.indexOf(" of ");
										Records = TotalPages.substring(chkIndex+4);									
									}
									if(Records.equalsIgnoreCase("0"))
									{
										System.out.println("No data found for the event Search");
										acop = "No data";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
										rc++;
										excel.writePass(d1[i][0], counter, sheet, acop);									

									}
									else
									{
										while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
											Thread.sleep(1000);

										String EndDateGet = driver.findElement(By.xpath(Object.getProperty("StatusLstCntDate"))).getText();
										Thread.sleep(2000);
										driver.findElement(By.xpath(Object.getProperty("StatusLstCnt"))).click();
										while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
											Thread.sleep(1000);

										String StartDateGet = driver.findElement(By.xpath(Object.getProperty("StatusLstCntDate"))).getText();


										StartDateGet=s.cutString(StartDateGet, "\n");
										EndDateGet=s.cutString(EndDateGet, "\n");

										DateFormat df = new SimpleDateFormat("MM-dd-yy");
										Date date1=df.parse(StartDateGet);
										Date date2=df.parse(EndDateGet);
										SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
										String StartDate = sdf.format(date1);
										String EndDate = sdf.format(date2);

										if(s.dateCompare(sDate, eDate, StartDate)==1 && s.dateCompare(sDate, eDate, EndDate)==1 )
										{
											acop = "Date within range";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
											rc++;
											excel.writePass(d1[i][0], counter, sheet, acop);											
										}
										else
										{
											System.out.println("Search value not displayed ");
											acop = "Date not in range";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
											rc++;
											String scr = s.CaptureScreenshot();
											excel.writeFail(d1[i][0], counter, sheet, acop,scr);											
										}

									}
								}
							}
							else
							{
								System.out.println("Edit date range pop up not displayed");
								acop = "Edit date range window not yet opened.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);							
							}
							s.clearDateRange(driver, Object);
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							System.out.println("TC3 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC3 Execution, because the page is not loading properly");
						e.printStackTrace();}
					}


					if(d1[i][0].equalsIgnoreCase("TC4"))
					{
						try
						{
							boolean strFilterResult = false;
							System.out.println( "TC4 Execution started.....");
							//Thread.sleep(10000);
							WebDriverWait wait = new WebDriverWait(driver,20);
							WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Object.getProperty("FleetSelect"))));
							element.click();

							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();						
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ColumnShowHide"))).click();
							do
							{
								Thread.sleep(1000);
							}while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver));

							if(driver.findElement(By.xpath(".//*[@id='div-100-columnSettings']/div/div/div[1]/div[1]/label/span/span")).isSelected())
							{
								System.out.println("All Columns selected");
								driver.findElement(By.xpath(Object.getProperty("ShowHideColumnCancel"))).click();
								Thread.sleep(1000);
							}
							else
							{
								driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();
								driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
									Thread.sleep(1000);


							}

							//cancel button
							String totalRecords =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
							driver.findElement(By.xpath(Object.getProperty("StatusShowFilter"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(Object.getProperty("FilterLoadStatus")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("FilterDisparity")), driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("FilterAlerts")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("FilterReeferPower")), driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("FilterAlarm")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("StatusFilterApply")), driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("StatusFilterCancel")), driver))
							{

								driver.findElement(By.xpath(Object.getProperty("FilterLoadStatus"))).click();
								driver.findElement(By.xpath(Object.getProperty("LoadStatusLoaded"))).click();

								driver.findElement(By.xpath(Object.getProperty("StatusFilterCancel"))).click();
								String ChkRecords =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();

								if(totalRecords.equalsIgnoreCase(ChkRecords))
								{
									System.out.println("show filter cancel button working as expected");
									acop = "cancel button working as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(d1[i][0], counter, sheet, acop);

								}
								else
								{
									System.out.println("Show filter Cancel Button not working as expected");
									acop = "Cancel button not working as Expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(d1[i][0], counter, sheet, acop,scr);								
								}
							}
							else
							{
								acop = "Filter Popup window not Displayed Successfully";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);							
							}

							try
							{

							//Load status
							driver.findElement(By.xpath(Object.getProperty("StatusShowFilter"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(5000);


							strFilterResult = Cs.checkFilterValue(driver, Object, "100", "loadStatus", "20", false, "Text", "StatusFilterApply","StatusClearFilter");

							if(strFilterResult==true)
							{
								System.out.println("Load Status data filter is working as expected");
								acop = "Load Status data filter is working as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);							
							}
							else
							{
								System.out.println("Load Status data filter is not working as expected");
								acop = "Load Status data filter is not working as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);							
							}
							}catch(Exception e)
							{
								e.printStackTrace();
							}
							

							//Disparity filter section

							driver.findElement(By.xpath(Object.getProperty("StatusShowFilter"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
								Thread.sleep(1000);
							strFilterResult =Cs.disparity(driver, Object, "100", "disparityAlert", "51", false, "Anchor", "StatusFilterApply","StatusClearFilter");

							if(strFilterResult==true)
							{
								System.out.println("Disparity data filter is working as expected");
								acop = "Disparity data filter is working as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);							
							}

							else
							{
								System.out.println("Disparity data filter is not working as expected");
								acop = "Disparity data filter is not working as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);							
							} 


							//Alarm filter
							driver.findElement(By.xpath(Object.getProperty("StatusShowFilter"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							strFilterResult = Cs.alarm(driver, Object, "100", "activeAlarmStatus", "49", false, "Text", "StatusFilterApply","StatusClearFilter");

							if(strFilterResult==true)
							{
								System.out.println("Alarm filter is working as expected");
								acop = "Alarm filter is working as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);							
							}
							else
							{
								System.out.println("Alarm filter is not working as expected");
								acop = "Alarm filter is not working as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);							
							}





							System.out.println("TC4 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC4 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

					}

					if(d1[i][0].equalsIgnoreCase("TC5"))
					{
						try
						{
							System.out.println( "TC5 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();					
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
								Thread.sleep(1000);



							for(int l=1;l<=3;l++)
							{
								driver.findElement(By.xpath(Object.getProperty("ColumnShowHide"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))				
									Thread.sleep(1000);

								if(driver.findElement(By.xpath(".//*[@id='div-100-columnSettings']/div/div/div[1]/div[1]/label/span/input")).isSelected())				
									System.out.println("IS SELECTED WORKING FINE");


								else					
									driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();

								List<WebElement> columnsShow = driver.findElements(By.xpath(".//*[@id='divColumnHeaders']/div["+l+"]/div/ul"));

								List<ArrayList<String>> columnsData = new ArrayList<ArrayList<String>>();

								for(WebElement columnshow:columnsShow)
								{
									List<WebElement> columnElements = columnshow.findElements(By.xpath("li"));
									ArrayList<String> columnData = new ArrayList<String>();

									for(WebElement column:columnElements)
									{
										if(!column.getText().equalsIgnoreCase(" "))
										{
											String []temp = column.getText().split("\n");
											columnData.add(temp[0]);
										}
									}

									int columnSize =columnData.size();

									Thread.sleep(5000);
									driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
									while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))					
										Thread.sleep(1000);


									List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-100-datagrid']/div/table[1]/thead/tr[2]"));
									List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();

									for(WebElement row:rows)
									{
										List<WebElement> rowElements = row.findElements(By.xpath("th"));

										ArrayList<String> rowData = new ArrayList<String>();

										for(WebElement column1:rowElements)
										{
											if(!column1.getText().equalsIgnoreCase(" "))
												rowData.add(column1.getText().toString());
										}
										int rowSize = rowData.size();

										ListIterator<String> iterator = columnData.listIterator();

										while (iterator.hasNext())					
											iterator.set(iterator.next().toUpperCase());


										List< String > sames = new ArrayList<String>();
										List< String > diffs = new  ArrayList<String>();
										int count = 0;
										for( String key : columnData )
										{
											if(key.equalsIgnoreCase("TractorID"))					
												key="TRACTOR\nID";

											else if(key.equalsIgnoreCase("Work Order"))					
												key="WO\nWORK ORDER";

											else if(key.equalsIgnoreCase("Customer"))					
												key="CUST.\nCUSTOMER";

											else if(key.equalsIgnoreCase("LastContact"))					
												key = "LAST\nCONTACT";

											else if(key.equalsIgnoreCase("Moving/Stationary"))					
												key="M/S\nMOVING/STATIONARY";

											else if(key.equalsIgnoreCase("Mode ofOperation"))					
												key ="MODE OF\nOPERATION";

											else if(key.equalsIgnoreCase("PPSI"))					
												key ="PPSI\nPPSI";

											else if(key.equalsIgnoreCase("Fuel Flow Meter Count"))					
												key ="FFMC\nFUEL FLOW METER COUNT";

											else if(key.equalsIgnoreCase("Hours"))					
												key ="HRS\nHOURS";

											else if(key.equalsIgnoreCase("RPM"))					
												key = "RPM\nRPM";

											else if(key.equalsIgnoreCase("Communications Platform"))				
												key ="CP\nCOMMUNICATIONS PLATFORM";

											else if(key.equalsIgnoreCase("Message Mode"))					
												key ="MM\nMESSAGE MODE";

											else if(key.equalsIgnoreCase("Fuel Sensor Error"))				
												key ="FF!\nFUEL SENSOR ERROR";

											else if(key.equalsIgnoreCase("Disparity Alert"))				
												key ="D!\nDISPARITY ALERT";

											else if(key.equalsIgnoreCase("Impact Alert"))					
												key ="I!\nIMPACT ALERT";

											else if(key.equalsIgnoreCase("State Machine Alert"))				
												key ="SM!\nSTATE MACHINE ALERT";

											else if(key.equalsIgnoreCase("Carb Alert"))			
												key ="C!\nCARB ALERT";

											else if(key.equalsIgnoreCase("Panic Alert"))				
												key ="PANIC\nALERT";

											else if(key.equalsIgnoreCase("Ambient Temperature"))					
												key ="AMB.\nAMBIENT TEMPERATURE";

											else if(key.equalsIgnoreCase("Set point Temperature"))				
												key ="SETPT.\nSET POINT TEMPERATURE";

											else if(key.equalsIgnoreCase("Return Temperature"))				
												key ="RET.\nRETURN TEMPERATURE";

											else if(key.equalsIgnoreCase("Discharge Temperature"))					
												key ="DIS.\nDISCHARGE TEMPERATURE";

											else if(key.equalsIgnoreCase("CLM"))					
												key ="CLM\nCLM";

											else if(key.equalsIgnoreCase("AFAX"))					
												key ="AFAX\nAFAX";

											else if(key.equalsIgnoreCase("Fahrenheit Minutes"))				
												key ="FMINS\nFAHRENHEIT MINUTES";

											else if(key.equalsIgnoreCase("Coil Temperature"))					
												key ="COIL TEMP.\nCOIL TEMPERATURE";

											else if(key.equalsIgnoreCase("ETV Position"))				
												key ="ETV\nETV POSITION";

											else if(key.equalsIgnoreCase("Discharge Pressure"))				
												key ="DP\nDISCHARGE PRESSURE";

											else if(key.equalsIgnoreCase("Suction Pressure"))					
												key ="SP\nSUCTION PRESSURE";


											if( rowData.contains( key ) )
											{
												sames.add( key );
												System.out.println("Inside IF"+sames);

												System.out.println("All columns are same");
												acop = "All columns are same";
												node.log(LogStatus.PASS, acop);
												data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
												rc++;
												excel.writePass(d1[i][0], counter, sheet, acop);

											}
											else {
												diffs.add( key );
												System.out.println("Inside ELSE"+diffs);
												System.out.println("Difference in column values"+diffs);
												acop = "Difference in column values";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
												rc++;
												String scr = s.CaptureScreenshot();
												excel.writeFail(d1[i][0], counter, sheet, acop,scr);				

											}
										}

									}

								}

							}
							System.out.println("TC5 Execution Completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC5 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}



					if(d1[i][0].equalsIgnoreCase("TC6"))
					{
						try
						{
							System.out.println( "TC6 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();							
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ColumnShowHide"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(driver.findElement(By.xpath(".//*[@id='div-100-columnSettings']/div/div/div[1]/div[1]/label/span/input")).isSelected())
								driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();


							else
							{
								driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();
								Thread.sleep(1000);
								//driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();								
							}
							List<WebElement> columnsShow = driver.findElements(By.xpath(".//*[@id='divColumnHeaders']/div[1]/div/ul"));
							List<ArrayList<String>> columnsData = new ArrayList<ArrayList<String>>();
							String strMain = d1[i][5];
							String[] arrSplit4 = strMain.split(",");
							for(int x=0;x<arrSplit4.length;x++)
							{
								int flag=0;
								for(int y=1;y<=3;y++)
								{
									for(int z=1;true;z++)
									{
										if(s.isElementPresentcheck(By.xpath(".//*[@id='divColumnHeaders']/div["+y+"]/div/ul/li["+z+"]"), driver))
										{										
											String temp=driver.findElement(By.xpath(".//*[@id='divColumnHeaders']/div["+y+"]/div/ul/li["+z+"]")).getText();
											temp=s.cutString(temp, "\n");

											if(temp.equalsIgnoreCase(arrSplit4[x]))
											{
												flag=1;
												if(!driver.findElement(By.xpath(".//*[@id='divColumnHeaders']/div["+y+"]/div/ul/li["+z+"]/label/span[2]/span")).isSelected())
													driver.findElement(By.xpath(".//*[@id='divColumnHeaders']/div["+y+"]/div/ul/li["+z+"]/label/span[2]/span")).click();

												break;
											}
										}
										else
											break;

									}
									if(flag==1)
										break;
								}

							}
							driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
								Thread.sleep(1000);


							List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-100-datagrid']/div/table[1]/thead/tr[2]"));
							List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
							int cnt=3;
							for(WebElement row:rows)
							{
								List<WebElement> rowElements = row.findElements(By.xpath("th"));
								ArrayList<String> rowData = new ArrayList<String>();
								for(WebElement column:rowElements){
									System.out.println("Header :"+column.getText()+":");
									if(column.getText().equalsIgnoreCase(null) || column.getText().equalsIgnoreCase(" ") || column.getText().length()<1)
										System.out.println("Blank");

									else
										rowData.add(column.getText());

								}


								for(int rnum=0;rnum<arrSplit4.length;rnum++)
								{
									for(String string : rowData)
									{
										if(string.equalsIgnoreCase(arrSplit4[rnum]))
											cnt++;

									}

								}

								if(cnt==arrSplit4.length)
								{
									System.out.println("All selected Column is Present");
									acop = "Dashboard displayed as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(d1[i][0], counter, sheet, acop);
								}
								else
								{
									System.out.println("Dashboard displayed as expected");
									acop = "Dashboard displayed as expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(d1[i][0], counter, sheet, acop,scr);
								}
							}
							driver.findElement(By.xpath(Object.getProperty("ColumnShowHide"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
								Thread.sleep(1000);

							if(driver.findElement(By.xpath(".//*[@id='div-100-columnSettings']/div/div/div[1]/div[1]/label/span/input")).isSelected())
							{
								System.out.println("All Columns selected");
								driver.findElement(By.xpath(Object.getProperty("ShowHideColumnCancel"))).click();
								Thread.sleep(1000);
							}
							else
							{
								driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();
								driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
									Thread.sleep(1000);

							}
							System.out.println("TC6 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC6 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}



					if(d1[i][0].equalsIgnoreCase("TC7"))
					{
						try
						{
							ArrayList<String> rowData = new ArrayList<String>();
							ArrayList<String> rowData1 = new ArrayList<String>();

							System.out.println( "TC7 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();							
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);



							List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-100-datagrid']/div/table[1]/thead/tr[2]"));
							List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
							int cnt=3;
							for(WebElement row:rows)
							{
								List<WebElement> rowElements = row.findElements(By.xpath("th"));
								for(WebElement column:rowElements)
								{
									System.out.println("Header :"+column.getText()+":");
									if(column.getText().equalsIgnoreCase(null) || column.getText().equalsIgnoreCase(" ") || column.getText().length()<1)
										System.out.println("Blank");								

									else
										rowData.add(column.getText());

								}

							}
							driver.findElement(By.xpath(Object.getProperty("ColumnShowHide"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(driver.findElement(By.xpath(".//*[@id='div-100-columnSettings']/div/div/div[1]/div[1]/label/span/input")).isSelected())
								driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();

							else
							{
								driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();
								Thread.sleep(1000);
								//driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();
							}
							List<WebElement> columnsShow = driver.findElements(By.xpath(".//*[@id='divColumnHeaders']/div[1]/div/ul"));
							List<ArrayList<String>> columnsData = new ArrayList<ArrayList<String>>();
							String strMain = d1[i][5];
							String[] arrSplit4 = strMain.split(",");
							for(int x=0;x<arrSplit4.length;x++)
							{
								int flag=0;
								for(int y=1;y<=3;y++)
								{
									for(int z=1;true;z++)
									{
										if(s.isElementPresentcheck(By.xpath(".//*[@id='divColumnHeaders']/div["+y+"]/div/ul/li["+z+"]"), driver))
										{

											String temp=driver.findElement(By.xpath(".//*[@id='divColumnHeaders']/div["+y+"]/div/ul/li["+z+"]")).getText();
											temp=s.cutString(temp, "\n");

											if(temp.equalsIgnoreCase(arrSplit4[x]))
											{
												flag=1;
												if(!driver.findElement(By.xpath(".//*[@id='divColumnHeaders']/div["+y+"]/div/ul/li["+z+"]/label/span[2]/span")).isSelected())
													driver.findElement(By.xpath(".//*[@id='divColumnHeaders']/div["+y+"]/div/ul/li["+z+"]/label/span[2]/span")).click();

												break;
											}
										}
										else
											break;

									}
									if(flag==1)
										break;
								}

							}
							driver.findElement(By.xpath(Object.getProperty("ShowHideColumnCancel"))).click();
							List<WebElement> rows1 = driver.findElements(By.xpath(".//*[@id='div-100-datagrid']/div/table[1]/thead/tr[2]"));
							List<ArrayList<String>> rowsData1 = new ArrayList<ArrayList<String>>();
							int cnt1=3;
							for(WebElement row1:rows1)
							{
								List<WebElement> rowElements1 = row1.findElements(By.xpath("th"));
								for(WebElement column:rowElements1)
								{

									if(column.getText().equalsIgnoreCase(null) || column.getText().equalsIgnoreCase(" ") || column.getText().length()<1)
										System.out.println("Blank");

									else
										rowData1.add(column.getText());


								}

							}
							int flag=0;
							for(int k=0;k<rowData.size();k++)
							{
								if(rowData.get(k).equalsIgnoreCase(rowData.get(k)))
									System.out.println("Cancel working properly");

								else
									flag=1;


							}
							if(flag==1)
							{
								System.out.println("Show/Hide Cancel Button NOT Working as expected");
								acop = " Show/Hide Cancel Button NOT Working as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr  = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);

							}
							else
							{
								System.out.println("Show/Hide Cancel Button Working as expected");
								acop = "Show/Hide Cancel Button Working as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);	
							}
							driver.findElement(By.xpath(Object.getProperty("ColumnShowHide"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(driver.findElement(By.xpath(".//*[@id='div-100-columnSettings']/div/div/div[1]/div[1]/label/span/input")).isSelected())
								driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();

							else
							{
								driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();
								driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
									Thread.sleep(1000);
							}
							System.out.println("TC7 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC7 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}



					if(d1[i][0].equalsIgnoreCase("TC8"))
					{
						try
						{
							boolean Test =true;
							System.out.println( "TC8 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();							
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("SelectAssetTags"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(3000);

							if(s.isElementPresentcheck(By.xpath("/html/body/main/div[2]/div[1]/ul/li[2]/div[8]/div/div/ul/li[2]"), driver))
							{
								driver.findElement(By.xpath(Object.getProperty("AssetTag"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
									Thread.sleep(1000);

								if(s.isElementPresentcheck(By.xpath(Object.getProperty("DeleteTag")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("RemoveAsset")), driver)
										&& s.isElementPresentcheck(By.xpath(Object.getProperty("CloseTag")), driver))
								{								
									driver.findElement(By.xpath(Object.getProperty("DeleteTag"))).click();
									if(s.isAlertPresent(driver))								
										driver.switchTo().alert().accept();

									Thread.sleep(3000);
									while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))								
										Thread.sleep(1000);

									Thread.sleep(2000);
									String ErrorMsg1 ="AssetTag Removed Completely";
									String errorMsg1 = driver.findElement(By.xpath(Object.getProperty("ErrorMsg"))).getText();
									if(errorMsg1.equalsIgnoreCase(ErrorMsg1))
									{
										System.out.println("The delete Tag Completely Working As Expected");
									}
									else
									{
										System.out.println("The delete Tag not Working");
										Test = false;
									}
									driver.findElement(By.xpath(Object.getProperty("SelectAssetTags"))).click();
									while(s.isElementPresentcheck(By.xpath("/html/body/main/div[2]/div[1]/ul/li[2]/div[8]/div/div/ul/li[2]"), driver))								
										Thread.sleep(1000);

									driver.findElement(By.xpath(Object.getProperty("AssetTag"))).click();
									while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))								
										Thread.sleep(2000);

									if(s.isElementPresentcheck(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr"), driver))
									{	
										String Chk1=driver.findElement(By.xpath(Object.getProperty("SelectedReefer"))).getText();

										int pt=0;
										String cut="Null";
										if(Chk1.contains("\n"))
										{
											pt=Chk1.indexOf("\n");
											cut = Chk1.substring(0, pt);
										}
										driver.findElement(By.xpath(Object.getProperty("RemoveAsset"))).click();
										while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))								
											Thread.sleep(1000);

										Thread.sleep(2000);
										if(s.isElementPresentcheck(By.xpath(Object.getProperty("ErrorMsg")), driver))
										{
											String errorMsg2 = driver.findElement(By.xpath(Object.getProperty("ErrorMsg"))).getText();

											if(errorMsg2.contains(cut))
												System.out.println("Asset Remove Tag Working as Expected");

											else
											{
												System.out.println("Remove Tag Not Working");
												Test = false;
											}
										}
										driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(cut);
										driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
										while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
											Thread.sleep(1000);

										if(s.isElementPresentcheck(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr[1]/td[2]/a"), driver))
										{
											System.out.println("Asset Not Yet Removed Case FAILED");
											Test = false;
										}
										else
											System.out.println("Remove Tag Working Successfully");

										driver.findElement(By.xpath(Object.getProperty("ClearSearch"))).click();
										if(s.isAlertPresent(driver))										
											driver.switchTo().alert().accept();

										while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))										
											Thread.sleep(1000);

									}
									else
									{
										System.out.println("Remove Tag Not Working");
										Test = false;

									}
									if(s.isElementPresentcheck(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr"), driver))
									{	
										driver.findElement(By.xpath(Object.getProperty("SelectAssetTags"))).click();
										while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))										
											Thread.sleep(1000);

										driver.findElement(By.xpath(Object.getProperty("AssetTag"))).click();
										while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))										
											Thread.sleep(1000);

										driver.findElement(By.xpath(Object.getProperty("CloseTag"))).click();
										while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))										
											Thread.sleep(1000);

										if(!(s.isElementPresentcheck(By.xpath(Object.getProperty("DeleteTag")), driver)) && !(s.isElementPresentcheck(By.xpath(Object.getProperty("RemoveAsset")), driver))
												&& !(s.isElementPresentcheck(By.xpath(Object.getProperty("CloseTag")), driver)))
										{
											System.out.println("Close Tag Working as Expected");

										}
										else
										{
											System.out.println("Close Tag NOT Working as Expected");
											Test = false;

										}
									}
									else
									{
										System.out.println("Close Tag NOT Working as Expected");
										Test = false;

									}

									if(Test==true)
									{
										System.out.println("All Functions in Select Asset Tag working as Expected#");
										acop = "All Functions in Select Asset Tag working as Expected";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
										rc++;
										excel.writePass(d1[i][0], counter, sheet, acop);
									}
									else
									{
										System.out.println("Select Asset Tag NOT working as Expected");
										acop = " Select Asset Tag NOT working as Expected";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
										rc++;
										String scr = s.CaptureScreenshot();
										excel.writeFail(d1[i][0], counter, sheet, acop,scr);
									}
								}
							}else
							{
								System.out.println(" Asset tag is not available");
								acop = " Asset tag is not available";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
							}
							System.out.println("TC8 Execution completed.");				
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC8 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}




					if(d1[i][0].equalsIgnoreCase("TC9"))
					{
						try
						{
							System.out.println( "TC9 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();							
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);


							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
							if(s.isElementPresentcheck(By.xpath(Object.getProperty("ErrorMsg")), driver))
							{
								String errormsg =driver.findElement(By.xpath(Object.getProperty("ErrorMsg"))).getText();
								String errormsg1 ="Please select a Asset";
								if(errormsg.equalsIgnoreCase(errormsg1))
									System.out.println("Error Message Matching");

								else
									System.out.println("Error Msg Missmatch");

							}
							else
								System.out.println("Error message not found");

							driver.findElement(By.xpath(Object.getProperty("SelectAsset"))).click();
							driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
							boolean CheckActions = true;
							if(s.isElementPresentcheck(By.xpath(Object.getProperty("SetLeaseOn/Off")), driver) 
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("AsignCustomer")), driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("AdminCommand")), driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("SetMileage")), driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("ClearAlarms")), driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("OffSeason")), driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("ReadAllIntelliset")), driver) 
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("TimeoutCommands")), driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("DoorAlarmCommand")), driver) 
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("MicroRead")), driver))
							{
								System.out.println("All Elements are Present in MoreActions");
								WebElement moreActionsList = driver.findElement(By.xpath(".//*[@id='btn-moreaction-cmd']/div/ul"));
								List<WebElement> moreActions = moreActionsList.findElements(By.tagName("li"));
								ArrayList<String> Actions = new ArrayList<String>();
								for(WebElement row : moreActions)
								{
									if(!row.getText().equalsIgnoreCase(" "))
										Actions.add(row.getText().toString());
								}
								for(String string: Actions)
								{
									switch(string)
									{
									case "Set Lease On / Off":
									{
										driver.findElement(By.xpath(Object.getProperty("SetLease"))).click();
										Thread.sleep(5000);
										if(s.isElementPresentcheck(By.xpath(Object.getProperty("SetLeaseOn")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("SetLeaseOff")), driver)
												&& s.isElementPresentcheck(By.xpath(Object.getProperty("LeaseSendCommand")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("LeaseCancel")), driver))
											System.out.println("Set Lease Displayed as Expected");

										else
										{
											System.out.println("Set Lease NOT Displayed as Expected");
											CheckActions=false;
										}
										driver.findElement(By.xpath(Object.getProperty("LeaseCancel"))).click();
										Thread.sleep(5000);
										break;
									}
									case "Assign / De-Assign Customer":
									{
										driver.findElement(By.xpath(Object.getProperty("SelectAsset"))).click();
										driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
										driver.findElement(By.xpath(Object.getProperty("AsignCustomer"))).click();
										if(s.isElementPresentcheck(By.xpath(Object.getProperty("AssignCustomer")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("DeAssignCusntomer")), driver)
												&& s.isElementPresentcheck(By.xpath(Object.getProperty("AssignSendCommand")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("AssignCancel")), driver))										
											System.out.println("Assign/De-Assign Displayed as Expected");

										else
										{
											System.out.println("Assign/De-Assign NOT Displayed as Expected");
											CheckActions=false;
										}
										driver.findElement(By.xpath(Object.getProperty("AssignCancel"))).click();
										Thread.sleep(5000);
										break;
									}
									case "Admin Commands":
									{
										driver.findElement(By.xpath(Object.getProperty("SelectAsset"))).click();
										driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
										driver.findElement(By.xpath(Object.getProperty("AdminCommand"))).click();
										if(s.isElementPresentcheck(By.xpath(Object.getProperty("AdminUnitStart")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("AdminReportFreq")), driver)
												&& s.isElementPresentcheck(By.xpath(Object.getProperty("AdminMaintenanceFreq")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("AdminSendCommand")), driver)
												&& s.isElementPresentcheck(By.xpath(Object.getProperty("AdminCancel")), driver))										
											System.out.println("Admin Command Displayed as Expected");

										else
										{
											System.out.println("Admin Command NOT Displayed as Expected");
											CheckActions=false;
										}
										//driver.manage().window().maximize();
										driver.findElement(By.xpath(Object.getProperty("AdminCancel"))).click();
										Thread.sleep(5000);
										break;
									}
									case "Set Mileage":
									{
										driver.findElement(By.xpath(Object.getProperty("SelectAsset"))).click();
										Thread.sleep(5000);
										driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();									
										driver.findElement(By.xpath(Object.getProperty("SetMileage"))).click();
										if(s.isElementPresentcheck(By.xpath(Object.getProperty("Mileage")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("MileageReadDate")), driver)
												&& s.isElementPresentcheck(By.xpath(Object.getProperty("MileageCalendar")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("SetMileageCommand")), driver)
												&& s.isElementPresentcheck(By.xpath(Object.getProperty("MileageCancel")), driver))									
											System.out.println("Set Mileage Command Displayed as Expected");

										else
										{
											System.out.println("Set Mileage Command NOT Displayed as Expected");
											CheckActions=false;
										}
										driver.findElement(By.xpath(Object.getProperty("MileageCancel"))).click();
										Thread.sleep(5000);
										break;
									}
									case "Clear Alarms":
									{
										driver.findElement(By.xpath(Object.getProperty("SelectAsset"))).click();
										driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
										driver.findElement(By.xpath(Object.getProperty("ClearAlarms"))).click();
										if(s.isElementPresentcheck(By.xpath(Object.getProperty("ClearAlarm")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("AlarmSendCommand")), driver)
												&& s.isElementPresentcheck(By.xpath(Object.getProperty("AlarmCancel")), driver))
											System.out.println("Clear Alarms Command Displayed as Expected");

										else
										{
											System.out.println("Clear Alarms NOT Command Displayed as Expected");
											CheckActions=false;
										}
										driver.findElement(By.xpath(Object.getProperty("AlarmCancel"))).click();
										Thread.sleep(5000);
										break;
									}
									case "Off Season":
									{
										driver.findElement(By.xpath(Object.getProperty("SelectAsset"))).click();
										driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
										driver.findElement(By.xpath(Object.getProperty("OffSeason"))).click();
										if(s.isElementPresentcheck(By.xpath(Object.getProperty("ExitOffSeason")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("EnterOffSeason")), driver)
												&& s.isElementPresentcheck(By.xpath(Object.getProperty("OffSeasonSendCommand")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("OffSeasonCancel")), driver))									
											System.out.println("Off Season Command Displayed as Expected");

										else
										{
											System.out.println("Off Season Command NOT Displayed as Expected");
											CheckActions=false;
										}
										driver.findElement(By.xpath(Object.getProperty("OffSeasonCancel"))).click();
										Thread.sleep(5000);
										break;
									}
									case "Read All Intelliset":
									{
										driver.findElement(By.xpath(Object.getProperty("SelectAsset"))).click();
										driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
										driver.findElement(By.xpath(Object.getProperty("ReadAllIntelliset"))).click();
										if(s.isElementPresentcheck(By.xpath(Object.getProperty("ReadAllIntelliset1")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("IntellisetSendCommand")), driver)
												&& s.isElementPresentcheck(By.xpath(Object.getProperty("IntellisetCancel")), driver))									
											System.out.println("Read All Intelliset Command Displayed as Expected");

										else
										{
											System.out.println("Read All Intelliset Command NOT Displayed as Expected");
											CheckActions=false;
										}
										driver.findElement(By.xpath(Object.getProperty("IntellisetCancel"))).click();
										Thread.sleep(5000);
										break;
									}
									case "Time Out Commands":
									{
										driver.findElement(By.xpath(Object.getProperty("SelectAsset"))).click();
										driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
										driver.findElement(By.xpath(Object.getProperty("TimeoutCommands"))).click();
										if(s.isAlertPresent(driver))
										{
											driver.switchTo().alert().accept();
											while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))								
												Thread.sleep(1000);									
										}
										if(s.isElementPresentcheck(By.xpath(Object.getProperty("ErrorMsg")), driver))									
											System.out.println("Time out Command Displayed as Expected");

										else
										{
											System.out.println("Time out Command NOT Displayed as Expected");
											CheckActions=false;
										}
										Thread.sleep(5000);
										break;
									}
									case "Door Alarm":
									{
										driver.findElement(By.xpath(Object.getProperty("SelectAsset"))).click();
										driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
										driver.findElement(By.xpath(Object.getProperty("DoorAlarmCommand"))).click();
										if(s.isElementPresentcheck(By.xpath(Object.getProperty("DisableDoorAlarm")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("EnableDoorAlarm")), driver)
												&& s.isElementPresentcheck(By.xpath(Object.getProperty("DoorAlarmSendCommand")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("DoorAlarmCancel")), driver))									
											System.out.println("Door Alarm Command Displayed as Expected");

										else
										{
											System.out.println("Door Alarm Command Not Displayed as Expected");
											CheckActions=false;
										}
										driver.findElement(By.xpath(Object.getProperty("DoorAlarmCancel"))).click();
										Thread.sleep(5000);
										break;
									}
									case "Micro Read":
									{


										driver.findElement(By.xpath(".//*[@id='header__search__input']")).sendKeys(d1[i][5]);
										driver.findElement(By.xpath(Object.getProperty("Searchbutton"))).click();
										Thread.sleep(5000);
										driver.findElement(By.xpath(Object.getProperty("SelectAsset"))).click();
										driver.findElement(By.xpath(Object.getProperty("MoreActions"))).click();
										driver.findElement(By.xpath(Object.getProperty("MicroRead"))).click();
										if(s.isElementPresentcheck(By.xpath(Object.getProperty("ErrorMsg")), driver))									
											System.out.println("Micro Read Command Displayed as Expected");

										else
										{
											System.out.println("Micro Read Command NOT Displayed as Expected");
											CheckActions=false;
										}
										Thread.sleep(5000);
										break;
									}
									default:
										break;

									}

								}
								if(CheckActions == true)
								{
									System.out.println("More Actions Working as expected");
									acop = "More Actions Working as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(d1[i][0], counter, sheet, acop);									
								}
								else
								{
									System.out.println("More Actions NOT Working as expected");
									acop = "More Actions NOT Working as expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
								}
							}
							else
							{
								System.out.println("Element Missing in More Action");
								acop = "More Actions Elements are Missing";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}

							System.out.println("TC9 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC9 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}




					if(d1[i][0].equalsIgnoreCase("TC10"))
					{
						driver.navigate().refresh();
						Thread.sleep(2000);
						if(s.isAlertPresent(driver))
							driver.switchTo().alert().accept();					
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							Thread.sleep(1000);
						try
						{
							System.out.println( "TC10 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);

							Thread.sleep(5000);								
							driver.findElement(By.xpath(Object.getProperty("ColumnShowHide"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(5000);

							//driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();
							//driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();


							Thread.sleep(5000);
							if(driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).isSelected())
							{
								driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
									Thread.sleep(5000);
								Thread.sleep(5000);
							}

							else
							{
								driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();
								driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
									Thread.sleep(5000);
								Thread.sleep(5000);

							}					

							Thread.sleep(5000);
							List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-100-datagrid']/div/table[1]/thead/tr[2]"));
							List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
							System.out.println("No.of rows "+rows.size());

							for(WebElement row:rows)
							{
								List<WebElement> rowElements = row.findElements(By.xpath("th"));									
								ArrayList<String> rowData = new ArrayList<String>();

								for(WebElement column:rowElements)
								{
									if(!column.getText().equalsIgnoreCase(" "))
										//System.out.println("column value "+column);
										rowData.add(column.getText().toString());
									//System.out.println("rowData Values are"+rowData);
								}
								System.out.println("rowData values are"+rowData);
								System.out.println("rowData Size are"+rowData.size());
								String strMain = d1[i][5];
								String[] arrSplit4 = strMain.split(",");
								System.out.println(arrSplit4);
								int cnt = 0;

								int present = 0;
								int notPresent = 0;
								for(int rnum=0;rnum<arrSplit4.length;rnum++)
								{
									System.out.println(arrSplit4[rnum]);
									if (rowData.contains(arrSplit4[rnum]))
									{
										System.out.println("This Column is present"+arrSplit4[rnum]);
										cnt++;

									}	

									else
									{
										System.out.println("This Column is not present"+arrSplit4[rnum]);
										notPresent++;

									}

								}
								System.out.println("count value"+cnt);

								if(notPresent == 0 )
								{
									System.out.println("All Column is Present");
									acop = "Dashboard displayed as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(d1[i][0], counter, sheet, acop);									
								}
								else
								{
									System.out.println("Column Not Present");
									acop = "Dashboard NOT displayed as expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
								}

							}


							System.out.println( "TC10 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC10 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}




					if(d1[i][0].equalsIgnoreCase("TC11"))
					{
						try
						{
							System.out.println( "TC11 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();

							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
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
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("ExcelDownloadAll")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("StatusShowFilter")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("SelectAssetTags")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ColumnShowHide")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)) || (!s.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("StatusDashboard")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ViewMap")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("pollCommands")), driver)) || !(s.isElementPresentcheck(By.xpath(Object.getProperty("ControlCommands")), driver)) ||
									!(s.isElementPresentcheck(By.xpath(Object.getProperty("MoreActions")), driver)))
							{
								System.out.println("Page not Re-loaded Successfully");
								acop = "Reefers Status Page Re-Loading Failed";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}

							else
							{
								System.out.println("Page Re-loaded Successfully");
								acop = "Reefers Status Page Re-Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}

							System.out.println( "TC11 Execution Completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC11 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}




					if (d1[i][0].equalsIgnoreCase("TC12"))
					{
						try
						{
							System.out.println( "TC12 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);


							driver.findElement(By.xpath(".//*[@id='table-col-100--all-none']/label/span[2]/span")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);


							String parentHandle = driver.getWindowHandle(); // get the current window handle									            
							driver.findElement(By.xpath(Object.getProperty("ViewMap"))).click();
							Thread.sleep(4000);//Clicking on this window

							for (String winHandle : driver.getWindowHandles())									
								driver.switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)


							int count=0;
							while(!s.isElementPresentcheck(By.xpath(".//*[@id='map']/div/div[1]/div[4]/div[4]/div/h2"), driver))
							{
								count++;
								Thread.sleep(2000);
								if(count>=10)									
									break;

							}

							if(s.isElementPresentcheck(By.xpath(Object.getProperty("MapVerification")),driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("PrintMap")),driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("ShowAll")),driver))
							{
								System.out.println("All the filds are present in the Map view");
								acop = "Status Map View Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
							}
							else
							{
								System.out.println("Mismatch Found");
								acop = "Status Map View not Loaded Successfully";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);
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
							if(s.isElementPresentcheck(By.xpath(Object.getProperty("MapVerification")),driver))
							{
								System.out.println("Show All is working as expected");
								acop = "Status Map View all the asset maps Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
							}
							else
							{
								System.out.println("Show All is not working");
								acop = "Status Show All is not working";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);
							}
							driver.findElement(By.xpath(".//*[@id='map']/div/div/div[10]/div[2]/div[1]")).click();
							Thread.sleep(5000);
							driver.findElement(By.xpath(".//*[@id='map']/div/div/div[10]/div[3]/div")).click();
							Thread.sleep(5000);


							driver.switchTo().window(parentHandle);
							System.out.println( "TC12 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC12 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}



					if(d1[i][0].equalsIgnoreCase("TC13"))
					{
						try
						{
							System.out.println( "TC13 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();								
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))								
								Thread.sleep(1000);

							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("PrintIcon"))).click();
							Thread.sleep(5000);
							ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
							driver.switchTo().window(tabs2.get(1));									

							if(s.isElementPresentcheck(By.xpath("html/body/table"), driver))
							{
								System.out.println("Print page displayed");
								acop = "Print page displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}

							else
							{
								System.out.println("Print page not displayed");
								acop = "Print Page not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}

							robot.keyPress(KeyEvent.VK_ESCAPE);
							Thread.sleep(200);
							robot.keyRelease(KeyEvent.VK_ESCAPE);
							driver.close();
							driver.switchTo().window(tabs2.get(0));
							System.out.println("TC13 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC13 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}




					if(d1[i][0].equalsIgnoreCase("TC14"))
					{
						try
						{
							System.out.println( "TC14 Execution started.....");
							ArrayList<String> tr=new ArrayList<String>();
							int pageSize=0,recordsCount=0;									

							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("ExcelDownload"))).click();
							Thread.sleep(5000);
							WebElement ele = driver.findElement(By.xpath(".//*[@id='div-100-datagrid-tbody']"));									
							List<WebElement>page=ele.findElements(By.tagName("tr"));

							pageSize=page.size();
							try
							{
								BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\ReeferReport.xls"));
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

							}
							catch (Exception e)
							{e.printStackTrace();}									

							if(recordsCount == pageSize)
							{
								System.out.println("Reefers Status Downloadof this page is downloaded successfull");									
								acop = "Reefers Status Downloadof this page is downloaded successfull";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}
							else
							{
								System.out.println("Count mismatch");
								acop = "Count mismatch";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}

							System.out.println("TC14 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC14 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}



					if(d1[i][0].equalsIgnoreCase("TC15"))
					{
						try
						{
							System.out.println( "TC15 Execution started.....");
							ArrayList<String> tr=new ArrayList<String>();
							int pageSize=0,recordsCount=0;
							int chkIndex=0;
							String Records="Null";								

							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);

							String TotalPages =driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
							if(TotalPages.contains(" of "))
							{
								chkIndex=TotalPages.indexOf(" of ");
								Records = TotalPages.substring(chkIndex+4);									
							}

							int Record = Integer.parseInt(Records);
							driver.findElement(By.xpath(Object.getProperty("ExcelDownloadAll"))).click();
							Thread.sleep(12000);

							CSVReader reader = new CSVReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\StatusReport-All.csv"));
							// this will load content into list
							List<String[]> li=reader.readAll();
							System.out.println("Total rows which we have is "+li.size());
							recordsCount = li.size()-1;

							if(recordsCount == Record)
							{
								System.out.println("Reefers Status Download-All downloaded successfully");									
								acop = "Reefers Status Download-All downloaded successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}
							else
							{
								System.out.println("Count mismatch");
								acop = "Count mismatch";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}
							System.out.println("TC15 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC15 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}


					if(d1[i][0].equalsIgnoreCase("TC16"))
					{
						try
						{
							System.out.println( "TC16 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);

							if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers") ,Object.getProperty("Status"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
							{
								System.out.println("Time zone Displayed Successfully");
								acop = "Time zone displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}
							else
							{
								System.out.println("Time zone not Displayed ");
								acop = "Time zone not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}
							System.out.println("TC16 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC16 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}


					if(d1[i][0].equalsIgnoreCase("TC17"))
					{
						try
						{
							System.out.println( "TC17 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();

							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("Status"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
							{
								System.out.println("Temperature Unit Displayed Successfully");
								acop = "Temperature Unit displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}

							else
							{
								System.out.println("Temperature Unit not Displayed ");
								acop = "Temperature Unit not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}

							System.out.println("TC17 Execution Completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC17 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}


					if(d1[i][0].equalsIgnoreCase("TC18"))
					{
						try
						{
							System.out.println( "TC18 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))

								Thread.sleep(1000);

							if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("Status"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
							{
								System.out.println("Fuel Level Displayed Successfully");
								acop = "Fuel Level displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}
							else
							{
								System.out.println("Fuel Level not Displayed ");
								acop = "Fuel Level not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}
							System.out.println("TC18 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC18 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}


					if(d1[i][0].equalsIgnoreCase("TC19"))
					{
						try
						{
							System.out.println( "TC19 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();

							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);

							if(s.unitofMeasure(driver, Object, Object.getProperty("Reefers"), Object.getProperty("Status"), Object.getProperty("DistanceCalcIcon"), Object.getProperty("DistanceTooltip"), Object.getProperty("DistanceTooltipval"), Object.getProperty("DistanceUnit")))
							{
								System.out.println("Distance Unit Displayed Successfully");
								acop = "Distance Unit displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}
							else
							{
								System.out.println("Distance Unit not Displayed ");
								acop = "Distance Unit not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}
							System.out.println("TC19 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC19 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}


					if(d1[i][0].equalsIgnoreCase("TC20"))
					{
						try
						{
							System.out.println( "TC20 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(3000);

							if((s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)))
							{

								System.out.println("Control Probe loaded Successfully");
								acop = "Control Probe displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}
							else
							{
								System.out.println("Control Probe not loaded Successfully");
								acop = "Control Probe not displayed as expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}
							System.out.println("TC20 Execution Completed.");
						}catch(Exception e)
						{e.printStackTrace();}
					}

					if(d1[i][0].equalsIgnoreCase("TC21"))
					{
						try
						{
							System.out.println( "TC21 Execution Started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();	
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferTrak"))).click();
							if(s.isElementPresentcheck(By.xpath(Object.getProperty("Settings")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("Logout")), driver))
							{
								driver.findElement(By.xpath(Object.getProperty("Settings"))).click();
								if(s.isElementPresentcheck(By.xpath(Object.getProperty("Displaysettings")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("UserSettings")), driver)
										&& s.isElementPresentcheck(By.xpath(Object.getProperty("Notificationsettings")), driver))
								{
									driver.findElement(By.xpath(Object.getProperty("ReeferTrak"))).click();
									driver.findElement(By.xpath(Object.getProperty("Logout"))).click();
									if(s.isAlertPresent(driver))									
										driver.switchTo().alert().accept();

									while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
										Thread.sleep(1000);

									Thread.sleep(2000);
									String url = driver.getCurrentUrl();
									String URL ="http://192.168.1.218:1100/AJAX/TMS_RT_WEB/index.jsp?strMsg=1";
									if(url.equalsIgnoreCase(URL))
									{
										System.out.println("Logout Successful");
										acop = "Loggedout Successfully";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
										rc++;
										excel.writePass(d1[i][0], counter, sheet, acop);									
									}
									else
									{
										System.out.println("Logout Failed");
										acop = "Logout Failed";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
										rc++;
										String scr = s.CaptureScreenshot();
										excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
									}

								}
								else
								{
									System.out.println("Settings Page not Displayed");
									acop = "Settings Page not Displayed as Expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
								}
							}
							else
							{
								System.out.println("ReeferTrak Submenu Not Present");
								acop = "ReeferTrak Submenu Not Present";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}
							Thread.sleep(2000);
							s.dologin(driver, d1[0][2], d1[0][3]);
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							System.out.println("TC21 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC21 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

					}

					if(d1[i][0].equalsIgnoreCase("TC22"))
					{
						try
						{
							System.out.println( "TC22 Execution started.....");
							Thread.sleep(8000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();								
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);						


							boolean strFilterResult = false;
							strFilterResult = Cs.checkSortedValue(driver, Object, "100");

							if (strFilterResult == true)
							{
								System.out.println("Column Sorted Successfully");
								acop = "Column Sorted Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}
							else
							{
								System.out.println("Column Sorting Failed");
								acop = "Column Sorting Failed";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);								
							}

							System.out.println("TC22 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC22 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

					}

					if(d1[i][0].equalsIgnoreCase("TC23"))
					{
						try
						{
							System.out.println( "TC23 Execution started.....");
							Thread.sleep(8000);
							//driver.manage().window().maximize();
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("TermsofUse"))).click();	
							Thread.sleep(2000);
							ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());


							driver.switchTo().window(tabs2.get(1));
							Thread.sleep(2000);
							String url = driver.getCurrentUrl();								

							Thread.sleep(5000);
							int count=0;
							while(!s.isElementPresentcheck(By.xpath("html/body/div[2]/div[2]/div/div/h1"), driver))
							{
								count++;
								Thread.sleep(2000);
								if(count>=10)									
									break;									
							}	



							System.out.println(url);
							String URL ="https://www.orbcomm.com/en/terms-and-conditions";

							if(url.equalsIgnoreCase(URL))
							{
								System.out.println("Terms and Condition Page displayed Successfully");
								acop = "Terms and Condition Page displayed Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}
							else
							{
								System.out.println("Terms and Condition Page Not displayed ");
								acop = "Terms and Condition Page Not displayed as Expected";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}					
							driver.close();
							Thread.sleep(2000);	
							driver.switchTo().window(tabs2.get(0));


							System.out.println("TC23 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC23 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

					}

					if(d1[i][0].equalsIgnoreCase("TC24"))
					{
						try
						{
							System.out.println( "TC24 Execution started.....");
							Thread.sleep(8000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Privacypolicy"))).click();
							Thread.sleep(2000);
							ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());														

							driver.switchTo().window(tabs2.get(1));
							Thread.sleep(2000);
							String url = driver.getCurrentUrl();
							Thread.sleep(5000);

							int count=0;
							while(!s.isElementPresentcheck(By.xpath("html/body/div[2]/div[3]/div"), driver))
							{
								count++;
								Thread.sleep(2000);
								if(count>=10)
								{
									break;
								}
							}


							System.out.println(url);
							String URL ="https://www.orbcomm.com/en/privacy-policy";
							if(url.equalsIgnoreCase(URL))
							{
								System.out.println("Privacy policy Page displayed Successfully");
								acop = "Privacy policy Page displayed Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}
							else
							{
								System.out.println("Privacy policy Page Not displayed ");
								acop = "Privacy policy Page Not displayed as Expected";
								String scr = s.CaptureScreenshot();
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);								
							}								
							driver.close();
							driver.switchTo().window(tabs2.get(0));
							System.out.println("TC24 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC24 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

					}

					if(d1[i][0].equalsIgnoreCase("TC25"))
					{
						try
						{
							System.out.println( "TC25 Execution Started.....");
							Thread.sleep(8000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();

							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))								
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);

							WebElement Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));									
							List<WebElement> PageList = Pagination.findElements(By.tagName("li"));
							System.out.println("Size of the page"+PageList.size());

							for(int j=0;j<PageList.size();j++)

								System.out.println(PageList.get(j).getText());


							if(PageList.get(0).getText().equalsIgnoreCase("Prev") && PageList.get(PageList.size()-2).getText().equalsIgnoreCase("Next") && PageList.get(PageList.size()-1).getText().contains("Go To Page"))
							{													

								if(d1[i][5].isEmpty())
								{
									acop = "Pagination Displayed as expected";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(d1[i][0], counter, sheet, acop);									
								}
								else
								{
									driver.findElement(By.xpath(Object.getProperty("PageDrpdown"))).click();
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("PageValue"))).sendKeys(d1[i][5]);
									driver.findElement(By.xpath(Object.getProperty("PageSelect"))).click();
									while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
										Thread.sleep(1000);

									Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder']/ul"));
									PageList = Pagination.findElements(By.tagName("li"));

									for(int j=0;j<PageList.size();j++)
									{

										if(PageList.get(j).getText().equalsIgnoreCase(d1[i][5]))
										{
											if(PageList.get(j).getAttribute("class").equalsIgnoreCase("active"))
											{
												acop = "Selected Page Displayed as expected";
												node.log(LogStatus.PASS, acop);
												data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
												rc++;
												excel.writePass(d1[i][0], counter, sheet, acop);									
												break;
											}
											else
											{
												System.out.println("Current Page doesnot match the Page which is selected ");
												acop = "Pagination not displayed as expected";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
												rc++;
												String scr = s.CaptureScreenshot();
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
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}
							System.out.println("TC25 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC25 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}

					if(d1[i][0].equalsIgnoreCase("TC26"))
					{
						try
						{
							System.out.println( "TC26 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();

							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							Select se = new Select(driver.findElement(By.id("per-page__select")));
							List<WebElement> l = se.getOptions();
							l.size();

							driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
							Thread.sleep(1000);
							String[] dropVal = new String[l.size()+1];

							for(int click=1;click<=l.size();click++)
							{
								String dropDownVal = driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li["+click+"]")).getText();
								dropVal[click] = dropDownVal;									
							}

							if (dropVal[1].equalsIgnoreCase("10 per page") && dropVal[2].equalsIgnoreCase("20 per page") && dropVal[3].equalsIgnoreCase("50 per page") &&
									dropVal[4].equalsIgnoreCase("100 per page") && dropVal[5].equalsIgnoreCase("200 per page") && dropVal[6].equalsIgnoreCase("300 per page"))
								System.out.println("All the fields are present successfully.");

							for(int sel=1;sel<=l.size()-1;sel++)
							{									
								String [] pageCnt = dropVal[sel].split(" ");

								Thread.sleep(10000);
								driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
								driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
								driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
								driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();

								driver.findElement(By.xpath(".//*[@id='per_page__select_chosen']/div/ul/li["+sel+"]")).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
									Thread.sleep(1000);

								WebElement ele = driver.findElement(By.xpath(".//*[@id='div-100-datagrid-tbody']"));

								List<WebElement>page=ele.findElements(By.tagName("tr"));									
								if (pageCnt[0].equals(""+page.size()))
								{
									System.out.println(page.size()+" Per page loaded successfully");									
									acop = page.size()+" Per Page Loaded successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
									rc++;
									excel.writePass(d1[i][0], counter, sheet, acop);									
								}
								else
								{
									System.out.println(page.size()+" Per page not loaded");
									acop = page.size()+" Per Page not Loaded successfully";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
									rc++;
									String scr = s.CaptureScreenshot();
									excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
								}

								driver.findElement(By.xpath(Object.getProperty("Recordperpage"))).click();
								driver.findElement(By.xpath(Object.getProperty("10PerPage"))).click();
							}
							System.out.println("TC26 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC26 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}

					if(d1[i][0].equalsIgnoreCase("TC27"))
					{
						try
						{
							System.out.println( "TC27 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);


							driver.findElement(By.xpath(".//*[@id='table-col-100--all-none']/label/span[2]/span")).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							List <WebElement> selectElements= driver.findElements(By.cssSelector(".cls-checked"));									
							int rowCount = 0;
							Map<String,String> arr = new TreeMap<>();

							for(int ij=0;ij<selectElements.size();ij++)
							{								
								if( (selectElements.get(ij).isSelected())&&!(selectElements.get(ij).getAttribute("id").equalsIgnoreCase(""))&&!(selectElements.get(ij).getAttribute("id").startsWith("select-All-Column")))
								{									
									rowCount = rowCount + 1;									
									arr.put(selectElements.get(ij).getAttribute("id"), selectElements.get(ij).getAttribute("id"));
								}
								else
									System.out.println("Check box NOT selected");


							}

							String chkVal = driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
							String [] getVal = chkVal.split(" - ");								
							String [] finalVal = getVal[1].split(" of ");

							if (finalVal[0].equals(""+arr.size()))
							{
								System.out.println("Select All is working as expected");
								acop = " All None is working";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);								
							}
							else
							{
								System.out.println("All none is not working");
								acop = "All none is not working as expected ";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}

							System.out.println("TC27 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC27 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}


					if(d1[i][0].equalsIgnoreCase("TC28"))
					{
						try
						{
							System.out.println( "TC28 Execution Started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);


							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(d1[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);

							if(s.isElementPresentcheck(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr/td[2]/a"), driver))									
								driver.findElement(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr/td[2]/a")).click();

							else									
								System.out.println("Search Failed ... No data Found ");

							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);


							String pageNo = driver.findElement(By.xpath(Object.getProperty("GetNoOfPages"))).getText();
							int pointToCut=0;
							String totalRecord="Null";
							if(pageNo.contains(" of "))
							{
								pointToCut=pageNo.indexOf(" of ");
								totalRecord = pageNo.substring(pointToCut+4);									
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
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);

								Thread.sleep(8000);
								driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
								driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
								driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
									Thread.sleep(1000);									
							}
							else
							{
								System.out.println("Asset History displayed successfully");
								acop = "Asset History displayed as expected";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);									
							}

							driver.findElement(By.xpath(Object.getProperty("Reefers"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ClearSearch"))).click();

							if(s.isAlertPresent(driver))									
								driver.switchTo().alert().accept();


							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))								
								Thread.sleep(1000);
							System.out.println("TC28 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC28 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}	

					}

					if(d1[i][0].equalsIgnoreCase("TC29"))
					{
						try
						{
							System.out.println( "TC29 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(5000);

							driver.findElement(By.xpath(Object.getProperty("ColumnShowHide"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(5000);

							if(driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).isSelected())
							{
								driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
									Thread.sleep(5000);
								Thread.sleep(5000);
							}

							else
							{
								driver.findElement(By.xpath(Object.getProperty("selectallcolumn1"))).click();
								driver.findElement(By.xpath(Object.getProperty("ShowHideColumnApply"))).click();
								while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
									Thread.sleep(5000);
								Thread.sleep(5000);

							}


							Thread.sleep(15000);	
							String parentHandle = driver.getWindowHandle(); // get the current window handle

							String valChk = driver.findElement(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr[1]/td[12]/a")).getText();
							String mysz2 = valChk.replaceAll(",\\s",",");
							Thread.sleep(2000);
							System.out.println(mysz2);
							driver.findElement(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr[1]/td[12]/a")).click();
							Thread.sleep(10000);
							for (String winHandle : driver.getWindowHandles())									
								System.out.println(winHandle);									
							Thread.sleep(4000);
							for (String winHandle : driver.getWindowHandles())	
							{
								driver.switchTo().window(winHandle); 
								System.out.println(winHandle);
							}
							int count=0;
							while(s.isElementPresentcheck(By.xpath(".//*[@id='map']/div/div/div[1]/div[4]/div[4]/div[2]/h2"), driver))
							{
								count++;
								Thread.sleep(2000);
								if(count>=10)									
									break;

							}

							String pageNav="";
							if(count<10)
							{
								WebElement htmltable=driver.findElement(By.cssSelector(".map__window>ul"));
								List<WebElement> rows=htmltable.findElements(By.tagName("li"));									
								pageNav = driver.findElement(By.cssSelector(".-location")).getText();
								System.out.println(pageNav);
								System.out.println(mysz2);
							}
							if (pageNav.contains(mysz2))
							{
								System.out.println("Location Loaded Successfully");
								acop = "Location Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
							}

							else
							{
								System.out.println("Location not loaded");
								acop = "Location not loaded";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);									
							}

							driver.close();
							driver.switchTo().window(parentHandle);
							System.out.println("TC29 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC29 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}

					if(d1[i][0].equalsIgnoreCase("TC30"))
					{
						try
						{
							System.out.println( "TC30 Execution started.....");
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Status"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("ReeferSearch"))).sendKeys(d1[i][5]);
							driver.findElement(By.xpath(Object.getProperty("SearchButton"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							String Fleet = driver.findElement(By.xpath(Object.getProperty("StatusFleet"))).getText();
							driver.findElement(By.xpath(Object.getProperty("StatusSnapshot"))).click();
							while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
								Thread.sleep(1000);

							Thread.sleep(5000);


							if(s.isElementPresentcheck(By.xpath(Object.getProperty("StatusReport")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("MaintenanceStatusReport")), driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("PreTripReport")), driver) && s.isElementPresentcheck(By.xpath(Object.getProperty("AlarmReport")), driver)
									&& s.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationReport")), driver))
							{
								System.out.println("All Reports are Present");
								acop = "All Reports are Present";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", s.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);

							}
							else
							{
								System.out.println(" Reports not Present");
								acop = "Reports not Present";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", s.timestamp(stime)});
								rc++;
								String scr = s.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);

							}

							System.out.println("TC30 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC30 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

					}




				}
			}

		}catch(Exception ex)
		{ex.printStackTrace();}
		finally
		{
			System.out.println("---------------------------------------------------------");

			reports.endTest(node);
			reports.flush();
			driver.close();
			return data;

		}

	}

}


