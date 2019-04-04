# 列表，括号之类分行时直接回车就可以
text = ('Put several strings within parentheses '
        'to have them joined together.'
        )
print(text)

L = [1,2,3,
     4,5,6,
     'a','b','c']
print(L)

# 一般分行需要反斜杠 \
a = 'a' + 'b' \
    'c' + 'd'
print(a)

str1 = "aaa"
str2 = "bbb"
str3 = "ccc"
print(''.join([str1, str2, str3]))