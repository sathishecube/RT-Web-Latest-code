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
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.TestUtil;
import dd_utils.controlCommandsutil;
import dd_utils.sCommandsHelp;

public class scheduledCommands extends TestCore 
{
	static TestUtil s =new TestUtil();
	static sCommandsHelp help =new sCommandsHelp();
		
	@Test
	public static Map<String, Object[]> scheduledcommandstestcase(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test ,int scase,int ecase) 
	{
			ExtentTest node = reports.startTest("ScheduledCommands");
			String[][] input =TestUtil.getData("ScheduledCommands");
			
			String acop =null;
			int counter =1;
			
			try 
			{
				driver = new FirefoxDriver(s.excelDownload());
				driver.get(Object.getProperty("URL"));
				if(s.dologin(driver ,input[0][2], input[0][3]))
				{
					System.out.println("Scheduled Commands Module");			
				
				for(int i=scase-1;i<ecase;i++ )
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
	  				
	  				Thread.sleep(5000);
	  				driver.findElement(By.xpath(Object.getProperty("FleetSelector"))).click();
	  				Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).click();
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).clear();
	  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(input[i][7]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					
					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();					
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					
					driver.findElement(By.xpath(Object.getProperty("ScheduledCommands"))).click();					
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					
					switch(tc)
					{
						case "TC1":
							System.out.println("TC1 Execution started.....");
							if(help.pageCheck(driver, Object))
							{
								
								System.out.println("Page loaded successfully");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Page loaded successfully", "Pass", s.timestamp(stime)});
								rc++;
								acop="Page loaded successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								
								System.out.println("Page load failed");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Page load failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Page load failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
						case "TC2":
							System.out.println("TC2 Execution started.....");
							if(help.search(driver, Object, input[i][8]))
							{
								System.out.println("Search successful...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Search successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Search successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								System.out.println("Search failed...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Search failed..", "Fail", s.timestamp(stime)});
								rc++;
								acop="Search failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
						case "TC3":
							System.out.println("TC3 Execution started.....");
							String sDate =s.dateConvert(input[i][5]);
							String eDate =s.dateConvert(input[i][6]);
							if(help.editDate(driver, Object, sDate, eDate))
							{
								System.out.println("Edit Date Range Test successful...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Edit Date Range Test successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Edit Date Range Test successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								System.out.println("Edit Date Range Test failed.../No data present for the date range...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Edit Date Range Test failed.../No data present for the date range...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Edit Date Range Test failed/No data present for the date range";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
						case "TC4":
							System.out.println("TC4 Execution started.....");
							if(help.loadDashboard(driver, Object))
							{
								System.out.println("Dashboard Headers present...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Dashboard Headers present...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Dashboard Headers present";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								System.out.println("Dashboard Headers are not pesent");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Dashboard Heders are not pesent...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Dashboard Headers are not pesent";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
						case "TC5":
							System.out.println("TC5 Execution started.....");
							if(help.refresh(driver, Object))
							{
								System.out.println("Refresh successful");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Refresh successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Refresh successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								System.out.println("Refresh failed");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Refresh failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Refresh failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
						case "TC6":
							System.out.println("TC6 Execution started.....");
							if(help.printReport(driver, Object))
							{
								System.out.println("Print Report page load successful");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Print Report page load successful...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Print Report page load successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								System.out.println("Print Report page load failed");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Print Report page load failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Print Report page load failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
						case "TC7":
							System.out.println("TC7 Execution started.....");
							if(help.saveAs(driver, Object))
							{
								System.out.println("Export Excel Report functionality validated successfully");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Export Excel Report functionality validated successfully...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Export Excel Report functionality validated successfully";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								System.out.println("Export Excel Report functionality validation failed");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Export Excel Report functionality validation failed", "Fail", s.timestamp(stime)});
								rc++;
								acop="Export Excel Report functionality validation failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
						case "TC8":
							System.out.println("TC8 Execution started.....");
							if(s.unitofMeasure(driver, Object, Object.getProperty("Commands"), Object.getProperty("ScheduledCommands"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
							{
								System.out.println("Units displayed as expected...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Units displayed as expected...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Units displayed as expected";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								System.out.println("Units displayed incorrectly...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Units displayed incorrectly...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Units displayed incorrectly";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
						case "TC9":
							System.out.println("TC9 Execution started.....");
							if(s.unitofMeasure(driver, Object, Object.getProperty("Commands"), Object.getProperty("ScheduledCommands"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
							{
								System.out.println("Units displayed as expected...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Units displayed as expected...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Units displayed as expected";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								System.out.println("Units displayed incorrectly...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Units displayed incorrectly...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Units displayed incorrectly";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
						case "TC10":
							System.out.println("TC10 Execution started.....");
							if(s.unitofMeasure(driver, Object, Object.getProperty("Commands"), Object.getProperty("ScheduledCommands"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
							{
								System.out.println("Units displayed as expected...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Units displayed as expected...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Units displayed as expected";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								System.out.println("Units displayed incorrectly...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Units displayed incorrectly...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Units displayed incorrectly";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
						case "TC11":
							System.out.println("TC11 Execution started.....");
							if(s.unitofMeasure(driver, Object, Object.getProperty("Commands"), Object.getProperty("ScheduledCommands"), Object.getProperty("DistanceCalcIcon"), Object.getProperty("DistanceTooltip"), Object.getProperty("DistanceTooltipval"), Object.getProperty("DistanceUnit")))
							{
								System.out.println("Units displayed as expected...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Units displayed as expected...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Units displayed as expected";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								System.out.println("Units displayed incorrectly...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Units displayed incorrectly...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Units displayed incorrectly";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
						case "TC12":
							System.out.println("TC12 Execution started.....");
							if((s.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)))
							{
								System.out.println("Controlling probe is present...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Controlling probe is not present...", "Pass", s.timestamp(stime)});
								rc++;
								acop="Controlling probe is present";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								System.out.println("Controlling probe is not present...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Controlling probe is not present...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Controlling probe is not present";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
						case "TC13":
							System.out.println("TC13 Execution started.....");
							if(help.checkAll(driver, Object))
							{
								System.out.println("Select All Validation successful...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Select All Validation successful......", "Pass", s.timestamp(stime)});
								rc++;
								acop="Select All Validation successful";
								node.log(LogStatus.PASS, acop);
								excel.writePass(tc, counter, sheet, acop);
							}
							else
							{
								System.out.println("Select All Validation failed...");
								data.put(""+rc, new Object[] {tc, "Scheduled Commands", tcdesc, eopt, "Select All Validation failed...", "Fail", s.timestamp(stime)});
								rc++;
								acop="Select All Validation failed";
								node.log(LogStatus.FAIL, acop);
								String scr = s.CaptureScreenshot();
								excel.writeFail(tc, counter, sheet, acop,scr);
							}
							break;
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
