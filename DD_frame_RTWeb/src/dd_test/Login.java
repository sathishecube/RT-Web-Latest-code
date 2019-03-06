package dd_test;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dd_core.TestCore;
import dd_utils.TestUtil;

public class Login extends TestCore 
{
	static TestUtil t =new TestUtil();
		
	@Test
	public static Map<String, Object[]> testcases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test, int scase,int ecase) throws Exception //throws IOException, InterruptedException
	{
		try
		{
			String acop =null;		
		int counter =1;
		
		ExtentTest node = reports.startTest("Login");
		String[][] d1 =TestUtil.getData("Login");
		System.out.println("Login Module");
		
		for(int i=scase-1;i<ecase;i++ )
		{	
			long stime=System.currentTimeMillis();
			if(d1[i][0].equalsIgnoreCase("TC1"))
			{	
				try
				{
				  System.out.println("TC1 Execution started.....");
				  driver = new FirefoxDriver();
				  driver.get(Object.getProperty("URL"));				  
				  t.dologin(driver ,d1[i][2], d1[i][3]);
				  Thread.sleep(5000);
				  
				  while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))				
					  Thread.sleep(2000);
			
				  if(t.isElementPresentcheck(By.xpath(".//*[@id='div-100-sub-lnk']"), driver))
				  {				  
					acop = "Fleet Status Page Loaded Successfully";
					node.log(LogStatus.PASS, acop);
					data.put(""+rc, new Object[] {d1[i][0], "Login", d1[i][1], d1[i][4], acop, "Pass", t.timestamp(stime)});
					rc++;
					excel.writePass(d1[i][0], counter, sheet, acop);					
					
					Thread.sleep(1000);
					driver.findElement(By.xpath(Object.getProperty("ReeferTrak"))).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(Object.getProperty("Logout"))).click();
					Thread.sleep(1000);
					
					if(t.isAlertPresent(driver))
					{
						driver.switchTo().alert().accept();
					}
					else
					{				
						acop = "Fleet Status Page not Loaded Successfully";
						node.log(LogStatus.FAIL, acop);						
						data.put(""+rc, new Object[] {d1[i][0], "Login",  d1[i][1], d1[i][4], acop, "Fail", t.timestamp(stime)});
						rc++;
						String scr = t.CaptureScreenshot();
						excel.writeFail(d1[i][0], counter, sheet, acop ,scr);					
						
					}
					}
			  else
				{
					
					acop = "Fleet Status Page not Loaded Successfully";
					node.log(LogStatus.FAIL, acop);
					data.put(""+rc, new Object[] {d1[i][0], "Login",  d1[i][1], d1[i][4], acop, "Fail", t.timestamp(stime)});
					rc++;
					String scr = t.CaptureScreenshot();					 
					excel.writeFail(d1[i][0], counter, sheet, acop ,scr);					
					
				}
				}catch(Exception e)
				{node.log(LogStatus.SKIP, "Skipped TC1 Execution, it is because of page loading issue or due to some other issue");
				e.printStackTrace();}
				
			  	driver.close();
			 }
	
		  if(d1[i][0].equalsIgnoreCase("TC2"))
		  {	
			  try
			  {

				  System.out.println("TC2 Execution started.....");
				  driver = new FirefoxDriver();
				  driver.get(Object.getProperty("URL"));
			  	  WebDriverWait wait = new WebDriverWait(driver,20);
			  	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object.getProperty("UserID"))));
			  	  t.dologin(driver,d1[i][2], d1[i][3]);
			  	  while(t.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			  		  Thread.sleep(1000);
			  
			  	  if(t.isElementPresentcheck(By.xpath(".//*[@id='errorMsg']"), driver))
			  	  {
			  		  System.out.println(driver.findElement(By.xpath(".//*[@id='errorMsg']")).getText());
			  		  acop = driver.findElement(By.xpath(".//*[@id='errorMsg']")).getText();
			  		  node.log(LogStatus.PASS, acop);
			  	  }
			  	  else
			  	  {
			  		  acop = "Login Successful";
			  		  node.log(LogStatus.FAIL, acop);
			  		  String screen =t.CaptureScreenshot();
			  		  Thread.sleep(1000);
			  		  driver.findElement(By.xpath(Object.getProperty("Logout"))).click();
			  	  }
			  	  
			  	  if(acop.equalsIgnoreCase(d1[i][4]))
			  	  {
			  		 
			  		  data.put(""+rc, new Object[] {d1[i][0], "Login", d1[i][1], d1[i][4], acop, "Pass", t.timestamp(stime)});
			  		  rc++;
			  		  excel.writePass(d1[i][0], counter, sheet, acop);			  		  
			  	  }
				else
				{
					data.put(""+rc, new Object[] {d1[i][0], "Login", d1[1][1], d1[i][4], acop, "Fail", t.timestamp(stime)});
					rc++;
					String scr = t.CaptureScreenshot();
					excel.writeFail(d1[i][0], counter, sheet, acop,scr);				
				}
			  }catch(Exception e)
				{node.log(LogStatus.SKIP, "Skipped TC2 Execution, it is because of page loading issue or due to some other issue");
				e.printStackTrace();}
		  }
		  
		}
		
		reports.endTest(node);
		reports.flush();
		
		}catch(Exception e)
		{e.printStackTrace();}
		finally
		{
		System.out.println("---------------------------------------------------------");
		 driver.close();
		return data;
		}
		  }
	
}
	

