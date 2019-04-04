L1 = [1,2,3,4,5,6,7]
L2 = [1,2,3,4,5,6,7]
L3 = [1,2,3,4,5,6,7]


def f1(a):
    return a ** 2

# map 一般用法
r1 = map(f1, L1)
print(list(r1))

# map 结合 lambda
r2 = map(lambda a: a**2, L1)
print(list(r2))

# map 多个参数
r3 = map(lambda x,y,z: x+y+z, L1,L2,L3)
print(list(r3))