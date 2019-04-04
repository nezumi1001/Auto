import csv


'''方法1'''
with open('F:\\Project\\Auto_180718\\pyse_auto\\Data\\user.csv') as user_file:
    user_datas = csv.reader(user_file)
    for user_data in user_datas:
        user_content = user_data

'''方法2'''
user_file = open('F:\\Project\\Auto_180718\\pyse_auto\\Data\\user.csv', 'r')
user_datas = csv.reader(user_file)
for user_data in user_datas:
    user_content = user_data

user_file.close()