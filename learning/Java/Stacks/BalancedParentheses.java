package Stacks;
import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {
    public static void main(String[] args) {
        String str = "((5+3)*2)";

        if (isBalanced(str)) System.out.println("The string is balanced");
        else System.out.println("The string is NOT balanced");
    }

    
    static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            // Loop through each character of the string.
            if (c == '(') {
                // If it's a (, push it to the stack.
                stack.push(c);
            }

            if (c == ')') {
                // If it's a ), if the stack is empty, it means there wasn't any opening brace
                // for that closing brace. Else, pop the last element in the stack.
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        // If the stack is empty, every opening brace has a matching closing brace.
        // If it's not, there are more opening braces than closing ones.
        return stack.isEmpty();
    }
}
