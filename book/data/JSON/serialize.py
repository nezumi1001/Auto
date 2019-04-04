import json

p = [
      {'name':'jason', 'age':20},
      {'sex':'male', 'flag':False},
    ]

# dict > JSON
r = json.dumps(p, sort_keys=True, indent=4, separators=(',', ':'))

print(type(r))
print(r)