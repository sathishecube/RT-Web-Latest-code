package dd_test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.*;

public class CHistory extends TestCore
{
	static TestUtil t =new TestUtil();
	static CmdHistoryUtil s = new CmdHistoryUtil();
	
	@Test
	public static Map<String, Object[]> Chistorycase(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase) 
	{
		String acop;
		ExtentTest node = reports.startTest("CommandHistory");
		String[][] d1 =TestUtil.getData("CommandHistory");		
		
		try
			{
			driver = new FirefoxDriver(t.excelDownload());
			driver.get(Object.getProperty("URL"));
			if(t.dologin(driver, d1[0][2], d1[0][3]))
			{
				System.out.println("Command History Module");			
				for(int i=scase-1;i<ecase;i++ )
				{
					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_ESCAPE);
					Thread.sleep(500);
					r.keyRelease(KeyEvent.VK_ESCAPE);
					Thread.sleep(3000);
					System.out.println("TC "+(i+1));
					long stime = System.currentTimeMillis();
					int counter=1;
					Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("FleetSelector"))).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).click();
					driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).clear();
	  				driver.findElement(By.xpath(Object.getProperty("AllFleetInput"))).sendKeys(d1[i][7]);
					driver.findElement(By.xpath(Object.getProperty("AllFleetSelect"))).click();
					
					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
				
					driver.findElement(By.xpath(Object.getProperty("Commands"))).click();					
					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						Thread.sleep(1000);
					
					
					driver.findElement(By.xpath(Object.getProperty("CommandHistory"))).click();					
					while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
					Thread.sleep(1000);
					
					switch(d1[i][0])
					{
					case "TC1":
						System.out.println("TC1 Execution started.....");
						if(s.pageCheck(driver, Object))
						{
							
							System.out.println("Page loaded successfully");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Page loaded successfully", "Pass", t.timestamp(stime)});
							rc++;
							acop="Page loaded successfully";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							
							System.out.println("Page load failed");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Page load failed", "Fail", t.timestamp(stime)});
							rc++;
							acop="Page load failed";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
						}
						break;
					case "TC2":
						System.out.println("TC2 Execution started.....");
						if(s.search(driver, Object, d1[i][8]))
						{
							System.out.println("Search successful...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Search successful...", "Pass", t.timestamp(stime)});
							rc++;
							acop="Search successful";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Search failed...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Search failed..", "Fail", t.timestamp(stime)});
							rc++;
							acop="Search failed";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
						}
						break;
					case "TC3":
						System.out.println("TC3 Execution started.....");
						String sDate =t.dateConvert(d1[i][5]);
						String eDate =t.dateConvert(d1[i][6]);
						if(s.editDate(driver, Object, sDate, eDate))
						{
							System.out.println("Edit Date Range Test successful...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Edit Date Range Test successful...", "Pass", t.timestamp(stime)});
							rc++;
							acop="Edit Date Range Test successful";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Edit Date Range Test failed.../No data present for the date range...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Edit Date Range Test failed.../No data present for the date range...", "Fail", t.timestamp(stime)});
							rc++;
							acop="Edit Date Range Test failed/No data present for the date range";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
						}
						break;
					case "TC4":
						System.out.println("TC4 Execution started.....");
						if(s.loadDashboard(driver, Object))
						{
							System.out.println("Dashboard Headers present...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Dashboard Headers present...", "Pass", t.timestamp(stime)});
							rc++;
							acop="Dashboard Headers present";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Dashboard Heders are not pesent");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Dashboard Heders are not pesent...", "Fail", t.timestamp(stime)});
							rc++;
							acop="Dashboard Heders are not pesent";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
						}
						break;
					case "TC5":
						System.out.println("TC5 Execution started.....");
						if(s.refresh(driver, Object))
						{
							System.out.println("Refresh successful");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Refresh successful...", "Pass", t.timestamp(stime)});
							rc++;
							acop="Refresh successful";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Refresh failed");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Refresh failed...", "Fail", t.timestamp(stime)});
							rc++;
							acop="Refresh failed";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
						}
						break;
					case "TC6":
						System.out.println("TC6 Execution started.....");
						if(s.printReport(driver, Object))
						{
							System.out.println("Print Report page load successful");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Print Report page load successful...", "Pass", t.timestamp(stime)});
							rc++;
							acop="Print Report page load successful";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Print Report page load failed");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Print Report page load failed...", "Fail", t.timestamp(stime)});
							rc++;
							acop="Print Report page load failed";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
						}
						break;
					case "TC7":
						System.out.println("TC7 Execution started.....");
						if(s.saveAs(driver, Object))
						{
							System.out.println("Export Excel Report functionality validated successfully");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Export Excel Report functionality validated successfully...", "Pass", t.timestamp(stime)});
							rc++;
							acop="Export Excel Report functionality validated successfully";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Export Excel Report functionality validation failed");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Export Excel Report functionality validation failed", "Fail", t.timestamp(stime)});
							rc++;
							acop="Export Excel Report functionality validation failed";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
						}
						break;
					case "TC8":
						System.out.println("TC8 Execution started.....");
						if(t.unitofMeasure(driver, Object, Object.getProperty("Commands"), Object.getProperty("CommandHistory"), Object.getProperty("DateTimeIcon"), Object.getProperty("TimeTooltip"), Object.getProperty("TimeTooltipval"), Object.getProperty("Timezone")))
						{
							System.out.println("Units displayed as expected...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Units displayed as expected...", "Pass", t.timestamp(stime)});
							rc++;
							acop="Units displayed as expected";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Units displayed incorrectly...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Units displayed incorrectly...", "Fail", t.timestamp(stime)});
							rc++;
							acop="Units displayed incorrectly";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
						}
						break;
					case "TC9":
						System.out.println("TC9 Execution started.....");
						if(t.unitofMeasure(driver, Object, Object.getProperty("Commands"), Object.getProperty("CommandHistory"), Object.getProperty("TemperatureIcon"), Object.getProperty("TempTooltip"), Object.getProperty("TempTooltipval"), Object.getProperty("TemperatureUnit")))
						{
							System.out.println("Units displayed as expected...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Units displayed as expected...", "Pass", t.timestamp(stime)});
							rc++;
							acop="Units displayed as expected";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Units displayed incorrectly...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Units displayed incorrectly...", "Fail", t.timestamp(stime)});
							rc++;
							acop="Units displayed incorrectly";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
						}
						break;
					case "TC10":
						System.out.println("TC10 Execution started.....");
						if(t.unitofMeasure(driver, Object, Object.getProperty("Commands"), Object.getProperty("CommandHistory"), Object.getProperty("FuelLevelIcon"), Object.getProperty("FuelTooltip"), Object.getProperty("FuelTooltipval"), Object.getProperty("FuelLevel")))
						{
							System.out.println("Units displayed as expected...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Units displayed as expected...", "Pass", t.timestamp(stime)});
							rc++;
							acop="Units displayed as expected";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Units displayed incorrectly...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Units displayed incorrectly...", "Fail", t.timestamp(stime)});
							rc++;
							acop="Units displayed incorrectly";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
						}
						break;
					case "TC11":
						System.out.println("TC11 Execution started.....");
						if(t.unitofMeasure(driver, Object, Object.getProperty("Commands"), Object.getProperty("CommandHistory"), Object.getProperty("DistanceCalcIcon"), Object.getProperty("DistanceTooltip"), Object.getProperty("DistanceTooltipval"), Object.getProperty("DistanceUnit")))
						{
							System.out.println("Units displayed as expected...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Units displayed as expected...", "Pass", t.timestamp(stime)});
							rc++;
							acop="Units displayed as expected";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Units displayed incorrectly...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Units displayed incorrectly...", "Fail", t.timestamp(stime)});
							rc++;
							acop="Units displayed incorrectly";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
						}
						break;
					case "TC12":
						System.out.println("TC12 Execution started.....");
						if((t.isElementPresentcheck(By.xpath(Object.getProperty("ControlProbeIcon")), driver)))
						{
							System.out.println("Controlling probe is not present...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Controlling probe is not present...", "Pass", t.timestamp(stime)});
							rc++;
							acop="Controlling probe is not present";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Controlling probe is not present...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Controlling probe is not present...", "Fail", t.timestamp(stime)});
							rc++;
							acop="Controlling probe is not present";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
						}
						break;
					case "TC13":
						System.out.println("TC13 Execution started.....");
						if(s.checkAll(driver, Object))
						{
							System.out.println("Select All Validation successful...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Select All Validation successful......", "Pass", t.timestamp(stime)});
							rc++;
							acop="Select All Validation successful";
							node.log(LogStatus.PASS, acop);
							excel.writePass(d1[i][0], counter, sheet, acop);
						}
						else
						{
							System.out.println("Select All Validation failed...");
							data.put(""+rc, new Object[] {d1[i][0], "Command History", d1[i][1], d1[i][4], "Select All Validation failed...", "Fail", t.timestamp(stime)});
							rc++;
							acop="Select All Validation failed";
							node.log(LogStatus.FAIL, acop);
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop ,scr);
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
		
		 System.out.println("---------------------------------------------------------");	
		driver.close();
		reports.endTest(node);
		reports.flush();
		return data;
	}
}