def divide(x, y):
    try:
        result = x / y
        # raise ValueError("This is value error.")
    # except ValueError as e:
    #     print(e)
    except ZeroDivisionError as e:
        print(e)
        print("Error: {}".format(e.args[-1]))
    except Exception:
        print("Other error.")
    else:
        print("result is ", result)
    finally:
        print("executing finally clause")

print('#1')
divide(2, 1)

print('#2')
divide(2, 0)