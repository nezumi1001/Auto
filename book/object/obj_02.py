'''面向对象'''
class Student():
    @property
    def score(self):
        return self._score

    @score.setter
    def score(self, value):
        if not isinstance(value, int):
            raise ValueError('Invalid score, it must be an integer')
        elif value < 0 or value > 100:
            raise ValueError('Invalid score, it must between 0 ~ 100')
        self._score = value

    @property
    def level(self):
        if self.score < 60:
            print('Fail')
        elif self.score < 90:
            print('Pass')
        else:
            print('Best')

s = Student()
s.score = 99
print(s.score)
s.level