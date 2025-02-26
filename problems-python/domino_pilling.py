arr = input().split(" ")
n = eval(arr[0])
m = eval(arr[1])

if n % 2 == 0 or m % 2 == 0:
    print(n * m // 2)

else:
    print((min(n, m) - 1) * max(n, m) // 2 + max(n, m) // 2)