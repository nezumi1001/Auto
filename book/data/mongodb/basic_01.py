# -*- coding:utf-8 -*-
import pymongo
from pymongo import MongoClient


client = MongoClient()
db = client.test
collection = db.book

# add 1
book_IT = {'name': 'python', 'value': 99}
collection.insert_one(book_IT)

# add many
book_food1 = {'name': 'apple', 'value': 11}
book_food2 = {'name': 'banana', 'value': 22}
collection.insert_many([book_food1, book_food2])

book_find = collection.find_one({'name': 'python'})
print(book_find)