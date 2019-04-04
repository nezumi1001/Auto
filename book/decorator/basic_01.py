# 不带参数
import functools


def log(func):
    @functools.wraps(func)
    def wrapper(*args, **kwargs):
        print('the fuc name: %s()' % func.__name__) #1
        print('the fuc doc: %s()' % func.__doc__) #1
        return func(*args, **kwargs) #2
    return wrapper

@log # 先执行
def test(a, b, c):
    '''This is test'''
    print(a, b, c)

test(1, 2, 3)


# 带参数
def log(text):
    def decorator(func):
        @functools.wraps(func)
        def wrapper(*args, **kwargs):
            print('%s %s():' % (text, func.__name__)) #3
            return func(*args, **kwargs) #4
        return wrapper
    return decorator

@log('Hello') # 先执行
def test(a, b, c):
    print(a, b, c)

test(1, 2, 3)