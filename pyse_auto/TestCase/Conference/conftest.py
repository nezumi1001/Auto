import pytest
from selenium import webdriver


@pytest.fixture()
def login_page(request):
    # setup
    url = 'https://engineering.eng.sonicwall.com'
    driver = webdriver.Chrome(r'C:\Program Files (x86)\Google\Chrome\Application\chromedriver')
    driver_info = {'driver': driver, 'url': url}
    user_info = {'username': 'khuang', 'password': 'nezuminomonO'}
    driver.get(url)
    driver.maximize_window()
    # teardown
    def end():
        driver.quit()
    request.addfinalizer(end)
    return {'driver': driver_info, 'user': user_info}
