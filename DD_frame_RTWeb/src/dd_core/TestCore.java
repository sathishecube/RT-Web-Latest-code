
package dd_core;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import dd_test.*;
import dd_utils.*;

public class TestCore {

	static Map<String, Object[]> data= new TreeMap<String, Object[]>();
	static Map<String, Object[]> data1= new TreeMap<String, Object[]>();

	public static WebDriver driver = null;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\dd_properties\\RT-Web.xls");
	public static Logger log = Logger.getLogger("devpinoyLogger"); 
	public static Properties Object = new Properties();
	public static Properties Object1 = new Properties();
	public static ExtentReports reports =new ExtentReports(System.getProperty("user.dir")+"\\TestResults\\TestResult.html",true);
	static String input[][] = TestUtil.getData("Summary");
	static int rc = 100;


	@BeforeSuite
	public static void setUp() throws IOException 
	{
		TestUtil.set();
		reports.loadConfig(new File("C:\\Users\\sbalasubramanian\\git\\RT-Web-Latest-code\\DD_frame_RTWeb\\extent-config.xml"));
		data.put(""+rc, new Object[] {"TC No", "Module", "Description", "Expected Result", "Actual Result", "Status", "Execution Time(Sec.)"});
		rc++;
	}

	@Test (priority=1)
	public static void login() throws Exception

	{
		if(input[0][0].equalsIgnoreCase("Login") && input[0][1].equalsIgnoreCase("Y"))
		{


			ExtentTest test =reports.startTest("Login");
			test.appendChild(test);

			String sd = input[0][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[0][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = Login.testcases(data1, rc, "Login",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);		
		}

	}

	@Test (priority=54)
	public static void setting() throws Exception
	{ 
		if(input[1][0].equalsIgnoreCase("Settings") && input[1][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("Settings");
			test.appendChild(test);		 
			String sd = input[1][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[1][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = Settings.setting(data1, rc, "Settings",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}
	@Test (priority=2)
	public static void reeferstatus() throws Exception
	{
		if(input[2][0].equalsIgnoreCase("ReeferStatus") && input[2][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferStatus");
			test.appendChild(test);

			String sd = input[2][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[2][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReeferStatus.reeferStatustestcases(data1, rc, "ReeferStatus",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	
	@Test (priority=3)
	public static void reefermultitemp() throws Exception
	{
		if(input[3][0].equalsIgnoreCase("ReefersMultiTemp") && input[3][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReefersMultiTemp");
			test.appendChild(test);

			String sd = input[3][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[3][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReeferMultitemp.reeferMultitemptestcases(data1, rc, "ReefersMultiTemp",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}
	@Test (priority=4)
	public static void reefermaintenance() throws Exception
	{
		if(input[4][0].equalsIgnoreCase("ReefersMaintenance") && input[4][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReefersMaintenance");
			test.appendChild(test);

			String sd = input[4][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[4][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReeferMaintenance.reeferMaintenancetestcases(data1, rc, "ReefersMaintenance",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}

	@Test (priority=5)
	public static void reeferpretrip() throws Exception
	{
		if(input[5][0].equalsIgnoreCase("ReefersPretrip") && input[5][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReefersPretrip");
			test.appendChild(test);

			String sd = input[5][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[5][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReeferPretrip.reeferpretriptestcases(data1, rc, "ReefersPretrip",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=6)
	public static void reeferalarm() throws Exception
	{
		if(input[6][0].equalsIgnoreCase("ReefersAlarm") && input[6][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReefersAlarm");
			test.appendChild(test);

			String sd = input[6][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[6][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReeferAlarm.reeferAlarmtestcases(data1, rc, "ReefersAlarm",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}	
	@Test (priority=7)
	public static void reefertempprofile() throws Exception
	{
		if(input[7][0].equalsIgnoreCase("ReefersTempProfile") && input[7][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReefersTempProfile");
			test.appendChild(test);

			String sd = input[7][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[7][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReeferTempProfile.reefertempprofiletestcases(data1, rc, "ReefersTempProfile",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}	
	@Test (priority=8)
	public static void reeferimpact() throws Exception
	{
		if(input[8][0].equalsIgnoreCase("ReefersImpact") && input[8][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReefersImpact");
			test.appendChild(test);

			String sd = input[8][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[8][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReefersImpact.reeferimpacttestcases(data1, rc, "ReefersImpact",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}	
	@Test (priority=9)
	public static void reeferITA() throws Exception
	{
		if(input[9][0].equalsIgnoreCase("ReefersITA") && input[9][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReefersITA");
			test.appendChild(test);

			String sd = input[9][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[9][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReefersITA.reeferITAtestcases(data1, rc, "ReefersITA",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}	
	@Test (priority=10)
	public static void reeferSM() throws Exception
	{
		if(input[10][0].equalsIgnoreCase("ReefersSM") && input[10][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReefersSM");
			test.appendChild(test);

			String sd = input[10][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[10][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = ReefersSM.reeferSMtestcases(data1, rc, "ReefersSM",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}
	@Test (priority=11)
	public static void reeferfuelflows() throws Exception
	{
		if(input[11][0].equalsIgnoreCase("ReefersFuelFlow") && input[11][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReefersFuelFlow");
			test.appendChild(test);

			String sd = input[11][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[11][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = ReeferFuel.ReefersFuelFlowtestcases(data1, rc, "ReefersFuelFlow",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	
	@Test (priority=12)
	public static void reeferdooralarms() throws Exception
	{
		if(input[12][0].equalsIgnoreCase("ReefersDoorAlarm") && input[12][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReefersDoorAlarm");
			test.appendChild(test);

			String sd = input[12][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[12][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);


			data1 = ReeferDoorAlarms.reeferdooralarmtestcases(data1, rc, "ReefersDoorAlarm",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	
	@Test (priority=14)
	public static void logistic() throws Exception
	{
		if(input[13][0].equalsIgnoreCase("LogisticUtilization") && input[13][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("Logistic Utilization");
			test.appendChild(test);

			String sd = input[13][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[13][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = Logistic.logisticutilization(data1, rc, "LogisticUtilization",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	
	@Test (priority=13)
	public static void logisticCLM() throws Exception
	{
		if(input[14][0].equalsIgnoreCase("LogisticCLM") && input[14][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("LogisticCLM");
			test.appendChild(test);

			String sd = input[14][2];
			float sd1 = Float.parseFloat(sd); 
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[14][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = LogisticCLM.logisticCLMtestcase(data1, rc, "LogisticCLM",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	
	@Test (priority=15)
	public static void logisticWayBill() throws Exception
	{
		if(input[15][0].equalsIgnoreCase("LogisticWayBill") && input[15][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("LogisticWayBill");
			test.appendChild(test);

			String sd = input[15][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[15][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = LogisticWayBill.logisticWayBilltestcase(data1, rc, "LogisticWayBill",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	
	@Test (priority=16)
	public static void orderstatus() throws Exception
	{
		if(input[16][0].equalsIgnoreCase("OrderStatus") && input[16][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("OrderStatus");
			test.appendChild(test);

			String sd = input[16][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[16][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =OrderStatus.OrderStatustestcase(data1, rc, "OrderStatus",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	
	@Test (priority=17)
	public static void ordermanifest() throws Exception
	{
		if(input[17][0].equalsIgnoreCase("OrderManifest") && input[17][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("OrderManifest");
			test.appendChild(test);

			String sd = input[17][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[17][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =OrderManifest.Ordermanifesttestcase(data1, rc, "OrderManifest",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}

	@Test (priority=18)
	public static void disparitystatus() throws Exception
	{
		if(input[18][0].equalsIgnoreCase("DisparityStatus") && input[18][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("DisparityStatus");
			test.appendChild(test);

			String sd = input[18][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[18][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = DisparityStatus.DisparityStatustestcase(data1, rc, "DisparityStatus",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	

	@Test (priority=19)
	public static void fuelrefuel() throws Exception
	{
		if(input[19][0].equalsIgnoreCase("FuelRefuel") && input[19][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("FuelRefuel");
			test.appendChild(test);

			String sd = input[19][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[19][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =FuelRefuel.fuelrefueltestcases(data1, rc, "FuelRefuel",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}	
	@Test (priority=20)
	public static void fuelrefuellocation() throws Exception
	{
		if(input[20][0].equalsIgnoreCase("FuelRefuelLocation") && input[20][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("FuelRefuelLocation");
			test.appendChild(test);

			String sd = input[20][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[20][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =FuelRefuelLocation.fuelrefuellocationtestcases(data1, rc, "FuelRefuelLocation",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=21)
	public static void refuelsummaryhistory() throws Exception
	{
		if(input[21][0].equalsIgnoreCase("FuelRefuelSummaryHistory") && input[21][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("FuelRefuelSummaryHistory");
			test.appendChild(test);

			String sd = input[21][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[21][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =RefuelSummaryHistory.refuelsummaryhistorytestcases(data1, rc, "FuelRefuelSummaryHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}	
	@Test (priority=22)
	public static void fuelusagesummary() throws Exception
	{
		if(input[22][0].equalsIgnoreCase("FuelUsageSummary") && input[22][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("FuelUsageSummary");
			test.appendChild(test);

			String sd = input[22][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[22][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =FuelUsageSummary.fuelusagesummarytestcases(data1, rc, "FuelUsageSummary",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}	
	@Test (priority=23)
	public static void Inventorysummary() throws Exception
	{
		if(input[23][0].equalsIgnoreCase("InventorySummary") && input[23][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("InventorySummary");
			test.appendChild(test);

			String sd = input[23][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[23][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =InventorySummary.inventorysummarytestcases(data1, rc, "InventorySummary",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}	
	@Test (priority=24)
	public static void reeferInventory() throws Exception
	{
		if(input[24][0].equalsIgnoreCase("ReeferInventory") && input[24][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferInventory");
			test.appendChild(test);

			String sd = input[24][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[24][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReeferInventory.reeferinventorytestcases(data1, rc, "ReeferInventory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}	
	@Test (priority=25)
	public static void yardInventory() throws Exception
	{
		if(input[25][0].equalsIgnoreCase("YardInventory") && input[25][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("YardInventory");
			test.appendChild(test);

			String sd = input[25][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[25][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =YardInventory.yardinventorytestcases(data1, rc, "YardInventory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}	
	@Test (priority=26)
	public static void regionInventory() throws Exception
	{
		if(input[26][0].equalsIgnoreCase("RegionInventory") && input[26][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("RegionInventory");
			test.appendChild(test);

			String sd = input[26][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[26][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =RegionInventory.regioninventorytestcases(data1, rc, "RegionInventory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=27)
	public static void cstatus() throws Exception
	{
		if(input[27][0].equalsIgnoreCase("CommandStatus") && input[27][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("CommandStatus");
			test.appendChild(test);

			String sd = input[27][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[27][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = Cstatus.Cstatuscases(data1, rc, "CommandStatus",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	
	@Test (priority=28)
	public static void chistory() throws Exception
	{
		if(input[28][0].equalsIgnoreCase("CommandHistory") && input[28][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("CommandHistory");
			test.appendChild(test);

			String sd = input[28][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[28][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);
			System.out.println("Start case:"+ scase);

			data1 = CHistory.Chistorycase(data1, rc, "CommandHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	
	@Test (priority=29)
	public static void scheduledcommands() throws Exception
	{
		if(input[29][0].equalsIgnoreCase("ScheduledCommands") && input[29][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ScheduledCommands");
			test.appendChild(test);

			String sd = input[29][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[29][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =scheduledCommands.scheduledcommandstestcase(data1, rc, "ScheduledCommands",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}

	@Test (priority=30)
	public static void pollcommands() throws Exception
	{
		if(input[30][0].equalsIgnoreCase("PollCommands") && input[30][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("PollCommands");
			test.appendChild(test);

			String sd = input[30][2];
			float sd1 = Float.parseFloat(sd);		 
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[30][3]; 

			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =pollCommands.Pollcommandstestcase(data1, rc, "PollCommands",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}

	@Test (priority=31)
	public static void controlcommands() throws Exception
	{
		if(input[31][0].equalsIgnoreCase("ControlCommands") && input[31][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ControlCommands");
			test.appendChild(test);

			String sd = input[31][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[31][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =controlCommands.Controlcommandsutil(data1, rc, "ControlCommands",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}

	@Test (priority=32)
	public static void orderdisparity() throws Exception
	{
		if(input[32][0].equalsIgnoreCase("OrdersDisparity") && input[32][1].equalsIgnoreCase("Y"))
		{
			System.out.println("Inside the function");
			ExtentTest test =reports.startTest("OrdersDisparity");
			test.appendChild(test);

			String sd = input[32][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[32][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =OrdersDisparity.orderdisparitytestcases(data1, rc, "OrdersDisparity",test,scase,ecase);

			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}

	@Test (priority=33)
	public static void reeferstatushistory() throws Exception
	{
		if(input[33][0].equalsIgnoreCase("ReeferStatusHistory") && input[33][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferStatusHistory");
			test.appendChild(test);

			String sd = input[33][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[33][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReeferStatusHistory.reeferstatushistroytestcase(data1, rc, "ReeferStatusHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}


	@Test (priority=34)
	public static void reefermultitemphistory() throws Exception
	{
		if(input[34][0].equalsIgnoreCase("ReeferMultitempHistory") && input[34][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferMultitempHistory");
			test.appendChild(test);

			String sd = input[34][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[34][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReefersMultiTempHistory.reefermultitemphistroytestcase(data1, rc, "ReeferMultitempHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}

	@Test (priority=35)
	public static void ReeferMaintenanceHistory() throws Exception
	{
		if(input[35][0].equalsIgnoreCase("ReeferMaintenanceHistory") && input[35][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferMaintenanceHistory");
			test.appendChild(test);

			String sd = input[35][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[35][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReeferMaintenanceHistory.reefermaintenancehistroytestcase(data1, rc, "ReeferMaintenanceHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}
	}
	@Test (priority=36)
	public static void ReefersPretripHistory() throws Exception
	{
		if(input[36][0].equalsIgnoreCase("ReeferPretripHistory") && input[36][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferPretripHistory");
			test.appendChild(test);

			String sd = input[36][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[36][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReefersPretripHistory.RPretripHistory(data1, rc, "ReeferPretripHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}
	}
	@Test (priority=37)
	public static void ReefersAlarmHistory() throws Exception
	{
		if(input[37][0].equalsIgnoreCase("ReeferAlarmHistory") && input[37][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferAlarmHistory");
			test.appendChild(test);

			String sd = input[37][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[37][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReefersAlarmHistory.RAlarmHistory(data1, rc, "ReeferAlarmHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}
	}
	@Test (priority=38)
	public static void ReefersTempProfileHistory() throws Exception
	{
		if(input[38][0].equalsIgnoreCase("ReeferTempProfileHistory") && input[38][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferTempProfileHistory");
			test.appendChild(test);

			String sd = input[38][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[38][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReefersTempProfileHistory.RTempProfileHistory(data1, rc, "ReeferTempProfileHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}
	}
	@Test (priority=39)
	public static void reeferITAhistory() throws Exception
	{
		if(input[39][0].equalsIgnoreCase("ReefersITAHistory") && input[39][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReefersITAHistory");
			test.appendChild(test);

			String sd = input[39][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[39][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReefersITAHistory.RITAHistory(data1, rc, "ReefersITAHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	
	@Test (priority=40)
	public static void ReefersSMHistory() throws Exception
	{
		if(input[40][0].equalsIgnoreCase("ReeferSMHistory") && input[40][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferSMHistory");
			test.appendChild(test);

			String sd = input[40][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[40][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReefersSMHistory.reeferSMtestcases(data1, rc, "ReeferSMHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	
	@Test (priority=41)
	public static void ReefersFuelflowHistory() throws Exception
	{
		if(input[41][0].equalsIgnoreCase("ReeferFuelFlowHistory") && input[41][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferFuelFlowHistory");
			test.appendChild(test);

			String sd = input[41][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[41][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReefersFuelflowHistory.reeferFuelflowtestcases(data1, rc, "ReeferFuelFlowHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}
	@Test (priority=42)
	public static void TKHMIDisplayHistory() throws Exception
	{
		if(input[42][0].equalsIgnoreCase("TKHMIDisplayHistory") && input[42][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("TKHMIDisplayHistory");
			test.appendChild(test);

			String sd = input[42][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[42][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =TKHMIDisplayHistory.TKHMIHistory(data1, rc, "TKHMIDisplayHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}	

	@Test (priority=43)
	public static void ReefersDoorAlarmHistory() throws Exception
	{
		if(input[43][0].equalsIgnoreCase("ReeferDoomAlarmHistory") && input[43][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferDoomAlarmHistory");
			test.appendChild(test);

			String sd = input[43][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[43][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReefersDoorAlarmHistory.RDAHistory(data1, rc, "ReeferDoomAlarmHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}
	@Test (priority=44)
	public static void AssetCommandHistory() throws Exception
	{
		if(input[44][0].equalsIgnoreCase("ReeferAssetCommadHist") && input[44][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferAssetCommadHist");
			test.appendChild(test);

			String sd = input[44][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[44][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =AssetCommandHistory.AssetCmdHistory(data1, rc, "ReeferAssetCommadHist",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}
	@Test (priority=45)
	public static void OrderHistory() throws Exception
	{
		if(input[45][0].equalsIgnoreCase("ReeferOrderHistory") && input[45][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferOrderHistory");
			test.appendChild(test);

			String sd = input[45][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[45][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =OrderHistory.ReefersOrderHistorytestcases(data1, rc, "ReeferOrderHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}
	@Test (priority=46)
	public static void ReefersImpactHistory() throws Exception
	{
		if(input[46][0].equalsIgnoreCase("ReefersImpactHistory") && input[46][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReefersImpactHistory");
			test.appendChild(test);

			String sd = input[46][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[46][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =ReefersImpactHistory.RImpactHistory(data1, rc, "ReefersImpactHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}
	@Test (priority=47)
	public static void LogisticUtilizationHistory() throws Exception
	{
		if(input[47][0].equalsIgnoreCase("ReeferUtilizationHistory") && input[47][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferUtilizationHistory");
			test.appendChild(test);

			String sd = input[47][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[47][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =LogisticUtilizationHistory.LUtilizationHistory(data1, rc, "ReeferUtilizationHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}

	@Test (priority=48)
	public static void LogisticCLMHistory() throws Exception
	{
		if(input[48][0].equalsIgnoreCase("ReeferCLMHistory") && input[48][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ReeferCLMHistory");
			test.appendChild(test);

			String sd = input[48][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[48][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =LogisticCLMHistory.CLMHistory(data1, rc, "ReeferCLMHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}				
	}
	@Test (priority=49)
	public static void LogisticWaybillHistory() throws Exception
	{
		if(input[49][0].equalsIgnoreCase("LogisticWaybillHistory") && input[49][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("LogisticWaybillHistory");
			test.appendChild(test);

			String sd = input[49][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[49][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 =LogisticWaybillHistory.LWaybillHistory(data1, rc, "LogisticWaybillHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}				
	}
	@Test (priority=50)
	public static void DisparityStautsHistory() throws Exception
	{
		if(input[50][0].equalsIgnoreCase("DisparityStatusHistory") && input[50][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("DisparityStatusHistory");
			test.appendChild(test);

			String sd = input[50][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[50][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);								

			data1 =DisparityStautsHistory.DSHistory(data1, rc, "DisparityStatusHistory",test,scase,ecase);
			System.out.println("rc"+rc);
			rc=rc+data1.size();
			System.out.println("data size"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}				
	}

	@Test (priority=51)
	public static void FSMADocs() throws Exception	
	{
		if(input[51][0].equalsIgnoreCase("FSMADocs") && input[51][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("FSMADocs");
			test.appendChild(test);		

			String sd = input[51][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[51][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);		

			data1 = FSMADocs.fsmadocstestcases(data1, rc, "FSMADocs",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}

	@Test  (priority=52)
	public static void TKHMIDisplay() throws Exception

	{
		if(input[52][0].equalsIgnoreCase("TKHMIDisplay") && input[52][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("TKHMIDisplay");
			test.appendChild(test);


			String sd = input[52][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[52][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = TKHMIDisplay.hmidisplaytestcases(data1, rc, "TKHMIDisplay",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}

	}


	@Test (priority=53)
	public static void FTA() throws Exception

	{
		if(input[53][0].equalsIgnoreCase("FTA") && input[53][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("FTA");
			test.appendChild(test);


			String sd = input[53][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[53][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = FTA.ftatestcases(data1, rc, "FTA",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=54)
	public static void UserAdminBilling() throws Exception

	{
		if(input[54][0].equalsIgnoreCase("UserAdminBilling") && input[54][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("UserAdminBilling");
			test.appendChild(test);


			String sd = input[54][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[54][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = UserAdminBilling.billingtestcases(data1, rc, "UserAdminBilling",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=55)
	public static void UserAdminGeofenceData() throws Exception

	{
		if(input[55][0].equalsIgnoreCase("UserAdminGeofenceData") && input[55][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("UserAdminGeofenceData");
			test.appendChild(test);


			String sd = input[55][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[55][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = UserAdminGeofenceData.geotestcases(data1, rc, "UserAdminGeofenceData",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	
	@Test (priority=56)
	public static void UnitAdminPowerOnStatus() throws Exception

	{
		if(input[56][0].equalsIgnoreCase("UnitAdminPowerOnStatus") && input[56][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("UnitAdminPowerOnStatus");
			test.appendChild(test);


			String sd = input[56][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[56][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = UnitAdminPowerOnStatus.powertestcases(data1, rc, "UnitAdminPowerOnStatus",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=57)
	public static void UnitData() throws Exception

	{
		if(input[57][0].equalsIgnoreCase("UnitData") && input[57][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("UnitData");
			test.appendChild(test);


			String sd = input[57][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[57][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = UnitData.unitdatatestcase(data1, rc, "UnitData",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=58)
	public static void SatData() throws Exception

	{
		if(input[58][0].equalsIgnoreCase("SatData") && input[58][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("SatData");
			test.appendChild(test);


			String sd = input[58][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[58][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = SatData.satdatatestcase(data1, rc, "SatData",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=59)
	public static void SIMData() throws Exception

	{
		if(input[59][0].equalsIgnoreCase("SIMData") && input[59][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("SIMData");
			test.appendChild(test);


			String sd = input[59][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[59][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = SIMData.simdatatestcase(data1, rc, "SIMData",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=60)
	public static void UploadOCP() throws Exception

	{		if(input[60][0].equalsIgnoreCase("UploadOCP") && input[60][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("UploadOCP");
			test.appendChild(test);


			String sd = input[60][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[60][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = UploadOCP.ocptestcase(data1, rc, "UploadOCP",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=61)
	public static void AnalyticsRefuelTransactions() throws Exception

	{		if(input[61][0].equalsIgnoreCase("AnalyticsRefuelTransactions") && input[61][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("AnalyticsRefuelTransactions");
			test.appendChild(test);


			String sd = input[61][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[61][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = AnalyticsRefuelTransactions.refueltranstestcase(data1, rc, "AnalyticsRefuelTransactions",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=62)
	public static void AnalyticsReeferPerformance() throws Exception

	{		if(input[62][0].equalsIgnoreCase("AnalyticsReeferPerformance") && input[62][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("AnalyticsReeferPerformance");
			test.appendChild(test);


			String sd = input[62][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[62][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = AnalyticsReeferPerformance.reeferperftestcase(data1, rc, "AnalyticsReeferPerformance",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=63)
	public static void RFLEvents() throws Exception

	{		if(input[63][0].equalsIgnoreCase("RFLEvents") && input[63][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("RFLEvents");
			test.appendChild(test);


			String sd = input[63][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[63][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = RFLEvents.rfleventstestcase(data1, rc, "RFLEvents",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=64)
	public static void AlalyticsFuelUsageSummary() throws Exception

	{		if(input[64][0].equalsIgnoreCase("AlalyticsFuelUsageSummary") && input[64][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("AlalyticsFuelUsageSummary");
			test.appendChild(test);


			String sd = input[64][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[64][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = AnalyticsFuelUsageSummary.analyticsfuelusagetestcase(data1, rc, "AlalyticsFuelUsageSummary",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=65)
	public static void FuelEntryExitSummary() throws Exception

	{		if(input[65][0].equalsIgnoreCase("FuelEntryExitSummary") && input[65][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("FuelEntryExitSummary");
			test.appendChild(test);


			String sd = input[65][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[65][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = FuelEntryExitSummary.entryexittestcase(data1, rc, "FuelEntryExitSummary",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}
	@Test (priority=66)
	public static void FuelEntryExitDetail() throws Exception

	{		if(input[66][0].equalsIgnoreCase("FuelEntryExitDetail") && input[66][1].equalsIgnoreCase("Y"))
		{

			ExtentTest test =reports.startTest("FuelEntryExitDetail");
			test.appendChild(test);


			String sd = input[66][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);

			String ed = input[66][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);

			data1 = FuelEntryExitDetail.entryexitdetailtestcase(data1, rc, "FuelEntryExitDetail",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);

		}

	}

	@AfterSuite
	public static void tearDown() throws AddressException, MessagingException{

		excel.writeoutput(data, "Output");
		TestUtil.zip(System.getProperty("user.dir")+"\\TestResults");
		Mail M = new Mail();
		M.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
	}

}
