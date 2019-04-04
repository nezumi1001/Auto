# -*- coding:utf-8 -*-
import requests
from lxml import etree
import time
import csv
import random


def save_csv(item, company_name):
    with open('./temp/LaGou.csv', 'a', encoding='gbk', newline='') as f:
        writer = csv.writer(f)
        try:
            writer.writerow(item)
            print('saving: ', company_name)
        except Exception as e:
            print('error: ', e)

def spider(url):
    headers = {
        'Referer': 'http://m.LaGou.com/search.html',
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36',
    }
    cookies = {
        '_ga': 'GA1.3.246047666.1545200985',
        'user_trace_token': '20181219142945-79e6266f-0357-11e9-9211-5254005c3644',
        'LGUID': '20181219142945-79e6293b-0357-11e9-9211-5254005c3644',
        'index_location_city': '%E5%85%A8%E5%9B%BD',
        'JSESSIONID': 'ABAAABAAAFDABFG97A4E558957FA1DC6197E08AB228774D',
        '_gid': 'GA1.2.738517616.1545201341',
        'X_HTTP_TOKEN': '03a9338580502ce49b29d6b8f75b31fa',
        'sensorsdata2015jssdkcross': '%7B%22distinct_id%22%3A%22167c59590a033e-0df3a8f7230b16-69101b7d-2304000-167c59590a11d6%22%2C%22%24device_id%22%3A%22167c59590a033e-0df3a8f7230b16-69101b7d-2304000-167c59590a11d6%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%7D%7D',
         'LGSID': '20181220093554-97c2274e-03f7-11e9-98df-5254005c3644',
        'PRE_UTM': '',
        'PRE_HOST': '',
        'PRE_SITE': 'http%3A%2F%2Fm.lagou.com%2F',
        'PRE_LAND': 'http%3A%2F%2Fm.lagou.com%2Fsearch.html',
        'Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6': '1545269755',
        '_gat': '1',
        'Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6': '1545270942',
        'LGRID': '20181220095542-5b7b2c81-03fa-11e9-98df-5254005c3644'
    }
    r = requests.get(url, headers=headers, cookies=cookies)
    time.sleep(random.randint(2, 5))
    return r

def main(url):
    r = spider(url)
    r = r.json()
    for i in r['content']['data']['page']['result']:
        city = i.get('city')
        company_name = i.get('companyName')
        create_time = i.get('createTime')
        salary = i.get('salary')
        position_id = i.get('positionId')
        page_detail = 'http://m.LaGou.com/jobs/' + str(position_id) + '.html'
        r = spider(page_detail)
        selector = etree.HTML(r.text)

        try:
            work_year = selector.xpath("//span[@class='item workyear']/span/text()")[0].strip()
        except Exception as e:
            work_year = ''
            print('error: ', e)

        try:
            education = selector.xpath("//span[@class='item education']/span/text()")[0].strip()
        except Exception as e:
            education = ''
            print('error: ', e)

        try:
            content = selector.xpath("string(//div[@class='content'])").strip().replace('\xa0', '')
        except Exception as e:
            content = ''
            print('error: ', e)

        item = [city, company_name, create_time, salary, work_year, education, content]
        save_csv(item, company_name)

for i in range(1, 2):
    url = 'http://m.LaGou.com/search.json?city=%E5%85%A8%E5%9B%BD&positionName=%E6%95%B0%E6%8D%AE%E5%88%86%E6%9E%90&pageNo={}&pageSize=15'.format(i)
    main(url)

# r = requests.get('http://m.lagou.com/jobs/4385214.html', headers=headers)
