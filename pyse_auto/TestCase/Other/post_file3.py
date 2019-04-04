import requests
import json

url = 'https://httpbin.org/post'
files = [
    ("file1", open(r"F:\Share\Temp\post_file1.txt", "rb")),
    ("file2", open(r"F:\Share\Temp\post_file2.txt", "rb"))
]
r = requests.post(url, files=files)

print(r.status_code)
print(r.text)