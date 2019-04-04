import configparser


class ConfigIni():
    def __init__(self, file_name):
        self.cf = configparser.ConfigParser()
        self.cf.read(file_name)

    def config_value(self, section, name):
        value = self.cf.get(section, name)
        return value

config_ini = ConfigIni(".\\Config\config.ini")
r = config_ini.config_value('config', 'platformName')
print(r)