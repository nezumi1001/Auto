# 统计函数使用时间
import functools
import time


def wrap_performance(func):
    @functools.wraps(func)
    def wrapper(self, *args, **kwargs):
        t_begin = time.time()
        func(self, *args, **kwargs)
        t_end = time.time()
        print("Time: %f " % (t_end - t_begin))
    return wrapper


class Test:
    def __init__(self):
        pass

    @wrap_performance # 先执行
    def test(self):
        time.sleep(1)


t = Test()
t.test()