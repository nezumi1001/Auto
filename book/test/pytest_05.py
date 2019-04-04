# -*- coding:utf-8 -*-
import pytest


@pytest.mark.abc
def test_1():
    print('test_1()')


if __name__ == '__main__':
    print('xxxxxxxxx')
    pytest.main(['-s', 'pytest_01.py'])