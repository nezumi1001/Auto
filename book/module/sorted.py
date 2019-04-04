# 文件按时间排序
import os

file_path = os.getcwd()
L = os.listdir(file_path)
print(L)

L.sort(key=lambda fn: os.path.getmtime(file_path+'\\'+fn))
print("The new file name: " + L[-1])


# 文件排序
file_path = os.getcwd()
L = os.listdir(file_path)
L2 = sorted(L)
print(L2)

file_new = os.path.join(file_path, L2[-1])
print(file_new)