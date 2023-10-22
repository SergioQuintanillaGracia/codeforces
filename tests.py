a = 3
char = "#"

for i in range(1, a * 2):
    if i < a :
        print(char * i)

    else:
        print(char * (a * 2 - i))