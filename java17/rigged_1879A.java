import java.util.Scanner;

public class rigged_1879A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = 0;
        int testCases = sc.nextInt();
        sc.nextLine();
        int polyStrength = 0;
        int polyEndurance = 0;
        int strength;
        int endurance;

        for (int i = 0; i < testCases; i++) {
            int athleteCount = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < athleteCount; j++) {
                if (j == 0) {  //The first test case, which is always Polycarp, the one who should win.
                    polyStrength = sc.nextInt();
                    polyEndurance = sc.nextInt();
                    sc.nextLine();
                    w = polyStrength;
                
                } else {
                    strength = sc.nextInt();
                    endurance = sc.nextInt();
                    sc.nextLine();

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
