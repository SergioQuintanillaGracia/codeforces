import java.util.*;

public class p033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            long num = sc.nextLong();

            System.out.println(reverseNum(num));
        }

        sc.close();
    }


    public static long reverseNum(long num) {
        long res = 0;
        int length = getNumLength(num);
        
        for (int i = 0; i < length; i++) {
            res += (num % 10) * (long) Math.pow(10, length - i - 1);
            num /= 10;
        }

        return res;
    }


    public static int getNumLength(long num) {
        // Returns the amount of digits the number has.
        if (num / 10 != 0) return 1 + getNumLength(num / 10);
        else return 1;
    }
}
