import requests
import json

url = 'https://api.douban.com/v2/book/search'
params = {'q':'东野圭吾'}
r = requests.get(url, params=params)

print(r.status_code, r.reason)
print(r.headers)
print(r.text)