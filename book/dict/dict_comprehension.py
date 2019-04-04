# dict comprehensions can be used to create dictionaries from arbitrary key and value expressions
D1 = {x: x**2 for x in (2, 4, 6)}
print(D1)

# When the keys are simple strings, it is sometimes easier to specify pairs using keyword arguments:
D2 = dict(sape=4139, guido=4127, jack=4098)
print(D2)

# 你还可以快速对换一个字典的键和值
d2 = {'a':1, 'b':2}
r2 = {v:k for k, v in d2.items()}
print(r2)