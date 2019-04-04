# -*- coding: utf-8 -*-
import time
from selenium.webdriver.support.ui import Select
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class BasePage():
    def __init__(self, driver_info):
        self.driver = driver_info['driver']
        self.url = driver_info['url']

    def save_image(self, fail=''):
        now = time.strftime("%Y-%m-%d_%H_%M_%S", time.localtime(time.time()))
        self.image = ".\\Screenshot\\{0}{1}.png".format(now, fail)
        self.driver.get_screenshot_as_file(self.image)

    def switch_frame(self, ID_name):
        self.driver.switch_to.frame(ID_name)

    def switch_window(self, ready):
        if ready == 1:
            self.now_handle = self.driver.current_window_handle
        elif ready == 2:
            all_handles = self.driver.window_handles
            for handle in all_handles:
                if handle != self.now_handle:
                    self.driver.switch_to.window(handle)

    def alert_window(self, option=1):
        alert = self.driver.switch_to.alert
        if option == 1:
            alert.accept()
        elif option == 2:
            alert.dismiss()

    def find_element(self, *loc, option=3, click=True, keyword='', text='', index='', value=''):
        '''
        1. WebDriverWait(driver,60,2).until(EC.title_is("DELL SonicWALL"))
        2. WebDriverWait(driver,60).until(EC.title_contains("你就知道"))
        3. WebDriverWait(driver, 60,).until(EC.visibility_of_element_located((By.XPATH, "//input[@id='kw']")))
        4. WebDriverWait(driver, 60).until(EC.presence_of_element_located((By.XPATH, "//input[@id='kw']")))
        5. WebDriverWait(driver, 60).until(EC.text_to_be_present_in_element((By.XPATH, "//tr[@id='sugConf']/th"), "搜索框"))
        '''
        option_dict = {
            1: lambda : WebDriverWait(self.driver, 60).until(EC.title_is(text)),
            2: lambda : WebDriverWait(self.driver, 60).until(EC.title_contains(text)),
            3: lambda : WebDriverWait(self.driver, 60).until(EC.visibility_of_element_located((loc))),
            4: lambda : WebDriverWait(self.driver, 60).until(EC.presence_of_element_located((loc))),
            5: lambda : WebDriverWait(self.driver, 60).until(EC.text_to_be_present_in_element((loc), text))
        }

        option_dict[option]()

        if click == True:
            self.driver.find_element(*loc).click()
        if keyword != '':
            self.driver.find_element(*loc).clear()
            self.driver.find_element(*loc).send_keys(keyword)
        if text != '':
            text = self.driver.find_element(*loc).text
            return text
        if index != '' or value != '':
            select = Select(self.driver.find_element(*loc))
            if index != '': select.select_by_index(index)
            if value != '': select.select_by_value(value)

    def find_elements(self, *loc, option=4, click=False, count=False, add=False, text=''):
        '''
        4. WebDriverWait(driver, 60).until(EC.presence_of_element_located((By.XPATH, "//input[@id='kw']")))
        '''
        option_dict = {
            4: lambda : WebDriverWait(self.driver, 60).until(EC.presence_of_all_elements_located((loc))),
        }

        option_dict[option]()

        if count == True:
            item_count = len(self.driver.find_elements(*loc))
            return item_count
        if add == True:
            item_list = []
            item_group = self.driver.find_elements(*loc)
            for i in item_group:
                item_list.append(i.text)
            return item_list
        if click == True:
            item_group = self.driver.find_elements(*loc)
            if text != '':
                for i in item_group:
                    if i.text == text: i.click(); break
            else:
                item_group[-1].click()
