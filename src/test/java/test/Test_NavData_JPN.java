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
	private String topMenu;

	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// ChromeDriver Settings
		System.setProperty(iData_JPN.chromeDriver_data[0], iData_JPN.chromeDriver_data[1]);
		ChromeOptions chromOptions = new ChromeOptions();
		chromOptions.addArguments("--start-maximized", "--ignore-certificate-errors", "--lang=ja-JP");
		driver = new ChromeDriver(chromOptions);
		driver.get(iData_JPN.baseUrl);
		mf = new Func_JPN(driver);
		mf.start_exReport();
		mf.log_message(testName, "Before Navigate To..." + "[JPN]" + iData_JPN.baseUrl);
	}

	// Actual data
	public List<String> actual_data(String top_menu) throws InterruptedException {
		// [M]Find and expand all menu (left pane)
		List<WebElement> expandMenus = mf.find_elements("xpath", iData_JPN.DarkMenu_LeftPane_path);
		mf.expand_menu(expandMenus, top_menu);
		// [W]Wait and find all menu (left pane)
		mf.wait_element("xpath", iData_JPN.LeftPane_path);
		List<WebElement> leftPaneMenus = mf.find_elements("xpath", iData_JPN.LeftPane_path);
		// [M]Add menu JPN > ENG
		List<String> actual_data = mf.vs_elements(leftPaneMenus, top_menu);
		return actual_data;
	}

	@Test
	public void test_Step01_Login_JPN() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [WA]Enter "ユーザ名"
		mf.wait_element("xpath", iData_JPN.userName_path).sendKeys(iData_JPN.login_name);
		// [WA]Enter "パスワード"
		mf.wait_element("xpath", iData_JPN.password_path).sendKeys(iData_JPN.login_pass);
		// [WA]Click "ログイン"
		mf.wait_element("xpath", iData_JPN.login_path).click();
		// [L]Log
		mf.log_message(testName, "Login to main page...");
	}

	@Test
	public void test_Step02_HomeMenu_Top_JPN() throws Exception {
		topMenu = "HOME";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [WA]Click HOME menu (top page)
		if (mf.wait_element_short("xpath", iData_JPN.HomeMenu_Top_path) != null) {
			mf.wait_element_short("xpath", iData_JPN.HomeMenu_Top_path).click();
		} else {
			// [WA]Preempt
			mf.wait_element("xpath", iData_JPN.preempt_path).click();
			mf.log_message(testName, "Preempt the box...");
		}
		// [WA]Click ホーム menu (top page)
		mf.wait_element("xpath", iData_JPN.HomeMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element("xpath", iData_JPN.Dashboard_System_path);

		// [WA]Get info
		String Device_Name_JPN = mf.wait_element("xpath", iData_JPN.Box_Name_path).getText();
		String Serial_Number_JPN = mf.wait_element("xpath", iData_JPN.Serial_Number_path).getText();
		String Firmware_Version_JPN = mf.wait_element("xpath", iData_JPN.Firmware_Version_path).getText();
		List<String> info_JPNs = new ArrayList<String>();
		info_JPNs.add(Device_Name_JPN);
		info_JPNs.add(Serial_Number_JPN);
		info_JPNs.add(Firmware_Version_JPN);
		// Create info >> Excel
		mf.create_info();
		// [L]Log
		mf.log_message(testName, "Got info for [JPN]!");
		// Update info >> Excel
		mf.update_info(info_JPNs, 0);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
		// Create data >> Excel
		mf.create_data();
		// [L]Log
		mf.log_message(testName, "Data created!");
		// Update data >> Excel
		mf.update_data(actualData, 0);
		// [L]Log
		mf.log_message(testName, "Data updated!");
		// [L]Log
		mf.log_message(testName, "Top menu " + "'" + topMenu + "'" + " is done!");
	}

	@Test
	public void test_Step03_MonitorMenu_Top_JPN() throws Exception {
		topMenu = "MONITOR";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [WA]Click 監視 menu (top page)
		mf.wait_element("xpath", iData_JPN.MonitorMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element("xpath", iData_JPN.RealTimeCharts_SystemMonitor_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
		// Update data >> Excel
		mf.update_data(actualData, 1);
		// [L]Log
		mf.log_message(testName, "Data updated!");
		// [L]Log
		mf.log_message(testName, "Top menu " + "'" + topMenu + "'" + " is done!");
	}

	@Test
	public void test_Step04_DeviceMenu_Top_JPN() throws Exception {
		topMenu = "DEVICE";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click デバイス menu (top page)
		mf.wait_element("xpath", iData_JPN.DeviceMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element("xpath", iData_JPN.Settings_Licenses_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
		// Update data >> Excel
		mf.update_data(actualData, 2);
		// [L]Log
		mf.log_message(testName, "Data updated!");
		// [L]Log
		mf.log_message(testName, "Top menu " + "'" + topMenu + "'" + " is done!");
	}

	@Test
	public void test_Step05_NetworkMenu_Top_JPN() throws Exception {
		topMenu = "NETWORK";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click ネットワーク menu (top page)
		mf.wait_element("xpath", iData_JPN.NetworkMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element("xpath", iData_JPN.System_Interfaces_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
		// Update data >> Excel
		mf.update_data(actualData, 3);
		// [L]Log
		mf.log_message(testName, "Data updated!");
		// [L]Log
		mf.log_message(testName, "Top menu " + "'" + topMenu + "'" + " is done!");
	}

	@Test
	public void test_Step06_ObjectMenu_Top_JPN() throws Exception {
		topMenu = "OBJECT";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click オブジェクト menu (top page)
		mf.wait_element("xpath", iData_JPN.ObjectMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element("xpath", iData_JPN.MatchObjects_Zones_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
		// Update data >> Excel
		mf.update_data(actualData, 4);
		// [L]Log
		mf.log_message(testName, "Data updated!");
		// [L]Log
		mf.log_message(testName, "Top menu " + "'" + topMenu + "'" + " is done!");
	}

	@Test
	public void test_Step07_PolicyMenu_Top_JPN() throws Exception {
		topMenu = "POLICY";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click ポリシー menu (top page)
		mf.wait_element("xpath", iData_JPN.PolicyMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element("xpath", iData_JPN.RulesPolicies_AccessRules_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
		// Update data >> Excel
		mf.update_data(actualData, 5);
		// [L]Log
		mf.log_message(testName, "Data updated!");
		// [L]Log
		mf.log_message(testName, "Top menu " + "'" + topMenu + "'" + " is done!");
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