'''dict 代替 switch case'''
def default_day():
    print('This is default day')

list_day = {
      1: lambda : print('This is day1'),
      2: lambda : print('This is day2'),
      3: lambda : print('This is day3')
      }

day = 3 # 用户设置
list_day.get(day, default_day)()