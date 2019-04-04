'''
关键字参数
- 关键字参数允许你传入0个或任意个含参数名的参数，这些关键字参数在函数内部自动组装为一个dict。
- 命名关键字参数必须传入参数名，这和位置参数不同。如果没有传入参数名，调用将报错。
- 关键字参数既可以直接传入：func(a=1, b=2)，又可以先组装dict，再通过**kw传入：func(**kw)。
- 使用*args和**kw是Python的习惯写法，当然也可以用其他参数名，但最好使用习惯用法。
- 命名的关键字参数是为了限制调用者可以传入的参数名，同时可以提供默认值。
'''
def aa(**kwargs):
    # 判断 key: age 是否存在
    if 'age' in kwargs:
        print('pass')
    print('description: ', kwargs)
    print(type(kwargs))

def bb(name, age):
    print('name: {0}, age: {1}'.format(name, age))

# 定义一个字典变量
my_kw = {'name':'jason', 'age':35}
# 可以先定义一个字典变量传入参数，也可以直接传入参数: aa(name='jason', age=35)
aa(**my_kw)
aa(name='Nobu', age=33)

bb(**my_kw)
bb(name='ippei', age=55)