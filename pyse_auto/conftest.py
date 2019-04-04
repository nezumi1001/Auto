import sys, os
import pytest
sys.path.append(os.getcwd())


@pytest.fixture()
def common_path():
    log_path = '.\\Report\\'
    data_path = '.\\Data\\'
    case_path = '.\\TestCase\\'
    downloads_path = 'C:\\Users\\khuang\\'
    path = {'log_path': log_path,
            'data_path': data_path,
            'case_path': case_path,
            'downloads_path': downloads_path}
    return path
