from selenium.webdriver.common.by import By
from Public.Pages.base_page import BasePage


class LoginPage(BasePage):
    # 变量设定
    keyword = 'sonicwall'

    # 元素定位
    username_loc = (By.XPATH, "//input[@id='userName']")
    password_loc = (By.XPATH, "//input[@name='pwd']")
    login_loc = (By.XPATH, "//input[@name='Submit']")

    def open(self):
        '''打开登录页面'''
        self._open(self.base_url)

    def user_login(self):
        '''用户登录'''
        self.switch_frame('authFrm')
        self.find_element(*self.username_loc, keyword=self.keyword)
        self.find_element(*self.password_loc, keyword=self.keyword)
        self.find_element(*self.login_loc)
