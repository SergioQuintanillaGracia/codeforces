import java.util.Scanner;

public class rigged_1879A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long w = 0;
        int testCases = sc.nextInt();
        long polyStrength = 0;
        int polyEndurance = 0;
        int strength;
        int endurance;

        for (int i = 0; i < testCases; i++) {
            int athleteCount = sc.nextInt();

            for (int j = 0; j < athleteCount; j++) {
                if (j == 0) {  //The first test case, which is always Polycarp, the one who should win.
                    polyStrength = sc.nextInt();
                    polyEndurance = sc.nextInt();
                    w = polyStrength;
                
                } else {
                    strength = sc.nextInt();
                    endurance = sc.nextInt();

                    if (strength >= polyStrength) {  // Here we are comparing the strength.
                        if (endurance >= polyEndurance) {  // Here we are comparing the endurance.
                            w = -1;
                            break;
                        }
                    }
                }
            }
            
            System.out.println(w);
        }
        
        sc.close();
    }
}
