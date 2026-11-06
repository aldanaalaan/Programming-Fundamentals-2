package Exercises.Recursive;

import java.util.Scanner;

public class FactorialEx {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        System.out.println(number + "i = " + factorial(number));
        in.close();
    }

    public static long factorial(int n) {
        if (n == 0)
            return 1;

        if (n - 1 < 0)
            return -1;

        return n * factorial(n - 1);
    }
}
