package info;

import java.io.File;

public class iData_ENG {
	// --- Base ---
	public static String baseUrl = "https://10.8.162.235/"; // TZ 570P
//	public static String baseUrl = "https://10.8.163.166/"; // NSa 2700
//	public static String baseUrl = "https://10.8.164.161/"; // NSa 5700
//	public static String baseUrl = "https://10.8.95.102/"; // TZ 370W

	public static File my_path = new File(System.getProperty("user.dir"));
	public static String[] chromeDriver_data = { "webdriver.chrome.driver",
			my_path.getParent() + "\\Driver\\chromedriver.exe" };

	// ===================================================================================================================================================================================
	// --- Item ---
	// Preempt
	public static String preempt_path = "//button[contains(text(),'Non-Config')]";
	// Username field
	public static String userName_path = "//input[contains(@placeholder,'Enter your username')]";
	public static String login_name = "admin";
	// Password field
	public static String password_path = "//input[contains(@placeholder,'Enter your password')]";
	public static String login_pass = "pwdpwdpwd";
	// LOGIN button
	public static String login_path = "//div[contains(text(),'LOG')]";

	// --- Info ---
	// Box Name > e.g. TZ570W
	public static String Box_Name_path = "//div[@class='fw-app-header__head__app-name sw-flexbox__flex-none']/span";
	// Serial Number > e.g. 2CB8ED4ACD9C
	public static String Serial_Number_path = "//span[contains(text(),'Serial Number')]/parent::div/following-sibling::div/span";
	// Firmware Version > e.g. SonicOS 7.0.1-5018
	public static String Firmware_Version_path = "//span[contains(text(),'Firmware Version')]/parent::div/following-sibling::div/span";

	// Config mode
	public static String Config_path = "//div[@class='sw-toggle sw-toggle--left sw-toggle--regular sw-toggle--light']";

	// Top Page
	public static String HomeMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='Home']";
	public static String MonitorMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='Monitor']";
	public static String DeviceMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='Device']";
	public static String NetworkMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='Network']";
	public static String ObjectMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='Object']";
	public static String PolicyMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='Policy']";
	// --- Main menu ---
	// Home > Dashboard > System
	public static String HomeMenu_Dashboard_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='Dashboard']";
	public static String HomeMenu_System_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='System']";
	public static String HomeMenu_System_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='System']";
	// MONITOR > Real-Time Charts > System Monitor
	public static String MonitorMenu_RealTimeCharts_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='Real-Time Charts']";
	public static String MonitorMenu_SystemMonitor_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='System Monitor']";
	public static String MonitorMenu_SystemMonitor_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='System Monitor']";
	// DEVICE > Settings > Licenses
	public static String DeviceMenu_Settings_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='Settings']";
	public static String DeviceMenu_Licenses_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='Licenses']";
	public static String DeviceMenu_Licenses_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='Licenses']";
	// NETWORK > System > Interfaces
	public static String NetworkMenu_System_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='System']";
	public static String NetworkMenu_Interfaces_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='Interfaces']";
	public static String NetworkMenu_Interfaces_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='Interfaces']";
	// OBJECT > Match Objects > Zones
	public static String ObjectMenu_MatchObjects_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='Match Objects']";
	public static String ObjectMenu_Zones_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='Zones']";
	public static String ObjectMenu_Zones_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='Zones']";
	// POLICY > Rules and Policies > Access Rules
	public static String PolicyMenu_RulesPolicies_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='Rules and Policies']";
	public static String PolicyMenu_AccessRules_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='Access Rules']";
	public static String PolicyMenu_AccessRules_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='Access Rules']";

	// Main menu > Sub menu
	public static String MainSub_menu_path = "//span[@class='sw-breadcrumb__item__text']//span[@class='fw-app-header__breadcrumb-device-name']";

	// All left pane
	public static String LeftPane_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

	// ===================================================================================================================================================================================
	// --- Dark menu ---
	public static String DarkMenu_LeftPane_path = "//li[@class='sw-nav-item sw-flexbox sw-nav-item--dark sw-nav-item--level-0 sw-nav-item--compact']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

	// ===================================================================================================================================================================================
	// --- Left pane ---
	// HOME
	public static String[] homeList = { "Dashboard", "System", "Access Points", "Capture ATP", "Policy Overview",
			"Topology", "Legal Information", "API" };

	// MONITOR
	public static String[] monitorList = { "Real-Time Charts", "System Monitor", "Protocol Monitor", "Policy Monitor",
			"User Monitor", "BWM Monitor", "AppFlow", "AppFlow Report", "AppFlow Monitor", "AppFlow Sessions",
			"CTA Report", "SDWAN", "SDWAN Monitor", "SD-WAN Connections", "Logs", "System Logs", "Auditing Logs",
			"Tools & Monitors", "Packet Monitor", "Active Connections", "Connections", "Core 0 Processes",
			"Packet Replay" };

	// DEVICE
	public static String[] deviceList = { "Settings", "Licenses", "Administration", "Time", "Certificates", "SNMP",
			"Firmware and Settings", "Storage", "Restart", "Internal Wireless", "Status", "Settings", "Security",
			"Advanced", "MAC Filter List", "IDS", "Virtual Access Point", "High Availability", "Status", "Settings",
			"Advanced", "Monitoring", "Users", "Status", "Settings", "Partitions", "Local Users & Groups",
			"Guest Services", "Guest Accounts", "Guest Status", "AppFlow", "Flow Reporting", "AppFlow Agent",
			"Network Access Control", "Settings", "Sessions", "Log", "Settings", "Syslog", "Automation",
			"Name Resolution", "Reports", "AWS", "Diagnostics", "Tech Support Report", "Check Network Settings",
			"DNS Name Lookup", "Network Path", "Ping", "Trace Route", "Real-Time Blacklist", "Reverse Name Lookup",
			"Connection TopX", "Geo and Botnet", "MX and Banner", "GRID Check", "URL Rating Request", "PMTU Discovery",
			"Switch Diagnostics", "Policy Lookup", "Switch Network", "Overview", "Switches", "Access Points",
			"Settings", "Firmware Management", "Floor Plan View", "Station Status", "IDS", "Advanced IDP",
			"Packet Capture", "Virtual Access Point", "RF Monitoring", "RF Analysis", "RF Spectrum", "FairNet",
			"Wi-Fi Multimedia", "3G/4G/LTE WWAN", "Bluetooth LE", "Radio Management", "WWAN" };

	// NETWORK
	public static String[] networkList = { "System", "Interfaces", "Failover & LB", "Neighbor Discovery", "ARP",
			"MAC IP Anti-Spoof", "Web Proxy", "PortShield Groups", "PoE Settings", "VLAN Translation", "IP Helper",
			"Dynamic Routing", "DHCP Server", "Multicast", "Network Monitor", "AWS Configuration", "Firewall",
			"Advanced", "Flood Protection", "SSL Control", "Cipher Control", "RBL Filter", "VoIP", "Settings",
			"Call Status", "DNS", "Settings", "Dynamic DNS", "DNS Proxy", "DNS Security", "Switching", "VLAN Trunking",
			"L2 Discovery", "Link Aggregation", "Port Mirroring", "SDWAN", "Groups", "SLA Probes", "SLA Class Objects",
			"Path Selection Profiles", "Rules", "IPSec VPN", "Rules and Settings", "Advanced", "DHCP over VPN",
			"L2TP Server", "AWS VPN", "SSL VPN", "Status", "Server Settings", "Client Settings", "Portal Settings",
			"Virtual Office" };

	// OBJECT
	public static String[] objectList = { "Match Objects", "Zones", "Addresses", "Services", "Countries",
			"Applications", "Web Categories", "Websites", "URI Lists", "Match Patterns", "Custom Match",
			"Match Objects", "Schedules", "Dynamic Group", "Email Addresses", "Profile Objects", "Endpoint Security",
			"Bandwidth", "Block Page", "Log and Alerts", "Intrusion Prevention", "QoS Marking", "Content Filter",
			"DHCP Option", "AWS", "Action Profiles", "Security Action Profile", "DoS Action Profile", "Signatures",
			"Anti-Virus Signatures", "Anti-Spyware Signatures", "Action Objects", "App Rule Actions",
			"Content Filter Actions" };

	// POLICY
	public static String[] policyList = { "Rules and Policies", "Settings", "Security Policy", "NAT Policy",
			"Route Policy", "Decryption Policy", "DoS Policy", "Endpoint Policy", "Shadow", "Access Rules", "NAT Rules",
			"Routing Rules", "Content Filter Rules", "App Rules", "Endpoint Rules", "DPI-SSL", "Client SSL",
			"Server SSL", "DPI-SSH", "Settings", "Security Services", "Summary", "Gateway Anti-Virus", "Anti-Spyware",
			"Intrusion Prevention", "Geo-IP Filter", "Botnet Filter", "App Control", "Content Filter", "Anti-Spam",
			"Status", "Settings", "Capture ATP", "Settings", "Scanning History", "Endpoint Security" };

}
