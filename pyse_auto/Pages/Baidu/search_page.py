from selenium.webdriver.common.by import By
from Pages.base_page import BasePage


class SearchPage(BasePage):
    '''settings'''
    search_loc = (By.XPATH, "//input[@id='kw']")
    button_loc = (By.XPATH, "//input[@id='su']")
    result_loc = (By.XPATH, "//div[@class='nums']")

    def search_info(self, keyword_info):
        '''search keyword'''
        self.find_element(*self.search_loc, keyword = keyword_info)
        self.find_element(*self.button_loc)

    def search_check(self):
        '''check result'''
        text = self.find_element(*self.result_loc, option=5, click=False, text='为您找到')
        return text
