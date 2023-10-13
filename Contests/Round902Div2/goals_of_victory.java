package Contests.Round902Div2;

import java.util.Scanner;

public class goals_of_victory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int teams = sc.nextInt();
            int efficiencySum = 0;

            for (int j = 0; j < teams - 1; j++) {
                efficiencySum += sc.nextInt();
            }
            
            System.out.println(-efficiencySum);
        }
    }
}
