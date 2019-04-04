'''dict 代替 switch case'''

#1
def dict_check(a):
    return {
        0: "It is 0",
        1: "It is 1",
        2: "It is 2"
        }.get(a, "xxxxxxx")

r = dict_check(1)
print(r)

#2
def default_day():
    return 'This is default day'

list_day = {
      1: 'This is day1',
      2: 'This is day2',
      3: 'This is day3'
      }


day = 7 # 用户设置
get_day1 = list_day.get(day, 'Unknown')
get_day2 = list_day.get(day, default_day())

print(get_day1)
print(get_day2)


