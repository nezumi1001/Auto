'''
列表推导式 (字典)
'''
D1 = {'a':1, 'b':2, 'c':3}
L1 = [1,2,3,4,5]

# 1. 循环打印 key, value
for k,v in D1.items():
    print(k, '=', v)

# 2. 列表推导式打印 key, value
r = [key+'='+str(value) for key,value in D1.items()]
print(r)

# 将列表显示为字典
d = {a: a**2 for a in L1}
print(d)