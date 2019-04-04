# -*- coding: utf-8 -*-
import sys, os
file_path = os.getcwd()
sys.path.append(file_path)

from Public.Common.data_path import CommonPath
from Public.Common.data_mail2 import SendMail


if __name__ == "__main__":
    # 发送邮件(其他附件)
    # file_path = "{}AttReport".format(CommonPath.log_path)
    # file_new = SendMail.new_report(file_path)
    # report_path = os.path.join(file_path, file_new)
    # SendMail.send_report(report_path)

    # 发送邮件(测试报告)
    file_path = "{}TestReport".format(CommonPath.log_path)
    file_new = SendMail.new_report(file_path)
    report_path = os.path.join(file_path, file_new)
    SendMail.send_report(report_path)