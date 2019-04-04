import os

print(os.getcwd())
print(os.__file__)
print(__file__)
print(os.path.realpath(__file__))
print(os.path.split(os.path.realpath(__file__)))
print(os.path.split(os.path.realpath(__file__))[0])
