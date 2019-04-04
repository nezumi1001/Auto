'''类变量和实例变量'''
class Animal():
    name = 'ippei' # 类变量
    def __init__(self, name):
        self.name = name # 实例变量
        print('从内部属性方法访问类变量 name: ' + self.__class__.name) # 访问类变量

a1 = Animal('jason')
# 访问对象 a1 的字典
print('访问对象 a1 的字典:')
print(a1.__dict__)
# 由于实例变量优先级高于类变量，因此它会屏蔽掉类的 name 属性
print('从外部对象访问属性方法 name: ' + a1.name)
# 直接访问类变量
print('从外部直接访问类变量 name: ' + Animal.name)
# 删除实例变量
del a1.name
# 再次调用 a1.name，由于实例的 name 属性没有找到，类的 name 属性就显示出来了
print('从外部对象访问属性方法 name: ' + a1.name)