import json

file_name = r'F:\Project\Auto_180608\book\JSON\test.json'
with open(file_name) as file_obj:
    num = json.load(file_obj)

print(num)