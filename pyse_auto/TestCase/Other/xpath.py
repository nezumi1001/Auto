# -*- coding:utf-8 -*-
import requests
from bs4 import BeautifulSoup
from lxml import etree


def GetID(url):
    headers = {
        # http: // www.baidu.com
        # 'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36'

        # https: // www.so.com
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36'
    }

    r = requests.get(url, headers=headers)
    selector = etree.HTML(r.text)
    # t = selector.xpath("//div[@id='u1']/a[2]/text()") # 文本
    # t = selector.xpath("//div[@id='u1']/a[2]/@href") # 属性(第2个)
    # t = selector.xpath("//div[@id='u1']/a[2]/text()")[0] # 字符串
    # t = selector.xpath("//div[@id='u1']/a[last()]/@href") # 属性(最末)
    # t = selector.xpath("//div[@id='u1']/a[last()-1]/@href") # 属性(倒数第2个)
    # t = selector.xpath("//*[@id='bd_tabnav']/nav/a[@data-linkid]") # 有/没有该属性
    # t = selector.xpath("//nav[@class='skin-text skin-text-tab']/a[1]/text()") # 支持多修饰
    # t = selector.xpath("//nav[starts-with(@class, 'skin-text')]/a[1]/text()") # 开头属性
    t = selector.xpath("//nav[contains(@class, 'skin-')]/a[1]/text()") # 包含属性
    # t = selector.xpath("//nav[contains(@class, 'skin-')]/a[1]/text()= '360导航'") # 文本属性
    # t = selector.xpath("//nav[@class='skin-text skin-text-tab']/a[contains(text(), '360')]") # 包含文本
    # t = selector.xpath("string(//nav[@class='skin-text skin-text-tab'])") # 所有文本(只能匹配第一个节点下的值)
    # t = selector.xpath("//a[@data-url='http://hao.360.cn/' and @data-linkid='hao']/text()") # 拥有属性(同时)
    # t = selector.xpath("//a[@data-url='http://hao.360.cn/' or @data-linkid='haoxxx']/text()") # 拥有属性(或者)
    # t = selector.xpath("//nav[contains(@class, 'skin-') and contains(@class, 'tab')]/a[1]/text()") # 同时包含属性
    # t = selector.xpath("//nav[contains(@class, 'skin-')]/a[1]/text() | //nav[contains(@class, 'skin-')]/a[2]/text()") # 多个匹配

    '''还原这个对象为 html 字符串'''
    # t = selector.xpath("//nav[contains(@class, 'skin-')]/a[1]")[0]
    # t = etree.tostring(t)


    print(t)


    # print(r.url)
    # print(r.history)
    # print(r.request.headers)
    # print(r.status_code)
    # print(r.status_code == requests.codes.ok)
    # print(r.encoding)
    # r.encoding = 'utf-8'
    # print(r.text)

    # with open(r'F:\Project\Auto\test\a.png', 'wb') as f:
    #     f.write(r.content)


if __name__ == '__main__':
    url = 'https://www.so.com'
    # url = 'http://www.baidu.com'
    # url = 'http://www.douban.com'
    douban = GetID(url)

