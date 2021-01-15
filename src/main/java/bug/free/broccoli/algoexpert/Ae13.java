package bug.free.broccoli.algoexpert;

public class Ae13 {
    public static boolean isPalindrome(String str) {
        int l = str.length();
        boolean matched = true;
        char[] input = str.toCharArray();
        for (int i = 0; i <= l / 2; i++) {
            if (input[i] != input[l - 1 - i]) {
                matched = false;
                break;
            }
        }
        return matched;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdcba"));
    }
}
