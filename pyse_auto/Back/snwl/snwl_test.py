# -*- coding: utf-8 -*-
'''snwl_test'''
from selenium import webdriver
from snwl_page import MainPage
import unittest, time


class BaiduTest(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.driver = webdriver.Chrome()
        cls.base_url = "https://webmail.sonicwall.com"
        cls.driver.get(cls.base_url)

    def test_baidu(self):
        main_page = MainPage(self.driver, self.base_url)
        main_page.browser_open()
        main_page.mail_create()
        self.driver = main_page.browser_quit()

    @classmethod
    def tearDownClass(cls):
        time.sleep(3)
        cls.driver.quit()


if __name__ == "__main__":
    unittest.main()