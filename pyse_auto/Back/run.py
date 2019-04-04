# -*- coding: utf-8 -*-
import os
import time
import unittest
import HTMLTestRunner

from Public.Common.data_path import CommonPath
from Public.Common.data_mail2 import SendMail


class TestRunner(object):
    '''Run TCs'''
    def __init__(self):
        self.case_dir = CommonPath.case_path
        self.title = 'Test Report'
        self.description = ''
        self.pattern = 'TC*'
        self.report_name = CommonPath.log_path

    def run(self):
        now = time.strftime("%Y-%m-%d_%H_%M_%S", time.localtime(time.time()))
        report_name = "{0}TestReport\\{1}.html".format(self.report_name, now)
        cases = unittest.defaultTestLoader.discover(self.case_dir, pattern=self.pattern)
        with open(report_name, 'wb') as fp:
            runner = HTMLTestRunner.HTMLTestRunner(stream=fp, title=self.title, description=self.description)
            runner.run(cases)

    def debug(self):
        cases = unittest.defaultTestLoader.discover(self.case_dir, pattern=self.pattern)
        runner = unittest.TextTestRunner(verbosity=2) # show results of each case
        print("Debugging...")
        runner.run(cases)
        print("End!!")


if __name__ == '__main__':
    test = TestRunner()
    test.run()

    # ##################################################################################################################
    # 发送邮件(测试报告)
    file_path = "{}TestReport".format(CommonPath.log_path)
    file_new = SendMail.new_report(file_path)
    report_path = os.path.join(file_path, file_new)
    SendMail.send_report(report_path)

    # ##################################################################################################################
    # Schedule to run TCs
    # while True:
    #     now_time = time.strftime('%H_%M')
    #     if now_time == "15_30":
    #         # os.system('C:\\Users\\Jason\\Desktop\\pyse\\test_case\\xx\\test_xx.py')
    #         test = TestRunner(case_dir="./TestCase",
    #                           title="Test Report",
    #                           description="",
    #                           pattern='TC*',
    #                           report_name="./Report/TestReport",
    #                           )
    #         test.run()
    #         break
    #     else:
    #         time.sleep(2)