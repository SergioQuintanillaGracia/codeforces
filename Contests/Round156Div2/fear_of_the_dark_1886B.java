// NOTE: I haven't entirely solved this problem yet, it will not pass the tests.

import java.util.Scanner;

public class fear_of_the_dark_1886B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p[] = new int[2];
        int a[] = new int[2];
        int b[] = new int[2];
        int o[] = new int[2];
        int cases = sc.nextInt();

        o[0] = 0;
        o[1] = 0;

        for (int i = 0; i < cases; i++) {
            p[0] = sc.nextInt();
            p[1] = sc.nextInt();
            a[0] = sc.nextInt();
            a[1] = sc.nextInt();
            b[0] = sc.nextInt();
            b[1] = sc.nextInt();

            double a_p = distance(a, p);
            double b_p = distance(b, p);
            double a_o = distance(a, o);
            double b_o = distance(b, o);
            double a_b = distance(a, b);

            if (a_p < b_p && a_o < b_o) {
                System.out.println(Math.max(a_o, a_p));
            
            } else if (a_p > b_p && a_o > b_o) {
                System.out.println(Math.max(b_o, b_p));
            
            } else {
                // I think this is wrong.
                System.out.println(Math.max(Math.max(a_b, Math.max(a_o, b_o)), Math.max(a_p, b_p)));
            }
        }
    }

    public static double distance(int point1[], int point2[]) {
        return (Math.sqrt(Math.pow((point2[0] - point1[0]), 2) + Math.pow((point2[1] - point1[1]), 2)));
    }
}