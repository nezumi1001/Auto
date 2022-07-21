package info;

import java.io.File;

public class iData_JPN {
	// --- Base ---
	public static String baseUrl = "https://10.103.50.207/"; // TZ 270W
//	public static String baseUrl = "https://10.8.162.169/"; // TZ 570P

	public static File my_path = new File(System.getProperty("user.dir"));
	public static String[] chromeDriver_data = { "webdriver.chrome.driver",
			my_path.getParent() + "\\Driver\\chromedriver.exe" };

	// ===================================================================================================================================================================================
	// --- Item ---
	// Preempt
	public static String preempt_path = "//button[contains(text(),'非構成')]";
	// ユーザ名 field
	public static String userName_path = "//input[contains(@placeholder,'ユーザ名を入力')]";
	public static String login_name = "admin";
	// パスワード field
	public static String password_path = "//input[contains(@placeholder,'パスワードを入力')]";
	public static String login_pass = "sonicwall";
	// ログイン button
	public static String login_path = "//div[contains(text(),'ログイン')]";

	// --- Info ---
	// Box Name > e.g. SONICWALL TZ 370W Japan
	public static String Box_Name_path = "//div[@class='fw-app-header__head__app-name sw-flexbox__flex-none']/span";
	// シリアル番号 > e.g. 2CB8ED69339C
	public static String Serial_Number_path = "//span[contains(text(),'シリアル番号')]/parent::div/following-sibling::div/span";
	// ファームウェア バージョン > e.g. SonicOS 7.0.1-5018
	public static String Firmware_Version_path = "//span[contains(text(),'ファームウェア バージョン')]/parent::div/following-sibling::div/span";

	// Config mode
	public static String Config_path = "//div[@class='sw-toggle sw-toggle--left sw-toggle--regular sw-toggle--light']";

	// Top Page
	public static String HomeMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='ホーム']";
	public static String MonitorMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='監視']";
	public static String DeviceMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='デバイス']";
	public static String NetworkMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='ネットワーク']";
	public static String ObjectMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='オブジェクト']";
	public static String PolicyMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and text()='ポリシー']";
	// --- Main menu ---
	// Home > Dashboard > System
	public static String HomeMenu_Dashboard_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='ダッシュボード']";
	public static String HomeMenu_System_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='システム']";
	public static String HomeMenu_System_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='システム']";
	// MONITOR > Real-Time Charts > System Monitor
	public static String MonitorMenu_RealTimeCharts_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='リアルタイム グラフ']";
	public static String MonitorMenu_SystemMonitor_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='システム監視']";
	public static String MonitorMenu_SystemMonitor_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='システム監視']";
	// DEVICE > Settings > Licenses
	public static String DeviceMenu_Settings_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='設定']";
	public static String DeviceMenu_Licenses_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='ライセンス']";
	public static String DeviceMenu_Licenses_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='ライセンス']";
	// NETWORK > System > Interfaces
	public static String NetworkMenu_System_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='システム']";
	public static String NetworkMenu_Interfaces_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='インターフェース']";
	public static String NetworkMenu_Interfaces_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='インターフェース']";
	// OBJECT > Match Objects > Zones
	public static String ObjectMenu_MatchObjects_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='一致オブジェクト']";
	public static String ObjectMenu_Zones_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='ゾーン']";
	public static String ObjectMenu_Zones_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='ゾーン']";
	// POLICY > Rules and Policies > Access Rules
	public static String PolicyMenu_RulesPolicies_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='ルールとポリシー']";
	public static String PolicyMenu_AccessRules_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span[text()='アクセス ルール']";
	public static String PolicyMenu_AccessRules_title_path = "//div[@class='sw-breadcrumb__item sw-flexbox__flex-none sw-flexbox sw-flexbox--center-items']/span[text()='アクセス ルール']";

	// Main menu > Sub menu
	public static String MainSub_menu_path = "//span[@class='sw-breadcrumb__item__text']//span[@class='fw-app-header__breadcrumb-device-name']";

	// All left pane
	public static String LeftPane_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

	// --- Dark menu ---
	public static String DarkMenu_LeftPane_path = "//li[@class='sw-nav-item sw-flexbox sw-nav-item--dark sw-nav-item--level-0 sw-nav-item--compact']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

	// ===================================================================================================================================================================================
	// --- Left pane ---
	// HOME
	public static String[] leftPane_HOME = { "ダッシュボード", "システム", "アクセス ポイント", "キャプチャ ATP", "Policy Overview", "トポロジ",
			"法的情報", "API" };

	// MONITOR
	public static String[] leftPane_MONITOR = { "リアルタイム グラフ", "システム監視", "プロトコル監視", "Policy Monitor", "ユーザ監視", "帯域幅管理監視",
			"AppFlow", "AppFlow 報告", "AppFlow 監視", "AppFlow Sessions", "CTA レポート", "SDWAN", "SDWAN 監視", "SD-WAN 接続",
			"ログ", "システム ログ", "監査ログ", "ツールと監視", "パケット監視", "Active Connections", "接続", "コア 0 プロセス", "パケット再生" };

	// DEVICE
	public static String[] leftPane_DEVICE = { "設定", "ライセンス", "管理", "時間", "証明書", "SNMP", "ファームウェアと設定", "記憶装置", "再起動",
			"内部無線", "状況", "設定", "セキュリティ", "詳細", "MAC フィルタ リスト", "IDS", "仮想アクセス ポイント", "高可用性", "状況", "設定", "詳細", "監視",
			"ユーザ", "状況", "設定", "パーティション", "ローカル ユーザとグループ", "ゲスト サービス", "ゲスト アカウント", "ゲスト状況", "AppFlow", "フロー報告",
			"AppFlow エージェント", "Network Access Control", "Settings", "Sessions", "ログ", "設定", "Syslog", "自動化", "名前解決",
			"レポート", "AWS", "診断", "テクニカル サポート レポート", "ネットワーク設定の確認", "DNS 名の調査", "ネットワーク パス", "Ping", "ルート追跡",
			"リアルタイム ブラックリスト", "逆引き名前調査", "上位接続", "地域とボットネット", "MX とバナー", "グリッド確認", "URL 格付け要求", "PMTU 検出", "スイッチ診断",
			"Policy Lookup", "スイッチ ネットワーク", "概要", "スイッチ", "アクセス ポイント", "設定", "ファームウェア管理", "フロア プランの表示", "ステーション状況",
			"IDS", "高度な IDP", "パケット キャプチャ", "仮想アクセス ポイント", "RF 監視", "RF 解析", "RF スペクトラム", "FairNet", "Wi-Fi マルチメディア",
			"3G/4G/LTE WWAN", "Bluetooth LE", "無線管理", "WWAN" };

	// NETWORK
	public static String[] leftPane_NETWORK = { "システム", "インターフェース", "フェイルオーバーと負荷分散", "近隣者検出", "ARP", "MAC IP アンチスプーフ",
			"ウェブ プロキシ", "PortShield グループ", "PoE 設定", "VLAN 変換", "IP ヘルパー", "動的ルーティング", "DHCP サーバ", "マルチキャスト",
			"ネットワーク監視", "AWS 設定", "ファイアウォール", "詳細", "フラッド防御", "SSL 制御", "暗号化制御", "RBL フィルタ", "VoIP", "設定", "通話状況",
			"DNS", "設定", "動的 DNS", "DNS プロキシ", "DNS セキュリティ", "スイッチング", "VLAN トランク", "L2 発見", "リンク統合", "ポート ミラーリング",
			"SDWAN", "グループ", "SLA プローブ", "SLA クラス オブジェクト", "パス選択プロファイル", "ルール", "IPSec VPN", "ルールと設定", "詳細",
			"VPN を越えた DHCP", "L2TP サーバ", "AWS VPN", "SSL VPN", "状況", "サーバ設定", "クライアント設定", "ポータル設定", "仮想オフィス" };

	// OBJECT
	public static String[] leftPane_OBJECT = { "一致オブジェクト", "ゾーン", "アドレス", "サービス", "Countries", "Applications",
			"Web Categories", "Websites", "URI リスト", "Match Patterns", "Custom Match", "一致オブジェクト", "スケジュール", "動的グループ",
			"電子メール アドレス", "プロファイル オブジェクト", "エンドポイント セキュリティ", "帯域幅", "Block Page", "Log and Alerts",
			"Intrusion Prevention", "QoS 級割", "コンテンツ フィルタ", "DHCP オプション", "AWS", "Action Profiles",
			"Security Action Profile", "DoS Action Profile", "Signatures", "Anti-Virus Signatures",
			"Anti-Spyware Signatures", "動作オブジェクト", "アプリケーション ルールの動作", "コンテンツ フィルタの動作" };

	// POLICY
	public static String[] leftPane_POLICY = { "ルールとポリシー", "Settings", "Security Policy", "NAT Policy", "Route Policy",
			"Decryption Policy", "DoS Policy", "Endpoint Policy", "Shadow", "アクセス ルール", "NAT ルール", "ルーティング ルール",
			"コンテンツ フィルタ ルール", "アプリケーション ルール", "エンドポイント ルール", "DPI-SSL", "クライアント SSL", "サーバ SSL", "DPI-SSH", "設定",
			"セキュリティ サービス", "サマリ", "ゲートウェイ アンチウイルス", "アンチスパイウェア", "侵入防御", "地域 IP フィルタ", "ボットネット フィルタ", "アプリケーション制御",
			"コンテンツ フィルタ", "アンチスパム", "状況", "設定", "キャプチャ ATP", "設定", "スキャン履歴", "エンドポイント セキュリティ" };

}
