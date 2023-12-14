package iip;
import java.util.*;

public class E004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            String resultS = "";

            if (a == 0 && b == 0) {
                resultS = " Not a Number";
            
            } else if (a >= 0 && b == 0) {
                resultS = " Infinite";
            
            } else if (a < 0 && b == 0) {
                resultS = "-Infinite";
            }

            if (resultS != "") {
                System.out.printf("%16.7f / %16.7f = %s\n", a, b, resultS);
            } else {
                System.out.printf("%16.7f / %16.7f = %16.7f\n", a, b, a / b);
            }
        }
    }
}