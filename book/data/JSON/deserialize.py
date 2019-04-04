import json

# JSON 字符串
f = '{"name":"jason", "age":22, "flag":true}'
# JSON > dict
r = json.loads(f)

print(type(f))
print(type(r))
print(r)