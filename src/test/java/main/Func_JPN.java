package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import info.iData_ENG;
import info.iData_JPN;
import test.Test_NavData_JPN;

public class Func_JPN {
	private WebDriver driver;
	private WebElement we;
	private List<WebElement> ges;
	private String main_handle;
	private Actions ac;
	private String class_name = Test_NavData_JPN.class.getName();
	private Logger log = LogManager.getLogger(class_name);
	private File my_path = new File(System.getProperty("user.dir"));
	private ExtentReports exReport;
	private ExtentTest exTest;

	public Func_JPN(WebDriver driver) {
		this.driver = driver;
	}

	// Page source
	public void page_source() {
		String pageSrc = driver.getPageSource();
		log_message(class_name, pageSrc);
		driver.quit();
	}

	// Start > Extent report
	public void start_exReport() {
		exReport = new ExtentReports(my_path + "\\Log\\report\\ExReport_JPN.html");
		exTest = exReport.startTest("Menu Test > [JPN]");
	}

	// End > Extent report
	public void close_exReport() {
		exReport.endTest(exTest);
		exReport.flush();
	}

	// Log message[S]
	public void log_message(String test_name, String info) {
		log.info(test_name + " > " + info);
		exTest.log(LogStatus.INFO, test_name + " > " + info);
		Reporter.log("[S]ReportLog >> " + test_name + " > " + info, true);
	}

	// Date time
	public String date_time() {
		DateFormat dateformat = new SimpleDateFormat("yyMMdd_HHmm");
		Date my_date = new Date();
		String my_date2 = dateformat.format(my_date);
		return my_date2;
	}

	// Take screenshot
	public String take_screenshot(String file_name, String pass_fail) throws Exception {
		file_name = pass_fail + file_name + "_" + date_time() + ".png";
		String file_path = my_path + "\\Screenshot\\Image\\";
		File src_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src_file, new File(file_path + file_name));
		String file_all = file_path + file_name;
		return file_all;
	}
	
	// Add screenshot > extent report
	public void extent_screenshot(String path) {
		String img_path = exTest.addScreenCapture(path);
		exTest.log(LogStatus.FAIL, "[Failed]", img_path);
	}

	// Mouse action
	public void mouse_action(WebElement item, int option) {
		if (option == 1) {
			ac = new Actions(driver);
			ac.moveToElement(item).perform();
		} else if (option == 2) {
			ac.moveToElement(item).click().perform();
		}
	}

	// Switch iframe
	public void switch_iframe(int option, String type) {
		if (option == 1) {
			if (type.equals("0")) {
				driver.switchTo().frame(0);
			} else if (type.equals("id")) {
				driver.switchTo().frame("id");
			} else if (type.equals("name")) {
				driver.switchTo().frame("name");
			}
		} else if (option == 0) {
			driver.switchTo().defaultContent();
		}
	}

	// Switch windows
	public void switch_window(int option) {
		// Get main window
		if (option == 1) {
			main_handle = driver.getWindowHandle();
		} else if (option == 2) {
			Set<String> all_handles = driver.getWindowHandles();
			for (String handle : all_handles) {
				if (!handle.equals(main_handle)) {
					driver.switchTo().window(handle);
					break;
				}
			}
		} else if (option == 0) {
			driver.switchTo().window(main_handle);
		}

	}

	// Wait element (short time) > preempt
	public WebElement wait_element_short(String type, String path) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			if (type.equals("xpath")) {
				we = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
			}
		} catch (Exception e) {
			log_message(class_name, "Ready to preempt...");
//			System.out.println("[P]Print out >> Ready to preempt...");
			return null;
		}
		return we;
	}

	// Wait element (long time)
	public WebElement wait_element(String type, String path) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			if (type.equals("id")) {
				we = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(path)));
			} else if (type.equals("name")) {
				we = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(path)));
			} else if (type.equals("class")) {
				we = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(path)));
			} else if (type.equals("xpath")) {
				we = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
			}
		} catch (Exception e) {
			log_message(class_name, "Element Not Found!");
//			System.out.println("[P]Print out >> Element Not Found!");
		}
		return we;
	}

	// Find elements
	public List<WebElement> find_elements(String type, String path) {
		try {
			if (type.equals("id")) {
				ges = driver.findElements(By.id(path));
			} else if (type.equals("name")) {
				ges = driver.findElements(By.name(path));
			} else if (type.equals("class")) {
				ges = driver.findElements(By.className(path));
			} else if (type.equals("xpath")) {
				ges = driver.findElements(By.xpath(path));
			}
		} catch (Exception e) {
			log_message(class_name, "Element Not Found!");
//			System.out.println("[P]Print out >> Element Not Found!");
		}
		return ges;
	}

	// Expand menu
	public void expand_menu(List<WebElement> expand_Menus, String top_menu) throws InterruptedException {
		log_message(class_name,
				"'" + top_menu + "'" + " left menu expanded " + "(" + expand_Menus.size() + ")" + ". Please wait...");
//		System.out.println("[P]Print out >> " + "'" + top_menu + "'" + " left menu expanded " + "("
//				+ expand_Menus.size() + ")" + ". Please wait...");
		for (WebElement expand_Menu : expand_Menus) {
			expand_Menu.click();
			Thread.sleep(1000);
		}
	}

	// Create data (info)
	public void create_info() throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("JPN");
		// Create 100 row
		for (int new_row = 0; new_row < 3; new_row++) {
			sheet.createRow(new_row);
		}
		// Create .\\Data\\info folder if not exists
		File file_compare = new File(my_path + "\\Data\\info");
		if (!file_compare.exists()) {
			file_compare.mkdir();
		}
		// Write data
		FileOutputStream out = new FileOutputStream(my_path + "\\Data\\info\\info_JPN.xls");
		workbook.write(out);
		out.close();
		workbook.close();
	}

	// Update data (info)
	public void update_info(List<String> info_list, int menu_column) throws IOException {
		FileInputStream fs = new FileInputStream(my_path + "\\Data\\info\\info_JPN.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workbook.getSheet("JPN");
		HSSFRow row = null;
		// Input data
		for (int i = 0; i < info_list.size(); i++) {
			row = sheet.getRow(i);
			row.createCell(menu_column).setCellValue(info_list.get(i));
		}
		// Auto column
		for (int auto_column = 0; auto_column < row.getLastCellNum(); auto_column++) {
			sheet.autoSizeColumn(auto_column);
		}
		// Write data
		FileOutputStream out = new FileOutputStream(my_path + "\\Data\\info\\info_JPN.xls");
		workbook.write(out);
		out.close();
		workbook.close();
	}

	// Create data (menu)
	public void create_data() throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("JPN");
		// Create 100 row
		for (int new_row = 0; new_row < 100; new_row++) {
			sheet.createRow(new_row);
		}
		// Create .\\Data\\compare folder if not exists
		File file_compare = new File(my_path + "\\Data\\compare");
		if (!file_compare.exists()) {
			file_compare.mkdir();
		}
		// Write data
		FileOutputStream out = new FileOutputStream(my_path + "\\Data\\compare\\Box_JPN.xls");
		workbook.write(out);
		out.close();
		workbook.close();
	}

	// Update data (menu)
	public void update_data(List<String> MENU_list, int menu_column) throws IOException {
		FileInputStream fs = new FileInputStream(my_path + "\\Data\\compare\\Box_JPN.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workbook.getSheet("JPN");
		HSSFRow row = null;
		// Input data
		for (int i = 0; i < MENU_list.size(); i++) {
			row = sheet.getRow(i);
			row.createCell(menu_column).setCellValue(MENU_list.get(i));
		}
		// Auto column
		for (int auto_column = 0; auto_column < row.getLastCellNum(); auto_column++) {
			sheet.autoSizeColumn(auto_column);
		}
		// Write data
		FileOutputStream out = new FileOutputStream(my_path + "\\Data\\compare\\Box_JPN.xls");
		workbook.write(out);
		out.close();
		workbook.close();
	}

	// VS menu
	public List<String> vs_elements(List<WebElement> left_Menus, String top_menu) {
		List<String> vs_leftMenus = new ArrayList<String>();
		log_message(class_name, "'" + top_menu + "'" + " menu total: " + left_Menus.size());
//		System.out.println("[P]Print out >> " + "'" + top_menu + "'" + " menu total: " + left_Menus.size());
		// Add menu JPN >> ENG
		for (WebElement left_Menu : left_Menus) {
			log_message(class_name, "'" + top_menu + "'" + " left menu: " + left_Menu.getText());
//			System.out.println("[P]Print out >> " + "'" + top_menu + "'" + " left menu: " + left_Menu.getText());
			// HOME
			if (top_menu.equals("HOME")) {
				int menuIndex = Arrays.asList(iData_JPN.leftPane_HOME).indexOf(left_Menu.getText());
				vs_leftMenus.add(iData_ENG.homeList[menuIndex]);
			}

			// MONITOR
			if (top_menu.equals("MONITOR")) {
				int menuIndex = Arrays.asList(iData_JPN.leftPane_MONITOR).indexOf(left_Menu.getText());
				vs_leftMenus.add(iData_ENG.monitorList[menuIndex]);
			}

			// DEVICE
			if (top_menu.equals("DEVICE")) {
				int menuIndex = Arrays.asList(iData_JPN.leftPane_DEVICE).indexOf(left_Menu.getText());
				vs_leftMenus.add(iData_ENG.deviceList[menuIndex]);
			}

			// NETWORK
			if (top_menu.equals("NETWORK")) {
				int menuIndex = Arrays.asList(iData_JPN.leftPane_NETWORK).indexOf(left_Menu.getText());
				vs_leftMenus.add(iData_ENG.networkList[menuIndex]);
			}

			// OBJECT
			if (top_menu.equals("OBJECT")) {
				int menuIndex = Arrays.asList(iData_JPN.leftPane_OBJECT).indexOf(left_Menu.getText());
				vs_leftMenus.add(iData_ENG.objectList[menuIndex]);
			}

			// POLICY
			if (top_menu.equals("POLICY")) {
				int menuIndex = Arrays.asList(iData_JPN.leftPane_POLICY).indexOf(left_Menu.getText());
				vs_leftMenus.add(iData_ENG.policyList[menuIndex]);
			}
		}
		return vs_leftMenus;
	}

}