import functools


def logit(logfile='out2.log'):
    def logging_decorator(func):
        @functools.wraps(func)
        def wrapped_function(*args, **kwargs):
            log_string = func.__name__ + " was called"
            print(log_string)
            # 打开logfile，并写入内容
            with open(logfile, 'a') as opened_file:
                # 现在将日志打到指定的logfile
                opened_file.write(log_string + '\n')
            return func(*args, **kwargs)
        return wrapped_function
    return logging_decorator

@logit()
def myfunc1():
    pass

myfunc1()

# @logit(logfile='func2.log')
# def myfunc2():
#     pass
#
# myfunc2()