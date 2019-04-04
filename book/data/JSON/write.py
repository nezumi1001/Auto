import json

num = ['a', 'b', 'c']

file_name = r'F:\SNWL\Auto\book\JSON\test.json'
with open(file_name, 'w') as file_obj:
    json.dump(num, file_obj)