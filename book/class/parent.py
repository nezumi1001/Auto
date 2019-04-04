'''子类调用父类(父)'''
class Animal():
    fly = 100
    def __init__(self, name):
        self.name = name
        print('This is Animal class')

    def skin(self):
        print('This is Animal skin')