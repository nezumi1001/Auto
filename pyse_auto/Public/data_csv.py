import csv


class ReadCSV():
    def __init__(self):
        pass

    def read_csv(self, file_path):
        with open(file_path, 'r', newline='') as f:
            user_datas = csv.reader(f)
            user_data = [i for i in user_datas]
            # for user_data in user_datas:
            #     self.user_content = user_data
            # return self.user_content
            return user_data

    def write_csv(self, file_path):
        with open(file_path, 'w', newline='') as f:
            user_data = csv.writer(f)
            user_data.writerow(['Ippei', 'Nobu', 'Jason'])


if __name__ == "__main__":
    d = ReadCSV()
    d.write_csv('F:\\Project\\Auto\\temp\\abc.csv')

    data = ReadCSV().read_csv('F:\\Project\\Auto\\temp\\abc.csv')
    print(data)
    # print(data[0])
    # print(data[1])
