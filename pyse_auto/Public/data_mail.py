'''
发送邮件(邮件正文)
https://email.163.com/#from=ntes_product
15601925862@163.com
Nezumi753951
'''
import sys, os
file_path = os.getcwd()
sys.path.append(file_path)

import smtplib
from email.header import Header
from email.mime.text import MIMEText

from Public.Common.data_path import CommonPath


class SendMail():
    def new_report(report_path):
        file_list = os.listdir(report_path)
        file_list.sort(key=lambda fn: os.path.getmtime(report_path + '\\' + fn))
        print("The new file name: " + file_list[-1])
        return file_list[-1]

    def send_report(new_file='', mail_title='Mail Test', msg_to = '15601925862@163.com'):
        with open(new_file, 'rb') as f:
            mail_body = f.read()

        mail_title = mail_title

        msg = MIMEText(mail_body, 'html', 'utf-8')
        msg['From'] = '15601925862@163.com'
        msg_to = msg_to
        # msg_to = '3345545791@qq.com'
        # msg_to = 'khuang@sonicwall.com'
        # msg_to = ['15601925862@163.com', '3345545791@qq.com']

        msg['Subject'] = Header(mail_title, 'utf-8')

        smtp = smtplib.SMTP('smtp.163.com')
        smtp.login('15601925862@163.com', 'Nezumi753951')
        smtp.sendmail(msg['From'], msg_to, msg.as_string())
        smtp.quit()


if __name__ == "__main__":
    # 发送附件到邮件(正文)
    # file_path = "{}AttReport".format(CommonPath.log_path)
    # file_new = SendMail.new_report(file_path)
    # report_path = os.path.join(file_path, file_new)
    # SendMail.send_report(report_path, mail_title='DTS Summary')

    # 发送报告到邮件(附件)
    file_path = "{}TestReport".format(CommonPath.log_path)
    file_new = SendMail.new_report(file_path)
    report_path = os.path.join(file_path, file_new)
    SendMail.send_report(report_path)