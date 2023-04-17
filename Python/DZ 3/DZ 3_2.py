# Требуется найти в массиве A[N] самый близкий по величине элемент к заданному числу X.
# Пользователь в первой строке вводит натуральное число N – количество элементов в массиве.
# В последующих  строках записаны N целых чисел Ai. Последняя строка содержит число X

# import random

# n = int(input("количество элементов в массиве "))
# A = [random.randint(0, 10) for i in range(n)]
# print(A)
# x = int(input("Число для сравнения: "))
# if x < 0:
#     x = abs(x)
# min = abs(x - A[0])
# index = 0
# for i in range(n):
#     count = abs(x - A[i])
#     if count < min:
#         min = count
#         index = i
# print(A[index])


import random

n = int(input("количество элементов в массиве "))
A = [random.randint(0, 10) for i in range(n)]
B = []
print(A)
x = int(input("Число для сравнения: "))
if x < 0:
    x = abs(x)
for i in A:
    B.append(abs(x - i))
f = B.index(min(B))

print(A[f])


# import random

# n = int(input("количество элементов в массиве "))
# A = [random.randint(0, 10) for i in range(n)]
# print(A)
# b = int(input("Число для сравнения: "))
# if b < 0:
#     b = abs(b)
# m= min(A, key=lambda x: abs(x-b))
# print(m)


# import random

# n = int(input("количество элементов в массиве "))
# A = [random.randint(0, 10) for i in range(n)]
# print(A)
# x = int(input("Число для сравнения: "))
# if x < 0:
#     x = abs(x)
# b=[abs(A[i]-x) for i in range(len(A))]
# print(A[b.index(min(b))])