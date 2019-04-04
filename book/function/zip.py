'''zip'''

L1 = ['a', 'b', 'c']
L2 = [1, 2, 3]
L3 = [4, 5, 6]

#1
r = zip(L2, L3)
print(list(r))

#2
D1 = zip(L1, L2)
print(dict(D1))

#3
for k,v in zip(L1, L2):
    print(k+':',v)

#4
questions = ['name', 'quest', 'favorite color']
answers = ['lancelot', 'the holy grail', 'blue']

for q, a in zip(questions, answers):
    print('What is your {0}?  It is {1}.'.format(q, a))