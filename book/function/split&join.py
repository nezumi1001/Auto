'''
split 字符串 > 列表，将把所有空格作为分隔符
join 列表 > 字符串，连接的元素必须为字符串
'''

str = "Chris-iven+Chris-jack+Chris-lusy"

L1 = str.split("+") # 以 + 为分隔符
L2 = str.split("-") # 以 _ 为分隔符
print("L1:")
print(L1)
print("\nL2:")
print(L2)

L3 = " ".join(L1)
L4 = "|".join(L2)
print("\nL3:")
print(L3)
print("\nL4:")
print(L4)

print("\nL5:")
L5 = ('F:', 'home', 'jason')
print('\\'.join(L5))