'''发送邮件(不含附件)'''
import os
import smtplib
from email.header import Header
from email.mime.text import MIMEText


def new_report(report_path):
    file_list = os.listdir(report_path)
    file_list.sort(key=lambda fn: os.path.getmtime(report_path + '\\' + fn))
    print("The new file name: " + file_list[-1])
    return file_list[-1]

def send_report(new_file):
    with open(new_file, 'rb') as f:
        mail_body = f.read()

    subject = 'Python SMTP mail test'
    msg = MIMEText(mail_body, 'html', 'utf-8')
    msg['From'] = '15601925862@163.com'
    msg['To'] = '15601925862@163.com'
    msg['Subject'] = Header(subject, 'utf-8')

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