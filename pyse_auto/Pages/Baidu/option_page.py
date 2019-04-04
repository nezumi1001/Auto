from selenium.webdriver.common.by import By
from Pages.base_page import BasePage


class OptionPage(BasePage):
    '''settings'''
    setting_loc = (By.XPATH, "//div[@id='u1']/a[@name='tj_settingicon']")
    search_loc = (By.XPATH, "//div[@class='bdpfmenu']/a[text()='搜索设置']")
    option_loc = (By.ID, "nr")
    save_loc = (By.XPATH, "//div[@id='gxszButton']/a[1]")

    def option_info(self):
        '''select option'''
        self.find_element(*self.setting_loc)
        self.find_element(*self.search_loc)
        self.find_element(*self.option_loc, click=False, value='20')
        self.find_element(*self.save_loc)

    def alert_info(self):
        '''alert window'''
        self.alert_window()
