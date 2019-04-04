'''用集合提取字典中唯一的元素'''

dict1 = {
    'b1': 'C++',
    'b2': 'Python',
    'b3': 'Java',
    'b4': 'Python',
    }

for book in set(dict1.values()):
    print(book, end=", ")