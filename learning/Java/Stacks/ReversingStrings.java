package Stacks;
import java.util.ArrayDeque;
import java.util.Deque;

public class ReversingStrings {
    public static void main(String[] args) {
        String str = "This is a string";
        String reversedStrStack = stackReverse(str);
        String reversedStrNormal = normalReverse(str);

        System.out.println(reversedStrStack);
        System.out.println(reversedStrNormal);
    }


    public static String stackReverse(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        // Add every character of the string to the stack.
        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversedStr = new StringBuilder();

        // Pop every element of the stack and add it to reversedStr.
        // As the last element added to the stack is the first to be removed, this
        // will produce a reversed string.
        while (!stack.isEmpty()) {
            reversedStr.append(stack.pop());
        }

        // Convert the StringBuilder into a string and return it.
        return reversedStr.toString();
    }


    public static String normalReverse(String str) {
        StringBuilder reversedStr = new StringBuilder();
        char arr[] = str.toCharArray();

        // Add the characters in the string in reversed order to the StringBuilder.
        for (int i = arr.length - 1; i >= 0; i--) {
            reversedStr.append(arr[i]);
        }

        // Convert the StringBuilder into a string and return it.
        return reversedStr.toString();
    }
}