import java.util.*;

public class p036 {
    private static int primeCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String line = sc.nextLine().trim();
        
            if (!line.equals("")) {
                String lineStrArr[] = line.split(" +");

                for (String numStr : lineStrArr) {
                    int num = Integer.parseInt(numStr);

                    if (isPrime(num)) primeCount++;
                }
            }
        }

        printMsg(primeCount);

        sc.close();
    }


    public static boolean isPrime(int num) {
        if (num == 0) return false;
        if (num == 1) return false;
        if (num == 2) return true;

        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }


    public static void printMsg(int primeCount) {
        if (primeCount == 0) {
            System.out.println("No prime numbers were found!");
        
        } else if (primeCount == 1) {
            System.out.println("Only one prime number was found!");
        
        } else {
            System.out.println(String.format("%d prime numbers were found!", primeCount));
        }
    }
}
