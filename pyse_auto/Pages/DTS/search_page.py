import smtplib
from email.header import Header
from email.mime.text import MIMEText
from selenium.webdriver.common.by import By
from Pages.base_page import BasePage


class SearchPage(BasePage):
    '''settings'''
    username_loc = (By.XPATH, "//input[@name='uname']")
    password_loc = (By.XPATH, "//input[@name='password']")
    submit_loc = (By.XPATH, "//input[@name='GoAheadAndLogIn']")
    query_loc = (By.XPATH, "//a[@href='/search.asp']")
    status_loc = (By.XPATH, "//select[@name='bug_status']")
    reporter_loc = (By.NAME, "reporter")
    run_loc = (By.XPATH, "//input[@value='Run Query']")
    email_loc = (By.XPATH, "//input[@value='Email Owners']")
    list_loc = (By.XPATH, "//form[@name='editMultiple']/table[1]/tbody/tr")

    def list_loop(self, ID, tr_num, td_num):
        '''get element'''
        if ID == False:
            self.tr_td = (By.XPATH, "//form[@name='editMultiple']/table[1]/tbody/tr{0}/td{1}".format([tr_num], [td_num]))
            return self.tr_td
        elif ID == True:
            self.tr_td2 = (By.XPATH, "//form[@name='editMultiple']/table[1]/tbody/tr{0}/td{1}/a".format([tr_num], [td_num]))
            return self.tr_td2

    def user_login(self, user_info):
        '''login'''
        self.find_element(*self.username_loc, keyword = user_info['username'])
        self.find_element(*self.password_loc, keyword = user_info['password'])
        self.find_element(*self.submit_loc)

    def dts_query(self):
        '''query'''
        self.find_element(*self.query_loc)
        self.find_element(*self.status_loc, click=False, value='qa_ready')
        self.find_element(*self.reporter_loc, click=False, value='4395') # Jason
        # self.find_element(*self.reporter_loc, click=False, value='3996') # Mike
        self.switch_window(ready=1)
        self.find_element(*self.run_loc)
        self.switch_window(ready=2)
        self.find_element(*self.email_loc, click=False) # 等待 [Email Owners] 按钮
        self.item_count = self.find_elements(*self.list_loc, count=True)
        # item_count 多包含1个(背景色)
        self.entry_list = []
        for m in range(2, self.item_count+1):
            for n in range(2, 13):
                self.ID = True if n == 2 else False
                self.entry_list.append(self.find_elements(*self.list_loop(self.ID, tr_num=m, td_num=n), add=True))

    def send_report(self, mail_title='DTS Summary', msg_to ='15601925862@163.com'):
        '''send mail'''
        self.summary = '<h3 align="center">{} Records Displayed</h3>'.format(self.item_count-1) + '<hr/>'
        self.table_heading = """
                                    <table class="pure-table">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Opened</th>
                                                <th>Sev</th>
                                                <th>Pri</th>
                                                <th>Owner</th>
                                                <th>QA Assignee</th>
                                                <th>Reporter</th>
                                                <th>Status</th>
                                                <th>Result</th>
                                                <th>Target Ver</th>
                                                <th>Summary</th>
                                            </tr>
                                        </thead>
                                    <tbody>
                            """

        n = 0
        self.table_list = ''
        while n < len(self.entry_list):
            self.table_list += ('<tr><td>' + self.entry_list[n+0][0] + '</td>' +
                                '<td>'     + self.entry_list[n+1][0] + '</td>' +
                                '<td>'     + self.entry_list[n+2][0] + '</td>' +
                                '<td>'     + self.entry_list[n+3][0] + '</td>' +
                                '<td>'     + self.entry_list[n+4][0] + '</td>' +
                                '<td>'     + self.entry_list[n+5][0] + '</td>' +
                                '<td>'     + self.entry_list[n+6][0] + '</td>' +
                                '<td>'     + self.entry_list[n+7][0] + '</td>' +
                                '<td>'     + self.entry_list[n+8][0] + '</td>' +
                                '<td>'     + self.entry_list[n+9][0] + '</td>' +
                                '<td>'     + self.entry_list[n+10][0] + '</td></tr>')
            n += 11

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
