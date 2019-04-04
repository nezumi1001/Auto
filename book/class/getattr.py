'''对象属性'''
class Animal():
    ''' ===== settings ===== '''
    def __init__(self, name):
        self.name = name

    ''' ===== get data ===== '''
    def get_name(self):
        print(self.name)

    ''' ===== set data ===== '''
    def set_name(self, name):
        if isinstance(name, str):
            self.name = name
        else:
            print('Invalid name!')

    def eat(self):
        print(self.name + ' is eating...')

class Dog(Animal):
    ''' ===== settings ===== '''
    def __init__(self, name):
        super().__init__(name) # 调用父类构造方法
        self.name = name

if __name__ == '__main__':
    a1 = Animal('jason') # 创建对象
    print(hasattr(a1, 'name')) # 判断属性是否存在
    print(getattr(a1, 'name')) # 获取属性
    setattr(a1, 'name', 'ippei') # 设置属性
    print(getattr(a1, 'name'))  # 如果不知道对象
    print(a1.name) # 如果知道对象
    setattr(a1, 'score', 100) # 追加属性
    print(getattr(a1, 'score'))