# -*- coding: utf-8 -*-
import sys, os
file_path = os.getcwd()
sys.path.append(file_path)

import time
import unittest
import HTMLTestRunner
from selenium import webdriver

from Public.Common.data_log import Logger
from Public.Common.data_ini import ReadINI
from Public.Common.data_path import CommonPath
from Public.Common.data_mail2 import SendMail
from Public.Pages.Conference.lab_page import LabPage


class MainPage(unittest.TestCase):
    def setUp(self):
        # Jenkins need full path
        self.driver = webdriver.Chrome(r'C:\Program Files (x86)\Google\Chrome\Application\chromedriver')
        config_value = ReadINI(CommonPath.common_path + 'config.ini')
        self.base_url = config_value.read_ini('url_Conference', 'URL')
        self.Conference = LabPage(self.driver, self.base_url)
        self.Conference.open()

    def test_lab(self):
        try:
            self.logger = Logger('TESTLOG').getlog()
            self.logger.info('Start running {}'.format(__file__.split('\\')[-1]))
            self.Conference.user_login()
            self.logger.info('{0} Done! {1}'.format('*'*20, '*'*20))
        except Exception as e:
            self.Conference.image_save('_Fail')
            self.logger.error('Fail!!')
            raise e
        else:
            self.logger.info('Success!!')
        finally:
            time.sleep(10)

    def tearDown(self):
        self.driver.quit()


if __name__ == "__main__":
    cases = unittest.TestSuite()
    cases.addTest(MainPage('test_lab'))
    now = time.strftime("%Y-%m-%d_%H_%M_%S", time.localtime(time.time()))
    report_name = "{0}TestReport\\{1}.html".format(CommonPath.log_path, now)
    with open(report_name, 'wb') as fp:
        runner = HTMLTestRunner.HTMLTestRunner(stream=fp,
                                               title='Test result',
                                               description=__file__.split('\\')[-1])
        runner.run(cases)

    # 发送邮件(其他附件)
    file_path = "{}Downloads".format(CommonPath.downloads_path)
    file_new = SendMail.new_report(file_path)
    report_path = os.path.join(file_path, file_new)
    SendMail.send_report(report_path, att_type='pdf', mail_title='Localization Lab')

    # 发送邮件(测试报告)
    # file_path = "{}TestReport".format(CommonPath.log_path)
    # file_new = SendMail.new_report(file_path)
    # report_path = os.path.join(file_path, file_new)
    # SendMail.send_report(report_path)