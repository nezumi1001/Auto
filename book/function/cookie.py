# cookie format
# http://www.bejson.com/

# cookie = 'BIDUPSID=CE5F5F051C2D8BA8B4B33D83FD810F32; PSTM=1528952078; BAIDUID=CE5F5F051C2D8BA8B4B33D83FD810F32:SL=0:NR=10:FG=1; sug=3; sugstore=0; ORIGIN=0; bdime=0; delPer=0; BD_HOME=0; H_PS_PSSID=1422_21127_22159; BD_UPN=12314353'
cookie = 'acw_tc=2f624a6815501301861053056e74427cb2f886f2b11d34f41184a993aafe47; PHPSESSID=1ufn6ub1dvst2qdcng88vestp3; UtzD_f52b_saltkey=uIr9JT1U; UtzD_f52b_lastvisit=1550126757; yaozh_uidhas=1; acw_tc=2f624a6815501301861053056e74427cb2f886f2b11d34f41184a993aafe47; MEIQIA_VISIT_ID=1HA1exvBwWDxAUVRp96PEEcCCEx; Hm_lvt_65968db3ac154c3089d7f9a4cbb98c94=1550130187%2C1550130280%2C1550130323; UtzD_f52b_ulastactivity=1550130356%7C0; yaozh_userId=693114; UtzD_f52b_creditnotice=0D0D2D0D0D0D0D0D0D638152; UtzD_f52b_creditrule=%E6%AF%8F%E5%A4%A9%E7%99%BB%E5%BD%95; MEIQIA_VISIT_ID=1HC92sfE1HaS1aSjtFUd4nqebfj; yaozh_mylogin=1550195046; UtzD_f52b_creditbase=0D0D2D0D0D0D0D0D0; yaozh_logintime=1550195763; yaozh_user=693114%09pashanhu1001; db_w_auth=638152%09pashanhu1001; UtzD_f52b_lastact=1550195764%09uc.php%09; UtzD_f52b_auth=0480bOVtKSBbgybH4sclbZn3QZfG1xUw4%2BfkCeDeCluj9wS1kNw3DotXs4CS6vi6omyNE%2FVqBBrRw7AdAKZZVABVlA8; Hm_lpvt_65968db3ac154c3089d7f9a4cbb98c94=1550195768'

def set_cookie(cookie):
    coo = {}
    for i in cookie.split(';'):
        k, v = i.split('=', 1)
        coo[k.strip()] = v.replace('"','')
    return coo

get_coo = set_cookie(cookie)
print(get_coo)
