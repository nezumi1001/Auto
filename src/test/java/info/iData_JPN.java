package info;

import java.io.File;

public class iData_JPN {
	// --- Base ---
	public static String baseUrl = "https://10.103.50.78/";
	public static File my_path = new File(System.getProperty("user.dir"));
	public static String[] chromeDriver_data = { "webdriver.chrome.driver",
			my_path.getParent() + "\\Driver\\chromedriver.exe" };
//	public static String chromeDriver_name = "webdriver.chrome.driver";
//	public static String chromeDriver_path = my_path.getParent() + "\\Driver\\chromedriver.exe";

	// ===================================================================================================================================================================================
	// --- Item ---
	// Preempt
	public static String preempt_path = "//button[contains(text(),'非構成')]";
	// ユーザ名 field
	public static String userName_path = "//input[contains(@placeholder,'ユーザ名を入力')]";
	public static String login_name = "admin";
	// パスワード field
	public static String password_path = "//input[contains(@placeholder,'パスワードを入力')]";
	public static String login_pass = "password";
	// ログイン button
	public static String login_path = "//div[contains(text(),'ログイン')]";

	// --- Info ---
	// Box Name > e.g. SONICWALL TZ 370W Japan
	public static String Box_Name_path = "//div[@class='fw-app-header__head__app-name sw-flexbox__flex-none']/span";
	// シリアル番号 > e.g. 2CB8ED69339C
	public static String Serial_Number_path = "//span[contains(text(),'シリアル番号')]/parent::div/following-sibling::div/span";
	// ファームウェア バージョン > e.g. SonicOS 7.0.1-5018
	public static String Firmware_Version_path = "//span[contains(text(),'ファームウェア バージョン')]/parent::div/following-sibling::div/span";

	// ホーム menu (top page)
	public static String HomeMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and contains(text(),'ホーム')]";
	// ホーム/ダッシュボード/システム
	public static String Dashboard_System_path = "//span[@class='sw-breadcrumb__item__text' and contains(text(),'システム')]";

	// 監視 menu (top page)
	public static String MonitorMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and contains(text(),'監視')]";
	// 監視/リアルタイム グラフ/システム監視
	public static String RealTimeCharts_SystemMonitor_path = "//span[@class='sw-breadcrumb__item__text' and contains(text(),'システム監視')]";

	// デバイス menu (top page)
	public static String DeviceMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and contains(text(),'デバイス')]";
	// デバイス/設定/ライセンス
	public static String Settings_Licenses_path = "//span[@class='sw-breadcrumb__item__text' and contains(text(),'ライセンス')]";

	// ネットワーク menu (top page)
	public static String NetworkMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and contains(text(),'ネットワーク')]";
	// ネットワーク/システム/インターフェース
	public static String System_Interfaces_path = "//span[@class='sw-breadcrumb__item__text' and contains(text(),'インターフェース')]";

	// オブジェクト menu (top page)
	public static String ObjectMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and contains(text(),'オブジェクト')]";
	// オブジェクト/一致オブジェクト/ゾーン
	public static String MatchObjects_Zones_path = "//span[@class='sw-breadcrumb__item__text' and contains(text(),'ゾーン')]";

	// ポリシー menu (top page)
	public static String PolicyMenu_Top_path = "//span[@class='sw-top-nav-item__label sw-flexbox__flex-none' and contains(text(),'ポリシー')]";
	// ポリシー/ルールとポリシー/アクセス ルール
	public static String RulesPolicies_AccessRules_path = "//span[@class='sw-breadcrumb__item__text' and contains(text(),'アクセス ルール')]";

	// All left pane
	public static String LeftPane_path = "//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

	// ===================================================================================================================================================================================
	// --- Dark menu ---
	public static String DarkMenu_LeftPane_path = "//li[@class='sw-nav-item sw-flexbox sw-nav-item--dark sw-nav-item--level-0 sw-nav-item--compact']//div[@class='sw-nav-item__content sw-flexbox sw-flexbox--center-items sw-flexbox__flex']/span";

	// ===================================================================================================================================================================================
	// --- Left pane ---
	// HOME
	public static String[] leftPane_HOME = { "ダッシュボード", "システム", "アクセス ポイント", "キャプチャ ATP", "トポロジ", "法的情報", "API" };

	// MONITOR
	public static String[] leftPane_MONITOR = { "リアルタイム グラフ", "システム監視", "プロトコル監視", "ユーザ監視", "帯域幅管理監視", "AppFlow",
			"AppFlow 報告", "AppFlow 監視", "CTA レポート", "SDWAN", "SDWAN 監視", "SD-WAN 接続", "ログ", "システム ログ", "監査ログ", "ツールと監視",
			"パケット監視", "接続", "コア 0 プロセス", "パケット再生" };

	// DEVICE
	public static String[] leftPane_DEVICE = { "設定", "ライセンス", "管理", "時間", "証明書", "SNMP", "ファームウェアと設定", "記憶装置", "再起動",
			"内部無線", "状況", "設定", "セキュリティ", "詳細", "MAC フィルタ リスト", "IDS", "仮想アクセス ポイント", "高可用性", "状況", "設定", "詳細", "監視",
			"ユーザ", "状況", "設定", "パーティション", "ローカル ユーザとグループ", "ゲスト サービス", "ゲスト アカウント", "ゲスト状況", "AppFlow", "フロー報告",
			"AppFlow エージェント", "Network Access Control", "Settings", "Sessions", "ログ", "設定", "Syslog", "自動化", "名前解決",
			"レポート", "AWS", "診断", "テクニカル サポート レポート", "ネットワーク設定の確認", "DNS 名の調査", "ネットワーク パス", "Ping", "ルート追跡",
			"リアルタイム ブラックリスト", "逆引き名前調査", "上位接続", "地域とボットネット", "MX とバナー", "グリッド確認", "URL 格付け要求", "PMTU 検出", "スイッチ診断",
			"スイッチ ネットワーク", "概要", "スイッチ", "アクセス ポイント", "設定", "ファームウェア管理", "フロア プラン表示", "ステーション状況", "IDS", "高度な IDP",
			"パケット キャプチャ", "仮想アクセス ポイント", "RF 監視", "RF 解析", "RF スペクトラム", "FairNet", "Wi-Fi マルチメディア", "3G/4G/LTE WWAN",
			"Bluetooth LE", "無線管理", "WWAN" };

	// NETWORK
	public static String[] leftPane_NETWORK = { "システム", "インターフェース", "フェイルオーバーと負荷分散", "近隣者検出", "ARP", "MAC IP アンチスプーフ",
			"ウェブ プロキシ", "PortShield グループ", "VLAN 変換", "IP ヘルパー", "動的ルーティング", "DHCP サーバ", "マルチキャスト", "ネットワーク監視",
			"AWS 設定", "ファイアウォール", "詳細", "フラッド防御", "SSL 制御", "暗号化制御", "RBL フィルタ", "VoIP", "設定", "通話状況", "DNS", "設定",
			"動的 DNS", "DNS プロキシ", "DNS セキュリティ", "スイッチング", "VLAN トランク", "L2 発見", "リンク統合", "ポート ミラーリング", "SDWAN", "グループ",
			"SLA プローブ", "SLA クラス オブジェクト", "パス選択プロファイル", "ルール", "IPSec VPN", "ルールと設定", "詳細", "VPN を越えた DHCP", "L2TP サーバ",
			"AWS VPN", "SSL VPN", "状況", "サーバ設定", "クライアント設定", "ポータル設定", "仮想オフィス" };

	// OBJECT
	public static String[] leftPane_OBJECT = { "一致オブジェクト", "ゾーン", "アドレス", "サービス", "URI リスト", "一致オブジェクト", "スケジュール",
			"動的グループ", "電子メール アドレス", "プロファイル オブジェクト", "エンドポイント セキュリティ", "帯域幅", "QoS 級割", "コンテンツ フィルタ", "DHCP オプション",
			"AWS", "動作オブジェクト", "アプリケーション ルールの動作", "コンテンツ フィルタの動作" };

	// POLICY
	public static String[] leftPane_POLICY = { "ルールとポリシー", "アクセス ルール", "NAT ルール", "ルーティング ルール", "コンテンツ フィルタ ルール",
			"アプリケーション ルール", "エンドポイント ルール", "DPI-SSL", "クライアント SSL", "サーバ SSL", "DPI-SSH", "設定", "セキュリティ サービス", "サマリ",
			"ゲートウェイ アンチウイルス", "アンチスパイウェア", "侵入防御", "地域 IP フィルタ", "ボットネット フィルタ", "アプリケーション制御", "コンテンツ フィルタ", "アンチスパム",
			"状況", "設定", "キャプチャ ATP", "設定", "スキャン履歴", "エンドポイント セキュリティ" };

}
