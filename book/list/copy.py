'''
变量赋值：修改原数据会同时改变新变量
复制拷贝：修改原数据不会改变新的变量
'''

L1 = ['a', 'b', 'c']
L2 = L1[:] # L1.copy()
L3 = L1

def test():
    print('L2:', L2)
    print('L3:', L3)

test()

L1.append('d')

print('========================')
test()