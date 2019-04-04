# 列表推导式 (函数)
L1 = ['ippei', 1, 'nobu', 2, 'jason', 3]
L2 = ['  banana', '  loganberry ', 'passion fruit  ']

r1 = [a.upper() for a in L1 if isinstance(a, str)]
r2 = [i.strip() for i in L2]

print(r1)
print(r2)