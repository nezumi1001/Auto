# -*- coding: utf-8 -*-
import sys, os
file_path = os.getcwd()
sys.path.append(file_path)

import time
import unittest
import HTMLTestRunner
from selenium import webdriver
from selenium.webdriver.chrome.options import Options


from Public.Common.data_log import Logger
from Public.Common.data_ini import ReadINI
from Public.Common.data_path import CommonPath
from Public.Common.data_mail2 import SendMail
from Public.Pages.Baidu.option_page import OptionPage


class MainPage(unittest.TestCase):
    def setUp(self):
        # self.driver = webdriver.Chrome()
        # Jenkins need full path
        chrome_options = Options()
        chrome_options.add_argument('--headless')
        chrome_options.add_argument('--disable-gpu')
        self.driver = webdriver.Chrome(chrome_options=chrome_options)

        # self.driver = webdriver.Chrome(r'C:\Program Files (x86)\Google\Chrome\Application\chromedriver')
        config_value = ReadINI(CommonPath.common_path + 'config.ini')
        self.base_url = config_value.read_ini('url_baidu', 'URL')
        self.baidu = OptionPage(self.driver, self.base_url)
        self.baidu.open()

    def test_option(self):
        try:
            self.logger = Logger('TESTLOG').getlog()
            self.logger.info('Start running {}'.format(__file__.split('\\')[-1]))
            self.baidu.option_info()
            self.logger.info('Click save setting...')
            time.sleep(2)
            self.baidu.alert_info()
            self.logger.info('Click OK on alert window...')
        except Exception as e:
            self.baidu.image_save('_Fail')
            self.logger.error('Fail!!')
            raise e
        else:
            self.logger.info('Success!!')
        finally:
            time.sleep(2)

    def tearDown(self):
        self.driver.quit()


if __name__ == "__main__":
    cases = unittest.TestSuite()
    cases.addTest(MainPage('test_option'))
    now = time.strftime("%Y-%m-%d_%H_%M_%S", time.localtime(time.time()))
    report_name = "{0}TestReport\\{1}.html".format(CommonPath.log_path, now)
    with open(report_name, 'wb') as fp:
        runner = HTMLTestRunner.HTMLTestRunner(stream=fp,
                                               title='Test result',
                                               description=__file__.split('\\')[-1])
        runner.run(cases)

    # 发送邮件(报告)
    # file_path = "{}TestReport".format(CommonPath.log_path)
    # file_new = SendMail.new_report(file_path)
    # report_path = os.path.join(file_path, file_new)
    # SendMail.send_report(report_path)