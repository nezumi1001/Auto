# -*- coding: utf-8 -*-
import time
from Public.data_log import Logger
from Pages.DTS.search_page import SearchPage


class TestMain():
    logger = Logger('TESTLOG').getlog()

    def test_search(self, login_page):
        try:
            self.logger.info('Running {}'.format(__file__.split('\\')[-1]))
            self.DTS = SearchPage(login_page['driver'])
            self.logger.info('Ready to login...')
            self.DTS.user_login(login_page['user'])
            self.logger.info('Ready to query...')
            self.DTS.dts_query()
            self.logger.info('Send report...')
            self.DTS.send_report()
        except Exception as e:
            self.DTS.save_image('_Fail')
            self.logger.error('Fail!')
            raise e
        else:
            self.logger.info('Done!')
        finally:
            time.sleep(10)
