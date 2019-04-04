import pytest
from selenium import webdriver


@pytest.fixture()
def login_page(request):
    # setup
    url = 'https://www.baidu.com'
    driver = webdriver.Chrome(r'C:\Program Files (x86)\Google\Chrome\Application\chromedriver')
    driver_info = {'driver': driver, 'url': url}
    keyword_info = 'selenium'
    driver.get(url)
    driver.maximize_window()
    # teardown
    def end():
        driver.quit()
    request.addfinalizer(end)
    return {'driver': driver_info, 'keyword': keyword_info}
