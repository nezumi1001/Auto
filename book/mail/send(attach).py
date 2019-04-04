'''发送邮件(含附件)'''
import sys, os
file_path = os.getcwd()
sys.path.append(file_path)

import smtplib
from email.header import Header
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart


def new_report(report_path):
    file_list = os.listdir(report_path)
    file_list.sort(key=lambda fn: os.path.getmtime(report_path + '\\' + fn))
    print("The new file name: " + file_list[-1])
    return file_list[-1]

def send_report(new_file):
    msg = MIMEText(open(new_file, 'rb').read(), 'html', 'utf-8')
    msg["Content-Type"] = 'application/octet-stream'
    msg["Content-Disposition"] = 'attachment; filename="report.html"'
    mail_title = 'Python SMTP mail test'
    msg['From'] = '15601925862@163.com'
    # msg['To'] = '15601925862@163.com'
    msg['To'] = ['15601925862@163.com', '3345545791@qq.com']

    msg['Subject'] = Header(mail_title, 'utf-8')
    msgRoot = MIMEMultipart('related')
    msgRoot.attach(msg)

    smtp = smtplib.SMTP('smtp.163.com')
    smtp.login('15601925862@163.com', 'Nezumi753951')
    smtp.sendmail(msg['From'], msg['To'].split(';'), msg.as_string())
    smtp.quit()
    print('邮件发送成功')


if __name__ == "__main__":
    # 发送报告到邮件
    file_path = r'.\Report\TestReport'
    file_new = new_report(file_path)
    report_path = os.path.join(file_path, file_new)
    print(report_path)
    send_report(report_path)