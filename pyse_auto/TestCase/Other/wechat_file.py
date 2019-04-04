import requests
import json

url = 'https://api.weixin.qq.com/cgi-bin/media/upload'
params = {"access_token": "15_wimTEWdzQsATar5EXUUqIIGxUPfOzJECPfx23i_nrtoS7hfOwquCM9hTiQn4Oa7qzUostVK7Un0lDIraznsO7zcsKC7Pt040lGotmair2lvrD1jLHViaDrqa1uuA_AgUnAqkBM1g0mwKGq-GPVPcAHAXDX",
          "type": "image"}

files = {"file": open(r"F:\Share\Temp\baiduYun.png", "rb")}
r = requests.post(url, params=params, files=files)

print(r.status_code)
print(r.text)