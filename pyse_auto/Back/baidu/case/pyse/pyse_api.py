# -*- coding: utf-8 -*-
import time
import unittest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

from selenium import webdriver


class Api(unittest.TestCase):
    '''Open your browser'''
    def __init__(self):
        super().__init__()
        self.driver = webdriver.Chrome()
        self.base_url = "https://www.baidu.com"
        self.driver.get(self.base_url)
        self.driver.maximize_window()

    def image_save(self, fail=''):
        '''Save screenshot'''
        now = time.strftime("%Y-%m-%d_%H_%M_%S", time.localtime(time.time()))
        self.image = "./image/{0}{1}.png".format(now, fail)
        self.driver.get_screenshot_as_file(self.image)

    def switch_to(self, now_handle, all_handles):
        '''Switch to the new window'''
        for handle in all_handles:
            if handle != now_handle:
                self.driver.switch_to.window(handle)

    def title_is(self, text):
        '''Wait for the page tile to be equal to the expected title'''
        WebDriverWait(self.driver, 60).until(EC.title_is(text))

    def title_contains(self, text):
        '''Wait for the page tile to contain a string'''
        return WebDriverWait(self.driver, 60).until(EC.title_contains(text))

    def presence_of_element_located(self, path):
        '''Wait until an element for the matching locator is present'''
        return WebDriverWait(self.driver, 60).until(EC.presence_of_element_located((By.XPATH, path)))

    def text_to_be_present_in_element(self, path, text):
        '''Wait until an element is located and has the given text'''
        return WebDriverWait(self.driver, 60).until(EC.text_to_be_present_in_element((By.XPATH, path), text))

    def element_to_be_clickable(self, path):
        '''Wait for an element to be located and be visible and enabled so that it can be clicked'''
        return WebDriverWait(self.driver, 60).until(EC.element_to_be_clickable((By.XPATH, path)))