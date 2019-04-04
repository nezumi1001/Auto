# -*- coding: utf-8 -*-
import time
import unittest
import HTMLTestRunner
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from pyse import pyse_api
from pyse import pyse_logger


class MainPage(unittest.TestCase):
    def setUp(self):
        self.pyse_obj = pyse_api.Api()
        self.driver = self.pyse_obj.driver
        self.logger = pyse_logger.Logger(logger='TESTLOG').getlog()
        self.logger.info('Start {}.py'.format(__name__))

    def test_option(self):
        '''Check the select option'''
        try:
            self.logger.info('Click the settings link...')
            self.pyse_obj.presence_of_element_located("//div[@id='u1']/a[@name='tj_settingicon']").click()
            self.logger.info('Click the search settings link...')
            self.pyse_obj.presence_of_element_located("//div[@class='bdpfmenu']/a[text()='搜索设置']").click()
            self.logger.info('Ready to select the option...')
            self.pyse_obj.presence_of_element_located("//select[@id='nr']")
            self.select = Select(self.driver.find_element_by_id('nr'))
            text = self.pyse_obj.presence_of_element_located("//select[@id='nr']/option[@value='20']").text
            self.select.select_by_value('20')
            self.logger.info('Option value=20 is selected...')
            self.assertEqual('每页显示20条', text)
        except Exception as e:
            self.pyse_obj.image_save('_Fail')
            self.logger.error('Fail to select the option...')
            raise e
        else:
            self.logger.info('Success to select the option...')
        finally:
            # self.pyse_obj.image_save()
            time.sleep(2)

    def tearDown(self):
        self.driver.quit()


if __name__ == "__main__":
    testunit = unittest.TestSuite()
    testunit.addTest(MainPage('test_option'))
    now = time.strftime("%Y-%m-%d_%H_%M_%S", time.localtime(time.time()))
    filename = "./report/{0}.html".format(now)
    with open(filename, 'wb') as fp:
        runner = HTMLTestRunner.HTMLTestRunner(stream=fp,
                                               title='Test result',
                                               description='')
        runner.run(testunit)