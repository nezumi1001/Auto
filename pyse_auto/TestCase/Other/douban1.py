import requests
import unittest

class GetParams(unittest.TestCase):
    def setUp(self):
        self.url = 'https://api.douban.com/v2/book/search'
        self.params = {"q": "TCL"}

    def test_get_params(self):
        r = requests.get(self.url, params=self.params)
        resp = r.json()
        books = resp['books']
        isbn = books[0]['isbn13']
        self.assertEqual(int(isbn), 9787508631769)

    def tearDown(self):
        pass

if __name__ == '__main__':
    unittest.main()
