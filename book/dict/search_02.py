'''dict 代替 switch case'''
def day1():
    return 'This is day1'

def day2():
    return 'This is day2'

def day3():
    return 'This is day3'

def default_day():
    return 'This is default day'

list_day = {
      1: day1,
      2: day2,
      3: day3
      }

day = 1 # 用户设置
get_day = list_day.get(day, default_day)()

print(get_day)