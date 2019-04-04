import requests
import json

url = 'https://httpbin.org/post'

#1
# files = {"file1": open(r"F:\Share\Temp\post_file1.txt", "rb")}

#2
# files = {"files": ("", "Ippei")}

#3
with open(r"F:\Share\Temp\post_file1.txt", encoding='UTF-8') as f:
    r = requests.post(url, data=f)

# r = requests.post(url, files=files)

print(r.status_code)
print(r.text)