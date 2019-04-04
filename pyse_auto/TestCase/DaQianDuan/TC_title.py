import requests
from lxml import etree
import csv


pre_url = 'http://www.daqianduan.com/page/'
all_url = [pre_url + str(x) for x in range(1, 10)]
headers = {'User-Agent': 'User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36'}

for url in all_url:
    r = requests.get(url, headers=headers)
    selector = etree.HTML(r.text)
    all_text = selector.xpath("//article[starts-with(@class, 'excerpt excerpt-')]")
    for text in all_text:
        title = text.xpath("header/h2/a/text()")[0]
        time = text.xpath("p[1]/time/text()")[0]
        item = [time, title]
        with open('page.csv', 'a') as f:
            writer = csv.writer(f)
            writer.writerow(item)
            print(time, title)


