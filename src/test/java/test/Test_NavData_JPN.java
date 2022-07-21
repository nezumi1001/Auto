package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import info.iData_JPN;
import main.Func_JPN;

public class Test_NavData_JPN {
	private Func_JPN mf;
	private WebDriver driver;
	private List<String> actualData;
	private int Preempt;

	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException {
		// [A]ChromeDriver Settings
		System.setProperty(iData_JPN.chromeDriver_data[0], iData_JPN.chromeDriver_data[1]);
		ChromeOptions chromOptions = new ChromeOptions();
		chromOptions.addArguments("--user-data-dir=C:\\Users\\khuang\\AppData\\Local\\Google\\Chrome\\User Data3");
		chromOptions.addArguments("--start-maximized", "--ignore-certificate-errors", "--lang=ja-JP");
		chromOptions.addArguments("--incognito");
		driver = new ChromeDriver(chromOptions);
		driver.get(iData_JPN.baseUrl);
		mf = new Func_JPN(driver);
		mf.start_exReport();
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(),
				"Before Navigate To..." + iData_JPN.baseUrl + "[JPN]");
	}

	// Actual data
	public List<String> actual_data(String top_menu) throws InterruptedException {
		// [M]Find and expand all menu (left pane)
		mf.wait_element("xpath", iData_JPN.DarkMenu_LeftPane_path);
		List<WebElement> expandMenus = mf.find_elements("xpath", iData_JPN.DarkMenu_LeftPane_path);
		List<String> actual_data = mf.expand_menu(expandMenus, top_menu);
		return actual_data;
	}

	// Click Top menu
	public void top_menu_click(String topMenu) throws InterruptedException {
		// [M]Click top menu > main menu > sub menu
		if (topMenu.equals("HOME")) {
			mf.wait_element("xpath", iData_JPN.HomeMenu_Top_path).click();
			mf.wait_element("xpath", iData_JPN.HomeMenu_Dashboard_path).click();
			mf.wait_element("xpath", iData_JPN.HomeMenu_System_path).click();
			mf.wait_element("xpath", iData_JPN.HomeMenu_System_title_path);
		}
		if (topMenu.equals("MONITOR")) {
			mf.wait_element("xpath", iData_JPN.MonitorMenu_Top_path).click();
			mf.wait_element("xpath", iData_JPN.MonitorMenu_RealTimeCharts_path).click();
			mf.wait_element("xpath", iData_JPN.MonitorMenu_SystemMonitor_path).click();
			mf.wait_element("xpath", iData_JPN.MonitorMenu_SystemMonitor_title_path);
		}
		if (topMenu.equals("DEVICE")) {
			mf.wait_element("xpath", iData_JPN.DeviceMenu_Top_path).click();
			mf.wait_element("xpath", iData_JPN.DeviceMenu_Settings_path).click();
			mf.wait_element("xpath", iData_JPN.DeviceMenu_Licenses_path).click();
			mf.wait_element("xpath", iData_JPN.DeviceMenu_Licenses_title_path);
		}
		if (topMenu.equals("NETWORK")) {
			mf.wait_element("xpath", iData_JPN.NetworkMenu_Top_path).click();
			mf.wait_element("xpath", iData_JPN.NetworkMenu_System_path).click();
			mf.wait_element("xpath", iData_JPN.NetworkMenu_Interfaces_path).click();
			mf.wait_element("xpath", iData_JPN.NetworkMenu_Interfaces_title_path);
		}
		if (topMenu.equals("OBJECT")) {
			mf.wait_element("xpath", iData_JPN.ObjectMenu_Top_path).click();
			mf.wait_element("xpath", iData_JPN.ObjectMenu_MatchObjects_path).click();
			mf.wait_element("xpath", iData_JPN.ObjectMenu_Zones_path).click();
			mf.wait_element("xpath", iData_JPN.ObjectMenu_Zones_title_path);
		}
		if (topMenu.equals("POLICY")) {
			mf.wait_element("xpath", iData_JPN.PolicyMenu_Top_path).click();
			mf.wait_element("xpath", iData_JPN.PolicyMenu_RulesPolicies_path).click();
			mf.wait_element("xpath", iData_JPN.PolicyMenu_AccessRules_path).click();
			mf.wait_element("xpath", iData_JPN.PolicyMenu_AccessRules_title_path);
		}
	}

	@Test
	public void test_Step01_Login_JPN() throws Exception {
		// [A]Enter "ユーザ名"
		mf.wait_element("xpath", iData_JPN.userName_path).sendKeys(iData_JPN.login_name);
		// [A]Enter "パスワード"
		mf.wait_element("xpath", iData_JPN.password_path).sendKeys(iData_JPN.login_pass);
		// [A]Click "ログイン"
		mf.wait_element("xpath", iData_JPN.login_path).click();
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Login to main page...");
		// [A]Preempt
		if (mf.wait_element_short("xpath", iData_JPN.preempt_path) != null) {
			mf.wait_element("xpath", iData_JPN.preempt_path).click();
			mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Preempt the box...");
			Preempt = 1;
		}
	}

	@Test
	public void test_Step02_MenuTop_JPN() throws Exception {
		String[] topMenus = { "HOME", "MONITOR", "DEVICE", "NETWORK", "OBJECT", "POLICY" };
		// [A]Switch to "Non-Config" mode
		if (Preempt == 0) {
			mf.wait_element("xpath", iData_JPN.Config_path).click();
			mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Switch to 'Non-Config' mode...");
		}
		
		// [A]Run all top menu
		for (int i = 0; i < topMenus.length; i++) {
			// [A]Click e.g. ("HOME" > "Main menu" > "Sub menu")
			top_menu_click(topMenus[i]);
			// [A]Special for "HOME" menu
			if (topMenus[i].equals("HOME")) {
				// [A]Get info
				String Device_Name_JPN = mf.wait_element("xpath", iData_JPN.Box_Name_path).getText();
				String Serial_Number_JPN = mf.wait_element("xpath", iData_JPN.Serial_Number_path).getText();
				String Firmware_Version_JPN = mf.wait_element("xpath", iData_JPN.Firmware_Version_path).getText();
				List<String> info_JPNs = new ArrayList<String>();
				info_JPNs.add(Device_Name_JPN);
				info_JPNs.add(Serial_Number_JPN);
				info_JPNs.add(Firmware_Version_JPN);
				// [M]Create info >> Excel
				mf.create_info();
				// [L]Log
				mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Got info for [JPN]!");
				// [M]Update info >> Excel
				mf.update_info(info_JPNs, 0);
				// [M]Get compare data
				actualData = actual_data(topMenus[i]);
				// [M]Create data >> Excel
				mf.create_data();
				// [L]Log
				mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Data created!");
			} else {
				// [M]Get compare data
				actualData = actual_data(topMenus[i]);
			}

			// [M]Update data >> Excel
			mf.update_data(actualData, i);
			// [L]Log
			mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Data updated!");
			// [L]Log
			mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(),
					"Top menu " + "'" + topMenus[i] + "'" + " is done!");
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws Exception {
		// Take screenshot [Pass] or [Fail]
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			mf.take_screenshot(testResult.getName(), "[PASS]");
			mf.log_message(testResult.getName(), "[Pass]Take screenshot...");
		} else if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = mf.take_screenshot(testResult.getName(), "[FAIL]");
			mf.extent_screenshot(path);
			mf.log_message(testResult.getName(), "[Fail]Take screenshot...");
		}
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		mf.close_exReport();
	}
}