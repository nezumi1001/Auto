#1 函数
squares = []

for x in range(10):
    squares.append(x**2)

print(squares)

#2 列表推导式
squares2 = list(map(lambda x: x**2, range(10)))
print(squares2)

#3 列表推导式 create a new list with the values doubled
squares3 = [x**2 for x in range(10)]
print(squares3)

#4 列表推导式 apply a function to all the elements
squares4 = [-4, -2, 0, 2, 4]
squares4 = [abs(x) for x in squares4]
print(squares4)

#5 列表推导式 call a method on each element
freshfruit = ['  banana', '  loganberry ', 'passion fruit  ']
freshfruit = [weapon.strip() for weapon in freshfruit]
print(freshfruit)

#6 列表推导式 create a list of 2-tuples like (number, square)
squares5 = [(x, x**2) for x in range(6)]
print(squares5)