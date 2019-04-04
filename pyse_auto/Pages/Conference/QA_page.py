import smtplib
from email.header import Header
from email.mime.text import MIMEText
from selenium.webdriver.common.by import By
from Pages.base_page import BasePage


class QAPage(BasePage):
    '''settings'''
    username_loc = (By.XPATH, "//input[@id='os_username']")
    password_loc = (By.XPATH, "//input[@id='os_password']")
    login_loc = (By.XPATH, "//input[@id='loginButton']")
    spaces_loc = (By.XPATH, "//a[@id='space-menu-link']")
    QA2_loc = (By.XPATH, "//div[@id='recent-spaces-section']/ul/li/a")
    name_loc = (By.XPATH, "//div[@class='values']/h4/a")
    mail_loc = (By.XPATH, "//div[@class='values']/a")

    def user_login(self, user_info):
        '''login'''
        self.find_element(*self.username_loc, keyword=user_info['username'])
        self.find_element(*self.password_loc, keyword=user_info['password'])
        self.find_element(*self.login_loc)

    def menu_space(self):
        '''menu: space > Shanghai QA2'''
        self.find_element(*self.spaces_loc)
        self.find_elements(*self.QA2_loc, click=True, text='Shanghai QA2')
        # find: name, mail
        self.name_list = self.find_elements(*self.name_loc, add=True)
        self.mail_list = self.find_elements(*self.mail_loc, add=True)

    def send_report(self, mail_title='QA Members', msg_to='15601925862@163.com'):
        '''send mail'''
        self.summary = '<h3 align="center">{} Records Displayed</h3>'.format(len(self.name_list)) + '<hr/>'
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
        while n < len(self.name_list):
            self.table_list += ('<tr><td>' + str(n+1)      + '</td>' +
                                '<td>'     + self.name_list[n] + '</td>' +
                                '<td>'     + self.mail_list[n] + '</td></tr>')
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
        self.msg['Subject'] = Header(mail_title, 'utf-8')
        smtp = smtplib.SMTP('smtp.163.com')
        smtp.login('15601925862@163.com', 'Nezumi753951')
        smtp.sendmail(self.msg['From'], msg_to, self.msg.as_string())
        smtp.quit()
