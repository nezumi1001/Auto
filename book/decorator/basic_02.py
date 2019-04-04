# 导入/不导入 functools
# import functools


def test_de(func):
    # @functools.wraps(func)
    def inner():
        func() #1
        print(func.__name__) #2
        return func
    return inner

@test_de # 先执行
def test_tc():
    print(test_tc.__name__)

r = test_tc()
print(test_tc.__name__) #3
print(r) #4
print(r.__name__) #5