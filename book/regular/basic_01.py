# match 从头开始匹配，如果没有就结束
# search 从整体匹配，一旦找到就结束
# group() = group(0) => 显示全部
# group(1) => 显示第一组
# group(2) => 显示第二组
# findall() 返回所有匹配结果，并保存到列表

import re


#1
url1 = 'abc123_.png python777'
a1 = re.match(r'\w{3,7}', url1); print('a1: ', a1.group()) # \w 表示字母数字下划线 [A-Za-z0-9_]
a2 = re.search(r'\d+', url1); print('a2: ', a2.group())
a3 = re.match(r'\w+\.png', url1); print('a3: ', a3.group())
a4 = re.search(r'[^\w]', url1); print('a4: ', a4.group()) # '非'匹配必须在 [] 内
a5 = re.findall(r'\w{3}', url1); print('a5: ', a5)

url2 = '<a href="http://news.baidu.com" name="tj_trnews" class="mnav">新闻</a>'
b1 = re.search(r'href=".*?"', url2); print('b1: ', b1.group())
b2 = re.search(r'<a.*?>(.*?)</a>', url2); print('b2: ', b2.group(1))
b3 = re.search(r'^<.*?>$', url2); print('b3: ', b3.group())

#2
text = 'Beautiful is better than ugly, Explicit is better than implicit, double click 666'
c1 = re.search('better', text); print('c1:', c1.group())
c2 = re.search('(\w+) is (\w+)', text); print('c2:', c2.group())
c3 = re.search('(\w+) is (\w+)', text); print('c3:', c3.group(1))
c4 = re.search('(\w+) is (\w+)', text); print('c4:', c4.group(2))
c5 = re.search('than (\w+)', text); print('c5:', c5.group())
c6 = re.findall('than \w+', text); print('c6:', c6)
c7 = re.findall('than (\w+)', text); print('c7:', c7)

egg = re.compile('than (\w+)')
c9 = egg.findall(text); print('c9:', c9)
c8 = re.findall(egg, text); print('c8:', c8)

#3
html = "<title>欢迎来到 python 世界</title>"
r = re.findall('<title>(.*?)</title>', html)
print(r)
print(''.join(r))

#4
html = "Aa123Bb"
r = re.findall('a', html, re.I)
print(r)

