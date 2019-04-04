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
                detail_url = text.xpath("header/h2/a/@href")[0]
                content = self.parse_detail(detail_url)
                csv_params = [time, title, content]
                self.csv_save(csv_params)

    def parse_detail(self, detail_url):
        sel = self.spider(detail_url)
        return sel.xpath("string(//*[@class='article-content'])")


if __name__ == "__main__":
    Spider().parse()