package bug.free.broccoli.algoexpert;

public class Ae15 {
    public String runLengthEncoding(String string) {
        char[] input = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (int i = 1; i < string.length(); i++) {
            if (input[i - 1] == input[i]) {
                counter++;
                if (counter > 9) {
                    sb.append(9).append(input[i]);
                    counter = 1;
                }
            } else {
                sb.append(counter).append(input[i - 1]);
                counter = 1;
            }

        }
        sb.append(counter).append(input[string.length() - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        Ae15 ae15 = new Ae15();
        System.out.println(ae15.runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    }
}
