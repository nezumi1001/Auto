# -*- coding: utf-8 -*-
'''
logger
self.logger.info('info message')
self.logger.warning('warn message')
self.logger.error('error message')
self.logger.critical('critical message')
'''
import time
import logging


class Logger(object):
    def __init__(self, logger):
        # Create logger
        self.logger = logging.getLogger(logger)
        self.logger.setLevel(logging.DEBUG)

        # Create 1st handler for logging file
        if not self.logger.handlers:
            log_path = '.\\report\\LogReport\\'
            rq = time.strftime('%Y-%m-%d_%H_%M_%S', time.localtime(time.time()))
            # log_name = log_path + rq + '.log'
            log_name = log_path + rq + '.csv'
            # File handler
            fh = logging.FileHandler(log_name)
            fh.setLevel(logging.DEBUG)

            ch = logging.StreamHandler()
            ch.setLevel(logging.DEBUG)

            # File format
            formatter = logging.Formatter('%(asctime)s, %(name)s, %(levelname)s, %(message)s')
            # formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
            fh.setFormatter(formatter)
            ch.setFormatter(formatter)

            # Add a handler
            self.logger.addHandler(fh)
            self.logger.addHandler(ch)

        # Close any handlers
        logging.shutdown()

    def getlog(self):
        return self.logger


logger = Logger(logger='TESTLOG').getlog()