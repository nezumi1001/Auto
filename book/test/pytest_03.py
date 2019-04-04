# -*- coding:utf-8 -*-
import pytest

# @pytest.fixture(scope='function') 默认可省略 function
# @pytest.fixture(scope='class')
# @pytest.fixture(scope='module')
# @pytest.fixture(scope='session')

@pytest.fixture(scope='class')
def before():
    print ('\nbefore each test')

@pytest.mark.usefixtures("before")
class Test2:
    def test_1(self):
        print('test_1()')

    def test_2(self):
        print('\ntest_2()')

