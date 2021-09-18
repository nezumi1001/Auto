package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
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

import info.iData_JPN;
import listener.Lis_WebDriverEventListener_JPN;
import main.Func_All_JPN;

public class Test_NavData_JPN {
	private Func_All_JPN mf;
	private WebDriver driver;
	private EventFiringWebDriver eDriver;
	private String topMenu;
	private File my_path = new File(System.getProperty("user.dir"));

	// Create data (IP)
	public void create_IP() throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("IP");
		// Create 2 row
		for (int new_row = 0; new_row < 2; new_row++) {
			sheet.createRow(new_row);
		}
		// Create .\\Data\\IP folder if not exists
		File file_IP = new File(my_path + "\\Data\\IP");
		if (!file_IP.exists()) {
			file_IP.mkdir();
		}
		// Write data
		FileOutputStream out = new FileOutputStream(my_path + "\\Data\\IP\\Box_IP.xls");
		workbook.write(out);
		out.close();
		workbook.close();
	}

	// Import data (IP)
	public void update_IP(List<String> Box_IP) throws IOException {
		FileInputStream fs = new FileInputStream(my_path + "\\Data\\IP\\Box_IP.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workbook.getSheet("IP");
		HSSFRow row = null;
		// Input data
		for (int i = 0; i < 2; i++) {
			row = sheet.getRow(i);
			row.createCell(0).setCellValue(Box_IP.get(i));
		}
		// Auto column
		for (int auto_column = 0; auto_column < row.getLastCellNum(); auto_column++) {
			sheet.autoSizeColumn(auto_column);
		}
		// Write data
		FileOutputStream out = new FileOutputStream(my_path + "\\Data\\IP\\Box_IP.xls");
		workbook.write(out);
		out.close();
		workbook.close();
	}

	@BeforeClass
	public void beforeClass() throws InterruptedException, IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// Create Box_IP.xls
//		create_IP();
		// Enter Box IP JPN
//		System.out.println("[P]Print out >> Please enter your Box IP for [JPN]:");
//		Scanner s_JPN = new java.util.Scanner(System.in);
//		String boxIP_JPN = s_JPN.next();
		// Enter Box IP ENG
//		System.out.println("[P]Print out >> Please enter your Box IP for [ENG]:");
//		Scanner s_ENG = new java.util.Scanner(System.in);
//		String boxIP_ENG = s_ENG.next();
		// Update data >> IP
//		List<String> boxIPs = new ArrayList<String>();
//		boxIPs.add(boxIP_JPN);
//		boxIPs.add(boxIP_ENG);
//		update_IP(boxIPs);
//		s_JPN.close();
//		s_ENG.close();
		// ChromeDriver Settings
		System.setProperty(iData_JPN.chromeDriver_name, iData_JPN.chromeDriver_path);
		ChromeOptions chromOptions = new ChromeOptions();
		chromOptions.addArguments("--start-maximized", "--ignore-certificate-errors", "--lang=ja-JP");
		driver = new ChromeDriver(chromOptions);
		// WebDriverEventListener
		eDriver = new EventFiringWebDriver(driver);
		Lis_WebDriverEventListener_JPN lis = new Lis_WebDriverEventListener_JPN();
		eDriver.register(lis);
//		eDriver.get(iData_JPN.baseUrl + boxIP_JPN);
		eDriver.get(iData_JPN.baseUrl);
		mf = new Func_All_JPN(eDriver);
		mf.start_exReport();
		mf.log_message(testName, "Got your Box IP for [JPN]: " + iData_JPN.baseUrl, "");
	}

	// Actual data
	public List<String> actual_data(String top_menu) throws InterruptedException {
		// [M]Find and expand all menu (left pane)
		List<WebElement> expandMenus = mf.find_elements(iData_JPN.DarkMenu_LeftPane_type,
				iData_JPN.DarkMenu_LeftPane_path);
		mf.expand_menu(expandMenus, top_menu);
		// [W]Wait and find all menu (left pane)
		mf.wait_element(iData_JPN.LeftPane_type, iData_JPN.LeftPane_path);
		List<WebElement> leftPaneMenus = mf.find_elements(iData_JPN.LeftPane_type, iData_JPN.LeftPane_path);
		// [M]Add menu JPN > ENG
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
	public void test_Step01_Login_JPN() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [WA]Enter "ユーザ名"
		mf.wait_element(iData_JPN.userName_type, iData_JPN.userName_path).sendKeys("admin");
		// [WA]Enter "パスワード"
		mf.wait_element(iData_JPN.password_type, iData_JPN.password_path).sendKeys("password");
		// [WA]Click "ログイン"
		mf.wait_element(iData_JPN.login_type, iData_JPN.login_path).click();
		// [L]Log
		mf.log_message(testName, "Login to main page...", "");
	}

	@Test
	public void test_Step02_HomeMenu_Top_JPN() throws Exception {
		topMenu = "HOME";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [WA]Click HOME menu (top page)
		if (mf.wait_element_short(iData_JPN.HomeMenu_Top_type, iData_JPN.HomeMenu_Top_path) != null) {
			mf.wait_element_short(iData_JPN.HomeMenu_Top_type, iData_JPN.HomeMenu_Top_path).click();
		} else {
			// [WA]Preempt
			mf.wait_element(iData_JPN.preempt_type, iData_JPN.preempt_path).click();
			mf.log_message(testName, "Preempt the box...", "");
		}
		// [WA]Click ホーム menu (top page)
		mf.wait_element(iData_JPN.HomeMenu_Top_type, iData_JPN.HomeMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element(iData_JPN.Dashboard_System_type, iData_JPN.Dashboard_System_path);
		
		// [WA]Get info
		String Device_Name_JPN = mf.wait_element(iData_JPN.Box_Name_type, iData_JPN.Box_Name_path).getText();
		String Serial_Number_JPN = mf.wait_element(iData_JPN.Serial_Number_type, iData_JPN.Serial_Number_path).getText();
		String Firmware_Version_JPN = mf.wait_element(iData_JPN.Firmware_Version_type, iData_JPN.Firmware_Version_path).getText();
		List<String> info_JPNs = new ArrayList<String>();
		info_JPNs.add(Device_Name_JPN);
		info_JPNs.add(Serial_Number_JPN);
		info_JPNs.add(Firmware_Version_JPN);
		// Create info >> Excel
		mf.create_info();
		// [L]Log
		mf.log_message(testName, "Got info for [JPN]!", "");
		// Update info >> Excel
		mf.update_info(info_JPNs, 0);

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
	public void test_Step03_MonitorMenu_Top_JPN() throws Exception {
		topMenu = "MONITOR";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [WA]Click 監視 menu (top page)
		mf.wait_element(iData_JPN.MonitorMenu_Top_type, iData_JPN.MonitorMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element(iData_JPN.RealTimeCharts_SystemMonitor_type, iData_JPN.RealTimeCharts_SystemMonitor_path);
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
	public void test_Step04_DeviceMenu_Top_JPN() throws Exception {
		topMenu = "DEVICE";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click デバイス menu (top page)
		mf.wait_element(iData_JPN.DeviceMenu_Top_type, iData_JPN.DeviceMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element(iData_JPN.Settings_Licenses_type, iData_JPN.Settings_Licenses_path);
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
	public void test_Step05_NetworkMenu_Top_JPN() throws Exception {
		topMenu = "NETWORK";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click ネットワーク menu (top page)
		mf.wait_element(iData_JPN.NetworkMenu_Top_type, iData_JPN.NetworkMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element(iData_JPN.System_Interfaces_type, iData_JPN.System_Interfaces_path);
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
	public void test_Step06_ObjectMenu_Top_JPN() throws Exception {
		topMenu = "OBJECT";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click オブジェクト menu (top page)
		mf.wait_element(iData_JPN.ObjectMenu_Top_type, iData_JPN.ObjectMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element(iData_JPN.MatchObjects_Zones_type, iData_JPN.MatchObjects_Zones_path);
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
	public void test_Step07_PolicyMenu_Top_JPN() throws Exception {
		topMenu = "POLICY";
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// [A]Click ポリシー menu (top page)
		mf.wait_element(iData_JPN.PolicyMenu_Top_type, iData_JPN.PolicyMenu_Top_path).click();
		// [W]Wait right page title (by default)
		mf.wait_element(iData_JPN.RulesPolicies_AccessRules_type, iData_JPN.RulesPolicies_AccessRules_path);
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