'''面向对象'''
class Student():
    def get_score(self):
        print(self.score)

    def set_score(self, score):
        if not isinstance(score, int):
            raise ValueError('Invalid score, it must be an integer')
        elif score < 0 or score > 100:
            raise ValueError('Invalid score, it must between 0 ~ 100')
        else:
            self.score = score
            print('pass')

s = Student()
s.set_score(77)
s.get_score()