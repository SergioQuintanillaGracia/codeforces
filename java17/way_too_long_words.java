import java.util.Scanner;

public class way_too_long_words {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int wordCount = sc.nextInt();
        String word;
        
        for (int i = 0; i < wordCount; i++) {
            word = sc.next();

            if (word.length() > 10) {
                word = "%s%d%s".formatted(word.charAt(0), word.length() - 2, word.charAt(word.length() - 1));
            }

            System.out.println(word);
        }
    }
}
