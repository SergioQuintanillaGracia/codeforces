package cpp.acepta_el_reto;

import java.util.Scanner;
import java.util.Locale;

public class galibo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        while (true) {
            int cases = sc.nextInt();

            if (cases == 0) break;

            int smallest = Integer.MAX_VALUE;

            for (int i = 0; i < cases; i++) {
                int heights = sc.nextInt();
                int highest = Integer.MIN_VALUE;

                for (int j = 0; j < heights; j++) {
                    int current = sc.nextInt();
                    highest = current > highest ? current : highest;
                }

                smallest = highest < smallest ? highest : smallest;
            }

            System.out.println(smallest);
        }
    }
}