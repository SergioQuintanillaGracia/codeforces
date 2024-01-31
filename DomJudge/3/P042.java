import java.util.*;

public class P042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int length = sc.nextInt();
            sc.nextLine();

            String v1Str[] = sc.nextLine().trim().split(" +");
            String v2Str[] = sc.nextLine().trim().split(" +");

            int product = 0;

            // Calculate the product of the vectors
            for (int i = 0; i < length; i++) {
                int v1i = Integer.parseInt(v1Str[i]);
                int v2i = Integer.parseInt(v2Str[i]);

                product += v1i * v2i;
            }

            System.out.println(product);
        }
    }
}