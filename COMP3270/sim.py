def fib(n):
    if n == 0 or n == 1 or n == 2:
        return 1
    return fib(n - 1) + fib(n - 2) + fib(n - 3)

def main():
    print(fib(6))


if __name__ == "__main__":
    main()
