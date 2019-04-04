'''
This is doc instruction
如果导入同级目录下的模块，package 将不属于任何包
只有导入子类目录下的模块，package 才会显示此包名
'''
a,b,c = 1,2,3

print('1. package: ' + (__package__ or 'Not belong to any package'))
print('2. name: ' + __name__)
print('3. doc:' + (__doc__ or 'Not any text'))
print('4. file: ' + __file__)
print('5. dir:')
print(dir())