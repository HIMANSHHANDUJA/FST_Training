numList=list(map(int,input().split()))
firstElement = numList[0]
lastElement = numList[-1]
 
if (firstElement == lastElement):
    print(True)
else:
    print(False)