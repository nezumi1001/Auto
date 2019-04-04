import configparser


class ReadINI():
    def __init__(self, file_name):
        self.cf = configparser.ConfigParser()
        self.cf.read(file_name)

    def read_ini(self, section, name):
        value = self.cf.get(section, name)
        return value


if __name__ == "__main__":
    config_value = ReadINI('.\\Data\\config.ini')
    base_url = config_value.read_ini('url_Conference', 'URL')
    print(base_url)