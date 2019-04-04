'''
可变参数
- Python允许你在list或tuple前面加一个*号，把list或tuple的元素变成可变参数传进去。
- 可变参数允许你传入0个或任意个参数，这些可变参数在函数调用时自动组装为一个tuple。
- 可变参数既可以直接传入：func(1, 2, 3)，也可以先组装list或tuple，再通过*args传入：func(*args)
- 使用*args和**kw是Python的习惯写法，当然也可以用其他参数名，但最好使用习惯用法。
'''
def aa(*args):
    for i in args:
        print(i)
    print(args)
    print(type(args))	

# 可变参数可以使列表，也可以是元祖: my_args = (1,2,3)
my_args = [1,2,3]
# 可以将变量传入参数，也可以直接传入: aa(1,2,3)
aa(*my_args)