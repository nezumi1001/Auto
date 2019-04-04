# -*- coding: utf-8 -*-
import time
import unittest
import HTMLTestRunner


class TestRunner(object):
    ''' Run test '''
    def __init__(self, case_dir="./case", title="Test Report", description="Test case execution"):
        self.case_dir = case_dir
        self.title = title
        self.description = description

    def run(self):
        now = time.strftime("%Y-%m-%d_%H_%M_%S", time.localtime(time.time()))
        report_name = "./report/{}.html".format(now)
        all_case = unittest.defaultTestLoader.discover(self.case_dir, pattern='test*.py', top_level_dir=None)
        with open(report_name, 'wb') as fp:
            runner = HTMLTestRunner.HTMLTestRunner(stream=fp, title=self.title, description=self.description)
            runner.run(all_case)

    def debug(self):
        all_case = unittest.defaultTestLoader.discover(self.case_dir, pattern='test*.py', top_level_dir=None)
        runner = unittest.TextTestRunner(verbosity=2)
        print("Debugging...")
        runner.run(all_case)
        print("End!!")

if __name__ == '__main__':
    test = TestRunner()
    test.run()