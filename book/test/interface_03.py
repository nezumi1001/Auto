import requests
import json

url = 'https://api.weixin.qq.com/cgi-bin/message/mass/sendall'
params = {"access_token": "15_4ZW1GHFvVojrkPOiFNexvnI7rYUMV2LvWNmd1vG7c6wzhtdfYVTbJ_YuL1lq92SDJvBm2xFbBebO6OCYusp7Fk5pKYZbydH-mFZ1GIrKNoTgnQqDIB3-ZHgzbfDKcQvZmiT9ZwiNXYXj0gncIYPbAGATJA"}

data = {
   "filter":{
      "is_to_all":True
   },
   "text":{
      "content":"ccc"
   },
    "msgtype":"text"
}

r = requests.post(url, params=params, json=data) # 高版本
# r = requests.post(url, params=params, data=json.dumps(data)) # 低版本

print(r.headers)
print(r.status_code)
print(r.text)