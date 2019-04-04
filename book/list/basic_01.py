# 列表/字典可以直接修改元素的值，但要修改整个列表/字典，必须 global
a = [1,2,3]

def fun1():
    a[0] = 0
fun1()
print(a)

def fun2():
    global a
    a = []
fun2()
print(a)


seasons = ['Spring', 'Summer', 'Fall', 'Winter']

count_seasons = seasons.count('Fall') # Return the number of times x appears in the list.
print(count_seasons)

r = list(enumerate(seasons, start=1))
print(r)

r.clear() # del r[:]
print(r)

