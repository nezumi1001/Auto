class Animal():
    '''定义类变量'''
    sum = 1
    def __init__(self, name):
        self.name = name
        # 私有属性变量
        self.__age = 22
        # 从属性方法访问类变量，也可以 print(Animal.sum) 来访问，这样做不适合，应该在外部访问
        print('1. 从属性方法访问类变量 sum: ' + str(self.__class__.sum))

    def aa(self):
        # 调用属性方法
        self.bb()

    def bb(self):
        print(self.__age)

a1 = Animal('kai')
# 从外部访问类变量
print('2. 从外部访问类变量 sum: ' + str(Animal.sum))
# 访问属性变量 (公有)
print('3. 从外部访问属性变量 name: ' + a1.name)
# 由于无法从外部直接访问私有变量，所以通过类方法调用 (私有)
print('4. 从外部访问属性变量 (私有) __age: ')
a1.aa()