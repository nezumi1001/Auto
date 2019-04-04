# -*- coding:utf-8 -*-
import pytest


@pytest.fixture()
def before():
    print('\nbefore each test')
    a = '@@@'
    return a

@pytest.mark.usefixtures("before")
class Test2:
    def test_1(self):
        print('test_1()')

    def test_2(self):
        print('test_2()')

# usefixtures 标记应用在函数前，表示在开始测试前应用该函数但不需要其返回值。
@pytest.mark.usefixtures("before")
def test_3():
    print(before)

def test_4(before):
    print(before)