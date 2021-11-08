package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import test.Test_NavData_ENG;

public class Func_ENG {
	private WebDriver driver;
	private WebElement we;
	private List<WebElement> ges;
	private String main_handle;
	private Actions ac;
	private String class_name = Test_NavData_ENG.class.getName();
	private Logger log = LogManager.getLogger(class_name);
	private File my_path = new File(System.getProperty("user.dir"));
	private ExtentReports exReport;
	private ExtentTest exTest;

	public Func_ENG(WebDriver driver) {
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
		exReport = new ExtentReports(my_path + "\\Log\\report\\ExReport_ENG.html");
		exTest = exReport.startTest("Menu Test > [ENG]");
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
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			if (type.equals("xpath")) {
				we = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
			}
		} catch (Exception e) {
			return null;
		}
		return we;
	}

	// Wait element (long time)
	public WebElement wait_element(String type, String path) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
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
		}
		return ges;
	}

	// Expand menu
	public List<String> expand_menu(List<WebElement> expand_Menus, String top_menu) throws InterruptedException {
		List<String> actual_data = new ArrayList<String>();
		log_message(class_name,
				"'" + top_menu + "'" + " has sub closed menu " + "(" + expand_Menus.size() + ")" + ". Please wait...");

		// Show DarkMenu_LeftPane_path menus (not opened)
		for (WebElement expand_Menu_text : expand_Menus) {
			log_message(class_name, expand_Menu_text.getText());
		}

		log_message(class_name, "*************************************************");

		// Add not opened menus to the list
		int leftPaneMenus_minus_temp = 1;
		for (int i = expand_Menus.size() - 1; i >= 0; i--) {
			Boolean isCheck = expand_Menus.get(i).isSelected();
			if (!isCheck) {
				// Click sub closed menu
				List<WebElement> leftPaneMenus_before = find_elements("xpath", iData_ENG.LeftPane_path);
				int leftPaneMenus_before_no = leftPaneMenus_before.size();
				expand_Menus.get(i).click();
				log_message(class_name, ">>>>>>>>>>>>>>>>>>>");
				log_message(class_name, expand_Menus.get(i).getText() + " is clicked!");
				Thread.sleep(1000);

				// Add sub closed menu to the list
				List<WebElement> leftPaneMenus_after = find_elements("xpath", iData_ENG.LeftPane_path);
				int leftPaneMenus_after_no = leftPaneMenus_after.size();
				int leftPaneMenus_minus = leftPaneMenus_after_no - leftPaneMenus_before_no;
				log_message(class_name, "'" + top_menu + "'" + " sub-menu " + expand_Menus.get(i).getText() + " total: "
						+ leftPaneMenus_minus);
				for (int k = leftPaneMenus_after_no - leftPaneMenus_minus
						- leftPaneMenus_minus_temp; k <= leftPaneMenus_after_no - leftPaneMenus_minus_temp; k++) {
					log_message(class_name, "Menu Index: " + k);
					log_message(class_name, "Add sub closed menu: " + leftPaneMenus_after.get(k).getText());

					// Add sub closed menu ENG
					actual_data.add(leftPaneMenus_after.get(k).getText());
				}
				leftPaneMenus_minus_temp += leftPaneMenus_minus + 1;
			}
		}

		// Count the number of all left pane menus
		wait_element("xpath", iData_ENG.LeftPane_path);
		List<WebElement> leftPaneMenus = find_elements("xpath", iData_ENG.LeftPane_path);
		int leftPaneMenus_no = leftPaneMenus.size();

		log_message(class_name, "+++++++++++++++++++++++++++++++++++++++++++++++++");

		// Add top opened menu to the list
		int topPaneMenus_no = leftPaneMenus_no - actual_data.size();
		for (int t = 0; t < topPaneMenus_no; t++) {
			log_message(class_name, "Add top opened menu: " + leftPaneMenus.get(t).getText());
			// Add top opened menu ENG
			actual_data.add(leftPaneMenus.get(t).getText());
		}

		// Show all left pane menu
		log_message(class_name, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		for (int j = 0; j < actual_data.size(); j++) {
			// --- Reset each main menu >> xx (TOP) ---
			// "DEVICE > Settings" >> "DEVICE > Settings (TOP)"
			if (actual_data.get(j).equals("Settings") && actual_data.get(j + 1).equals("Licenses")) {
				actual_data.set(j, "Settings (TOP)");
			}
			log_message(class_name, "MENU: " + actual_data.get(j));
		}

		// Show all left pane menu no
		log_message(class_name, "ALL MENU: " + actual_data.size());

		return actual_data;
	}

	// Create data (info)
	public void create_info() throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("ENG");
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
		FileOutputStream out = new FileOutputStream(my_path + "\\Data\\info\\info_ENG.xls");
		workbook.write(out);
		out.close();
		workbook.close();
	}

	// Update data (info)
	public void update_info(List<String> info_list, int menu_column) throws IOException {
		FileInputStream fs = new FileInputStream(my_path + "\\Data\\info\\info_ENG.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workbook.getSheet("ENG");
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
		FileOutputStream out = new FileOutputStream(my_path + "\\Data\\info\\info_ENG.xls");
		workbook.write(out);
		out.close();
		workbook.close();
	}

	// Create data (menu)
	public void create_data() throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("ENG");
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
		FileOutputStream out = new FileOutputStream(my_path + "\\Data\\compare\\Box_ENG.xls");
		workbook.write(out);
		out.close();
		workbook.close();
	}

	// Update data (menu)
	public void update_data(List<String> MENU_list, int menu_column) throws IOException {
		FileInputStream fs = new FileInputStream(my_path + "\\Data\\compare\\Box_ENG.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workbook.getSheet("ENG");
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
		FileOutputStream out = new FileOutputStream(my_path + "\\Data\\compare\\Box_ENG.xls");
		workbook.write(out);
		out.close();
		workbook.close();
	}

}