import java.util.*;

public class p038 {
    private static double a, b, c;
    private static int jediCount = 0;
    private static int sithCount = 0;
    private static int tranceCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String lineArr[] = sc.nextLine().trim().split(" +");
        a = Double.parseDouble(lineArr[0]);
        b = Double.parseDouble(lineArr[1]);
        c = Double.parseDouble(lineArr[2]);

        while (sc.hasNext()) {
            String inputArr[] = sc.nextLine().trim().split(" +");
            double x = Double.parseDouble(inputArr[0]);
            double y = Double.parseDouble(inputArr[1]);

            double dist = a * x + b * y + c;

            if (dist > 1) {
                jediCount++;
            
            } else if (dist < -1) {
                sithCount++;
            
            } else tranceCount++;
        }

        printCounters();

        sc.close();
    }


    public static void printCounters() {
        System.out.printf("%d May the Force be with you!\n", jediCount);
        System.out.printf("%d Fear is the path to the dark side. Fear leads to anger. Anger leads "
            + "to hate. Hate leads to suffering. Suffering leads to the dark side.\n", tranceCount);
        System.out.printf("%d Good! Your hate has made you powerful. Now, fulfill your destiny "
            + "and take your father's place at my side!\n", sithCount);
    }
}
