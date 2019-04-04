# -*- coding:utf-8 -*-
import requests
from lxml import etree


s = requests.session()
url = 'https://www.douban.com/accounts/login'
headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36'}
r = s.get(url, headers=headers)
sel = etree.HTML(r.text)
img_url = sel.xpath("//img[@id='captcha_image']/@src")[0]
img_r = requests.get(img_url)

with open('.\\image\\abc.png', 'wb') as f:
    f.write(img_r.content)

img_text = input('please enter: ')

img_id = img_url.split('=')[1]
img_id = img_id.split('&')[0]
print(img_id)

data = {'form_email': '894223696@qq.com', 'form_password': 'ritsmeikan753951', 'captcha-solution': img_text, 'captcha-id': img_id}
r = s.post(url, data=data, headers=headers)

print('nezumi' in r.text)