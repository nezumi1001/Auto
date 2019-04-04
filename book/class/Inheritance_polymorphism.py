'''类的继承和多态'''
class Animal():
    ''' ===== settings ===== '''
    def __init__(self, name):
        self.name = name

    def sleep(self):
        print(self.name + ' is sleeping...')

    def skill(self, animal_name):
        animal_name.eat()

    def eat(self):
        print(self.name + ' is eating...')

class Dog(Animal):
    ''' ===== settings ===== '''
    def __init__(self, name):
        super().__init__(name)
        self.name = name

    def eat(self):
        print(self.name + ' is eating his meal...') # 覆盖父类方法

class Cat(Animal):
    ''' ===== settings ===== '''
    def __init__(self, name):
        super().__init__(name)
        self.name = name

# 外部函数
def eat_all(who):
    who.eat()

if __name__ == '__main__':
    # 继承顺序
    print(Cat.__mro__)

    # 创建实例
    a1 = Animal('jason')
    a1.eat()

    # 继承
    a2 = Dog('nobu')
    a2.sleep()

    # 多态
    a3 = Dog('mike')
    a1.skill(a3)

    a4 = Cat('lucky')
    a1.skill(a4)

    eat_all(Dog('Mike'))
    eat_all(Dog('Nobu'))