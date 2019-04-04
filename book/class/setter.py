class Dog():
    def __init__(self, name):
        self.__name = name

    @property
    def name(self):
        return self.__name

    @name.setter
    def name(self, new_name):
        if not isinstance(new_name, str):
            print('Please input the valid name!')
        else:
            self.__name = new_name

d1 = Dog('mike')
print(d1.name)

d1.name = 'lulu'
print(d1.name)

d1.name = 22
print(d1.name)