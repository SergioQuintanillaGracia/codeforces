import sys

centerX = 3
centerY = 3

x = 0
for line in sys.stdin:
    x += 1

    arr = line.strip().split(" ")
    
    try:
        y = arr.index('1') + 1
        break
    except ValueError:
        pass

print(abs(x - centerX) + abs(y - centerY))