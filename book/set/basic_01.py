# 去重并按顺序排列
a = [1,3,7,7,5]
b = list(set(a))
print(b)
b.sort(key=a.index)
print(b)

a = set([1,2,3])
b = set([4,2,6])
print(a & b) # 交集
print(a - b) # 差集
print(a | b) # 并集