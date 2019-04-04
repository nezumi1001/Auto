#1 open 不加任何参数默认只读
with open('test.txt') as file_obj:
    text = file_obj.read()
    print(text)

#2 添加文件路径
file_path = r'F:\SNWL\Auto\book\文件\file\test2.txt'
with open(file_path) as file_obj:
    text = file_obj.read()
    print(text)

#3 readlines 读取每行并返回列表
file_path = r'F:\SNWL\Auto\book\文件\file\test3.txt'
with open(file_path) as file_obj:
    lines = file_obj.readlines()

for line in lines:
    print(line.rstrip())

#4 只写
file_path = r'F:\SNWL\Auto\book\文件\file\test4.txt'
with open(file_path, 'w') as file_obj:
    file_obj.write("this is a test doc4.")

#5 追加
file_path = r'F:\SNWL\Auto\book\文件\file\test5.txt'
with open(file_path, 'a') as file_obj:
    file_obj.write("this is a test doc5.")

#6 读取 + 写入
file_path = r'F:\SNWL\Auto\book\文件\file\test6.txt'
with open(file_path, 'r+') as file_obj:
    text = file_obj.read()
    file_obj.write("this is a test doc7.")
    print(text)