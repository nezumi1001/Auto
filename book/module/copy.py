import copy

print(dir(copy))
# 过滤掉 '__' 开头
print([i for i in dir(copy) if not i.startswith('__')])
# 定义了模块的公共接口，默认导入所有模块（不包含 '__' 开头）
print(copy.__all__)
# 查看文档注释
print(range.__doc__)
# 查看路径(导入的是否是标准库里的模块)
print(copy.__file__)