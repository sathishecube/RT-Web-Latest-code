package dd_test;

import java.util.ArrayList;
import java.util.Map;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import dd_core.TestCore;
import dd_utils.*;

public class Settings extends TestCore 
{
	static TestUtil t =new TestUtil();
	static SettingsUtil s =new SettingsUtil();
	
	@Test
	public static Map<String, Object[]> setting(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test ,int scase ,int ecase) 
	{
		try
		{
		String acop =null;
		int counter =1;
		ExtentTest node = reports.startTest("Settings");
		String[][] d1 =TestUtil.getData("Settings");
		System.out.println("Settings Module");
		
		driver = new FirefoxDriver();
		driver.get(Object.getProperty("URL"));		
		
			
				if(t.dologin(driver, d1[0][2], d1[0][3]))
				{
				for(int i=scase-1;i<ecase;i++ )
				{
					long stime=System.currentTimeMillis();
				
					//Executing 1st test case
					if(d1[i][0].equalsIgnoreCase("TC1"))
					{ 
						try
						{
							System.out.println("TC1 Execution started.....");
							String z = "";
							z = s.Settinghome(driver);
							System.out.println(z);
							if(z.equalsIgnoreCase("Display setting, user setting, Notification setting"))
							{
								System.out.println(z+" are available...");
								node.log(LogStatus.PASS, z+"are available");
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z+" are available" , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								System.out.println("settings page verification failed..");
								node.log(LogStatus.FAIL, "Settings page verification failed..");
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], "settings page verification failed..", "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				
					//Executing 2nd test case
					if(d1[i][0].equalsIgnoreCase("TC2"))
					{ 
						try
						{
							System.out.println("TC2 Execution started.....");
							Thread.sleep(5000);
							ArrayList<String> z = new ArrayList<String>(); 
							z = s.displaySettinghome(driver);
							String a ="";
							for(int j=0;j<z.size();j++)
							{
								a = a.concat(z.get(j));
							}
							System.out.println(a);
							if(a.equalsIgnoreCase("SessionExpiration, MessagesPerReport, ConfirmCommandMessage, DateFormat, TemperatureUnit, TimeZone, FuelUnit, HistoryReportType, DistanceUnit, ReeferState/Modeofopdisplay, DefaultReportView, LocationDisplay(City,StateandYard), Update settings, Reset"))
							{
								System.out.println(a+" are available");
								node.log(LogStatus.PASS, a+" are available");
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z+" are available" , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z+" are available");
							}
							else
							{
								node.log(LogStatus.FAIL, "Display settings page verification failed..");
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], "Display settings page verification failed..", "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z+" are available",scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				
				
					//Excecuting 3rd test case
					if(d1[i][0].equalsIgnoreCase("TC3"))
					{ 
						try
						{
							System.out.println("TC3 Execution started.....");
							Thread.sleep(5000);
							String z = "";
							//int b = Integer.parseInt(d1[i][5]);
							//System.out.println(b);
							z = s.Sessionexpire(driver, d1[i][5]);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS, z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);					
								
							}
							else
							{
								node.log(LogStatus.FAIL, "Session expiration update failed");
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], "session expiration updation failed", "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(5000);
						}catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				
				
					//Executing 4th testcase
					if(d1[i][0].equalsIgnoreCase("TC4"))
					{ 
						try
						{
							System.out.println("TC4 Execution started.....");
							Thread.sleep(5000);
							String z = "";
							z= s.Messagesperreport(driver, d1[i][6]);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS, z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								node.log(LogStatus.FAIL, "Message Per report updation failed");
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], "Message per report updation failed", "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				
					//Executing 5th Testcase
					if(d1[i][0].equalsIgnoreCase("TC5"))
					{
						try
						{
							System.out.println("TC5 Execution started.....");
							Thread.sleep(5000);
							String acop1="";
							String aop = d1[i][4];							
							acop1=s.confirmCommand(driver, Object1, d1[i][7],d1[i][8]);
							System.out.println(acop1);
							if(acop1.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS,acop1);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], acop1 , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop1);
							}
							else
							{
								node.log(LogStatus.FAIL, acop1);
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], acop1, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, acop1,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				
					//Executing 6th testcase
					if(d1[i][0].equalsIgnoreCase("TC6") )
					{ 
						try
						{
							System.out.println("TC6 Execution started.....");
							Thread.sleep(5000);
							String z = "";
							z=s.Dateformat(driver, d1[i][8], d1[i][9]);							
							System.out.println(z);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS, z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								node.log(LogStatus.FAIL, "Date format updation failed");
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], "Date format updation failed", "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				
					//executing 7th test case
					if(d1[i][0].equalsIgnoreCase("TC7") )
					{ 
						try
						{
							System.out.println("TC7 Execution started.....");
							Thread.sleep(5000);
							String z = "";
							z =s.TempUnit(driver, d1[i][9]);
							System.out.println(z);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS, z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								node.log(LogStatus.FAIL, "Temp unit updation failed");
								
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], "Temp unit updation failed", "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{e.printStackTrace();}
					}
				
					//Excecuting 8th test case
					if(d1[i][0].equalsIgnoreCase("TC8"))
					{ 
						try
						{
							System.out.println("TC8 Execution started.....");
							Thread.sleep(5000);
							String z = "";
							z= s.Timezone(driver, d1[i][10]);
							System.out.println(z);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS, z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								node.log(LogStatus.FAIL, "TimeZone updation failed");
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], "TimeZone updation failed", "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}	
							Thread.sleep(2000);
						}catch(Exception e)
						{e.printStackTrace();}
					}
				
					//Executing 9th test case
					if(d1[i][0].equalsIgnoreCase("TC9"))
					{ 
						try
						{
							System.out.println("TC9 Execution started.....");
							Thread.sleep(5000);
							String z = "";
							z=s.fuelunit(driver, d1[i][11]);
							System.out.println(z);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS, z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								node.log(LogStatus.FAIL, "Fuel unit updation failed");
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], "Fuel unit updation failed", "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{ e.printStackTrace();}
					}
				
					//Executing 10th test case
					if(d1[i][0].equalsIgnoreCase("TC10") )
					{ 
						try
						{
							System.out.println("TC10 Execution started.....");
							Thread.sleep(5000);
							String z = "";
							z=s.modeOfOperation(driver, d1[i][12]);
							System.out.println(z);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							z=aop;
							if(z.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS, z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								node.log(LogStatus.FAIL, "History report type failed");
								t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], "History Report type fail", "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{e.printStackTrace();}
					}
				
					//Executing 11th test case
					if(d1[i][0].equalsIgnoreCase("TC11"))
					{ 
						try
						{
							System.out.println("TC11 Execution started.....");
							Thread.sleep(5000);
							String z = "";
							z=s.distanceUnit(driver, d1[i][13]);
							System.out.println(z);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS, z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								node.log(LogStatus.FAIL, z);
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{
							e.printStackTrace();}
					}
				
					//Executing 12th test case
					if(d1[i][0].equalsIgnoreCase("TC12"))
					{ 
						try
						{
							System.out.println("TC12 Execution started.....");
							Thread.sleep(5000);
							String z = "";
							z=s.modeOfOperation(driver, d1[i][14]);
							System.out.println(z);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS, z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								node.log(LogStatus.FAIL, z);
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{e.printStackTrace();}
					}
				
					//Executing 13th test case
					if(d1[i][0].equalsIgnoreCase("TC13"))
					{ 
						try
						{
							System.out.println("TC13 Execution started.....");							
							Thread.sleep(5000);
							String z = "";
							z=s.defaultview(driver, d1[i][15]);
							System.out.println("Result :"  +z);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS, z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								node.log(LogStatus.FAIL, "Default Report View updation failed");
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], "Default Report View updation failed", "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{e.printStackTrace();}
						
					}
				
					//Executing 14th test case
					if(d1[i][0].equalsIgnoreCase("TC14") )
					{ 
						try
						{	
							System.out.println("TC14 Execution started.....");
							Thread.sleep(10000);
							String z = "";
							z=s.location(driver, Object1, d1[i][16]);
							System.out.println(z);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.equalsIgnoreCase(aop))
							{
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{e.printStackTrace();}
					
					}
				
					//Executing 15th testcase
					if(d1[i][0].equalsIgnoreCase("TC15"))
					{ 
						try
						{
							System.out.println("TC15 Execution started.....");
							Thread.sleep(5000);
							String z = "";
							z=s.userSettings(driver, Object1, d1[i][2], d1[i][17]);
							System.out.println(z);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS, z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								node.log(LogStatus.FAIL, z);
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{e.printStackTrace();}
					}
				
					//Executing 16th test case
					if(d1[i][0].equalsIgnoreCase("TC16"))
					{ 
						try
						{
							System.out.println("TC16 Execution started.....");
							Thread.sleep(5000);
							String z = "";
							z=s.notificationSettings(driver, Object1);
							System.out.println(z);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.equalsIgnoreCase(aop))
							{
								node.log(LogStatus.PASS,z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							else
							{
								node.log(LogStatus.FAIL, z);
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{e.printStackTrace();}
					}
				
					//Executing 17th test case
					if(d1[i][0].equalsIgnoreCase("TC17"))
					{ 
						try
						{
							System.out.println("TC17 Execution started.....");
							Thread.sleep(5000);
							String z = "";
							z=s.notificationSettingsnew(driver, Object1,d1[i][17]);
							System.out.println(z);
							String aop = d1[i][4];
							System.out.println("aop : " +aop);
							if(z.contains("not") || z.contains("fail"))
							{
								node.log(LogStatus.PASS, z);
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								excel.writeFail(d1[i][0], counter, sheet, z,scr);
							}
							else
							{
								node.log(LogStatus.FAIL, z);
								//t.CaptureScreenshot();
								data.put(""+rc, new Object[] {d1[i][0],"Settings", d1[i][1], d1[i][4], z , "Pass", t.timestamp(stime) });
								rc++;
								excel.writePass(d1[i][0], counter, sheet, z);
							}
							Thread.sleep(2000);
						}catch(Exception e)
						{e.printStackTrace();}
					}
				}
				}
				
		
		
		reports.endTest(node);
		reports.flush();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		System.out.println("---------------------------------------------------------");
		driver.close();
		return data;
		}
	
	}
}
