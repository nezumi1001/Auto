# -*- coding:utf-8 -*-
import requests
from lxml import etree
import csv


class Spider():
    # pre_url = 'http://www.daqianduan.com/page/'
    all_url = ['http://www.daqianduan.com/page/' + str(x) for x in range(1, 2)]
    headers = {'User-Agent': 'User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36'}

    def spider(self, url):
        r = requests.get(url, headers=self.headers)
        return etree.HTML(r.text)

    def csv_save(*item):
        with open('page.csv', 'a', encoding='utf-8', newline='') as f:
            writer = csv.writer(f)
            try:
                writer.writerow(item[1])
            except Exception as e:
                print('Error: ', e)
            print(item[1][0], item[1][1])

    def parse(self):
        for url in self.all_url:
            selector = self.spider(url)
            all_text = selector.xpath("//article[starts-with(@class, 'excerpt excerpt-')]")
            for text in all_text:
                time = text.xpath("p[1]/time/text()")[0]
                title = text.xpath("header/h2/a/text()")[0]
                img_url = text.xpath("a/img/@src")[0]
                self.image_download(img_url, title)

    def image_download(self, img_url, title):
        r = requests.get(img_url, headers=self.headers)
        with open('.\\abc\\' + title + '.png', 'wb') as f:
            f.write(r.content)


if __name__ == "__main__":
    Spider().parse()