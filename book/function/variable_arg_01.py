#1
def foo(x,y=2,*args,**kwargs):
    print("x==>", x)
    print("y==>", y)
    print("targs_tuple==>", args)
    print("dargs_dict==>", kwargs)

foo("1x", "2y", "3t1", "3t2", d1="4d1", d2="4d2")
print('-'*40)

#2
def cheeseshop(kind, *arguments, **keywords):
    print("-- Do you have any", kind, "?")
    print("-- I'm sorry, we're all out of", kind)
    for arg in arguments:
        print(arg)
    print("-" * 40)
    for kw in keywords:
        print(kw, ":", keywords[kw])

cheeseshop("Limburger", "It's very runny, sir.",
           "It's really very, VERY runny, sir.",
           shopkeeper="Michael Palin",
           client="John Cleese",
           sketch="Cheese Shop Sketch")
