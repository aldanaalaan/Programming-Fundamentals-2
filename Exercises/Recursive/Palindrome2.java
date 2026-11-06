package Exercises.Recursive;

public class Palindrome2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("oso"));
    }

    public static boolean isPalindrome(String str) {
        if (str.charAt(0) != str.charAt(str.length() - 1))
            return false;
        else if (str.length() <= 1)
            return true;
        else
            return isPalindrome(str.substring(1, str.length() - 1));
    }
}
