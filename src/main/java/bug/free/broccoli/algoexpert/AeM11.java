package bug.free.broccoli.algoexpert;

import java.util.Stack;

public class AeM11 {

    public static boolean balancedBrackets(String str) {
        Stack<Character> s = new Stack<>();
        char[] input = str.toCharArray();
        for (char i : input) {
            switch (i) {
                case '(':
                case '[':
                case '{':
                    s.push(i);
                    break;
                case ')':
                case ']':
                case '}':
                    if (s.isEmpty() || !matching(s.pop(), i)) return false;
            }
        }
        return s.isEmpty();
    }

    private static boolean matching(char opening, char closing) {
        return (opening == '[' && closing == ']') ||
                (opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}');
    }

    public static void main(String[] args) {
        System.out.println("Balanced=>" + balancedBrackets("([])(){}(())()()"));
    }
}
