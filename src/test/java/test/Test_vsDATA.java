package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test_vsDATA {
	private File my_path = new File(System.getProperty("user.dir"));
	private Logger log = LogManager.getLogger(Test_NavData_ENG.class.getName());
	private String main_menu;
	private int match = 0;
	private ExtentReports exReport;
	private ExtentTest exTest;

	// Import data only (info JPN)
	public List<String> info_JPN() throws IOException {
		List<String> data_infos_JPN = new ArrayList<String>();
		FileInputStream fs_JPN = new FileInputStream(my_path + "\\Data\\info\\info_JPN.xls");
		HSSFWorkbook workbook_JPN = new HSSFWorkbook(fs_JPN);
		HSSFSheet sheet = workbook_JPN.getSheet("JPN");
		// Get info JPN
		for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
			HSSFCell data_info = sheet.getRow(data_row).getCell(0);
			if (data_info == null) {
				continue;
			}
			String dataInfo = data_info.getStringCellValue();
			data_infos_JPN.add(dataInfo);
		}
		workbook_JPN.close();
		return data_infos_JPN;
	}

	// Import data only (info ENG)
	public List<String> info_ENG() throws IOException {
		List<String> data_infos_ENG = new ArrayList<String>();
		FileInputStream fs_ENG = new FileInputStream(my_path + "\\Data\\info\\info_ENG.xls");
		HSSFWorkbook workbook_ENG = new HSSFWorkbook(fs_ENG);
		HSSFSheet sheet = workbook_ENG.getSheet("ENG");
		// Get info ENG
		for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
			HSSFCell data_info = sheet.getRow(data_row).getCell(0);
			if (data_info == null) {
				continue;
			}
			String dataInfo = data_info.getStringCellValue();
			data_infos_ENG.add(dataInfo);
		}
		workbook_ENG.close();
		return data_infos_ENG;
	}

	// box_JPN
	public String[][] box_JPN() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		List<String> menu_HOME = new ArrayList<String>();
		List<String> menu_MONITOR = new ArrayList<String>();
		List<String> menu_DEVICE = new ArrayList<String>();
		List<String> menu_NETWORK = new ArrayList<String>();
		List<String> menu_OBJECT = new ArrayList<String>();
		List<String> menu_POLICY = new ArrayList<String>();
		// Import data JPN
		FileInputStream fs_JPN = new FileInputStream(my_path + "\\Data\\compare\\Box_JPN.xls");
		HSSFWorkbook workbook_JPN = new HSSFWorkbook(fs_JPN);
		HSSFSheet sheet = workbook_JPN.getSheet("JPN");
		// Get data JPN
		for (int data_column = 0; data_column < 6; data_column++) {
			for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
				HSSFCell data_value = sheet.getRow(data_row).getCell(data_column);
				if (data_value == null) {
					continue;
				}
				String dataValue = data_value.getStringCellValue();

				// Get data from each column
				if (data_column == 0) {
					menu_HOME.add(dataValue);
				} else if (data_column == 1) {
					menu_MONITOR.add(dataValue);
				} else if (data_column == 2) {
					menu_DEVICE.add(dataValue);
				} else if (data_column == 3) {
					menu_NETWORK.add(dataValue);
				} else if (data_column == 4) {
					menu_OBJECT.add(dataValue);
				} else if (data_column == 5) {
					menu_POLICY.add(dataValue);
				}
			}
		}

		// Merge data JPN
		String[] menu_HOMEs = menu_HOME.toArray(new String[menu_HOME.size()]);
		String[] menu_MONITORs = menu_MONITOR.toArray(new String[menu_MONITOR.size()]);
		String[] menu_DEVICEs = menu_DEVICE.toArray(new String[menu_DEVICE.size()]);
		String[] menu_NETWORKs = menu_NETWORK.toArray(new String[menu_NETWORK.size()]);
		String[] menu_OBJECTs = menu_OBJECT.toArray(new String[menu_OBJECT.size()]);
		String[] menu_POLICYs = menu_POLICY.toArray(new String[menu_POLICY.size()]);
		String[][] menu_JPN = { menu_HOMEs, menu_MONITORs, menu_DEVICEs, menu_NETWORKs, menu_OBJECTs, menu_POLICYs };
		// [L]Log
		log_message(testName, "Got data!");
		workbook_JPN.close();
		return menu_JPN;
	}

	// box_ENG
	public String[][] box_ENG() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		List<String> menu_HOME = new ArrayList<String>();
		List<String> menu_MONITOR = new ArrayList<String>();
		List<String> menu_DEVICE = new ArrayList<String>();
		List<String> menu_NETWORK = new ArrayList<String>();
		List<String> menu_OBJECT = new ArrayList<String>();
		List<String> menu_POLICY = new ArrayList<String>();
		// Import data ENG
		FileInputStream fs_ENG = new FileInputStream(my_path + "\\Data\\compare\\Box_ENG.xls");
		HSSFWorkbook workbook_ENG = new HSSFWorkbook(fs_ENG);
		HSSFSheet sheet = workbook_ENG.getSheet("ENG");
		// Get data ENG
		for (int data_column = 0; data_column < 6; data_column++) {
			for (int data_row = 0; data_row <= sheet.getLastRowNum(); data_row++) {
				HSSFCell data_value = sheet.getRow(data_row).getCell(data_column);
				if (data_value == null) {
					continue;
				}
				String dataValue = data_value.getStringCellValue();

				// Get data from each column
				if (data_column == 0) {
					menu_HOME.add(dataValue);
				} else if (data_column == 1) {
					menu_MONITOR.add(dataValue);
				} else if (data_column == 2) {
					menu_DEVICE.add(dataValue);
				} else if (data_column == 3) {
					menu_NETWORK.add(dataValue);
				} else if (data_column == 4) {
					menu_OBJECT.add(dataValue);
				} else if (data_column == 5) {
					menu_POLICY.add(dataValue);
				}
			}
		}

		// Merge data ENG
		String[] menu_HOMEs = menu_HOME.toArray(new String[menu_HOME.size()]);
		String[] menu_MONITORs = menu_MONITOR.toArray(new String[menu_MONITOR.size()]);
		String[] menu_DEVICEs = menu_DEVICE.toArray(new String[menu_DEVICE.size()]);
		String[] menu_NETWORKs = menu_NETWORK.toArray(new String[menu_NETWORK.size()]);
		String[] menu_OBJECTs = menu_OBJECT.toArray(new String[menu_OBJECT.size()]);
		String[] menu_POLICYs = menu_POLICY.toArray(new String[menu_POLICY.size()]);
		String[][] menu_ENG = { menu_HOMEs, menu_MONITORs, menu_DEVICEs, menu_NETWORKs, menu_OBJECTs, menu_POLICYs };
		// [L]Log
		log_message(testName, "Got data!");
		workbook_ENG.close();
		return menu_ENG;
	}

	// Get missing page
	public int missing_page(int column_no, List<String> MenusJPNs, List<String> MenusENGs) {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		// Column name
		String[] column_name = { "HOME", "MONITOR", "DEVICE", "NETWORK", "OBJECT", "POLICY" };
		// New menu JPN
		List<String> HOME_MenusJPNs = new ArrayList<String>();
		List<String> MONITOR_MenusJPNs = new ArrayList<String>();
		List<String> DEVICE_MenusJPNs = new ArrayList<String>();
		List<String> NETWORK_MenusJPNs = new ArrayList<String>();
		List<String> OBJECT_MenusJPNs = new ArrayList<String>();
		List<String> POLICY_MenusJPNs = new ArrayList<String>();

		// HOME JPN
		String[] HOME_Menus_JPN = { "Dashboard", "Legal Information", "API" };
		// MONITOR JPN
		String[] MONITOR_Menus_JPN = { "Real-Time Charts", "AppFlow", "SDWAN", "Logs", "Tools & Monitors" };
		// DEVICE JPN
		String[] DEVICE_Menus_JPN = { "Settings (TOP)", "Internal Wireless", "High Availability", "Users", "AppFlow",
				"Network Access Control", "Log", "Diagnostics", "Switch Network", "Access Points", "WWAN" };
		// NETWORK JPN
		String[] NETWORK_Menus_JPN = { "System", "Firewall", "VoIP", "DNS", "Switching", "SDWAN", "IPSec VPN",
				"SSL VPN" };
		// OBJECT JPN
		String[] OBJECT_Menus_JPN = { "Match Objects", "Profile Objects", "Action Objects", "Signatures" };
		// POLICY JPN
		String[] POLICY_Menus_JPN = { "Rules and Policies", "DPI-SSL", "DPI-SSH", "Security Services", "Anti-Spam",
				"Capture ATP", "Endpoint Security" };
		// ------------------------------------------------------------------------------------------------------------------------------
		// New menu ENG
		List<String> HOME_MenusENGs = new ArrayList<String>();
		List<String> MONITOR_MenusENGs = new ArrayList<String>();
		List<String> DEVICE_MenusENGs = new ArrayList<String>();
		List<String> NETWORK_MenusENGs = new ArrayList<String>();
		List<String> OBJECT_MenusENGs = new ArrayList<String>();
		List<String> POLICY_MenusENGs = new ArrayList<String>();
		// HOME ENG
		String[] HOME_Menus_ENG = { "Dashboard", "Legal Information", "API" };
		// MONITOR ENG
		String[] MONITOR_Menus_ENG = { "Real-Time Charts", "AppFlow", "SDWAN", "Logs", "Tools & Monitors" };
		// DEVICE ENG
		String[] DEVICE_Menus_ENG = { "Settings (TOP)", "Internal Wireless", "High Availability", "Users", "AppFlow",
				"Network Access Control", "Log", "Diagnostics", "Switch Network", "Access Points", "WWAN" };
		// NETWORK ENG
		String[] NETWORK_Menus_ENG = { "System", "Firewall", "VoIP", "DNS", "Switching", "SDWAN", "IPSec VPN",
				"SSL VPN" };
		// OBJECT ENG
		String[] OBJECT_Menus_ENG = { "Match Objects", "Profile Objects", "Action Objects", "Signatures" };
		// POLICY ENG
		String[] POLICY_Menus_ENG = { "Rules and Policies", "DPI-SSL", "DPI-SSH", "Security Services", "Anti-Spam",
				"Capture ATP", "Endpoint Security" };

		// --- Make new menu ---
		main_menu = column_name[column_no];
		// Mark ">" JPN
		for (int i = 0; i < MenusJPNs.size(); i++) {
			// HOME JPN
			if (main_menu.equals("HOME")) {
				String MenusJPN_temp = MenusJPNs.get(i);
				int iTemp = i;
				while (!MenusJPN_temp.equals("Dashboard") && !MenusJPN_temp.equals("Legal Information")
						&& !MenusJPN_temp.equals("API")) {
					iTemp = iTemp - 1;
					MenusJPN_temp = MenusJPNs.get(iTemp);
				}
				for (int k = 0; k < HOME_Menus_JPN.length; k++) {
					if (MenusJPN_temp.equals(HOME_Menus_JPN[k])) {
						if (iTemp == i) {
							HOME_MenusJPNs.add(HOME_Menus_JPN[k]);
						} else {
							HOME_MenusJPNs.add(HOME_Menus_JPN[k] + " > " + MenusJPNs.get(i));
						}
					}
				}
			}

			// MONITOR JPN
			if (main_menu.equals("MONITOR")) {
				String MenusJPN_temp = MenusJPNs.get(i);
				int iTemp = i;
				while (!MenusJPN_temp.equals("Real-Time Charts") && !MenusJPN_temp.equals("AppFlow")
						&& !MenusJPN_temp.equals("SDWAN") && !MenusJPN_temp.equals("Logs")
						&& !MenusJPN_temp.equals("Tools & Monitors")) {
					iTemp = iTemp - 1;
					MenusJPN_temp = MenusJPNs.get(iTemp);
				}
				for (int k = 0; k < MONITOR_Menus_JPN.length; k++) {
					if (MenusJPN_temp.equals(MONITOR_Menus_JPN[k])) {
						if (iTemp == i) {
							MONITOR_MenusJPNs.add(MONITOR_Menus_JPN[k]);
						} else {
							MONITOR_MenusJPNs.add(MONITOR_Menus_JPN[k] + " > " + MenusJPNs.get(i));
						}
					}
				}
			}

			// DEVICE JPN
			if (main_menu.equals("DEVICE")) {
				String MenusJPN_temp = MenusJPNs.get(i);
				int iTemp = i;
				while (!MenusJPN_temp.equals("Settings (TOP)") && !MenusJPN_temp.equals("Internal Wireless")
						&& !MenusJPN_temp.equals("High Availability") && !MenusJPN_temp.equals("Users")
						&& !MenusJPN_temp.equals("AppFlow") && !MenusJPN_temp.equals("Network Access Control")
						&& !MenusJPN_temp.equals("Log") && !MenusJPN_temp.equals("Diagnostics")
						&& !MenusJPN_temp.equals("Switch Network") && !MenusJPN_temp.equals("Access Points")
						&& !MenusJPN_temp.equals("WWAN")) {
					iTemp = iTemp - 1;
					MenusJPN_temp = MenusJPNs.get(iTemp);
				}
				for (int k = 0; k < DEVICE_Menus_JPN.length; k++) {
					if (MenusJPN_temp.equals(DEVICE_Menus_JPN[k])) {
						if (iTemp == i) {
							DEVICE_MenusJPNs.add(DEVICE_Menus_JPN[k]);
						} else {
							DEVICE_MenusJPNs.add(DEVICE_Menus_JPN[k] + " > " + MenusJPNs.get(i));
						}
					}
				}
			}

			// NETWORK JPN
			if (main_menu.equals("NETWORK")) {
				String MenusJPN_temp = MenusJPNs.get(i);
				int iTemp = i;
				while (!MenusJPN_temp.equals("System") && !MenusJPN_temp.equals("Firewall")
						&& !MenusJPN_temp.equals("VoIP") && !MenusJPN_temp.equals("DNS")
						&& !MenusJPN_temp.equals("Switching") && !MenusJPN_temp.equals("SDWAN")
						&& !MenusJPN_temp.equals("IPSec VPN") && !MenusJPN_temp.equals("SSL VPN")) {
					iTemp = iTemp - 1;
					MenusJPN_temp = MenusJPNs.get(iTemp);
				}
				for (int k = 0; k < NETWORK_Menus_JPN.length; k++) {
					if (MenusJPN_temp.equals(NETWORK_Menus_JPN[k])) {
						if (iTemp == i) {
							NETWORK_MenusJPNs.add(NETWORK_Menus_JPN[k]);
						} else {
							NETWORK_MenusJPNs.add(NETWORK_Menus_JPN[k] + " > " + MenusJPNs.get(i));
						}
					}
				}
			}

			// OBJECT JPN
			if (main_menu.equals("OBJECT")) {
				String MenusJPN_temp = MenusJPNs.get(i);
				int iTemp = i;
				while (!MenusJPN_temp.equals("Match Objects") && !MenusJPN_temp.equals("Profile Objects")
						&& !MenusJPN_temp.equals("Action Objects") && !MenusJPN_temp.equals("Signatures")) {
					iTemp = iTemp - 1;
					MenusJPN_temp = MenusJPNs.get(iTemp);
				}
				for (int k = 0; k < OBJECT_Menus_JPN.length; k++) {
					if (MenusJPN_temp.equals(OBJECT_Menus_JPN[k])) {
						if (iTemp == i) {
							OBJECT_MenusJPNs.add(OBJECT_Menus_JPN[k]);
						} else {
							OBJECT_MenusJPNs.add(OBJECT_Menus_JPN[k] + " > " + MenusJPNs.get(i));
						}
					}
				}
			}

			// POLICY JPN
			if (main_menu.equals("POLICY")) {
				String MenusJPN_temp = MenusJPNs.get(i);
				int iTemp = i;
				while (!MenusJPN_temp.equals("Rules and Policies") && !MenusJPN_temp.equals("DPI-SSL")
						&& !MenusJPN_temp.equals("DPI-SSH") && !MenusJPN_temp.equals("Security Services")
						&& !MenusJPN_temp.equals("Anti-Spam") && !MenusJPN_temp.equals("Capture ATP")
						&& !MenusJPN_temp.equals("Endpoint Security")) {
					iTemp = iTemp - 1;
					MenusJPN_temp = MenusJPNs.get(iTemp);
				}
				for (int k = 0; k < POLICY_Menus_JPN.length; k++) {
					if (MenusJPN_temp.equals(POLICY_Menus_JPN[k])) {
						if (iTemp == i) {
							POLICY_MenusJPNs.add(POLICY_Menus_JPN[k]);
						} else {
							POLICY_MenusJPNs.add(POLICY_Menus_JPN[k] + " > " + MenusJPNs.get(i));
						}
					}
				}
			}

		}

		// Mark ">" ENG
		for (int i = 0; i < MenusENGs.size(); i++) {
			// HOME ENG
			if (main_menu.equals("HOME")) {
				String MenusENG_temp = MenusENGs.get(i);
				int iTemp = i;
				while (!MenusENG_temp.equals("Dashboard") && !MenusENG_temp.equals("Legal Information")
						&& !MenusENG_temp.equals("API")) {
					iTemp = iTemp - 1;
					MenusENG_temp = MenusENGs.get(iTemp);
				}
				for (int k = 0; k < HOME_Menus_ENG.length; k++) {
					if (MenusENG_temp.equals(HOME_Menus_ENG[k])) {
						if (iTemp == i) {
							HOME_MenusENGs.add(HOME_Menus_ENG[k]);
						} else {
							HOME_MenusENGs.add(HOME_Menus_ENG[k] + " > " + MenusENGs.get(i));
						}
					}
				}
			}

			// MONITOR ENG
			if (main_menu.equals("MONITOR")) {
				String MenusENG_temp = MenusENGs.get(i);
				int iTemp = i;
				while (!MenusENG_temp.equals("Real-Time Charts") && !MenusENG_temp.equals("AppFlow")
						&& !MenusENG_temp.equals("SDWAN") && !MenusENG_temp.equals("Logs")
						&& !MenusENG_temp.equals("Tools & Monitors")) {
					iTemp = iTemp - 1;
					MenusENG_temp = MenusENGs.get(iTemp);
				}
				for (int k = 0; k < MONITOR_Menus_ENG.length; k++) {
					if (MenusENG_temp.equals(MONITOR_Menus_ENG[k])) {
						if (iTemp == i) {
							MONITOR_MenusENGs.add(MONITOR_Menus_ENG[k]);
						} else {
							MONITOR_MenusENGs.add(MONITOR_Menus_ENG[k] + " > " + MenusENGs.get(i));
						}
					}
				}
			}

			// DEVICE ENG
			if (main_menu.equals("DEVICE")) {
				String MenusENG_temp = MenusENGs.get(i);
				int iTemp = i;
				while (!MenusENG_temp.equals("Settings (TOP)") && !MenusENG_temp.equals("Internal Wireless")
						&& !MenusENG_temp.equals("High Availability") && !MenusENG_temp.equals("Users")
						&& !MenusENG_temp.equals("AppFlow") && !MenusENG_temp.equals("Network Access Control")
						&& !MenusENG_temp.equals("Log") && !MenusENG_temp.equals("Diagnostics")
						&& !MenusENG_temp.equals("Switch Network") && !MenusENG_temp.equals("Access Points")
						&& !MenusENG_temp.equals("WWAN")) {
					iTemp = iTemp - 1;
					MenusENG_temp = MenusENGs.get(iTemp);
				}
				for (int k = 0; k < DEVICE_Menus_ENG.length; k++) {
					if (MenusENG_temp.equals(DEVICE_Menus_ENG[k])) {
						if (iTemp == i) {
							DEVICE_MenusENGs.add(DEVICE_Menus_ENG[k]);
						} else {
							DEVICE_MenusENGs.add(DEVICE_Menus_ENG[k] + " > " + MenusENGs.get(i));
						}
					}
				}
			}

			// NETWORK ENG
			if (main_menu.equals("NETWORK")) {
				String MenusENG_temp = MenusENGs.get(i);
				int iTemp = i;
				while (!MenusENG_temp.equals("System") && !MenusENG_temp.equals("Firewall")
						&& !MenusENG_temp.equals("VoIP") && !MenusENG_temp.equals("DNS")
						&& !MenusENG_temp.equals("Switching") && !MenusENG_temp.equals("SDWAN")
						&& !MenusENG_temp.equals("IPSec VPN") && !MenusENG_temp.equals("SSL VPN")) {
					iTemp = iTemp - 1;
					MenusENG_temp = MenusENGs.get(iTemp);
				}
				for (int k = 0; k < NETWORK_Menus_ENG.length; k++) {
					if (MenusENG_temp.equals(NETWORK_Menus_ENG[k])) {
						if (iTemp == i) {
							NETWORK_MenusENGs.add(NETWORK_Menus_ENG[k]);
						} else {
							NETWORK_MenusENGs.add(NETWORK_Menus_ENG[k] + " > " + MenusENGs.get(i));
						}
					}
				}
			}

			// OBJECT ENG
			if (main_menu.equals("OBJECT")) {
				String MenusENG_temp = MenusENGs.get(i);
				int iTemp = i;
				while (!MenusENG_temp.equals("Match Objects") && !MenusENG_temp.equals("Profile Objects")
						&& !MenusENG_temp.equals("Action Objects") && !MenusENG_temp.equals("Signatures")) {
					iTemp = iTemp - 1;
					MenusENG_temp = MenusENGs.get(iTemp);
				}
				for (int k = 0; k < OBJECT_Menus_ENG.length; k++) {
					if (MenusENG_temp.equals(OBJECT_Menus_ENG[k])) {
						if (iTemp == i) {
							OBJECT_MenusENGs.add(OBJECT_Menus_ENG[k]);
						} else {
							OBJECT_MenusENGs.add(OBJECT_Menus_ENG[k] + " > " + MenusENGs.get(i));
						}
					}
				}
			}

			// POLICY ENG
			if (main_menu.equals("POLICY")) {
				String MenusENG_temp = MenusENGs.get(i);
				int iTemp = i;
				while (!MenusENG_temp.equals("Rules and Policies") && !MenusENG_temp.equals("DPI-SSL")
						&& !MenusENG_temp.equals("DPI-SSH") && !MenusENG_temp.equals("Security Services")
						&& !MenusENG_temp.equals("Anti-Spam") && !MenusENG_temp.equals("Capture ATP")
						&& !MenusENG_temp.equals("Endpoint Security")) {
					iTemp = iTemp - 1;
					MenusENG_temp = MenusENGs.get(iTemp);
				}
				for (int k = 0; k < POLICY_Menus_ENG.length; k++) {
					if (MenusENG_temp.equals(POLICY_Menus_ENG[k])) {
						if (iTemp == i) {
							POLICY_MenusENGs.add(POLICY_Menus_ENG[k]);
						} else {
							POLICY_MenusENGs.add(POLICY_Menus_ENG[k] + " > " + MenusENGs.get(i));
						}
					}
				}
			}

		}

		// --- Final VS ---
		// Merge data JPN & ENG
		String[] HOME_JPNs = HOME_MenusJPNs.toArray(new String[HOME_MenusJPNs.size()]);
		String[] MONITOR_JPNs = MONITOR_MenusJPNs.toArray(new String[MONITOR_MenusJPNs.size()]);
		String[] DEVICE_JPNs = DEVICE_MenusJPNs.toArray(new String[DEVICE_MenusJPNs.size()]);
		String[] NETWORK_JPNs = NETWORK_MenusJPNs.toArray(new String[NETWORK_MenusJPNs.size()]);
		String[] OBJECT_JPNs = OBJECT_MenusJPNs.toArray(new String[OBJECT_MenusJPNs.size()]);
		String[] POLICY_JPNs = POLICY_MenusJPNs.toArray(new String[POLICY_MenusJPNs.size()]);
		String[][] Menu_JPNs = { HOME_JPNs, MONITOR_JPNs, DEVICE_JPNs, NETWORK_JPNs, OBJECT_JPNs, POLICY_JPNs };

		// Merge data ENG
		String[] HOME_ENGs = HOME_MenusENGs.toArray(new String[HOME_MenusENGs.size()]);
		String[] MONITOR_ENGs = MONITOR_MenusENGs.toArray(new String[MONITOR_MenusENGs.size()]);
		String[] DEVICE_ENGs = DEVICE_MenusENGs.toArray(new String[DEVICE_MenusENGs.size()]);
		String[] NETWORK_ENGs = NETWORK_MenusENGs.toArray(new String[NETWORK_MenusENGs.size()]);
		String[] OBJECT_ENGs = OBJECT_MenusENGs.toArray(new String[OBJECT_MenusENGs.size()]);
		String[] POLICY_ENGs = POLICY_MenusENGs.toArray(new String[POLICY_MenusENGs.size()]);
		String[][] Menu_ENGs = { HOME_ENGs, MONITOR_ENGs, DEVICE_ENGs, NETWORK_ENGs, OBJECT_ENGs, POLICY_ENGs };

		// JPN version missing
		for (int i = 0; i < 6; i++) {
			List<String> MenuJPNs = Arrays.asList(Menu_JPNs[i]);
			List<String> MenuENGs = Arrays.asList(Menu_ENGs[i]);
			for (String MenuENG : MenuENGs) {
				if (!MenuJPNs.contains(MenuENG)) {
					if (MenuENG.contains(" (TOP)")) {
						MenuENG = MenuENG.replace(" (TOP)", "");
					}
					// [L]Log
					log_message(testName, "[JPN] version missing: " + main_menu + " > " + MenuENG);
					match++;
				}
			}
		}

		// ENG version missing
		for (int i = 0; i < 6; i++) {
			List<String> MenuJPNs = Arrays.asList(Menu_JPNs[i]);
			List<String> MenuENGs = Arrays.asList(Menu_ENGs[i]);
			for (String MenuJPN : MenuJPNs) {
				if (!MenuENGs.contains(MenuJPN)) {
					if (MenuJPN.contains(" (TOP)")) {
						MenuJPN = MenuJPN.replace(" (TOP)", "");
					}
					// [L]Log
					log_message(testName, "[ENG] version missing: " + main_menu + " > " + MenuJPN);
					match++;
				}
			}
		}

		return match;
	}

	// Start > Extent report
	public void start_exReport() {
		exReport = new ExtentReports(my_path + "\\Log\\report\\ExReport_VS.html");
		exTest = exReport.startTest("Menu Test > [JPN] vs [ENG]");
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

	@Test
	public void test_dataCompare() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		start_exReport();

		// Get data JPN & ENG
		String[][] Menus_JPNs = box_JPN();
		String[][] Menus_ENGs = box_ENG();

		// [L]Log
		log_message(testName, "Ready to start...");

		// [L]Log
		log_message(testName, "--------------------------------------------------------------------");

		// [L]Log (info JPN)
		List<String> InfoJPNs = info_JPN();
		log_message(testName, "[JPN] info: " + "Device Name -----> " + InfoJPNs.get(0));
		log_message(testName, "[JPN] info: " + "Serial Number ---> " + InfoJPNs.get(1));
		log_message(testName, "[JPN] info: " + "Firmware Version > " + InfoJPNs.get(2));

		// [L]Log
		log_message(testName, "--------------------------------------------------------------------");

		// [L]Log (info JPN)
		List<String> InfoENGs = info_ENG();
		log_message(testName, "[ENG] info: " + "Device Name -----> " + InfoENGs.get(0));
		log_message(testName, "[ENG] info: " + "Serial Number ---> " + InfoENGs.get(1));
		log_message(testName, "[ENG] info: " + "Firmware Version > " + InfoENGs.get(2));

		// [L]Log
		log_message(testName, "--------------------------------------------------------------------");

		// Compare data JPN & ENG
		for (int i = 0; i < 6; i++) {
			List<String> MenusJPNs = Arrays.asList(Menus_JPNs[i]);
			List<String> MenusENGs = Arrays.asList(Menus_ENGs[i]);
			match = missing_page(i, MenusJPNs, MenusENGs);
		}
		// Completely Match!
		if (match == 0) {
			log_message(testName, "********** All matched! **********");
//			System.out.println("********** All matched! **********");
		}

		close_exReport();
	}

}
