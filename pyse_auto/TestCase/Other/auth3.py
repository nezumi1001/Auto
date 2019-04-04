import requests


url1 = 'https://httpbin.org/cookies'
url2 = 'https://httpbin.org/cookies/set/sessioncookies/123456'

#1
# r = requests.get(url1)
# print(r.text)

#2
# r = requests.get(url2)
# print(r.text)

#3
# session = requests.session() # 初始化一个 session 对象
# r = session.get(url2)
# print(r.text)

#4
history1 = {'history1': 'huawei'}
history2 = {'history2': 'xiaomi'}
session = requests.session()

session.headers.update(history1)
r = session.get("https://httpbin.org/headers", headers=history1)
session.headers.update(history2)
r = session.get("https://httpbin.org/headers", headers=history2)
print(r.text)

# 删除 session
session.headers['history1'] = None
r = session.get("https://httpbin.org/headers", headers=history2)
print(r.text)
