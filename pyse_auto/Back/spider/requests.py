import requests
from bs4 import BeautifulSoup

url = "https://www.baidu.com"
html = requests.get(url, )

print(html.content)