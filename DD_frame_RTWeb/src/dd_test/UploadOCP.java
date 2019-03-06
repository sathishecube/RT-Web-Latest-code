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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dd_core.TestCore;
import dd_utils.LogisticUtils;
import dd_utils.TestUtil;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadOCP extends TestCore 
{
	
	static TestUtil t =new TestUtil();
	static LogisticUtils l =new LogisticUtils();
	@Test
	public static Map<String, Object[]>ocptestcase(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase)
	{
		//TestUtil s =new TestUtil();
		String acop = null;
		int counter = 1;
		ExtentTest node = reports.startTest("UploadOCP");
		String[][] d1 = t.getData("UploadOCP");
		try
		{
			
			driver = new FirefoxDriver(t.excelDownload());
			driver.get(Object.getProperty("URL"));
			if(t.dologin(driver, d1[0][2], d1[0][3]))
			{			
				System.out.println("UploadOCP Module");
			for(int i=scase-1;i<ecase;i++)
			{
				long stime = System.currentTimeMillis();
				if(d1[i][0].equalsIgnoreCase("TC1"))
				{
					try
					{
						System.out.println( "TC1 Execution started.....");
						Thread.sleep(4000);
						driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						driver.findElement(By.xpath(Object.getProperty("UploadOCP"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);
						if(!(t.isElementPresentcheck(By.xpath(Object.getProperty("IntroduceUnit")), driver)) || !(t.isElementPresentcheck(By.xpath(Object.getProperty("GetGSMData")), driver)) || 
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("GetSATData")), driver)) ||!(t.isElementPresentcheck(By.xpath(Object.getProperty("GetUnitData")), driver)) || 
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("ScrapUnit")), driver)) ||!(t.isElementPresentcheck(By.xpath(Object.getProperty("PowerONStatusReport")), driver)) || 
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("GeofenceData")), driver)) ||!(t.isElementPresentcheck(By.xpath(Object.getProperty("ChooseFile")), driver)) || 
								!(t.isElementPresentcheck(By.xpath(Object.getProperty("SATRadioBut")), driver)) ||!(t.isElementPresentcheck(By.xpath(Object.getProperty("UploadFile")), driver)))
						{
							System.out.println("Page not loaded Successfully");
							acop = "UploadOCP Page not Loaded Successfully";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d1[i][0], "UploadOCP", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							excel.writeFail(d1[i][0], counter, sheet, acop,scr);							
						}
						else
						{	
							System.out.println("Page loaded Successfully");
							acop = "UploadOCP Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d1[i][0], "UploadOCP", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
							rc++;
							excel.writePass(d1[i][0], counter, sheet, acop);							
						}
					}catch(Exception e)
					{node.log(LogStatus.SKIP, "Skipped TC1 Execution, it is because of page loading issue or due to some other issue");
					e.printStackTrace();
					}

				}


				if(d1[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
						System.out.println( "TC2 Execution started.....");
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						driver.findElement(By.xpath(Object.getProperty("UploadOCP"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);
						
						 WebElement uploadElement = driver.findElement(By.xpath(Object.getProperty("FileUpload")));
						 uploadElement.sendKeys("C:\\Users\\sbalasubramanian\\Desktop\\New.xlsx");
						 driver.findElement(By.xpath(Object.getProperty("UploadFile"))).click();
						 
						 while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);
						
							
							String msg = driver.findElement(By.xpath(Object.getProperty("Success"))).getText();
							System.out.println(msg+"AND"+d1[i][5]);
							Thread.sleep(2000);
							
							if (msg.equals(d1[i][5]))
							{
								System.out.println("SIM File Uploaded Successfully");
								acop = "SIM File Uploaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "UploadOCP", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
							}
							else
							{
								System.out.println("SIM File Uploa Failed");
								acop = "SIM File Uploa Failed";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "UploadOCP", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
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
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
							Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("UnitAdmin"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);

						driver.findElement(By.xpath(Object.getProperty("UploadOCP"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))							
							Thread.sleep(1000);
						driver.findElement(By.xpath(Object.getProperty("SATRadioBut"))).click();
						Thread.sleep(2000);
						 WebElement uploadElement = driver.findElement(By.xpath(Object.getProperty("FileUpload")));
						 uploadElement.sendKeys("C:\\Users\\sbalasubramanian\\Desktop\\New.xlsx");
						 driver.findElement(By.xpath(Object.getProperty("UploadFile"))).click();
						 
						 while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))						
								Thread.sleep(1000);
													
							String msg = driver.findElement(By.xpath(Object.getProperty("Success"))).getText();
							System.out.println(msg);
							Thread.sleep(2000);
							
							if (msg.equals(d1[i][5]))
							{
								System.out.println("SAT File Uploaded Successfully");
								acop = "SAT File Uploaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d1[i][0], "UploadOCP", d1[i][1], d1[i][8], acop, "Pass", t.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
							}
							else
							{
								System.out.println("SAT File Uploa Failed");
								acop = "SAT File Uploa Failed";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d1[i][0], "UploadOCP", d1[i][1], d1[i][8], acop, "Fail", t.timestamp(stime)});
								rc++;
								excel.writePass(d1[i][0], counter, sheet, acop);
							}

						
						
					}catch(Exception e)
					{node.log(LogStatus.SKIP, "Skipped TC3 Execution, it is because of page loading issue or due to some other issue");
					e.printStackTrace();}
				}

								


			}
		}
	}catch(Exception e)
	{e.printStackTrace();}

	System.out.println("---------------------------------------------------------");
	driver.close();
	reports.endTest(node);
	reports.flush();

	return data;
	}
}
