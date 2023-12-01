package iip;
import java.util.*;

public class E003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();

            System.out.printf("%10.3f + %10.3f = %10.3f\n", a, b, a + b);
        }
    }
}