# 如果字符串中既有单引号'又有双引号"，则需要进行转义，用转义字符\来标识
print('I\'m \"Tom\"')

# 转义字符\可以转义很多字符，比如\n表示换行，\r表示回车，\t表示制表符，字符\本身也要转义，所以\\表示的字符就是\
print("abc\t123")
print("abc\n123")

# 如果字符串里面有很多字符都需要转义，就需要加很多\，为了简化，Python还允许用r''表示”内部的字符串默认不转义。
print(r"abc\t123")
print(r"F:\Share\test""\\")

# 如果字符串含有多行（段落），那么添加多个\n会很不方便，Python提供了三引号'''字符串'''来表示段落。例如：
print('''111
... aaa
... ZZZ
... ''')

# 以下的例子使用了一个转义符，避免在最开始产生一个不需要的空行。
print("""\
Usage: thingy [OPTIONS]
       -h                        Display this usage message
       -H hostname               Hostname to connect to
""")