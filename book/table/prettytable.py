from prettytable import PrettyTable


table = PrettyTable(["Name", "Age", "Height"])
table.align["Name"] = "l" # 以 name 字段左对齐
# table.padding_width = 1 # 填充宽度
table.add_row(["ngy", 23, 180])
table.add_row(["kid", 13, 160])
table.add_row(["Yao Ming", 38, 226])
table.add_row(["Isaiah Thomas", 29, 175])
table.add_row(["Kobe Bryant", 40, 198])

s = table.get_string()

# 输出 html
# s = table.get_html_string(format=True, hrules=True)
# file_path = r'.\table.html'
# with open(file_path, 'w', encoding='utf-8') as file_obj:
#     file_obj.write(str(s))

print(s)