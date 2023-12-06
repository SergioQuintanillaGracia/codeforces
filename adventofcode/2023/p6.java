import java.util.*;

public class p6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long res = 1;

        // Store the input in string arrays.
        String timesStr[] = sc.nextLine().split(": +")[1].split(" +");
        String distancesStr[] = sc.nextLine().split(": +")[1].split(" +");
        long times[] = new long[timesStr.length];
        long distances[] = new long[distancesStr.length];

        // Copy the input to int arrays.
        for (int i = 0; i < timesStr.length; i++) {
            times[i] = Long.parseLong(timesStr[i]);
            distances[i] = Long.parseLong(distancesStr[i]);
        }

        for (int i = 0; i < times.length; i++) {
            int possibleWays = 0;

            // Check all the possible combinations of time spent holding the button.
            for (int j = 1; j < times[i]; j++) {
                if (j * (times[i] - j) > distances[i]) {
                    // The current combination will lead to a better time than the record.
                    possibleWays++;
                }
            }

            res *= possibleWays;
        }

        System.out.println(res);
    }
}