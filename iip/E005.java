package iip;
import java.util.*;

public class E005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lineCount = 0;
        int wordCount = 0;

        boolean previousWasSpace = false;

        while (sc.hasNext()) {
            lineCount++;

            String line = sc.nextLine().trim();
            if (line.length() > 0) wordCount++;

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ' ') {
                    if (!previousWasSpace) {
                        wordCount++;
                        previousWasSpace = true;
                    }

                } else {
                    previousWasSpace = false;
                }
            }
        }
        
        System.out.printf("%10d words\n%10d lines\n", wordCount, lineCount);
    }
}