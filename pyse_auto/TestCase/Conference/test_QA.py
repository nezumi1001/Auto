# -*- coding: utf-8 -*-
import time
from Public.data_log import Logger
from Pages.Conference.QA_page import QAPage


class TestMain():
    logger = Logger('TESTLOG').getlog()

    def test_QA(self, login_page):
        try:
            self.logger.info('Running {}'.format(__file__.split('\\')[-1]))
            self.conference = QAPage(login_page['driver'])
            self.logger.info('Ready to login...')
            self.conference.user_login(login_page['user'])
            self.logger.info('Ready to menu: space > Shanghai QA2...')
            self.conference.menu_space()
            self.logger.info('Send report...')
            self.conference.send_report()
        except Exception as e:
            self.conference.save_image('_Fail')
            self.logger.error('Fail!')
            raise e
        else:
            self.logger.info('Done!')
        finally:
            time.sleep(10)
