dict1 = {
    'name': 'jason',
    'job': 'QA',
    'age': 33,
    }

print("My name is " +
      dict1['name'].title() + ". " +
      "My job is " +
      dict1['job'] + ". " +
      "My age is " +
      str(dict1['age']) + ".")

print("key: ", end="")
for key in dict1.keys():
    print(key, end=", ")

print("\nvalue: ", end="")
for value in dict1.values():
    print(value, end=", ")

print("\nitem: ")
for key, value in dict1.items():
    print(key + ": " + str(value))

print("\nenumerate: ")
for i, v in enumerate(dict1.keys()):
    print(i, v)

dict2 = dict(name='jason', age=33)
print(dict2)

str1 = ''
# a = eval(str1) # 字符串 => 字典

# update
d1 = {'a': 1, 'b': 2}
d2 = {'c': 3, 'd': 4}
d1.update(d2)
print(d1)