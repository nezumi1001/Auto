# %
a = 'the name is %s' % 'jason' # 字符串
b = 'the number is %d' % 99 # 十进制
print(a)
print(b)

# format是一个格式化字符串的函数。用{}代替%
# 位置
print("========== 位置 ==========")
str1 = "1111 + 2222 is {0:,}".format(1111+2222)
str2 = "{0} and {1} || {1} and {0}".format('a', 'b')
str3 = "{1[0]},{0[0]}".format(['a',1], ['b',2])
str4 = "This {item} is {status}.".format(item='book', status='good')
str5 = "The book {0}, {1} and {other}.".format('Python', 'Java', other='VB')
print(str1)
print(str2)
print(str3)
print(str4)
print(str5)

"""
格式限定符
^、<、>分别是居中、左对齐、右对齐，后面带宽度
:号后面带填充的字符，只能是一个字符，不指定的话默认是用空格填充
"""
print("========== 格式限定符 ==========")
str7 = '{:>7}'.format('123')
str8 = '{:0<7}'.format('123')
str9 = '{:a^7}'.format('123')

print(str7)
print(str8)
print(str9)

"""
精度与类型f
精度常跟类型f一起使用
"""
print("========== 精度 ==========")
str10 = "The value of 1/3 is approximately {0:.3f}.".format(1/3)
print(str10)

"""
进制
b、d、o、x 分别是二进制、十进制、八进制、十六进制
"""
print("========== 进制 ==========")
str11 = '{:b}'.format(17)
str12 = '{:d}'.format(17)
str13 = '{:o}'.format(17)
str14 = '{:x}'.format(17)

print(str11)
print(str12)
print(str13)
print(str14)

"""
通过类的属性
"""
print("========== 类的属性 ==========")
class User():
    def __init__(self, name, gender, phone):
        self.name = name
        self.gender = gender
        self.phone = phone

    def __str__(self):
        return 'user info: {self.name}, {self.gender}, {self.phone}'.format(self=self)

print(User("Jason", "Male", "123"))

"""
位置/进制
"""
print("========== 位置/进制 ==========")
# Passing an integer after the ':' will cause that field to be a minimum number of characters wide. This is useful for making tables pretty.
table = {'Sjoerd': 4127, 'Jack': 4098, 'Dcab': 7678}
for name, phone in table.items():
    print('{0:10} ==> {1:10d}'.format(name, phone))