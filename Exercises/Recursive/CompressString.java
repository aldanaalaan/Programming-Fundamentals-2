package Exercises.Recursive;

public class CompressString {

    public static void main(String[] args) {
        System.out.println(compressString("aaaabaaaabaaa"));
    }

    public static String compressString(String str) {
        if (str.length() == 1)
            return str;
        String compressed = "" + str.charAt(0);
        char currentC = str.charAt(0);
        int appears = 0;

        for (int i = 0; i < str.length(); i++) {
            if (currentC != str.charAt(i)) {
                break;
            }
            appears++;
        }
        if (appears != 1)
            compressed += appears;

        if (appears != str.length())
            compressed += compressString(str.substring(appears));

        return compressed;

    }
}