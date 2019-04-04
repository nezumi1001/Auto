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

    def test_click(self):
        '''Check the search button'''
        try:
            self.logger.info('Check the search button...')
            result = self.pyse_obj.element_to_be_clickable("//input[@id='su']")
            self.logger.info('Result: {}'.format(result))
        except Exception as e:
            self.pyse_obj.image_save('_Fail')
            self.logger.error('The search button is disabled...')
            raise e
        else:
            self.logger.info('The search button is enabled...')
        finally:
            # self.pyse_obj.image_save()
            time.sleep(2)

    def tearDown(self):
        self.driver.quit()


if __name__ == "__main__":
    testunit = unittest.TestSuite()
    testunit.addTest(MainPage('test_click'))
    now = time.strftime("%Y-%m-%d_%H_%M_%S", time.localtime(time.time()))
    filename = "./report/{0}.html".format(now)
    with open(filename, 'wb') as fp:
        runner = HTMLTestRunner.HTMLTestRunner(stream=fp,
                                               title='Test result',
                                               description='')
        runner.run(testunit)