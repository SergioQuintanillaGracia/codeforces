package Contests.Round902Div2;

import java.util.Scanner;

public class helmets_in_night_light {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int residents = sc.nextInt();
            int directPrice = sc.nextInt();
            int cost = 0;
            int[] residentShare = new int[residents];  // Amount of residents each resident can share the message.
            int[] residentCost = new int[residents];  // Cost of sharing the message for each resident.

            // We fill both arrays with the input data.
            for (int j = 0; j < residents; j++) {
                residentShare[j] = sc.nextInt();
            }

            for (int j = 0; j < residents; j++) {
                residentCost[j] = sc.nextInt();
            }

            // Pack Chanek should pass the message at least one time:
            cost += directPrice;
            residents--;

            // We continue passing the message until there are no residents left to pass it to.
            while (residents > 0) {
                cost += getSmallestCost(directPrice, residentShare, residentCost);
                residents--;
            }

            System.out.println(cost);
        }

        sc.close();
    }

    private static int getSmallestCost(int directPrice, int[] residentShare, int[] residentCost) {
        int smallest = directPrice;  // We initialize the variable with the cost of Pack Chanek to share the msg.
        int smallestIndex = -1;

        // If some resident can share it at a lower cost, we set its cost to smallest.
        for (int i = 0; i < residentShare.length; i++) {
            if (residentCost[i] < smallest && residentShare[i] > 0) {
                smallest = residentCost[i];
                smallestIndex = i;
            }
        }

        if (smallestIndex >= 0) {
            residentShare[smallestIndex]--;
        }

        return smallest;
    }
}
