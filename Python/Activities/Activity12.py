def sum(num):
    if num:
        return num + sum(num-1)
    else:
        return 0


n=int(input())
print(sum(n))

