import java.util.Scanner;

public class yes_or_yes_1703A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < amount; i++) {
            if (sc.next().toUpperCase().equals("YES")) {
                System.out.println("YES");
            
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}