'''
Python中的对象包含三要素：id、type、value。
其中id用来唯一标识一个对象，type标识对象的类型，value是对象的值。
is判断的是a对象是否就是b对象，是通过id来判断的。
==判断的是a对象的值是否和b对象的值相等，是通过value来判断的。

- 只要各对象的值一样，则 x == y 的值一定为True；
- 如果对象的类型为整数或字符串且值一样，则 x == y和 x is y 的值为True。（经测试浮点型数值，只有正浮点数符合这条规律，负浮点数不符合）；
- list，tuple，dict，set值一样的话，x is y 则为False；
- x == y 与 x != y 的值相反，x is y 与 x is not y 的值相反。

以上结论只针对对变量直接赋值或变量相互赋值后的比较，不针对两个变量之间拷贝后在进行比较。
'''

a = [1,2,3]
b = a.copy()

print(id(a)) # 5665176 (随机)
print(id(b)) # 5668416 (随机)
print(a is b) # False
print(a == b) # True
