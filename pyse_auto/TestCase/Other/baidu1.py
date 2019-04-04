import requests
import unittest

class GetParams(unittest.TestCase):
    def setUp(self):
        self.url = 'https://www.baidu.com/s'

    def test_params(self):
        params = {'wd':'python'}
        headers = {
            'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
            'Accept-Encoding': 'gzip, deflate, br',
            'Accept-Language': 'zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2',
            'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:62.0) Gecko/20100101 Firefox/62.0'
        }

        data_params = {'params': params, 'headers': headers}
        # r = requests.get(self.url, params=params, headers=headers)
        r = requests.get(self.url, **data_params)
        trans_encoding = r.headers['Transfer-Encoding']
        self.assertEqual(trans_encoding, 'chunked')

        # for k, v in r.headers.items():
        #     print(k, ': ', v)

    def tearDown(self):
        pass

if __name__ == '__main__':
    unittest.main()

# print(r.status_code, r.reason)
# print(r.headers)
# print(r.text)