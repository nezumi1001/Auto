# normal call with separate arguments
L1 = list(range(3, 6))
print(L1)

# call with arguments unpacked from a list
args = [3, 6]
L2 = list(range(*args))
print(L2)

# function
def test(*num):
    print(num)
    print(type(num))
    print(*num)

test(1, 2)