# -*- coding: utf-8 -*-
import os

from Public.data_mail2 import SendMail


def test_report(common_path):
    file_path = "{}TestReport".format(common_path['log_path'])
    file_new = SendMail.new_report(file_path)
    report_path = os.path.join(file_path, file_new)
    SendMail.send_report(report_path, mail_title='Test Report')

