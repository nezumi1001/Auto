# pip install xlrd
import xlrd

class ReadExcel():
    def __init__(self, file_name, sheet_name):
        self.file_name = xlrd.open_workbook(file_name)
        self.sheet_name = self.file_name.sheet_by_name(sheet_name)

    def read_excel(self, row_num, col_num):
        value = self.sheet_name.cell(row_num, col_num).value
        return value

data = ReadExcel(".\\pyse_auto\\Data\\test.xlsx", "Sheet1").read_excel(1,0) # 第 1 行，第 0 列
print(data)