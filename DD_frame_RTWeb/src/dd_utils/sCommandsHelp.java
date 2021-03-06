package dd_utils;
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
import java.util.Properties;
import java.util.TreeMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class sCommandsHelp 
{
	TestUtil s =new TestUtil();
	
	public boolean pageCheck(WebDriver driver, Properties obj)
	{	
		boolean status=false;
		try
		{
			if(s.isElementPresentcheck(By.xpath(obj.getProperty("Searchbox")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("Editdaterange")),driver)
					&& s.isElementPresentcheck(By.xpath(obj.getProperty("RefreshReport")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("Printthispage")),driver)
					&& s.isElementPresentcheck(By.xpath(obj.getProperty("PageNumber")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("DateTimeIcon")),driver)
					&& s.isElementPresentcheck(By.xpath(obj.getProperty("TemperatureIcon")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("FuelLevelIcon")),driver)
					&& s.isElementPresentcheck(By.xpath(obj.getProperty("DistanceCalcIcon")), driver) && s.isElementPresentcheck(By.xpath(obj.getProperty("ControlProbeIcon")),driver))
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
		catch(Exception e)
		{
			
		}
		finally
		{
			return status;
		}
	}
	
	public boolean search(WebDriver driver, Properties obj, String assetId)
	{
		boolean status = false;
		try
		{
			driver.findElement(By.xpath(obj.getProperty("Searchbox"))).clear();
			driver.findElement(By.xpath(obj.getProperty("Searchbox"))).sendKeys(assetId);
			driver.findElement(By.xpath(obj.getProperty("Searchbutton"))).click();
			if(s.isAlertPresent(driver))
			{
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				return false;
			}
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(2000);
			}
			String AssetId="Null";
			if(s.isElementPresentcheck(By.xpath(".//*[@id='div-305-datagrid-tbody']/tr/td[2]/a"), driver))
			{
				System.out.println("Search returned a result... Checking...");
				AssetId = driver.findElement(By.xpath(".//*[@id='div-305-datagrid-tbody']/tr/td[2]/a")).getText();
				AssetId=s.cutString(AssetId, "\n");
			
				if(assetId.equalsIgnoreCase(AssetId))
				{
					System.out.println("Asset Id Matching...");
					status=true;
				}
				else
				{
					System.out.println("Fail");
					status = false;
				}
			}
			else
			{
				System.out.println("Fail...");
				status=false;
			}
			if(s.isElementPresentcheck(By.xpath(obj.getProperty("ClearButton")), driver))
			{
				driver.findElement(By.xpath(obj.getProperty("ClearButton"))).click();
				if(s.isAlertPresent(driver))
				{
					Alert alert = driver.switchTo().alert();
					if(alert.getText().equalsIgnoreCase("Are you sure you want to clear search?"))
					{
						System.out.println("Clear Successful...");
						//status=true;
					}
					alert.accept();
				}
				else
				{
					status = false;
					
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
	
	public boolean editDate(WebDriver driver, Properties obj, String sDate, String eDate)
	{
		boolean status=false;
		
		try
		{
			
			driver.findElement(By.xpath(obj.getProperty("Editdaterange"))).click();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath(obj.getProperty("StartDate"))).isDisplayed() && driver.findElement(By.xpath(obj.getProperty("EndDate"))).isDisplayed()
					 && driver.findElement(By.xpath(obj.getProperty("SetDateRange"))).isDisplayed() && driver.findElement(By.xpath(obj.getProperty("DateCancel"))).isDisplayed())
			{
				System.out.println("Edit date range pop up displayed Successfully");
				if(sDate.equalsIgnoreCase("NA"))
				{
					System.out.println("Test Case successful...");
					status=true;
					driver.findElement(By.xpath(obj.getProperty("DateCancel"))).click();
					Thread.sleep(2000);
				}
				else
				{
					driver.findElement(By.xpath(obj.getProperty("StartDate"))).sendKeys(sDate);
					driver.findElement(By.xpath(obj.getProperty("EndDate"))).sendKeys(eDate);
					driver.findElement(By.xpath(obj.getProperty("SetDateRange"))).click();
					String strMain = driver.findElement(By.xpath(obj.getProperty("DateRangeDisplay"))).getText();
					System.out.println("Date range displayed as expected");
					
					String[] arrSplit = strMain.split(" to ");
					int chkIndex=0;
					String TotalPages =driver.findElement(By.xpath(obj.getProperty("GetNoOfPages"))).getText();
					System.out.println(TotalPages);
					String Records="Null";
					if(TotalPages.contains(" of "))
					{
						chkIndex=TotalPages.indexOf(" of ");
						Records = TotalPages.substring(chkIndex+4);
						System.out.println(Records);
					}
					
					if(Records.equalsIgnoreCase("0"))
					{
						System.out.println("No data present for the date range...");
						status=true;
					}
					else
					{
						String EndDateGet = driver.findElement(By.xpath(obj.getProperty("SCSentTimeVal"))).getText();
						driver.findElement(By.xpath(obj.getProperty("SCSentTime"))).click();
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						{
							Thread.sleep(2000);
						}
						
						String StartDateGet = driver.findElement(By.xpath(obj.getProperty("SCSentTimeVal"))).getText();
						System.out.println(EndDateGet);
						System.out.println(StartDateGet);
						
						StartDateGet=s.cutString(StartDateGet, "\n");
						EndDateGet=s.cutString(EndDateGet, "\n");
						
						System.out.println("StartDate="+StartDateGet);
						System.out.println("EndDate="+EndDateGet);
						
						DateFormat df = new SimpleDateFormat("MM-dd-yy");
						Date date1=df.parse(StartDateGet);
						Date date2=df.parse(EndDateGet);
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
				        String StartDate = sdf.format(date1);
				        String EndDate = sdf.format(date2);
						System.out.println("Converted to"+StartDate);
						System.out.println("Converted to"+EndDate);
						
						if(s.dateCompare(sDate, eDate, StartDate)==1 && s.dateCompare(sDate, eDate, EndDate)==1 )
						{
							
							System.out.println("Date within range");
							status=true;
							//driver.findElement(By.xpath(obj.getProperty("DateCancel"))).click();
	  					}
	  					else
	  					{
	  						System.out.println("Search value not displayed ");
							status=false;
							driver.findElement(By.xpath(obj.getProperty("DateCancel"))).click();
	  					}
					}
				}
			}
			else
			{
				status=false;
			}
			
			driver.findElement(By.xpath(obj.getProperty("Editdaterange"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(obj.getProperty("ClearDaterange"))).click();
			
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(2000);
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
	
	public boolean refresh(WebDriver driver, Properties obj)
	{
		sCommandsHelp help = new sCommandsHelp();
		boolean status=false;
		try
		{
			driver.findElement(By.xpath(".//*[@id='btnRefreshReport']")).click();
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				Thread.sleep(2000);
			if(help.loadDashboard(driver, obj))
				status=help.pageCheck(driver, obj);
			else
				status=false;
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
	
	public boolean loadDashboard(WebDriver driver, Properties obj)
	{
		boolean status=false;
		try
		{
			if(s.isElementPresentcheck(By.xpath(obj.getProperty("SCHeaderReefer")),driver)	&& s.isElementPresentcheck(By.xpath(obj.getProperty("SCHeaderCommand")),driver) 
					&& s.isElementPresentcheck(By.xpath(obj.getProperty("SCHeaderCreatedTime")),driver)	&& s.isElementPresentcheck(By.xpath(obj.getProperty("SCHEaderScheduleTimer")),driver) 
					&& s.isElementPresentcheck(By.xpath(obj.getProperty("SCHeaderScheduleBy")),driver)	&& s.isElementPresentcheck(By.xpath(obj.getProperty("SCHeaderScheduledStatus")),driver))
			{
				System.out.println("Dashboard loaded Successfully");
				status=true;
			}
			else
			{
				System.out.println("Dashboard not loaded Successfully");
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
	
	public boolean printReport(WebDriver driver, Properties obj)
	{
		boolean status=false;
		try
		{
			driver.findElement(By.xpath(obj.getProperty("PrintIcon"))).click();
			
			Thread.sleep(5000);
			
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			
			System.out.println(tabs2.get(0));
			System.out.println(driver.getWindowHandle());
			
			driver.switchTo().window(tabs2.get(1));
			
			System.out.println(tabs2.get(1));
			System.out.println(driver.getWindowHandle());
			
			if(s.isElementPresentcheck(By.xpath("html/body/table"), driver))
			{
				System.out.println("Print page displayed");
				status=true;
			}
			else
			{
				System.out.println("Print page not displayed");
				status=false;
			}
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(200);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			driver.close(); 
			driver.switchTo().window(tabs2.get(0));
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
	
	public boolean saveAs(WebDriver driver, Properties obj)
	{
		boolean status = false;
		try
		{
			driver.findElement(By.xpath(obj.getProperty("Downloadthispage"))).click();
			Thread.sleep(5000);
			BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\RT_Web_Automation_Excel_Download\\ScheduledCommandsReport.xls"));
			String line;
			ArrayList<String> tr=new ArrayList<String>();
			int i=0;
			while ((line = reader.readLine()) != null)
			{
				//System.out.println(line);
				//records.add(line);
				if(line.contains("<tr"))
					tr.add(line);
				//System.out.println(records.get(i));
				i++;
			}
			reader.close();
			System.out.println(tr.size());
			for(i=0;i<tr.size();i++)
				System.out.println(tr.get(i));
			System.out.println(tr.size());
			
			int recordsCount = tr.size()-2;
			WebElement ele = driver.findElement(By.xpath(".//*[@id='div-305-datagrid-tbody']"));
			List<WebElement> trCount = ele.findElements(By.tagName("tr"));
			if(recordsCount == trCount.size())
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
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return status;
		}
	}
	
	public boolean checkAll(WebDriver driver, Properties obj)
	{
		boolean status=false;
		try
		{
			{
                driver.findElement(By.xpath(obj.getProperty("SCSelectAll"))).click();
                while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
                {
                      
                       System.out.println("inside while");
                       Thread.sleep(1000);
                }
                List <WebElement> selectElements= driver.findElements(By.cssSelector(".cls-checked"));
                System.out.println(">>>>>>>>>>>>>>>"+selectElements.size());
                int rowCount = 0;
                Map<String,String> arr = new TreeMap<>();
                //ArrayList <String> arrRowList = new ArrayList <String>();
                for(int ij=0;ij<selectElements.size();ij++)
                {                                                     
                       System.out.println("id::>>"+ij+"<<"+selectElements.get(ij).getAttribute("id"));

                       if( (selectElements.get(ij).isSelected())&&!(selectElements.get(ij).getAttribute("id").equalsIgnoreCase(""))&&!(selectElements.get(ij).getAttribute("id").startsWith("select-All-Column")))
                       {
                      System.out.println("Check box selected");
                      rowCount = rowCount + 1;
                      //arrRowList.add(selectElements.get(ij).getAttribute("id"));
                      arr.put(selectElements.get(ij).getAttribute("id"), selectElements.get(ij).getAttribute("id"));
                    }
                    else
                    {
                       System.out.println("Check box NOT selected");
                    }
                      
                }
                System.out.println("row count:"+ rowCount);
                System.out.println("Map Size: "+arr.size());
                String chkVal = driver.findElement(By.xpath(obj.getProperty("DAGetNoOfPages"))).getText();
                String [] getVal = chkVal.split(" - ");
                System.out.println(getVal[1]);
                String [] finalVal = getVal[1].split(" of ");
                System.out.println(finalVal[0]);
                if (finalVal[0].equals(""+arr.size()))
                {
                       System.out.println("Select All is working as expected");
                       status=true;
                }
                else
                {
                       System.out.println(" Per page not loaded");
                       status=false;
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
}
