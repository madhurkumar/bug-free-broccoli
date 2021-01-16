package bug.free.broccoli.algoexpert;

public class Ae14 {

    public static String caesarCypherEncryptor(String str, int key) {
        char[] input = str.toCharArray();
        StringBuilder sb = new StringBuilder(str.length());
        key = key < 26 ? key : key % 26;
        for (int i = 0; i < str.length(); i++) {
            int d = 122 - (int) input[i];
            if (d >= key) sb.append((char) ((int) input[i] + key));
            else sb.append((char) ((int) 'a' + key - d - 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("abc", 52));
    }
}
