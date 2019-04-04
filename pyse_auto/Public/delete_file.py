import os


def del_files(path):
    for root, dirs, files in os.walk(path):
        for name in files:
            if '.log' or '.html' or '.xls' or '.png' in name:  # 判断是否为某一字串
                os.remove(os.path.join(root, name)) # os.move 语句为删除文件语句
                print('Delete files:', os.path.join(root, name))


if __name__=='__main__':
    # 此为需要删除的路径
    path1 = r'F:\Project\Auto\pyse_auto\Report\AttReport'
    path2 = r'F:\Project\Auto\pyse_auto\Report\LogReport'
    path3 = r'F:\Project\Auto\pyse_auto\Report\TestReport'
    path4 = r'F:\Project\Auto\pyse_auto\Screenshot'

    # 调用函数
    del_files(path1)
    del_files(path2)
    del_files(path3)
    del_files(path4)