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
    ippei_loc = (By.XPATH, "//div[@id='recent-spaces-section']/ul/li/a")
    local_status_loc = (By.XPATH, "//div[@class='quick-links-wrapper']/div/ul/li/a/span[2]")
    status_2018_loc = (By.XPATH, "//span[@id='childrenspan20448611-0']/a")
    status_week_loc = (By.XPATH, "//ul[@id='child_ul20448611-0']/li/div[2]/span/a")
    menu_loc = (By.XPATH, "//a[@id='action-menu-link']")
    pdf_loc = (By.XPATH, "//a[@id='action-export-pdf-link']")

    def user_login(self):
        '''用户登录'''
        self.find_element(*self.username_loc, keyword=self.username)
        self.find_element(*self.password_loc, keyword=self.password)
        self.find_element(*self.login_loc)
        self.find_element(*self.spaces_loc)
        self.find_elements(*self.ippei_loc, click=True, text='Ippei Okazaki')
        self.find_elements(*self.local_status_loc, click=True, text='Localization Status')
        self.find_element(*self.status_2018_loc)
        self.find_elements(*self.status_week_loc, click=True)
        self.find_element(*self.menu_loc)
        self.find_element(*self.pdf_loc)