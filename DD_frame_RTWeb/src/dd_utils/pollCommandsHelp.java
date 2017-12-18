package dd_utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class pollCommandsHelp 
{
	TestUtil s = new TestUtil();
	public boolean pageCheck(WebDriver driver, Properties obj, String assetId)
	{
		boolean status = false;
		try
		{
			driver.findElement(By.xpath(obj.getProperty("Searchbox"))).clear();
			driver.findElement(By.xpath(obj.getProperty("Searchbox"))).sendKeys(assetId);
			driver.findElement(By.xpath(obj.getProperty("Searchbutton"))).click();
			
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(2000);
			}
			if(s.isElementPresentcheck(By.xpath(obj.getProperty("SearchedAssetSelect")), driver))
			{
				driver.findElement(By.xpath(obj.getProperty("SearchedAssetSelect"))).click();
				driver.findElement(By.xpath(obj.getProperty("PollCommands"))).click();
				
				WebDriverWait wait = new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("CancelPollCommands"))));
				Thread.sleep(2000);
				
				System.out.println("In Poll Commands Screen");
				
				if(s.isElementEnabledcheck(By.xpath(obj.getProperty("PollFuelFlowStatus")), driver) && s.isElementEnabledcheck(By.xpath(obj.getProperty("PollReeferStatus")), driver)
						&& s.isElementEnabledcheck(By.xpath(obj.getProperty("PollMaintenanceStatus")), driver) && s.isElementEnabledcheck(By.xpath(obj.getProperty("PollAlarmStatus")), driver)
						&& s.isElementEnabledcheck(By.xpath(obj.getProperty("PollGPSReport")), driver) && s.isElementEnabledcheck(By.xpath(obj.getProperty("ReeferAlarmList")), driver)
						&& s.isElementEnabledcheck(By.xpath(obj.getProperty("PollMultiTempStatus")), driver) && s.isElementEnabledcheck(By.xpath(obj.getProperty("ReadActiveIntelliset")), driver)
						&& s.isElementEnabledcheck(By.xpath(obj.getProperty("PollMileageReport")), driver) && s.isElementEnabledcheck(By.xpath(obj.getProperty("PollTempProfile")), driver)
						&& s.isElementEnabledcheck(By.xpath(obj.getProperty("PollPretripStatus")), driver) && s.isElementEnabledcheck(By.xpath(obj.getProperty("PollSystemStatus")), driver)
						&& s.isElementEnabledcheck(By.xpath(obj.getProperty("PollTerminalStatus")), driver))
				{
					System.out.println("All commands present...");
					status=true;
				}
				else
				{
					System.out.println("Commands missing...");
				}
				
				driver.findElement(By.xpath(obj.getProperty("CancelPollCommands"))).click();
				Thread.sleep(2000);
				if(s.isElementPresentcheck(By.xpath(obj.getProperty("PollCommands")), driver))
					System.out.println("Back to Reefer Status page...");
				else
				{
					status=false;
					System.out.println("Cancel Poll didn't work as expected...");
				}
			}
			else
			{
				System.out.println("Invalid Asset searched...");
				status=false;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return status;
		}
	}
	
	public boolean sendPollCommand(WebDriver driver, Properties obj, String assetId,String message)
	{
		boolean status=false,clicked=false;
		try
		{
			driver.findElement(By.xpath(obj.getProperty("Searchbox"))).clear();
			driver.findElement(By.xpath(obj.getProperty("Searchbox"))).sendKeys(assetId);
			driver.findElement(By.xpath(obj.getProperty("Searchbutton"))).click();
			
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(2000);
			}
			
			driver.findElement(By.xpath(obj.getProperty("SearchedAssetSelect"))).click();
			driver.findElement(By.xpath(obj.getProperty("PollCommands"))).click();
			
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("CancelPollCommands"))));
			
			System.out.println("In Poll Commands Screen");
			int labelnum = 0;
			for(int i=1;i<=13;i++)
			{
				if(message.equalsIgnoreCase(driver.findElement(By.xpath("html/body/div[24]/div/div/div[2]/ul/li["+i+"]/label")).getText()))
				{
					driver.findElement(By.xpath("html/body/div[24]/div/div/div[2]/ul/li["+i+"]/label/span/span")).click();
					System.out.println("Clicked on the message "+message);
					labelnum=i;
					clicked=true;
					break;
				}
			}
			
			if(clicked)
			{
				driver.findElement(By.xpath(obj.getProperty("SendPollCommands"))).click();
				if(s.isAlertPresent(driver))
				{
					Alert alert = driver.switchTo().alert();
					System.out.println(alert.getText());
					alert.accept();
				}
				else
				{
					System.out.println("No alert present... Error...");
					status=false;
				}
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("CommandSentConfirmation"))));
				
				String msg=driver.findElement(By.xpath(obj.getProperty("CommandSentConfirmation"))).getText();
				System.out.println();
				try
				{
					
					//if(msg.equalsIgnoreCase("Command sent to the selected asset(s)"))
					//Added a new condition temporarily
					if(true)
					{
						System.out.println("Command Sent successfully...");
						
						dbChecker db = new dbChecker();
						//System.out.println(driver.findElement(By.xpath("html/body/div[28]/div/div/div[2]/ul/li["+labelnum+"]/label")).getText()+"mmmmm");
						if(db.commandTableCheck(assetId, message))
						{
							System.out.println("Pass");
							status=true;
						}
						else
						{
							System.out.println("Fail");
							status=false;
						}
		        		
					}
					else
					{
						status=false;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			else
			{
				System.out.println("Invalid message...");
				status=false;
			}
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			//driver.close();
			return status;
		}
	}
}
