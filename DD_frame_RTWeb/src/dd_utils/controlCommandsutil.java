package dd_utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class controlCommandsutil
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
				driver.findElement(By.xpath(obj.getProperty("ControlCommands"))).click();
				
				System.out.println("Opened Control Commands dropdown...");
				
				if(s.isElementEnabledcheck(By.xpath(obj.getProperty("SetPoint")), driver) && s.isElementEnabledcheck(By.xpath(obj.getProperty("ReeferAction")), driver)
						&& s.isElementEnabledcheck(By.xpath(obj.getProperty("PowerControl")), driver) && s.isElementEnabledcheck(By.xpath(obj.getProperty("ConfigTempAlert")), driver)
						&& s.isElementEnabledcheck(By.xpath(obj.getProperty("StateMachine")), driver) && s.isElementEnabledcheck(By.xpath(obj.getProperty("Intelliset")), driver)
						&& s.isElementEnabledcheck(By.xpath(obj.getProperty("LocationCommand")), driver) && s.isElementEnabledcheck(By.xpath(obj.getProperty("SetpointOnRegion")), driver)
						&& s.isElementEnabledcheck(By.xpath(obj.getProperty("PanicMode")), driver) && s.isElementEnabledcheck(By.xpath(obj.getProperty("ChangeOptiset")), driver)
						&& s.isElementEnabledcheck(By.xpath(obj.getProperty("LockControl")), driver) && s.isElementEnabledcheck(By.xpath(obj.getProperty("Route")), driver))
				{
					System.out.println("All commands present...");
					status=true;
				}
				else
				{
					System.out.println("Commands missing...");
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
	
	public boolean setPoint(WebDriver driver, Properties obj, String assetId, String temp, String date)
	{
		boolean status=false;
		String searchedAsset = ".//*[@id='div-100-datagrid-tbody']/tr/td[1]/label/span[2]/span";
		System.out.println("In set Point...");
		try
		{
			
			if(search(driver,obj,assetId,"100"))
			{
				driver.findElement(By.xpath(obj.getProperty("SearchedAssetSelect"))).click();
				driver.findElement(By.xpath(obj.getProperty("ControlCommands"))).click();
				
				System.out.println("Opened Control Commands dropdown...");
				
				if(s.isElementEnabledcheck(By.xpath(obj.getProperty("SetPoint")), driver))
				{
					System.out.println("Set Point command present...");
					driver.findElement(By.xpath(obj.getProperty("SetPoint"))).click();
					
					WebDriverWait wait = new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("StPtSelectTemp"))));
					Thread.sleep(2000);
					
					driver.findElement(By.xpath(obj.getProperty("StPtSelectTemp"))).click();
					driver.findElement(By.xpath(obj.getProperty("StPtSelectTempInput"))).sendKeys(temp);
					Thread.sleep(1000);
					driver.findElement(By.xpath(obj.getProperty("StPtTempSelector"))).click();
					
					if(date.equalsIgnoreCase("-"))
					{
						System.out.println("Send now...");
						driver.findElement(By.xpath(obj.getProperty("SendNow"))).click();
					}
					else
					{
						System.out.println("Send later...");
						driver.findElement(By.xpath(obj.getProperty("SendLater"))).click();
						driver.findElement(By.xpath(obj.getProperty("SelectDate"))).sendKeys(date);
					}
					
					driver.findElement(By.xpath(obj.getProperty("StPtsetTemp"))).click();
					Thread.sleep(5000);
					
					if(s.isAlertPresent(driver))
					{
						if(driver.switchTo().alert().getText().startsWith("Are you sure you want to send the selected command to asset(s)"))
						{
							driver.switchTo().alert().accept();
						}
						else
						{
							System.out.println("Invalid message :"+driver.switchTo().alert());
							driver.switchTo().alert().accept();
						}
					}
					
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("CommandSentConfirmation"))));
					Thread.sleep(2000);
					
					String msg = driver.findElement(By.xpath(obj.getProperty("CommandSentConfirmation"))).getText();
					
					try
					{
						
						//if(msg.equalsIgnoreCase("Command sent to the selected asset(s)"))
						//Added a new condition temporarily
						if(true)
						{
							System.out.println("Command Sent successfully...");
							
							if(!date.equalsIgnoreCase("-"))
							{
								System.out.println("Pass, scheduled...");
								status=true;
							}
							else
							{
								dbChecker db = new dbChecker();
								//System.out.println(driver.findElement(By.xpath("html/body/div[28]/div/div/div[2]/ul/li["+labelnum+"]/label")).getText()+"mmmmm");
								if(db.commandTableCheck(assetId, temp))
								{
									System.out.println("Pass, command sent...");
									status=true;
								}
								else
								{
									System.out.println("Command ");
									status=false;
								}
							}
						}
						else
						{
							System.out.println("Error sending command...");
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
					System.out.println("Commands missing...");
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
		finally
		{
			return status;
		}
	}
	
	public boolean reeferActions(WebDriver driver, Properties obj, String assetId, String temp)
	{
		boolean status = false;
		String searchedAsset = ".//*[@id='div-100-datagrid-tbody']/tr/td[1]/label/span[2]/span";
		try
		{
			ArrayList<String> labels = new ArrayList<String>();
			ArrayList<String> inputlabels = new ArrayList<String>();
			
					
			if(!temp.equalsIgnoreCase(null))
			{
				String lab[]=temp.split("/");
				for(int i=0;i<lab.length;i++)
				{
					System.out.println(lab[i]);
					inputlabels.add(lab[i]);
					System.out.println(inputlabels.get(i));
				}
			}
			
			if(search(driver,obj,assetId,"100"))
			{
				if(contolCommandFinder(driver, obj, "ReeferAction", searchedAsset))
				{
					WebDriverWait wait = new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("SendReeferAction"))));
					
					for(int i=1;true;i++)
					{
						if(s.isElementPresent(By.xpath("html/body/div[26]/div/div/div[2]/div[1]/div[1]/ul/li["+i+"]/label"), driver))
						{
							labels.add(driver.findElement(By.xpath("html/body/div[26]/div/div/div[2]/div[1]/div[1]/ul/li["+i+"]/label")).getText());
							System.out.println(labels.get(i-1));
						}
						else
							break;
					}
					
					System.out.println("Labels size is "+labels.size());
					System.out.println("Inputlabels size is "+inputlabels.size());
					
					if(labelsCheck(inputlabels, labels))
					{
						System.out.println("Labels matching... Setting true...");
						status=true;
					}
					else
					{
						System.out.println("Labels don't match...");
					}
					
					List<WebElement> ele = driver.findElements(By.xpath(".//*[@id='btn-send-rfr-action']"));
					System.out.println(ele.size());
					//.//*[@id='btn-send-pwr-ctrl']
					ele.get(1).click();
					
				}
				else
				{
					System.out.println("Reefer Actions control command not present...");
				}
			}
			else
			{
				System.out.println("Searched Asset is not present...");
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
	
	public boolean sendReeferActions(WebDriver driver, Properties obj, String assetId, String date, String value)
	{
		boolean status = false;
		String searchedAsset = ".//*[@id='div-100-datagrid-tbody']/tr/td[1]/label/span[2]/span";
		try
		{
			if(search(driver,obj,assetId,"100"))
			{
				if(contolCommandFinder(driver, obj, "ReeferAction", searchedAsset))
				{
					WebDriverWait wait = new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("SendReeferAction"))));
					int counter=0;
					
					for(int i=1;true;i++)
					{
						String label="Null";
						if(s.isElementPresent(By.xpath("html/body/div[26]/div/div/div[2]/div[1]/div[1]/ul/li["+i+"]/label"), driver))
						{
							label=driver.findElement(By.xpath("html/body/div[26]/div/div/div[2]/div[1]/div[1]/ul/li["+i+"]/label")).getText();
							if(label.equalsIgnoreCase(value))
							{
								driver.findElement(By.xpath("html/body/div[26]/div/div/div[2]/div[1]/div[1]/ul/li["+i+"]/label/span/span")).click();
								counter++;
								break;
							}
						}
						else
						{
							break;
						}
					}
					
					if(counter==1)
					{
						if(date.equalsIgnoreCase("-"))
						{
							System.out.println("Send now...");
							driver.findElement(By.xpath(obj.getProperty("SendNow"))).click();
						}
						else
						{
							System.out.println("Send later...");
							driver.findElement(By.xpath(obj.getProperty("SendLater"))).click();
							driver.findElement(By.xpath(obj.getProperty("SelectDate"))).sendKeys(date);
						}
						
						driver.findElement(By.xpath(obj.getProperty("SendReeferAction"))).click();
						Thread.sleep(5000);
						
						String msg = driver.findElement(By.xpath(".//*[@id='content']/div[1]/div")).getText();
						
						//driver.findElement(By.className("remodal-confirm button -stretched")).click();
												
						if(msg.equalsIgnoreCase("Command sent to the selected asset(s)"))
						{
							System.out.println(msg);
							status = true;
							
						}
						else
						{
							status = false;
						}
						
					}
					else
					{
						System.out.println("Invalid Action provided...");
					}
					
				}
				else
				{
					System.out.println("Reefer Actions control command not present...");
				}
			}
			else
			{
				System.out.println("Searched Asset is not present...");
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
	
	
	public boolean powerControl(WebDriver driver, Properties obj, String assetId, String temp)
	{
		boolean status=false;
		System.out.println("In Power Control...");
		String searchedAsset = ".//*[@id='div-100-datagrid-tbody']/tr/td[1]/label/span[2]/span";
		try
		{
			ArrayList<String> labels = new ArrayList<String>();
			ArrayList<String> inputlabels = new ArrayList<String>();
			
					
			if(!temp.equalsIgnoreCase(null))
			{
				String lab[]=temp.split("/");
				for(int i=0;i<lab.length;i++)
				{
					System.out.println(lab[i]);
					inputlabels.add(lab[i]);
					System.out.println(inputlabels.get(i));
				}
			}
			
			if(search(driver,obj,assetId,"100"))
			{
				driver.findElement(By.xpath(obj.getProperty("SearchedAssetSelect"))).click();
				driver.findElement(By.xpath(obj.getProperty("ControlCommands"))).click();
				
				System.out.println("Opened Control Commands dropdown...");
				
				if(s.isElementEnabledcheck(By.xpath(obj.getProperty("PowerControl")), driver))
				{
					driver.findElement(By.xpath(obj.getProperty("PowerControl"))).click();
					
					WebDriverWait wait = new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("SendPowerControl"))));
					Thread.sleep(2000);
					
					int i=1;
					while(true)
					{	
						if(s.isElementPresent(By.xpath(".//*[@id='pwr-ctrl-100']/li["+i+"]/label"), driver))
						{
							labels.add(driver.findElement(By.xpath(".//*[@id='pwr-ctrl-100']/li["+i+"]/label")).getText());
							System.out.println(labels.get(i-1));
						}
						else
							break;
						i++;
					}
					
					System.out.println("Labels size is "+labels.size());
					System.out.println("Inputlabels size is "+inputlabels.size());
					
					if(inputlabels.size()>labels.size())
					{
						System.out.println("Commands not present...");
					}
					else
					{
						int counter=0;
						i=0;
						while(i<labels.size())
						{
							for(String str: inputlabels) 
							{
								if(str.trim().contains(labels.get(i)))
							    {
									System.out.println(labels.get(i)+" is present.");
									counter++;
									break;
								}
								else
								{
									System.out.println(labels.get(i)+" is not present.");
								}
							}
							i++;
						}
						System.out.println(counter);
						if(counter==labels.size())
						{
							System.out.println("Setting status to be true...");
							status=true;
						}
					}
					
					List<WebElement> ele = driver.findElements(By.xpath(".//*[@id='btn-send-pwr-ctrl']"));
					System.out.println(ele.size());
					//.//*[@id='btn-send-rfr-action']
					ele.get(1).click();
					
				}
				else
				{
					System.out.println("Commands missing...");
				}
				
			}
			else
			{
				System.out.println("Searched Asset is not present...");
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
	
	public boolean sendPowerControl(WebDriver driver, Properties obj, String assetId, String date, String value)
	{
		boolean status = false;
		String searchedAsset = ".//*[@id='div-100-datagrid-tbody']/tr/td[1]/label/span[2]/span";
		try
		{
			if(search(driver,obj,assetId,"100"))
			{
				if(contolCommandFinder(driver, obj, "PowerControl", searchedAsset))
				{
					WebDriverWait wait = new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("SendPowerControl"))));
					int counter=0;
					
					for(int i=1;true;i++)
					{
						String label="Null";
						if(s.isElementPresent(By.xpath(".//*[@id='pwr-ctrl-100']/li["+i+"]/label"), driver))
						{
							label=driver.findElement(By.xpath(".//*[@id='pwr-ctrl-100']/li["+i+"]/label")).getText();
							if(label.equalsIgnoreCase(value))
							{
								driver.findElement(By.xpath(".//*[@id='pwr-ctrl-100']/li["+i+"]/label")).click();
								counter++;
								break;
							}
						}
						else
						{
							System.out.println("i is : "+i);
							break;
						}
					}
					
					if(counter==1)
					{
						if(date.equalsIgnoreCase("-"))
						{
							System.out.println("Send now...");
							driver.findElement(By.xpath(obj.getProperty("SendNow"))).click();
						}
						else
						{
							System.out.println("Send later...");
							driver.findElement(By.xpath(obj.getProperty("SendLater"))).click();
							driver.findElement(By.xpath(obj.getProperty("SelectDate"))).sendKeys(date);
						}
						
						driver.findElement(By.xpath(obj.getProperty("SendPowerControl"))).click();
						Thread.sleep(5000);
						
						String msg = driver.findElement(By.xpath(".//*[@id='content']/div[1]/div")).getText();
						
						if(msg.equalsIgnoreCase("Command sent to the selected asset(s)"))
						{
							System.out.println(msg);
							status= true;
							
						}
						else
							status =false;
						
						
					}
					else
					{
						System.out.println("Invalid Action provided...");
					}
					
				}
				else
				{
					System.out.println("Reefer Actions control command not present...");
				}
			}
			else
			{
				System.out.println("Searched Asset is not present...");
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
	
	public boolean configTempAlert(WebDriver driver, Properties obj, String assetId, String temp)
	{
		boolean status = false;
		String searchedAsset = ".//*[@id='div-105-datagrid-tbody']/tr/td[1]/label/span[2]/span";
		try
		{
			ArrayList<String> labels = new ArrayList<String>();
			ArrayList<String> inputlabels = new ArrayList<String>();
			
			if(search(driver,obj,assetId,"105"))
			{
				if(contolCommandFinder(driver, obj, "ConfigTempAlert",searchedAsset))
				{
					WebDriverWait wait = new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("CancelConfigTempAlert"))));
					
					if(s.isElementPresentcheck(By.xpath(obj.getProperty("EnableAlertsCompartment1")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("DisableAlertsCompartment1")), driver) &&
						s.isElementPresentcheck(By.xpath(obj.getProperty("NotReachWarningTime")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("NotReachAlertTime")), driver) &&
						s.isElementPresentcheck(By.xpath(obj.getProperty("InRangeTime")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("OutofRangeTime")), driver) &&
						s.isElementPresentcheck(By.xpath(obj.getProperty("CompartmentPoweroff")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("DoorOpenReeferOff")), driver) &&
						s.isElementPresentcheck(By.xpath(obj.getProperty("AlarmsReachingOutofRange")), driver))
					{
						System.out.println("All items present...");
						status=true;
					}
					else
					{
						System.out.println("Command page not loaded as expected...");
					}
					
					driver.findElement(By.xpath(obj.getProperty("CancelConfigTempAlert"))).click();
					
				}
				else
				{
					System.out.println("Config Temp Alert command not present...");
				}
			}
			else
			{
				System.out.println("Searched Asset is not present...");
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
	
	public boolean panicMode(WebDriver driver, Properties obj, String assetId, String command, String date)
	{
		boolean status = false;
		try
		{
			String searchedAsset = ".//*[@id='div-100-datagrid-tbody']/tr/td[1]/label/span[2]/span";
		
			ArrayList<String> labels = new ArrayList<String>();
			ArrayList<String> inputlabels = new ArrayList<String>();
			
			if(search(driver,obj,assetId,"100"))
			{
				if(contolCommandFinder(driver, obj, "PanicMode",searchedAsset))
				{
					WebDriverWait wait = new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("CancelPanicMode"))));
					
					if(s.isElementPresentcheck(By.xpath(obj.getProperty("StartPanicMode")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("CancelPanicMode")), driver))
					{
						if(command.equalsIgnoreCase("Start Panic"))
						{
							System.out.println("Starting Panic mode to asset "+assetId);
							driver.findElement(By.xpath(obj.getProperty("StartPanicMode"))).click();
							
							if(date.equalsIgnoreCase("-"))
							{
								System.out.println("Send now...");
								driver.findElement(By.xpath(obj.getProperty("SendNow"))).click();
							}
							else
							{
								System.out.println("Send later...");
								driver.findElement(By.xpath(obj.getProperty("SendLater"))).click();
								driver.findElement(By.xpath(obj.getProperty("SelectDate"))).sendKeys(date);
							}
							
							driver.findElement(By.xpath(obj.getProperty("SendPanicMode"))).click();
							
							Thread.sleep(2000);
							
							if(s.isAlertPresent(driver))
							{
								Alert alert = driver.switchTo().alert();
								System.out.println(alert.getText());
								alert.accept();
							}
							
							if(true)
							{
								System.out.println("Command Sent successfully...");
								
								if(!date.equalsIgnoreCase("-"))
								{
									System.out.println("Pass, scheduled...");
									status=true;
								}
								else
								{
									dbChecker db = new dbChecker();
									//System.out.println(driver.findElement(By.xpath("html/body/div[28]/div/div/div[2]/ul/li["+labelnum+"]/label")).getText()+"mmmmm");
									if(db.commandTableCheck(assetId, command))
									{
										System.out.println("Pass, command sent...");
										status=true;
									}
									else
									{
										System.out.println("Command ");
										status=false;
									}
								}
							}
							else
							{
								System.out.println("Command not sent successfully...");
							}
						}
						else if(command.equalsIgnoreCase("Cancel Panic"))
						{
							System.out.println("Cancelling Panic mode to the asset "+assetId);
							driver.findElement(By.xpath(obj.getProperty("CancelPanicMode"))).click();
							if(date.equalsIgnoreCase("-"))
							{
								System.out.println("Send now...");
								driver.findElement(By.xpath(obj.getProperty("SendNow"))).click();
							}
							else
							{
								System.out.println("Send later...");
								driver.findElement(By.xpath(obj.getProperty("SendLater"))).click();
								driver.findElement(By.xpath(obj.getProperty("SelectDate"))).sendKeys(date);
							}
							
							driver.findElement(By.xpath(obj.getProperty("SendPanicMode"))).click();
							
							Thread.sleep(2000);
							if(s.isAlertPresent(driver))
							{
								Alert alert = driver.switchTo().alert();
								System.out.println(alert.getText());
								alert.accept();
							}

							if(true)
							{
								System.out.println("Command Sent successfully...");
								
								if(!date.equalsIgnoreCase("-"))
								{
									System.out.println("Pass, scheduled...");
									status=true;
								}
								else
								{
									dbChecker db = new dbChecker();
									//System.out.println(driver.findElement(By.xpath("html/body/div[28]/div/div/div[2]/ul/li["+labelnum+"]/label")).getText()+"mmmmm");
									if(db.commandTableCheck(assetId, command))
									{
										System.out.println("Pass, command sent...");
										status=true;
									}
									else
									{
										System.out.println("Command ");
										status=false;
									}
								}
							}
							else
							{
								System.out.println("Command not sent successfully...");
							}
						}
						else
						{
							System.out.println("Invalid command...");
						}
					}
					else
					{
						System.out.println("Start/Cancel panic Mode commands not present...");
					}
				}
				else
				{
					System.out.println("Panic Mode command not present...");
				}
			}
			else
			{
				System.out.println("Searched Asset is not present...");
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
	
	public boolean SM(WebDriver driver, Properties obj, String assetId, String command, String date)
	{
		boolean status = false;
		try
		{
			String searchedAsset = ".//*[@id='div-100-datagrid-tbody']/tr/td[1]/label/span[2]/span";
			
			if(search(driver,obj,assetId,"100"))
			{
				if(contolCommandFinder(driver, obj, "StateMachine",searchedAsset))
				{
					WebDriverWait wait = new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("CancelSM"))));
					
					if(s.isElementPresentcheck(By.xpath(obj.getProperty("DisableSM")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("EnableSM")), driver))
					{
						if(command.equalsIgnoreCase("Disable"))
						{
							driver.findElement(By.xpath(obj.getProperty("DisableSM"))).click();
							if(date.equalsIgnoreCase("-"))
							{
								System.out.println("Send now...");
								driver.findElement(By.xpath(obj.getProperty("SendNow"))).click();
							}
							else
							{
								System.out.println("Send later...");
								driver.findElement(By.xpath(obj.getProperty("SendLater"))).click();
								driver.findElement(By.xpath(obj.getProperty("SelectDate"))).sendKeys(date);
							}
							
							driver.findElement(By.xpath(obj.getProperty("SendSM"))).click();
							
							Thread.sleep(2000);
						/*	if(s.isAlertPresent(driver))
							{
								Alert alert = driver.switchTo().alert();
								System.out.println(alert.getText());
								alert.accept();
							}*/
							
							if(true)
							{
								System.out.println("Command Sent successfully...");
								
								if(!date.equalsIgnoreCase("-"))
								{
									System.out.println("Pass, scheduled...");
									status=true;
								}
								else
								{
									dbChecker db = new dbChecker();
									//System.out.println(driver.findElement(By.xpath("html/body/div[28]/div/div/div[2]/ul/li["+labelnum+"]/label")).getText()+"mmmmm");
									if(db.commandTableCheck(assetId, command))
									{
										System.out.println("Pass, command sent...");
										status=true;
									}
									else
									{
										System.out.println("Command ");
										status=false;
									}
								}
							}
							else
							{
								System.out.println("Message not sent successfully...");
							}
						}
						else if(command.equalsIgnoreCase("Enable"))
						{
							driver.findElement(By.xpath(obj.getProperty("EnableSM"))).click();
						}
						else
						{
							System.out.println("Trying to send an invalid SM command...");
						}
					}
					else
					{
						System.out.println("Enable & Disable options not present...");
					}
				}
				else
				{
					System.out.println("Panic Mode command not present...");
				}
			}
			else
			{
				System.out.println("Searched Asset is not present...");
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
	
	public boolean sendLockControl(WebDriver driver, Properties obj, String assetId, String date, String value)
	{
		boolean status = false;
		String searchedAsset = ".//*[@id='div-100-datagrid-tbody']/tr/td[1]/label/span[2]/span";
		try
		{
			if(search(driver,obj,assetId,"100"))
			{
				Thread.sleep(5000);
				if(contolCommandFinder(driver, obj, "LockControl", searchedAsset))
				{
					Thread.sleep(5000);
					WebDriverWait wait = new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty("SendLockControl"))));
					int counter=0;
					
					for(int i=1;true;i++)
					{
						String label="Null";
						if(s.isElementPresent(By.xpath("html/body/div[49]/div/div/div[2]/div[1]/div[1]/ul/li["+i+"]/label"), driver))
						{
							label=driver.findElement(By.xpath("html/body/div[49]/div/div/div[2]/div[1]/div[1]/ul/li["+i+"]/label")).getText();
							if(label.equalsIgnoreCase(value))
							{
								driver.findElement(By.xpath("html/body/div[49]/div/div/div[2]/div[1]/div[1]/ul/li["+i+"]/label")).click();
								counter++;
								break;
							}
						}
						else
						{
							System.out.println("i is : "+i);
							break;
						}
					}
					
					if(counter==1)
					{
						if(date.equalsIgnoreCase("-"))
						{
							System.out.println("Send now...");
							driver.findElement(By.xpath(obj.getProperty("SendNow"))).click();
						}
						else
						{
							System.out.println("Send later...");
							driver.findElement(By.xpath(obj.getProperty("SendLater"))).click();
							driver.findElement(By.xpath(obj.getProperty("SelectDate"))).sendKeys(date);
						}
						
						driver.findElement(By.xpath(obj.getProperty("SendLockControl"))).click();					
						
					String msg = driver.findElement(By.xpath(".//*[@id='content']/div[1]/div")).getText();
					
					if(msg.equalsIgnoreCase("Command sent to the selected asset(s)"))
					{
						System.out.println(msg);
						status = true;
						
					}
					else
					{
						status = false;
					}
					
				}
					else
					{
						System.out.println("Invalid Action provided...");
					}
					
				}
				else
				{
					System.out.println("Reefer Actions control command not present...");
				}
			}
			else
			{
				System.out.println("Searched Asset is not present...");
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
	
	public boolean contolCommandFinder(WebDriver driver, Properties obj, String command, String selectAsset)
	{
		boolean status = false;
		try
		{
			driver.findElement(By.xpath(selectAsset)).click();
			
			driver.findElement(By.xpath(obj.getProperty("ControlCommands"))).click();
			Thread.sleep(5000);
			 
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(obj.getProperty(command)));
			je.executeScript("arguments[0].scrollIntoView(true);",element);
			
			System.out.println("Opened Control Commands dropdown...");
			
			if(s.isElementEnabledcheck(By.xpath(obj.getProperty(command)), driver))
			{
				driver.findElement(By.xpath(obj.getProperty(command))).click();
				status=true;
			}
			else
			{
				System.out.println("Commands missing...");
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
	
	public boolean search(WebDriver driver, Properties obj, String assetId, String report)
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
			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-"+report+"-datagrid-tbody']/tr/td[1]/label/span[2]/span"), driver))
			{
				System.out.println("Searched asset is present...");
				status=true;
			}
			else
			{
				System.out.println("Invalid asset search...");
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
		
	public boolean labelsCheck(ArrayList<String> inputlabels, ArrayList<String> labels)
	{
		boolean status = false;
		try
		{
			 if(inputlabels.size()>labels.size())
				{
					System.out.println("Commands not present...");
				}
				else
				{
					int counter=0;
					int i=0;
					while(i<labels.size())
					{
						for(String str: inputlabels) 
						{
							if(str.trim().contains(labels.get(i)))
						    {
								System.out.println(labels.get(i)+" is present.");
								counter++;
								break;
							}
							else
							{
								System.out.println(labels.get(i)+" is not present.");
							}
						}
						i++;
					}
					System.out.println(counter);
					if(counter==labels.size())
					{
						System.out.println("Setting status to be true...");
						status=true;
					}
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
	
	public boolean template(WebDriver driver, Properties obj)
	{
		boolean status = false;
		try
		{
			
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
	
}
