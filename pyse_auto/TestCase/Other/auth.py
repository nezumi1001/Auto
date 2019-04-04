import requests


url1 = 'https://httpbin.org/cookies'
url2 = 'https://cn.bing.com'

r1 = requests.get(url1)
print(r1.status_code)
print(r1.cookies) # 返回 jar 包，需要转换

r1 = requests.utils.dict_from_cookiejar(r1.cookies) # jar 包 => 字典
print(r1)

r2 = requests.get(url2)
r2 = requests.utils.dict_from_cookiejar(r2.cookies) # jar 包 => 字典
for key, value in r2.items():
    print({key : value})

