'''子类调用父类(子)'''
from parent import Animal

class Bird(Animal):
    fly = 50
    def __init__(self, name, spec):
        self.spec = spec
        super(Bird, self).__init__(name) # 调用父类构造方法
        # Animal.__init__(self, name)

    def bird_skin(self):
        super(Bird, self).skin() # 调用父类skin方法

b1 = Bird('sub_kai', 'bird') # 创建子类对象
b1.bird_skin() # 访问子类方法
print(b1.spec) # 访问子类属性变量 spec
print(b1.name) # 访问子类属性变量 name
print(b1.fly) # 访问子类类变量

b2 = Animal('super_kai') # 创建父类对象
print(b2.name) # 访问父类属性变量
print(Animal.fly) # 访问父类类变量