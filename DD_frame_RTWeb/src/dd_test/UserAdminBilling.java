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


public class UserAdminBilling extends TestCore 
{
	static TestUtil t =new TestUtil();
	static LogisticUtils l =new LogisticUtils();

	@Test
	public static Map<String, Object[]>billingtestcases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase) 
	{
		ExtentTest node = reports.startTest("UserAdminBilling");
		String[][] d1 =TestUtil.getData("UserAdminBilling");

		String acop =null;
		int counter =1;

		try 
		{
			driver = new FirefoxDriver(t.excelDownload());
			driver.get(Object.getProperty("URL"));
			if(t.dologin(driver ,d1[0][2], d1[0][3]))
			{			
				System.out.println("User Admin Billing Module");
				for(int i=scase-1;i<ecase;i++ )
				{
					String qa1 = d1[i][5];
					System.out.println(d1[i][5]);
					long stime=System.currentTimeMillis();

					if (d1[i][0].equalsIgnoreCase("TC1"))
					{
						try
						{
							System.out.println("TC1 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();							
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("Billing"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
								Thread.sleep(1000);


							if(!(t.isElementPresentcheck(By.xpath(Object.getProperty("UploadOcp")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("IntroduceUnit")), driver)) || 
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("GetGSMData")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("GetSATData")), driver)) ||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("GetUnitData")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("ScrapUnit")), driver)) ||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("PowerONStatusReport")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("GeofenceData")), driver)) ||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("ProductSelect")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("ProductSearch")), driver)) ||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("BillingAdd")), driver)) || (!t.isElementPresentcheck(By.xpath(Object.getProperty("BiilingModify")), driver)) ||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("BillingProductDashboard")), driver)))
							{
								System.out.println("Page not loaded Successfully");
								acop = "UserAdminBilling Page not Loaded Successfully";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);								
							}
							else
							{
								System.out.println("Page loaded Successfully");
								acop = "UserAdminBilling Page Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
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
							System.out.println( "TC2 Execution started.....");
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("Billing"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);


							WebElement ele = driver.findElement(By.xpath(Object.getProperty("ProductSelect")));
							System.out.println(ele.getTagName());
							List<WebElement>page=ele.findElements(By.tagName("option"));
							System.out.println("<<<<<<<<<<<<<"+page.size());

							// This is for grid
							String search = d1[i][5];
							String[] valSearch = search.split(",");
							System.out.println(valSearch);
							String gridVal = d1[i][6];
							String[] vals = gridVal.split(",");
							System.out.println(vals);

							for (int k=1; k<=page.size();k++)
							{

								driver.findElement(By.xpath(Object.getProperty("ProductSearch"))).sendKeys(valSearch[k-1]);
								Thread.sleep(1000);
								driver.findElement(By.xpath(Object.getProperty("BilingSearchButton"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
									Thread.sleep(1000);
								System.out.println("inside first for loop");
								//System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCFIRST"+vals[k]);
								//System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"+vals[k-1]);
								driver.findElement(By.xpath("//*[@id='header__billing_selector__select_chosen']/a/span")).click();
								Thread.sleep(1000);
								String SelVal = driver.findElement(By.xpath(".//*[@id='header__billing_selector__select_chosen']/div/ul/li["+k+"]")).getText();
								System.out.println(">>>>>>>>>>>>>"+SelVal);

								driver.findElement(By.xpath(".//*[@id='header__billing_selector__select_chosen']/div/ul/li["+k+"]")).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
									Thread.sleep(1000);

								if(t.isElementPresentcheck(By.xpath(".//*[@id='div-"+vals[k-1]+"-datagrid-tbody']/tr[1]/td[2]"), driver))
								{

									String Chk=driver.findElement(By.xpath(".//*[@id='div-"+vals[k-1]+"-datagrid-tbody']/tr[1]/td[2]")).getText();
									System.out.println(Chk);
									System.out.println(Chk.length());

									if(Chk.equalsIgnoreCase(valSearch[k-1]))
									{
										System.out.println("Search value displayed Successfully");
										acop = "Selected search value"+ Chk +" displayed Successfully";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
										rc++;
										excel.writePass(d1[i][0], counter, sheet, acop);	
										driver.findElement(By.xpath(Object.getProperty("BillingClearSearch"))).click();
										if(t.isAlertPresent(driver))
										{
											driver.switchTo().alert().accept();
										}		
										while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
									}

									else
									{
										System.out.println("Search value not displayed ");
										acop = "Selected search value"+ Chk +" not displayed Successfully";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d1[i][0] ,"UserAdminBilling", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										excel.writeFail(d1[i][0], counter, sheet, acop,scr);	
										driver.findElement(By.xpath(Object.getProperty("BillingClearSearch"))).click();
										if(t.isAlertPresent(driver))
										{
											driver.switchTo().alert().accept();
										}		
										while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
									}
								}

								else
								{
									System.out.println("Search Failed ... No data Found ");
									driver.findElement(By.xpath(Object.getProperty("BillingClearSearch"))).click();
									if(t.isAlertPresent(driver))
									{
										driver.switchTo().alert().accept();
									}		
									while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
								}
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
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("Billing"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);


							WebElement ele = driver.findElement(By.xpath(".//*[@id='header__billing-selector__select']"));
							System.out.println(ele.getTagName());
							List<WebElement>page=ele.findElements(By.tagName("option"));
							System.out.println("<<<<<<<<<<<<<"+page.size());
							//This is for column value
							String strMain = d1[i][5];
							String[] arrSplit4 = strMain.split("#");
							System.out.println(arrSplit4);
							// This is for grid
							String gridVal = d1[i][6];
							String[] vals = gridVal.split(",");
							System.out.println(vals);

							for (int k=1; k<=page.size();k++)
							{
								System.out.println("column vanue is "+arrSplit4[k-1]);
								System.out.println("Grid vanue is "+vals[k-1]);
								driver.findElement(By.xpath(Object.getProperty("ProductSelect"))).click();
								Thread.sleep(1000);
								String SelVal = driver.findElement(By.xpath(".//*[@id='header__billing_selector__select_chosen']/div/ul/li["+k+"]")).getText();
								System.out.println(">>>>>>>>>>>>>"+SelVal);
								driver.findElement(By.xpath(".//*[@id='header__billing_selector__select_chosen']/div/ul/li["+k+"]")).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
									Thread.sleep(1000);
								if(t.isElementPresentcheck(By.xpath(".//*[@id='div-"+vals[k-1]+"-datagrid']"), driver))
								{
									System.out.println(".//*[@id='div-"+vals[k-1]+"-datagrid']/div/table[1]/thead/tr[2]");
									String Chk=driver.findElement(By.xpath(".//*[@id='div-"+vals[k-1]+"-datagrid']/div/table[1]/thead/tr[2]")).getText();
									List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-"+vals[k-1]+"-datagrid']/div/table[1]/thead/tr[2]"));
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
										//String strMain = d1[i][5];
										String[] arrSplit5 = arrSplit4[k-1].split(",");
										System.out.println(arrSplit5);
										for(int rnum=0;rnum<arrSplit5.length;rnum++)
										{
											System.out.println(arrSplit5[rnum]);
											if (rowData.contains(arrSplit5[rnum]))
											{
												System.out.println("This Column is present:::"+arrSplit5[rnum]);
												acop = "Dashboard displayed as expected";
												data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
												rc++;
												excel.writePass(d1[i][0], counter, sheet, acop);

											}
											else
											{
												System.out.println("This Column is not present:::"+arrSplit5[rnum]);
												acop = "Dashboard displayed as expected";
												data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												excel.writeFail(d1[i][0], counter, sheet, acop,scr);

											}
										}
									}




									/*if(Chk.equalsIgnoreCase(d1[i][5]))
								{
									System.out.println("Search value displayed Successfully");
									acop = "Selected search value"+ Chk +" displayed Successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
									rc++;
									excel.writePass(d1[i][0], counter, sheet, acop);

								}
								else
								{
									System.out.println("Search value not displayed ");
									acop = "Selected search value"+ Chk +" not displayed Successfully";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d1[i][0], "ReefersStatus", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									excel.writeFail(d1[i][0], counter, sheet, acop,scr);

								}*/
								}

								else
									System.out.println("Search Failed ... No data Found ");



								System.out.println("TC2 Execution completed.");
							}



						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC3 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}

					if(d1[i][0].equalsIgnoreCase("TC4"))
					{
						try
						{
							System.out.println( "TC4 Execution started.....");
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("Billing"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);
							WebElement ele = driver.findElement(By.xpath(".//*[@id='header__billing-selector__select']"));
							System.out.println(ele.getTagName());
							List<WebElement>page=ele.findElements(By.tagName("option"));
							System.out.println("<<<<<<<<<<<<<"+page.size());

							for (int k=1; k<=page.size();k++)
							{
								driver.findElement(By.xpath(Object.getProperty("ProductSelect"))).click();
								Thread.sleep(1000);
								String SelVal = driver.findElement(By.xpath(".//*[@id='header__billing_selector__select_chosen']/div/ul/li["+k+"]")).getText();
								System.out.println(">>>>>>>>>>>>>"+SelVal);
								driver.findElement(By.xpath(".//*[@id='header__billing_selector__select_chosen']/div/ul/li["+k+"]")).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
									Thread.sleep(1000);
								switch(SelVal)
								{
								case "PRODUCT":
									driver.findElement(By.xpath(Object.getProperty("BillingAdd"))).click();
									//while(t.isElementPresentcheck(By.xpath(Object.getProperty("ProductName")), driver))	
									System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV"+d1[i][5]);
									Thread.sleep(2000);
									//driver.findElement(By.xpath(Object.getProperty("ProductName"))).click();
									driver.findElement(By.xpath(Object.getProperty("ProductName"))).sendKeys(d1[i][5]);
									driver.findElement(By.xpath("/html/body/div[59]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div/div/a/span")).click();
									driver.findElement(By.xpath("/html/body/div[59]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div/div/div/ul/li[2]")).click();
									//driver.findElement(By.xpath(Object.getProperty("ProductType"))).click();
									driver.findElement(By.xpath(Object.getProperty("ProductType"))).sendKeys(d1[i][5]);
									//driver.findElement(By.xpath(Object.getProperty("ProductSubType"))).click();
									driver.findElement(By.xpath(Object.getProperty("ProductSubType"))).sendKeys(d1[i][5]);
									driver.findElement(By.xpath(Object.getProperty("ProductAddButton"))).click();
									while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
										Thread.sleep(1000);
									String sucMessage = driver.findElement(By.xpath(Object.getProperty("SuccessDisplay"))).getText();
									//String chk = "Product ("+d1[i][5]+") already exist";
									if (sucMessage == d1[i][8])
									{
										System.out.println("Product Added Successfully");
										acop = "Product Added Successfully";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
										rc++;
										excel.writePass(d1[i][0], counter, sheet, acop);
									}

									else
									{

										String newval = d1[i][5]+"1";
										driver.findElement(By.xpath(Object.getProperty("BillingAdd"))).click();
										Thread.sleep(2000);
										driver.findElement(By.xpath(Object.getProperty("ProductName"))).sendKeys(newval);
										driver.findElement(By.xpath("/html/body/div[59]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div/div/a/span")).click();
										driver.findElement(By.xpath("/html/body/div[59]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div/div/div/ul/li[2]")).click();
										driver.findElement(By.xpath(Object.getProperty("ProductType"))).sendKeys(newval);
										driver.findElement(By.xpath(Object.getProperty("ProductSubType"))).sendKeys(newval);
										driver.findElement(By.xpath(Object.getProperty("ProductAddButton"))).click();
										while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
											Thread.sleep(1000);
										String sucMessage1 = driver.findElement(By.xpath(Object.getProperty("SuccessDisplay"))).getText();
										if (sucMessage == d1[i][8])
										{
											System.out.println("Product Added Successfully");
											acop = "Product Added Successfully";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
											rc++;
											excel.writePass(d1[i][0], counter, sheet, acop);
										}
										else
										{
											System.out.println("Product Added Failed");
											acop = "Product Added Failed";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
											rc++;
											excel.writePass(d1[i][0], counter, sheet, acop);
										}
									}

									break;

								case "CONTRACT":
									driver.findElement(By.xpath(Object.getProperty("BillingAdd"))).click();
									//while(t.isElementPresentcheck(By.xpath(Object.getProperty("ProductName")), driver))	
									//System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV"+d1[i][5]);
									Thread.sleep(2000);
									//driver.findElement(By.xpath(Object.getProperty("ProductName"))).click();
									driver.findElement(By.xpath("/html/body/div[61]/div/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/a/span")).sendKeys(d1[i][5]);
									driver.findElement(By.xpath("/html/body/div[59]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div/div/a/span")).click();
									driver.findElement(By.xpath("/html/body/div[59]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div/div/div/ul/li[2]")).click();
									//driver.findElement(By.xpath(Object.getProperty("ProductType"))).click();
									driver.findElement(By.xpath(Object.getProperty("ProductType"))).sendKeys(d1[i][5]);
									//driver.findElement(By.xpath(Object.getProperty("ProductSubType"))).click();
									driver.findElement(By.xpath(Object.getProperty("ProductSubType"))).sendKeys(d1[i][5]);
									driver.findElement(By.xpath(Object.getProperty("ProductAddButton"))).click();
									while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
										Thread.sleep(1000);
									String sucMessage2 = driver.findElement(By.xpath(Object.getProperty("SuccessDisplay"))).getText();
									//String chk = "Product ("+d1[i][5]+") already exist";
									if (sucMessage2 == d1[i][8])
									{
										System.out.println("Product Added Successfully");
										acop = "Product Added Successfully";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
										rc++;
										excel.writePass(d1[i][0], counter, sheet, acop);
									}

									else
									{

										String newval = d1[i][5]+"1";
										driver.findElement(By.xpath(Object.getProperty("BillingAdd"))).click();
										Thread.sleep(2000);
										driver.findElement(By.xpath(Object.getProperty("ProductName"))).sendKeys(newval);
										driver.findElement(By.xpath("/html/body/div[59]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div/div/a/span")).click();
										driver.findElement(By.xpath("/html/body/div[59]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div/div/div/ul/li[2]")).click();
										driver.findElement(By.xpath(Object.getProperty("ProductType"))).sendKeys(newval);
										driver.findElement(By.xpath(Object.getProperty("ProductSubType"))).sendKeys(newval);
										driver.findElement(By.xpath(Object.getProperty("ProductAddButton"))).click();
										while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
											Thread.sleep(1000);
										String sucMessage1 = driver.findElement(By.xpath(Object.getProperty("SuccessDisplay"))).getText();
									}

									break;

								}




							}


						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC4 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}

					if(d1[i][0].equalsIgnoreCase("TC5"))
					{
						try
						{
							ArrayList<String> tr=new ArrayList<String>();
							System.out.println( "TC5 Execution started.....");
							//ArrayList<String> tr=new ArrayList<String>();
							int pageSize=0,recordsCount=0;									

							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();									
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))									
								Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("Billing"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							WebElement ele = driver.findElement(By.xpath(".//*[@id='header__billing-selector__select']"));
							System.out.println(ele.getTagName());
							List<WebElement>page=ele.findElements(By.tagName("option"));
							System.out.println("<<<<<<<<<<<<<"+page.size());
							String gridVal = d1[i][5];
							String[] vals = gridVal.split(",");
							System.out.println(vals);

							for (int k=1; k<=page.size();k++)
							{
								driver.findElement(By.xpath(Object.getProperty("ProductSelect"))).click();
								Thread.sleep(1000);
								String SelVal = driver.findElement(By.xpath(".//*[@id='header__billing_selector__select_chosen']/div/ul/li["+k+"]")).getText();
								System.out.println(">>>>>>>>>>>>>"+SelVal);
								driver.findElement(By.xpath(".//*[@id='header__billing_selector__select_chosen']/div/ul/li["+k+"]")).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
									Thread.sleep(1000);
								String parentHandle = driver.getWindowHandle();
								if (t.isElementPresentcheck(By.xpath("//*[@id='btnExportBillingAll']"),driver))
								{
									driver.findElement(By.xpath(Object.getProperty("BillingDownloadAll"))).click();
									Thread.sleep(10000);
									while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
										Thread.sleep(1000);
									if ((t.isElementPresentcheck(By.xpath(Object.getProperty("BillingDownloadAll")), driver)))
									{
										System.out
										.println("Nothing todo it will proceed");
									}
									else
									{
										for (String winHandle : driver.getWindowHandles())									
											System.out.println(winHandle);									
										Thread.sleep(4000);
										for (String winHandle : driver.getWindowHandles())	
										{
											driver.switchTo().window(winHandle); 
											System.out.println(winHandle);
										}
										//driver.close();
										driver.switchTo().window(parentHandle);
										System.out
										.println("inside else to handle windows");
									}
									try
									{
										BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\Product-All.xls"));
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
										System.out.println("Excell All downloaded count "+recordsCount);

									}
									catch (Exception e)
									{e.printStackTrace();}	

									WebElement Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder-Billing']/ul"));
									List<WebElement> PageList = Pagination.findElements(By.tagName("li"));
									System.out.println("Size of the page"+PageList.size());
									/*for(int j=0;j<PageList.size();j++)
												{						
													System.out.println(PageList.get(j).getText());
												}					
												if(PageList.get(0).getText().equalsIgnoreCase("Prev") && PageList.get(PageList.size()-2).getText().equalsIgnoreCase("Next") && PageList.get(PageList.size()-1).getText().contains("Go To Page"))
												{  					
													PageList.get(PageList.size()-3).click();
													System.out.println("Pagination Displayed Successfully");
													if(d1[i][5].isEmpty())
													{
														acop = "Pagination Displayed as expected";
														data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
														rc++;
														excel.writePass(d1[i][0], counter, sheet, acop);

													}
												}*/
									//String sat = driver.findElement(By.xpath(Object.getProperty("gettextProduct"))).getText();
									if (PageList.size() == 4)
									{
										WebElement ele1 = driver.findElement(By.xpath(".//*[@id='div-"+vals[k-1]+"-datagrid-tbody']"));									
										List<WebElement>page1=ele1.findElements(By.tagName("tr"));
										pageSize=page1.size();
										System.out
										.println("What is the page size = "+pageSize);
										if(recordsCount == pageSize)
										{
											System.out.println("UserAdminBilling download all is downloaded successfull");									
											acop = "UserAdminBilling download all is downloaded successfull";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
											rc++;
											excel.writePass(d1[i][0], counter, sheet, acop);									
										}
										else
										{
											System.out.println("UserAdminBilling download all is downloaded failed");									
											acop = "UserAdminBilling download all is downloaded failed";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
											rc++;
											excel.writePass(d1[i][0], counter, sheet, acop);
										}
									}
									else
									{
										String pageVal = PageList.get(PageList.size()-3).getText();
										PageList.get(PageList.size()-3).click();
										while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
											Thread.sleep(1000);
										int iTest = Integer.parseInt(pageVal);
										int total = iTest * 10;
										int sum = total - 10;
										/*driver.findElement(By.xpath(Object.getProperty("BillPageDrpdown"))).click();
													Thread.sleep(2000);
													driver.findElement(By.xpath(Object.getProperty("BillPageValue"))).sendKeys(pageVal);
													driver.findElement(By.xpath(Object.getProperty("BillPageSelect"))).click();
													while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))								
														Thread.sleep(1000);*/
										System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"+sum);
										System.out.println(".//*[@id='div-"+vals[k-1]+"-datagrid-tbody']");
										WebElement Pagination1 = driver.findElement(By.xpath(".//*[@id='div-"+vals[k-1]+"-datagrid-tbody']"));
										List<WebElement> PageList1 = Pagination1.findElements(By.tagName("tr"));
										System.out.println("Size of the page "+PageList1.size());
										//int iTest1 = Integer.parseInt(PageList1.size());
										int totalSum = sum + PageList1.size();
										System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"+totalSum);

										if(recordsCount == totalSum)
										{
											System.out.println(" download all is downloaded successfull");									
											acop = "UserAdminBilling download all is downloaded successfull";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
											rc++;
											excel.writePass(d1[i][0], counter, sheet, acop);									
										}
										else
										{
											System.out.println("UserAdminBilling download all is downloaded failed");									
											acop = "UserAdminBilling download all is downloaded failed";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
											rc++;
											excel.writePass(d1[i][0], counter, sheet, acop);
										}



									}

								}
								else
								{
									System.out.println("Excell All not present");
								}




							}


							/*driver.findElement(By.xpath(Object.getProperty("ExcelDownload"))).click();
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
							}*/

							System.out.println("TC14 Execution completed.");
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC14 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}

					if(d1[i][0].equalsIgnoreCase("TC6"))
					{
						try
						{
							System.out.println( "TC6 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("Billing"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("BillingRefresh"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
								Thread.sleep(1000);

							if(!(t.isElementPresentcheck(By.xpath(Object.getProperty("UploadOcp")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("IntroduceUnit")), driver)) || 
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("GetGSMData")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("GetSATData")), driver)) ||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("GetUnitData")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("ScrapUnit")), driver)) ||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("PowerONStatusReport")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("GeofenceData")), driver)) ||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("ProductSelect")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("ProductSearch")), driver)) ||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("BillingAdd")), driver)) || (!t.isElementPresentcheck(By.xpath(Object.getProperty("BiilingModify")), driver)) ||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("BillingProductDashboard")), driver)))
							{
								System.out.println("Page not Re-loaded Successfully");
								acop = "Door Alarm Page Re-Loading Failed";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);								
							}
							else
							{
								System.out.println("Page Re-loaded Successfully");
								acop = "Door Alarm Page Re-Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);								
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC6 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}

					}
					if(d1[i][0].equalsIgnoreCase("TC7"))
					{
						try
						{
							System.out.println( "TC7 Execution started.....");
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("FleetSelect"))).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][4]);
							driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);

							driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("Billing"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);
							driver.findElement(By.xpath("//*[@id='header__billing_selector__select_chosen']/a/span")).click();
							Thread.sleep(1000);
							driver.findElement(By.xpath(".//*[@id='header__billing_selector__select_chosen']/div/ul/li[2]")).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);					
							WebElement Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder-Billing']/ul"));
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
									data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
									rc++;
									excel.writePass(d1[i][0], counter, sheet, acop);

								}
								else
								{
									driver.findElement(By.xpath(Object.getProperty("BillPageDrpdown"))).click();
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("BillPageValue"))).sendKeys(d1[i][5]);
									driver.findElement(By.xpath(Object.getProperty("BillPageSelect"))).click();
									while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))								
										Thread.sleep(1000);

									Pagination = driver.findElement(By.xpath(".//*[@id='pagination-holder-Billing']/ul"));
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
												data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
												rc++;
												excel.writePass(d1[i][0], counter, sheet, acop);	  			  		  					
												break;
											}
											else
											{
												System.out.println("Current Page doesnot match the Page which is selected ");
												acop = "Pagination not displayed as expected";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
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
								data.put(""+rc, new Object[] {d1[i][0], "UserAdminBilling", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop,scr);								
							}
						}catch(Exception e)
						{node.log(LogStatus.SKIP, "Skipped TC7 Execution, it is because of page loading issue or due to some other issue");
						e.printStackTrace();}
					}





				}
			}



		}catch(Exception e)
		{
			e.printStackTrace();
		}	

		System.out.println("---------------------------------------------------------");
		//driver.close();
		reports.endTest(node);
		reports.flush();
		return data;

	}

}
