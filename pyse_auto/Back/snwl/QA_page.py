import time
from prettytable import PrettyTable
from selenium.webdriver.common.by import By

from Public.Pages.base_page import BasePage
from Public.Common.data_csv import ReadCSV


class StatusPage(BasePage):
    '''变量设定'''
    data = ReadCSV().read_csv('.\\Data\\sonicwall.csv')
    username = data[0]; password = data[1]

    username_loc = (By.XPATH, "//input[@id='os_username']")
    password_loc = (By.XPATH, "//input[@id='os_password']")
    login_loc = (By.XPATH, "//input[@id='loginButton']")
    spaces_loc = (By.XPATH, "//a[@id='space-menu-link']")
    QA2_loc = (By.XPATH, "//div[@id='recent-spaces-section']/ul/li/a")
    name_loc = (By.XPATH, "//div[@class='values']/h4/a")
    mail_loc = (By.XPATH, "//div[@class='values']/a")

    def user_login(self):
        '''用户登录'''
        self.find_element(*self.username_loc, keyword=self.username)
        self.find_element(*self.password_loc, keyword=self.password)
        self.find_element(*self.login_loc)
        self.find_element(*self.spaces_loc)
        self.find_elements(*self.QA2_loc, click=True, text='Shanghai QA2')
        self.name_list = self.find_elements(*self.name_loc, add=True)
        self.mail_list = self.find_elements(*self.mail_loc, add=True)
        return self.name_list, self.mail_list

    def save_table(self):
        '''保存到 pretty table'''
        pt = ['No', 'Name', 'E-mail']
        table = PrettyTable(pt)
        table.align["No"] = "l" # 以 No 字段左对齐
        table.align["Name"] = "l" # 以 Name 字段左对齐
        table.align["E-mail"] = "l" # 以 E-mail 字段左对齐

        # 添加表格
        self.item_count = len(self.name_list)
        for m in range(self.item_count):
            table.add_row([m + 1, self.name_list[m], self.mail_list[m]])

        # 保存文件
        now = time.strftime("%Y-%m-%d_%H_%M_%S", time.localtime(time.time()))
        file_path = '.\\Report\\AttReport\\{}.html'.format(now)
        tb = table.get_html_string(format=True, hrules=True, attributes={"bgcolor": "#FFFFFF"}) # "#FAEBDD"
        with open(file_path, 'w', encoding='utf-8') as file_obj:
            file_obj.write('{} Members Displayed.\n'.format(self.item_count))
            file_obj.write(str(tb))