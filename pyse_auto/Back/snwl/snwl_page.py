# -*- coding: utf-8 -*-
'''snwl_page'''
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class BasePage():
    def __init__(self, driver, url):
        self.driver = driver
        self.base_url = url
        self.username = 'sv\khuang'
        self.password = 'Nezuminomono'
        self.mail_from = "khuang@sonicwall.com"
        self.mail_to = "khuang@sonicwall.com"
        # self.mail_to = "15601925862@163.com"
        self.mail_title = "测试邮件"
        self.mail_text = "邮件发送测试..."

class MainPage(BasePage):
    def browser_open(self):
        # open browser
        print("Open url %s ... Done" %(self.base_url))
        self.driver.maximize_window()
        # username
        WebDriverWait(self.driver, 60).until(EC.visibility_of_element_located((By.XPATH, "//input[@id='username']")))
        self.driver.find_element_by_xpath("//input[@id='username']").clear()
        self.driver.find_element_by_xpath("//input[@id='username']").send_keys(self.username)
        # password
        WebDriverWait(self.driver, 60).until(EC.visibility_of_element_located((By.XPATH, "//input[@id='password']")))
        self.driver.find_element_by_xpath("//input[@id='password']").clear()
        self.driver.find_element_by_xpath("//input[@id='password']").send_keys(self.password)
        # login
        WebDriverWait(self.driver, 60).until(EC.visibility_of_element_located((By.XPATH, "//div[@onclick='clkLgn()']"))).click()
        # wait for page title
        WebDriverWait(self.driver, 60).until(EC.title_contains("邮件"))
        print("Success to find page title %s ... Done" %(self.driver.title))

    def mail_create(self):
        # click new email
        WebDriverWait(self.driver, 60).until(EC.visibility_of_element_located((By.XPATH, "//button[@autoid='_fce_1']"))).click()
        print("Create a new email... Done")
        # from
        WebDriverWait(self.driver, 60).until(EC.visibility_of_element_located((By.XPATH, "//input[@autoid='_fp_5']"))).send_keys(self.mail_from)
        print("Input FROM: %s ... Done" %(self.mail_from))
        # to
        WebDriverWait(self.driver, 60).until(EC.visibility_of_element_located((By.XPATH, "//input[contains(@class, 'ms-fcl-ns')]"))).send_keys(self.mail_to)
        print("Input TO: %s ... Done" %(self.mail_to))
        # mail title
        self.driver.find_element_by_xpath("//input[contains(@class, 'ms-fcl-ns')]").send_keys(Keys.TAB)
        WebDriverWait(self.driver, 60).until(EC.visibility_of_element_located((By.XPATH, "//input[@autoid='_mcp_c']"))).send_keys(self.mail_title)
        print("Input email title %s ... Done" %(self.mail_title))
        # mail text
        self.driver.find_element_by_xpath("//input[contains(@class, 'ms-fcl-ns')]").send_keys(Keys.TAB)
        WebDriverWait(self.driver, 60).until(EC.visibility_of_element_located((By.XPATH, "//div[@aria-label='邮件正文']"))).send_keys(self.mail_text)
        print("Input email text %s ... Done" %(self.mail_text))
        # send
        WebDriverWait(self.driver, 60).until(EC.visibility_of_element_located((By.XPATH, "//button[@autoid='_mcp_g']"))).click()
        print("Send email... Done")

    def browser_quit(self):
        '''close browser'''
        print("Ready to close the browser... Done")
        return self.driver