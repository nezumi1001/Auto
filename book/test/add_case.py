# -*- coding: utf-8 -*-
import time
import sys, os
file_path = os.getcwd()
sys.path.append(file_path)

import unittest
import HTMLTestRunner
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.webdriver.common.by import By


class MainPage(unittest.TestCase):
    def setUp(self):
        pass

    def test_option(self):
        '''Check xxx'''
        try:
            pass
        except Exception as e:
            pass
        else:
            pass
        finally:
            pass

    @unittest.skip('do not run this case')
    def test_search(self):
        pass

    @unittest.skipIf(2>1, '')
    def test_view(self):
        pass

    def tearDown(self):
        pass


if __name__ == "__main__":
    # Add single case
    all_case = unittest.TestSuite()
    all_case.addTest(MainPage('test_option'))
    runner = unittest.TextTestRunner(verbosity=2)  # show results of each case
    runner.run(all_case)

    # Add mutiple cases
    all_case = unittest.TestSuite()
    cases = [MainPage('test_option'), MainPage('test_search')]
    all_case.addTests(cases)
    runner = unittest.TextTestRunner(verbosity=2) # show results of each case
    runner.run(all_case)

    # Add external cases
    all_case = unittest.defaultTestLoader.discover("./TestCase", pattern='TC*')
    runner = unittest.TextTestRunner(verbosity=2) # show results of each case
    runner.run(all_case)
