import requests
from bs4 import BeautifulSoup


def GetID(url):
    r = requests.get(url)
    html = r.text
    douban = []
    soup = BeautifulSoup(html, 'html.parser')
    items = soup.find_all('a', attrs={'class': 'nbg'})

    for i in items:
        web_site = i.get('href')
        id = web_site.split('/')[4]
        douban.append(id)
    return douban


if __name__ == '__main__':
    url = 'https://book.douban.com/tag/科学?start=20&type=T'
    douban = GetID(url)
    print('The total number: %d' % len(douban))

    for i in douban:
        print('Curreny id: %s' % i)
