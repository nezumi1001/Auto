package info;

import java.io.File;

public class iData_ENG {
	// --- Base ---
	public static String baseUrl = "https://10.8.34.196/"; // [NSa 6700]
	public static File my_path = new File(System.getProperty("user.dir"));
//	public static String baseUrl = "https://10.8.75.196/"; //[TZ 570W]
//	public static String baseUrl = "https://10.8.135.150/"; [TZ 570W]
	public static String[] chromeDriver_data = { "webdriver.chrome.driver",
			my_path.getParent() + "\\Driver\\chromedriver.exe" };
//	public static String chromeDriver_name = "webdriver.chrome.driver";
//	public static String chromeDriver_path = my_path.getParent() + "\\Driver\\chromedriver.exe";

	// ===================================================================================================================================================================================
	// --- Item ---
	// Preempt
	public static String preempt_path = "//button[contains(text(),'Non-Config')]";
	// Username field
	public static String userName_path = "//input[contains(@placeholder,'Enter your username')]";
	public static String login_name = "admin";
	// Password field
	public static String password_path = "//input[contains(@placeholder,'Enter your password')]";
	public static String login_pass = "password";
	// LOGIN button
	public static String login_path = "//div[contains(text(),'LOG')]";

	// --- Info ---
	// Box Name > e.g. TZ570W
	public static String Box_Name_path = "//div[@class='fw-app-header__head__app-name sw-flexbox__flex-none']/span";
	// Serial Number > e.g. 2CB8ED4ACD9C
	public static String Serial_Number_path = "//span[contains(text(),'Serial Number')]/parent::div/following-sibling::div/span";
	// Firmware Version > e.g. SonicOS 7.0.1-5018
	public static String Firmware_Version_path = "//span[contains(text(),'Firmware Version')]/parent::div/following-sibling::div/span";

	// HOME menu (top page)
	public static String HomeMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and contains(text(),'Home')]";
	// HOME/Dashboard/System
	public static String Dashboard_System_path = "//span[@class='sw-breadcrumb__item__text' and contains(text(),'System')]";

	// MONITOR menu (top page)
	public static String MonitorMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and contains(text(),'Monitor')]";
	// Monitor/Real-Time Charts/System Monitor
	public static String RealTimeCharts_SystemMonitor_path = "//span[@class='sw-breadcrumb__item__text' and contains(text(),'System Monitor')]";

	// DEVICE menu (top page)
	public static String DeviceMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and contains(text(),'Device')]";
	// Device/Settings/Licenses
	public static String Settings_Licenses_path = "//span[@class='sw-breadcrumb__item__text' and contains(text(),'Licenses')]";

	// NETWORK menu (top page)
	public static String NetworkMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and contains(text(),'Network')]";
	// Network/System/Interfaces
	public static String System_Interfaces_path = "//span[@class='sw-breadcrumb__item__text' and contains(text(),'Interfaces')]";

	// OBJECT menu (top page)
	public static String ObjectMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and contains(text(),'Object')]";
	// Object/Match Objects/Zones
	public static String MatchObjects_Zones_path = "//span[@class='sw-breadcrumb__item__text' and contains(text(),'Zones')]";

	// POLICY menu (top page)
	public static String PolicyMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and contains(text(),'Policy')]";
	// Policy/Rules and Policies/Access Rules
	public static String RulesPolicies_AccessRules_path = "//span[@class='sw-breadcrumb__item__text' and contains(text(),'Access Rules')]";

	// All left pane
	public static String LeftPane_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

	// ===================================================================================================================================================================================
	// --- Dark menu ---
	public static String DarkMenu_LeftPane_path = "//li[@class='sw-nav-item sw-flexbox sw-nav-item--dark sw-nav-item--level-0 sw-nav-item--compact']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

	// ===================================================================================================================================================================================
	// --- Left pane ---
	// HOME
	public static String[] homeList = { "Dashboard", "System", "Access Points", "Capture ATP", "Topology",
			"Legal Information", "API" };

	// MONITOR
	public static String[] monitorList = { "Real-Time Charts", "System Monitor", "Protocol Monitor", "User Monitor",
			"BWM Monitor", "AppFlow", "AppFlow Report", "AppFlow Monitor", "CTA Report", "SDWAN", "SDWAN Monitor",
			"SD-WAN Connections", "Logs", "System Logs", "Auditing Logs", "Tools & Monitors", "Packet Monitor",
			"Connections", "Core 0 Processes", "Packet Replay" };

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
			"Switch Diagnostics", "Switch Network", "Overview", "Switches", "Access Points", "Settings",
			"Firmware Management", "Floor Plan View", "Station Status", "IDS", "Advanced IDP", "Packet Capture",
			"Virtual Access Point", "RF Monitoring", "RF Analysis", "RF Spectrum", "FairNet", "Wi-Fi Multimedia",
			"3G/4G/LTE WWAN", "Bluetooth LE", "Radio Management", "WWAN" };

	// NETWORK
	public static String[] networkList = { "System", "Interfaces", "Failover & LB", "Neighbor Discovery", "ARP",
			"MAC IP Anti-Spoof", "Web Proxy", "PortShield Groups", "VLAN Translation", "IP Helper", "Dynamic Routing",
			"DHCP Server", "Multicast", "Network Monitor", "AWS Configuration", "Firewall", "Advanced",
			"Flood Protection", "SSL Control", "Cipher Control", "RBL Filter", "VoIP", "Settings", "Call Status", "DNS",
			"Settings", "Dynamic DNS", "DNS Proxy", "DNS Security", "Switching", "VLAN Trunking", "L2 Discovery",
			"Link Aggregation", "Port Mirroring", "SDWAN", "Groups", "SLA Probes", "SLA Class Objects",
			"Path Selection Profiles", "Rules", "IPSec VPN", "Rules and Settings", "Advanced", "DHCP over VPN",
			"L2TP Server", "AWS VPN", "SSL VPN", "Status", "Server Settings", "Client Settings", "Portal Settings",
			"Virtual Office" };

	// OBJECT
	public static String[] objectList = { "Match Objects", "Zones", "Addresses", "Services", "URI Lists",
			"Match Objects", "Schedules", "Dynamic Group", "Email Addresses", "Profile Objects", "Endpoint Security",
			"Bandwidth", "QoS Marking", "Content Filter", "DHCP Option", "AWS", "Action Objects", "App Rule Actions",
			"Content Filter Actions" };

	// POLICY
	public static String[] policyList = { "Rules and Policies", "Access Rules", "NAT Rules", "Routing Rules",
			"Content Filter Rules", "App Rules", "Endpoint Rules", "DPI-SSL", "Client SSL", "Server SSL", "DPI-SSH",
			"Settings", "Security Services", "Summary", "Gateway Anti-Virus", "Anti-Spyware", "Intrusion Prevention",
			"Geo-IP Filter", "Botnet Filter", "App Control", "Content Filter", "Anti-Spam", "Status", "Settings",
			"Capture ATP", "Settings", "Scanning History", "Endpoint Security" };

}
