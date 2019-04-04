'''遍历索引'''
L1 = ['ippei', 'nobu', 'jason']

# 结合 range() 和 len() 函数以遍历一个序列的索引
for i in range(len(L1)):
    print(i, L1[i])

print('=========================================')
# 索引位置和对应值可以使用 enumerate() 函数同时得到
for i,v in enumerate(L1, start=1):
    print(i,v)

print('=========================================')
# 在字典中遍历时，关键字和对应的值可以使用 items() 方法同时解读出来
D1 = {'name':'jason', 'age':22, 'flag':True}

for k,v in D1.items():
    print(k+':', v)

# 反置
for i in reversed(range(1, 4)):
    print(i)