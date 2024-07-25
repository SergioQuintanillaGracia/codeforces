import java.util.Scanner;
import java.util.HashMap;

public class games_268A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amount = sc.nextInt();
        int guestUniformTimes = 0;
        // These hashmaps will store the amount of times a number / color
        // is repeated.
        HashMap<Integer, Integer> team1Map = new HashMap<>();
        HashMap<Integer, Integer> team2Map = new HashMap<>();

        for (int i = 0; i < amount; i++) {
            // Add the integers to the hashmaps, or increment their corresponding
            // value by 1 if they already are there.
            int val1 = sc.nextInt();
            if (!team1Map.containsKey(val1)) team1Map.put(val1, 1);
            else team1Map.put(val1, team1Map.get(val1) + 1);

            int val2 = sc.nextInt();
            if (!team2Map.containsKey(val2)) team2Map.put(val2, 1);
            else team2Map.put(val2, team2Map.get(val2) + 1);
        }

        for (int i : team1Map.keySet()) {
            guestUniformTimes += team1Map.get(i) * team2Map.getOrDefault(i, 0);
        }

        System.out.println(guestUniformTimes);
    }
}
