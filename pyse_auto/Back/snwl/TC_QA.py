# -*- coding: utf-8 -*-
import sys, os
file_path = os.getcwd()
sys.path.append(file_path)

import time
import unittest
import HTMLTestRunner
from selenium import webdriver
from selenium.webdriver.chrome.options import Options

import smtplib
from email.header import Header
from email.mime.text import MIMEText

from Public.Common.data_log import Logger
from Public.Common.data_ini import ReadINI
from Public.Common.data_path import CommonPath
# from Public.Common.data_mail import SendMail
# from Public.Common.data_mail2 import SendMail
from Public.Pages.Conference.QA_page import StatusPage


class MainPage(unittest.TestCase):
    def setUp(self):
        chrome_options = Options()
        chrome_options.add_argument('--headless')
        chrome_options.add_argument('--disable-gpu')
        self.driver = webdriver.Chrome(chrome_options=chrome_options)
        # Jenkins need full path
        # self.driver = webdriver.Chrome(r'C:\Program Files (x86)\Google\Chrome\Application\chromedriver')
        config_value = ReadINI(CommonPath.common_path + 'config.ini')
        self.base_url = config_value.read_ini('url_Conference', 'URL')
        self.Conference = StatusPage(self.driver, self.base_url)
        self.Conference.open()

    def send_report(self, new_data='', new_data2='', mail_title='Mail Test', msg_to = '15601925862@163.com'):
        self.summary = '<h3 align="center">{} Records Displayed</h3>'.format(len(new_data)) + '<hr/>'

        self.table_heading = """
                                    <table class="pure-table">
                                        <thead>
                                            <tr>
                                                <th>No</th>
                                                <th>Name</th>
                                                <th>E-mail</th>
                                            </tr>
                                        </thead>
                                    <tbody>
                             """

        n = 0
        self.table_list = ''
        while n < len(new_data):
            self.table_list += ('<tr><td>' + str(n+1) + '</td>' +
                                '<td>' + new_data[n] + '</td>' +
                                '<td>' + new_data2[n] + '</td></tr>')
            n += 1

        self.css_style = """
                        <head>
                             <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
                             <style>
                                    .pure-table {
                                        /* Remove spacing between table cells (from Normalize.css) */
                                        border-collapse: collapse;
                                        border-spacing: 0;
                                        empty-cells: show;
                                        border: 2px solid #cbcbcb;
                                    }

                                    .pure-table caption {
                                        color: #000;
                                        font: italic 85%/1 arial, sans-serif;
                                    }

                                    .pure-table td,
                                    .pure-table th {
                                        border-left: 1px solid #cbcbcb;/*  inner column border */
                                        border-right: 1px solid #cbcbcb;/*  inner column border */
                                        border-width: 0 0 0 1px;
                                        font-size: inherit;
                                        margin: 0;
                                        overflow: visible; /*to make ths where the title is really long work*/
                                        padding: 0.5em 1em; /* cell padding */
                                    }

                                    /* Consider removing this next declaration block, as it causes problems when
                                    there's a rowspan on the first cell. Case added to the tests. issue#432 */
                                    .pure-table td:first-child,
                                    .pure-table th:first-child {
                                        border-left-width: 0;
                                    }

                                    .pure-table thead {
                                     /*   background-color: #e0e0e0;
                                        color: #000;*/
                                        background-color: #d65c00;
                                        color: #FFF;
                                        text-align: left;
                                        vertical-align: bottom;
                                    }

                                    /*
                                    striping:
                                       even - #fff (white)
                                       odd  - #f2f2f2 (light gray)
                                    */
                                    .pure-table td {
                                    /*    background-color: transparent;*/
                                          background-color: #ffefe2
                                    }
                                    .pure-table-odd td {
                                        background-color: #f2f2f2;
                                    }

                                    /* nth-child selector for modern browsers
                                    .pure-table-striped tr:nth-child(2n-1) td {
                                        background-color: #f2f2f2;
                                    }*/

                                    .pure-table tr {
                                        border-bottom: 1px solid #cbcbcb;
                                    }
                                    .pure-table td {
                                        border-bottom: 1px solid #cbcbcb;
                                    }
                                    </style>
                                    </head>
                            """

        mail_title = mail_title
        self.msg = MIMEText(self.css_style + self.summary + self.table_heading + self.table_list, 'html', 'utf-8')
        self.msg['From'] = '15601925862@163.com'
        msg_to = msg_to
        # msg_to = '3345545791@qq.com'
        # msg_to = 'khuang@sonicwall.com'
        # msg_to = ['15601925862@163.com', '3345545791@qq.com']

        self.msg['Subject'] = Header(mail_title, 'utf-8')

        smtp = smtplib.SMTP('smtp.163.com')
        smtp.login('15601925862@163.com', 'Nezumi753951')
        smtp.sendmail(self.msg['From'], msg_to, self.msg.as_string())
        smtp.quit()
        print('邮件发送成功')

    def test_QA(self):
        try:
            self.logger = Logger('TESTLOG').getlog()
            self.logger.info('Start running {}'.format(__file__.split('\\')[-1]))
            self.name_list, self.mail_list = self.Conference.user_login()
            self.send_report(new_data=self.name_list, new_data2=self.mail_list, mail_title='QA Members')
            # self.Conference.save_table()
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
    cases.addTest(MainPage('test_QA'))
    now = time.strftime("%Y-%m-%d_%H_%M_%S", time.localtime(time.time()))
    report_name = "{0}TestReport\\{1}.html".format(CommonPath.log_path, now)
    with open(report_name, 'wb') as fp:
        runner = HTMLTestRunner.HTMLTestRunner(stream=fp,
                                               title='Test result',
                                               description=__file__.split('\\')[-1])
        runner.run(cases)

    # 发送邮件(其他附件)
    # file_path = "{}AttReport".format(CommonPath.log_path)
    # file_new = SendMail.new_report(file_path)
    # report_path = os.path.join(file_path, file_new)
    # SendMail.send_report(report_path, mail_title='QA Members')

    # 发送邮件(测试报告)
    # file_path = "{}TestReport".format(CommonPath.log_path)
    # file_new = SendMail.new_report(file_path)
    # report_path = os.path.join(file_path, file_new)
    # SendMail.send_report(report_path)