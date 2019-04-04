'''dict 代替 switch case'''
def default_day(a):
    return 'N/A'

list_day = {
      1: lambda a: a + a,
      2: lambda a: a - a,
      3: lambda a: a * a,
      4: lambda a: a / a
      }

day = 1 # 用户设置
r = list_day.get(day, default_day)(10)
print(r)