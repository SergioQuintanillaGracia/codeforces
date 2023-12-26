import java.util.*;

public class p031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String lineArr[] = sc.nextLine().trim().split(" +");

            int a = Integer.parseInt(lineArr[0]);
            int b = Integer.parseInt(lineArr[1]);
            int c = Integer.parseInt(lineArr[2]);

            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        // There are infinite solutions.
                        System.out.println("infinite solutions");
                    
                    } else {
                        // There is no solution
                        System.out.println("undetermined");
                    }
                    
                } else {
                    // It is a first grade equation
                    System.out.println(String.format("%d %d %d %.4f first degree equation", a, b, c, -c / ((double) b)));
                }

            } else {
                // It's a second grade equation.
                System.out.println(getQuadraticSolStr(a, b, c));
            }
        }
    }


    public static String getQuadraticSolStr(int a, int b, int c) {
        double discrim = b * b - 4 * a * c;

        if (discrim == 0) {
            // There will only be one solution, and it won't be imaginary.
            return String.format("%.4f double solution", -b / (2.0 * a));
        
        } else if (discrim > 0) {
            // There will be 2 non-imaginary solutions.
            double sol1 = (-b + Math.sqrt(discrim)) / (2.0 * a);
            double sol2 = (-b - Math.sqrt(discrim)) / (2.0 * a);

            return String.format("%.4f and %.4f", sol1, sol2);
        
        } else {
            // There will be 2 imaginary solutions.
            double realPart = -b / (2.0 * a);
            double imaginaryPart = Math.sqrt(-discrim) / (2.0 * a);

            return String.format("%.4f + %.4fi and %.4f - %.4fi",
                realPart, imaginaryPart, realPart, imaginaryPart);
        }
    }
}
