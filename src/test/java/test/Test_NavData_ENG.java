package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import info.iData_ENG;
import listener.Lis_WebDriverEventListener_ENG;
import main.Func_All_ENG;

public class Test_NavData_ENG {
	private Func_All_ENG mf;
	private WebDriver driver;
	private EventFiringWebDriver eDriver;
	private String topMenu;
	private File my_path = new File(System.getProperty("user.dir"));

	// Import data only (IP)
	public String box_IP_ENG() throws IOException {
		FileInputStream fs_ENG = new FileInputStream(my_path + "\\Data\\IP\\Box_IP.xls");
		HSSFWorkbook workbook_ENG = new HSSFWorkbook(fs_ENG);
		HSSFSheet sheet = workbook_ENG.getSheet("IP");
		// Get data ENG
		HSSFCell data_IP_ENG = sheet.getRow(1).getCell(0);
		String dataIP_ENG = null;
		if (data_IP_ENG != null) {
			dataIP_ENG = data_IP_ENG.getStringCellValue();
		}
		workbook_ENG.close();
		return dataIP_ENG;
	}

	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// Get Box IP ENG
//		Thread.sleep(3000);
//		String boxIP_ENG = null;
//		while (boxIP_ENG == null) {
//			boxIP_ENG = box_IP_ENG();
//			Thread.sleep(3000);
//		}
		// ChromeDriver Settings
		System.setProperty(iData_ENG.chromeDriver_name, iData_ENG.chromeDriver_path);
		ChromeOptions chromOptions = new ChromeOptions();
		chromOptions.addArguments("--start-maximized", "--ignore-certificate-errors", "--lang=en-US");
		driver = new ChromeDriver(chromOptions);
		// WebDriverEventListener
		eDriver = new EventFiringWebDriver(driver);
		Lis_WebDriverEventListener_ENG lis = new Lis_WebDriverEventListener_ENG();
		eDriver.register(lis);
//		eDriver.get(iData_ENG.baseUrl + boxIP_ENG);
		eDriver.get(iData_ENG.baseUrl);
		mf = new Func_All_ENG(eDriver);
		mf.start_exReport();
		mf.log_message(testName, "Got your Box IP for [ENG]: " + iData_ENG.baseUrl, "");
	}

	// Actual data
	public List<String> actual_data(String top_menu) throws InterruptedException {
		// [M]Find and expand all menu (left pane)
		List<WebElement> expandMenus = mf.find_elements(iData_ENG.DarkMenu_LeftPane_type,
				iData_ENG.DarkMenu_LeftPane_path);
		mf.expand_menu(expandMenus, top_menu);
		// [W]Wait and find all menu (left pane)
		mf.wait_element(iData_ENG.LeftPane_type, iData_ENG.LeftPane_path);
		List<WebElement> leftPaneMenus = mf.find_elements(iData_ENG.LeftPane_type, iData_ENG.LeftPane_path);
		// [M]Add menu ENG
		List<String> actual_data = mf.vs_elements(leftPaneMenus, top_menu);
		return actual_data;
	}

	// Expect data
	public List<String> expect_data(String[] menu_list) {
		// [M]Get menu ENG
		List<String> expect_data = Arrays.asList(menu_list);
		return expect_data;
	}

	@Test
	public void test_Step01_Login_ENG() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [WA]Enter "Username"
		mf.wait_element(iData_ENG.userName_type, iData_ENG.userName_path).sendKeys("admin");
		// [WA]Enter "Password"
		mf.wait_element(iData_ENG.password_type, iData_ENG.password_path).sendKeys("password");
		// [WA]Click "ログイン"
		mf.wait_element(iData_ENG.login_type, iData_ENG.login_path).click();
		// [L]Log
		mf.log_message(testName, "Login to main page...", "");
	}

	@Test
	public void test_Step02_HomeMenu_Top_ENG() throws Exception {
		topMenu = "HOME";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [WA]Click HOME menu (top page)
		if (mf.wait_element_short(iData_ENG.HomeMenu_Top_type, iData_ENG.HomeMenu_Top_path) != null) {
			mf.wait_element_short(iData_ENG.HomeMenu_Top_type, iData_ENG.HomeMenu_Top_path).click();
		} else {
			// [WA]Preempt
			mf.wait_element(iData_ENG.preempt_type, iData_ENG.preempt_path).click();
			mf.log_message(testName, "Preempt the box...", "");
		}
		// [WA]Click HOME menu (top page)
		mf.wait_element(iData_ENG.HomeMenu_Top_type, iData_ENG.HomeMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element(iData_ENG.Dashboard_System_type, iData_ENG.Dashboard_System_path);

		// [WA]Get info
		String Device_Name_ENG = mf.wait_element(iData_ENG.Box_Name_type, iData_ENG.Box_Name_path).getText();
		String Serial_Number_ENG = mf.wait_element(iData_ENG.Serial_Number_type, iData_ENG.Serial_Number_path)
				.getText();
		String Firmware_Version_ENG = mf.wait_element(iData_ENG.Firmware_Version_type, iData_ENG.Firmware_Version_path)
				.getText();
		List<String> info_ENGs = new ArrayList<String>();
		info_ENGs.add(Device_Name_ENG);
		info_ENGs.add(Serial_Number_ENG);
		info_ENGs.add(Firmware_Version_ENG);
		// Create info >> Excel
		mf.create_info();
		// [L]Log
		mf.log_message(testName, "Got info for [ENG]!", "");
		// Update info >> Excel
		mf.update_info(info_ENGs, 0);

		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
//		List<String> expectData = expect_data(iData.homeList);
		// Create data >> Excel
		mf.create_data();
		// [L]Log
		mf.log_message(testName, "Data created!", "");
		// Update data >> Excel
		mf.update_data(actualData, 0);
		// [L]Log
		mf.log_message(testName, "Data updated!", "");
		// [R]Compare menu (left pane) to myself
//		Assert.assertEquals(expectData.toArray(), actualData.toArray());
		// [L]Log
		mf.log_message(testName, "Top menu " + "'" + topMenu + "'" + " is done!", "");
	}

	@Test
	public void test_Step03_MonitorMenu_Top_ENG() throws Exception {
		topMenu = "MONITOR";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [WA]Click MONITOR menu (top page)
		mf.wait_element(iData_ENG.MonitorMenu_Top_type, iData_ENG.MonitorMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element(iData_ENG.RealTimeCharts_SystemMonitor_type, iData_ENG.RealTimeCharts_SystemMonitor_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
//		List<String> expectData = expect_data(iData.monitorList);
		// Update data >> Excel
		mf.update_data(actualData, 1);
		// [L]Log
		mf.log_message(testName, "Data updated!", "");
		// [R]Compare menu (left pane) to myself
//		Assert.assertEquals(expectData.toArray(), actualData.toArray());
		// [L]Log
		mf.log_message(testName, "Top menu " + "'" + topMenu + "'" + " is done!", "");
	}

	@Test
	public void test_Step04_DeviceMenu_Top_ENG() throws Exception {
		topMenu = "DEVICE";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click DEVICE menu (top page)
		mf.wait_element(iData_ENG.DeviceMenu_Top_type, iData_ENG.DeviceMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element(iData_ENG.Settings_Licenses_type, iData_ENG.Settings_Licenses_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
//		List<String> expectData = expect_data(iData.deviceList);
		// Update data >> Excel
		mf.update_data(actualData, 2);
		// [L]Log
		mf.log_message(testName, "Data updated!", "");
		// [R]Compare menu (left pane) to myself
//		Assert.assertEquals(expectData.toArray(), actualData.toArray());
		// [L]Log
		mf.log_message(testName, "Top menu " + "'" + topMenu + "'" + " is done!", "");
	}

	@Test
	public void test_Step05_NetworkMenu_Top_ENG() throws Exception {
		topMenu = "NETWORK";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click NETWORK menu (top page)
		mf.wait_element(iData_ENG.NetworkMenu_Top_type, iData_ENG.NetworkMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element(iData_ENG.System_Interfaces_type, iData_ENG.System_Interfaces_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
//		List<String> expectData = expect_data(iData.networkList);
		// Update data >> Excel
		mf.update_data(actualData, 3);
		// [L]Log
		mf.log_message(testName, "Data updated!", "");
		// [R]Compare menu (left pane) to myself
//		Assert.assertEquals(expectData.toArray(), actualData.toArray());
		// [L]Log
		mf.log_message(testName, "Top menu " + "'" + topMenu + "'" + " is done!", "");
	}

	@Test
	public void test_Step06_ObjectMenu_Top_ENG() throws Exception {
		topMenu = "OBJECT";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click OBJECT menu (top page)
		mf.wait_element(iData_ENG.ObjectMenu_Top_type, iData_ENG.ObjectMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element(iData_ENG.MatchObjects_Zones_type, iData_ENG.MatchObjects_Zones_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
//		List<String> expectData = expect_data(iData.objectList);
		// Update data >> Excel
		mf.update_data(actualData, 4);
		// [L]Log
		mf.log_message(testName, "Data updated!", "");
		// [R]Compare menu (left pane) to myself
//		Assert.assertEquals(expectData.toArray(), actualData.toArray());
		// [L]Log
		mf.log_message(testName, "Top menu " + "'" + topMenu + "'" + " is done!", "");
	}

	@Test
	public void test_Step07_PolicyMenu_Top_ENG() throws Exception {
		topMenu = "POLICY";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click POLICY menu (top page)
		mf.wait_element(iData_ENG.PolicyMenu_Top_type, iData_ENG.PolicyMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element(iData_ENG.RulesPolicies_AccessRules_type, iData_ENG.RulesPolicies_AccessRules_path);
		// [M]Get compare data
		List<String> actualData = actual_data(topMenu);
//		List<String> expectData = expect_data(iData.policyList);
		// Update data >> Excel
		mf.update_data(actualData, 5);
		// [L]Log
		mf.log_message(testName, "Data updated!", "");
		// [R]Compare menu (left pane) to myself
//		Assert.assertEquals(expectData.toArray(), actualData.toArray());
		// [L]Log
		mf.log_message(testName, "Top menu " + "'" + topMenu + "'" + " is done!", "");
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws Exception {
		// Take screenshot [Pass] or [Fail]
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			mf.take_screenshot(testResult.getName(), "[PASS]");
			mf.log_message(testResult.getName(), "[Pass]Take screenshot...", "");
		} else if (testResult.getStatus() == ITestResult.FAILURE) {
			mf.take_screenshot(testResult.getName(), "[FAIL]");
			mf.log_message(testResult.getName(), "[Fail]Take screenshot...", "");
		}
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		eDriver.quit();
		mf.close_exReport();
	}
}