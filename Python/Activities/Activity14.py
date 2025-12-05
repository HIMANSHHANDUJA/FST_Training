def fibonacci(num):
    if num<=1:
        return num
    else:
        return(fibonacci(num-1)+fibonacci(num-2))

s=int(input())
for num in range(s):
    print(fibonacci(num))

