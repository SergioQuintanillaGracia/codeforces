import java.util.*;

public class p035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            long num = sc.nextLong();

            if (sumOfDigits(num) == 9) System.out.println(num);
        }

        sc.close();
    }


    public static int sumOfDigits(long num) {
        if (num < 10) return (int) num;

        int digitSum = 0;
        int numLength = getNumLength(num);

        for (int i = 0; i <= numLength; i++) {
            digitSum += num % 10;
            num /= 10;
        }

        return sumOfDigits(digitSum);
    }


    public static int getNumLength(long num) {
        // Returns the amount of digits the number has.
        if (num / 10 != 0) return 1 + getNumLength(num / 10);
        else return 1;
    }
}
