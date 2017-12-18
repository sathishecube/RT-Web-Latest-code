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
import dd_utils.LogisticUtils;
import dd_utils.TestUtil;
import dd_utils.controlCommandsutil;

public class controlCommands extends TestCore 
{
	static TestUtil s =new TestUtil();
	static controlCommandsutil help =new controlCommandsutil();
		
	@Test
	public static Map<String, Object[]> Controlcommandsutil(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test ,int scase,int ecase) 
	{
			ExtentTest node = reports.startTest("ControlCommands");
			String[][] input =TestUtil.getData("ControlCommands");
			
			String acop =null;
			int counter =1;
			
			try 
			{
				driver = new FirefoxDriver(s.excelDownload());
				driver.get(Object.getProperty("URL"));
				if(s.dologin(driver ,input[0][2], input[0][3]))
				{	
					//driver.manage().window().maximize();
					System.out.println("Control Commands Module");
					
				for(int i=scase-1;i<ecase;i++ )
				{			
									
					Thread.sleep(3000);
					System.out.println("TC "+(i+1));
					
					long stime = System.currentTimeMillis();					
					
					String  tc=input[i][0];
					String tcdesc =input[i][1];
	  				String eopt =input[i][4];
	  				String assetId = input[i][6];
	  				String message = input[i][7];
	  				String date = input[i][8];
	  				
	  				driver.findElement(By.xpath(".//*[@id='div-100-sub-lnk']")).click();	  				
	  				while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
	  				Thread.sleep(2000);
	  						
	  				
	  				driver.findElement(By.xpath(Object.getProperty("FleetSelector"))).click();
	  				Thread.sleep(2000);
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
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Page loaded successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Page loaded successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Page load failed");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Page load failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Page load failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
							}catch(Exception e)
							{
								e.printStackTrace();
							}
						case "TC2":
							System.out.println("TC2 Execution started.....");
							try
							{
							if(help.setPoint(driver, Object,assetId,message, date))
							{
								
								System.out.println("Set Point test successful...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Set Point test successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Set Point test successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Set Point test failed...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Set Point test failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Set Point test failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
							}catch(Exception e)
							{e.printStackTrace();}
							
						case "TC3":
							System.out.println("TC3 Execution started.....");
							try
							{
							if(help.reeferActions(driver, Object,assetId,message))
							{
								System.out.println("Reefer Action test successful...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Reefer Action test successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Reefer Action test successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Reefer Action test failed...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Reefer Action test failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Reefer Action test failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
							}catch(Exception e)
							{e.printStackTrace();}
						case "TC4":
							System.out.println("TC4 Execution started.....");
							try
							{
							if(help.sendReeferActions(driver, Object,assetId,date,message))
							{
								System.out.println("Send reefer Action test successful...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Send reefer Action test successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Send reefer Action test successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Send reefer Action test failed...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Send reefer Action test failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Send reefer Action test failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
							}catch(Exception e)
							{e.printStackTrace();}
						case "TC5":
							System.out.println("TC5 Execution started.....");
							try
							{
							if(help.powerControl(driver, Object,assetId,message))
							{
								
								System.out.println("Power Control test successful...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Power Control test successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Power Control test successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Power Control test failed...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Power Control test failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Power Control test failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
							}catch(Exception e)
							{e.printStackTrace();}
						case "TC6":
							System.out.println("TC6 Execution started.....");
							try
							{
							if(help.sendPowerControl (driver, Object,assetId,date,message))
							{
								System.out.println("Send reefer Action test successful...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Send reefer Action test successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Send reefer Action test successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Send reefer Action test failed...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Send reefer Action test failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Send reefer Action test failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
							}catch(Exception e)
							{e.printStackTrace();}
						case "TC7":
							System.out.println("TC7 Execution started.....");
							try
							{
							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							Thread.sleep(2000);
							if(help.configTempAlert(driver, Object,assetId,message))
							{
								
								System.out.println("Config temp Alert test successful...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Config temp test successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Config temp Alert test successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Config temp Alert test failed...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Config Temp test failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Config temp Alert test failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
							}catch(Exception e)
							{e.printStackTrace();}
						case "TC8":
							System.out.println("TC8 Execution started.....");
							try
							{
							driver.findElement(By.xpath(Object.getProperty("MultiTemp"))).click();
							Thread.sleep(2000);
							if(help.configTempAlert(driver, Object,assetId,message))
							{
								
								System.out.println("Config temp Alert test successful...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Config temp test successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Config temp Alert test successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Config temp Alert test failed...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Config Temp test failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Config temp Alert test failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
							}catch(Exception e)
							{e.printStackTrace();}
						case "TC9":
							System.out.println("TC9 Execution started.....");
							try
							{
							if(help.SM(driver, Object,assetId,message,date))
							{	
								System.out.println("State Machine test successful...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "State Machine test successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="State Machine test successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("State Machine test failed...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "State Machine test failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="State Machine test failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
							}catch(Exception e)
							{e.printStackTrace();}
						case "TC10":
							System.out.println("TC10 Execution started.....");
							try
							{
							if(help.panicMode(driver, Object,assetId,message, date))
							{
								
								System.out.println("Panic Mode test successful...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Panic Mode test successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Panic Mode test successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Panic Mode test failed...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Panic Mode test failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Panic Mode test failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
							}catch(Exception e)
							{e.printStackTrace();}
						case "TC11":
							System.out.println("TC11 Execution started.....");
							try
							{
							if(help.sendLockControl(driver, Object, assetId, date, message))
							{
								
								System.out.println("Lock control test successful...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Lock control test successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Lock control test successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Lock control test failed...");
								data.put(""+rc, new Object[] {tc, "Control Commands", tcdesc, eopt, "Lock control test failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Lock control test failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
							}catch(Exception e)
							{e.printStackTrace();}
						default:
							break;
							
					}
					
					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_ESCAPE);
					Thread.sleep(500);
					r.keyRelease(KeyEvent.VK_ESCAPE);
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
