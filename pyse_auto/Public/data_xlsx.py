# pip install xlrd
import xlrd


class ReadExcel():
    def __init__(self, file_path, sheet_name):
        self.file_name = xlrd.open_workbook(file_path)
        self.sheet_name = self.file_name.sheet_by_name(sheet_name)

    def cell_no(self):
        '''获取行数对象'''
        return self.sheet_name

    def read_excel(self, row_num, col_num):
        value = self.sheet_name.cell(row_num, col_num).value
        return value


if __name__ == "__main__":
    # 显示单元格数据
    data_path = '.\\Data\\test.xlsx'
    data1 = ReadExcel(data_path, 'Sheet1').read_excel(1,0) # 第 2 行，第 1 列
    data2 = ReadExcel(data_path, 'Sheet1').read_excel(1,1) # 第 2 行，第 2 列
    data3 = ReadExcel(data_path, 'Sheet1').read_excel(1,2) # 第 2 行，第 3 列
    print(data1)
    print(data2)
    print(data3)

    # 显示多行/列
    cell = ReadExcel(data_path, 'Sheet1').cell_no()
    data2 = []
    for i in range(1, cell.nrows):
        data = ReadExcel(data_path, 'Sheet1').read_excel(i, 0)
        data2.append(data)
    print(data2)
