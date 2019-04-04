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

    def test_login(self):
        '''Check the page title'''
        try:
            self.logger.info('Check the page title...')
            self.pyse_obj.title_contains('百度一下')
            self.assertEqual('百度一下，你就知道', self.driver.title)
        except Exception as e:
            self.pyse_obj.image_save('_Fail')
            self.logger.error('Fail to get the page title...')
            raise e
        else:
            self.logger.info('Success to get the page title...')
        finally:
            # self.pyse_obj.image_save()
            time.sleep(2)

    def tearDown(self):
        self.driver.quit()


if __name__ == "__main__":
    testunit = unittest.TestSuite()
    testunit.addTest(MainPage('test_login'))
    now = time.strftime("%Y-%m-%d_%H_%M_%S", time.localtime(time.time()))
    filename = "./report/{0}.html".format(now)
    with open(filename, 'wb') as fp:
        runner = HTMLTestRunner.HTMLTestRunner(stream=fp,
                                               title='Test result',
                                               description='')
        runner.run(testunit)