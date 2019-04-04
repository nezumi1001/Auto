'''列表推导式'''
L = [1, 2, 3, 4, 5, 6, 7, 8, 9]

r1 = [a*a for a in L]
r2 = [a*a for a in L if a <= 3]
r3 = [[a, a**2] for a in L]

print(r1)
print(r2)
print(r3)