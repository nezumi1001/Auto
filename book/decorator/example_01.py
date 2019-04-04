import functools


def new_decorator(func):
    print("Step 0...") # 一般不写
    @functools.wraps(func)
    def wrap_function(*args, **kwargs):
        print("Step 1...")
        func()
        print("Step 2...")
    return wrap_function

@new_decorator # 先执行
def function_decoration():
    """Hey you! Decorate me!"""
    print(function_decoration.__doc__)


function_decoration()
print(function_decoration.__name__)