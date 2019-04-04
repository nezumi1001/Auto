class Animal():
    sum = 0
    def __init__(self, name):
        self.name = name
        print(self.__class__.sum) # 访问类变量

    @staticmethod # 静态方法
    def check():
        if Animal.sum != 0:
            print('sum is not 0')
        else:
            print('sum is 0')

    @classmethod # 类方法
    def eat(cls):
        cls.sum += 1
        print(cls.sum)

    def report(self):
        self.check()

a1 = Animal('kai')
a1.report()
a1.eat()
a1.report()