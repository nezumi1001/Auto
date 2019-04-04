'''
匿名函数
# 匿名函数有个限制，就是只能有一个表达式，不用写return，返回值就是该表达式的结果。
'''
def aa(a,b):
    return a + b

# 普通函数
print(aa(1,2))

# 匿名函数
r = lambda a,b: a+b
print(r(1,2))

L = [1, 2, 3, 4, 5, 6, 7, 8, 9]

# map 和 lambda 结合
r1 = list(map(lambda a: str(a), L))
r2 = list(map(lambda a: a * a, L))
print(r1)
print(r2)

# 匿名函数2
def make_incrementor(n):
    return lambda x: x + n

f = make_incrementor(42)
print(f(0))
print(f(1))
