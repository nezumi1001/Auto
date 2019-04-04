import requests
import csv
import http.client
from bs4 import BeautifulSoup

# http://www.weather.com.cn/weather/101010100.shtml

def test_weather(url):
    headers = {
        'Accept': 'text/html, application/xhtml+xml, application/xml; q=0.9, image/webp, image/apng, */*;q=0.8',
        'Accept-Encoding': 'gzip, deflate',
        'Accept-Language': 'en, zh-CN; q=0.9, zh; q=0.8, en-US; q=0.7',
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36'
    }

    r = requests.get(url, headers=headers)
    r.encoding = 'utf-8'
    return r.text

def get_data(html_text):
    final = []
    bs = BeautifulSoup(html_text, 'html.parser')
    body = bs.body
    data = body.find('div', {'id': '7d'})
    ul = data.find('ul')
    li = ul.find_all('li')

    for day in li:
        temp = []
        data = day.find('h1').string
        temp.append(data)

        inf = day.find_all('p')
        temp.append(inf[0].string)

        if inf[1].find('span') is None:
            temperature_highest = None
        else:
            temperature_highest = inf[1].find('span').string
        temperature_lowest = inf[1].find('i').string
        temp.append(temperature_highest)
        temp.append(temperature_lowest)

        final.append(temp)
        return final

def csv_data(data, name):
    file_name = name
    with open(file_name, 'a', newline='') as f:
        f_csv = csv.writer(f)
        f_csv.writerows(data)


if __name__ == '__main__':
    url = 'http://www.weather.com.cn/weather/101010100.shtml'
    html = test_weather(url)
    result = get_data(html)
    csv_data(result, 'result.csv')