package dd_test;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.TestUtil;
import dd_utils.pollCommandsHelp;
import dd_utils.sCommandsHelp;


public class pollCommands extends TestCore 
{
	static TestUtil s =new TestUtil();
	static pollCommandsHelp help =new pollCommandsHelp();
		
	@Test
	public static Map<String, Object[]> Pollcommandstestcase(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test ,int scase,int ecase) 
	{
			ExtentTest node = reports.startTest("PollCommands");
			String[][] input =TestUtil.getData("PollCommands");
			
			String acop =null;
			int counter =1;
			
			try 
			{
				driver = new FirefoxDriver(s.excelDownload());
				driver.get(Object.getProperty("URL"));
				if(s.dologin(driver ,input[0][2], input[0][3]))
				{
					System.out.println("Poll Commands Module");				
				for(int i=scase-1;i<ecase;i++)
				{
					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_ESCAPE);
					Thread.sleep(500);
					r.keyRelease(KeyEvent.VK_ESCAPE);
					
					Thread.sleep(3000);
					System.out.println("TC "+(i+1));
					
					long stime = System.currentTimeMillis();					
					
					String tc=input[i][0];
					String tcdesc =input[i][1];
	  				String eopt =input[i][4];
	  				String assetId = input[i][6];
	  				String message = input[i][7];
	  				
	  				Thread.sleep(5000);
	  				driver.findElement(By.xpath(Object.getProperty("FleetSelector"))).click();
	  				Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).click();
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).clear();
	  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][5]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(2000);
					
					switch(tc)
					{
						case "TC1":
							System.out.println("TC1 Execution started.....");
							try
							{
							if(help.pageCheck(driver, Object,assetId))
							{
								
								System.out.println("Page loaded successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Page loaded successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Page loaded successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet,acop);
							}
							else
							{
								
								System.out.println("Page load failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Page load failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Page load failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						case "TC2":
							System.out.println("TC2 Execution started.....");
							try
							{
							if(help.sendPollCommand(driver, Object, assetId, message))
							{
								
								System.out.println("Reefer Status Poll Command sent successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Reefer Status Poll Command sent successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Reefer Status Poll Command sent successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet,acop);
							}
							else
							{
								
								System.out.println("Reefer Status Poll Command sending failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Reefer Status Poll Command sending failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Reefer Status Poll Command sending failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}	
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						case "TC3":
							System.out.println("TC3 Execution started.....");
							try
							{
							if(help.sendPollCommand(driver, Object, assetId, message))
							{
								
								System.out.println("Poll Maintenance Status Command sent successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Maintenance Status Command sent successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Poll Maintenance Status Command sent successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet,acop);
							}
							else
							{
								
								System.out.println("Poll Maintenance Status Command sending failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Maintenance Status Command sending failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Poll Maintenance Status Command sending failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}	
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						case "TC4":
							System.out.println("TC4 Execution started.....");
							try
							{
							if(help.sendPollCommand(driver, Object, assetId, message))
							{
								
								System.out.println("Poll Alarm Status Command sent successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Alarm Status Command sent successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Poll Alarm Status Command sent successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Poll Alarm Status Command sending failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Alarm Status Command sending failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Poll Alarm Status Command sending failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}	
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						case "TC5":
							System.out.println("TC5 Execution started.....");
							try
							{
							if(help.sendPollCommand(driver, Object, assetId, message))
							{
								
								System.out.println("Poll GPS Report Command sent successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll GPS Report Command sent successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Poll GPS Report Command sent successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Poll GPS Report Command sending failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll GPS Report Command sending failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Poll GPS Report Command sending failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}	
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						case "TC6":
							System.out.println("TC6 Execution started.....");
							try
							{
							if(help.sendPollCommand(driver, Object, assetId, message))
							{
								
								System.out.println("Reefer Alarm List Command sent successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Reefer Alarm List Command sent successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Reefer Alarm List Command sent successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Reefer Alarm List Command sending failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Reefer Alarm List Command sending failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Reefer Alarm List Command sending failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}	
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						case "TC7":
							System.out.println("TC7 Execution started.....");
							try
							{
							if(help.sendPollCommand(driver, Object, assetId, message))
							{
								
								System.out.println("Read Active Intelliset Command sent successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Read Active Intelliset Command sent successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Read Active Intelliset Command sent successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Read Active Intelliset Command sending failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Read Active Intelliset Command sending failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Read Active Intelliset Command sending failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}	
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						case "TC8":
							System.out.println("TC8 Execution started.....");
							try
							{
							if(help.sendPollCommand(driver, Object, assetId, message))
							{
								
								System.out.println("Poll Mileage Report Command sent successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Mileage Report Command sent successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Poll Mileage Report Command sent successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Poll Mileage Report Command sending failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Mileage Report Command sending failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Poll Mileage Report Command sending failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}	
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						case "TC9":
							System.out.println("TC9 Execution started.....");
							try
							{
							if(help.sendPollCommand(driver, Object, assetId, message))
							{
								
								System.out.println("Poll Temp Profile Command sent successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Temp Profile Command sent successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Poll Temp Profile Command sent successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Poll Temp Profile Command sending failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Temp Profile Command sending failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Poll Temp Profile Command sending failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}	
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						case "TC10":
							System.out.println("TC10 Execution started.....");
							try
							{
							if(help.sendPollCommand(driver, Object, assetId, message))
							{
								
								System.out.println("Poll Pretrip Status (TK) Command sent successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Pretrip Status (TK) Command sent successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Poll Pretrip Status (TK) Command sent successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Poll Pretrip Status (TK) Command sending failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Pretrip Status (TK) Command sending failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Poll Pretrip Status (TK) Command sending failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}	
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						case "TC11":
							System.out.println("TC11 Execution started.....");
							try
							{
							if(help.sendPollCommand(driver, Object, assetId, message))
							{
								
								System.out.println("Poll System Status (TK) Command sent successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll System Status (TK) Command sent successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Poll System Status (TK) Command sent successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Poll System Status (TK) Command sending failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll System Status (TK) Command sending failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Poll System Status (TK) Command sending failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}	
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						case "TC12":
							System.out.println("TC12 Execution started.....");
							try
							{
							if(help.sendPollCommand(driver, Object, assetId, message))
							{
								
								System.out.println("Poll Terminal Status (TK) Command sent successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Terminal Status (TK) Command sent successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Poll Terminal Status (TK) Command sent successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Poll Terminal Status (TK) Command sending failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Terminal Status (TK) Command sending failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Poll Terminal Status (TK) Command sending failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}	
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						case "TC13":
							System.out.println("TC13 Execution started.....");
							try
							{
							if(help.sendPollCommand(driver, Object, assetId, message))
							{
								
								System.out.println("Poll Multi-Temp Status Command sent successfully");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Multi-Temp Status Command sent successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Poll Multi-Temp Status Command sent successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Poll Multi-Temp Status Command sending failed");
								data.put(""+rc, new Object[] {tc, "Poll Commands", tcdesc, eopt, "Poll Multi-Temp Status Command sending failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Poll Multi-Temp Status Command sending failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}	
							break;
							}catch(Exception e )
							{e.printStackTrace();}
						default:
							break;
					
					
					
					
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
