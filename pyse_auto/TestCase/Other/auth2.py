import requests


url1 = 'https://httpbin.org/cookies'
cookies = {"cookie-name": "selenium"}
r = requests.get(url1, cookies=cookies)
print(r.text)