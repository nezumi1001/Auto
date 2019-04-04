from selenium.webdriver.common.by import By
from Pages.base_page import BasePage


class LabPage(BasePage):
    '''settings'''
    username_loc = (By.XPATH, "//input[@id='os_username']")
    password_loc = (By.XPATH, "//input[@id='os_password']")
    login_loc = (By.XPATH, "//input[@id='loginButton']")
    spaces_loc = (By.XPATH, "//a[@id='space-menu-link']")
    locali_loc = (By.XPATH, "//div[@id='recent-spaces-section']/ul/li/a")
    lab_loc = (By.XPATH, "//span[@id='childrenspan23478961-0']/a")
    menu_loc = (By.XPATH, "//a[@id='action-menu-link']")
    pdf_loc = (By.XPATH, "//a[@id='action-export-pdf-link']")

    def user_login(self, user_info):
        '''login'''
        self.find_element(*self.username_loc, keyword=user_info['username'])
        self.find_element(*self.password_loc, keyword=user_info['password'])
        self.find_element(*self.login_loc)

    def menu_space(self):
        '''menu: space > Localization'''
        self.find_element(*self.spaces_loc)
        self.find_elements(*self.locali_loc, click=True, text='Localization')

    def link_localization_lab(self):
        '''link: Localization Lab'''
        self.find_element(*self.lab_loc)

    def menu_export_PDF(self):
        '''menu: export PDF'''
        self.find_element(*self.menu_loc)
        self.find_element(*self.pdf_loc)
