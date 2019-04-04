# -*- coding:utf-8 -*-
import requests


cookie = 'lianjia_uuid=b9243250-fdd8-9aec-9f94-4fe95a1bce9e; lianjia_ssid=8bdceb95-3c0e-727f-0f0c-7c4fad7982ef; select_city=310000; TY_SESSION_ID=3eca84e0-02bf-418f-9cc1-c4c8435b0d17; Hm_lvt_9152f8221cb6243a53c83b956842be8a=1545288893; UM_distinctid=167ca6541aa7fc-0daeed65ac1f55-69101b7d-232800-167ca6541ab26d; CNZZDATA1253491255=1075804285-1545286244-%7C1545286244; CNZZDATA1254525948=1921035698-1545285287-%7C1545285287; Hm_lpvt_9152f8221cb6243a53c83b956842be8a=1545288921'

def test_cookie(cookie):
    coo = {}
    for i in cookie.split(';'):
        k, v = i.split('=', 1)
        coo[k.strip()] = v.replace('"', '')
    return coo

cookies = test_cookie(cookie)
print(cookies)