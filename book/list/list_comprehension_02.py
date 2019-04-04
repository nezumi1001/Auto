'''
列表推导式 (列出当前目录下的所有文件和目录名)
'''
import os

L1 = [a for a in os.listdir('.')]

print(L1)