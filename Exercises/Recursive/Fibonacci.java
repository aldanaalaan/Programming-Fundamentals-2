package Exercises.Recursive;

public class Fibonacci {

    public static int calls = 0;
    public static void main(String[] args) {
        final int INDEX = 11;
        System.out.println("Fibonacci number by index: " + INDEX);
        System.out.println(fibonacciByIndex(INDEX));
    }

    public static long fibonacciByIndex(long index) {
        calls++;
        if (index == 0)
            return 0;
        else if (index == 1)
            return 1;
        else
            return fibonacciByIndex(index - 1) + fibonacciByIndex(index - 2);
    }
}
