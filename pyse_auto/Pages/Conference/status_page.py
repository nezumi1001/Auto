from selenium.webdriver.common.by import By
from Pages.base_page import BasePage


class StatusPage(BasePage):
    '''settings'''
    username_loc = (By.XPATH, "//input[@id='os_username']")
    password_loc = (By.XPATH, "//input[@id='os_password']")
    login_loc = (By.XPATH, "//input[@id='loginButton']")
    spaces_loc = (By.XPATH, "//a[@id='space-menu-link']")
    ippei_loc = (By.XPATH, "//div[@id='recent-spaces-section']/ul/li/a")
    local_status_loc = (By.XPATH, "//div[@class='quick-links-wrapper']/div/ul/li/a/span[2]")
    # status_2018_loc = (By.XPATH, "//span[@id='childrenspan20448611-0']/a")
    status_2019_loc = (By.XPATH, "//span[@id='childrenspan36739925-0']/a")
    # status_week_2018_loc = (By.XPATH, "//ul[@id='child_ul20448611-0']/li/div[2]/span/a")
    status_week_2019_loc = (By.XPATH, "//ul[@id='child_ul36739925-0']/li/div[2]/span/a")
    menu_loc = (By.XPATH, "//a[@id='action-menu-link']")
    pdf_loc = (By.XPATH, "//a[@id='action-export-pdf-link']")

    def user_login(self, user_info):
        '''login'''
        self.find_element(*self.username_loc, keyword=user_info['username'])
        self.find_element(*self.password_loc, keyword=user_info['password'])
        self.find_element(*self.login_loc)

    def menu_space(self):
        '''menu: space > Ippei Okazaki'''
        self.find_element(*self.spaces_loc)
        self.find_elements(*self.ippei_loc, click=True, text='Ippei Okazaki')

    def link_localization_status(self):
        '''link: Localization Status'''
        self.find_elements(*self.local_status_loc, click=True, text='Localization Status')
        # link: 2019
        self.find_element(*self.status_2019_loc)
        self.find_elements(*self.status_week_2019_loc, click=True)

    def menu_export_PDF(self):
        '''menu: export PDF'''
        self.find_element(*self.menu_loc)
        self.find_element(*self.pdf_loc)
