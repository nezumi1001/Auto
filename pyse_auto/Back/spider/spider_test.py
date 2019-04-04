from bs4 import BeautifulSoup
from selenium import webdriver


driver = webdriver.PhantomJS()
url = "https://www.baidu.com"
driver.get(url)
html = driver.page_source

soup = BeautifulSoup(html, 'html.parser', from_encoding='utf-8')
# soup = BeautifulSoup(html, 'lxml')
# r = soup.select("input[id='kw']")
print((soup.contents))

