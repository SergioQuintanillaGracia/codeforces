package iip;
import java.util.*;

public class E006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lineCount = 0;
        int digitCount = 0;
        int letterCount = 0;

        while (sc.hasNext()) {
            lineCount++;

            String line = sc.nextLine();

            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    digitCount++;

                } else if (Character.isLetter(line.charAt(i))) {
                    letterCount++;
                }
            }
        }
        
        System.out.printf("%10d letters\n%10d digits\n%10d lines\n", letterCount, digitCount, lineCount);
    }
}