# Посчитать факториал (произведение 1 до N) и треугольное число (сумма чисел от 1 до N) для числа N ЧЕРЕЗ РЕКУРСИЮ и без циклов

def factorial(N):
    if N == 1:
        return 1
    return N * factorial(N-1)

N = int(input("Input N for Factorial calculating: "))
print("Result : ", factorial(N))



def triangle_num(N):
    if N < 2:
        return 1
  # n * (n + 1) // 2
    t = 1/2 * N * (N+1)
    return  t + triangle_num(N - 1)
N = int(input("Input N for triangle numbers: "))
print("Sum of triangular numbers are: ",triangle_num(N))