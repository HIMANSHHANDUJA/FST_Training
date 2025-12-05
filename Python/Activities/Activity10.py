a=input().split()
h=[int(a)]
t=tuple(h)
print(h)
for num in h:
    if (num%5 == 0):
        print(num)
    else:
        print("not divisible")