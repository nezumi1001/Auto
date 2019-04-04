def num_plus(n=0):
    """序号累加"""
    print(str(n+1) + '='*100)
    return n+1

# 定义
num1 = 1
num2 = 1
List1 = [1,2,3]
List2 = [1,2,3]
a = {'a':1, 'b':[2,3] }
b = a.copy()

# 1. 字符串/数值所分配的内存地址始终相同
n = num_plus()
print("id(num1): {0}\nid(num2): {1}".format(id(num1), id(num2)))

# 2. 列表/字典所分配的内存地址都不一样
n = num_plus(n)
print("id(List1): {0}\nid(List2): {1}".format(id(List1), id(List2)))

# 3. copy一个对象后，最外层的内存地址(id)不同。
n = num_plus(n)
print("id(a): {0}\nid(b): {1}".format(id(a), id(b)))

# 4. copy一个对象后，里面的各项元素的内存地址(id)都相同。
n = num_plus(n)
print("id(a['a'])):", id(a['a']))
print("id(b['a'])):", id(b['a']))
print("id(a['b'])):", id(a['b']))
print("id(b['b'])):", id(b['b']))

# 5. 数值为不可变对象
n = num_plus(n)
a['a'] = 2
print("a:", a)
print("b:", b)

# 6. 列表为可变对象
n = num_plus(n)
a['b'].append(4)
print("a:", a)
print("b:", b)