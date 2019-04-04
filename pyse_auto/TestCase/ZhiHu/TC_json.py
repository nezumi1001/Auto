# -*- coding:utf-8 -*-
import re
import json
import requests
from lxml import etree
import random, time
import collections
from pymongo import MongoClient


def spider(user_url):
    headers = {
        'user-agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36',
    }
    r = requests.get(user_url, headers=headers)
    pat = re.compile('<script id="js-initialData" type="text/json">(.*)</script><script src="https://static.zhihu.com/heifetz/vendor.4709996994b6c965ecab.js">')
    r_json = re.findall(pat, r.text)[0]
    # user_follow = json.loads(r_json).get('initialState')['entities']['users'].keys()
    user_follow = list(json.loads(r_json)['initialState']['entities']['users'].keys())[1:]
    # new_url = ['https://www.zhihu.com/people/' + user_name + '/following' for user_name in user]
    url_all = ['https://www.zhihu.com/people/{}/following'.format(user_name) for user_name in user_follow]
    sel = etree.HTML(r.text)
    try:
        name = sel.xpath("//span[@class='ProfileHeader-name']/text()")[0]
        print(name)
    except:
        name = ''
        print('name invalid')
    # work = sel.xpath("//div[@class='ProfileHeader-infoItem']/text()")[0]
    # fan = sel.xpath("//div[@class='NumberBoard FollowshipCard-counts NumberBoard--divider']/a/div/strong/text()")
    collection.insert_one({'name': name})
    time.sleep(random.randint(3, 7))
    return url_all

url_need = collections.deque()
url_need.append('https://www.zhihu.com/people/qi-wen-guang/following')
client = MongoClient()
db = client.zhihu
collection = db.user

url_have = set()
while True:
    user_url = url_need.popleft()
    try:
        url_all = spider(user_url)
        url_have.add(user_url)
        url_pre = list(set(url_all) - url_have)
        url_need.extend(url_pre)
    except:
        pass