# -*- coding:utf-8 -*-
import requests
import random
import time, re
from lxml import etree
from string import punctuation


def download(url):
    headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36'}
    r = requests.get(url, headers=headers)
    r.encoding = 'utf-8'
    return etree.HTML(r.text)

def spider(text_url):
    selector = download(text_url)
    title = selector.xpath("//h2[@class='rich_media_title']/text()")[0].strip()
    content = selector.xpath("string(//*[@class='rich_media_content '])").strip()
    save_data(title, content)

def save_data(title, content):
    title = re.sub(r'[{}]+'.format(punctuation), '', title)
    with open('./data/' + title + '.txt', 'wt', encoding='utf-8') as f:
        f.write(content)
        print('Downloading...', title)

def main(num):
    for i in range(1, num+1):
        url = 'https://weixin.sogou.com/pcindex/pc/pc_0/{}.html'.format(i)
        selector = download(url)
        text_all = selector.xpath("/html/body/li")
        for text in text_all:
            text_url = text.xpath("div[2]/h3/a/@href")[0]
            spider(text_url)

main(1)