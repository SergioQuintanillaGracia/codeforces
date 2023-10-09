package Contests.Round156Div2;

import java.util.Scanner;

public class sum_of_three_1882A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        int solutions[] = new int[3];

        for (int i = 0; i < cases; i++) {
            int num = sc.nextInt();

            if (num >= 7) {
                solutions[0] = 1;
                solutions[1] = 2;
                solutions[2] = num - 3;
                
                if (solutions[2] % 3 == 0) {
                    solutions[1] += 2;
                    solutions[2] -= 2;
                }

                if (solutions[0] != solutions[1] && solutions[0] != solutions[2] && solutions[1] != solutions[2]) {
                    System.out.println("YES\n%d %d %d".formatted(solutions[0], solutions[1], solutions[2]));
                
                } else {
                    System.out.println("NO");
                }
            
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}