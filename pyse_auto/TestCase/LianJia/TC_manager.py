# -*- coding:utf-8 -*-
import requests
from lxml import etree
import random
import time
import csv


def save_csv(item, manager_name, heading=True):
    with open('.\\temp\\lianjia.csv', 'a', encoding='gbk', newline='') as f:
        writer = csv.writer(f)
        try:
            if heading == True:
                table_heading = ['经纪人', '职位', '店铺', '成交']
                writer.writerow(table_heading)
            else:
                writer.writerow(item)
                print('Saving: ', manager_name)
        except Exception as e:
            print('Error: ', e)

def page_response(url):
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36',
        'Referer': 'https://m.lianjia.com/sh/jingjiren/'
    }
    cookies = {
        'lianjia_uuid': 'b9243250-fdd8-9aec-9f94-4fe95a1bce9e',
        'lianjia_ssid': '8bdceb95-3c0e-727f-0f0c-7c4fad7982ef',
        'select_city': '310000',
        'TY_SESSION_ID': '3eca84e0-02bf-418f-9cc1-c4c8435b0d17',
        'Hm_lvt_9152f8221cb6243a53c83b956842be8a': '1545288893',
        'UM_distinctid': '167ca6541aa7fc-0daeed65ac1f55-69101b7d-232800-167ca6541ab26d',
        'CNZZDATA1253491255': '1075804285-1545286244-%7C1545286244',
        'CNZZDATA1254525948': '1921035698-1545285287-%7C1545285287',
        'Hm_lpvt_9152f8221cb6243a53c83b956842be8a': '1545288921'
    }
    r = requests.get(url, headers=headers, cookies=cookies)
    time.sleep(random.randint(2,7))
    return r

def page_spider(url):
    r_main = page_response(url)
    selector_main = etree.HTML(r_main.text)
    item_list = selector_main.xpath("//div[@class='item_list']")
    save_csv(0,0,heading=True)
    for i in item_list:
        manager_name = i.xpath("div[@class='item_main text_cut flexbox']/span[@class='name']/a/text()")[0].strip()
        manager_level = i.xpath("div[@class='item_main text_cut flexbox']/span[@class='info q_level']/text()")[0].strip()
        manager_shop = i.xpath("string(div[@class='item_other q_shop'])").replace(' ', '').replace('\n', '')
        manager_id = i.xpath("div[@class='item_main text_cut flexbox']/span[@class='name']/a/@href")[0].strip().split('/')[3]
        r_manager = page_response('https://m.lianjia.com/sh/jingjiren/{}/'.format(manager_id))
        selector_manager = etree.HTML(r_manager.text)
        manager_deal = selector_manager.xpath("//div[@class='data_info tab_bar flexbox']/div[1]/div[1]/text()")[0]
        item = [manager_name, manager_level, manager_shop, manager_deal]
        save_csv(item, manager_name, heading=False)

def main():
    for i in range(15, 16, 15):
        url = 'https://m.lianjia.com/sh/jingjiren/?page_size=15&_t=1&offset={}'.format(i)
        page_spider(url)
        print('====== {} managers displayed ======'.format(i))


if __name__ == '__main__':
    main()