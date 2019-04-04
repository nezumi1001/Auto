# -*- coding: utf-8 -*-
import time
from Public.data_log import Logger
from Pages.Baidu.search_page import SearchPage


class TestMain():
    logger = Logger('TESTLOG').getlog()

    def test_search(self, login_page):
        try:
            self.logger.info('Running {}'.format(__file__.split('\\')[-1]))
            self.baidu = SearchPage(login_page['driver'])
            self.logger.info('Ready to search...')
            self.baidu.search_info(login_page['keyword'])
            self.logger.info('Ready to check result...')
            text = self.baidu.search_check()
            assert '找到相关结果约' in text, '\n>>>Failed: The search result is not found!'
            self.logger.info('Assert search result...')
        except Exception as e:
            self.baidu.save_image('_Fail')
            self.logger.error('Fail!!')
            raise e
        else:
            self.logger.info('Done!')
        finally:
            time.sleep(10)
