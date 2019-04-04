# -*- coding: utf-8 -*-
import time
from Public.data_log import Logger
from Pages.Conference.lab_page import LabPage


class TestMain():
    logger = Logger('TESTLOG').getlog()

    def test_lab(self, login_page):
        try:
            self.logger.info('Running {}'.format(__file__.split('\\')[-1]))
            self.conference = LabPage(login_page['driver'])
            self.logger.info('Ready to login...')
            self.conference.user_login(login_page['user'])
            self.logger.info('Ready to menu: space > Localization...')
            self.conference.menu_space()
            self.logger.info('Ready to link: Localization Lab...')
            self.conference.link_localization_lab()
            self.logger.info('Ready to menu: export PDF...')
            self.conference.menu_export_PDF()
        except Exception as e:
            self.conference.save_image('_Fail')
            self.logger.error('Fail!')
            raise e
        else:
            self.logger.info('Done!')
        finally:
            time.sleep(10)
