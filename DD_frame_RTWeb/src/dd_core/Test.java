package dd_core;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import dd_utils.TestUtil;

public class Test{

	public static void main(String[] args) throws Exception {
		try
		{

		System.setProperty("webdriver.gecko.driver", "\\\\AMXSERVER\\amx-share\\STW_QA\\Jar files\\geckodriver.exe");
		       WebDriver driver = new FirefoxDriver();
		       driver.get("http://www.google.com");
		}
		catch (Exception e)
		{

		e.printStackTrace();

		}

		}

		}