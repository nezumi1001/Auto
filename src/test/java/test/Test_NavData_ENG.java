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

import info.iData_ENG;
import main.Func_ENG;

public class Test_NavData_ENG {
	private Func_ENG mf;
	private WebDriver driver;
	private String topMenu;

	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException {
//		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// ChromeDriver Settings
		System.setProperty(iData_ENG.chromeDriver_data[0], iData_ENG.chromeDriver_data[1]);
		ChromeOptions chromOptions = new ChromeOptions();
		chromOptions.addArguments("--start-maximized", "--ignore-certificate-errors", "--lang=en-US");
		driver = new ChromeDriver(chromOptions);
		driver.get(iData_ENG.baseUrl);
		mf = new Func_ENG(driver);
		mf.start_exReport();
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(),
				"Before Navigate To..." + iData_ENG.baseUrl + "[ENG]");
	}

	// Actual data
	public List<String> actual_data(String top_menu) throws InterruptedException {
		// [M]Find and expand all menu (left pane)
		List<WebElement> expandMenus = mf.find_elements("xpath", iData_ENG.DarkMenu_LeftPane_path);
		mf.expand_menu(expandMenus, top_menu);
		// [W]Wait and find all menu (left pane)
		mf.wait_element("xpath", iData_ENG.LeftPane_path);
		List<WebElement> leftPaneMenus = mf.find_elements("xpath", iData_ENG.LeftPane_path);
		// [M]Add menu ENG
		List<String> actual_data = mf.vs_elements(leftPaneMenus, top_menu);
		return actual_data;
	}

	@Test
	public void test_Step01_Login_ENG() throws Exception {
//		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [WA]Enter "Username"
		mf.wait_element("xpath", iData_ENG.userName_path).sendKeys(iData_ENG.login_name);
		// [WA]Enter "Password"
		mf.wait_element("xpath", iData_ENG.password_path).sendKeys(iData_ENG.login_pass);
		// [WA]Click "ログイン"
		mf.wait_element("xpath", iData_ENG.login_path).click();
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Login to main page...");
	}

	@Test
	public void test_Step02_HomeMenu_Top_ENG() throws Exception {
		topMenu = "HOME";
//		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [WA]Click HOME menu (top page)
		if (mf.wait_element_short("xpath", iData_ENG.HomeMenu_Top_path) != null) {
			mf.wait_element_short("xpath", iData_ENG.HomeMenu_Top_path).click();
		} else {
			// [WA]Preempt
			mf.wait_element("xpath", iData_ENG.preempt_path).click();
			mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Preempt the box...");
			mf.wait_element("xpath", iData_ENG.HomeMenu_Top_path).click();
		}
		// [W]Wait right page title (by default)
		mf.wait_element("xpath", iData_ENG.Dashboard_System_path);

		// [WA]Get info
		String Device_Name_ENG = mf.wait_element("xpath", iData_ENG.Box_Name_path).getText();
		String Serial_Number_ENG = mf.wait_element("xpath", iData_ENG.Serial_Number_path).getText();
		String Firmware_Version_ENG = mf.wait_element("xpath", iData_ENG.Firmware_Version_path).getText();
		List<String> info_ENGs = new ArrayList<String>();
		info_ENGs.add(Device_Name_ENG);
		info_ENGs.add(Serial_Number_ENG);
		info_ENGs.add(Firmware_Version_ENG);
		// Create info >> Excel
		mf.create_info();
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Got info for [ENG]!");
		// Update info >> Excel
		mf.update_info(info_ENGs, 0);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
		// Create data >> Excel
		mf.create_data();
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Data created!");
		// Update data >> Excel
		mf.update_data(actualData, 0);
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Data updated!");
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(),
				"Top menu " + "'" + topMenu + "'" + " is done!");
	}

	@Test
	public void test_Step03_MonitorMenu_Top_ENG() throws Exception {
		topMenu = "MONITOR";
//		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [WA]Click MONITOR menu (top page)
		mf.wait_element("xpath", iData_ENG.MonitorMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element("xpath", iData_ENG.RealTimeCharts_SystemMonitor_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
		// Update data >> Excel
		mf.update_data(actualData, 1);
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Data updated!");
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(),
				"Top menu " + "'" + topMenu + "'" + " is done!");
	}

	@Test
	public void test_Step04_DeviceMenu_Top_ENG() throws Exception {
		topMenu = "DEVICE";
//		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click DEVICE menu (top page)
		mf.wait_element("xpath", iData_ENG.DeviceMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element("xpath", iData_ENG.Settings_Licenses_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
		// Update data >> Excel
		mf.update_data(actualData, 2);
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Data updated!");
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(),
				"Top menu " + "'" + topMenu + "'" + " is done!");
	}

	@Test
	public void test_Step05_NetworkMenu_Top_ENG() throws Exception {
		topMenu = "NETWORK";
//		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click NETWORK menu (top page)
		mf.wait_element("xpath", iData_ENG.NetworkMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element("xpath", iData_ENG.System_Interfaces_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
		// Update data >> Excel
		mf.update_data(actualData, 3);
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Data updated!");
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(),
				"Top menu " + "'" + topMenu + "'" + " is done!");
	}

	@Test
	public void test_Step06_ObjectMenu_Top_ENG() throws Exception {
		topMenu = "OBJECT";
//		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click OBJECT menu (top page)
		mf.wait_element("xpath", iData_ENG.ObjectMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element("xpath", iData_ENG.MatchObjects_Zones_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
		// Update data >> Excel
		mf.update_data(actualData, 4);
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Data updated!");
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(),
				"Top menu " + "'" + topMenu + "'" + " is done!");
	}

	@Test
	public void test_Step07_PolicyMenu_Top_ENG() throws Exception {
		topMenu = "POLICY";
//		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click POLICY menu (top page)
		mf.wait_element("xpath", iData_ENG.PolicyMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element("xpath", iData_ENG.RulesPolicies_AccessRules_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
		// Update data >> Excel
		mf.update_data(actualData, 5);
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(), "Data updated!");
		// [L]Log
		mf.log_message(Thread.currentThread().getStackTrace()[1].getMethodName(),
				"Top menu " + "'" + topMenu + "'" + " is done!");
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