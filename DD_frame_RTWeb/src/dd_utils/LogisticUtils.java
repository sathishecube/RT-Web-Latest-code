package dd_utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogisticUtils 
{
	
	TestUtil s = new TestUtil();
	public boolean disparity(WebDriver driver, Properties obj, String strReportCode, String selFilterOption, String columnToCheck, boolean isSendKeyPresent, String columnType, String xPathApplyButton,String clearButton)
	{
		boolean status = true;
		try{
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(1000);
			}
				WebElement ele = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"-"+strReportCode+"']"));
				System.out.println(ele);
				System.out.println(ele.getTagName());
				List<WebElement>page=ele.findElements(By.tagName("option"));
				System.out.println("<<<<<<<<<<<<<"+page.size());
				for (int k=2; k<=page.size();k++)
				{			
					if (s.isElementPresent(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button"), driver))
					{
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						{
  							Thread.sleep(1000);	
  						}
					}
					System.out.println("selFilterOption"+selFilterOption+"reportCode"+strReportCode);
					driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/a/span")).click();
					Thread.sleep(1000);
					String SelVal = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).getAttribute("innerText");
					System.out.println(">>>>>>>>>>>>>"+SelVal);
					if (isSendKeyPresent){
						driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/div/input")).sendKeys(SelVal);
						driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li[1]")).click();
					}else{
						driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).click();
					}
					driver.findElement(By.xpath(obj.getProperty(xPathApplyButton))).click();
					
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						{
							Thread.sleep(1000);
						}
					int chkIndex=0;
					String TotalPages =driver.findElement(By.xpath(obj.getProperty("DAGetNoOfPages"))).getText();
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
						System.out.println("No Record Found for "+SelVal);
						String acop = "No Record Found";
							driver.findElement(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button")).click();
							Thread.sleep(2000);
					}
					else
					{
						WebElement chk = driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']"));
						System.out.println(chk.getTagName());
						List<WebElement>tag=chk.findElements(By.tagName("tr"));
						System.out.println("%%%%%%%%%%%%"+tag.size());
						String Records1 = "Null";
						String strXPathSingleRow = "Null";
						String strXPathMultipleRow = "Null";
						String rowValue = "";	
						String clsattr ="";
						for (int n1 = 1;n1<=tag.size();n1++)
						{						
							if (SelVal.equals("Active Disparity"))
							{
								System.out.println(driver.findElement(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]/a/span")).getText());
								rowValue = driver.findElement(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]/a/span")).getText();
								clsattr =driver.findElement(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]/a/span")).getAttribute("class");
							}
							else
							{
								//strXPathMultipleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]";
							System.out.println(driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]")).getText());
							rowValue = driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]")).getText();
							clsattr =driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]")).getAttribute("class");
							}
						
							if (rowValue.equals("Active Disparity")){
								rowValue = " Assets with disparity";}	
							
							else if (rowValue.equals("-")){
								rowValue = "Asset without disparity";}

							
							if (rowValue.contains(SelVal))
							{				
								status = true;
								//System.out.println(status);
							}
							else
							{
								status = false;	
								//System.out.println(status);
							}
						}
						System.out.println(status);;
					driver.findElement(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button")).click();
					Thread.sleep(2000);
					}
				}
				s.clearFilter(driver, obj, clearButton);
				Thread.sleep(1000);
				
	}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		return status;
		}
						
	}
	
	
	public boolean analyticsFilter(WebDriver driver, Properties obj, String strReportCode, String selFilterOption, String columnToCheck, boolean isSendKeyPresent, String columnType, String xPathApplyButton,String clearButton)
	{
		boolean status = true;
		try{
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(1000);
			}
				WebElement ele = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"']"));
				//WebElement ele = driver.findElement(By.xpath(".//*[@id='OEMFilter']"));
				System.out.println(ele);
				System.out.println(ele.getTagName());
				List<WebElement>page=ele.findElements(By.tagName("option"));
				System.out.println("<<<<<<<<<<<<<"+page.size());
				for (int k=2; k<=page.size();k++)
				{			
					if (s.isElementPresent(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button"), driver))
					{
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						{
  							Thread.sleep(1000);	
  						}
					}
					System.out.println("selFilterOption"+selFilterOption+"reportCode"+strReportCode);
					driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_chosen']/a/span")).click();
					Thread.sleep(1000);
					String SelVal = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_chosen']/div/ul/li["+k+"]")).getAttribute("innerText");
					System.out.println(">>>>>>>>>>>>>"+SelVal);
					if (isSendKeyPresent){
						driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_chosen']/div/div/input")).sendKeys(SelVal);
						driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_chosen']/div/ul/li[1]")).click();
					}else{
						driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_chosen']/div/ul/li["+k+"]")).click();
					}
					driver.findElement(By.xpath(obj.getProperty(xPathApplyButton))).click();
					
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						{
							Thread.sleep(1000);
						}
					int chkIndex=0;
					String TotalPages =driver.findElement(By.xpath(obj.getProperty("DAGetNoOfPages"))).getText();
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
						System.out.println("No Record Found for "+SelVal);
						String acop = "No Record Found";
							driver.findElement(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button")).click();
							Thread.sleep(2000);
					}
					else
					{
						WebElement chk = driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']"));
						System.out.println(chk.getTagName());
						List<WebElement>tag=chk.findElements(By.tagName("tr"));
						System.out.println("%%%%%%%%%%%%"+tag.size());
						String Records1 = "Null";
						String strXPathSingleRow = "Null";
						String strXPathMultipleRow = "Null";
						String rowValue = "";	
						String clsattr ="";
						for (int n1 = 1;n1<=tag.size();n1++)
						{						
							if (SelVal.equals("Active Disparity"))
							{
								System.out.println(driver.findElement(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]/a/span")).getText());
								rowValue = driver.findElement(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]/a/span")).getText();
								clsattr =driver.findElement(By.xpath(".//*[@id='div-100-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]/a/span")).getAttribute("class");
							}
							else
							{
								//strXPathMultipleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]";
							System.out.println(driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]")).getText());
							rowValue = driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]")).getText();
							clsattr =driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]")).getAttribute("class");
							}
						
							if (rowValue.equals("Active Disparity")){
								rowValue = " Assets with disparity";}	
							
							else if (rowValue.equals("CT")){
								rowValue = "Carrier";}
							else if (rowValue.equals("TK")){
								rowValue = "ThermoKing";}
							else if (rowValue.equals("ST")){
								rowValue = "Single-Temp";}
							else if (rowValue.equals("MT")){
								rowValue = "Multi-Temp";}
							else if (rowValue.equals("SS/CS")){
								rowValue = "Start/Stop";}
							else if (rowValue.equals("CONT")){
								rowValue = "Continuous";}
							else if (rowValue.equals("CONT")){
								rowValue = "Continuous";}
							else if (rowValue.equals("MIXED")){
								rowValue = "Mixed";}

							
							if (rowValue.contains(SelVal))
							{				
								status = true;
								//System.out.println(status);
							}
							else
							{
								status = false;	
								//System.out.println(status);
							}
						}
						System.out.println(status);;
					driver.findElement(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button")).click();
					Thread.sleep(2000);
					}
				}
				s.clearFilter(driver, obj, clearButton);
				Thread.sleep(1000);
				
	}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		return status;
		}
						
	}
	



	static ArrayList<Integer> indexOfAll(Object obj, ArrayList list)
	  {
		    ArrayList<Integer> indexList = new ArrayList<Integer>();
		    for (int i = 0; i < list.size(); i++)
		        if(obj.equals(list.get(i)))
		            indexList.add(i);
		    return indexList;
		}
	
	public boolean dwellNumber(String[] ChkReefers) 
	{
		boolean status=true;
		Integer[] intarray=new Integer[ChkReefers.length];
		Integer[] chkarray=new Integer[ChkReefers.length];
		int i=0,chk=0;
			for(String str:ChkReefers)
			{
				chk=0;
				if(str.equalsIgnoreCase("-") || str.length() == 0 || str.equalsIgnoreCase(" "))
				{
					str = "-2147483648";
					chk=1;
				}
					
				for(int j=0;j<str.length();j++)
				{
					char test = str.charAt(j);
					System.out.println(j+":"+(int) test);
			
					if((int)test>=48 && (int)test<=57 || (int) test==45)
					{
						System.out.println("Test val : "+test);
					}
					else
					{
						System.out.println("Test is : "+test);
						str=str.substring(0,j);
						break;
					}
			
				}
				if(chk==1)
				{
					intarray[i]=Integer.parseInt(str.trim());//Exception in this line
					chkarray[i]=Integer.parseInt(str.trim());//Exception in this line
				}
				else
				{
					chkarray[i]=Integer.parseInt(str.trim());//Exception in this line
					intarray[i]=Integer.parseInt(str.trim());//Exception in this line
				}
				
				i++;
			}
			for(int j=0;j<intarray.length;j++)
			{
				System.out.println(":::::::::::::Int Values"+intarray[j]);
				System.out.println(":::::::::::::Int Values"+chkarray[j]);
			}
			   
			Arrays.sort(intarray, new Comparator<Integer>(){@Override public int compare(Integer x, Integer y){return x - y;}});
		   
			for(int j=0;j<intarray.length;j++)
			{
				//System.out.println(":::::::::::::After Sort Values"+intarray[j]+":"+chkarray[j]);
				if(intarray[j].compareTo(chkarray[j])==0)
				{
					System.out.println(":::::::::::::After Sort Values"+intarray[j]+":"+chkarray[j]);
				}
				else
				{
					System.out.println(":::::::::::::After Sort Values"+intarray[j]+":"+chkarray[j]);
					System.out.println("Sorting fail...");
					status=false;
					break;
				}
					
			}
			
			return status;
		
	}
	public boolean checkSortedValue(WebDriver driver, Properties obj, String strReportCode)
	{
		boolean status = true;
		//WebElement html = driver.findElement(By.tagName("html")); 
		//driver.manage().window().maximize();
		try{
			
			
			for(int i=0;i<4;i++)
				//html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			
		List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid']/div/table[1]/thead/tr[2]"));
			//WebElement htmltable=driver.findElement(By.xpath(".//*[@id='div-6000-datagrid-tbody']"));
		List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
		WebElement htmltable1=driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']"));
		List<WebElement> rows1=htmltable1.findElements(By.tagName("tr"));
		System.out.println("No. of Rows in the WebTable: "+rows1.size());
		Thread.sleep(5000);
		String [] ChkReefers = new String[rows1.size()-1];
			String[] NewReefers = new String[rows1.size()-1];
			String Reefers = "Null";
			int pt = 0;
			String cut = "\n";
			System.out.println("No.of rows "+rows.size());
			for(WebElement row:rows)
			{
			List<WebElement> rowElements = row.findElements(By.xpath("th"));
			System.out.println("rowelement value"+rowElements.size());
			
			ArrayList<String> rowData = new ArrayList<String>();
			ArrayList<String> rowDataId = new ArrayList<String>();
			
			for(WebElement column:rowElements)
			{
				System.out.println("ID Value is... : "+column.getAttribute("id"));
				//System.out.println("row Size value "+rowElements.size());
				String colValue = column.getAttribute("id");
				System.out.println(">>>>>>>>>>>id value = "+colValue);
			    rowData.add(column.getText().toString());
			    rowDataId.add(column.getAttribute("id"));
			    String getVal = column.getText().toString();
			    String getValId = column.getAttribute("id");
			  System.out.println("rowData Values are"+rowData);
			  
			  //ArrayList<Integer> lival= indexOfAll(getVal, rowData);
			  
			  int retval=rowData.indexOf(getVal);
			  int retValid= rowDataId.indexOf(getValId);
					  
					  
					  
			  //retVal = driver.findElement(By.xpath(".//*[@id='div-114-datagrid']/div/table[1]/thead/tr[2]/th[5]"))
			  System.out.println("<<<<<<<<<<<<<<<<<<"+retval);
			  retval++;
			  retValid++;
			  if(colValue.contains("all-none") || colValue.contains("snapshot"))
			  {
				  System.out.println("All none...");
				  continue;
			  }
			  
			 String xpathValue =  ".//*[@id='"+colValue+"']/button";
			 if (driver.findElement(By.xpath(xpathValue)).isDisplayed())
			 {
				System.out.println("::::::::::::::::::::::::::::: This xpath is displayed"+xpathValue);
				
				/*WebElement element = driver.findElement(By.xpath(xpathValue));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(500);*/ 
				
				try
				{
					/*while(s.isElementPresentcheck(By.xpath(".//*[@id='table-group--heading3']"),driver) || s.isElementPresentcheck(By.xpath(".//*[@id='table-group--heading1']"),driver)
						|| s.isElementPresentcheck(By.xpath(".//*[@id='table-group--heading2']"),driver) || s.isElementPresentcheck(By.xpath(".//*[@id='table-group--heading4']"),driver))
					{
						Thread.sleep(2000);
						System.out.println("Hinderance...");
						driver.findElement(By.xpath("")).
					}*/
					
					//WebElement element = driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+(j+1)+"]/td["+retval+"]/a"));
					WebElement element = driver.findElement(By.xpath(xpathValue));
					while(!element.isDisplayed() || !element.isEnabled())
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(500); 
					driver.findElement(By.xpath(xpathValue)).click();
				}
				catch(Exception e)
				{
					try
					{
						WebElement element = driver.findElement(By.xpath(xpathValue));
						while(!element.isDisplayed() || !element.isEnabled())
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
						Thread.sleep(500); 
						/*while(s.isElementPresentcheck(By.xpath(".//*[@id='table-group--heading3']"),driver) || s.isElementPresentcheck(By.xpath(".//*[@id='table-group--heading1']"),driver)
							|| s.isElementPresentcheck(By.xpath(".//*[@id='table-group--heading2']"),driver) || s.isElementPresentcheck(By.xpath(".//*[@id='table-group--heading4']"),driver))
						{
							Thread.sleep(2000);
							System.out.println("Hinderance...");
						}*/
						
						driver.findElement(By.xpath(xpathValue)).click();
						//System.out.println("Missed once not again");
					}
					catch(Exception ex)
					{
						
						ex.printStackTrace();
					}
				}
			
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(2000);
			}
				/*Thread.sleep(8000);
				WebDriverWait wait = new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathValue)));*/
			/*List <WebElement> selectElements= driver.findElements(By.cssSelector(".cls-checked"));
			 if( (selectElements.get(1).isSelected()))
			 {
				System.out.println("Nothing to do..............."); 
			 }
			 else*/
			 {
				 
			System.out.println("Rows:"+rows1.size());
			if(strReportCode.equalsIgnoreCase("114"))
			{
				for(int j=1;j<rows1.size();j++)
				{
					System.out.println("Checking");
					if (s.isElementPresentcheck(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+(j+1)+"]/td["+retValid+"]/a"), driver))
					{
						System.out.println(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+(j+1)+"]/td["+retValid+"]/a is present...");
						Reefers= driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+(j+1)+"]/td["+retValid+"]/a")).getText();
					}
					else
					{
						System.out.println((j+1)+".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+(j+1)+"]/td["+retValid+"]/t is not Present");
						Reefers= driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+(j+1)+"]/td["+retValid+"]")).getText();
					}
					if (Reefers.contains("\n"))
					{
						Reefers = s.cutString(Reefers, cut);
						System.out.println(Reefers+":"+j);
					}
					NewReefers[j-1] = Reefers;
					ChkReefers[j-1] = Reefers; 
					
				}
			
			}
			else
			{
				for(int j=1;j<rows1.size();j++)
				{
					System.out.println("Checking");
					if (s.isElementPresentcheck(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+(j+1)+"]/td["+retval+"]/a"), driver))
					{
						System.out.println(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+(j+1)+"]/td["+retval+"]/a is present...");
						Reefers= driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+(j+1)+"]/td["+retval+"]/a")).getText();
					}
					else
					{
						System.out.println((j+1)+".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+(j+1)+"]/td["+retval+"]/t is not Present");
						Reefers= driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+(j+1)+"]/td["+retval+"]")).getText();
					}
					if (Reefers.contains("\n"))
					{
						Reefers = s.cutString(Reefers, cut);
						System.out.println(Reefers+":"+j);
					}
					NewReefers[j-1] = Reefers;
					ChkReefers[j-1] = Reefers; 
					
				}
			}
			
            
			for(int k=0;k<NewReefers.length;k++)
			{
				System.out.println("Befor Sorting"+NewReefers[k]+":"+ChkReefers[k]);
			}
			
			int counter=0;
			
			for(int l=0;l<ChkReefers.length;l++)
			{
				for(int m=0;m<ChkReefers[l].length();m++)
				{
					if(ChkReefers[l].charAt(m)=='-')
					{
						counter++;
					}
				}
				if(counter==2)
					break;
				else
					counter=0;
			}
			
			
			/*if(counter>=2)
			{
				for(int l=0;l<ChkReefers.length;l++)
				{
					if(ChkReefers[l].length()>10)
					{
						ChkReefers[l] = ChkReefers[l].substring(0, 9);
						NewReefers[l] = NewReefers[l].substring(0, 9);
					}
					System.out.println(ChkReefers[l]+"::"+NewReefers[l]);
				}
				//NewReefers=s.dateSort(ChkReefers);
			}
			else
			{
				Arrays.sort(ChkReefers);
			
			
			for(int j=0;j<NewReefers.length;j++)
			{
				System.out.println("After Sorting"+NewReefers[j]+":"+ChkReefers[j]);
			}
			boolean Results=false;
			Results = Arrays.equals(NewReefers, ChkReefers);
		if(Results)
		{
			System.out.println("Column sorted Successfully");
			
		}
		else
		{
			System.out.println("Column sorting Failed ");
			status=false;
		}
			}*/
			if(counter==2)
			{
				for(int l=0;l<ChkReefers.length;l++)
				{
					if(ChkReefers[l].length()>10)
					{
						ChkReefers[l] = ChkReefers[l].substring(0, 9);
						NewReefers[l] = NewReefers[l].substring(0, 9);
					}
					System.out.println(ChkReefers[l]+"::"+NewReefers[l]);
				}
				if(s.dateSort(ChkReefers))
				{
					System.out.println("Matching");
				}
				else
				{
					System.out.println("Not matching...");
					status = false;
				}
				
			}
			else
			{
				if (getVal.equals("DWELL"))
				{
					if(dwellNumber(ChkReefers))
					{
						System.out.println("DWELL working fine");
					}
					else
					{
						status=false;
						
					}
					continue;
				}
					
					if (getVal.equals("NR WARNING"))
					{
						if(dwellNumber(ChkReefers))
						{
							System.out.println("NR WARNING working fine");
						}
						else
						{
							status=false;
							
						}
						continue;
					}
						
						if (getVal.equals("NR ALERT"))
						{
							if(dwellNumber(ChkReefers))
							{
								System.out.println("NR ALERT working fine");
							}
							else
							{
								status=false;
								
							}
							continue;
						}
							
							if (getVal.equals("LOW"))
							{
								if(dwellNumber(ChkReefers))
								{
									System.out.println("LOW working fine");
								}
								else
								{
									status=false;
									
								}
								continue;
							}
								
								if (getVal.equals("HIGH"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("HIGH working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.equals("G RMS"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("G RMS working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
						
								if (getVal.equals("PEAK G"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("PEAK G working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.equals("DELTA V"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("DELTA V working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.equals("BATT. VOLT"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("BATT. VOLT working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.equals("SPEED"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("SPEED working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.equals("ENG. HRS.\nENGINE HOURS"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("ENGINE HOURS working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.equals("FUEL"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("FUEL working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								} 
								
								if (getVal.equals("FLOW METER COUNT"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("FLOW METER COUNT working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.equals("FUEL METER ID"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("FUEL METER ID working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}  
					
								if (getVal.equals("FUEL FLOW METER COUNT"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("FUEL FLOW METER COUNT working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								} 
								
								if (getVal.equals("COUNTDOWN"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("COUNTDOWN working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.contains("FUEL FLOW METER COUNT"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("FFMC FUEL FLOW METER COUNT working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.equals("COUNTDOWN"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("COUNTDOWN working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.equals("LATITUDE"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("LATITUDE working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.equals("LONGITUDE"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("LONGITUDE working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								} 
								
								if (getVal.contains("WAYBILL"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("WAYBILL working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								} 
								
								if (getVal.equals("INTELLISET"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("INTELLISET working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.contains("PPSI"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("PPSI working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								} 
								
								if (getVal.equals("COMMODITY CODE"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("COMMODITY CODE working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
								if (getVal.contains("AVG. REFUEL"))
								{
									if(dwellNumber(ChkReefers))
									{
										System.out.println("AVG. REFUEL working fine");
									}
									else
									{
										status=false;
										
									}
									continue;
								}
								
			
				Arrays.sort(ChkReefers);
			
				for(int i=0;i<NewReefers.length;i++)
					System.out.println("After Sort"+NewReefers[i]+"::"+ChkReefers[i]);
				
				boolean Results=false;
				Results = Arrays.equals(NewReefers, ChkReefers);
				if(Results)
				{
					System.out.println("Matching"); 
				}
				else
				{
					System.out.println("Not matching...");
					status = false;
				}
			}
			 }
			}//If Close
			 else
				{
					System.out.println("::::::::::::::::::::::::::::: This xpath is NOT displayed"+xpathValue);
				}
            
			}
		
			
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
			return status;
			}

	}
	
	public boolean checkFilterValue(WebDriver driver, Properties obj, String strReportCode, String selFilterOption, String columnToCheck, boolean isSendKeyPresent, String columnType, String xPathApplyButton,String clearButton)
	{
		boolean status = true;	

		try{
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(1000);
			}
				WebElement ele = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"-"+strReportCode+"']"));
				System.out.println(ele.getTagName());
				List<WebElement>page=ele.findElements(By.tagName("option"));
				System.out.println("<<<<<<<<<<<<<"+page.size());
				for (int k=2; k<=page.size();k++)
				{			
					
					if (s.isElementPresent(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button"), driver))
					{
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						{
  							Thread.sleep(1000);	
  						}
					}
					System.out.println("selFilterOption "+selFilterOption+" reportCode "+strReportCode);
					driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/a/span")).click();
					Thread.sleep(1000);
					String SelVal = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).getText();
					System.out.println(">>>>>>>>>>>>>"+SelVal);
					if (isSendKeyPresent){
						System.out.println("Inside if condition");
						driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/div/input")).sendKeys(SelVal);
						driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li[1]")).click();
					}else{
						System.out.println("Inside else condition");
						Thread.sleep(1000);
						//driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/a")).click();
						//Thread.sleep(3000);
						driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).click();
						
						//driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div["+xx+]"_"+strReportCode+"_chosen']/a")).click();
					}
					
					
					
					
					Thread.sleep(1000);
					driver.findElement(By.xpath(obj.getProperty(xPathApplyButton))).click();
					
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						{
							Thread.sleep(1000);
						}
					int chkIndex=0;
					String TotalPages =driver.findElement(By.xpath(obj.getProperty("DAGetNoOfPages"))).getText();
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
						System.out.println("No Record Found for "+SelVal);
						String acop = "No Record Found";
						
							driver.findElement(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button")).click();
							Thread.sleep(2000);
							
					}
					else
					{
						WebElement chk = driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']"));
						System.out.println(chk.getTagName());
						List<WebElement>tag=chk.findElements(By.tagName("tr"));
						System.out.println("%%%%%%%%%%%%"+tag.size());
						String Records1 = "Null";
						String strXPathSingleRow = "Null";
						String strXPathMultipleRow = "Null";
						String rowValue = "";	
						String clsattr ="";
						for (int n1 = 1;n1<=tag.size();n1++)
						{
							
							if (columnType.equals("Anchor")){
								//use anchor tag and span in xPath
								strXPathSingleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr/td["+columnToCheck+"]/a/span";
								strXPathMultipleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]/a/span";
							}else{
								strXPathSingleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr/td["+columnToCheck+"]";
								strXPathMultipleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]";
							}
							
							

							if (tag.size()==1){
								System.out.println("Single Row::::::::"+driver.findElement(By.xpath(strXPathSingleRow)).getText());
								rowValue = driver.findElement(By.xpath(strXPathSingleRow)).getText();
								clsattr =driver.findElement(By.xpath(strXPathSingleRow)).getAttribute("class");
							}
							else
							{
								System.out.println(driver.findElement(By.xpath(strXPathMultipleRow)).getText());
  								rowValue = driver.findElement(By.xpath(strXPathMultipleRow)).getText();
  								clsattr =driver.findElement(By.xpath(strXPathMultipleRow)).getAttribute("class");
							}

							//Remove Space from T - Call, L - Call, E - Call in Order Status Filter value
							if (rowValue.equals("L - Call")||rowValue.equals("T - Call")||rowValue.equals("E - Call")){
								rowValue = rowValue.replaceAll("\\s", "");}
							else if (rowValue.equals("RFR")){
								rowValue = "Reefer";}
							else if (rowValue.equals("DV")){
								rowValue = "Dry van";}
							else if (rowValue.equals("Cooler")){
								rowValue = "Chilled";}
							else if (rowValue.equals("Mix")){
								rowValue = "Mixed";}
							else if (rowValue.equals("-")){
								SelVal = "-";}
							else if (rowValue.equals("Not Acknowledged")){
								rowValue = "Reefer OFF on Active Order";}
							else if (rowValue.equals("Moving")){
								SelVal = "Moving";}
							else if (rowValue.equals("ON")){
								SelVal = "Reefer On";}
							else if (rowValue.equals("OFF")){
								SelVal = "Reefer Off";}
							
							
							if (SelVal.equals("Active Alarms"))
							{
								rowValue = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).getAttribute("class");
								if(SelVal.equalsIgnoreCase("-empty -section-divider"))
								{
									System.out.println("Active Alarm Failed");
									status=false;
								}
								else
								{
									System.out.println("Active Alarm Pass");
									
								}
								rowValue=SelVal;
							}
							else if (SelVal.equals("No Alarms"))
							{
								rowValue = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).getAttribute("class");
								if(SelVal.equalsIgnoreCase("-empty -section-divider"))
									System.out.println("No Alarm Pass");
								else
								{
									System.out.println("No Alarm Failed");
									status=false;
								}
								rowValue=SelVal;
							}
							
								
							if (rowValue.contains(SelVal))
								{
									System.out.println("<<<<<<PASSSSSSSSSSSS>>>>>");
									//status=true;
								}
								else
								{
									status=false;
								}
						}
					driver.findElement(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button")).click();
					Thread.sleep(2000);			
					
				 }
				}
				s.clearFilter(driver, obj, clearButton);				
				Thread.sleep(1000);
			
	
	}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		return status;
		}
	}
	
	public boolean alarm(WebDriver driver, Properties obj, String strReportCode, String selFilterOption, String columnToCheck, boolean isSendKeyPresent, String columnType, String xPathApplyButton,String clearButton)
	{
		boolean status = true;	

		try{
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(1000);
			}
				WebElement ele = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"-"+strReportCode+"']"));
				System.out.println(ele.getTagName());
				List<WebElement>page=ele.findElements(By.tagName("option"));
				System.out.println("<<<<<<<<<<<<<"+page.size());
				for (int k=2; k<=page.size();k++)
				{				
					if (s.isElementPresent(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button"), driver))
					{
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						{
  							Thread.sleep(1000);	
  						}
					}
					System.out.println("selFilterOption"+selFilterOption+"reportCode"+strReportCode);
					driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/a/span")).click();
					Thread.sleep(1000);
					//driver.manage().window().maximize();
					String SelVal = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).getText();
					System.out.println(">>>>>>>>>>>>>"+SelVal);			
					
						//driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div")).click();
						
						driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).click();	
						
					    driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-filters']/div/div/div[3]/button[1]")).click();
					
					/*if(s.isElementPresent(By.xpath(".//*[@id='div-100-filters']/div/div/div[3]/button[1]"), driver))
					{
						System.out.println("Inside element present check");					
						Thread.sleep(10000);					
					
					}*/
					
					
					
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						{
							Thread.sleep(1000);
						}
					int chkIndex=0;
					String TotalPages =driver.findElement(By.xpath(obj.getProperty("DAGetNoOfPages"))).getText();
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
						System.out.println("No Record Found for "+SelVal);
						String acop = "No Record Found";
						
							driver.findElement(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button")).click();
							Thread.sleep(2000);
							
					}
					else
					{
						WebElement chk = driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']"));
						System.out.println(chk.getTagName());
						List<WebElement>tag=chk.findElements(By.tagName("tr"));
						System.out.println("%%%%%%%%%%%%"+tag.size());
						String Records1 = "Null";
						String strXPathSingleRow = "Null";
						String strXPathMultipleRow = "Null";
						String rowValue = "";	
						String clsattr ="";
						for (int n1 = 1;n1<=tag.size();n1++)
						{
							
							if (columnType.equals("Anchor")){
								//use anchor tag and span in xPath
								strXPathSingleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr/td["+columnToCheck+"]/a/span";
								strXPathMultipleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]/a/span";
							}else{
								strXPathSingleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr/td["+columnToCheck+"]";
								strXPathMultipleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]";
							}
							
							

							if (tag.size()==1){
								System.out.println("Single Row::::::::"+driver.findElement(By.xpath(strXPathSingleRow)).getText());
								rowValue = driver.findElement(By.xpath(strXPathSingleRow)).getText();
								clsattr =driver.findElement(By.xpath(strXPathSingleRow)).getAttribute("class");
							}
							else
							{
								System.out.println(driver.findElement(By.xpath(strXPathMultipleRow)).getText());
  								rowValue = driver.findElement(By.xpath(strXPathMultipleRow)).getText();
  								clsattr =driver.findElement(By.xpath(strXPathMultipleRow)).getAttribute("class");
							}

							
							
							if (SelVal.equals("Active Alarms"))
							{
								rowValue = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).getAttribute("class");
								if(SelVal.equalsIgnoreCase("-empty -section-divider"))
								{
									System.out.println("Active Alarm Failed");
									status=false;
								}
								else
								{
									System.out.println("Active Alarm Pass");
									
								}
								rowValue=SelVal;
							}
							else if (SelVal.equals("No Alarms"))
							{
								rowValue = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).getAttribute("class");
								if(rowValue.equals("-"))
								{
									System.out.println("No Alarm Failed");
									status=false;
									
								}
								else
								{
									System.out.println("No Alarm Pass");
								}
								rowValue=SelVal;
							}
							
								
							if (rowValue.contains(SelVal))
								{
									System.out.println("<<<<<<PASSSSSSSSSSSS>>>>>");
									//status=true;
								}
								else
								{
									status=false;
								}
						}
					driver.findElement(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button")).click();
					Thread.sleep(2000);			
					
				 }
				}
				s.clearFilter(driver, obj, clearButton);				
				Thread.sleep(1000);
			
	
	}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		return status;
		}
	}
	public boolean yard(WebDriver driver, Properties obj, String strReportCode, String selFilterOption, String columnToCheck, boolean isSendKeyPresent, String columnType, String xPathApplyButton,String clearButton)
	{
		boolean status = true;	

		try{
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(1000);
			}
				WebElement ele = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"-"+strReportCode+"']"));
				System.out.println(ele.getTagName());
				List<WebElement>page=ele.findElements(By.tagName("option"));
				System.out.println("<<<<<<<<<<<<<"+page.size());
				for (int k=2; k<=page.size();k++)
				{				
					if (s.isElementPresent(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button"), driver))
					{
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						{
  							Thread.sleep(1000);	
  						}
					}
					System.out.println("selFilterOption"+selFilterOption+"reportCode"+strReportCode);
					driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/a/span")).click();
					Thread.sleep(1000);
					//driver.manage().window().maximize();
					String SelVal = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).getText();
					System.out.println(">>>>>>>>>>>>>"+SelVal);	
					
					driver.findElement(By.xpath(".//*[@id='geofenceId_100_chosen']/div/div/input")).sendKeys(SelVal);
					driver.findElement(By.xpath(".//*[@id='geofenceId_100_chosen']/div/div/input")).click();
					driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li")).click();						
					driver.findElement(By.xpath(".//*[@id='div-100-filters']/div/div/div[3]/button[1]")).click();					
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						{
							Thread.sleep(1000);
						}
					int chkIndex=0;
					String TotalPages =driver.findElement(By.xpath(obj.getProperty("DAGetNoOfPages"))).getText();
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
						System.out.println("No Record Found for "+SelVal);
						String acop = "No Record Found";
						
							driver.findElement(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button")).click();
							Thread.sleep(2000);
							
					}
					else
					{
						WebElement chk = driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']"));
						System.out.println(chk.getTagName());
						List<WebElement>tag=chk.findElements(By.tagName("tr"));
						System.out.println("%%%%%%%%%%%%"+tag.size());
						String Records1 = "Null";
						String strXPathSingleRow = "Null";
						String strXPathMultipleRow = "Null";
						String rowValue = "";	
						String clsattr ="";
						for (int n1 = 1;n1<=tag.size();n1++)
						{
							
							if (columnType.equals("Anchor")){
								//use anchor tag and span in xPath
								strXPathSingleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr/td["+columnToCheck+"]/a/span";
								strXPathMultipleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]/a/span";
							}else{
								strXPathSingleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr/td["+columnToCheck+"]";
								strXPathMultipleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]";
							}
							
							

							if (tag.size()==1){
								System.out.println("Single Row::::::::"+driver.findElement(By.xpath(strXPathSingleRow)).getText());
								rowValue = driver.findElement(By.xpath(strXPathSingleRow)).getText();
								clsattr =driver.findElement(By.xpath(strXPathSingleRow)).getAttribute("class");
							}
							else
							{
								System.out.println(driver.findElement(By.xpath(strXPathMultipleRow)).getText());
  								rowValue = driver.findElement(By.xpath(strXPathMultipleRow)).getText();
  								clsattr =driver.findElement(By.xpath(strXPathMultipleRow)).getAttribute("class");
							}

							
							
							if (SelVal.equals("Active Alarms"))
							{
								rowValue = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).getAttribute("class");
								if(SelVal.equalsIgnoreCase("-empty -section-divider"))
								{
									System.out.println("Active Alarm Failed");
									status=false;
								}
								else
								{
									System.out.println("Active Alarm Pass");
									
								}
								rowValue=SelVal;
							}
							else if (SelVal.equals("No Alarms"))
							{
								rowValue = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).getAttribute("class");
								if(SelVal.equalsIgnoreCase("-empty -section-divider"))
									System.out.println("No Alarm Pass");
								else
								{
									System.out.println("No Alarm Failed");
									status=false;
								}
								rowValue=SelVal;
							}
							
								
							if (rowValue.contains(SelVal))
								{
									System.out.println("<<<<<<PASSSSSSSSSSSS>>>>>");
									//status=true;
								}
								else
								{
									status=false;
								}
						}
					driver.findElement(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button")).click();
					Thread.sleep(2000);			
					
				 }
				}
				s.clearFilter(driver, obj, clearButton);				
				Thread.sleep(1000);
			
	
	}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		return status;
		}
	}
	public boolean impact(WebDriver driver, Properties obj, String strReportCode, String selFilterOption, String columnToCheck, boolean isSendKeyPresent, String columnType, String xPathApplyButton,String clearButton)
	{
		boolean status = true;	

		try{
			while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(1000);
			}
				WebElement ele = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"-"+strReportCode+"']"));
				System.out.println(ele.getTagName());
				List<WebElement>page=ele.findElements(By.tagName("option"));
				System.out.println("<<<<<<<<<<<<<"+page.size());
				for (int k=2; k<=page.size();k++)
				{				
					if (s.isElementPresent(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button"), driver))
					{
						while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  						{
  							Thread.sleep(1000);	
  						}
					}
					System.out.println("selFilterOption"+selFilterOption+"reportCode"+strReportCode);
					driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/a/span")).click();
					Thread.sleep(1000);
					//driver.manage().window().maximize();
					String SelVal = driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).getText();
					System.out.println(">>>>>>>>>>>>>"+SelVal);			
					
						//driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div")).click();
						
						driver.findElement(By.xpath(".//*[@id='"+selFilterOption+"_"+strReportCode+"_chosen']/div/ul/li["+k+"]")).click();	
						
						driver.findElement(By.xpath(obj.getProperty(xPathApplyButton))).click();
					
					/*if(s.isElementPresent(By.xpath(".//*[@id='div-100-filters']/div/div/div[3]/button[1]"), driver))
					{
						System.out.println("Inside element present check");					
						Thread.sleep(10000);					
					
					}*/
					
					
					
					while(s.isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
						{
							Thread.sleep(1000);
						}
					int chkIndex=0;
					String TotalPages =driver.findElement(By.xpath(obj.getProperty("DAGetNoOfPages"))).getText();
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
						System.out.println("No Record Found for "+SelVal);
						String acop = "No Record Found";
						
							driver.findElement(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button")).click();
							Thread.sleep(2000);
							
					}
					else
					{
						WebElement chk = driver.findElement(By.xpath(".//*[@id='div-"+strReportCode+"-datagrid-tbody']"));
						System.out.println(chk.getTagName());
						List<WebElement>tag=chk.findElements(By.tagName("tr"));
						System.out.println("%%%%%%%%%%%%"+tag.size());
						String Records1 = "Null";
						String strXPathSingleRow = "Null";
						String strXPathMultipleRow = "Null";
						String rowValue = "";	
						String clsattr ="";
						for (int n1 = 1;n1<=tag.size();n1++)
						{
							
							if (columnType.equals("Anchor")){
								//use anchor tag and span in xPath
								strXPathSingleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr/td["+columnToCheck+"]/a/span";
								strXPathMultipleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]/a/span";
							}else{
								strXPathSingleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr/td["+columnToCheck+"]";
								strXPathMultipleRow = ".//*[@id='div-"+strReportCode+"-datagrid-tbody']/tr["+n1+"]/td["+columnToCheck+"]";
							}
							
							

							if (tag.size()==1){
								System.out.println("Single Row::::::::"+driver.findElement(By.xpath(strXPathSingleRow)).getText());
								rowValue = driver.findElement(By.xpath(strXPathSingleRow)).getText();
								clsattr =driver.findElement(By.xpath(strXPathSingleRow)).getAttribute("class");
							}
							else
							{
								System.out.println(driver.findElement(By.xpath(strXPathMultipleRow)).getText());
  								rowValue = driver.findElement(By.xpath(strXPathMultipleRow)).getText();
  								clsattr =driver.findElement(By.xpath(strXPathMultipleRow)).getAttribute("class");
							}

							
							
								
							if (rowValue.contains(SelVal))
								{
									System.out.println("<<<<<<PASSSSSSSSSSSS>>>>>");
									//status=true;
								}
								else
								{
									status=false;
								}
						}
					driver.findElement(By.xpath(".//*[@id='show-filters-"+strReportCode+"']/button")).click();
					Thread.sleep(2000);			
					
				 }
				}
				s.clearFilter(driver, obj, clearButton);				
				Thread.sleep(1000);
			
	
	}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		return status;
		}
	}
}