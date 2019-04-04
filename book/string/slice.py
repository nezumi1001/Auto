'''切片'''
# 在切片操作字符串时，有一个很有用的规律： s[:i] + s[i:] 等于 s
s = 'hello'
r = s[:2] + s[2:]
print(r)

# 插入
a = [1,3]
a[1:1] = [2]
print(a)

# 插入列表
a = [1,2]
b = [3,4]
a.extend(b)
print(a)

# 替换
a = [1,2,3]
a[1:3] = [22,33]
print(a)

# 删除
a[1:] = ""
print(a)

# 索引
a = ['name', 'age']
print(a.index('age'))

# 统计
a = [1,2,3,1,1]
print(a.count(1))