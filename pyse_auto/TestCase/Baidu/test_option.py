# -*- coding: utf-8 -*-
import time
from Public.data_log import Logger
from Pages.Baidu.option_page import OptionPage


class TestMain():
    logger = Logger('TESTLOG').getlog()

    def test_option(self, login_page):
        try:
            self.logger.info('Running {}'.format(__file__.split('\\')[-1]))
            self.baidu = OptionPage(login_page['driver'])
            self.logger.info('Ready to select option...')
            self.baidu.option_info()
            self.logger.info('Ready to click [OK] on alert window...')
            time.sleep(2)
            self.baidu.alert_info()
        except Exception as e:
            self.baidu.save_image('_Fail')
            self.logger.error('Fail!')
            raise e
        else:
            self.logger.info('Done!')
        finally:
            time.sleep(10)
