import requests
import json

url = 'https://httpbin.org/post'
params = {"show_env": 1}
data = {'a': 'leo', 'b': 'bela'}
r = requests.post(url, params=params, data=data)

print(r.status_code)
print(r.text)