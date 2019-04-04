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

    def test_multi(self):
        '''Check the baidu image'''
        try:
            self.logger.info('Ready to click baidu image...')
            now_handle = self.driver.current_window_handle
            self.pyse_obj.presence_of_element_located("//div[@id='lg']/map[@name='mp']/area").click()
            all_handles = self.driver.window_handles
            self.pyse_obj.switch_to(now_handle, all_handles)
            self.logger.info('Switch to the new window...')
            self.pyse_obj.title_is('今日新鲜事_百度搜索')
            self.assertEqual('今日新鲜事_百度搜索', self.driver.title)
        except Exception as e:
            self.pyse_obj.image_save('_Fail')
            self.logger.error('Fail to verify the new page title...')
            raise e
        else:
            self.logger.info('Success to verify the new page title...')
        finally:
            # self.pyse_obj.image_save()
            time.sleep(2)

    def tearDown(self):
        self.driver.quit()


if __name__ == "__main__":
    testunit = unittest.TestSuite()
    testunit.addTest(MainPage('test_multi'))
    now = time.strftime("%Y-%m-%d_%H_%M_%S", time.localtime(time.time()))
    filename = "./report/{0}.html".format(now)
    with open(filename, 'wb') as fp:
        runner = HTMLTestRunner.HTMLTestRunner(stream=fp,
                                               title='Test result',
                                               description='')
        runner.run(testunit)