import requests
import json

url = 'https://api.weixin.qq.com/cgi-bin/message/mass/sendall'
params = {"access_token": "15_LQGZXsQ4dbk0fOrnsME7N_jZiU6DFcc9xyp00qSBTK8jkeapbh6hL5EKenqE5huCPYDnHoh7mNixNx-XEyrwntS2pnnVU6-io9uxl4I282TZkUGnzU5k8UmoSOdsmtVTrS8FeFmJP_nUJ0SlWVYjAIAKJM"}

data = {
   "filter":{
      "is_to_all":True
   },
   "text":{
      "content":"ggg"
   },
    "msgtype":"text"
}

r = requests.post(url, params=params, json=data) # 高版本
# r = requests.post(url, params=params, data=json.dumps(data)) # 低版本

print(r.headers)
print(r.status_code)
print(r.text)